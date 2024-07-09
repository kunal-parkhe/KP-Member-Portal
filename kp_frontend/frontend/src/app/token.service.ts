import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  constructor() { }
  private token: string = '';
  //private id!: number;

  setToken(token: string) {
    this.token = token;
  }

  getToken(): string {
    return this.token;
  }
  //setId(id:number) {
  //  this.id = id;
  //}

  //getId(): number {
   // return this.id;
  //}
}
