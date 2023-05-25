import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';


import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './home.component';
import { FooterComponent } from './_components/footer/footer.component';
import { NavbarComponent } from './_components/navbar/navbar.component';
import { GameComponent } from './_pages/game/game.component';
import { SettingsComponent } from './_pages/settings/settings.component';
import { ShopComponent } from './_pages/shop/shop.component';

@NgModule({
    imports: [HomeRoutingModule, HomeComponent, NavbarComponent, FooterComponent, GameComponent, ShopComponent, SettingsComponent]
})

export class HomeModule {}
