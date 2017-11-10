import { Diagnostic } from '@angular/compiler-cli/ngtools2';

import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import {Validators, FormControl, FormGroup, FormBuilder} from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Message } from 'primeng/components/common/api';

@Component({
  selector: 'form-curso',
  templateUrl: './form-curso.component.html',
  styleUrls: ['./form-curso.component.css']
})
export class FormCursoComponent implements OnInit {
  msgs: Message[] = [];
  formCursos: FormGroup;
  submitted: boolean;
  @Output() clavasEvent = new EventEmitter();
  nome: string;
  duracao: string;
  nomeCurso: string;

  constructor(private http: HttpClient,
  private vl: FormBuilder) { }
  ngOnInit() {
    this.formCursos = this.vl.group({
      nome: new FormControl('', Validators.required),
      duracao: new FormControl('', Validators.required)
    });
  }

  resetaForm() {
    this.formCursos.reset();
  }

  adicionaCurso(): void {
    const cursoAdd = {
    nomeC: this.nome,
    duracaoC: this.duracao
    };
    if ((this.nome !== undefined) && (this.duracao !== undefined)) {
      this.http.post('http://localhost:8080/novoCurso', cursoAdd).subscribe(
       data => {
        this.clavasEvent.emit(data);

       }
      );
      this.nome = '';
      this.duracao = '';
    }
  }
  onSubmit(value: string): void {
    this.submitted = true;
    this.msgs = [];
    this.msgs.push({severity: 'info', summary: 'Success', detail: 'Curso ' + this.nome + ' com duração de' +
    this.duracao + ' adicionado com sucesso!'});
}

}
