package com.pluralsight.springboot3fundamentals;

public class NoSuchListException extends RuntimeException {

  public NoSuchListException() {
    super();
  }

  //--------------------------------------------------------------------------------------------------------------------

  public NoSuchListException(String message) {
    super(message);
  }

  //--------------------------------------------------------------------------------------------------------------------

}
