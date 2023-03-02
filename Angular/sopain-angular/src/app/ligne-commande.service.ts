import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LigneCommande } from './model';

@Injectable({
  providedIn: 'root'
})
export class LigneCommandeService {

  ligneCommandes: Array<LigneCommande> = new Array<LigneCommande>();

  constructor(private http: HttpClient) {
    //this.load();

   }

   findById(id: number): Observable<LigneCommande> {
    return this.http.get<LigneCommande>("http://localhost:8888/lignecommande/" + id);
  }

  findAllByCommandeId(idCommande: number) : Observable<Array<LigneCommande>> {
    return this.http.get<Array<LigneCommande>>("http://localhost:8888/lignecommande/commande/" + idCommande);
}


  create(ligneCo: LigneCommande): void {
    this.http.post<LigneCommande>("http://localhost:8888/lignecommande", ligneCo).subscribe(resp => {
      this.load();
    });
  }

  update(ligneCo: LigneCommande): void {
    this.http.put<LigneCommande>("http://localhost:8888/lignecommande/" + ligneCo.id, ligneCo).subscribe(resp => {
    this.load();
      
    });
  }

  remove(id: number): void {
    this.http.delete<void>("http://localhost:8888/lignecommande/" + id).subscribe(resp => {
      this.load();
    });
  }

    private load(): void{
    this.http.get<Array<LigneCommande>>("http://localhost:8888/lignecommande").subscribe(resp => {
      this.ligneCommandes = resp;
    });
}
}
