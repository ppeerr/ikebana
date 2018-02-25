package com.per.repository.enums;

public enum FlowersType {

    ROSES("Розы"),
    TULIPS("Тюльпаны"),
    PETUNIAS("Петунии"),
    VIOLETS("Фиалки"),
    ORCHIDS("Орхидеи"),
    CHRYSANTHEMUMS("Хризантемы");

    private String name;

    FlowersType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
