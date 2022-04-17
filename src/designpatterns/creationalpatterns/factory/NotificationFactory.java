package designpatterns.creationalpatterns.factory;

public class NotificationFactory {

    public static void getNotification(Notification notification) {

        if (notification instanceof PushNotification) {

            new PushNotification().notifyUser();

        } else if (notification instanceof EmailNotification) {

            new EmailNotification().notifyUser();

        } else {

            new SMSNotification().notifyUser();
        }
    }
}
