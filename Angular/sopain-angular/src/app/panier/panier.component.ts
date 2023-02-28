import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service';
import { ClientHttpService } from '../client/client-http.service';
import { Client } from '../model';

@Component({
  selector: 'panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.css']
})
export class PanierComponent {

  client: Client = new Client();

  constructor(private http: HttpClient, private router: Router, private clientServ: ClientHttpService, private authServ: AuthService) {
    this.clientServ.findById(this.authServ.connected.id).subscribe(resp=>{
      this.client =resp;
    });
  }


}
