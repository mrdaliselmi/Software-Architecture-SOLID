package com.directi.training.dip.exercise_refactored;

import java.io.IOException;
import java.util.Base64;

public class EncodingModule {
    private DataReader reader;
    private DataWriter writer;

    public EncodingModule(DataReader reader, DataWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void encode() throws IOException {
        String text = reader.readData();
        String encodedLine = Base64.getEncoder().encodeToString(text.getBytes());
        writer.writeData(encodedLine);
    }
}