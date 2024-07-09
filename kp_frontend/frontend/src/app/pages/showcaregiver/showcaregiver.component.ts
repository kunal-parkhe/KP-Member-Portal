import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AssignCaregiver } from 'src/app/assign-caregiver';
import { Caregiver } from 'src/app/caregiver';
import { CaregiverService } from 'src/app/services/caregiver.service';
import { DeleteService } from 'src/app/services/delete.service';
import { ShowcaregiverService } from 'src/app/services/showcaregiver.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-showcaregiver',
  templateUrl: './showcaregiver.component.html',
  styleUrls: ['./showcaregiver.component.scss']
})
export class ShowcaregiverComponent implements OnInit {
  //caregiver!: Caregiver[];
  assigncaregiver!: AssignCaregiver[];
  memberId = Number(localStorage.getItem('memId')); 
  constructor(private caregiverService: CaregiverService,private showCaregiver:ShowcaregiverService,private deleteService:DeleteService,private router:Router) { }

  ngOnInit(): void {
  }
  

  viewDetails(memberId:number){
    
    this.showCaregiver.fetchAssign(memberId).subscribe((data) => {
      this.assigncaregiver = data;
    });

    
  }

  deleteDetails(memberId: number, careGiverId: number){
    this.deleteService.deletecaregiver(memberId, careGiverId).subscribe(
      () => {
        
        Swal.fire("Delete Successfully");
      //this.router.navigate(['/caregiver']);
      },
      (error: any) => {
        alert("Not Allowed more than 2 caregivers.");
        // Handle error
      }
    );

  }
}
