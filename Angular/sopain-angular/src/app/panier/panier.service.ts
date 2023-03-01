import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BasiqueService } from '../basique.service';
import { CommandeHttpService } from '../commande/commande-http.service';
import { CompteclientHttpService } from '../compteclient/compteclient-http.service';
import { LigneCommandeService } from '../ligne-commande.service';
import { Basique, Commande, LigneCommande, Produit } from '../model';

@Injectable({
  providedIn: 'root'
})
export class PanierService {

  panier:Commande = new Commande();

  constructor(private http: HttpClient, private router: Router, private compteClientServ: CompteclientHttpService, private basiqueServ: BasiqueService, private ligneCoServ: LigneCommandeService, private commServ: CommandeHttpService) { 

    if (this.panier.client==null) {
      this.panier.etatcommande="Panier";
      this.panier.client=this.compteClientServ.currentclient;
      this.panier.lignesCommande = new Array<LigneCommande>();
      this.createPanier(this.panier);
    }
    else this.load();

  }

  addToCart(produit: Produit) {

    if (this.isSameProductInPanier(produit)[0]==0) {

      this.basiqueServ.findById(produit.id).subscribe(response => {
        let ligneCo:LigneCommande = new LigneCommande();
        ligneCo.produit=produit;
        this.panier.lignesCommande.push(ligneCo);
        this.commServ.update(this.panier);
        //this.ligneCoServ.create(lc);

  });}
    else {
      let pos =this.isSameProductInPanier(produit)[1];
      this.panier.lignesCommande[pos].qte++;
    }

}

isSameProductInPanier(produit: Produit):number[] {
  let count:number=0;
  let pos:number=-1;
  if(this.panier.lignesCommande.length >0){ 
  this.panier.lignesCommande.forEach( (ligne) => {
  if (ligne.produit===produit) {
    count++;
  }
  pos++;
});}

  return [count,pos];
}

  getItems() {
    return this.panier;
  }

  getTotal():number {
    let tot:number=0;

    if (this.panier.lignesCommande.length>0) {

      this.panier.lignesCommande.forEach( (ligne) => {

      tot+=ligne.produit.prix * ligne.qte;
      ligne.total=tot;
      this.commServ.update(this.panier);

      //this.ligneCoServ.update(ligne);
    });}

    
 
    return tot;
  }

  clearCart() {
    this.panier.lignesCommande =[];
    return this.panier;
  }

  private load(): void {
    this.panier = this.commServ.findPanierClient(this.compteClientServ.currentclient)[0];
  }
  
  //create(panier: Commande): void {
   // this.http.post<Commande>("http://localhost:8888/commande", panier).subscribe(resp => {
    //  this.load();
   // });

  createPanier(panier: Commande): void {
    this.http.post<Commande>("http://localhost:8888/commande", panier).subscribe(resp => {
      this.panier=resp;
      this.panier.lignesCommande=new Array<LigneCommande>();
    });
}
}
