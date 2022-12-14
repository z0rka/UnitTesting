package org.example.exceptions;

/**
 * @author Kostiantyn Kvartyrmeister on 14.12.2022
 */
public class WrongFileException extends Exception {

  public WrongFileException(String message) {
    super(message);
  }
}
