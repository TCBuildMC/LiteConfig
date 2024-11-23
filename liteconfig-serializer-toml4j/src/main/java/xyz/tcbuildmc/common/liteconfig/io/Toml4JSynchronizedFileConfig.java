package xyz.tcbuildmc.common.liteconfig.io;

import com.moandjiezana.toml.Toml;
import com.moandjiezana.toml.TomlWriter;

import java.io.File;
import java.nio.file.Path;

public class Toml4JSynchronizedFileConfig<T> extends Toml4JFileConfig<T> {
    public Toml4JSynchronizedFileConfig(Class<T> clazz, File file, Toml toml, TomlWriter writer) {
        super(clazz, file, toml, writer);
    }

    public Toml4JSynchronizedFileConfig(Class<T> clazz, File file) {
        super(clazz, file);
    }

    public Toml4JSynchronizedFileConfig(Class<T> clazz, Path path, Toml toml, TomlWriter writer) {
        super(clazz, path, toml, writer);
    }

    public Toml4JSynchronizedFileConfig(Class<T> clazz, Path path) {
        super(clazz, path);
    }

    public Toml4JSynchronizedFileConfig(Class<T> clazz, String filePath, Toml toml, TomlWriter writer) {
        super(clazz, filePath, toml, writer);
    }

    public Toml4JSynchronizedFileConfig(Class<T> clazz, String filePath) {
        super(clazz, filePath);
    }

    @Override
    public void load() {
        synchronized (this) {
            super.load();
        }
    }

    @Override
    public void save() {
        synchronized (this) {
            super.save();
        }
    }
}
