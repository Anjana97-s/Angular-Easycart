import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { SellerService } from 'src/app/seller.service';
import { SharingService } from 'src/app/Service/sharing.service';

@Component({
  selector: 'app-updateseller',
  templateUrl: './updateseller.component.html',
  styleUrls: ['./updateseller.component.css']
})
export class UpdatesellerComponent implements OnInit {
  Id:any;
  data:any;
  seller:any=[];
  sellerlist:any=[];
  sellerForm:FormGroup;
  formdata:any;
  rImage='data:image/png;base64,'
  submitted=false;
  constructor(private sanitizer:DomSanitizer, public sellser:SellerService,private router:Router,private formBuilder: FormBuilder,
    private shr:SharingService) {
      this.sellerForm=this.formBuilder.group({
        firstName:new FormControl(''),
        address:new FormControl(''),
        city:new FormControl(''),
        state:new FormControl(''),
        pin:new FormControl(''),
        country:new FormControl('')
      })
     }

  ngOnInit(): void {
    this.Id=this.shr.getdetails()
    console.log(this.Id)
    this.sellser.currentSeller().subscribe(
      (data:any)=>{
        this.seller=data;
        console.log(this.seller)
      }
    );
  }
  onSubmit(){
    const sellerForm={
      firstName:  this.sellerForm.value.firstName,
      address:this.sellerForm.value.address,
      city:this.sellerForm.value.city,
      state:this.sellerForm.value.state,
      pin:this.sellerForm.value.pin,
      country:this.sellerForm.value.country,
      email: this.sellerForm.value.email,
      password:this.seller.password,
      phone:this.seller.phone,
      image: this.seller.image,
      filename:this.seller.filename
    }
    this.submitted=true;
    if(this.sellerForm.valid){
      this.sellser.updateseller(this.Id,sellerForm).subscribe(
        (res:any)=> {
            this.router.navigate(['sellerprofile'])

      }
      )
  }

}
}