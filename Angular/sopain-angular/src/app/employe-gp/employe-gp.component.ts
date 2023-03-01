import { Component } from '@angular/core';
import { Employe, Basique, Compte } from '../model';
import { EmployegpHttpService } from './employe-gp.http.service';

@Component({
  selector: 'app-employe-gp',
  templateUrl: './employe-gp.component.html',
  styleUrls: ['./employe-gp.component.css']
})
export class EmployeGpComponent {

  recherche:string;
  
  formBasique: Basique = null;

  cache:boolean=false;
  isFormValid: boolean = false;


  constructor(private employeService: EmployegpHttpService) {
  }



  list(): Array<Employe> {
    return this.employeService.findAll();
  }

  
  listBasique(): Array<Basique> {
    if (this.recherche) {
      return this.employeService.findAllBasiques()
        .filter(b => b.libelle.toLowerCase().includes(this.recherche.toLowerCase()));
    } else {
      return this.employeService.findAllBasiques();
    }
  }
 
  
  add(): void {
    
    this.formBasique = new Basique();

  }

  modif(): void {
    this.cache=true;
  }


  save(): void {

    if(this.formBasique.id) {
      this.employeService.update(this.formBasique);
    } else {
      this.employeService.create(this.formBasique);
    }

    this.cancel();
  }

  remove(id: number): void {
    this.employeService.remove(id);
  }

  cancel(): void {
    this.formBasique = null;
    this.cache=false;
    
  }

  edit(id: number): void {
    this.employeService.findById(id).subscribe(response => {
      this.formBasique = response;
  
      
    });
  }


  employeconnecte(): Employe {
    return this.employeService.currentEmploye;
  }

  validateForm(): boolean {
    let isFormValid = true;
  
    if (!this.formBasique.categorie || !this.formBasique.libelle || !this.formBasique.prix || !this.formBasique.description || !this.formBasique.image_ref) {
      isFormValid = false;
    }
  
    return isFormValid;
  }
  



}

