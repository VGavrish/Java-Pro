package HomeWork9;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger extends Logger {
    private final FileLoggerConfiguration configuration;

    public FileLogger (FileLoggerConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void info(String message) {
        if (configuration.getLoggingLevel() == LoggingLevel.INFO || configuration.getLoggingLevel() == LoggingLevel.DEBAG) {
            log(message, LoggingLevel.INFO);
        }
    }

    @Override
    public void debug(String message) {
        if (configuration.getLoggingLevel() == LoggingLevel.DEBAG) {
            log(message, LoggingLevel.DEBAG);
            log(message, LoggingLevel.INFO);
        }
    }

    private void log(String message, LoggingLevel loggingLevel) {
        File file = new File(configuration.getFilePath());
        String time = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

        try {
            if (file.length() >= configuration.getMaxSize()) {
                String newFileName = "Log_" + time + ".txt";
                File newFile = new File(file.getParent(), newFileName);
                FileWriter fileWriter = new FileWriter(newFile, true);
                fileWriter.write(String.format(configuration.getLogFormat(), time, loggingLevel, message));
                fileWriter.close();
                throw new FileMaxSizeReachedException("Maximum file size reached. Current size: " + file.length()
                        + ", Max size: " + configuration.getMaxSize() + ". A new file" + newFileName + " has been created");
            } else {
                FileWriter fileWriter = new FileWriter(file, true);
                fileWriter.write(String.format(configuration.getLogFormat(), time, loggingLevel, message));
                fileWriter.close();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }catch (FileMaxSizeReachedException e) {
            e.printStackTrace();
        }
    }
}
