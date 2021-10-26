import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { CartService } from '../Service/cart.service';
import { ProductService } from '../Service/product.service';
import { SharingService } from '../Service/sharing.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
list:any;
  constructor(public crtser:CartService,private router:Router,public proser:ProductService,private formBuilder: FormBuilder,
    private shr:SharingService) { }

  ngOnInit(): void {
    this.list=this.shr.getdetails()
    console.log(this.list)
  }

}
