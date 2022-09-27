package com.tamplan.sample.store.lib.event;

import com.tamplan.sample.store.lib.time.TimeReference;

import java.time.LocalDateTime;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

public abstract class BaseEvent {

    private String eventId;
    private LocalDateTime eventDate;
    private String source;
    private String type;

    public BaseEvent(TimeReference timeReference, String source, String type) {
        requireNonNull(timeReference);
        requireNonNull(source);
        requireNonNull(type);
        this.source = source;
        this.type = type;
        this.eventId = UUID.randomUUID().toString();
        this.eventDate = timeReference.now();
    }

    public BaseEvent(String source, String type) {
        this(TimeReference.getInstance(), source, type);
    }
}
