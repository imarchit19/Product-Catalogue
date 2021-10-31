import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NewItemComponent } from './new-item/new-item.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { HomeComponent } from './home/home.component';
import { ItemComponent } from './item/item.component';
import { UpdateItemComponent } from './update-item/update-item.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';


const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'auth/login', component: LoginComponent },
  { path: 'home/signup', component: RegisterComponent },
  { path: 'item/:id', component: ItemComponent },
  { path: 'new_item', component: NewItemComponent },
  { path: 'update_item/:id', component: UpdateItemComponent },
  { path: '**', component: NotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { enableTracing: false, relativeLinkResolution: 'legacy' })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
