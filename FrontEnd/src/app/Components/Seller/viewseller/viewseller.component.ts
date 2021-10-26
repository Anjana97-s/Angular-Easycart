import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SellerService } from 'src/app/seller.service';
import { SharingService } from 'src/app/Service/sharing.service';

@Component({
  selector: 'app-viewseller',
  templateUrl: './viewseller.component.html',
  styleUrls: ['./viewseller.component.css']
})
export class ViewsellerComponent implements OnInit {
seller:any;
  constructor(public sellser:SellerService,private router:Router,
    private shr:SharingService) { }

  ngOnInit(): void {
    this.sellser.getseller().subscribe(
      (res:any)=>{
        this.seller=res;
        console.log(res);
      }
    );
  }

}
