import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UniversiteRoutingModule } from './universite-routing.module';
import { ListComponent } from './list/list.component';
import { FormsModule } from '@angular/forms';
import { UpdateComponent } from './update/update.component';
import { AppModule } from '../app.module';
import { ErrorsComponent } from '../errors/errors.component';
import { NgToastModule } from 'ng-angular-popup';



@NgModule({
  declarations: [
    ListComponent,
    UpdateComponent,
    ErrorsComponent
  ],
  imports: [
    CommonModule,
    UniversiteRoutingModule,
    FormsModule,
    NgToastModule


  ]
})
export class UniversiteModule { }
