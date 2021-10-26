import { Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { SellerService } from 'src/app/seller.service';
import { SharingService } from 'src/app/Service/sharing.service';

@Component({
  selector: 'app-sellerprofile',
  templateUrl: './sellerprofile.component.html',
  styleUrls: ['./sellerprofile.component.css']
})
export class SellerprofileComponent implements OnInit {
  data:any;
  sellerid:any;
  seller:any=[];
  sellerlist:any=[];
  public userFile:any=File
  rImage='data:image/png;base64,'

  constructor(private sanitizer:DomSanitizer, public sellser:SellerService,private router:Router,
    private shr:SharingService) { }

  ngOnInit(): void {
    this.sellser.currentSeller().subscribe(
      (data:any)=>{
        this.seller=data;
        console.log(this.seller)
      }
    );
  }
  edit(id:any)
  {
   this.router.navigate(['updateseller'])
    this.data=id;
    this.shr.setdetails(this.data)
  }
  onSelectFile(event:any){
    const file= event.target.files[0];
    this.userFile=file

  }
  upload(id:any)
{
  const sellerForm={
firstName:this.seller.firstName,
    email:this.seller.email,
    password:this.seller.password,
    address:this.seller.address,
city:this.seller.city,
state:this.seller.state,
pin:this.seller.pin,
country:this.seller.country
}
this.sellerid=id;
console.log(this.sellerid)
const formData=new FormData();
formData.append('seller',JSON.stringify(sellerForm))
formData.append('file',this.userFile)
console.log(this.userFile)

this.sellser.updateimage(this.sellerid,formData).subscribe(
  (data) => {

    if (data) {
     alert("Updated  Successfully!")

    }
}, (data) => {
  alert(data.error.message)
}
)
}

}
