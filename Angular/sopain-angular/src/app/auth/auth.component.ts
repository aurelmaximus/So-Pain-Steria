import { Component } from '@angular/core';
import { AuthDTO, Compte } from '../model';
import { AuthService } from './auth.service';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent {

  connectedDTO: AuthDTO = new AuthDTO();

  constructor(private authService: AuthService){

  }

  getConnected():Compte {
    return this.authService.connected
  }

  seconnecter(): void {

    this.authService.login(this.connectedDTO);
    //this.reloadPage();
  }

  reloadPage() {
    setTimeout(()=>{
      window.location.reload();
    }, 100);
}

}
