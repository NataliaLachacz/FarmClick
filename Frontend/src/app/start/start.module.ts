import { NgModule } from '@angular/core';

import { StartRoutingModule } from './start-routing.module';


import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { StartComponent } from './start.component';

@NgModule({
    imports: [StartRoutingModule, StartComponent, LoginComponent, RegisterComponent]
})

export class StartModule {}
