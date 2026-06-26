package model;

public class RateLimitResponse {
    private final boolean allowed;
    private final int remainingRequests;
    private final long retryAfterSeconds;

    public RateLimitResponse(boolean allowed, int remainingRequests, long retryAfterSeconds) {
        this.allowed = allowed;
        this.remainingRequests = remainingRequests;
        this.retryAfterSeconds = retryAfterSeconds;
    }

    public boolean isAllowed() {
        return allowed;
    }

    public int getRemainingRequests() {
        return remainingRequests;
    }

    public long getRetryAfterSeconds() {
        return retryAfterSeconds;
    }

    @Override
    public String toString() {
        return "RateLimitResponse{" +
                "allowed=" + allowed +
                ", remainingRequests=" + remainingRequests +
                ", retryAfterSeconds=" + retryAfterSeconds +
                '}';
    }
}
