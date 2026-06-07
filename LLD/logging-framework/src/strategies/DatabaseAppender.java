package strategies;

import models.LogFormatter;
import models.LogMessage;

public class DatabaseAppender implements LogAppender {
    private LogFormatter logFormatter;

    @Override
    public void appendMessage(LogMessage logMessage) {
        try {
            Thread.sleep(2000); // simulate slow I/O
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(
                "DB => "
                        + logFormatter.format(logMessage));
    }

    @Override
    public void setFormatter(LogFormatter logFormatter) {
        this.logFormatter = logFormatter;
    }

    @Override
    public void close() {

    }
}
