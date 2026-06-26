package strategy;

import model.RateLimitResponse;

import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractRateLimitingStrategy implements RateLimitingStrategy {
    @Override
    public RateLimitResponse handleRequest(String userId) {
        refreshState(userId);
        if (canAllow(userId)) {
            updateState(userId);
            return buildSuccessResponse(userId);
        }
        return buildErrorResponse(userId);
    }

    protected abstract void refreshState(String userId);

    protected abstract boolean canAllow(String userId);

    protected abstract void updateState(String userId);

    protected abstract RateLimitResponse buildSuccessResponse(String userId);

    protected abstract RateLimitResponse buildErrorResponse(String userId);
}
