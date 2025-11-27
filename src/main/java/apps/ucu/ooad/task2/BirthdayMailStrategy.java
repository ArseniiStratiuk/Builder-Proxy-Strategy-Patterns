package apps.ucu.ooad.task2;

public class BirthdayMailStrategy implements MailTemplateStrategy {
    @Override
    public MailTemplate buildTemplate(Client client) {
        String subject = "Happy Birthday, " + client.getName() + "!";
        String body = "Dear " + client.getName() + ",\n" +
                "We hope you enjoy turning " + client.getAge() + " today. " +
                "Here is a discount coupon just for you!";
        return new MailTemplate(subject, body);
    }
}
