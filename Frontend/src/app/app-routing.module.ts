import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: '',
    loadChildren: (): any => import('./start/start.module').then((m: any) => m.StartModule),
    // pathMatch: 'full'
  },
  { path: 'home',
    loadChildren: (): any => import('./home/home.module').then((m: any) => m.HomeModule),
  },
  {
    path: '**',
    redirectTo: ''
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
