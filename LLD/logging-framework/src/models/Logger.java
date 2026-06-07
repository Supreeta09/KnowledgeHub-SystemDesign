package models;

import strategies.LogAppender;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private String name;
    private final LoggerConfig loggerConfig;
    private final List<LogAppender> appenders = new ArrayList<>();

    Logger(String name, LoggerConfig loggerConfig) {
        this.name = name;
        this.loggerConfig = loggerConfig;
    }

    public void addAppender(LogAppender appender) {
        appenders.add(appender);
    }

    public void log(LogLevel logLevel, String message) {
        if (!logLevel.isEnabled(loggerConfig.getLogLevel())) {
            return;
        }

        LogMessage logMessage = new LogMessage(logLevel, name, message);

        write(logMessage);
    }

    private void write(LogMessage logMessage) {
        for (LogAppender appender: appenders) {
            appender.appendMessage(logMessage);
        }
    }

    public void trace(String message) {
        log(LogLevel.TRACE, message);
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void warn(String message) {
        log(LogLevel.WARN, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void fatal(String message) {
        log(LogLevel.FATAL, message);
    }
}
