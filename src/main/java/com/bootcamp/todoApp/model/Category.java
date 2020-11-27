package com.bootcamp.todoApp.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Category {
    @Id
    private Long id;
    private String color;
    @ManyToMany
    private Set<Todo> todos;

}
