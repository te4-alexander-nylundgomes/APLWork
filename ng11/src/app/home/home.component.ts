import { Component, OnInit } from '@angular/core';
import { TodoComponent } from "../todo/todo.component";
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  todos: {}[] = [
    {id: 1, title: 'Wash dishes', desc: 'Something that just needs to get done!', isDone: false},
    {id: 2, title: 'Clean room', desc: 'Something that just needs to get done!', isDone: false},
    {id: 3, title: 'Eat toothpaste', desc: 'Something that just needs to get done!', isDone: false},
    {id: 4, title: 'Recycle cans', desc: 'Something that just needs to get done!', isDone: false},
  ]

  newId: number = 4;
  newTitle: string = ""
  newDesc: string = ""

  constructor() { }

  ngOnInit(): void {
  }

  removeTodo(e): void{
    let index = this.todos.indexOf(e);
    this.todos.splice(index, 1);
  }

  clearFields(){
    this.newDesc = "";
    this.newTitle = "";
  }

  newTodo(): void{
    this.newId += 1;

    this.todos.push({ id: this.newId, title: this.newTitle, desc: this.newDesc, isDone: false})
  }

}
