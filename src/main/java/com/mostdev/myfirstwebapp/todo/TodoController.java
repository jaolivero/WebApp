package com.mostdev.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    @RequestMapping("list-Todos")
    public String listAllTodos(ModelMap model){
        List<Todo> todos = todoService.findByUserName("Caleb");
        model.addAttribute("todos", todos);

        return "listTodos";
    }

    @RequestMapping(value = "add-Todo", method = RequestMethod.GET)
    public String ShowTodosPage(ModelMap model) {
        //default value for new todos
        String username = (String) model.get("name");
        Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "add-Todo", method = RequestMethod.POST)
    public String AddNewTodo(ModelMap model, @Valid Todo todo, BindingResult result ) {

        if(result.hasErrors()) {
            return "todo";
        }

        String username = (String) model.get("name");
        todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);

        //do not use the JSP but the link to the url
        return "redirect:list-Todos";
    }

    @RequestMapping("delete-Todo")
    public String deleteTodo(@RequestParam int id) {

        todoService.deleteById(id);
        return "redirect:list-Todos";
    }

    @RequestMapping(value="update-Todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        Todo todo = todoService.findById(id);
        model.addAttribute("todo", todo);
        return "todo";
    }



    @RequestMapping(value="update-Todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if(result.hasErrors()) {
            return "todo";
        }

        String username = (String)model.get("name");
        todo.setUsername(username);
        todoService.updateTodo(todo);
        return "redirect:list-Todos";

    }


}
