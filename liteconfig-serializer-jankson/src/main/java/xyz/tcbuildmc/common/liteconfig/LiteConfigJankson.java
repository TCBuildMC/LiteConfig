package xyz.tcbuildmc.common.liteconfig;

import blue.endless.jankson.Jankson;

public final class LiteConfigJankson {
    public static Jankson defaultJankson() {
        return Jankson.builder().build();
    }
}
