import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DialogModule } from 'primeng/components/dialog/dialog';
import {PanelModule, GrowlModule,  ButtonModule, InputTextModule} from 'primeng/primeng';
import { FormCursoComponent } from './form-curso.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

@NgModule({
  imports: [
    ReactiveFormsModule,
    CommonModule,
    ButtonModule,
    FormsModule,
    InputTextModule,
    FormsModule,
    HttpClientModule
  ],
  declarations: [
    FormCursoComponent
  ],
  exports: [
   FormCursoComponent
  ]
})
export class FormCursoModule { }
