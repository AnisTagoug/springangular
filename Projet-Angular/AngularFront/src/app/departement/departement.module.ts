import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DepartementRoutingModule } from './departement-routing.module';
import { ListComponent } from './list/list.component';
import { FormsModule } from '@angular/forms';
import { UpdateComponent } from './update/update.component';
import { ErrorsComponent } from '../errors/errors.component';


@NgModule({
  declarations: [
    ListComponent,
    UpdateComponent,

  ],
  imports: [
    CommonModule,
    DepartementRoutingModule,
    FormsModule,

  ]
})
export class DepartementModule { }
