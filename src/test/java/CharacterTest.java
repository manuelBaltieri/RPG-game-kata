import com.kata.rpg.Character;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public
class CharacterTest {

	private final Character character = new Character();

	@Test
	void initialHealthIs1000() {
		assertThat(new Character().currentHealth()).isEqualTo(Character.INITIAL_HEALTH);
	}

	@Test
	void characterCanReceiveDamage() {
		int damage = 1;
		character.receiveDamage(damage);

		assertThat(character.currentHealth()).isEqualTo(Character.INITIAL_HEALTH - damage);
	}

	@Test
	void notNegativeHealth() {
		character.receiveDamage(Character.INITIAL_HEALTH + 1);

		assertThat(character.currentHealth()).isEqualTo(0);
	}

	@Test
	void health0MeansDead() {
		character.receiveDamage(Character.INITIAL_HEALTH);
		assertThat(character.isDead()).isTrue();
	}

	@Test
	void characterCanReceiveHealing() {
		character.receiveDamage(2);

		int healthBeforeHealing = character.currentHealth();

		int heal = 1;
		character.receiveHealing(heal);

		int healthAfterHealing = character.currentHealth();

		assertThat(healthAfterHealing).isEqualTo(healthBeforeHealing + heal);
	}

	@Test
	void deadCharacterCanNotBeHealed() {
		character.receiveDamage(Character.INITIAL_HEALTH);

		assertThat(character.isDead()).isTrue();
		character.receiveHealing(1);

		assertThat(character.currentHealth()).isEqualTo(0);
	}

	@Test
	void maxHealtIs1000() {
		character.receiveHealing(1);

		assertThat(character.currentHealth()).isEqualTo(Character.INITIAL_HEALTH);
	}

    /*@Test
    void notNegativeHealth() {
        Character character = new Character();
        character.receiveDamage(Character.INITIAL_HEALTH + 1);

        assertThat(character.currentHealth()).isEqualTo(0);
    }*/
}
