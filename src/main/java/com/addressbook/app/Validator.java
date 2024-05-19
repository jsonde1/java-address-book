package com.addressbook.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    //will support most Latin-script names
    final Pattern nameRegex = Pattern.compile("^([a-zA-Z]{2,}\\s[a-zA-Z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{1,})?)");

    public boolean validName(String name){
        Matcher matcher = nameRegex.matcher(name);
        return matcher.matches();
    }
}
