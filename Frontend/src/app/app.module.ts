import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from '../app/app-routing.module';
import { SharedModule } from './_shared/shared.module';

import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,

    SharedModule
  ],
  // providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule {}
