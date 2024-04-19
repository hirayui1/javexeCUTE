package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        /**
         * imagine:
         * - request sent from client
         * - we have client code
         * - we gonna run it on the machine
         */

        var cmdArray = new String[] {"java", "Main.java"};

        // Execute the command - creates a running problam
        Process process = Runtime.getRuntime().exec(cmdArray);

        // Read the output of the process
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line;
        var sb = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        // Wait for the process to complete
        int exitCode = process.waitFor();

        reader.close();

        System.out.println("Process exited with code: " + exitCode);
        System.out.println(sb);

    }
}
