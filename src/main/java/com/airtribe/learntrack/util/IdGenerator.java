package com.airtribe.learntrack.util;

public class IdGenerator {
    private static int counter = 1;

    public static int nextId() {
        return counter++;
    }
}
