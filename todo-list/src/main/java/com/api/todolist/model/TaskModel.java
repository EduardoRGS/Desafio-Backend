package com.api.todolist.model;

import com.api.todolist.enums.PropertyEnum;
import com.api.todolist.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@ToString
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descripton;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PropertyEnum property;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusEnum status;


}
