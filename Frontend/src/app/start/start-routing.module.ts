import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';

import { StartComponent } from './start.component';
import { LoginComponent } from './_pages/login/login.component';
import { RegisterComponent } from './_pages/register/register.component';

const routes: Routes = [
    {
        path: '',
        component: StartComponent,
    },
    {
      path: 'login',
      component: LoginComponent
    },
    {
      path: 'register',
      component: RegisterComponent
    },
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
})
export class StartRoutingModule {}