import { Component } from '@angular/core';
import { BasiqueService } from '../basique.service';
import { Basique } from '../model';

@Component({
  selector: 'app-patisserie',
  templateUrl: './patisserie.component.html',
  styleUrls: ['./patisserie.component.css']
})
export class PatisserieComponent {

  constructor(private basiqueServ: BasiqueService) {

  }

  list(): Array<Basique> {
    return this.basiqueServ.findAll();
  }
   
}
