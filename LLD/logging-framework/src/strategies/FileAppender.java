package strategies;

import models.LogFormatter;
import models.LogMessage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements LogAppender {
    private final BufferedWriter writer;
    private LogFormatter logFormatter;

    public FileAppender(String filePath) throws IOException {
        writer = new BufferedWriter(new FileWriter(filePath, true));
    }

    @Override
    public void appendMessage(LogMessage logMessage) {
        try {
            writer.write(logFormatter.format(logMessage));
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setFormatter(LogFormatter logFormatter) {
        this.logFormatter = logFormatter;
    }

    @Override
    public void close() {
        try {
            writer.close();
        } catch (Exception ignored) {
        }
    }
}
