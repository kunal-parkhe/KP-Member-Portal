import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private router:Router) { }
  isLoggedIn() {

    const token = localStorage.getItem("token"); // get token from local storage
    return token;


  }

  signOut(){
    localStorage.clear();
    this.router.navigate(['signin']);
  }
}
