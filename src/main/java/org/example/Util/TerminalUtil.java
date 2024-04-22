package org.example.Util;

import java.io.BufferedReader;
import java.io.IOException;

public class TerminalUtil {
    public static StringBuilder readTerminal(Process process) {
        StringBuilder successStr = new StringBuilder();
        StringBuilder errorStr = new StringBuilder();

        try (BufferedReader success = process.inputReader(); BufferedReader error = process.errorReader()) {
            String line;
            while((line = success.readLine()) != null) {
                successStr.append(line);
            }

            while((line = error.readLine()) != null) {
                errorStr.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return successStr.isEmpty() ? errorStr : successStr;
    }

    public static Process runTerminalCommand(String imageName, String lang, String fileName) {
        String[] cmdArray = {
                "docker",
                "run",
                "--rm",
                "-v",
                System.getProperty("user.dir").concat(":/app"),
                "-w",
                "/app",
                imageName,
                lang,
                fileName
        };
        Process process;
        try {
            process = Runtime.getRuntime().exec(cmdArray);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return process;
    }
}
