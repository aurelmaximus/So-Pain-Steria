import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from '../auth/auth.service';
import { Basique, Compte, Employe, Produit } from '../model';

@Injectable({
  providedIn: 'root'
})
export class EmployegpHttpService {
  

    employes: Array<Employe> = new Array<Employe>();
    basiques: Array<Basique> = new Array<Basique>();
    
    currentCompte : Compte;

  constructor(private http: HttpClient,private auth: AuthService) {
    this.load();
  }


  findAll(): Array<Employe> {
    return this.employes;
  }

  findAllBasiques(): Array<Basique> {
    

    this.basiques.sort((a, b) => (a.categorie < b.categorie) ? 1 : -1);
  
    return this.basiques;

  }

  findById(id: number): Observable<Basique> {
    return this.http.get<Basique>("http://localhost:8888/basique/" + id);
  }

  create(employe: Basique): void {
    this.http.post<Basique>("http://localhost:8888/basique", employe).subscribe(resp => {
      this.load();
    });
  }

  update(employe: Basique): void {
    this.http.put<Basique>("http://localhost:8888/basique/" + employe.id, employe).subscribe(resp => {
      this.load();
    });
  }

  remove(id: number): void {
    this.http.delete<void>("http://localhost:8888/basique/" + id).subscribe(resp => {
      this.load();
    });
  }

  findByIdEmp(id: number): Observable<Compte> {
    return this.http.get<Compte>("http://localhost:8888/compte/" + id);
  }

  private load(): void {
      this.findByIdEmp(this.auth.connected.id).subscribe(resp => {
      this.currentCompte=resp;
    });

    this.http.get<Array<Basique>>("http://localhost:8888/basique").subscribe(resp => {
      this.basiques = resp;
    });
  }

  

}
