import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { BasiqueService } from '../basique.service';
import { Basique } from '../model';

@Component({
  selector: 'app-pain',
  templateUrl: './pain.component.html',
  styleUrls: ['./pain.component.css']
})
export class PainComponent {
  libelle:string;
  prix:number;

  constructor(private basiqueService: BasiqueService)  { }



}
