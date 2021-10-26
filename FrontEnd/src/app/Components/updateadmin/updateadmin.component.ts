import { HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/Service/admin.service';
import { SharingService } from 'src/app/Service/sharing.service';

@Component({
  selector: 'app-updateadmin',
  templateUrl: './updateadmin.component.html',
  styleUrls: ['./updateadmin.component.css']
})
export class UpdateadminComponent implements OnInit {
  Id:any;
  data:any;
  admin:any=[];
  adminlist:any=[];
  adminForm:FormGroup;
  formdata:any;
  rImage='data:image/png;base64,'
  submitted=false;

  constructor(private sanitizer:DomSanitizer, public admser:AdminService,private router:Router,private formBuilder: FormBuilder,
    private shr:SharingService) {
        this.adminForm=this.formBuilder.group({
          name:new FormControl('', [Validators.required]),
          email:new FormControl('',[Validators.required]),

        })
     }

  ngOnInit(): void {
    this.Id=this.shr.getdetails()
    console.log(this.Id)
    this.admser.currentAdmin().subscribe(
      (data:any)=>{
        this.admin=data;
        console.log(this.admin)
      }
    );
  }
  onSubmit(){
    const adminForm={
      name:  this.adminForm.value.name,
      email: this.adminForm.value.email,
      password:this.admin.password,
      image: this.admin.image,
      filename:this.admin.filename
    }
    this.submitted=true;
    if(this.adminForm.valid){
      console.log(this.data)
      this.admser.updateadmin(this.Id,adminForm).subscribe(
        (res:any)=> {
            this.router.navigate(['adminprofile'])

      }
      )
  }

}

}
