package models;

public class PatternFormatter implements LogFormatter {
    private final String pattern;

    public PatternFormatter(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String format(LogMessage logMessage) {
        return pattern
                .replace("%d", logMessage.getThreadName())
                .replace("%p", logMessage.getLogLevel().name())
                .replace("%c", logMessage.getLoggerName())
                .replace("%t", logMessage.getThreadName())
                .replace("%m", logMessage.getMessage());
    }
}
