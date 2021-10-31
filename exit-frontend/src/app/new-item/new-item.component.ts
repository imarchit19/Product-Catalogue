import { Component, OnInit } from '@angular/core';
import { Item } from '../model/item';
import { ItemCategory } from '../model/item-category';
import { ApiService } from '../services/api.service';
import { Location } from '@angular/common';
import { OptionCategory } from '../model/option-category';

@Component({
  selector: 'app-new-item',
  templateUrl: './new-item.component.html',
  styleUrls: ['./new-item.component.css']
})
export class NewItemComponent implements OnInit {

  model: Item = {
    itemId: 0,
    itemName: '',
    itemImage: '',
    itemPrice: 0,
    itemPincodes: [],
    itemCategory: ItemCategory.LAPTOPS,
    descriptions: '',
    brand: '',
    lastAccessed: '',
    noOfTimesAccessed: 0
  };

  opts: OptionCategory[] = [
    { id: ItemCategory.LAPTOPS, name: 'Laptops' },
    { id: ItemCategory.MOBILES, name: 'Mobiles' },
    { id: ItemCategory.TABLETS, name: 'Tablets' }
  ];

  filterCategory(theCategory: ItemCategory) {
    this.model.itemCategory = theCategory;
  }

  constructor(
    private apiService: ApiService,
    private location: Location) { }

  ngOnInit() {
  }

  sendItem(): void {
    this.apiService.addItem(this.model).subscribe(
      res => {
        this.location.back();
      },
      err => {
        alert('An error has occurred while sending item details');
      }
    );
  }


}
