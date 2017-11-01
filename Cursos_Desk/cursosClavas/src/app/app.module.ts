
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { FormCursoComponent } from './form-curso/form-curso.component';
import { CursosGridComponent } from './cursos-grid/cursos-grid.component';

@NgModule({
  declarations: [
    AppComponent,
    FormCursoComponent,
    CursosGridComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule

  ],
  providers: [],
  bootstrap: [AppComponent],

})
export class AppModule { }
