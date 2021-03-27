import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { GameComponent } from './components/game/game.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { SettingsComponent } from './components/settings/settings.component';
import { ShopComponent } from './components/shop/shop.component';
import { StartComponent } from './components/start/start.component';

const homeRoutes: Routes = [{
  path: '',
  children: [
    { path: '', redirectTo: 'game' , pathMatch: 'full'},
    { path: 'game', component: GameComponent },
    { path: 'shop', component: ShopComponent },
    { path: 'settings', component: SettingsComponent }
  ]
}];

const routes: Routes = [
  { path: '', component: StartComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'home', component: HomeComponent, children: homeRoutes},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
