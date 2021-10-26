import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from '../../Service/cart.service';
import { SharingService } from '../../Service/sharing.service';

@Component({
  selector: 'app-cartlist',
  templateUrl: './cartlist.component.html',
  styleUrls: ['./cartlist.component.css']
})
export class CartlistComponent implements OnInit {
  data:any;
carts:any;
cartlist:any=[];
  constructor(public crtser:CartService,private router:Router,
    private shr:SharingService) { }

  ngOnInit(): void {
    this.crtser.getcart().subscribe(
      (res:any)=>{
        this.carts=res;
        console.log(this.carts)
      }
    );
   
  }
  remove(id:any)
  {
    this.cartlist.slice(id,1);
    this.crtser.Deletecart(id).subscribe
    (
      (res)=>{
        console.log("entered")
        console.warn(res)
      }
    )
  }
  edit(id:any)
  {
    this.router.navigate(['updatecart'])
    this.data=id;
    this.shr.setdetails(this.data)
  }
  order()
  {
    this.router.navigate(['order'])
    this.cartlist=this.carts
    this.shr.setdetails(this.cartlist)
  }
  
}
