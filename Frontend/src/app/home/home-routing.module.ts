import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';

import { SettingsComponent } from './_pages/settings/settings.component';
import { ShopComponent } from './_pages/shop/shop.component';
import { GameComponent } from './_pages/game/game.component';
import { HomeComponent } from './home.component';

const routes: Routes = [
    {
        path: '',
        component: HomeComponent,
        children: [
          {
            path: '',
            component: GameComponent
          },
          {
            path: 'shop',
            component: ShopComponent
          },
          {
            path: 'settings',
            component: SettingsComponent
          }
        ]
    },
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
})
export class HomeRoutingModule {}
