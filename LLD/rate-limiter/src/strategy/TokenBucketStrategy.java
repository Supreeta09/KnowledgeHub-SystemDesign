package strategy;

import model.RateLimitResponse;
import model.TokenBucket;

import java.util.concurrent.ConcurrentHashMap;

public class TokenBucketStrategy extends AbstractRateLimitingStrategy {
    private int maxTokens;
    private int refillRate;
    private final ConcurrentHashMap<String, TokenBucket> buckets = new ConcurrentHashMap<>();

    public TokenBucketStrategy(int maxTokens, int refillRate) {
        this.maxTokens = maxTokens;
        this.refillRate = refillRate;
    }

    @Override
    protected void refreshState(String userId) {
        long now = System.currentTimeMillis();
        TokenBucket bucket = buckets.computeIfAbsent(userId,
                id -> new TokenBucket(maxTokens, now));
        synchronized (bucket) {
            long elapsed = now - bucket.getLastRefillTime();

            int tokensToAdd = (int) (elapsed / 1000) * refillRate;  // elapsed is in millis, we want seconds (refill rate is per seconds)
            bucket.setTokens(
                    Math.min(maxTokens, bucket.getTokens() + tokensToAdd));
            bucket.setLastRefillTime(now);
        }
    }

    @Override
    protected boolean canAllow(String userId) {
        TokenBucket bucket = buckets.get(userId);
        synchronized (bucket) {
            return bucket.getTokens() >= 1;
        }
    }

    @Override
    protected void updateState(String userId) {
        TokenBucket bucket = buckets.get(userId);
        synchronized (bucket) {
            bucket.setTokens(bucket.getTokens() - 1);
        }
    }

    @Override
    protected RateLimitResponse buildSuccessResponse(String userId) {
        TokenBucket bucket = buckets.get(userId);
        synchronized (bucket) {
            return new RateLimitResponse(
                    true,
                    bucket.getTokens(),
                    0
            );
        }
    }

    @Override
    protected RateLimitResponse buildErrorResponse(String userId) {
        TokenBucket bucket = buckets.get(userId);
        synchronized (bucket) {
            return new RateLimitResponse(
                    false,
                    0,
                    1   // we are refilling per second. So if it waits for 1sec, then token gets refilled
            );
        }
    }
}
