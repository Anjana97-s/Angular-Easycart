import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
const baseUrl = 'http://localhost:8080/products/view';
const Url = 'http://localhost:8080/products/products';
@Injectable({
  providedIn: 'root'
})
export class ProductService {
  getToken ()
   {
   return localStorage.getItem('token1')
  }
  public token = localStorage.getItem('token1')

  public tokenStr = 'Contacts' + " " +this. token;
  public headers = new HttpHeaders().set("Content-Type", "application/json").set("Authorization", this.tokenStr)
  constructor( private httpclient: HttpClient,private router: Router) { 
    this.httpclient=httpclient;
    
  }
  loginuser(data:any):Observable<any>{
    return this.httpclient.post('http://localhost:8080/cust_login',data);
  }
  findProduct(productId:any):Observable<any>{
    return this.httpclient.get(`${baseUrl}?productId=${productId}`,{ headers: this.headers });

  }
 wishlist(data:any):Observable<any>{
return this.httpclient.post('http://localhost:8080/wishlist/add',data,{headers:this.headers});
 }
 getproduct():Observable<any>{
  return this.httpclient.get('http://localhost:8080/products/',{headers:this.headers});

 }
 /*findByDate(fromdate:Date,todate:Date): Observable<any> {
  console.log(fromdate);
  console.log(todate);
return this.httpclient.get(`${Url}?fromdate=${fromdate}&todate=${todate}`,{headers:this.headers});

}*/
}