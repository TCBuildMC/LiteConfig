package xyz.tcbuildmc.common.liteconfig.io;

import xyz.tcbuildmc.common.liteconfig.api.ImmutableConfig;

import java.io.File;
import java.nio.file.Path;

public abstract class ImmutableFileConfig<T> extends FileConfig<T> implements ImmutableConfig<T> {
    public ImmutableFileConfig(Class<T> clazz, File file) {
        super(clazz, file);
    }

    public ImmutableFileConfig(Class<T> clazz, Path path) {
        super(clazz, path);
    }

    public ImmutableFileConfig(Class<T> clazz, String filePath) {
        super(clazz, filePath);
    }
}
