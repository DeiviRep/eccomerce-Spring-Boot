package com.jalasoft.ecommerce.exception;

public class EmailAlreadyTaken extends RuntimeException{

  public final static String MESSAGE_ERROR = "Email re@gmail.com is already taken";
  public EmailAlreadyTaken(String email) {

    super(String.format(MESSAGE_ERROR,email));
  }
}
