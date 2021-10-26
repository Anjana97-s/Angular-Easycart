import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CartComponent } from './Components/Cart/cart/cart.component';
import { WishlistComponent } from './Components/Wishlist/wishlist/wishlist.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { DemoMaterialModule } from './material.module';
import { MatNativeDateModule } from '@angular/material/core';
import { LoginComponent } from './Components/Login/login/login.component';
import { ProductComponent } from './Components/Product/product/product.component';
import { CartlistComponent } from './Components/cartlist/cartlist.component';
import { UpdatecartComponent } from './Components/Cart/cart/updatecart/updatecart.component';
import { ViewpurchaseComponent } from './Components/Purchase/viewpurchase/viewpurchase.component';
import { ViewsellerComponent } from './Components/Seller/viewseller/viewseller.component';
import { ViewproductComponent } from './Components/Product/viewproduct/viewproduct.component';
import { AdminprofileComponent } from './Components/adminprofile/adminprofile.component';
import { SellerprofileComponent } from './Components/sellerprofile/sellerprofile.component';
import { UpdatesellerComponent } from './Components/updateseller/updateseller.component';
import { UpdateadminComponent } from './Components/updateadmin/updateadmin.component';
import { AddadminComponent } from './Components/addadmin/addadmin.component';
import { LoginadminComponent } from './Components/loginadmin/loginadmin.component';
import { SellerloginComponent } from './Components/sellerlogin/sellerlogin.component';
import { SellerRegisterComponent } from './Components/seller-register/seller-register.component';
import { OrderComponent } from './order/order.component';
import { VieworderComponent } from './order/vieworder/vieworder.component';

 
@NgModule({
  declarations: [
    AppComponent,
    CartComponent,
    WishlistComponent,
    LoginComponent,
    ProductComponent,
    CartlistComponent,
    UpdatecartComponent,
    ViewpurchaseComponent,
    ViewsellerComponent,
    ViewproductComponent,
    AdminprofileComponent,
    SellerprofileComponent,
    UpdatesellerComponent,
    UpdateadminComponent,
    AddadminComponent,
    LoginadminComponent,
    SellerloginComponent,
    SellerRegisterComponent,
    OrderComponent,
    VieworderComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    DemoMaterialModule,
    MatNativeDateModule,
    ReactiveFormsModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
