package org.example.Util;

import spark.Request;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class IOUtil {
    public static void write(String fileName, Request req) {
        File file = new File(fileName);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(req.body());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete(String filename) {
        File file = new File(filename);
        file.delete();
    }
}
