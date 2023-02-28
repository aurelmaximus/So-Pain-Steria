import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service';
import { BasiqueService } from '../basique.service';
import { ClientHttpService } from '../client/client-http.service';
import { Basique, Produit } from '../model';

@Injectable({
  providedIn: 'root'
})
export class PanierService {

  articles: Array<Produit> = new Array<Produit>();
  //total:number = 0;

  constructor(private http: HttpClient, private router: Router, private clientServ: ClientHttpService, private authServ: AuthService, private basiqueServ: BasiqueService) { 


  }

  addToCart(produit: Produit) {

    if(produit instanceof Basique) {
      this.basiqueServ.findById(produit.id).subscribe(response => {
        let bas = response;
        this.articles.push(bas);
      })
      
    }
    else this.articles.push(produit);
    
  }

  getItems() {
    return this.articles;
  }

  getTotal():number {
    let tot:number=0;

    if (this.articles.length>0) {
    this.articles.forEach( (prod) => {
      tot+=prod.prix;
    });}
    
    return tot;
  }

  clearCart() {
    this.articles = [];
    return this.articles;
  }
}
