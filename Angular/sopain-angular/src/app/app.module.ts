import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { FooterComponent } from './footer/footer.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { EmployeComponent } from './employe/employe.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AuthComponent } from './auth/auth.component';
<<<<<<< HEAD
import { HomeComponent } from './home/home.component';
import { MaisonComponent } from './maison/maison.component';
=======
import { CommandeComponent } from './commande/commande.component';
>>>>>>> develop

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    FooterComponent,
    InscriptionComponent,
    HomeComponent,
    MaisonComponent,
    EmployeComponent,
<<<<<<< HEAD
=======
    AuthComponent,
    CommandeComponent
>>>>>>> develop
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
