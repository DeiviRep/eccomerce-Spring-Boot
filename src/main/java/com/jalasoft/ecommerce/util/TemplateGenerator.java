package com.jalasoft.ecommerce.util;

public class TemplateGenerator {

  public static String generateTemplateConfirmationToken(String name, String url) {
    return "<html>" +
        "<body>" +
        "<h1> Hello " + name + ",</h1>" +
        "<p>Please click the button below to confirm your account:</p>" +
        "<a href='" + url + "'>" +
        "<button>Confirm Account<button>" +
        "</a>" +
        "</body>" +
        "</html>";
  }

}
