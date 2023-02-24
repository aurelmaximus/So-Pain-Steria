import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthComponent } from './auth/auth.component';
import { EmployeComponent } from './employe/employe.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
{path: "", component: HomeComponent, pathMatch: 'full'}
{path: "employe", component: EmployeComponent},
{path: "auth", component: AuthComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
