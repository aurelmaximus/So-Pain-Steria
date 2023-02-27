import { Component } from '@angular/core';
import { AuthService } from '../auth/auth.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent {

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
