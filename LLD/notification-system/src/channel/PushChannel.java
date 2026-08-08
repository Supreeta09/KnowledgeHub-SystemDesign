package channel;

import model.Notification;
import model.Subscriber;

public class PushChannel implements NotificationChannel{
    @Override
    public void sendNotification(Subscriber subscriber, Notification notification) {
        System.out.println("Sending PUSH to " + subscriber.getSubscriberId() + ": " + notification.getMessage());

    }
}
