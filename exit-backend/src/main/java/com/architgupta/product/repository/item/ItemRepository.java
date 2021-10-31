/**
 * 
 */
package com.architgupta.product.repository.item;

import com.architgupta.product.model.item.Item;
import com.architgupta.product.model.item.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author architgupta
 *
 */

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByItemCategory(ItemCategory itemCategory);
    List<Item> findAllByItemNameContainingIgnoreCase(String itemName);
    List<Item> findAllByBrandContainingIgnoreCase(String brand);
    List<Item> findAllByItemId(long itemId);
    List<Item> findAllByOrderByNoOfTimesAccessedDesc();
    List<Item> findAllByOrderByItemPriceAsc();
    List<Item> findAllByOrderByItemPriceDesc();
}
