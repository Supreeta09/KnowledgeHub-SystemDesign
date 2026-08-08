package model;

import java.util.Map;

public class SubscriptionPreference {
    private final Client client;
    private final Subscriber subscriber;
    private final Map<Severity, DeliveryStrategy> severityStrategy;

    public SubscriptionPreference(Client client, Subscriber subscriber, Map<Severity, DeliveryStrategy> severityStrategy) {
        this.client = client;
        this.subscriber = subscriber;
        this.severityStrategy = severityStrategy;
    }

    public DeliveryStrategy getStrategy(Severity severity) {
        return severityStrategy.get(severity);
    }

    public Client getClient() {
        return client;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }
}
