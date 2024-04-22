package org.example;
import org.example.Util.ClassNameFinder;
import spark.Request;

public class SupportedLangs {
    private static String fileName;
    private static String imageName;
    public static boolean supports(String lang, Request req) {
        return lang != null && switch (lang.toLowerCase()) {
            case "python" -> {
                fileName = "python.py";
                imageName = "python:3";
                yield true;
            }
            case "node" -> {
                fileName = "js.js";
                imageName = "ghost:5-alpine";
                yield true;}
            case "java" -> {
                fileName = ClassNameFinder.findClassNameInJava(req);
                imageName = "openjdk:11";
                yield true;
            }
            default -> false;
        };
    }

    public static String getFileName() {
        return fileName;
    }

    public static String getImageName() {
        return imageName;
    }
}
