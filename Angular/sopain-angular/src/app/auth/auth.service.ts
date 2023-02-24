import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { AuthDTO,Compte } from '../model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  connected: Compte = new Compte();
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
    this.http.post<Compte>("http://localhost:8888/utilisateur/auth", dto).subscribe(resp => {
      this.connected = resp;
      console.log(this.connected.nom);
      this.logged = true;
      this.router.navigate(['/accueil'+this.connected.type_compte]);
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
