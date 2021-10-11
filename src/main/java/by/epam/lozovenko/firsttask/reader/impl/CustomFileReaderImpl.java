package by.epam.lozovenko.firsttask.reader.impl;

import by.epam.lozovenko.firsttask.reader.CustomFileReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CustomFileReaderImpl implements CustomFileReader {
    private static final Logger logger = LogManager.getLogger(CustomFileReaderImpl.class);

    @Override
    public List<String> readLinesFromFile(String stringFilePath) {
        List<String> lines = new ArrayList<>();
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(stringFilePath);
        if (is != null) {
            try (Stream<String> lineStream = new BufferedReader(new InputStreamReader(is))
                    .lines()) {
                logger.log(Level.INFO, "Found file " + stringFilePath);
                lineStream.map(String::strip)
                        .forEach(line -> {
                            logger.log(Level.INFO, "Read line: " + line);
                            lines.add(line);
                        });
            }
        } else {
            logger.log(Level.ERROR, "File " + stringFilePath + " not found!");
        }
        return lines;
    }
}
