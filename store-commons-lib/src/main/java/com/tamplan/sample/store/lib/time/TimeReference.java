package com.tamplan.sample.store.lib.time;

import java.time.LocalDateTime;

public class TimeReference {

    private static TimeReference timeReference;

    public static TimeReference getInstance() {
        if (timeReference == null) {
            timeReference = new TimeReference();
        }

        return timeReference;
    }

    private TimeReference() {
    }

    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}
