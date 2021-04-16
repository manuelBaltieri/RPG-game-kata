import com.kata.rpg.Character;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CharacterTest {

    @Test
    void initialHealthIs1000() {
        assertThat(new Character().currentHealth()).isEqualTo(1000);
    }

    @Test
    void characterCanReceiveDamage() {
        Character character = new Character();
        character.receiveDamage(1);

        assertThat(character.currentHealth()).isEqualTo(999);
    }

    @Test
    void notNegativeHealth() {
        Character character = new Character();
        character.receiveDamage(1001);

        assertThat(character.currentHealth()).isEqualTo(0);
    }

    @Test
    void health0MeansDead() {
        Character character = new Character();
        character.receiveDamage(1000);
        assertThat(character.isDead()).isTrue();
    }


}
