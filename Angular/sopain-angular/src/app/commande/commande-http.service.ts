import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client, Commande } from '../model';

@Injectable({
  providedIn: 'root'
})
export class CommandeHttpService {

    commandes: Array<Commande> = new Array<Commande>();
    etatcommandes: Map<string, string> = new Map<string,string>();
  
    constructor(private http: HttpClient) {
    this.load();
  }

  findAll(): Array<Commande> {
    return this.commandes;
  }

  findAllPasTermine(): Array<Commande> {
    return this.commandes
      .filter(commande => commande.etatcommande === 'EnCours' || commande.etatcommande === 'Prete')
      .sort((a, b) => {
        const dateA = new Date(`${a.dateArrivee} ${a.heureArrive}`);
        const dateB = new Date(`${b.dateArrivee} ${b.heureArrive}`);
        if (a.etatcommande === 'EnCours' && b.etatcommande === 'Prete') {
          return -1;
        } else if (a.etatcommande === 'Prete' && b.etatcommande === 'EnCours') {
          return 1;
        } else {
          return dateA.getTime() - dateB.getTime();
        }
      });
  }

  findAllTermine(): Array<Commande> {
    return this.commandes
      .filter(commande => commande.etatcommande === 'Termine')
      .sort((a, b) => {
        const dateA = new Date(`${a.dateArrivee} ${a.heureArrive}`);
        const dateB = new Date(`${b.dateArrivee} ${b.heureArrive}`);
        return dateB.getTime() - dateA.getTime();
      });
  }

  findAllclientEncours(client: Client): Array<Commande> {
    return this.commandes
      .filter(commande => commande.client.id === client.id && (commande.etatcommande === 'EnCours' || commande.etatcommande === 'Prete'))
      .sort((a, b) => {
        const dateA = new Date(`${a.dateArrivee} ${a.heureArrive}`);
        const dateB = new Date(`${b.dateArrivee} ${b.heureArrive}`);
        if (a.etatcommande === 'EnCours'  && b.etatcommande === 'Prete') {
          return -1;
        } else if (a.etatcommande === 'Prete' && b.etatcommande === 'EnCours' ) {
          return 1;
        } else {
          return dateA.getTime() - dateB.getTime();
        }
      });
  }
  
  findAllclienttermine(client: Client): Array<Commande> {
    return this.commandes
      .filter(commande => commande.client.id === client.id && (commande.etatcommande === 'Termine'))
      .sort((a, b) => {
        const dateA = new Date(`${a.dateArrivee} ${a.heureArrive}`);
        const dateB = new Date(`${b.dateArrivee} ${b.heureArrive}`);
        if (a.etatcommande === 'EnCours' && b.etatcommande === 'Prete') {
          return -1;
        } else if (a.etatcommande === 'Prete' && b.etatcommande === 'EnCours') {
          return 1;
        } else {
          return dateA.getTime() - dateB.getTime();
        }
      });
  }

  findById(numero: number): Observable<Commande> {
    return this.http.get<Commande>("http://localhost:8888/commande/" + numero);
  }

  findByIdWithLignes(numero: number): Observable<Commande> {
    return this.http.get<Commande>("http://localhost:8888/commande/lignes" + numero);
  }


  create(commande: Commande): void {
    this.http.post<Commande>("http://localhost:8888/commande", commande).subscribe(resp => {
      this.load();
      commande=resp;
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

  findPanierClient(cli: Client): Array<Commande> {
    return this.commandes
      .filter(commande => commande.client.id === cli.id && (commande.etatcommande === 'Panier'));
  }



}
