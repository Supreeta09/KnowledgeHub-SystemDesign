package channel;

import model.Notification;
import model.Subscriber;

public class PhoneCallChannel implements NotificationChannel {
    @Override
    public void sendNotification(Subscriber subscriber, Notification notification) {
        System.out.println("Calling " + subscriber.getPhone() + " for notification " + notification.getNotificationId());
    }
}
