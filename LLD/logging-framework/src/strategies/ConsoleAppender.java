package strategies;

import models.LogFormatter;
import models.LogMessage;

public class ConsoleAppender implements LogAppender {
    private LogFormatter logFormatter;

    @Override
    public void appendMessage(LogMessage logMessage) {
        System.out.println(logFormatter.format(logMessage));
    }

    @Override
    public void setFormatter(LogFormatter logFormatter) {
        this.logFormatter = logFormatter;
    }

    @Override
    public void close() {

    }
}
