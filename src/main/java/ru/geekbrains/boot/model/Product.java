package ru.geekbrains.boot.model;

import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String title;
    private Double cost;


    public Product(String title, Double cost) {
        this.title = title;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "#" + this.id + " " + this.title + " " + this.cost;
    }
}