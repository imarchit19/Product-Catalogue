import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchProductByIdComponent } from './search-product-by-id.component';

describe('SearchProductByIdComponent', () => {
  let component: SearchProductByIdComponent;
  let fixture: ComponentFixture<SearchProductByIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchProductByIdComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchProductByIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
