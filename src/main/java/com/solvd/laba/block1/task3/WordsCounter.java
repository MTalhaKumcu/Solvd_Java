package com.solvd.laba.block1.task3;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordsCounter {

    public static void main(String[] args) {
        File inputFile = new File("src/main/java/com/solvd/laba/block1/task3/input.txt");
        File outputFile = new File("src/main/java/com/solvd/laba/block1/task3/output.txt");

        try {
            // Check if the input file exists
            if (!inputFile.exists()) {
                System.err.println("Error: The input file does not exist.");
                return;
            }

            // Read text from the file
            List<String> lines = FileUtils.readLines(inputFile, StandardCharsets.UTF_8);

            // Calculate the number of unique words
            Set<String> uniqueWords = new HashSet<>();
            for (String line : lines) {
                String[] words = StringUtils.split(line);
                for (String word : words) {
                    uniqueWords.add(word);
                }
            }

            // Write the result to the file
            FileUtils.write(outputFile, "Number of unique words: " + uniqueWords.size(), StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
