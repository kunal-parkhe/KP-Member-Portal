import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { Caregiver } from 'src/app/caregiver';
import { AuthService } from 'src/app/services/auth.service';
import { CaregiverService } from 'src/app/services/caregiver.service';
import { Router } from '@angular/router';
import { ShowcaregiverService } from 'src/app/services/showcaregiver.service';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import Swal from 'sweetalert2'
@Component({
  selector: 'app-caregiver',
  templateUrl: './caregiver.component.html',
  styleUrls: ['./caregiver.component.scss']
})
export class CaregiverComponent implements OnInit {
  caregiver!: Caregiver[];
  EmailId!: String;
  searchContent!: string;
   memberId = Number(localStorage.getItem('memId')); 

   

  constructor(private caregiverService: CaregiverService, private auth: AuthService, private router: Router) { }
  
  ngOnInit(): void {
    this.getAllCaregivers();
    
    
  }
  
  
  
  assignButtonClick(memberId:number,caregiverid:number) {
    
    var careGiverId = caregiverid; 
    console.log(localStorage.getItem('memId'));

    this.caregiverService.getAssign(memberId, careGiverId).subscribe(
      () => {
        
      //alert("Assign succesfully");
      Swal.fire("Assign Successfully");
       
      },
      (error: any) => {
        //alert("Not allowed more than 2 caregivers");
        Swal.fire("Not allowed more than 2 caregivers");
      }
    );
  
  }
  ButtonClick(){
    this.router.navigate(["/showcaregiver"]) ;
  }
  
  getAllCaregivers() {
    this.caregiverService.getAllCaregiver().subscribe(data => {
      this.caregiver = data;
      
    
    });
  }

  
}
