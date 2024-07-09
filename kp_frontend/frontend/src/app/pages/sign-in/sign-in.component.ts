import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import { TokenService } from 'src/app/token.service';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent implements OnInit {
     
  constructor(private userServeice:UserService, private snackBar:MatSnackBar,private router:Router,private tokenService:TokenService) { }
  
    public user={  
      
      email:'',
      password:'',
      
      }
      submit=false;
  

  ngOnInit(): void {
  }
  formSubmit(){
    console.log(this.user);
    if(this.user.email=='' || this.user.email == null){
      // alert("User Name is Required..!")
      this.snackBar.open("Email id is Required.!!", "OK", {
        duration:2000,
      })
      return;
    }
    //userServiceCall
    this.userServeice.loginUSer(this.user).subscribe(
      (response:any)=>{
        console.log(response.accessToken);
        localStorage.setItem('token',response.accessToken);
        this.tokenService.setToken(response.accessToken);
       // alert("Successfully Registered..!")
       Swal.fire("LOGGED IN!!..", "Logged in with Member email id "+ this.user.email, "success");
       this.router.navigate(['/caregiver']);
       localStorage.setItem('memId',response.id);
       console.log(response.id);
      },
      (error)=>{
        console.log(error);
        // alert("Somethings wents Wrong..!")
        this.snackBar.open("Check the email id and password!!", "OK", {
          duration:2000,
        })
      }
    );
  }
  

}
