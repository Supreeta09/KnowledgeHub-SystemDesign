package strategy;

import model.FixedWindowCounter;
import model.RateLimitResponse;

import java.util.concurrent.ConcurrentHashMap;

public class FixedWindowStrategy extends AbstractRateLimitingStrategy {
    private final int maxRequests;
    private final long windowSize;
    private final ConcurrentHashMap<String, FixedWindowCounter> stores = new ConcurrentHashMap<>();

    public FixedWindowStrategy(int maxRequests, long windowSize) {
        this.maxRequests = maxRequests;
        this.windowSize = windowSize;
    }

    @Override
    protected void refreshState(String userId) {
        long now = System.currentTimeMillis();
        FixedWindowCounter counter = stores.computeIfAbsent(userId,
                id -> new FixedWindowCounter(0, now));

        synchronized (counter) {
            if (now - counter.getWindowStartTime() >= windowSize) {
                counter.reset(now);
            }
        }
    }

    @Override
    protected boolean canAllow(String userId) {
        FixedWindowCounter counter = stores.get(userId);
        synchronized (counter) {
            System.out.println(
                    "Count = " + counter.getRequestCount());
            return counter.getRequestCount() < maxRequests;
        }
    }

    @Override
    protected void updateState(String userId) {
        FixedWindowCounter counter = stores.get(userId);
        synchronized (counter) {
            counter.increment();
        }
    }

    @Override
    protected RateLimitResponse buildSuccessResponse(String userId) {
        FixedWindowCounter counter = stores.get(userId);

        synchronized (counter) {
            return new RateLimitResponse(
                    true,
                    maxRequests - counter.getRequestCount(),
                    0
            );
        }
    }

    @Override
    protected RateLimitResponse buildErrorResponse(String userId) {
        FixedWindowCounter counter = stores.get(userId);

        synchronized (counter) {
            long retryAfter = (counter.getWindowStartTime() + windowSize - System.currentTimeMillis()) / 1000;
            return new RateLimitResponse(
                    false,
                    0,
                    retryAfter
            );
        }
    }
}
