import channel.*;
import model.*;
import services.NotificationService;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // ==================================================
        // 1. Create notification channels
        // ==================================================

        NotificationChannel emailChannel = new EmailChannel();

        NotificationChannel smsChannel = new SmsChannel();

        NotificationChannel phoneChannel = new PhoneCallChannel();

        NotificationChannel pushChannel = new PushChannel();


        // ==================================================
        // 2. Create delivery strategies
        // ==================================================

        DeliveryStrategy highSeverityStrategy = new DeliveryStrategy(
                List.of(
                        smsChannel,
                        phoneChannel
                )
        );

        DeliveryStrategy mediumSeverityStrategy = new DeliveryStrategy(
                List.of(
                        emailChannel,
                        smsChannel
                )
        );

        DeliveryStrategy lowSeverityStrategy = new DeliveryStrategy(
                List.of(
                        pushChannel
                )
        );


        // ==================================================
        // 3. Create clients
        // ==================================================

        Client amazon = new Client("C001", "Amazon");

        Client flipkart = new Client("C002", "Flipkart");


        // ==================================================
        // 4. Create subscribers
        // ==================================================

        Subscriber subscriber1 = new Subscriber(
                        "S001",
                        "Test User",
                        "test@email.com",
                        "909090"
                );

        Subscriber subscriber2 = new Subscriber(
                        "S002",
                        "Dummy User",
                        "dummy@email.com",
                        "11221122"
                );


        // ==================================================
        // 5. Create subscription preferences
        // ==================================================

        SubscriptionPreference amazonPreference =
                new SubscriptionPreference(
                        amazon,
                        subscriber1,
                        Map.of(
                                Severity.HIGH,
                                highSeverityStrategy,

                                Severity.MEDIUM,
                                mediumSeverityStrategy,

                                Severity.LOW,
                                lowSeverityStrategy
                        )
                );

        SubscriptionPreference flipkartPreference =
                new SubscriptionPreference(
                        flipkart,
                        subscriber2,
                        Map.of(
                                Severity.HIGH,
                                highSeverityStrategy,

                                Severity.MEDIUM,
                                mediumSeverityStrategy,

                                Severity.LOW,
                                lowSeverityStrategy
                        )
                );


        // ==================================================
        // 6. Register subscriptions
        // ==================================================

        SubscriptionRegistry registry = new SubscriptionRegistry();

        registry.addSubscription(amazonPreference);
        registry.addSubscription(flipkartPreference);


        // ==================================================
        // 7. Create notifications
        // ==================================================

        Notification notification1 =
                new Notification(
                        "N001",
                        amazon.getClientId(),
                        subscriber1.getSubscriberId(),
                        "Your order has been confirmed",
                        Severity.MEDIUM,
                        null
                );

        Notification notification2 =
                new Notification(
                        "N002",
                        flipkart.getClientId(),
                        subscriber2.getSubscriberId(),
                        "Your order has been shipped",
                        Severity.LOW,
                        null
                );


        // ==================================================
        // 8. Create notification service
        // ==================================================

        NotificationService notificationService = new NotificationService(registry);


        // ==================================================
        // 9. Publish notifications
        // ==================================================

        notificationService.publish(notification1);

        notificationService.publish(notification2);
    }
}
