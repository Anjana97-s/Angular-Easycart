import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { SellerService } from 'src/app/seller.service';
import { SharingService } from 'src/app/Service/sharing.service';

@Component({
  selector: 'app-seller-register',
  templateUrl: './seller-register.component.html',
  styleUrls: ['./seller-register.component.css']
})
export class SellerRegisterComponent implements OnInit {
  public userFile:any=File
  public seller:any
  productRegForm=this.fb.group({
    firstName: [""],
    //lastName:[""],
    address:[""],
    city:[""],
    pin:[""],
    state:[""],
    country:[""],
    phone:[""],
    password: [''],

    email: [""],

  })
  constructor(private fb:FormBuilder,public sellser:SellerService,private router:Router,
    private shr:SharingService) { }

  ngOnInit(): void {
  }
  register() {
    this.productRegForm.markAllAsTouched();
    
    if (this.productRegForm.valid) {
      this.seller=this.productRegForm.value
      const formData=new FormData();
      formData.append('seller',JSON.stringify(this.seller))
      formData.append('file',this.userFile)
      console.log(this.userFile)

      this.sellser.register(formData).subscribe(
        (data) => {

          if (data) {
            alert("Registered Successfully!")
           // this.router.navigateByUrl("/product-view")
      
          }
        }, (data) => {
          alert(data.error.message)
        }
        
      )

    }
    else {
      alert("Invalid details")
    }

  }
  onSelectFile(event:any){
    const file= event.target.files[0];
    this.userFile=file

  }
}
