import { Component } from '@angular/core';
import { ClientHttpService } from '../client/client-http.service';

@Component({
  selector: 'panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.css']
})
export class PanierComponent {

  constructor(private clientServ: ClientHttpService) {
    
  }

}
