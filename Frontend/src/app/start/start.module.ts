import { NgModule } from '@angular/core';

import { StartRoutingModule } from './start-routing.module';
import { SharedModule } from '../_shared/shared.module';

import { LoginComponent } from './_pages/login/login.component';
import { RegisterComponent } from './_pages/register/register.component';
import { StartComponent } from './start.component';

@NgModule({
    declarations: [StartComponent, LoginComponent, RegisterComponent],
    imports: [SharedModule, StartRoutingModule],
})

export class StartModule {}
