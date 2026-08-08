package model;

import channel.NotificationChannel;

import java.util.List;

public class DeliveryStrategy {
    private final List<NotificationChannel> channels;

    public DeliveryStrategy(List<NotificationChannel> channels) {
        this.channels = channels;
    }

    public void execute(Subscriber subscriber, Notification notification) {
        for (NotificationChannel channel: channels) {
            channel.sendNotification(subscriber, notification);
        }
    }
}
