import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeGcComponent } from './employe-gc/employe-gc.component';
import { EmployeComponent } from './employe/employe.component';
import { HomeComponent } from './home/home.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { PainComponent } from './pain/pain.component';
import { PatisserieComponent } from './patisserie/patisserie.component';
import { ViennoiserieComponent } from './viennoiserie/viennoiserie.component';

const routes: Routes = [
{path: "employe", component: EmployeComponent},
{path: "employegc", component: EmployeGcComponent},
{path: "", component: HomeComponent, pathMatch: 'full'},
{path: "pain", component: PainComponent},
{path: "viennoiserie", component: ViennoiserieComponent},
{path: "patisserie", component: PatisserieComponent},


];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
