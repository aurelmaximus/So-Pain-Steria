import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthDTO,Compte } from '../model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  connected: Compte = new Compte();
  idConnected: number;
  utilisateurs:  Array<Compte> = new Array<Compte>();
  role: Array<string>;
  logged: boolean;

  constructor(private http: HttpClient, private router: Router) {
    
    // .subscribe(response => {
    //   this.formStagiaire = response;
     
    // this.connected = sessionStorage.getItem(this.idConnected);
    this.idConnected = parseInt(sessionStorage.getItem('idtemp'));
    this.findById(this.idConnected).subscribe(resp => {
      this.connected=resp;

    
    if(this.connected.id!=0) {
      this.logged=true;
    }
    else this.logged=false;

  })

  }


  login(dto: AuthDTO):void {
    console.log(dto);
    this.http.post<Compte>("http://localhost:8888/compte/auth", dto).subscribe(resp => {
      this.connected = resp;
      console.log(this.connected.nom);
      
      this.logged = true;
      console.log(this.connected.nom + " ID: " + this.connected.id.toString() + " de type " + this.connected.type.slice(1) + " est connecté !!!!");
      sessionStorage.setItem('idtemp', this.connected.id.toString());

      this.router.navigate(['/'+this.connected.type.slice(1).toLowerCase()]);
    })
  }

  logout():void {
    this.connected = new Compte();
    this.logged=false;
    this.idConnected=0;
    sessionStorage.clear();
    this.router.navigate(['/maison']);
  }

  findById(id: number): Observable<Compte> {
    return this.http.get<Compte>("http://localhost:8888/compte/" + id);
  }

  //private load(): void {
  //  this.http.get<Array<Utilisateur>>("http://localhost:8888/utilisateur").subscribe(resp => {
  //    this.utilisateurs = resp;
  //  });
  //}
}
