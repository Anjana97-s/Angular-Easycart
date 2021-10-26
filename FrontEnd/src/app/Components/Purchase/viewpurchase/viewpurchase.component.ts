import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PurchaseService } from 'src/app/purchase.service';
import { SharingService } from 'src/app/Service/sharing.service';

@Component({
  selector: 'app-viewpurchase',
  templateUrl: './viewpurchase.component.html',
  styleUrls: ['./viewpurchase.component.css']
})
export class ViewpurchaseComponent implements OnInit {
purchase:any;
  constructor(public purser:PurchaseService,private router:Router,
    private shr:SharingService) { }

  ngOnInit(): void {
    this.purser.getpurchase().subscribe(
      (res:any)=>{
        this.purchase=res;
        console.log(res);
      }

    )
  }

}
