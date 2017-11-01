import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'form-curso',
  templateUrl: './form-curso.component.html',
  styleUrls: ['./form-curso.component.css']
})
export class FormCursoComponent implements OnInit {
  id: number;

  descricao: string;
  duracao: string;

  cursos: any = {};

  nomeCurso: string;

  formulario: FormGroup;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get('http://localhost:8080/cursoLista').subscribe
    (data => {
      this.cursos = data;
    });
  }
  resetaForm() {
    this.formulario.reset();
  }

  adicionaCurso(): void {
    this.http.get('http://localhost:8080/cursoAdiciona/' + this.descricao + '/' + this.duracao).subscribe( data => {
      this.cursos = data;
    });
  }
  excluirCurso(id) {
    this.http.delete('http://localhost:8080/cursoDeleta/' + id).subscribe( data => {
      this.cursos = data;
    });
  }
  pesquisarCurso() {
    this.http.get('http://localhost:8080/pesquisarNome/' + this.nomeCurso).subscribe(
      data => {
        this.cursos = data;
      }
    );
  }

}
