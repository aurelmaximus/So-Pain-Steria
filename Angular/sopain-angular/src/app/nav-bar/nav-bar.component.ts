import { Component } from '@angular/core';
import { AuthService } from '../auth/auth.service';
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

  constructor(private authServ: AuthService){

  }

  isConnected(): boolean {
    return this.authServ.logged;
  
  }

  unConnect(): void{
    this.authServ.logout();

  }

  getAuthServ(): AuthService {
      return this.authServ;
  }
}
