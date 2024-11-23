package xyz.tcbuildmc.common.liteconfig.io;

import com.moandjiezana.toml.Toml;
import com.moandjiezana.toml.TomlWriter;
import xyz.tcbuildmc.common.liteconfig.LiteConfigToml4J;
import xyz.tcbuildmc.common.liteconfig.util.FileUtils;

import java.io.File;
import java.nio.file.Path;

public class Toml4JFileConfig<T> extends FileConfig<T> {
    private final Toml toml;
    private final TomlWriter writer;

    public Toml4JFileConfig(Class<T> clazz, File file, Toml toml, TomlWriter writer) {
        super(clazz, file);
        this.toml = toml;
        this.writer = writer;
    }

    public Toml4JFileConfig(Class<T> clazz, File file) {
        this(clazz, file, LiteConfigToml4J.defaultToml(), LiteConfigToml4J.defaultWriter());
    }

    public Toml4JFileConfig(Class<T> clazz, Path path, Toml toml, TomlWriter writer) {
        super(clazz, path);
        this.toml = toml;
        this.writer = writer;
    }

    public Toml4JFileConfig(Class<T> clazz, Path path) {
        this(clazz, path, LiteConfigToml4J.defaultToml(), LiteConfigToml4J.defaultWriter());
    }

    public Toml4JFileConfig(Class<T> clazz, String filePath, Toml toml, TomlWriter writer) {
        super(clazz, filePath);
        this.toml = toml;
        this.writer = writer;
    }

    public Toml4JFileConfig(Class<T> clazz, String filePath) {
        this(clazz, filePath, LiteConfigToml4J.defaultToml(), LiteConfigToml4J.defaultWriter());
    }

    @Override
    public void load() {
        String toml = FileUtils.read(this.file);
        this.instance = this.toml.read(toml).to(this.clazz);
    }

    @Override
    public void save() {
        String toml = this.writer.write(this.instance);
        FileUtils.write(this.file, toml);
    }
}
