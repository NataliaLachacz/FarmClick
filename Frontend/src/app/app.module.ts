import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AppRoutingModule } from './components/app/app-routing.module';
import { AppComponent } from './components/app/app.component';
import { HomeComponent } from './components/home/home.component';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { GameComponent } from './components/game/game.component';

import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { CounterService } from './services/counter.service';

const appRoutes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'game', component: GameComponent },
  { path: '', redirectTo: '/game', pathMatch: 'full' },
  { path: '**', component: GameComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    RegisterComponent,
    LoginComponent,
    NavbarComponent,
    FooterComponent,
    GameComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FontAwesomeModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [CounterService],
  bootstrap: [AppComponent]
})
export class AppModule {}
