import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './core/components/login/login.component';
import { UserListComponent } from './core/components/user-list/user-list.component';
import { UserFormComponent } from './core/components/user-form/user-form.component';
import { HomeComponent } from './core/components/home/home.component';
import { loggedInGuard } from './shared/route-guards/logged-in-guard/logged-in.guard';
import { CreateUserComponent } from './core/components/create-user/create-user.component';
import { adminGuard } from './shared/route-guards/admin-guard/admin.guard';
import { FirstLoginComponent } from './core/components/first-login/first-login.component';
import { firstLoginGuard } from './shared/route-guards/first-login-guard/first-login.guard';
import { RoomListComponent } from './core/components/room-list/room-list/room-list.component';
import { RequestApiKeyComponent } from './core/components/request-api-key/request-api-key/request-api-key.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'home', component: HomeComponent, canActivate: [loggedInGuard] },
  { path: 'users', component: UserListComponent },
  { path: 'adduser', component: UserFormComponent },
  { path: 'register', component: CreateUserComponent, canActivate: [adminGuard] },
  { path: 'first-login', component: FirstLoginComponent, canActivate: [firstLoginGuard] },
  { path: 'rooms', component: RoomListComponent, canActivate: [loggedInGuard] },
  { path: 'apikey', component: RequestApiKeyComponent, canActivate: [adminGuard] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
