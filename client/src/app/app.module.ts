import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './core/components/login/login.component';
import { FormsModule } from '@angular/forms';
import { UserService } from './core/services/user-service/user.service';
import { provideHttpClient } from '@angular/common/http';
import { NavbarComponent } from './shared/components/navbar/navbar.component';
import { NavbarService } from './shared/services/navbar-service/navbar.service';
import { HomeComponent } from './core/components/home/home.component';
import { CreateUserComponent } from './core/components/create-user/create-user.component';
import { FirstLoginComponent } from './core/components/first-login/first-login.component';
import { RoomListComponent } from './core/components/room-list/room-list/room-list.component';
import { RequestApiKeyComponent } from './core/components/request-api-key/request-api-key/request-api-key.component';
import { RoomComponent } from './core/components/room/room/room.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavbarComponent,
    HomeComponent,
    CreateUserComponent,
    FirstLoginComponent,
    RoomListComponent,
    RequestApiKeyComponent,
    RoomComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [UserService, provideHttpClient(), NavbarService],
  bootstrap: [AppComponent]
})
export class AppModule { }
