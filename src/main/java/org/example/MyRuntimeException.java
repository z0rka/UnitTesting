package org.example;

import lombok.NoArgsConstructor;
import org.example.libs.ArraysLibrary;

/**
 * @author Kostiantyn Kvartyrmeister on 13.12.2022
 * Exception that we throw in
 * {@link ArraysLibrary}
 */
@NoArgsConstructor
public class MyRuntimeException extends Exception {

  public MyRuntimeException(String message) {
    super(message);
  }
}
