import { Component } from '@angular/core';
import { CommandeHttpService } from '../commande/commande-http.service';
import { Commande, Employe } from '../model';
import { EmployeHttpService } from './employe-http.service';

@Component({
  selector: 'app-employe',
  templateUrl: './employe.component.html',
  styleUrls: ['./employe.component.css']
})
export class EmployeComponent {


  formEmploye: Employe = null;



  constructor(private employeService: EmployeHttpService,private commandeService: CommandeHttpService) {
  }

  list(): Array<Employe> {
    return this.employeService.findAll();
  }

  
  listCommandes(): Array<Commande> {
    return this.commandeService.findAll();
  }
 


}
