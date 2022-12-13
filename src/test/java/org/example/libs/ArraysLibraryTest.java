package org.example.libs;

import org.example.MyRuntimeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Kostiantyn Kvartyrmeister on 13.12.2022
 */
class ArraysLibraryTest {

  private static final ArraysLibrary library = new ArraysLibrary();

  @Test
  void testChecker() {
    Integer[] integers = {4, 1, 4, 1, 1, 4, 1};
    Integer[] integers2 = {4, 1, 4, 1, 1, 4, 1, 6};

    boolean test = library.checkForNumbers(integers, 4, 1);
    Assertions.assertTrue(test);

    test = library.checkForNumbers(null, 4, 1);
    Assertions.assertFalse(test);

    test = library.checkForNumbers(integers2, 4, 1);
    Assertions.assertFalse(test);

    test = library.checkForNumbers(integers2, 6, 1);
    Assertions.assertFalse(test);
  }

  void testAfterLastNumberGiven() {
    Integer[] integers2 = {4, 3, 7, 8, 1, 2, 1, 6};

    try {
      library.afterLastNumberGiven(integers2, 2);

      library.afterLastNumberGiven(null, 3);

      library.afterLastNumberGiven(integers2, 6);

      library.afterLastNumberGiven(integers2, 4);
    } catch (MyRuntimeException e) {
      throw new RuntimeException(e);
    }


  }
}
}
