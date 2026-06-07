package models;

public class LoggerConfig {
    private final LogLevel logLevel;
    private final String pattern;
    private final String filePath;

    public LoggerConfig(LogLevel logLevel, String pattern, String filePath) {
        this.logLevel = logLevel;
        this.pattern = pattern;
        this.filePath = filePath;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getPattern() {
        return pattern;
    }
}
