package com.example.todoapispring;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController  {
    private static List<Todo> todosList;

    public TodoController(){
        todosList  = new ArrayList<>();
        todosList.add(new Todo(1,"Todo 1","Todo 1 is ongoing",1));
        todosList.add(new Todo(2,"Todo 2","Todo 2 is ongoing",2));
        todosList.add(new Todo(3,"Todo 3","Todo 3 is ongoing",3));
    }

    @GetMapping("/")
    public ResponseEntity<List<Todo>> getTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(todosList);
    }

    @PostMapping("/")
//    @ResponseStatus(HttpStatus.CREATED)  for setting http status code correctly
    public ResponseEntity<Todo> createTodo(@RequestBody Todo  newTodo){
        todosList.add(newTodo);
        return  ResponseEntity.status(HttpStatus.CREATED).body(newTodo); //another way to for setting http status code correctly
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<Todo> getTodoById(@PathVariable int todoId){
        for(Todo todo:todosList){
            if(todo.getId() ==  todoId){
                return ResponseEntity.ok(todo);
            }
        }
        //along with 404 status code, try to send a json {message: "Todo not found"}
        return  ResponseEntity.notFound().build();
    }






}
