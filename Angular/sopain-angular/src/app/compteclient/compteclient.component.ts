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

  constructor(private compteclientService: CompteclientHttpService,private commandeService: CommandeHttpService) {
  }

  list(): Array<Client> {
    return this.compteclientService.findAll();
  }

   
  listCommandesPastermine(): Array<Commande> {
    return this.commandeService.findAllPasTermine();
  }

  listCommandestermine(): Array<Commande> {
    return this.commandeService.findAllTermine();
  }

  cancel(): void {
    
  }




}
