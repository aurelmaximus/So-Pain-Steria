import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from '../auth/auth.service';
import { Employe } from '../model';

@Injectable({
  providedIn: 'root'
})
export class EmployegcHttpService {
  

    employes: Array<Employe> = new Array<Employe>();
    currentEmploye : Employe;

  constructor(private http: HttpClient, private auth: AuthService) {
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

  findByIdEmp(id: number): Observable<Employe> {
    return this.http.get<Employe>("http://localhost:8888/employe/" + id);
  }

  private load(): void {
    this.findByIdEmp(this.auth.connected.id).subscribe(resp => {
      this.currentEmploye=resp;
    });

    this.http.get<Array<Employe>>("http://localhost:8888/employe").subscribe(resp => {
      this.employes = resp;
    });
  }

}
