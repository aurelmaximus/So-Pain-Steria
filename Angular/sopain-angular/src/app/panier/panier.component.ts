import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service';
import { ClientHttpService } from '../client/client-http.service';
import { Basique, Client, Produit } from '../model';
import { PanierService } from './panier.service';

@Component({
  selector: 'panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.css']
})
export class PanierComponent {

  client: Client = new Client();
  articles: Array<Produit> = new Array<Produit>();

  constructor(private http: HttpClient, private router: Router, private panierServ: PanierService, private clientServ: ClientHttpService, private authServ: AuthService) {
    this.clientServ.findById(this.authServ.connected.id).subscribe(resp=>{
      this.client =resp;
    });

    this.articles = this.panierServ.getItems();
  }

  isBasique(produit: Produit): boolean{
    return produit instanceof Basique ? true : false;
}

  getTotal():number {
    return this.panierServ.getTotal();
  }



}
