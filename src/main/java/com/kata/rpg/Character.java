package com.kata.rpg;

public class Character {
    private int currentHealt = 1000;

    public void receiveDamage(int damage) {
        currentHealt -= damage;
    }

    public int currentHealth() {
        return currentHealt;
    }
}
