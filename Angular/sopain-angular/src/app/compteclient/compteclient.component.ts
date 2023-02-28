import { Component } from '@angular/core';
import { CommandeHttpService } from '../commande/commande-http.service';
import { Client, Commande } from '../model';
import { CompteclientHttpService } from './compteclient-http.service';

@Component({
  selector: 'app-compteclient',
  templateUrl: './compteclient.component.html',
  styleUrls: ['./compteclient.component.css']
})
export class CompteclientComponent {

  formClient: Client = null;
  isFormValid: boolean = false;



  constructor(private compteclientService: CompteclientHttpService,private commandeService: CommandeHttpService) {
  }


  list(): Array<Client> {
    return this.compteclientService.findAll();
  }

   
  listCommandesEnCours(): Array<Commande> {
    const client = this.clientconnecte();
    return client?.id ? this.commandeService.findAllclientEncours(client) : [];
  }

  listCommandesTermine(): Array<Commande> {
    const client = this.clientconnecte();
    return client?.id ? this.commandeService.findAllclienttermine(client) : [];
  }

  cancel(): void {
    this.formClient = null;
  }

  clientconnecte(): Client {
    return this.compteclientService.currentclient;
  }

  save(): void {
    
      if (this.formClient.id) {
        
        this.compteclientService.update(this.formClient);
        
      } else {
       
        this.compteclientService.create(this.formClient);
      }
  
  this.cancel();
  }

  edit(id: number): void {
    this.compteclientService.findById(id).subscribe(response => {
      this.formClient = response;
  
      
    });
  }

 

}
