package com.api.todolist.model;

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

    @Column
    private String descripton;


    @Enumerated(EnumType.STRING)
    @Column
    private EnumProperty property;

    @Column
    private Boolean status;


}
