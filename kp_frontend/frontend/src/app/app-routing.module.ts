import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './pages/home/home.component';
import { SignInComponent } from './pages/sign-in/sign-in.component';
import { SignUpComponent } from './pages/sign-up/sign-up.component';
import { CaregiverComponent } from './pages/caregiver/caregiver.component';
import { GuardService } from './services/guard.service';
import { ShowcaregiverComponent } from './pages/showcaregiver/showcaregiver.component';


const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    pathMatch: 'full',
  },
  {
    path: 'signup',
    component: SignUpComponent,
    pathMatch: 'full',
  },
  {
    path: 'signin',
    component: SignInComponent,
    pathMatch: 'full',
  },
  {
    path:'caregiver',
    component:CaregiverComponent,
    canActivate: [GuardService],
    
  },
  {
    path:'showcaregiver',
    component:ShowcaregiverComponent,
    canActivate: [GuardService],
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
