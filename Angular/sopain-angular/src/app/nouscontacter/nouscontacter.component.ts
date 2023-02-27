import { Component } from '@angular/core';

@Component({
  selector: 'app-nouscontacter',
  templateUrl: './nouscontacter.component.html',
  styleUrls: ['./nouscontacter.component.css']
})
export class NouscontacterComponent {
  env : boolean=true;
  env1 : boolean=false;


envoyer(){

  this.env=false;
  this.env1=true;
  setTimeout(function(){window.location.replace("http://localhost:4200/")},3000);

}
}
