import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
//const API_URL="http://localhost:8081"
// LOCALHOST URL REST API
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) {}

  //ADD_USER
  addUSer(user:any){
    return this.http.post("http://localhost:8081/register", user)
  }
  loginUSer(user:any){
    return this.http.post("http://localhost:8081/login", user)
  }
}
