import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class GuardService implements CanActivate {

  constructor(private authService: AuthService, private router: Router) { }

  canActivate(

    next: ActivatedRouteSnapshot,

    state: RouterStateSnapshot):  boolean {

      if (!this.authService.isLoggedIn()) {

        this.router.navigate(["/signin"]); // go to login if not authenticated

        return false;

      }

    return true;

  }
}
