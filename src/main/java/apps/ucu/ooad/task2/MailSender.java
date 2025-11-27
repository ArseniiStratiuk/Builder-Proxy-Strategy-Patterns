package apps.ucu.ooad.task2;

public class MailSender {
    public void sendMail(MailInfo mailInfo) {
        MailTemplate template = mailInfo.resolveTemplate();
        String recipient = mailInfo.getClient().getName() + " <client-" + mailInfo.getClient().getId() + ">";
        System.out.println("Sending email to " + recipient);
        System.out.println("Subject: " + template.subject());
        System.out.println(template.body());
        System.out.println("----");
    }
}
