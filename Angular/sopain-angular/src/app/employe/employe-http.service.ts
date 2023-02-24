import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employe } from '../model';

@Injectable({
  providedIn: 'root'
})
export class EmployeHttpService {

    employes: Array<Employe> = new Array<Employe>();

  constructor(private http: HttpClient) {
    this.load();
  }


  findAll(): Array<Employe> {
    return this.employes;
  }

  findById(id: number): Observable<Employe> {
    return this.http.get<Employe>("http://localhost:8888/employe/" + id);
  }

  create(employe: Employe): void {
    this.http.post<Employe>("http://localhost:8888/employe", employe).subscribe(resp => {
      this.load();
    });
  }

  update(employe: Employe): void {
    this.http.put<Employe>("http://localhost:8888/employe/" + employe.id, employe).subscribe(resp => {
      this.load();
    });
  }

  remove(id: number): void {
    this.http.delete<void>("http://localhost:8888/employe/" + id).subscribe(resp => {
      this.load();
    });
  }

  private load(): void {
    this.http.get<Array<Employe>>("http://localhost:8888/employe").subscribe(resp => {
      this.employes = resp;
    });
  }

}