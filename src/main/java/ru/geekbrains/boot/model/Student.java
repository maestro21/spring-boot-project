package ru.geekbrains.boot.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Long id;
    private String name;
    private int score;
}
