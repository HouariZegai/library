package com.houarizegai.bookapi.util;

import java.util.Objects;
import java.util.UUID;

public class StringUtil {

    private StringUtil() {
    }

    public static String uuidToStringSafe(UUID uuid) {
        return Objects.nonNull(uuid) ? uuid.toString() : null;
    }

    public static UUID stringToUuidSafe(String uuid) {
        return Objects.nonNull(uuid) ? UUID.fromString(uuid) : null;
    }
}
