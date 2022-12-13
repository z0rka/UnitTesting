package org.example.libs;

import lombok.NoArgsConstructor;

/**
 * @author Kostiantyn Kvartyrmeister on 03.12.2022 Class realised to add and minus numbers
 */
@NoArgsConstructor
public class SimpleMathLibrary<T extends Number> {

  /**
   * Method ads number to number
   *
   * @param a T that extends Number
   * @param b T that extends Number
   * @return Double
   */
  double add(T a, T b) {
    if (a == null || b == null) {
      return -1.0;
    }
    return a.doubleValue() + b.doubleValue();
  }

  /**
   * Method minuses number to number
   *
   * @param a T that extends Number
   * @param b T that extends Number
   * @return Double
   */
  double minus(T a, T b) {
    if (a == null || b == null) {
      return -1.0;
    }
    return a.doubleValue() - b.doubleValue();
  }
}
