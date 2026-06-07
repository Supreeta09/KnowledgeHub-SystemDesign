import models.*;
import strategies.ConsoleAppender;
import strategies.DatabaseAppender;
import strategies.FileAppender;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        LogManager logManager = LogManager.getInstance();

        LoggerConfig config = new LoggerConfig(LogLevel.INFO, "[%d] [%p] [%c] %m",
                "app.log");

        Logger logger = logManager.getLogger("User service", config);

        LogFormatter logFormatter = new PatternFormatter(config.getPattern());

        ConsoleAppender console = new ConsoleAppender();
        console.setFormatter(logFormatter);

        FileAppender file = new FileAppender(config.getFilePath());
        file.setFormatter(logFormatter);

        DatabaseAppender database = new DatabaseAppender();
        database.setFormatter(logFormatter);

        logger.addAppender(console);
        logger.addAppender(file);
        logger.addAppender(database);

        logger.info("User created");
        logger.error("User creation failed");
    }
}
