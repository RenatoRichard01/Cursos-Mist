import { PesquisaComponent } from './pesquisa/pesquisa.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { FormCursoComponent } from './form-curso/form-curso.component';
import { CursosGridComponent } from './cursos-grid/cursos-grid.component';
import { FormCursoModule } from './form-curso/form-curso.module';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    FormCursoComponent,
    CursosGridComponent,
    PesquisaComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormCursoModule
  ],
  providers: [],
  bootstrap: [AppComponent],

})
export class AppModule { }
