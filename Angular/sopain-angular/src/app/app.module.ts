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
import { CommandeComponent } from './commande/commande.component';
import { AuthComponent } from './auth/auth.component';
import { ClientComponent } from './client/client.component';
import { EmployeGcComponent } from './employe-gc/employe-gc.component';

import { HomeComponent } from './home/home.component';
import { MaisonComponent } from './maison/maison.component';

import { CommandeComponent } from './commande/commande.component';
import { PainComponent } from './pain/pain.component';
import { ViennoiserieComponent } from './viennoiserie/viennoiserie.component';
import { PatisserieComponent } from './patisserie/patisserie.component';



@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    FooterComponent,
    InscriptionComponent,
    HomeComponent,
    MaisonComponent,
    EmployeComponent,
    ClientComponent,
   AuthComponent,
    CommandeComponent
    EmployeGcComponent,
    PainComponent,
    ViennoiserieComponent,
    PatisserieComponent
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
