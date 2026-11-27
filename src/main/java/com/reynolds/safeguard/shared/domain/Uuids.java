package com.reynolds.safeguard.shared.domain;

import com.github.f4b6a3.uuid.UuidCreator;

import java.util.UUID;

/**
 * UUIDv7 = 48 bits ms timestamp + version + 74 random bits.
 * Time-ordered → better index locality than v4 and works as a pagination cursor
 * without a separate created_at tiebreaker.
 */
public final class Uuids {

    private Uuids() {
    }

    public static UUID v7() {
        return UuidCreator.getTimeOrderedEpoch();
    }
}
