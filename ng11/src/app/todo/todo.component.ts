import { Component, EventEmitter, Output,  Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.scss']
})
export class TodoComponent implements OnInit {
  @Input() todo: {title: string, desc: string, isDone: boolean, id: number};
  @Output() removeTodoEvent: EventEmitter<any> = new EventEmitter();

  isClicked: boolean = false;

  constructor() { }

  ngOnInit(): void {
  }

  removeTodo(){
    console.log('recieved')
    this.removeTodoEvent.emit(this.todo);
  }

  changeState(){
    this.todo.isDone = !this.todo.isDone;

    this.isClicked = true;
    setTimeout(() => {
      this.isClicked = false;
    }, 50)
  }

}
