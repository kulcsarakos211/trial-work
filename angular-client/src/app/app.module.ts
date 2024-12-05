import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { provideHttpClient } from '@angular/common/http';
import { AppComponent } from './app.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserService } from './service/user.service';
import { RouterModule } from '@angular/router';
import { UserFormComponent } from './user-form/user-form.component';

@NgModule({
  declarations: [
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    RouterModule,
    UserListComponent,
    AppComponent,
    UserFormComponent
  ],
  providers: [UserService, provideHttpClient()],
  bootstrap: [AppComponent]
})
export class AppModule { }