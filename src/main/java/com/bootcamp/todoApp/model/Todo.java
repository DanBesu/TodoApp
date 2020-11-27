package com.bootcamp.todoApp.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Todo implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Boolean done;
    private String text;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date day;
    @ManyToMany(mappedBy = "todos")
    private Set<Category> categories;


}
