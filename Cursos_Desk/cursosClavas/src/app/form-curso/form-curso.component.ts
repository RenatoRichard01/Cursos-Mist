import { Component, OnInit, Input } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'form-curso',
  templateUrl: './form-curso.component.html',
  styleUrls: ['./form-curso.component.css']
})
export class FormCursoComponent implements OnInit {
  curso: string;
  id: number;

  descricao: string;
  duracao: string;
  listaDeCursos: any = {};
  nomeCurso: string;

  formulario: FormGroup;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get('http://localhost:8080/cursoLista').subscribe
    (data => {
      this.listaDeCursos = data;
    });
  }

  resetaForm() {
    this.formulario.reset();
  }

  adicionaCurso(): void {
    const cursos = {
      descricao: this.curso,
      duracao: this.duracao
    };
    if ((this.curso !== undefined) && (this.duracao !== undefined)) {
      this.http.post('http//localhost:8080/cursoAdiciona/', cursos).subscribe(
       data => {
         this.listaDeCursos = data;
       }
      );
      this.curso = '';
      this.duracao = '';
    } else {
      this.curso = '';
      this.duracao = '';
      alert('Existem campos vazios!');
    }
  }

  excluirCurso(id) {
    this.http.delete('http://localhost:8080/cursoDeleta/' + id).subscribe( data => {
      this.listaDeCursos = data;
    });
  }

  modificarCursos(id, nomeInput, duracaoInput) {
    if ((id !== undefined) && (nomeInput !== '') && (duracaoInput !== '')) {
      const curso = {
        id: id,
        nome: nomeInput,
        duracao: duracaoInput
      };
      this.http.put('http://localhost:8080/alteraCurso', curso)
      .subscribe(
          data => {
            this.listaDeCursos = data;
          }
        );
        alert('id: ' +  id + 'alterado com sucesso');
    } else {
      this.http.get('http://localhost:8080/cursoLista').subscribe
      (data => {
        this.listaDeCursos = data;
      });
      alert(' ERRO ao alterar campos, verifique se não estão vazios');
    }
  }

  pesquisarCurso() {
    this.http.get('http://localhost:8080/pesquisarNome/' + this.nomeCurso).subscribe(
      data => {
        this.listaDeCursos = data;
      }
    );
  }
  validTouched() {
  }
}
