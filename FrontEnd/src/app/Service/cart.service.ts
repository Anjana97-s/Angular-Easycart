import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { ProductService } from './product.service';
import { SharingService } from './sharing.service';
const baseUrl = 'http://localhost:8080/products/view';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  getToken ()
  {
  return localStorage.getItem('token1')
 }
 public token = localStorage.getItem('token1')

 public tokenStr = 'Contacts' + " " +this. token;
 public headers = new HttpHeaders().set("Content-Type", "application/json").set("Authorization", this.tokenStr)
  constructor(private router:Router,private httpClient: HttpClient, private shr:SharingService) { }

loginuser(data:any):Observable<any>{
  return this.httpClient.post('http://localhost:8080/cust_login',data);
}
Addcart(id:any,quantity:any):Observable<any>
{

return this.httpClient.post('http://localhost:8080/cart/add/'+id,quantity,{ headers: this.headers })
}
getcart():Observable<any>
{
  return this.httpClient.get('http://localhost:8080/cart/',{ headers: this.headers });

}
cartpro(id:any):Observable<any>
{
  return this.httpClient.get('http://localhost:8080/cart/get/'+id,{headers: this.headers })
}
updatecart(id:any,data:any):Observable<any>{

return this.httpClient.put('http://localhost:8080/cart/update/'+id,data,{ headers: this.headers })
}
Deletecart(id:any):Observable<any>{

  return this.httpClient.delete('http://localhost:8080/cart/delete/'+id,{ headers: this.headers })
}
}
