/**
 * 
 */
package com.architgupta.product.controller.item;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.architgupta.product.model.item.Item;
import com.architgupta.product.repository.item.ItemRepository;
import com.architgupta.product.service.item.ItemService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author architgupta
 *
 */
@RestController
@RequestMapping(value = "/api/items")
@CrossOrigin
public class ItemController {
	private ItemRepository itemRepository;
	private ItemService itemService;

	@Autowired
	public ItemController(ItemRepository itemRepository, ItemService itemService){
		this.itemRepository = itemRepository;
		this.itemService = itemService;
	}

	@PreAuthorize(value = "hasAnyAuthority('USER', 'ADMIN')")
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Item> getAll(){
		return itemRepository.findAll();
	}

	@PreAuthorize(value = "hasAnyAuthority('USER', 'ADMIN')")
	@GetMapping(value = "/all/byAccesses")
	public List<Item> getAllByNoOfAccesses(){
		return itemRepository.findAllByOrderByNoOfTimesAccessedDesc();
	}
	
	@PreAuthorize(value = "hasAnyAuthority('USER', 'ADMIN')")
	@GetMapping(value = "/all/byItemPriceAsc")
	public List<Item> getAllByItemPriceAsc(){
		return itemRepository.findAllByOrderByItemPriceAsc();
	}
	
	@PreAuthorize(value = "hasAnyAuthority('USER', 'ADMIN')")
	@GetMapping(value = "/all/byItemPriceDesc")
	public List<Item> getAllByItemPriceDesc(){
		return itemRepository.findAllByOrderByItemPriceDesc();
	}

	@PreAuthorize(value = "hasAnyAuthority('USER', 'ADMIN')")
	@GetMapping(value = "/all/byCategory/{theCategory}")
	public List<Item> getAllByCategory(@PathVariable String theCategory){
		return itemRepository.findAllByItemCategory(itemService.findCategory(theCategory));
	}
	
	@PreAuthorize(value = "hasAnyAuthority('USER', 'ADMIN')")
	@GetMapping(value = "/all/byBrand/{brand}")
	public List<Item> getAllByBrand(@PathVariable String brand){
		return itemRepository.findAllByBrandContainingIgnoreCase(brand);
	}

	@PreAuthorize(value = "hasAnyAuthority('USER', 'ADMIN')")
	@GetMapping(value = "/all/byName/{term}")
	public List<Item> getAllByName(@PathVariable String term){
		return itemRepository.findAllByItemNameContainingIgnoreCase(term);
	}

	@PreAuthorize(value = "hasAnyAuthority('USER', 'ADMIN')")
	@GetMapping(value = "/all/byId/{theId}")
	public List<Item> getAllById(@PathVariable long theId){
		return itemRepository.findAllByItemId(theId);
	}

	@PreAuthorize(value = "hasAnyAuthority('ADMIN')")
	@PostMapping(value = "/create")
	public Item postItem(@RequestBody Item item){
		itemService.newItem(item);
		return item;
	}

	@SuppressWarnings("rawtypes")
	@PreAuthorize(value = "hasAnyAuthority('ADMIN')")
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity deleteItem(@PathVariable long id){
		if (itemRepository.findById(id).isPresent()) {
			itemRepository.deleteById(id);
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	@PreAuthorize(value = "hasAnyAuthority('USER', 'ADMIN')")
	@GetMapping(value = "/item/{id}")
	public ResponseEntity<Item> getItem(@PathVariable long id){
		if (itemRepository.findById(id).isPresent())
			return new ResponseEntity<>(itemService.getItem(id), HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PreAuthorize(value = "hasAnyAuthority('ADMIN')")
	@PostMapping(value = "/update/{id}")
	public Item updateItem(@RequestBody Item item, @PathVariable long id){
		return itemService.updateItem(item, id);
	}
}
