package com.aditreilinii.Service;

import java.time.LocalDateTime;

public class Timestamp {

    public static String getTimestamp() {
        return LocalDateTime.now().toString();
    }

}
