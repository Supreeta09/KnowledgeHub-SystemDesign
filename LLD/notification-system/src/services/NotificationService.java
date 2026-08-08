package services;

import model.*;

public class NotificationService {
    private final SubscriptionRegistry registry;

    public NotificationService(SubscriptionRegistry registry) {
        this.registry = registry;
    }

    public void publish(Notification notification) {
        SubscriptionPreference preference = registry.getPreference(notification.getClientId(),
                notification.getSubscriberId());

        if (preference == null) {
            throw new RuntimeException("No subscription found");
        }

        DeliveryStrategy strategy = preference.getStrategy(notification.getSeverity());

        if (strategy == null)
            throw new RuntimeException("No strategy found");

        notification.setStatus(NotificationStatus.QUEUED);

        strategy.execute(preference.getSubscriber(), notification);

        notification.setStatus(NotificationStatus.SENT);
    }
}

