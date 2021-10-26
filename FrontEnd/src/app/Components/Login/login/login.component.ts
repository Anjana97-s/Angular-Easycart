import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginServiceService } from 'src/app/Service/login-service.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  data: any;

  constructor(private http:HttpClient ,private   lgser:LoginServiceService ,    private router: Router) { }
  formdata:any;

  submitted = false;
  ngOnInit(): void {
    this.formdata=new FormGroup({
      email:new FormControl( '', [Validators.required, Validators.email]),
    
      password:new FormControl('',[Validators.required,Validators.minLength(8),Validators.maxLength(20)]),
    });
      }
      get f() { return this.formdata.controls; }
      inputdata()
      {
        this.submitted = true;
        if (this.formdata.valid) {
          this.data=this.formdata.value;
         // this.http.post('http://localhost:8080/login',this.data)
    
          //.subscribe((data)=>
          console.warn(this.data);
          this.lgser.loginuser(this.data)
          .subscribe((res:any)=> {
            if(res['status']==1){
    console.warn(res);
    localStorage.setItem('token1',res.accessToken.value);
    }
          }
          ); 
         //alert('Login Successfully')
          this.router.navigate(["/product"]);          
    
    
      }
      else
      {
        return;
      }
    
      }
    
  }


