/**
 * 
 */
package com.architgupta.product.model.item;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author architgupta
 *
 */

@Entity
@Table(name = "items")
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private long itemId;

    @NotBlank
    @Column(columnDefinition = "VARCHAR(255)")
    private String itemName;
    
    private Integer itemPrice;

	@Enumerated
    @Column(columnDefinition = "smallint")
    private ItemCategory itemCategory;
    
    @Column(columnDefinition = "VARCHAR(255)")
    private String itemImage;
    
    private Integer[] itemPincodes;

	@NotBlank
    @Column(columnDefinition = "LONGTEXT")
    private String descriptions;

    @Column(columnDefinition = "LONGTEXT")
    private String brand;

    private Date lastAccessed;

    private long noOfTimesAccessed;

    public Item(){}

    public Item(String itemName, ItemCategory itemCategory, String descriptions, String brand, String itemImage, Integer itemPrice, Integer[] itemPincodes){
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.descriptions = descriptions;
        this.brand = brand;
        this.itemImage = itemImage;
        this.itemPrice = itemPrice;
        this.itemPincodes = itemPincodes;
    }
    
    public Integer[] getItemPincodes() {
		return itemPincodes;
	}

	public void setItemPincodes(Integer[] itemPincodes) {
		this.itemPincodes = itemPincodes;
	}

	public Integer getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Integer itemPrice) {
		this.itemPrice = itemPrice;
	}

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public ItemCategory getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getLastAccessed() {
        return lastAccessed;
    }
    
    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public void setLastAccessed(Date lastAccessed) {
        this.lastAccessed = lastAccessed;
    }

    public long getNoOfTimesAccessed() {
        return noOfTimesAccessed;
    }

    public void setNoOfTimesAccessed(long noOfTimesAccessed) {
        this.noOfTimesAccessed = noOfTimesAccessed;
    }
}
