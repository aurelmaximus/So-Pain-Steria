import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientComponent } from './client/client.component';
import { EmployeGcComponent } from './employe-gc/employe-gc.component';
import { AuthComponent } from './auth/auth.component';
import { EmployeComponent } from './employe/employe.component';
import { HomeComponent } from './home/home.component';
import { MaisonComponent } from './maison/maison.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { PainComponent } from './pain/pain.component';
import { PatisserieComponent } from './patisserie/patisserie.component';
import { ViennoiserieComponent } from './viennoiserie/viennoiserie.component';
import { CompteclientComponent } from './compteclient/compteclient.component';
import { NouscontacterComponent } from './nouscontacter/nouscontacter.component';
import { EmployeGpComponent } from './employe-gp/employe-gp.component';


const routes: Routes = [
{path: "client", component: ClientComponent},
{path: "employe", component: EmployeComponent},
{path: "auth", component: AuthComponent},
{path: "", component: HomeComponent, pathMatch: 'full'},
{path: "patisserie", component: PatisserieComponent},
{path: "viennoiserie", component: ViennoiserieComponent},
{path: "employegc", component: EmployeGcComponent},
{path: "pain", component: PainComponent},
{path: "viennoiserie", component: ViennoiserieComponent},
{path: "patisserie", component: PatisserieComponent},
{path: "maison", component: MaisonComponent},
{path: "auth", component: AuthComponent},
{path: "Nous-Contacter", component: NouscontacterComponent},
{path: "compteclient", component: CompteclientComponent},
{path: "employegp", component: EmployeGpComponent},

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }