/**
 * 
 */
package com.architgupta.product.service.item;

import com.architgupta.product.model.item.Item;
import com.architgupta.product.model.item.ItemCategory;
import com.architgupta.product.repository.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * @author architgupta
 *
 */

@Service
public class ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemCategory findCategory(String category) {
        ItemCategory itemCategory = ItemCategory.LAPTOPS;
        if (category.equals("Mobiles"))
            itemCategory = ItemCategory.MOBILES;
        if (category.equals("Tablets"))
        	itemCategory = ItemCategory.TABLETS;
        if (category.equals("1"))
        	itemCategory = ItemCategory.MOBILES;
        if (category.equals("2"))
        	itemCategory = ItemCategory.TABLETS;

        return itemCategory;
    }

    public void newItem(Item item) {
        item.setLastAccessed(new Date());
        itemRepository.save(item);
    }

    public Item getItem(long id) {
        Item itemToSave = itemRepository.findById(id).orElse(null);
        Item itemToReturn = new Item();

        if (itemToSave != null) {
            itemToReturn.setItemId(itemToSave.getItemId());
            copyItem(itemToReturn, itemToSave);
            itemToSave.setLastAccessed(new Date());
            itemToSave.setNoOfTimesAccessed(itemToReturn.getNoOfTimesAccessed() + 1);

            itemRepository.save(itemToSave);

            return itemToReturn;
        }
        return null;
    }

    public Item updateItem(Item item, long id) {
        Optional<Item> itemToCheck = itemRepository.findById(id);

        if (itemToCheck.isPresent()) {
            Item itemToSave = itemToCheck.get();
            copyItem(itemToSave, item);

            itemRepository.save(itemToSave);
            return itemToSave;
        } else {
            return null;
        }
    }

    private void copyItem(Item item1, Item item2) {
        item1.setItemName(item2.getItemName());
        item1.setItemCategory(item2.getItemCategory());
        item1.setItemImage(item2.getItemImage());
        item1.setItemPrice(item2.getItemPrice());
        item1.setItemPincodes(item2.getItemPincodes());
        item1.setDescriptions(item2.getDescriptions());
        item1.setBrand(item2.getBrand());
        item1.setLastAccessed(item2.getLastAccessed());
        item1.setNoOfTimesAccessed(item2.getNoOfTimesAccessed());
    }
}
