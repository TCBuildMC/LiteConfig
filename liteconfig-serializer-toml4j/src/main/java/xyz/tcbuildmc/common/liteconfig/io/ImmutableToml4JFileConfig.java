package xyz.tcbuildmc.common.liteconfig.io;

import com.moandjiezana.toml.Toml;
import xyz.tcbuildmc.common.liteconfig.LiteConfigToml4J;
import xyz.tcbuildmc.common.liteconfig.util.FileUtils;

import java.io.File;
import java.nio.file.Path;

public class ImmutableToml4JFileConfig<T> extends ImmutableFileConfig<T> {
    private final Toml toml;

    public ImmutableToml4JFileConfig(Class<T> clazz, File file, Toml toml) {
        super(clazz, file);
        this.toml = toml;
    }

    public ImmutableToml4JFileConfig(Class<T> clazz, File file) {
        this(clazz, file, LiteConfigToml4J.defaultToml());
    }

    public ImmutableToml4JFileConfig(Class<T> clazz, Path path, Toml toml) {
        super(clazz, path);
        this.toml = toml;
    }

    public ImmutableToml4JFileConfig(Class<T> clazz, Path path) {
        this(clazz, path, LiteConfigToml4J.defaultToml());
    }

    public ImmutableToml4JFileConfig(Class<T> clazz, String filePath, Toml toml) {
        super(clazz, filePath);
        this.toml = toml;
    }

    public ImmutableToml4JFileConfig(Class<T> clazz, String filePath) {
        this(clazz, filePath, LiteConfigToml4J.defaultToml());
    }

    @Override
    public void load() {
        String toml = FileUtils.read(this.file);
        this.instance = this.toml.read(toml).to(this.clazz);
    }
}
