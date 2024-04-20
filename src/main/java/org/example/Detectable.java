package org.example;

import java.util.Map;
import java.util.Optional;

public interface Detectable {
    DetectionResult detect(String filename);
}
