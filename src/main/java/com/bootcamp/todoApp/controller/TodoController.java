package com.bootcamp.todoApp.controller;

import com.bootcamp.todoApp.model.Todo;
import com.bootcamp.todoApp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class TodoController {

    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("todo", new Todo());
        model.addAttribute("today", new Date(System.currentTimeMillis()));
        model.addAttribute("todoList", todoService.getAllSortedById());
        return "index";
    }

    @PostMapping("/addTodo")
    public String addTodo(Model model, @ModelAttribute Todo todo) {
        todoService.addNewTodo(todo);
        return "redirect:/";
    }

}









