package com.Step07.springboot.myFirstApp.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class TodoControllerJPA {
    private TodoRepository todoRepository;

    public TodoControllerJPA(TodoService todoService,TodoRepository todoRepository) {
        this.todoRepository = todoRepository;

    }

    @RequestMapping(value="list-todos")
    public String listTodos(ModelMap model){
        String username = (String) model.get("name");
        List<Todo> todos = todoRepository.findByUsername(username);
        model.addAttribute("todos",todos);
        return "listTodos";
    }

    @RequestMapping(value="add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(
            ModelMap model
    ){
        Todo todo = new Todo(0, "", "Default Desc", LocalDate.now(), false);
        model.put("todo", todo);
        return "addTodo";
    }

    @RequestMapping(value="add-todo", method = RequestMethod.POST)
    public String addNewTodo(
            @Valid Todo todo,
            BindingResult bindingResult,
            ModelMap model
    ){
        String username = (String) model.get("name");
        todo.setUsername(username);
        if (bindingResult.hasErrors() || username.isEmpty()) {
            return "addTodo";
        }
        todoRepository.save(todo);
        return "redirect:list-todos";
    }

    @RequestMapping(value="delete-todo")
    public String deleteTodo( @RequestParam int id ){
        todoRepository.deleteById(id);
        return "redirect:list-todos";
    }
    @RequestMapping(value="update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage( @RequestParam int id, ModelMap model ){
        Todo todo = todoRepository.getReferenceById(id);
        model.addAttribute("todo",todo);
        return "updateTodo";
    }

    @RequestMapping(value="update-todo", method = RequestMethod.POST)
    public String showUpdateTodo(ModelMap model, @Valid Todo todo, BindingResult result ){
        if(result.hasErrors()) {
            return "updateTodo";
        }
        String username = (String) model.get("name");
        todo.setUsername(username);
        todoRepository.save(todo);
        return "redirect:list-todos";
    }

    private String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            return authentication.getName();
        }
        return null;
    }
}
