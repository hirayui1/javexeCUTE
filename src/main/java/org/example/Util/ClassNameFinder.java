package org.example.Util;

import spark.Request;

public class ClassNameFinder {
    public static String findClassNameInJava(Request req) {
        String[] split = req.body().split("\n");

        for (String line : split) {
            String[] words = line.trim().split("\\s+");
            boolean isClassName = false;
            for (String word : words) {
                if (isClassName) {
                    return word + ".java";
                }
                if (word.equalsIgnoreCase("class")) {
                    isClassName = true;

                }
            }
        }
        return null;
    }
}
