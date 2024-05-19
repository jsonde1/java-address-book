package com.addressbook.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    //will support most Latin-script names
    final Pattern nameRegex = Pattern.compile("^([a-zA-Z]{2,}\\s[a-zA-Z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{1,})?)");
    final Pattern phoneNumberRegex = Pattern.compile("^(07\\d{8,12}|447\\d{7,11})$");

    public boolean validName(String name){
        Matcher matcher = nameRegex.matcher(name);
        return matcher.matches();
    }

    public boolean validPhoneNumber(String number) {
        Matcher matcher = phoneNumberRegex.matcher(number);
        return matcher.matches();
    }
}
