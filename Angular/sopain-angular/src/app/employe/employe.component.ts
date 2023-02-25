import { Component } from '@angular/core';
import { CommandeHttpService } from '../commande/commande-http.service';
import { Commande, Employe, EtatCommande } from '../model';
import { EmployeHttpService } from './employe-http.service';

@Component({
  selector: 'app-employe',
  templateUrl: './employe.component.html',
  styleUrls: ['./employe.component.css']
})
export class EmployeComponent {


  formEmploye: Employe = null;
  formCommande: Commande = null;

  etatcommande:boolean =false;
  cache:boolean=true;

  constructor(private employeService: EmployeHttpService,private commandeService: CommandeHttpService) {
  }

  list(): Array<Employe> {
    return this.employeService.findAll();
  }

  
  listCommandesPastermine(): Array<Commande> {
    return this.commandeService.findAllPasTermine();
  }

  listCommandestermine(): Array<Commande> {
    return this.commandeService.findAllTermine();
  }


  cancel(): void {
    this.etatcommande=false;
    this.cache=true;
  }

  save(): void {
    if(this.formCommande.numero) {
      this.commandeService.update(this.formCommande);
    } else {
      this.commandeService.create(this.formCommande);
    }

    this.cancel();
  }
 
Encours(numero: number): void {
  this.commandeService.findById(numero).subscribe(response => {
   
    this.formCommande = response;
   

    this.formCommande.etatcommande = 'EnCours';
   
    this.save();
  
  });
 
}

Prete(numero: number): void {
  this.commandeService.findById(numero).subscribe(response => {
    
    this.formCommande = response;
    
    if (confirm('Voulez-vous vraiment marquer cette commande comme Prete ?'))

    this.formCommande.etatcommande = 'Prete';
   
    this.save();
  
  });
 
}

termine(numero: number): void {
  this.commandeService.findById(numero).subscribe(response => {
    
    this.formCommande = response;
    

    this.formCommande.etatcommande = 'Termine';
    
    this.save();
  
  });
 
}


  avant(): void {
   
    
  }


}
