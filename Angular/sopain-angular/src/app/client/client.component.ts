import { Component } from '@angular/core';
import { Client } from '../model';
import { ClientHttpService } from './client-http.service';
import { ClientService } from './client.service';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent {
  formClient: Client;

  constructor( private clientService: ClientHttpService) {}

  public findAll() {
    return this.clientService.findAll();
  }

  add() {
    if(this.formClient) {
      if(this.formClient.id) {
        this.clientService.update(this.formClient)
      } else {
        this.clientService.create(this.formClient)
      }

      this.formClient = undefined
    } else {
      this.formClient = new Client()
    }
  }

  cancel() {
    this.formClient = undefined
  }

 

  remove(id: number) {
    this.clientService.remove(id)
  }
}
