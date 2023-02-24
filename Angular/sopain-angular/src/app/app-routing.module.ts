import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthComponent } from './auth/auth.component';
import { EmployeComponent } from './employe/employe.component';
import { HomeComponent } from './home/home.component';
import { MaisonComponent } from './maison/maison.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { PainComponent } from './pain/pain.component';
import { PatisserieComponent } from './patisserie/patisserie.component';
import { ViennoiserieComponent } from './viennoiserie/viennoiserie.component';

const routes: Routes = [
{path: "employe", component: EmployeComponent},
{path: "", component: HomeComponent, pathMatch: 'full'},
{path: "pain", component: PainComponent},
{path: "viennoiserie", component: ViennoiserieComponent},
{path: "patisserie", component: PatisserieComponent},
{path: "maison", component: MaisonComponent},
{path: "auth", component: AuthComponent},

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
