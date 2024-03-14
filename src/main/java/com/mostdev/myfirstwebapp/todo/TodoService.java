package com.mostdev.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(1, "Caleb", "Learn AWS", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(1, "Caleb", "Learn Azure", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(1, "Caleb", "Learn Java", LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUserName(String username){
        return todos;
    }









}
