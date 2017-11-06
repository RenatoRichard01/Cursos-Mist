import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
 listaDeCursos: any = {};

    constructor(private http: HttpClient) { }

    ngOnInit(): void {
      this.http.get
      ('http://localhost:8080//cursoLista')
      .subscribe(
        data => {
          this.listaDeCursos = data;
        }
      );
    }
    onAtualizarLista(evento) {
      this.listaDeCursos = evento;
    }
}

