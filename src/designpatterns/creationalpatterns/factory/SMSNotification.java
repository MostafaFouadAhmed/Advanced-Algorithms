package designpatterns.creationalpatterns.factory;

public class SMSNotification implements Notification{

    Notification notification = new EmailNotification();

    @Override
    public void notifyUser() {
        notification.test();

        System.out.println("SMS NOTIFICATION");
    }

}
