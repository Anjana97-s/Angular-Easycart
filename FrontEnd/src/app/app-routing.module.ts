import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CartlistComponent } from './Components/cartlist/cartlist.component';
import { CartComponent } from './Components/Cart/cart/cart.component';
import { LoginComponent } from './Components/Login/login/login.component';
import { ProductComponent } from './Components/Product/product/product.component';
import { WishlistComponent } from './Components/Wishlist/wishlist/wishlist.component';
import { UpdatecartComponent } from './Components/Cart/cart/updatecart/updatecart.component';
import { ViewsellerComponent } from './Components/Seller/viewseller/viewseller.component';
import { ViewproductComponent } from './Components/Product/viewproduct/viewproduct.component';
import { ViewpurchaseComponent } from './Components/Purchase/viewpurchase/viewpurchase.component';
import { AddadminComponent } from './Components/addadmin/addadmin.component';
import { AdminprofileComponent } from './Components/adminprofile/adminprofile.component';
import { UpdateadminComponent } from './Components/updateadmin/updateadmin.component';
import { SellerprofileComponent } from './Components/sellerprofile/sellerprofile.component';
import { UpdatesellerComponent } from './Components/updateseller/updateseller.component';
import { LoginadminComponent } from './Components/loginadmin/loginadmin.component';
import { SellerRegisterComponent } from './Components/seller-register/seller-register.component';
import { SellerloginComponent } from './Components/sellerlogin/sellerlogin.component';
import { OrderComponent } from './order/order.component';
import { VieworderComponent } from './order/vieworder/vieworder.component';

const routes: Routes = [
  {path:'',component:LoginComponent},
  {path:'product',component:ProductComponent},

{path:'cartlist',component:CartlistComponent},
  {path:'cart',component:CartComponent},
  {path:'wishlist',component:WishlistComponent},
  {path:'updatecart',component:UpdatecartComponent},
  {path:'viewseller',component:ViewsellerComponent},
  {path:'viewproduct',component:ViewproductComponent},
  {path:'viewpurchase',component:ViewpurchaseComponent},
  {path:'addadmin',component:AddadminComponent },
  {path:'adminprofile',component:AdminprofileComponent},
  {path:'updateadmin',component:UpdateadminComponent},
  {path:'sellerprofile',component:SellerprofileComponent},
  {path:'updateseller',component:UpdatesellerComponent},
  {path:'adminlogin',component:LoginadminComponent}, 
  {path:'sellerreg',component:SellerRegisterComponent},
  {path:'sellerlogin',component:SellerloginComponent},
  {path:'updateseller',component:UpdatesellerComponent},
  {path:'sellerprofile',component:SellerprofileComponent},
  {path:'order',component:OrderComponent},
  {path:'vieworder',component:VieworderComponent}


];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
