import { Component } from '@angular/core';
import { BasiqueService } from '../basique.service';

@Component({
  selector: 'app-pain',
  templateUrl: './pain.component.html',
  styleUrls: ['./pain.component.css']
})
export class PainComponent {
  libelle:string;
  prix:number;

  constructor(private basiqueService: BasiqueService)  { }

getBasique(): void {
  this.basiqueService.findByLib(this.libelle).subscribe(data => {
    this.prix = data.prix; 
  });

}
}