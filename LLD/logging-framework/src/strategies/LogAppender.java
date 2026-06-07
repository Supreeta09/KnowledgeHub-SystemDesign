package strategies;

import models.LogFormatter;
import models.LogMessage;

public interface LogAppender {
    void appendMessage(LogMessage logMessage);
    void setFormatter(LogFormatter logFormatter);
    void close();
}
