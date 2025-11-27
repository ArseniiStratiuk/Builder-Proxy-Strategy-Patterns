package apps.ucu.ooad.task1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void builderAssignsEveryField() {
        User user = User.builder()
                .name("Alex")
                .age(25)
                .gender(Gender.MALE)
                .weight(82.5)
                .height(185.2)
                .build();

        assertEquals("Alex", user.getName());
        assertEquals(25, user.getAge());
        assertEquals(Gender.MALE, user.getGender());
        assertEquals(82.5, user.getWeight());
        assertEquals(185.2, user.getHeight());
    }

    @Test
    void builderAppliesDefaultsWhenMissing() {
        User user = User.builder()
                .name("Sam")
                .build();

        assertEquals(0, user.getAge());
        assertNull(user.getGender());
        assertEquals(0.0, user.getWeight());
        assertEquals(0.0, user.getHeight());
    }

    @Test
    void builderRejectsNullName() {
        assertThrows(NullPointerException.class, () -> User.builder().name(null).build());
    }
}
