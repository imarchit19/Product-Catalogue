import { Component, OnInit, Input } from '@angular/core';
import {Item} from '../model/item';
import {ApiService} from '../services/api.service';
import {ActivatedRoute} from '@angular/router';
import {ItemCategory} from '../model/item-category';
import {OptionCategory} from '../model/option-category';
import {Location} from '@angular/common';

@Component({
  selector: 'app-update-item',
  templateUrl: './update-item.component.html',
  styleUrls: ['./update-item.component.css']
})
export class UpdateItemComponent implements OnInit {

  @Input() item!: Item;

  opts: OptionCategory[] = [
    { id: ItemCategory.LAPTOPS, name: 'Laptops' },
    { id: ItemCategory.MOBILES, name: 'Mobiles' },
    { id: ItemCategory.TABLETS, name: 'Tablets' }
  ];

  filterCategory(theCategory: ItemCategory) {
    this.item.itemCategory = theCategory;
  }

  constructor(
    private apiService: ApiService,
    private route: ActivatedRoute,
    private location: Location
  ) { }

  ngOnInit() {
    this.getItem();
  }

  getItem(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.apiService.getItem(id)
      .subscribe(item => this.item = item);
  }

  sendItem(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.apiService.updateItem(this.item, id).subscribe(
      res => {
        this.location.back();
      },
      err => {
        alert('An error has occurred while updating item');
      }
    );
  }

}
