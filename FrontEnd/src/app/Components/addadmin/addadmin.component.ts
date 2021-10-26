import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/Service/admin.service';
import { SharingService } from 'src/app/Service/sharing.service';

@Component({
  selector: 'app-addadmin',
  templateUrl: './addadmin.component.html',
  styleUrls: ['./addadmin.component.css']
})
export class AddadminComponent implements OnInit {
  public userFile:any=File
  public admin:any
  productRegForm=this.fb.group({
    name: [""],
    email: [""],
    password: [''],

  })
  constructor(private fb:FormBuilder,public admser:AdminService,private router:Router,
    private shr:SharingService) { }

  ngOnInit(): void {
  }
  register() {
    this.productRegForm.markAllAsTouched();
    
    if (this.productRegForm.valid) {
      this.admin=this.productRegForm.value
      const formData=new FormData();
      formData.append('admin',JSON.stringify(this.admin))
      formData.append('file',this.userFile)
      console.log(this.userFile)

      this.admser.register(formData).subscribe(
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
