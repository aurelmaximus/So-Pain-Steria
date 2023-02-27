import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { AuthDTO,Compte } from '../model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  connected: Compte = new Compte();
  idConnected: string;
  utilisateurs:  Array<Compte> = new Array<Compte>();
  role: Array<string>;
  logged: boolean;

  constructor(private http: HttpClient, private router: Router) {
    
    
    if(this.connected.email) {
      this.logged=true;
    }
    else this.logged=false;

  }


  login(dto: AuthDTO):void {
    console.log(dto);
    this.http.post<Compte>("http://localhost:8888/compte/auth", dto).subscribe(resp => {
      this.connected = resp;
      console.log(this.connected.nom);
      
      this.logged = true;
      console.log(this.connected.nom + " ID: " + this.connected.id.toString() + " de type " + this.connected.type.slice(1) + " est connecté !!!!");
      sessionStorage.setItem(this.idConnected, this.connected.id.toString());

      this.router.navigate(['/'+this.connected.type.slice(1).toLowerCase()]);
    })
  }

  logout():void {
    this.connected = new Compte();
    this.logged=false;
    this.router.navigate(['']);
  }
  //private load(): void {
  //  this.http.get<Array<Utilisateur>>("http://localhost:8888/utilisateur").subscribe(resp => {
  //    this.utilisateurs = resp;
  //  });
  //}
}
