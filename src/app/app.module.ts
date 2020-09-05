import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { JwtclientService  } from './jwtclient.service';
import { SecurityComponent } from './security/security.component';

@NgModule({
  declarations: [
    AppComponent,
    SecurityComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
