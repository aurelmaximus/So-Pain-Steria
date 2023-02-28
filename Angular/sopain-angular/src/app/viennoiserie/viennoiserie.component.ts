import { Component } from '@angular/core';
import { BasiqueService } from '../basique.service';
import { Basique, Produit } from '../model';
import { PanierService } from '../panier/panier.service';

@Component({
  selector: 'app-viennoiserie',
  templateUrl: './viennoiserie.component.html',
  styleUrls: ['./viennoiserie.component.css']
})
export class ViennoiserieComponent {

  viens: Array<Basique> = new Array<Basique>();
  vien: Basique = new Basique();

  constructor(private basiqueService: BasiqueService, private panierServ: PanierService)  { 
  this.findViens();
  }

  list(): Array<Basique> {
    return this.basiqueService.findAll();
  }

  findViens(): void {
    this.basiqueService.findByCat('viennoiserie').subscribe(resp => {
      this.viens = resp;
    });
  }

  findVienByLib(lib: string) {
    this.basiqueService.findByLib(lib).subscribe(response => {
      this.vien = response;
    });
  }

  addToCart(bas: Basique) {
    this.panierServ.addToCart(bas);
    window.alert(bas.libelle + ' a été ajouté au panier!');
  }
   
}


