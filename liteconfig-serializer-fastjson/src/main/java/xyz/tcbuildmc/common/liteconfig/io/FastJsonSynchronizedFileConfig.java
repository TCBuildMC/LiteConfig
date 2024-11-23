package xyz.tcbuildmc.common.liteconfig.io;

import java.io.File;
import java.nio.file.Path;

public class FastJsonSynchronizedFileConfig<T> extends FastJsonFileConfig<T> {

    public FastJsonSynchronizedFileConfig(Class<T> clazz, File file) {
        super(clazz, file);
    }

    public FastJsonSynchronizedFileConfig(Class<T> clazz, Path path) {
        super(clazz, path);
    }

    public FastJsonSynchronizedFileConfig(Class<T> clazz, String filePath) {
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
