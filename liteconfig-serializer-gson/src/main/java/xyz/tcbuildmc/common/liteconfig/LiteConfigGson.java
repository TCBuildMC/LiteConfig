package xyz.tcbuildmc.common.liteconfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class LiteConfigGson {
    public static Gson defaultGson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .create();
    }
}
