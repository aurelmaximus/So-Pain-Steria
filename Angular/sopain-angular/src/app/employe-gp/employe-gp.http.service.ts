import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from '../auth/auth.service';
import { Basique, Employe, Produit } from '../model';

@Injectable({
  providedIn: 'root'
})
export class EmployegpHttpService {
  

    employes: Array<Employe> = new Array<Employe>();
    basiques: Array<Basique> = new Array<Basique>();
    currentEmploye : Employe;

  constructor(private http: HttpClient) {
    this.load();
  }


  findAll(): Array<Employe> {
    return this.employes;
  }

  findAllBasiques(): Array<Basique> {
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

  private load(): void {
    this.http.get<Array<Employe>>("http://localhost:8888/employe").subscribe(resp => {
      this.employes = resp;
    });

    this.http.get<Array<Basique>>("http://localhost:8888/basique").subscribe(resp => {
      this.basiques = resp;
    });
  }

}
