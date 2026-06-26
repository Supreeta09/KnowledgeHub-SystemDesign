package model;

public class FixedWindowCounter {
    private int requestCount;
    private long windowStartTime;

    public FixedWindowCounter(int requestCount, long windowStartTime) {
        this.requestCount = requestCount;
        this.windowStartTime = windowStartTime;
    }

    public int getRequestCount() {
        return requestCount;
    }

    public long getWindowStartTime() {
        return windowStartTime;
    }

    public void increment() {
        requestCount++;
    }

    public void reset(long newStartTime) {
        requestCount = 0;
        windowStartTime = newStartTime;
    }
}
