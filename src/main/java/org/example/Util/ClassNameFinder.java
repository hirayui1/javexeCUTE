package org.example.Util;

import spark.Request;

public class ClassNameFinder {
    public static String findClassNameInJava(Request req) {
        String[] split = req.body().split("\n");

        for (String line : split) {

            if (line.contains("public class")){
                String[] words = line.trim().split("\\s+");
                return words[2] + ".java";
            }
        }
        return null;
    }

}
