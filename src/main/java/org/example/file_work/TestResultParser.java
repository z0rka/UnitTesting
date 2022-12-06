package org.example.file_work;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import lombok.NoArgsConstructor;

/**
 * @author Kostiantyn Kvartyrmeister on 06.12.2022
 */
@NoArgsConstructor
public class TestResultParser {

  private int findAmount(String[] s) {
    Iterator<String> iterator = Arrays.stream(s).iterator();
    AtomicReference<String> amount = null;

    iterator.forEachRemaining(s1 -> {
      if (s1.contains("test") || s1.contains("tests")) {
        if (iterator.next().matches("[-+]?\\d+")) {
          amount.set(iterator.next());
        }
      }
    });

    return Integer.parseInt(amount.get());
  }

  private void read(File file) {
    String str;
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      str = reader.readLine();
      while (str != null) {
        if (str.toLowerCase().contains("test") || str.toLowerCase().contains("tests")) {
          String[] s = str.split(" ");
          findAmount(s);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void parse(String path) {
    File file = new File(path);
    read(file);
  }

  public void parse(File file) {
    read(file);
  }

  public void parse(Path path) {
    File file = path.toFile();
    read(file);
  }
}
