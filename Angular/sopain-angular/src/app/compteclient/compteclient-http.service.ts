import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from '../auth/auth.service';
import { Client } from '../model';

@Injectable({
  providedIn: 'root'
})
export class CompteclientHttpService {

    clients: Array<Client> = new Array<Client>();
    currentclient: Client;

  constructor(private http: HttpClient, private auth: AuthService) {
    this.load();
  }

  findAll(): Array<Client> {
    return this.clients;
  }


  findById(id: number): Observable<Client> {
    return this.http.get<Client>("http://localhost:8888/client/" + id);
  }

  create(client: Client): void {
    this.http.post<Client>("http://localhost:8888/client", client).subscribe(resp => {
      this.load();
    });
  }

  update(client: Client): void {
    this.http.put<Client>("http://localhost:8888/client/" + client.id, client).subscribe(resp => {
      this.load();
    });
  }

  remove(id: number): void {
    this.http.delete<void>("http://localhost:8888/client/" + id).subscribe(resp => {
      this.load();
    });
  }

  findByIdCli(id: number): Observable<Client> {
    return this.http.get<Client>("http://localhost:8888/client/" + id);
  }

  private load(): void {
    this.findByIdCli(this.auth.connected.id).subscribe(resp => {
      this.currentclient=resp;
    });
  }

}
