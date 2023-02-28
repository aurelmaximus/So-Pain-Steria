import { Component } from '@angular/core';
import { BasiqueService } from '../basique.service';
import { Basique } from '../model';

@Component({
  selector: 'app-patisserie',
  templateUrl: './patisserie.component.html',
  styleUrls: ['./patisserie.component.css']
})
export class PatisserieComponent {

  patisseries: Array<Basique> = new Array<Basique>();
  pat: Basique = new Basique();

  constructor(private basiqueServ: BasiqueService) {
    this.findPatisseries();
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


   
}
