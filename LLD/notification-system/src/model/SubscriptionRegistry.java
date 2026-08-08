package model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SubscriptionRegistry {

    private Map<String, SubscriptionPreference> registry = new ConcurrentHashMap<>();

    public void addSubscription(SubscriptionPreference subscriptionPreference) {
        String key = buildKey(subscriptionPreference.getClient().getClientId(), subscriptionPreference.getSubscriber().getSubscriberId());
        registry.put(key, subscriptionPreference);
    }

    public SubscriptionPreference getPreference(String clientId, String subscriberId) {
        String key = buildKey(clientId, subscriberId);
        return registry.get(key);
    }

    private String buildKey(String clientId, String subscriberId) {
        return clientId + ":" + subscriberId;
    }

}
