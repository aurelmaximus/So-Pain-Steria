import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service';
import { ClientHttpService } from '../client/client-http.service';

@Injectable({
  providedIn: 'root'
})
export class PanierService {


  constructor(private http: HttpClient, private router: Router, private clientServ: ClientHttpService, private authServ: AuthService) { 


  }
}
