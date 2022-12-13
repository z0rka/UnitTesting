package org.example.libs;

import java.util.Arrays;
import java.util.List;
import lombok.NoArgsConstructor;
import org.example.MyRuntimeException;

/**
 * @author Kostiantyn Kvartyrmeister on 11.12.2022
 */
@NoArgsConstructor
public class ArraysLibrary {

  /**
   * Method takes
   *
   * @param array        - array of numbers
   * @param numberForCut - number before witch all the numbers will be deleted
   * @return array of numbers after numberForCut
   */
  public <T extends Number> Number[] afterLastNumberGiven(T[] array, int numberForCut)
      throws MyRuntimeException {
    if (array == null) {
      return null;
    }

    if (Arrays.stream(array).noneMatch(a -> a.intValue() == 4)) {
      throw new MyRuntimeException("Not proper array");
    }

    List<T> ts = Arrays.stream(array).toList();
    int index = ts.lastIndexOf(numberForCut);

    return ts.stream()
        .skip(index + 1)
        .map(Number::intValue)
        .toList()
        .toArray(new Number[0]);
  }

  public <T extends Number> boolean checkForNumbers(T[] array, int num1, int num2) {
    if (array == null) {
      return false;
    } else
      return Arrays
          .stream(array)
          .toList()
          .stream()
          .allMatch(a -> a.intValue() == num1 || a.intValue() == num2);
  }
}
