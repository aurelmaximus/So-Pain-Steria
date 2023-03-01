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


  constructor(private articlefavoriservice: ArticleFavorisHttpService, private basiqueServ: BasiqueService, private panierServ: PanierService,private basiqueService: BasiqueService) {  
  }

  list(): Array<Basique> {
    const clientConnecte = this.articlefavoriservice.currentclient;
  
    // Récupérer tous les produits
    const basiques = this.basiqueServ.findAll();
    console.log('Tous les produits:', basiques);
  
    // Filtrer les articles favoris du client connecté
    const articleFavorisClient = this.articlefavoriservice.articlefavoris.filter((articleFavori) => articleFavori.client.id === clientConnecte.id);
    console.log('Articles favoris du client:', articleFavorisClient);
  
    return basiques;
  }


  findAll(): Array<Basique> {
    return this.produits;
  }
  
  addToCart(bas: Basique) {
    this.panierServ.addToCart(bas);
    window.alert(bas.libelle + ' a été ajouté au panier!');
  }

  clientconnecte(): Client {
    return this.articlefavoriservice.currentclient;
  }

}
