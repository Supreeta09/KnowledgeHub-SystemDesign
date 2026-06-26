package facade;

import model.RateLimitResponse;
import strategy.RateLimitingStrategy;

public class RateLimiter {
    private final RateLimitingStrategy strategy;

    public RateLimiter(RateLimitingStrategy strategy) {
        this.strategy = strategy;
    }

    public RateLimitResponse handleRequest(String userId) {
        return strategy.handleRequest(userId);
    }
}
