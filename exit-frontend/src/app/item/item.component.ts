import { Component, OnInit } from '@angular/core';
import {ApiService} from '../services/api.service';
import {ActivatedRoute} from '@angular/router';
import {Item} from '../model/item';
import {Location} from '@angular/common';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {

  item!: Item;
  descriptions: string[] = [];
  brand: string[] = [];

  constructor(
    private apiService: ApiService,
    private route: ActivatedRoute,
    private location: Location
  ) {
   }

  ngOnInit() {
    this.route.params.subscribe(params => {
      const id = +params['id'];
      this.getItem();
    });
  }

  getItem(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.apiService.getItem(id).subscribe(item => {
      this.item = item;
      this.descriptions = item.descriptions.split('\n');
      this.brand = item.brand.split('\n');
    });
  }

  deleteThisItem(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    if (confirm('Are you sure you want to delete this item?')) {
      this.apiService.deleteItem(id).subscribe(
        res => {
          alert('Item deleted successfully');
          this.location.back();
        },
        err => alert('Error occurred while deleting item')
      );
    }
  }

  checkPincode(){
    var temp = (<HTMLInputElement>document.getElementById("itemNamePincodeField")).value;
    var inputValue = Number(temp);
    
    var check = false;
    for (let index = 0; index < this.item.itemPincodes.length; index++) {
      if(inputValue === this.item.itemPincodes[index]) {
        check = true;
        break;
      }     
    }
    if(temp == ''){
      (document.getElementById('delivery') as HTMLImageElement).textContent = "Don't Leave Field Blank";
      return;
    }
    if(check){
      (document.getElementById('delivery') as HTMLImageElement).textContent = "Delivery Possible";
    } else{
      (document.getElementById('delivery') as HTMLImageElement).textContent = "No Delivery Possible";
    }
  }
}
