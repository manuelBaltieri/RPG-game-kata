package com.kata.rpg;

import static java.lang.Math.min;

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

	public
	boolean isAlive() {
		return !isDead();
	}

	public
	void receiveHealing(int heal) {
		if (isAlive()) {
			currentHealth = min(INITIAL_HEALTH, currentHealth + heal);
		}
	}

	public
	void inflictDamage(Character defender, int damage)
	throws
			CharacterCannotAttackHimselfException {
		if (this == defender) {
			throw new CharacterCannotAttackHimselfException();
		}
		defender.receiveDamage(damage);
	}
}
