import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientComponent } from './client/client.component';
import { AuthComponent } from './auth/auth.component';
import { EmployeGcComponent } from './employe-gc/employe-gc.component';
import { EmployeComponent } from './employe/employe.component';
import { HomeComponent } from './home/home.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { PainComponent } from './pain/pain.component';
import { PatisserieComponent } from './patisserie/patisserie.component';
import { ViennoiserieComponent } from './viennoiserie/viennoiserie.component';


const routes: Routes = [
{path: "client", component: ClientComponent},
{path: "employe", component: EmployeComponent},
{path: "auth", component: AuthComponent},
{path: "", component: HomeComponent, pathMatch: 'full'}
{path: "patisserie", component: PatisserieComponent},
{path: "viennoiserie", component: ViennoiserieComponent},
{path: "employegc", component: EmployeGcComponent},
{path: "pain", component: PainComponent},
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
