package com.example.todoapispring;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TodoController  {
    private static List<Todo> todosList;

    public TodoController(){
        todosList  = new ArrayList<>();
        todosList.add(new Todo(1,"Todo 1","Todo 1 is ongoing",1));
        todosList.add(new Todo(2,"Todo 2","Todo 2 is ongoing",2));
        todosList.add(new Todo(3,"Todo 3","Todo 3 is ongoing",3));
    }

    @GetMapping("/todos")
    public List<Todo> getTodos(){
        return todosList;
    }

    @PostMapping("/todos")
    public Todo createTodo(@RequestBody Todo  newTodo){
        todosList.add(newTodo);
        return  newTodo;
    }






}
