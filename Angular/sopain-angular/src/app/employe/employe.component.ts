import { Component } from '@angular/core';
import { Employe } from '../model';
import { EmployeHttpService } from './employe-http.service';

@Component({
  selector: 'app-employe',
  templateUrl: './employe.component.html',
  styleUrls: ['./employe.component.css']
})
export class EmployeComponent {


  formEmploye: Employe = null;



  constructor(private employeService: EmployeHttpService) {
  }

  list(): Array<Employe> {
    return this.employeService.findAll();
  }

 


}
