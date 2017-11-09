import {Validator} from 'codelyzer';
import {Message} from '@angular/compiler/i18n';
import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validator } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'form-curso',
  templateUrl: './form-curso.component.html',
  styleUrls: ['./form-curso.component.css']
})
export class FormCursoComponent implements OnInit {
  msgs: Message[] = [];

  submitted: boolean;
  formCursos: FormGroup;
  //@Output() clavasEvent = new EventEmitter();
  nome: string;
  duracao: string;
  //nomeCurso: string;

  formulario: FormGroup;

  constructor(private http: HttpClient,
  private vl: FormBuilder) { }
  ngOnInit(
    this.formCursos = this.vl.group({
      'nome': new FormControl('', Validator.required),
      'duracao': new FormControl('', Validator.required)
    });
  ) {
  }

  resetaForm() {
    this.formulario.reset();
  }
/*
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
  }*/
onSubmit(value: string) {
    this.submitted = true;
    this.msgs.push({severity: 'info', summary: 'Success', detail: 'Form Submitted'});
}

}
