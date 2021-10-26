import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {
  getToken ()
  {
  return localStorage.getItem('token1')
 }
 public token = localStorage.getItem('token1')

 public tokenStr = 'Contacts' + " " +this. token;
 public headers = new HttpHeaders().set("Content-Type", "application/json")
  constructor(private httpclient: HttpClient) { }
  loginuser(data:any):Observable<any>{
    return this.httpclient.post('http://localhost:8080/cust_login',data);
  }
  loginadmin(data:any):Observable<any>
  {
    return this.httpclient.post('http://localhost:8080/admin_login',data,{ headers: this.headers });

  }
  loginseller(data:any):Observable<any>
  {
    return this.httpclient.post('http://localhost:8080/seller_login',data,{ headers: this.headers });

  }
}
