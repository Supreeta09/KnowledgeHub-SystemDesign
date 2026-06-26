package factory;

import strategy.FixedWindowStrategy;
import strategy.RateLimitingStrategy;
import strategy.TokenBucketStrategy;

public class RateLimiterFactory {
    public static RateLimitingStrategy create(String type) {
        switch (type.toUpperCase()) {
            case "FIXED_WINDOW":
                return new FixedWindowStrategy(100, 60000);
            case "TOKEN_BUCKET":
                return new TokenBucketStrategy(100, 10);
            default:
                throw new IllegalArgumentException(
                        "Unknown Strategy");
        }
    }
}
