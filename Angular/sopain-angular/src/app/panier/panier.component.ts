import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service';
import { ClientHttpService } from '../client/client-http.service';
import { CommandeHttpService } from '../commande/commande-http.service';
import { LigneCommandeService } from '../ligne-commande.service';
import { Basique, Client, Commande, Produit } from '../model';
import { PanierService } from './panier.service';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.css']
})
export class PanierComponent {
  showText = false;
  showText2 = false;
  showText3 = false;
  selectedPaymentMethod: string;
  cardNumber: string;

  client: Client = new Client();
  panier:Commande = new Commande();

  constructor(private http: HttpClient, private router: Router, private panierServ: PanierService, private clientServ: ClientHttpService, private authServ: AuthService, private commServ: CommandeHttpService, private ligneCoServ: LigneCommandeService) {
    //this.load();
    this.panier = this.panierServ.getItems();
    }
  toggleText() {
    this.showText = !this.showText;
  } 

  submit() {
    // fonction de traitement de la soumission du formulaire
    this.showText2 = !this.showText2;

  }

  ngOnInit() {
    this.showText2 = true;
  }

  


  isBasique(produit: Produit): boolean{
    return produit instanceof Basique ? true : false;
}

  getTotal():number {
    return this.panierServ.getTotal();
  }

  pay() {
      //ajouter articles aux commandes
      window.location.href = "http://localhost:4200/client"; }

  //  this.clientServ.findById(this.authServ.connected.id).subscribe(resp=>{
  //    this.client =resp;
  //    //this.commServ.findPanierClient(this.client);
  // })

    validate() {
      //ajouter articles aux commandes
      window.location.href = "http://localhost:4200/client";  }

}




