import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CartService } from 'src/app/Service/cart.service';
import { ProductService } from 'src/app/Service/product.service';
import { SharingService } from 'src/app/Service/sharing.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  Id:any;
  quantity:any;
  data:any;
  productId:any;
  products:any;
  productlist:any=[];
  total = 0;
  cartForm:FormGroup;
  formdata:any;
  submitted=false;

  constructor(public crtser:CartService,private router:Router,public proser:ProductService,private formBuilder: FormBuilder,
    private shr:SharingService) {
      this.cartForm= this.formBuilder.group({
       
        quantity:new FormControl('',[Validators.required])
      });
     }

  ngOnInit(): void {
    this.Id=this.shr.getdetails()
    console.log(this.Id)
    this.proser.findProduct(this.Id).subscribe(
      (res:any)=>{
        this.products=res;
        console.log(res);
      }
    );
  }
  onSubmit(){
    this.submitted=true;
    if(this.cartForm.valid){
      this.data=this.cartForm.value;
      console.log(this.data)
      this.crtser.Addcart(this.Id,this.data).subscribe(
        (res:any)=> {
            console.warn(res)
      }
      )
  }
  
}
}
