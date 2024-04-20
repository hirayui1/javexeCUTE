package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        for (String arg : args) {
            System.out.println(arg);
        }

        DetectionResult a = new DetectionResult();

//        Arrays.stream(args).forEach(System.out::println);
        /**
         * imagine:
         * - request sent from client (/scala)
         * - we have client code
         * - we gonna run it on the machine
         */
//        Scanner scan = new Scanner(System.in);
//        var givenInput = scan.nextLine().split(" ");

      /*  String[] givenInput = new String[2];

        for (int i = 0; i < givenInput.length; i++) {
            System.out.println("input now: ");
            givenInput[i] = scan.nextLine();
        }*/
//        var givenInput = new String[] {"program.java", "java"};

        // Execute the command - creates a running problam
        Process process = Runtime
                .getRuntime()
                .exec(args);

        // Read the output of the process
        BufferedReader success  = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader error  = process.errorReader();

        String line;
        var successStr = new StringBuilder();
        var errorStr = new StringBuilder();

        while ((line = success.readLine()) != null) {
            successStr.append(line);
        }

        while ((line = error.readLine()) != null) {
            errorStr.append(line);
        }

        // Wait for the process to complete
        int exitCode = process.waitFor();

        success.close();

        if (successStr.isEmpty()) {
            System.out.println(errorStr);
        } else {
            System.out.println(successStr);
        }
    }
}
