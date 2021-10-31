import { Component, OnInit } from '@angular/core';
import {ApiService} from '../services/api.service';
import {Observable, Subject} from 'rxjs';
import {Item} from '../model/item';
import {debounceTime, distinctUntilChanged, switchMap} from 'rxjs/operators';

@Component({
  selector: 'app-search-product-by-id',
  templateUrl: './search-product-by-id.component.html',
  styleUrls: ['./search-product-by-id.component.css']
})
export class SearchProductByIdComponent implements OnInit {

  items$!: Observable<Item[]>;
  private searchTermsById = new Subject<String>();

  constructor(private apiService: ApiService) { }

  search(theId: String): void {
    this.searchTermsById.next(theId);
  }

  ngOnInit(): void {
    this.items$ = this.searchTermsById.pipe(
      debounceTime(300),
      distinctUntilChanged(),
      switchMap((theId: String) => this.apiService.searchItemsById(theId)),
    );
  }

}
