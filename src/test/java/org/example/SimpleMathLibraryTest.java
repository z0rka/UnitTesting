package org.example;

import java.lang.reflect.Method;
import java.util.Arrays;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

/**
 * @author Kostiantyn Kvartyrmeister on 03.12.2022 Class test {@link SimpleMathLibrary} class
 * methods
 */
class SimpleMathLibraryTest {

  private int tests = 0;
  private int failedTests = 0;
  /**
   * Test method and our test class object to make count for console/file print
   */
  private static SimpleMathLibrary<Integer> math;
  private static final SimpleMathLibraryTest test = new SimpleMathLibraryTest();

  /**
   * Method prints info about tests in console
   */
  @AfterAll
  private static void printConsole() {
    long test = countTests();
    long disabled = countDisabled();

    System.out.println(test + " tests found");
    System.out.println(test - disabled + " tests started");
    System.out.println(disabled + " tests skipped");
  }

  /**
   * Method count test methods marker with {@link Disabled}
   */
  private static long countDisabled() {
    Method[] declaredMethods = test.getClass().getDeclaredMethods();
    return Arrays.stream(declaredMethods)
        .filter(method -> method.isAnnotationPresent(Disabled.class))
        .count();
  }

  /**
   * Method count test methods marker with {@link Test}
   */
  private static long countTests() {
    Method[] declaredMethods = test.getClass().getDeclaredMethods();
    return Arrays.stream(declaredMethods)
        .filter(method -> method.isAnnotationPresent(Test.class))
        .count();
  }

  /**
   * Method inits private fields
   */
  @BeforeAll
  private static void init() {
    math = new SimpleMathLibrary<>();
  }

  /**
   * Method test add method from our class
   */
  @Test
  void testAdd() {

    Double d = math.add(5, 3);

    try {
      Assertions.assertEquals(13.0, d);
    } catch (AssertionFailedError e) {
      failedTests++;
    }

    Double d1 = math.add(null, 5);
    Assertions.assertEquals(-1.0, d1);

    if (d == 13.0 && d1 == -1.0) {
      System.out.println("Ok");
    } else {
      System.out.println("NOK");
    }
  }

  /**
   * Method test minus method from our class
   */
  @Test
  void testMinus() {
    Double d = math.minus(10, 8);
    Assertions.assertEquals(2.0, d);

    Double d1 = math.minus(null, 8);
    Assertions.assertEquals(-1.0, d1);

    if (d == 2.0 && d1 == -1.0) {
      System.out.println("Ok");
    } else {
      System.out.println("NOK");
    }
  }

}
