package com.bridgelabz;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

//import org.junit.Assert;
import com.bridgeLabz.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class FileAPITest {
    public static final String HOME = System.getProperty("user.home");
    public static final String PLAY_WITH_FILES = "TempPlayGround";

    @Test
    public void givenPathWhenCheckedThenConfirm() throws IOException {


        Path homePath = Paths.get(HOME);
        assertTrue(Files.exists(homePath));

        Path playPath = Paths.get(HOME + PLAY_WITH_FILES);
        if (Files.exists(playPath))
            FileUtils.deleteFiles(playPath.toFile());
        assertTrue(Files.notExists(playPath));

        Files.createDirectory(playPath);
        assertTrue(Files.exists(playPath));

        IntStream.range(1, 10).forEach(counter -> {
            Path tempFilePath = Paths.get(playPath + "/temp" + counter);
            Assertions.assertTrue(Files.notExists(tempFilePath));
            try {
                Files.createFile(tempFilePath);
            } catch (IOException e) {
            }
            Assertions.assertTrue(Files.exists(tempFilePath));
        });

        Files.newDirectoryStream(playPath).forEach(System.out::println);
        Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && path.toString().startsWith("temp"))
                .forEach(System.out::println);
    }

}