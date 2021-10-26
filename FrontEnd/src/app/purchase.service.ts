import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PurchaseService {
  getToken ()
  {
  return localStorage.getItem('token1')
 }
 public token = localStorage.getItem('token1')

 public tokenStr = 'Contacts' + " " +this. token;
 public headers = new HttpHeaders().set("Content-Type", "application/json").set("Authorization", this.tokenStr)
  constructor(private httpclient: HttpClient,private router: Router) {
    this.httpclient=httpclient;
   }
   loginuser(data:any):Observable<any>{
    return this.httpclient.post('http://localhost:8080/cust_login',data);
  }
  getpurchase():Observable<any>
  {
    return this.httpclient.get('http://localhost:8080/purchase/',{ headers: this.headers });
  }
}
