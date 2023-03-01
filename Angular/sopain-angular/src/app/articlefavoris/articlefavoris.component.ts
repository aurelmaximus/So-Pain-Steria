import { Component } from '@angular/core';
import { BasiqueService } from '../basique.service';
import { Basique } from '../model';
import { PanierService } from '../panier/panier.service';

@Component({
  selector: 'app-articlefavoris',
  templateUrl: './articlefavoris.component.html',
  styleUrls: ['./articlefavoris.component.css']
})
export class ArticlefavorisComponent {

  patisseries: Array<Basique> = new Array<Basique>();
  pat: Basique = new Basique();

  viens: Array<Basique> = new Array<Basique>();
  vien: Basique = new Basique();

  pains: Array<Basique> = new Array<Basique>();
  pain: Basique = new Basique();


  constructor(private basiqueServ: BasiqueService, private panierServ: PanierService,private basiqueService: BasiqueService) {
    this.findPatisseries();
    this.findViens();
    this.findPains();
  }

  list(): Array<Basique> {
    return this.basiqueServ.findAll();
  }

  findPatisseries(): void {
    this.basiqueServ.findByCat('gateau').subscribe(resp => {
      this.patisseries = resp;
    });
  }

  findPatByLib(lib: string) {
    this.basiqueServ.findByLib(lib).subscribe(response => {
      this.pat = response;
    });
  }

  addToCart(bas: Basique) {
    this.panierServ.addToCart(bas);
    window.alert(bas.libelle + ' a été ajouté au panier!');
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

  findPains(): void {
    this.basiqueService.findByCat('pain').subscribe(resp => {
      this.pains = resp;
    });
  }

  findPainByLib(lib: string) {
    this.basiqueService.findByLib(lib).subscribe(response => {
      this.pain = response;
    });
  }
  
}
