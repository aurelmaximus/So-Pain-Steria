  import { Component } from '@angular/core';
import { CommandeHttpService } from '../commande/commande-http.service';
import { Employe, Compte, Adresse } from '../model';
import { EmployegcHttpService } from './employe-gc.http.service';

@Component({
  selector: 'app-employe-gc , [autofocus]',
  templateUrl: './employe-gc.component.html',
  styleUrls: ['./employe-gc.component.css']
})
export class EmployeGcComponent {

  formEmploye: Employe = null;
  
  cache:boolean=false;
  isFormValid: boolean = false;
  

  constructor(private employeService: EmployegcHttpService) {

  }

  list(): Array<Employe> {
    return this.employeService.findAll();
  }
  
  add(): void {
    
    this.formEmploye = new Employe();
    this.formEmploye.adresse = new Adresse();
  }

  modif(): void {
    this.cache=true;
  }

  save(): void {
    this.formEmploye.type = 'employe';
  
    if (this.validateForm()) {
      if (this.formEmploye.id) {
        this.employeService.update(this.formEmploye);
      } else {
        this.employeService.create(this.formEmploye);
      }
      this.cancel();
    }
  }
  
  cancel(): void {
    this.formEmploye = null;
    this.cache=false;
  }

  remove(id: number): void {
    this.employeService.remove(id);
  }


  edit(id: number): void {
    this.employeService.findById(id).subscribe(response => {
      this.formEmploye = response;
  
      
    });
  }


  employeconnecte(): Employe {
    return this.employeService.currentEmploye;
  }

  validateForm(): boolean {
    let isFormValid = true;
  
    if (!this.formEmploye.nom || !this.formEmploye.prenom || !this.formEmploye.email || !this.formEmploye.password || !this.formEmploye.adresse.voie || !this.formEmploye.adresse.cp || !this.formEmploye.adresse.ville) {
      isFormValid = false;
    }
  
    return isFormValid;
  }
  
}



