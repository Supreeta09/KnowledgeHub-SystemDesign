package strategy;

import model.RateLimitResponse;

public interface RateLimitingStrategy {
    RateLimitResponse handleRequest(String userId);
}
