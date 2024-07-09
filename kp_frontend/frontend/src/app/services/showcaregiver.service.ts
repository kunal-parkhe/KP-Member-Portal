import { HttpClient, HttpHeaders,HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AssignCaregiver } from '../assign-caregiver';
import { Observable } from 'rxjs/internal/Observable';
import { TokenService } from '../token.service';
@Injectable({
  providedIn: 'any'
})
export class ShowcaregiverService {
  FETCH_URL="http://localhost:8091/fetch/";

  constructor(private http:HttpClient,private tokenService:TokenService) { }

  fetchAssign(memberId: number):Observable<any>{
    
    const authToken = this.tokenService.getToken();
    const headers = new HttpHeaders({ 'Authorization': `Bearer ${authToken}` });
    const params = new HttpParams().set('memberId', String(memberId));
    return this.http.get<any>(this.FETCH_URL+memberId, { headers, params });
  }
}
