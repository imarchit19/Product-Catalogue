import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { NavigationComponent } from './navigation/navigation.component';
import { NewItemComponent } from './new-item/new-item.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { PopularComponent } from './popular/popular.component';
import { ItemComponent } from './item/item.component';
import { ItemsComponent } from './items/items.component';
import { RegisterComponent } from './register/register.component';
import { SearchProductByCategoryComponent } from './search-product-by-category/search-product-by-category.component';
import { SearchProductByIdComponent } from './search-product-by-id/search-product-by-id.component';
import { SearchItemComponent } from './search-item/search-item.component';
import { UpdateItemComponent } from './update-item/update-item.component';

import { httpInterceptorProviders } from './auth/auth-interceptor';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SpinnerComponent } from './spinner/spinner.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    NavigationComponent,
    NewItemComponent,
    NotFoundComponent,
    PopularComponent,
    ItemComponent,
    ItemsComponent,
    RegisterComponent,
    SearchProductByCategoryComponent,
    SearchProductByIdComponent,
    SearchItemComponent,
    UpdateItemComponent,
    SpinnerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
