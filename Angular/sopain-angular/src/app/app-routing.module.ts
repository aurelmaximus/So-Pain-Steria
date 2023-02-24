import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeComponent } from './employe/employe.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
{path: "employe", component: EmployeComponent},
{path: "", component: HomeComponent, pathMatch: 'full'}


];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
