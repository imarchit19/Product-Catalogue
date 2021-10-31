import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchProductByCategoryComponent } from './search-product-by-category.component';

describe('SearchProductByCategoryComponent', () => {
  let component: SearchProductByCategoryComponent;
  let fixture: ComponentFixture<SearchProductByCategoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchProductByCategoryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchProductByCategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
