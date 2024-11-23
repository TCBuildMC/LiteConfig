package xyz.tcbuildmc.common.liteconfig;

import com.moandjiezana.toml.Toml;
import com.moandjiezana.toml.TomlWriter;

public final class LiteConfigToml4J {
    public static Toml defaultToml() {
        return new Toml();
    }

    public static TomlWriter defaultWriter() {
        return new TomlWriter.Builder().build();
    }
}
