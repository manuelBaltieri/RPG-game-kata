package com.kata.rpg;

public
class Character {
	public static final int INITIAL_HEALTH = 1000;
	private             int currentHealth  = INITIAL_HEALTH;

	public
	void receiveDamage(int damage) {
		if (damage > currentHealth) {
			currentHealth = 0;
		} else {
			currentHealth -= damage;
		}
	}

	public
	int currentHealth() {
		return currentHealth;
	}

	public
	boolean isDead() {
		return currentHealth <= 0;
	}
}
