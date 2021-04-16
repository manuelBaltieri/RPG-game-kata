package com.kata.rpg;

public class Character {
  private int currentHealth = 1000;

  public void receiveDamage(int damage) {
    if (damage > currentHealth) {
      currentHealth = 0;
    } else {
      currentHealth -= damage;
    }
  }

  public int currentHealth() {
    return currentHealth;
  }

  public boolean isDead() {
    return currentHealth <= 0;
  }
}
