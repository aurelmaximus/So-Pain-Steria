import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Basique } from './model';

@Injectable({
  providedIn: 'root'
})
export class BasiqueService {

  basiques: Array<Basique> = new Array<Basique>();


  constructor(private http: HttpClient) {
    this.load();
  }

  findAll(): Array<Basique> {
    return this.basiques;
  }


  findById(id: number): Observable<Basique> {
    return this.http.get<Basique>("http://localhost:8888/basique/" + id);
  }

  findByCat(cat: string): Observable<Array<Basique>> {
    return this.http.get<Array<Basique>>("http://localhost:8888/basique/categorie" + cat);
  }

  findByLib(libelle: string): Observable<Basique> {
    return this.http.get<Basique>("http://localhost:8888/basique/libelle" + libelle);
  }

  create(basique: Basique): void {
    this.http.post<Basique>("http://localhost:8888/basique", basique).subscribe(resp => {
      this.load();
    });
  }

  update(basique: Basique): void {
    this.http.put<Basique>("http://localhost:8888/basique/" + basique.id, basique).subscribe(resp => {
      this.load();
    });
  }

  remove(id: number): void {
    this.http.delete<void>("http://localhost:8888/basique/" + id).subscribe(resp => {
      this.load();
    });
  }

  private load(): void {
    this.http.get<Array<Basique>>("http://localhost:8888/basique").subscribe(resp => {
      this.basiques = resp;
    });
  }

}
