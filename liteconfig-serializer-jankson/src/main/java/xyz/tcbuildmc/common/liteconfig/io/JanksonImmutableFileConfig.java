package xyz.tcbuildmc.common.liteconfig.io;

import blue.endless.jankson.Jankson;
import blue.endless.jankson.api.SyntaxError;
import xyz.tcbuildmc.common.liteconfig.LiteConfigJankson;
import xyz.tcbuildmc.common.liteconfig.util.FileUtils;

import java.io.File;
import java.nio.file.Path;

public class JanksonImmutableFileConfig<T> extends ImmutableFileConfig<T> {
    private final Jankson jankson;

    public JanksonImmutableFileConfig(Class<T> clazz, File file, Jankson jankson) {
        super(clazz, file);
        this.jankson = jankson;
    }

    public JanksonImmutableFileConfig(Class<T> clazz, File file) {
        this(clazz, file, LiteConfigJankson.defaultJankson());
    }

    public JanksonImmutableFileConfig(Class<T> clazz, Path path, Jankson jankson) {
        super(clazz, path);
        this.jankson = jankson;
    }

    public JanksonImmutableFileConfig(Class<T> clazz, Path path) {
        this(clazz, path, LiteConfigJankson.defaultJankson());
    }

    public JanksonImmutableFileConfig(Class<T> clazz, String filePath, Jankson jankson) {
        super(clazz, filePath);
        this.jankson = jankson;
    }

    public JanksonImmutableFileConfig(Class<T> clazz, String filePath) {
        this(clazz, filePath, LiteConfigJankson.defaultJankson());
    }

    @Override
    public void load() {
        String json = FileUtils.read(this.file);
        try {
            this.instance = this.jankson.fromJson(json, this.clazz);
        } catch (SyntaxError e) {
            throw new RuntimeException("Failed to deserialize.", e);
        }
    }
}
