import com.kata.rpg.Character;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CharacterTest {

    @Test
    void initialHealthIs1000() {
        assertThat(new Character().currentHealth()).isEqualTo(Character.INITIAL_HEALTH);
    }

    @Test
    void characterCanReceiveDamage() {
        Character character = new Character();
        int damage = 1;
        character.receiveDamage(damage);

        assertThat(character.currentHealth()).isEqualTo(Character.INITIAL_HEALTH - damage);
    }

    @Test
    void notNegativeHealth() {
        Character character = new Character();
        character.receiveDamage(Character.INITIAL_HEALTH + 1);

        assertThat(character.currentHealth()).isEqualTo(0);
    }

    @Test
    void health0MeansDead() {
        Character character = new Character();
        character.receiveDamage(Character.INITIAL_HEALTH);
        assertThat(character.isDead()).isTrue();
    }


}
