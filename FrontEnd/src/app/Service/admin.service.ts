import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
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
  /* loginadmin(data:any):Observable<any>
   {
     const headers=new HttpHeaders().set("Content-Type", "application/json")
     return this.httpclient.post('http://localhost:8080/admin_login',data,{headers});
 
   }
   loginuser(data:any):Observable<any>{
    return this.httpclient.post('http://localhost:8080/cust_login',data);
  }*/
  register(formData:FormData):Observable<any>
  {
   
    return this.httpclient.post('http://localhost:8080/admin',formData);

  }
  currentAdmin():Observable<any>
  {
return this.httpclient.get('http://localhost:8080/admin',{headers:this.headers})
  }
  updateadmin(id:any,data:any):Observable<any>{

    return this.httpclient.put('http://localhost:8080/admin/'+id,data,{ headers: this.headers })
    }
    updateimage(id:any,formData:FormData):Observable<any>{
      return this.httpclient.put('http://localhost:8080/admin/image/'+id,formData,{ headers: this.headers })

    }
    vieworder():Observable<any>
    {
      return this.httpclient.get('http://localhost:8080/order/all',{headers:this.headers})

    }
}
