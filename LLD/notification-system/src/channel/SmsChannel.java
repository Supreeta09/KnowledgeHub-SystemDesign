package channel;

import model.Notification;
import model.Subscriber;

public class SmsChannel implements NotificationChannel{
    @Override
    public void sendNotification(Subscriber subscriber, Notification notification) {
        System.out.println("Sending SMS to " + subscriber.getPhone() + ": " + notification.getMessage());
    }
}
