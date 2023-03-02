import { Component } from '@angular/core';
import { BasiqueService } from '../basique.service';
import { ArticleFavori, Basique, Client } from '../model';
import { PanierService } from '../panier/panier.service';
import { ArticleFavorisHttpService } from './articlefavorishttp.service';

@Component({
  selector: 'app-articlefavoris',
  templateUrl: './articlefavoris.component.html',
  styleUrls: ['./articlefavoris.component.css']
})
export class ArticlefavorisComponent {

  produits: Array<Basique> = new Array<Basique>();
  favoris: boolean = false;


  constructor(private articlefavoriservice: ArticleFavorisHttpService, private panierServ: PanierService,private basiqueService: BasiqueService) {  
  }
  
  listfavoris(): Array<Basique> {
    const clientConnecte = this.articlefavoriservice.currentclient;
  
    // Récupérer tous les produits
    const basiques: Array<Basique> = this.basiqueService.findAll();
    console.log('Tous les produits:', basiques);
  
    // Filtrer les articles favoris du client connecté
    // this.articlefavoriservice.articlefavoris
    let articleFavoris = new Array<Basique>();
    
    const articleFavorisClient = this.articlefavoriservice.articlefavoris.filter((articleFavori: ArticleFavori) => articleFavori.client.id === clientConnecte.id);
    for(let fav of articleFavorisClient) {
      
      articleFavoris.push(basiques.find((article: Basique) => article.id === fav.basique.id))
    }
    console.log('Articles favoris du client:', articleFavoris);
  
  
    return articleFavoris;
  }

  listarticlefavoris(): Array<ArticleFavori> {
   
    const client = this.clientconnecte();
 
    const articlesFavoris = client?.id ? this.articlefavoriservice.findAll() : [];
  
    return articlesFavoris;
}

  findAll(): Array<Basique> {
    return this.produits;
  }
  
  addToCart(bas: Basique, qte:number) {
    this.panierServ.addToCart(bas, qte);
    window.alert(bas.libelle + ' a été ajouté au panier!');
  }

  clientconnecte(): Client {
    return this.articlefavoriservice.currentclient;
  }

}
