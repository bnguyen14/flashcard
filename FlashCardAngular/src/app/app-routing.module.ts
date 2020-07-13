import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { LogoutComponent } from './logout/logout.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { RegisterComponent } from './register/register.component';
import { ManageCardsComponent } from './manage-cards/manage-cards.component';

const routes: Routes = [
  {path:'', component: LoginComponent},
  {path:'Home', component: HomeComponent},
  {path:'Logout', component: LogoutComponent},
  {path:'Register', component: RegisterComponent},
  {path:'ManageCard', component: ManageCardsComponent},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
