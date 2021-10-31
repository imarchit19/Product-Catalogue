import { Component, OnInit } from '@angular/core';
import {ApiService} from '../services/api.service';
import {Observable, Subject} from 'rxjs';
import {Item} from '../model/item';
import {debounceTime, distinctUntilChanged, switchMap} from 'rxjs/operators';

@Component({
  selector: 'app-search-item',
  templateUrl: './search-item.component.html',
  styleUrls: ['./search-item.component.css']
})
export class SearchItemComponent implements OnInit {

  items$!: Observable<Item[]>;
  private searchTerms = new Subject<string>();

  constructor(private apiService: ApiService) { }

  search(term: string): void {
    this.searchTerms.next(term);
  }

  ngOnInit(): void {
    this.items$ = this.searchTerms.pipe(
      debounceTime(300),
      distinctUntilChanged(),
      switchMap((term: string) => this.apiService.searchItems(term)),
    );
  }

}
