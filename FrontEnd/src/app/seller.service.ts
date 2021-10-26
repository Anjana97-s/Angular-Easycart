import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SellerService {
  getToken ()
  {
  return localStorage.getItem('token1')
 }
 public token = localStorage.getItem('token1')

 public tokenStr = 'Contacts' + " " +this. token;
 public headers = new HttpHeaders().set("Authorization", this.tokenStr)
  constructor(private httpclient: HttpClient,private router: Router) {
    this.httpclient=httpclient;
   }
   loginuser(data:any):Observable<any>{
    return this.httpclient.post('http://localhost:8080/cust_login',data);
  }
  register(formData:FormData):Observable<any>
  {
   
    return this.httpclient.post('http://localhost:8080/seller',formData);

  }
  getseller():Observable<any>
  {
    return this.httpclient.get('http://localhost:8080/seller/seller',{ headers: this.headers });
  }
  currentSeller():Observable<any>
  {
return this.httpclient.get('http://localhost:8080/seller',{headers:this.headers})
  }
  updateseller(id:any,data:any):Observable<any>{

    return this.httpclient.put('http://localhost:8080/seller/'+id,data,{ headers: this.headers })
    }

    Deleteseller(id:any):Observable<any>{
      return this.httpclient.delete('http://localhost:8080/seller/'+id,{ headers: this.headers })

    }
    updateimage(id:any,formData:FormData):Observable<any>{
      return this.httpclient.put('http://localhost:8080/seller/image/'+id,formData,{ headers: this.headers })

    }
}
