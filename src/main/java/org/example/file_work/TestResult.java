package org.example.file_work;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Kostiantyn Kvartyrmeister on 06.12.2022
 */
@AllArgsConstructor
@Getter
public class TestResult {

  private int tests;
  private int passedTests;
  private int failedTests;
}
