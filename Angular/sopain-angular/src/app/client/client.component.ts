import { Component } from '@angular/core';
import { Adresse, Client } from '../model';
import { ClientHttpService } from './client-http.service';


@Component({
  selector: 'app-ordinateur',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent {

  formClient: Client = null;
  isFormValid: boolean = false;
  // form : boolean = true;
  // page2 : boolean = false;

  constructor(private clientService: ClientHttpService) {
    this.formClient = new Client();
    this.formClient.adresse = new Adresse();
    this.formClient.type = 'client';
  }

  list(): Array<Client> {
    return this.clientService.findAll();
  }

  add(): void {
    this.formClient = new Client();
    this.formClient.adresse = new Adresse();
  }

  edit(id: number): void {
    this.clientService.findById(id).subscribe(response => {
      this.formClient = response;
    });
  }

  save(): void {

    if (this.validateForm()) {
    if(this.formClient.id) { // UPDATE
      this.clientService.update(this.formClient);
    } else { // CREATE
      this.clientService.create(this.formClient);
    }
  }

    //  this.form=false;
    //  this.page2=true;

    //  setTimeout(function(){window.location.replace("http://localhost:4200/")},3000);
      

  }


  remove(id: number): void {
    this.clientService.remove(id);
  }

  cancel(): void {
    this.formClient = null;
  }

  validateForm(): boolean {
    let isFormValid = true;
  
    if (!this.formClient.nom || !this.formClient.prenom || !this.formClient.email || !this.formClient.password || !this.formClient.adresse.voie || !this.formClient.adresse.cp || !this.formClient.adresse.ville) {
      isFormValid = false;
    }
  
    return isFormValid;
  }
 
}
