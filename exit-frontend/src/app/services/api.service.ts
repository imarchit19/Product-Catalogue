import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Item } from '../model/item';
import { ItemCategory } from '../model/item-category';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})

export class ApiService {

  private BASE_URL = 'http://localhost:8081/api/items';

  constructor(private http: HttpClient) { }

  addItem(item: Item): Observable<any> {
    const url = `${this.BASE_URL}/create`;
    return this.http.post(url, item, httpOptions);
  }

  getItems(): Observable<Item[]> {
    const url = `${this.BASE_URL}/all`;
    return this.http.get<Item[]>(url, httpOptions);
  }

  getItemsByNoOfAccesses(): Observable<Item[]> {
    const url = `${this.BASE_URL}/all/byAccesses`;
    return this.http.get<Item[]>(url, httpOptions);
  }

  getItemsByItemPriceAsc(): Observable<Item[]> {
    const url = `${this.BASE_URL}/all/byItemPriceAsc`;
    return this.http.get<Item[]>(url, httpOptions);
  }

  getItemsByItemPriceDesc(): Observable<Item[]> {
    const url = `${this.BASE_URL}/all/byItemPriceDesc`;
    return this.http.get<Item[]>(url, httpOptions);
  }

  getItemsByCategory(itemCategory: ItemCategory): Observable<Item[]> {
    const url = `${this.BASE_URL}/all/byCategory/${itemCategory}`;
    return this.http.get<Item[]>(url, httpOptions);
  }

  getItem(id: number): Observable<Item> {
    const url = `${this.BASE_URL}/item/${id}`;
    return this.http.get<Item>(url, httpOptions);
  }

  updateItem(item: Item, id: number): Observable<any> {
    const url = `${this.BASE_URL}/update/${id}`;
    return this.http.post(url, item, httpOptions);
  }

  deleteItem(id: number): Observable<any> {
    const url = `${this.BASE_URL}/delete/${id}`;
    return this.http.delete(url, httpOptions);
  }

  searchItems(term: string): Observable<Item[]> {
    const url = `${this.BASE_URL}/all/byName/${term}`;
    if (!term.trim()) {
      return of([]);
    }
    return this.http.get<Item[]>(url, httpOptions);
  }

  searchItemsByCategory(theCategory: string): Observable<Item[]> {
    const url = `${this.BASE_URL}/all/byCategory/${theCategory}`;
    if (!theCategory.trim()) {
      return of([]);
    }
    return this.http.get<Item[]>(url, httpOptions);
  }

  searchItemsById(theId: String): Observable<Item[]> {
    const url = `${this.BASE_URL}/all/byId/${theId}`;
    if (!theId.trim()) {
      return of([]);
    }
    return this.http.get<Item[]>(url, httpOptions);
  }

  searchItemsByBrand(brand: String): Observable<Item[]> {
    const url = `${this.BASE_URL}/all/byBrand/${brand}`;
    if (!brand.trim()) {
      return of([]);
    }
    return this.http.get<Item[]>(url, httpOptions);
  }
}
