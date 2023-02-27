import { Component } from '@angular/core';
import { CommandeHttpService } from '../commande/commande-http.service';
import { Employe, Compte, Adresse } from '../model';
import { EmployegcHttpService } from './employe-gc.http.service';

@Component({
  selector: 'app-employe-gc',
  templateUrl: './employe-gc.component.html',
  styleUrls: ['./employe-gc.component.css']
})
export class EmployeGcComponent {

  formEmploye: Employe = null;
  
  cache:boolean=false;
  masquer:boolean=true;


  constructor(private employeService: EmployegcHttpService) {
  }



  list(): Array<Employe> {
    return this.employeService.findAll();
  }

  
  listEmploye(): Array<Employe> {
    return this.employeService.findAll();
  }
 
  
  add(): void {
    
    this.formEmploye = new Employe();
    this.formEmploye.adresse = new Adresse();
  

  }

  modif(): void {
    this.cache=true;
    this.masquer=false;
  }


  save(): void {

    if(this.formEmploye.id) {
      this.employeService.update(this.formEmploye);
    } else {
      this.employeService.create(this.formEmploye);
    }

    this.cancel();
  }

  remove(id: number): void {
    this.employeService.remove(id);
  }

  cancel(): void {
    this.formEmploye = null;
    this.cache=false;
    
  }

  edit(id: number): void {
    this.employeService.findById(id).subscribe(response => {
      this.formEmploye = response;
  
      
    });
  }


  employeconnecte(): Employe {
    return this.employeService.currentEmploye;
  }

}



