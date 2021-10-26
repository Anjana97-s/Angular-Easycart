import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductService } from 'src/app/Service/product.service';
import { SharingService } from 'src/app/Service/sharing.service';

@Component({
  selector: 'app-viewproduct',
  templateUrl: './viewproduct.component.html',
  styleUrls: ['./viewproduct.component.css']
})
export class ViewproductComponent implements OnInit {
  data:any;
  productId:any;
  products:any;
  productlist:any=[];
  fromdate!: Date;

  todate!: Date;
  constructor(public proser:ProductService,private router:Router,
    private shr:SharingService) { }

  ngOnInit(): void {
    this.proser.getproduct().subscribe(
      (res:any)=>{
        this.products=res;
        console.log(res);
      }
    )
  }
 /* searchProduct(): void {
    this.proser.findByDate(this.fromdate,this.todate)
      .subscribe(
        data => {
          this.products = data;
          console.log("entered");

          console.log(data);
        },
        error => {
          console.log(error);
        });
        console.log(this.fromdate);
        console.log(this.todate);
  }*/

}
