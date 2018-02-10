package com.per.repository.enums;

public enum ProductType {

    BOUQUET("Букет"),
    BASKET("Корзинка");

    private String name;

    ProductType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
