import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// import { GameComponent } from './home/_pages/game/game.component';
// import { HomeComponent } from './home/home.component';
// import { LoginComponent } from './start/_pages/login/login.component';
// import { RegisterComponent } from './start/_pages/register/register.component';
// import { SettingsComponent } from './home/_pages/settings/settings.component';
// import { ShopComponent } from './home/_pages/shop/shop.component';
// import { StartComponent } from './start/start.component';

// const homeRoutes: Routes = [{
//   path: '',
//   children: [
//     { path: '', redirectTo: 'game' , pathMatch: 'full'},
//     { path: 'game', component: GameComponent },
//     { path: 'shop', component: ShopComponent },
//     { path: 'settings', component: SettingsComponent }
//   ]
// }];

// const routes: Routes = [
//   { path: '', component: StartComponent },
//   { path: 'login', component: LoginComponent },
//   { path: 'register', component: RegisterComponent },
//   { path: 'home', component: HomeComponent, children: homeRoutes},
// ];

const routes: Routes = [
  { path: '',
    loadChildren: (): any => import('./start/start.module').then((m: any) => m.StartModule),
    pathMatch: 'full'
  },
  { path: 'home',
    loadChildren: (): any => import('./home/home.module').then((m: any) => m.HomeModule),
    pathMatch: 'full'
  },
  {
    path: '**',
    redirectTo: ''
  }
  // { path: 'login', component: LoginComponent },
  // { path: 'register', component: RegisterComponent },
  // { path: 'home', component: HomeComponent, children: homeRoutes},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
