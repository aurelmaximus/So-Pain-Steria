import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Client } from '../model';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  private listeClients: Array<Client> = new Array<Client>()

  constructor(private http: HttpClient) {
    this.loadAll()
  }

  public loadAll(): void {
    this.http.get<Array<Client>>("http://localhost:8888/client").subscribe(resp => {
      this.listeClients = resp
    })
  }

  public findAll(): Array<Client> {
    return this.listeClients
  }

  public findById(id: number): Client {
    return this.listeClients.find(c => c.id == id)
  }

  public insert(client: Client): void {
    let maxId = -1
    this.listeClients.forEach(c => maxId = Math.max(maxId, c.id))
    client.id = maxId + 1
    client.version = 0

    this.listeClients.push({...client})
  }

  public update(client: Client): void {
    let editedClient = this.findById(client.id);
    if(editedClient) {
      let idx = this.listeClients.indexOf(editedClient)
      client.version++
      this.listeClients[idx] = {...client}
    }
  }

  public delete(id: number) {
    let s = this.findById(id);
    let idx = this.listeClients.indexOf(s)
    this.listeClients.splice(idx, 1)
  }




}
