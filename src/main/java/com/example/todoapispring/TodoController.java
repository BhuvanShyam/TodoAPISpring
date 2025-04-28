package com.example.todoapispring;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TodoController  {
    private static List<Todo> todos

    public TodoController(){
        todos  = new ArrayList<>();
        todos.add(new Todo(1,"Todo 1","Todo 1 is ongoing",1));
        todos.add(new Todo(2,"Todo 2","Todo 2 is ongoing",2));
        todos.add(new Todo(3,"Todo 3","Todo 3 is ongoing",3));
    }




}
