import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service';
import { ClientHttpService } from '../client/client-http.service';
import { Produit } from '../model';

@Injectable({
  providedIn: 'root'
})
export class PanierService {

  items: Array<Produit> = new Array<Produit>();

  constructor(private http: HttpClient, private router: Router, private clientServ: ClientHttpService, private authServ: AuthService) { 


  }

  addToCart(produit: Produit) {
    this.items.push(produit);
  }

  getItems() {
    return this.items;
  }

  clearCart() {
    this.items = [];
    return this.items;
  }
}
