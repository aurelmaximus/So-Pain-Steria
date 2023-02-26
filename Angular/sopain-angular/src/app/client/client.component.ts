import { Component } from '@angular/core';
import { Client } from '../model';
import { ClientHttpService } from './client-http.service';


@Component({
  selector: 'app-ordinateur',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent {
  formClient: Client = undefined;

  constructor(private clientService: ClientHttpService) {
  }

  list(): Array<Client> {
    return this.clientService.findAll();
  }

  add(): void {
    this.formClient = new Client();
  }

  edit(id: number): void {
    this.clientService.findById(id).subscribe(response => {
      this.formClient = response;
    });
  }

  save(): void {
    if(this.formClient.id) { // UPDATE
      this.clientService.update(this.formClient);
    } else { // CREATE
      this.clientService.create(this.formClient);
    }

    this.cancel();
  }

  remove(id: number): void {
    this.clientService.remove(id);
  }

  cancel(): void {
    this.formClient = null;
  }
}
