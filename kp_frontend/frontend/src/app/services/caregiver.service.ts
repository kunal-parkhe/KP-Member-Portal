import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Caregiver } from '../caregiver';
import { TokenService } from '../token.service';

@Injectable({
  providedIn: 'any'
})
export class CaregiverService {
  caregiverURL="http://localhost:8081/getAllCaregiver";
  ASSIGN_URL="http://localhost:8091/assign/";
  
  constructor(private http:HttpClient,private tokenService:TokenService) { }

  getAllCaregiver():Observable<Caregiver[]>{
    

   return this.http.get<Caregiver[]>(`${this.caregiverURL}`);

}
getAssign(memberId: number, careGiverId: number): Observable<any> {
  
  const requestBody = { memberId: memberId, careGiverId: careGiverId };
  const authToken = this.tokenService.getToken(); 
  const headers = new HttpHeaders({ 'Authorization': `Bearer ${authToken}` });
  
  return this.http.post<any>(this.ASSIGN_URL+memberId+ '/'+careGiverId, requestBody,{ headers });
}
//showAssign(memberId: number, careGiverId: number): Observable<Caregiver[]>{
 // const requestBody = { memberId: memberId, careGiverId: careGiverId };
 // const authToken = this.tokenService.getToken(); 
 // const headers = new HttpHeaders({ 'Authorization': `Bearer ${authToken}` });
 // return this.http.get<Caregiver[]>(this.GET_ASSIGN+memberId+ '/'+careGiverId);
//}
}
