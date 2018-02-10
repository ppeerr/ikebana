package com.per.repository.enums;

public enum StatusType {

    ERROR("Ошибка"),
    PROCESSING("Обрабатывается"),
    WORKING("В работе"),
    COMPLETED("Завершен");

    private String name;

    StatusType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
