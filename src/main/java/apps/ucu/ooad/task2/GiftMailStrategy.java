package apps.ucu.ooad.task2;

public class GiftMailStrategy implements MailTemplateStrategy {
    @Override
    public MailTemplate buildTemplate(Client client) {
        String subject = "A special gift for " + client.getName();
        String salutation = client.getGender() == Gender.FEMALE ? "Ms." : "Mr.";
        String body = "Hello " + salutation + " " + client.getName() + ",\n" +
                "Thanks for being with us! Pick any present you like from our catalog.";
        return new MailTemplate(subject, body);
    }
}
