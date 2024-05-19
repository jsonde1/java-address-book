package com.addressbook.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    // Will support Latin-script names
    private final Pattern nameRegex = Pattern.compile("^([a-zA-Z]{2,}\\s[a-zA-Z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{1,})?)");
    // Will support UK mobile numbers including starting with 447 but NOT +447
    private final Pattern phoneNumberRegex = Pattern.compile("^(07\\d{8,12}|447\\d{7,11})$");
    // Will support emails conforming to RFC-5322 standards
    private final Pattern emailRegex = Pattern.compile(("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"));

    public boolean validName(String name){
        Matcher matcher = nameRegex.matcher(name);
        if (!matcher.matches()) throw new IllegalStateException("Name contains illegal characters, does not include a surname or is empty\nThe operation could not be completed\n");
        return true;
    }

    public boolean validPhoneNumber(String number) {
        Matcher matcher = phoneNumberRegex.matcher(number);
        if (!matcher.matches()) throw new IllegalStateException("Phone Number contains illegal characters, is too long or is empty\nThe operation could not be completed\n");
        return matcher.matches();
    }

    public boolean validEmail(String email) {
        Matcher matcher = emailRegex.matcher(email);
        if (!matcher.matches()) throw new IllegalStateException("Email contains illegal characters, is too long or is empty\nThe operation could not be completed\n");
        return matcher.matches();
    }
    /* Used when editing contact to allow users to specify
       which contact attribute they want to edit
       will only throw exception if ALL parameters are empty */
    public boolean[] checksEmpty(String name, String number, String email) {
        if (name.isEmpty() && number.isEmpty() && email.isEmpty()) throw new IllegalStateException("Please enter at least one value to be changed\n");
        return new boolean[]{name.isEmpty(), number.isEmpty(), email.isEmpty()};
    }
}
