import { Component } from '@angular/core';
import { CommandeHttpService } from '../commande/commande-http.service';
import { Employe, Commande } from '../model';
import { EmployegcHttpService } from './employe-gc.http.service';

@Component({
  selector: 'app-employe-gc',
  templateUrl: './employe-gc.component.html',
  styleUrls: ['./employe-gc.component.css']
})
export class EmployeGcComponent {

  formEmploye: Employe = null;



  constructor(private employeService: EmployegcHttpService) {
  }

  list(): Array<Employe> {
    return this.employeService.findAll();
  }

  
  listEmploye(): Array<Employe> {
    return this.employeService.findAll();
  }
 




}
