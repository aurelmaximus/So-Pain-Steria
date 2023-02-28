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
  pains: Array<Basique> = new Array<Basique>();
  pain: Basique = new Basique();

  constructor(private basiqueService: BasiqueService)  { 
  this.findPains();
  }

  list(): Array<Basique> {
    return this.basiqueService.findAll();
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

