import { Component, OnInit } from '@angular/core';
import {ApiService} from '../services/api.service';
import {Item} from '../model/item';
import {ItemCategory} from '../model/item-category';
import {OptionCategory} from '../model/option-category';

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css']
})
export class ItemsComponent implements OnInit {

  items: Item[] = [];

  opts: OptionCategory[] = [
    { id: ItemCategory.LAPTOPS, name: 'Laptops' },
    { id: ItemCategory.MOBILES, name: 'Mobiles' },
    { id: ItemCategory.TABLETS, name: 'Tablets' }
  ];

  constructor(private apiService: ApiService) { }

  ngOnInit() {
    this.getAllItems();
  }

  getAllItems() {
    this.apiService.getItems().subscribe(
      res => {
        this.items = res;
      },
      err => {
        alert('Error occurred while getting items from server');
      }
    );
  }

  getAllByCategory(itemCategory: ItemCategory) {
    this.apiService.getItemsByCategory(itemCategory).subscribe(
      res => {
        this.items = res;
      },
      err => {
        alert('Error occurred while getting items from server');
      }
    );
  }
}
