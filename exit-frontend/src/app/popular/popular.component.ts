import { Component, OnInit } from '@angular/core';
import {ApiService} from '../services/api.service';
import {Item} from '../model/item';

@Component({
  selector: 'app-popular',
  templateUrl: './popular.component.html',
  styleUrls: ['./popular.component.css']
})
export class PopularComponent implements OnInit {

  items: Item[] = [];

  constructor(private apiService: ApiService) { }

  ngOnInit() {
    this.apiService.getItemsByItemPriceAsc().subscribe(
      res => {
        this.items = res;
      },
      err => {
        alert('Error occurred while getting items');
      }
    );
  }

  orderByPriceLH(){
    this.apiService.getItemsByItemPriceAsc().subscribe(
      res => {
        this.items = res;
      },
      err => {
        alert('Error occurred while getting items');
      }
    );
  }

  orderByPriceHL(){
    this.apiService.getItemsByItemPriceDesc().subscribe(
      res => {
        this.items = res;
      },
      err => {
        alert('Error occurred while getting items');
      }
    );
  }

  orderByPopularity(){
    this.apiService.getItemsByNoOfAccesses().subscribe(
      res => {
        this.items = res;
      },
      err => {
        alert('Error occurred while getting items');
      }
    );
  }
}
