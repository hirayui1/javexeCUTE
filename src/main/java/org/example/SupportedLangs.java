package org.example;


import java.sql.SQLOutput;

public class SupportedLangs {
    public static boolean supports(String lang) {
        return lang != null && switch (lang.toLowerCase()) {
            case "python" -> true;
            case "scala" -> true;
            default -> false;
        };
    }
}
