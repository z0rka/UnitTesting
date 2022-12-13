package org.example.libs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
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
   * Method inits private fields
   */
  @BeforeAll
  private static void init() {
    math = new SimpleMathLibrary<>();
  }

  /**
   * Method test {@link SimpleMathLibrary#add(Number, Number)} method from our class
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
   * Method test {@link SimpleMathLibrary#minus(Number, Number)} method from our class
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
