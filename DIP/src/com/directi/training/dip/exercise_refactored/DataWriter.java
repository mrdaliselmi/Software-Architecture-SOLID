package com.directi.training.dip.exercise_refactored;

import java.io.IOException;

public interface DataWriter {
    int writeData(String inputString) throws IOException;
}
