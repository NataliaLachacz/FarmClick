import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
// import { HttpClientModule } from '@angular/common/http';
// import { CommonModule } from '@angular/common';
// import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from '../app/app-routing.module';
import { SharedModule } from './_shared/shared.module';

import { AppComponent } from './app.component';
// import { HomeComponent } from './home/home.component';
// import { RegisterComponent } from './start/_pages/register/register.component';
// import { LoginComponent } from './start/_pages/login/login.component';
// import { NavbarComponent } from './home/_components/navbar/navbar.component';
// import { FooterComponent } from './home/_components/footer/footer.component';
// import { GameComponent } from './home/_pages/game/game.component';
// import { ShopComponent } from './home/_pages/shop/shop.component';
// import { StartComponent } from './start/start.component';
// import { SettingsComponent } from './home/_pages/settings/settings.component';

import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
// import { UserService } from './_shared/services/user.service';

@NgModule({
  declarations: [
    AppComponent,
    // HomeComponent,
    // RegisterComponent,
    // LoginComponent,
    // NavbarComponent,
    // FooterComponent,
    // GameComponent,
    // ShopComponent,
    // StartComponent,
    // SettingsComponent
  ],
  imports: [
    AppRoutingModule,
    // CommonModule,
    // HttpClientModule,
    BrowserModule,
    // FormsModule,
    // ReactiveFormsModule,
    // FontAwesomeModule,
    SharedModule
  ],
  // providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule {}
