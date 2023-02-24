import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Commande } from '../model';

@Injectable({
  providedIn: 'root'
})
export class CommandeHttpService {

    commandes: Array<Commande> = new Array<Commande>();

  constructor(private http: HttpClient) {
    this.load();
  }


  findAll(): Array<Commande> {
    return this.commandes;
  }

  findById(id: number): Observable<Commande> {
    return this.http.get<Commande>("http://localhost:8888/commande/" + id);
  }

  create(commande: Commande): void {
    this.http.post<Commande>("http://localhost:8888/commande", commande).subscribe(resp => {
      this.load();
    });
  }

  update(commande: Commande): void {
    this.http.put<Commande>("http://localhost:8888/commande/" + commande.numero, commande).subscribe(resp => {
      this.load();
    });
  }

  remove(id: number): void {
    this.http.delete<void>("http://localhost:8888/commande/" + id).subscribe(resp => {
      this.load();
    });
  }

  private load(): void {
    this.http.get<Array<Commande>>("http://localhost:8888/commande").subscribe(resp => {
      this.commandes = resp;
    });
  }

}
