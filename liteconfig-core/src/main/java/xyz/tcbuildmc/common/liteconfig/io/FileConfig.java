package xyz.tcbuildmc.common.liteconfig.io;

import xyz.tcbuildmc.common.liteconfig.api.AbstractConfig;

import java.io.File;
import java.nio.file.Path;

public abstract class FileConfig<T> extends AbstractConfig<T> {
    protected final File file;

    public FileConfig(Class<T> clazz, File file) {
        super(clazz);
        this.file = file;
    }

    public FileConfig(Class<T> clazz, Path path) {
        this(clazz, path.toFile());
    }

    public FileConfig(Class<T> clazz, String filePath) {
        this(clazz, new File(filePath));
    }
}
