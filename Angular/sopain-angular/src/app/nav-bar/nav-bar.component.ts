import { Component } from '@angular/core';
import { AuthService } from '../auth/auth.service';
import { CompteclientHttpService } from '../compteclient/compteclient-http.service';


@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent {
thathome : boolean = true;
thatclient : boolean = false;
thatemploye : boolean =false;

  constructor(private authServ: AuthService ){

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
