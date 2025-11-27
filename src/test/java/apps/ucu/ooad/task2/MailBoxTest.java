package apps.ucu.ooad.task2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MailBoxTest {

    private RecordingMailSender recordingMailSender;
    private MailBox mailBox;

    @BeforeEach
    void setUp() {
        Client.resetIdSequenceForTests();
        recordingMailSender = new RecordingMailSender();
        mailBox = new MailBox(recordingMailSender);
    }

    @Test
    void sendAllDispatchesEveryMailAndClearsQueue() {
        Client alice = new Client("Alice", 20, Gender.FEMALE);
        Client bob = new Client("Bob", 32, Gender.MALE);
        mailBox.addMailInfo(new MailInfo(alice, MailCode.BIRTHDAY));
        mailBox.addMailInfo(new MailInfo(bob, MailCode.GIFT));

        mailBox.sendAll();
        assertEquals(2, recordingMailSender.sentInfos.size());

        mailBox.sendAll();
        assertEquals(2, recordingMailSender.sentInfos.size(), "Queue should be empty after first send");
    }

    private static class RecordingMailSender extends MailSender {
        private final List<MailInfo> sentInfos = new ArrayList<>();

        @Override
        public void sendMail(MailInfo mailInfo) {
            sentInfos.add(mailInfo);
        }
    }
}
