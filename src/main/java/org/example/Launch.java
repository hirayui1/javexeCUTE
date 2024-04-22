package org.example;

import org.example.Util.IOUtil;
import org.example.Util.TerminalUtil;
import spark.Request;
import spark.Response;

import static spark.Spark.get;

public class Launch {
    /**
     * open socket at host: localhost and port: 4567
     * while (true) {
     * listen to oncoming connections
     * accept connection
     * expose resource URL - /python or /hello
     * process request - read user data, process
     * respond back - send back HTTP response (200, 404, 201)
     * }
     */
    public static void main(String[] args) {
        start();
    }
    private static void start() {
        get("/:lang", (Request req, Response res) -> {
            // send the code from client
            // read the code from request
            // create a file with name: "python.py" and write the user code into it
            // and pass it into cmdArray
            // try to add timeout - 5 seconds

            String lang = req.params(":lang");
            if(
            SupportedLangs.supports(lang, req)){

            String fileName = SupportedLangs.getFileName();
            String imageName = SupportedLangs.getImageName();

            IOUtil.write(fileName, req);

            StringBuilder finalOutput = TerminalUtil.readTerminal(TerminalUtil.runTerminalCommand(imageName, lang, fileName));
            IOUtil.delete(fileName);
            return finalOutput;
            } else {
                res.type("text/plain");
                return "Your lang/parameter is not supported or incorrectly entered";
            }
        });
    }
}