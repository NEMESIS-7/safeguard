package com.reynolds.safeguard.shared.api;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

public record CursorPage<T>(
        List<T> content,
        String nextCursor,
        boolean hasMore
) {

    public static <T> CursorPage<T> of(List<T> content, String nextCursor) {
        return new CursorPage<>(content, nextCursor, nextCursor != null);
    }

    public static <T> CursorPage<T> empty() {
        return new CursorPage<>(List.of(), null, false);
    }

    public static <E, T> CursorPage<T> from(List<E> rows, int limit, Function<E, UUID> idOf, Function<E, T> mapper) {
        boolean hasMore = rows.size() > limit;
        List<E> page = hasMore ? rows.subList(0, limit) : rows;
        String nextCursor = hasMore ? idOf.apply(page.get(page.size() - 1)).toString() : null;
        return new CursorPage<>(page.stream().map(mapper).toList(), nextCursor, hasMore);
    }
}
