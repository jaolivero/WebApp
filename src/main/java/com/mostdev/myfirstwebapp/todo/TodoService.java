package com.mostdev.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 0;


    static {
        todos.add(new Todo(todosCount++, "Caleb", "Learn AWS Certified", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(todosCount++, "Caleb", "Learn Azure Certificate", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(todosCount++, "Caleb", "Learn Java asap", LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUserName(String username){
        return todos;
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean isDone) {
        Todo todo = new Todo(++todosCount, username, description, targetDate,isDone);
        todos.add(todo);
    }

    public void deleteById(int id) {

        Predicate<?  super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);

    }

    public Todo findById(int id) {
        Predicate<?  super Todo> predicate = todo -> todo.getId() == id;

        //functional programming instead of forloop
        Todo todo = todos.stream().filter(predicate).findFirst().get();

        return todo;
    }

    public void updateTodo(@Valid Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }

}
