package com.api.todolist.enums;

public enum StatusEnum {
    PENDENTE("Pendente"),
    CONCLUIDA("Concluida");

    private final String name;

    StatusEnum(String name) {
        this.name = name;
    }
}
