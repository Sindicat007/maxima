package ru.maxima.maven.example.task2;

import lombok.Getter;

@Getter
public enum CardSuit {

    HEARTS("Красный"), DIAMONDS("Красный"), CLUBS("Черный"), SPADES("Черный");
    private final String color;

    CardSuit(String color) {
        this.color = color;
    }

}
