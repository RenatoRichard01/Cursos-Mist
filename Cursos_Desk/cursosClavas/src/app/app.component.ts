import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  title = 'app';

}
/*
  ngOnInit(): void {
    this.http.get('http://localhost:8080/cursos/lista').subscribe
    (data => {
      //this.results = data[];
       console.log(data);
    });
  }
}
*/
