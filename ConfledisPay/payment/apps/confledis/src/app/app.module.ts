import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Routes } from '@angular/router';

import { AppComponent } from './app.component';

@NgModule({
  declarations: [AppComponent],

  imports: [BrowserModule],
  providers: [],
  bootstrap: [AppComponent],
})
// decl.d.ts
declare module 'mfe1/Module';
export class AppModule {}
export const APP_ROUTES: Routes = [
  {
    path: '',
    component: AppComponent,
    pathMatch: 'full'
  },
  
  {
    path: 'Payment',
    loadChildren: () => import('mfe1/Module').then(m => m.FlightsModule)
  },
];
