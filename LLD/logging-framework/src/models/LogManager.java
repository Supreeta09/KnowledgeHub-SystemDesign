package models;

import java.util.concurrent.ConcurrentHashMap;

public class LogManager {
    private static final LogManager INSTANCE = new LogManager();

    private final ConcurrentHashMap<String, Logger> loggers = new ConcurrentHashMap<>();

    private LogManager() {}

    public static LogManager getInstance() {
        return INSTANCE;
    }

    public Logger getLogger(String name, LoggerConfig loggerConfig) {
        return loggers.computeIfAbsent(name, key -> new Logger(key, loggerConfig));
    }
}
