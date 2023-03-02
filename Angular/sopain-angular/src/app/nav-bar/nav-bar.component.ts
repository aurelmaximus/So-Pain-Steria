import { Component } from '@angular/core';
import { AuthService } from '../auth/auth.service';
import { CompteclientHttpService } from '../compteclient/compteclient-http.service';
import { CompteclientComponent } from '../compteclient/compteclient.component';
import { Client } from '../model';


@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent {
thathome : boolean = true;
thatclient : boolean = false;
thatemploye : boolean =false;
count = 0;

  constructor(private authServ: AuthService , private compteclientService: CompteclientHttpService ){

  }
  
  clientconnecte(): Client {
    return this.compteclientService.currentclient;
  }

  isConnected(): boolean {
    return this.authServ.logged;
  
  }

  isClient(): boolean {
    if(this.authServ.connected.type=="client") {
      return true;
    }
    else return false;
  }

  isEmploye(): boolean {
    if(this.authServ.connected.type=="employe") {
      return true;
    }
    else return false;
  }

  unConnect(): void{
    this.authServ.logout();

  }

  getAuthServ(): AuthService {
      return this.authServ;
  }

}
