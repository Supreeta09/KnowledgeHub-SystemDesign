package models;

public class JsonFormatter implements LogFormatter {
    @Override
    public String format(LogMessage logMessage) {
        return "{"
                + "\"timestamp\":\"" + logMessage.getThreadName() + "\","
                + "\"level\":\"" + logMessage.getLogLevel() + "\","
                + "\"logger\":\"" + logMessage.getLoggerName() + "\","
                + "\"message\":\"" + logMessage.getMessage() + "\""
                + "}";
    }
}
