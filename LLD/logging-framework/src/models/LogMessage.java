package models;

import java.time.LocalDateTime;

public class LogMessage {
    private final LocalDateTime timestamp;
    private final LogLevel logLevel;
    private final String loggerName;
    private final String threadName;
    private final String message;

    LogMessage(LogLevel logLevel, String loggerName, String message) {
        this.timestamp = LocalDateTime.now();
        this.logLevel = logLevel;
        this.loggerName = loggerName;
        this.message = message;
        this.threadName = Thread.currentThread().getName();
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public String getLoggerName() {
        return loggerName;
    }

    public String getThreadName() {
        return threadName;
    }

    public String getMessage() {
        return message;
    }
}
