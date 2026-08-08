package channel;

import model.Notification;
import model.Subscriber;

public interface NotificationChannel {
    public void sendNotification(Subscriber subscriber, Notification notification);
}
