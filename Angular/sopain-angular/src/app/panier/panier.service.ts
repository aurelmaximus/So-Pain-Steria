import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
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
  lignes: Array<LigneCommande> = new Array<LigneCommande>();

  constructor(private http: HttpClient, private router: Router, private basiqueServ: BasiqueService, private ligneCoServ: LigneCommandeService, private commServ: CommandeHttpService) { 
  }




  addToCart(produit: Produit, quantite:number) {


    let ligneCo:LigneCommande = new LigneCommande();
    

    if (this.isSameProductInPanier(produit)[0]==0) {

        ligneCo.commande=this.panier;
        ligneCo.qte=quantite;
        
        this.basiqueServ.findById(produit.id).subscribe(response => {
          ligneCo.produit=response;
          this.ligneCoServ.create(ligneCo);

          this.panier.lignesCommande.push(ligneCo);
          //this.updatePanier(this.panier);
          this.findByIdWithLignes(this.panier.numero).subscribe(response => {   //Récupère le panier avec les LigneCommande
            this.panier=response;
            
           //console.log("Taille du panier : " + this.panier.lignesCommande.length);
            console.log("Nouvel article ajouté : " + ligneCo.produit.libelle);
  
          });

         
  });}
    // Si produit déjà présent
    else {
      let pos =this.isSameProductInPanier(produit)[1]; // Récupère la position de la LigneCommande ayant le même produit

      // Récupère la LigneCommande en base
        this.ligneCoServ.findById(this.panier.lignesCommande[pos].id).subscribe(response => {
        ligneCo=response;
        ligneCo.qte=this.panier.lignesCommande[pos].qte + quantite; // Ajoute la quantité pour la LigneCommande    
                     
        this.ligneCoServ.update(ligneCo);                           // Mise à jour de la LigneCommande
  
        this.panier.lignesCommande[pos]=ligneCo;
          //this.updatePanier(this.panier);
        this.findByIdWithLignes(this.panier.numero).subscribe(response => { //Récupère le panier avec les LigneCommande
          this.panier=response;
  
          //this.panier.lignesCommande.push(ligneCo);
          //console.log("Taille du panier : " + this.panier.lignesCommande.length)
          console.log("Quantité de " + ligneCo.produit.libelle + " dans le panier: " + this.panier.lignesCommande[pos].qte);
          //this.updatePanier(this.panier);
          //this.panier.lignesCommande[pos].qte++;
      
  
    });
 
  
    });

 }

  this.updatePanier(this.panier);
  this.ligneCoServ.findAllByCommandeId(this.panier.numero).subscribe(resp=>{
    this.lignes=resp;
  });
    

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
      ligne.total=0;
      tot+=ligne.produit.prix*ligne.qte;
      ligne.total+=tot;
      //this.commServ.update(this.panier);

      //this.ligneCoServ.update(ligne);
    });}

    this.updatePanier(this.panier);  
    return tot;
  }

  clearCart() {
    this.panier.lignesCommande =[];
    return this.panier;
  }

  //private load(): void {
  //  this.panier = this.commServ.findPanierClient(this.compteClientServ.currentclient)[0];
  //}
  
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

  
  updatePanier(commande: Commande): void {
    this.http.put<Commande>("http://localhost:8888/commande/" + commande.numero, commande).subscribe(resp => {
      console.log('Panier mis à jour', commande);
      this.panier=resp;
      
    });
  }

  //init(){
  //  if(this.panier.lignesCommande==null || this.panier.lignesCommande==undefined) {
  //     this.panier.etatcommande="Panier";
  //     this.panier.client=this.compteClientServ.currentclient;
  //     //this.panier.lignesCommande = new Array<LigneCommande>();
  //     this.createPanier(this.panier);
  //   }
  //   else this.load();
  // }

  findByIdWithLignes(numero: number): Observable<Commande> {
    return this.http.get<Commande>("http://localhost:8888/commande/lignes/" + numero);
  }


  findPanierByIdClientOrCreate(idClient: number):  Observable<Commande> {
    return this.http.get<Commande>("http://localhost:8888/commande/panier/" + idClient);
  }
}

