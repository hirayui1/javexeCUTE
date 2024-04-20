package org.example;

import java.util.List;

public class DetectionResult {
    String compiler;
    List<String> errors;

    public DetectionResult() {

    }
    public boolean failed() {
        return !errors.isEmpty();
    }

    public boolean succeded() {
        return !failed();
    }
}
