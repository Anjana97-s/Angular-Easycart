import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class SharingService {
  

  constructor( ) { }
  message:any;
  setdetails(datavalue:any){
    this.message=datavalue;
  }
  getdetails(){
    return this.message;
  }
}
