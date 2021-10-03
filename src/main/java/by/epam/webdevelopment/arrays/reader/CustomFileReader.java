package by.epam.webdevelopment.arrays.reader;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomFileReader {
    private static final Logger logger = LogManager.getLogger(CustomFileReader.class);

    public List<String> readLinesFromFile(String stringFilePath) {
        List<String> lines = new ArrayList<>();
        Path path = Paths.get(stringFilePath);

        try (Stream<String> lineStream = Files.lines(path)) {
            lineStream.map(String::strip)
                    .collect(Collectors.toList())
                    .forEach(line -> {
                        logger.log(Level.INFO, "Read line: " + line);
                        lines.add(line);
                    });
        } catch (IOException e) {
            logger.error("File not found: " + e);
        }

        return lines;
    }
}
