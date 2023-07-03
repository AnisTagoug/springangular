import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './header/header.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { AuthGuard } from './_auth/auth.guard';
import { AuthInterceptor } from './_auth/auth.interceptor';
import { UserService } from './_services/user.service';
import {OAuthModule} from "angular-oauth2-oidc";
import { NavbarAdminComponent } from './navbar-admin/navbar-admin.component';
import { UserTableComponent } from './GestionUsers/user-table/user-table.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { AddUserComponent } from './GestionUsers/add-user/add-user.component';
import {Ng2SearchPipeModule} from "ng2-search-filter";
import {OrderModule} from "ngx-order-pipe";
import { ErrorsComponent } from './errors/errors.component';
import { NgToastModule } from 'ng-angular-popup';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AdminComponent,
    UserComponent,
    LoginComponent,
    HeaderComponent,
    ForbiddenComponent,
    NavbarAdminComponent,
    UserTableComponent,
    AddUserComponent,
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        HttpClientModule,
        RouterModule,
        ReactiveFormsModule,
       Ng2SearchPipeModule,
      OrderModule,
      NgToastModule

    ],
  providers: [
    AuthGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass:AuthInterceptor,
      multi:true
    },
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
