package apps.ucu.ooad.task2;

public enum MailCode {
    BIRTHDAY(new BirthdayMailStrategy()),
    GIFT(new GiftMailStrategy());

    private final MailTemplateStrategy strategy;

    MailCode(MailTemplateStrategy strategy) {
        this.strategy = strategy;
    }

    public MailTemplate createTemplate(Client client) {
        return strategy.buildTemplate(client);
    }
}
