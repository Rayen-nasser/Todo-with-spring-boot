package com.Step07.springboot.myFirstApp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int id = 0;
    static {
        todos.add(new Todo(++id,"rayen", "JS",LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++id,"ibrahiim", "TS",LocalDate.now().plusYears(2), true));
        todos.add(new Todo(++id,"samir", "JAVA",LocalDate.now().plusYears(3), false));
    }
    public List<Todo> findByUsername(String username){
        List list = new ArrayList<Todo>();
        for (Todo todo : this.todos) {
            if (todo.getUsername() == username) {
                list.add(todo);
            }
        }
        return list;
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done){
        Todo todo = new Todo(++id,username,description,targetDate,done);
        todos.add(todo);
    }

    public void deleteTodo(int id){
        todos.removeIf(todo -> todo.getId() == id);
    }

    public Todo getByTodo(int id){
        return todos.stream()
                .filter(todo -> todo.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void updateTodo(Todo todo){
         todos.stream()
                 .filter(t -> t.getId() == todo.getId())
                 .findFirst()
                 .ifPresent(t -> {
                     t.setId(todo.getId());
                     t.setUsername(todo.getUsername());
                     t.setDescription(todo.getDescription());
                     t.setDone(todo.isDone());
                     t.setTargetDate(todo.getTargetDate());
                 });
    }
}
