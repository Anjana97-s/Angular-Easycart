import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/Service/admin.service';
import { SharingService } from 'src/app/Service/sharing.service';
import { DomSanitizer,SafeUrl } from '@angular/platform-browser';
@Component({
  selector: 'app-adminprofile',
  templateUrl: './adminprofile.component.html',
  styleUrls: ['./adminprofile.component.css']
})
export class AdminprofileComponent implements OnInit {
  data:any;
  adminid:any;
  admin:any=[];
  adminlist:any=[];
  public userFile:any=File

  rImage='data:image/png;base64,'
  constructor(private sanitizer:DomSanitizer, public admser:AdminService,private router:Router,
    private shr:SharingService) {
     }

  ngOnInit(): void {
    this.admser.currentAdmin().subscribe(
      (data:any)=>{
        this.admin=data;
        console.log(this.admin)
      }
    );
  }
  edit(id:any)
  {
   this.router.navigate(['updateadmin'])
    this.data=id;
    this.shr.setdetails(this.data)
  }
  onSelectFile(event:any){
    const file= event.target.files[0];
    this.userFile=file

  }
  upload(id:any)
  {
    const adminForm={
      name:this.admin.name,
      email:this.admin.email,
      password:this.admin.password
    }
    this.adminid=id
    console.log(this.adminid)
    const formData=new FormData();
    formData.append('admin',JSON.stringify(adminForm))
    formData.append('file',this.userFile)
    this.admser.updateimage(this.adminid,formData).subscribe(
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
