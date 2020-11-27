package com.bootcamp.todoApp.service;

import com.bootcamp.todoApp.model.Todo;
import com.bootcamp.todoApp.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class TodoService {

    TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAll() {
        return todoRepository.findAll();

    }

    public List<Todo> getAllSortedById() {
        return todoRepository.findAll(Sort.by("id"));
    }

    public Todo addNewTodo(Todo todo) {
        todo.setDone(false);
        return todoRepository.save(todo);
    }

    public Todo changeDoneField(Todo todo) {
        var repoTodo = todoRepository.getOne(todo.getId());
        repoTodo.setDone(!repoTodo.getDone());
        return todoRepository.save(repoTodo);
    }

    public void deleteTodo(Todo todo){
        todoRepository.deleteById(todo.getId());
    }

    public Todo updateTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public void getDonePercent(Date date){

    }
}








