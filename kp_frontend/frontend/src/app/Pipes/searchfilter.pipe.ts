import { Pipe, PipeTransform } from '@angular/core';
import { Caregiver } from '../caregiver';
@Pipe({
  name: 'searchfilter'
})
export class SearchfilterPipe implements PipeTransform {

  transform(caregiver: Caregiver[], value: string): any {
    
    if(!caregiver || !value){
      return caregiver;
    }
    else{
      return caregiver.filter(res=>{
      
        return res.firstname.toLowerCase().includes(value.toLowerCase()) ||
        res.lastname.toLowerCase().includes(value.toLowerCase()) ||
        res.emailid.toLowerCase().includes(value.toLowerCase())||
        res.caregiverid.toString().toLowerCase().includes(value.toLowerCase())
      })
    }
  }

}
