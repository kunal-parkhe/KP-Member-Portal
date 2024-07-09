import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TokenService } from '../token.service';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class DeleteService {
  DELETE_URL="http://localhost:8091/delete/";
  constructor(private http:HttpClient,private tokenService:TokenService) { }

  deletecaregiver(memberId: number, careGiverId: number): Observable<any> {
    const requestBody = { memberId: memberId, careGiverId: careGiverId };
    const authToken = this.tokenService.getToken(); 
    const headers = new HttpHeaders({ 'Authorization': `Bearer ${authToken}` });
  
  return this.http.post<any>(this.DELETE_URL+memberId+ '/'+careGiverId, requestBody,{ headers });
  }
}
