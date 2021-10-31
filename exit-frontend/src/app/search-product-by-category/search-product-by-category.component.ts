import { Component, OnInit } from '@angular/core';
import {ApiService} from '../services/api.service';
import {Observable, Subject} from 'rxjs';
import {Item} from '../model/item';
import {debounceTime, distinctUntilChanged, switchMap} from 'rxjs/operators';

@Component({
  selector: 'app-search-product-by-category',
  templateUrl: './search-product-by-category.component.html',
  styleUrls: ['./search-product-by-category.component.css']
})
export class SearchProductByCategoryComponent implements OnInit {

  items$!: Observable<Item[]>;
  private searchTermsByBrand = new Subject<string>();

  constructor(private apiService: ApiService) { }

  search(brand: string): void {
    this.searchTermsByBrand.next(brand);
  }

  ngOnInit(): void {
    this.items$ = this.searchTermsByBrand.pipe(
      debounceTime(300),
      distinctUntilChanged(),
      switchMap((brand: string) => this.apiService.searchItemsByBrand(brand)),
    );
  }

}
