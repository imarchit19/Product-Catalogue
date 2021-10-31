import {ItemCategory} from './item-category';

export interface Item {
  itemId: number;
  itemName: string;
  itemImage: string;
  itemCategory: ItemCategory;
  descriptions: string;
  itemPrice: number;
  itemPincodes: Array<number>;
  brand: string;
  lastAccessed: string;
  noOfTimesAccessed: number;
}
