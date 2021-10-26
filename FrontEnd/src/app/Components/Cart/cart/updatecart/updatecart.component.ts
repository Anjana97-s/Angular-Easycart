import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CartService } from 'src/app/Service/cart.service';
import { ProductService } from 'src/app/Service/product.service';
import { SharingService } from 'src/app/Service/sharing.service';

@Component({
  selector: 'app-updatecart',
  templateUrl: './updatecart.component.html',
  styleUrls: ['./updatecart.component.css']
})
export class UpdatecartComponent implements OnInit {
  Id:any;
  data:any;
  cart:any;
  cartForm:FormGroup;
  formdata:any;

  submitted=false;
  constructor(public crtser:CartService,private router:Router,public proser:ProductService,private formBuilder: FormBuilder,
    private shr:SharingService) {
      this.cartForm= this.formBuilder.group({
        id:new FormControl('', [Validators.required]),
        productId:new FormControl('',[Validators.required]),
        quantity:new FormControl('',[Validators.required])
      });
     }

  ngOnInit(): void {
    this.Id=this.shr.getdetails()
    console.log(this.Id)
    this.crtser.cartpro(this.Id).subscribe(
      (res:any)=>{
        this.cart=res;
        console.log(this.cart);
      }
    );
  }
  
  onSubmit(){
    this.submitted=true;
    if(this.cartForm.valid){
      this.data=this.cartForm.value;
      console.log(this.data)
      this.crtser.updatecart(this.Id,this.data).subscribe(
        (res:any)=> {
            console.warn(res)
            this.router.navigate(['cartlist'])

      }
      )
  }

}

}
