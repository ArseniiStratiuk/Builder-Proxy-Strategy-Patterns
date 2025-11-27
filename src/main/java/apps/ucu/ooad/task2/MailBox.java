package apps.ucu.ooad.task2;

import java.util.ArrayList;
import java.util.List;

public class MailBox {
    private final List<MailInfo> infos = new ArrayList<>();
    private final MailSender mailSender;

    public MailBox(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void addMailInfo(MailInfo mailInfo) {
        infos.add(mailInfo);
    }

    public void sendAll() {
        infos.forEach(mailSender::sendMail);
        infos.clear();
    }
}
