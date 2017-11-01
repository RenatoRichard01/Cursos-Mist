import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'form-curso',
  templateUrl: './form-curso.component.html',
  styleUrls: ['./form-curso.component.css']
})
export class FormCursoComponent implements OnInit {
  nome: string;
  duracao: string;

  formulario: FormGroup;
  constructor(private http: HttpClient) { }

  ngOnInit():void {

  }
  adicionaCurso(): void {
    this.http.get ('http://localhost:8080/curso/adiciona'+this.nome+'/'+this.duracao).subscribe( data=> {
      console.log(data);
    });
  }
  removeCurso(id: number){
    this.http.get('http://localhost:8080/curso/deleta'
    +this.nome+'/'+this.duracao).subscribe( data=> {
      console.log(data);
    })
  }

}
