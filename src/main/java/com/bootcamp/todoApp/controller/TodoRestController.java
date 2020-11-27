package com.bootcamp.todoApp.controller;

import com.bootcamp.todoApp.model.Todo;
import com.bootcamp.todoApp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoRestController {

    private TodoService todoService;

    @Autowired
    public TodoRestController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PutMapping(value="/api/todo/check", produces=MediaType.APPLICATION_JSON_VALUE)
    //@ResponseBody
    public Todo checkTodoDone(@RequestBody Todo todo) {
        return todoService.changeDoneField(todo);
    }

    /*
    @PostMapping("/api/todo/update")
    public void updateTodo(Model model, @ModelAttribute Todo todo){
        todoService.updateTodo(todo);
    }
    */

//    @PutMapping("/api/todo/update")
//   @DeleteMapping("/api/todo")


   @DeleteMapping(value = "/api/todo/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteTodo(@RequestBody Todo todo){
        todoService.deleteTodo(todo);
   }

}
