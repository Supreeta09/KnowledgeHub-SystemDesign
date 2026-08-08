package channel;

import model.Notification;
import model.Subscriber;

public class EmailChannel implements NotificationChannel {
    @Override
    public void sendNotification(Subscriber subscriber, Notification notification) {
        System.out.println("Sending EMAIL to " + subscriber.getEmail() + ": " + notification.getMessage());
    }
}
