import com.kata.rpg.Character;
import com.kata.rpg.CharacterCannotAttackHimselfException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

	@Test
	void characterAttacksAnotherCharacter()
	throws
			CharacterCannotAttackHimselfException {
		int damage = 1;

		Character attacker = new Character();
		Character defender = new Character();

		attacker.inflictDamage(defender, damage);

		assertThat(defender.currentHealth()).isEqualTo(Character.INITIAL_HEALTH - damage);
	}

	@Test()
	void characterCannotAttacksHimself() {
		Character attacker = new Character();

		assertThrows(CharacterCannotAttackHimselfException.class, () -> {
			attacker.inflictDamage(attacker, 1);
		});
	}
}
