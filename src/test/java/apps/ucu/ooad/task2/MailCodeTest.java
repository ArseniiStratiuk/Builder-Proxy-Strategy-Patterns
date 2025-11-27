package apps.ucu.ooad.task2;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MailCodeTest {

    @BeforeEach
    void resetClientIds() {
        Client.resetIdSequenceForTests();
    }

    @Test
    void birthdayTemplateMentionsAgeAndName() {
        Client client = new Client("Ira", 19, Gender.FEMALE);

        MailTemplate template = MailCode.BIRTHDAY.createTemplate(client);

        assertTrue(template.subject().contains("Ira"));
        assertTrue(template.body().contains("19"));
    }

    @Test
    void giftTemplateUsesGenderSpecificSalutation() {
        Client client = new Client("Andrew", 27, Gender.MALE);

        MailTemplate template = MailCode.GIFT.createTemplate(client);

        assertTrue(template.body().contains("Mr."));
        assertTrue(template.subject().contains("Andrew"));
    }
}
