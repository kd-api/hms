package com.krushidj.hms.logger;

import org.slf4j.Logger;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Use this in a try-with-resources block to automatically implement logging timing.
 */
public class TimingLogger implements AutoCloseable {
    private final Logger logger;
    private final String description;
    private final long startTime;
    private final AtomicBoolean closed = new AtomicBoolean(false);

    public TimingLogger(Logger logger, String description) {
        Objects.requireNonNull(logger, "Logger to write to");
        this.logger = logger;
        Objects.requireNonNull(description, "Description of the event we are timing");
        if (description.isEmpty()) {
            throw new IllegalArgumentException("Description may not be empty");
        }
        this.description = description;

        this.startTime = System.currentTimeMillis();
        logger.info(description + " STARTTIME=" + startTime);
    }

    @Override
    public void close() {
        if (closed.compareAndSet(false, true)) {
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            logger.info(description + " ENDTIME=" + endTime + " DURATION=" + duration);

        } else {
            throw new IllegalStateException("TimingLogger for " + description + " is already closed");
        }
    }
}