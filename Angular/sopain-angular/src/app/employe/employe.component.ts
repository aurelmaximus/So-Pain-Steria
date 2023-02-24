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
  formCommande: Commande = null;

  etatcommande:boolean =false;
  cache:boolean=true;

  constructor(private employeService: EmployeHttpService,private commandeService: CommandeHttpService) {
  }

  list(): Array<Employe> {
    return this.employeService.findAll();
  }

  
  listCommandes(): Array<Commande> {
    return this.commandeService.findAll();
  }


  appel(): void {
   this.etatcommande=true;
   this.cache=false;
  }

  cancel(): void {
    this.etatcommande=false;
    this.cache=true;
  }

  edit(numero: number): void {
    this.commandeService.findById(numero).subscribe(response => {
      console.log('response from findById', response);
  
      this.formCommande = response;
      console.log('formCommande before update', this.formCommande);
  
      this.commandeService.update(this.formCommande);
      console.log('formCommande afterupdate', this.formCommande);
  
      this.cancel();
    });
  }


}
