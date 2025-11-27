package apps.ucu.ooad.task2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClientTest {

    @BeforeEach
    void resetIds() {
        Client.resetIdSequenceForTests();
    }

    @Test
    void idsIncrementAutomatically() {
        Client first = new Client("Alice", 21, Gender.FEMALE);
        Client second = new Client("Bob", 30, Gender.MALE);

        assertEquals(0, first.getId());
        assertEquals(1, second.getId());
    }
}
