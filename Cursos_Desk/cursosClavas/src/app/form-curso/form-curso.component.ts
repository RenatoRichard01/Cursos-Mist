import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'form-curso',
  templateUrl: './form-curso.component.html',
  styleUrls: ['./form-curso.component.css']
})
export class FormCursoComponent implements OnInit {
//a comentar...
  @Output() clavasEvent = new EventEmitter();

  nome: string;
  duracao: string;
  nomeCurso: string;

  formulario: FormGroup;

  constructor(private http: HttpClient) { }

  ngOnInit() { }

  resetaForm() {
    this.formulario.reset();
  }

  adicionaCurso(): void {
    const cursoAdd = {
      nome: this.nome,
      duracao: this.duracao
    };
    if ((this.nome !== undefined) && (this.duracao !== undefined)) {
      this.http.post('http://localhost:8080/novoCurso', cursoAdd).subscribe(
       data => {
        this.clavasEvent.emit(data);
       }
      );
      alert('curso: ' + this.nome + 'Adicionado com sucesso');
      this.nome = '';
      this.duracao = '';
    } else {
      this.nome = '';
      this.duracao = '';
      alert('Existem campos vazios!');
    }
  }

}
