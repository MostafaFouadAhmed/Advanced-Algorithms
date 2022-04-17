package designpatterns.creationalpatterns.factory;

public class NotificationClient {

    public static void main(String[] args) {
        NotificationFactory.getNotification(new SMSNotification());
        NotificationFactory.getNotification(new PushNotification());
        NotificationFactory.getNotification(new EmailNotification());
    }

}
