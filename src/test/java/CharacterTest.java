import com.kata.rpg.Character;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CharacterTest {

    @Test
    void characterCanReceiveDamage() {
        Character character = new Character();
        character.receiveDamage(1);

        assertThat(character.currentHealth()).isEqualTo(999);
    }

}
