import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Commande } from '../model';

@Injectable({
  providedIn: 'root'
})
export class CommandeHttpService {

    commandes: Array<Commande> = new Array<Commande>();
    etatcommandes: Map<string, string> = new Map<string,string>();
  
    constructor(private http: HttpClient) {
    this.load();
  }

  findAllPasTermine(): Array<Commande> {
    return this.commandes
      .filter(commande => commande.etatcommande === 'EnCours' || commande.etatcommande === 'Prete')
      .sort((a, b) => {
        if (a.etatcommande === 'EnCours' && b.etatcommande === 'Prete') {
          return -1;
        } else if (a.etatcommande === 'Prete' && b.etatcommande === 'EnCours') {
          return 1; 
        } else {
          return 0; 
        }
      });
      
  }

  findAllTermine(): Array<Commande> {
    return this.commandes.filter(commande => commande.etatcommande === 'Termine');
  }

  findById(numero: number): Observable<Commande> {
    return this.http.get<Commande>("http://localhost:8888/commande/" + numero);
  }

  create(commande: Commande): void {
    this.http.post<Commande>("http://localhost:8888/commande", commande).subscribe(resp => {
      this.load();
    });
  }

  update(commande: Commande): void {
    this.http.put<Commande>("http://localhost:8888/commande/" + commande.numero, commande).subscribe(resp => {
      console.log('formCommande afterupdate', commande);
      this.load();
      
    });
  }

  remove(numero: number): void {
    this.http.delete<void>("http://localhost:8888/commande/" + numero).subscribe(resp => {
      this.load();
    });
  }

  private load(): void {
    this.http.get<Array<Commande>>("http://localhost:8888/commande").subscribe(resp => {
      this.commandes = resp;
    });
  }

  private loadEtatcommande(): void {
    this.http.get<Array<string>>("http://localhost:8888/etatcommandes").subscribe(resp => {
      resp.forEach(civ => {
        this.etatcommandes.set(civ, civ);
      });
    });
  }

}
