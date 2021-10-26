import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/Service/admin.service';
import { SharingService } from 'src/app/Service/sharing.service';

@Component({
  selector: 'app-vieworder',
  templateUrl: './vieworder.component.html',
  styleUrls: ['./vieworder.component.css']
})
export class VieworderComponent implements OnInit {
order:any;
  constructor(public sellser:AdminService,private router:Router,
    private shr:SharingService) { }

  ngOnInit(): void {
    this.sellser.vieworder().subscribe(
      (res:any)=>{
        this.order=res;
        console.log(res);
      }
    );
  }

}
