package org.example.file_work;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import lombok.NoArgsConstructor;

/**
 * @author Kostiantyn Kvartyrmeister on 06.12.2022
 */
@NoArgsConstructor
public class TestResultParser {

  private int findAmount(String[] s, String word, String word1) {

    List<String> strings = Arrays.stream(s).toList();
    AtomicReference<String> amount = new AtomicReference<>();

    strings
        .forEach(s1 -> {
          if ((s1.toLowerCase().contains(word) || s1.toLowerCase().contains(word1))
              && strings.size() > (strings.indexOf(s1) + 1) && strings.get(
              strings.indexOf(s1) + 1).matches("[-+]?\\d+")) {

            amount.set(strings.get(strings.indexOf(s1) + 1));
          }
        });

    return Integer.parseInt(amount.get());
  }

  private TestResult objectCreator(int amount, int passed, int failed) {
    return new TestResult(amount, passed, failed);
  }

  private boolean checkResults(int amount, int passed, int failed) {
    return amount == passed + failed;
  }

  private TestResult read(File file) {
    String str;
    int amount = 0;
    int passed = 0;
    int failed = 0;

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

      str = reader.readLine();

      while (str != null) {
        if (str.toLowerCase().contains("test") || str.toLowerCase().contains("tests")) {
          String[] s = str.split(" ");
          amount = findAmount(s, "test", "tests");
        }
        if (str.toLowerCase().contains("passed") || str.toLowerCase()
            .contains("completed")) {
          String[] s = str.split(" ");
          passed = findAmount(s, "passed", "completed");
        }
        if (str.toLowerCase().contains("failed")) {
          String[] s = str.split(" ");
          failed = findAmount(s, "failed", "down");
        }
        str = reader.readLine();
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

    if (checkResults(amount, passed, failed)) {
      return objectCreator(amount, passed, failed);
    }
    return new TestResult(0, 0, 0);
  }

  public TestResult parse(String path) {
    if (path == null) {
      return new TestResult(0, 0, 0);
    }
    File file = new File(path);
    return read(file);
  }

  public TestResult parse(File file) {
    if (file == null) {
      return new TestResult(0, 0, 0);
    }
    return read(file);
  }

  public TestResult parse(Path path) {
    if (path == null) {
      return new TestResult(0, 0, 0);
    }
    File file = path.toFile();
    return read(file);
  }
}
