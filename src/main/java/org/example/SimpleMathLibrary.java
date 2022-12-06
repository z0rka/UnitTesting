package org.example;

import lombok.NoArgsConstructor;

/**
 * @author Kostiantyn Kvartyrmeister on 03.12.2022
 */
@NoArgsConstructor
public class SimpleMathLibrary<T extends Number> {

  double add(T a, T b) {
    if (a == null || b == null) {
      return -1.0;
    }
    return a.doubleValue() + b.doubleValue();
  }

  double minus(T a, T b) {
    if (a == null || b == null) {
      return -1.0;
    }
    return a.doubleValue() - b.doubleValue();
  }
}
