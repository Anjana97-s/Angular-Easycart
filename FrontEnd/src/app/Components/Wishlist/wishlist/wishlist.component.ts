import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SharingService } from 'src/app/Service/sharing.service';
import { WishlistService } from 'src/app/Service/wishlist.service';

@Component({
  selector: 'app-wishlist',
  templateUrl: './wishlist.component.html',
  styleUrls: ['./wishlist.component.css']
})
export class WishlistComponent implements OnInit {
data:any;
wishlists:any;
productlist:any=[];
id:any;
  constructor(public wshlser:WishlistService,private router:Router,
    private shr:SharingService) { }

  ngOnInit(): void { 
    this.wshlser.getwishlist().subscribe(
      (res:any)=>{
        this.wishlists=res;
        console.log(res);
      }
    );
  }
  Remove(id:any)
  {
    this.productlist.slice(id,1);
    this.wshlser.deletepro(id).subscribe
    (
      (res)=>{
        console.log("entered")
        console.warn(res)
      }
    )
  }


}
