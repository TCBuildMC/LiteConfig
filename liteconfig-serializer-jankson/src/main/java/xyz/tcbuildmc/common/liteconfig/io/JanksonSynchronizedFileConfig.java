package xyz.tcbuildmc.common.liteconfig.io;

import blue.endless.jankson.Jankson;

import java.io.File;
import java.nio.file.Path;

public class JanksonSynchronizedFileConfig<T> extends JanksonFileConfig<T> {
    public JanksonSynchronizedFileConfig(Class<T> clazz, File file, Jankson jankson) {
        super(clazz, file, jankson);
    }

    public JanksonSynchronizedFileConfig(Class<T> clazz, File file) {
        super(clazz, file);
    }

    public JanksonSynchronizedFileConfig(Class<T> clazz, Path path, Jankson jankson) {
        super(clazz, path, jankson);
    }

    public JanksonSynchronizedFileConfig(Class<T> clazz, Path path) {
        super(clazz, path);
    }

    public JanksonSynchronizedFileConfig(Class<T> clazz, String filePath, Jankson jankson) {
        super(clazz, filePath, jankson);
    }

    public JanksonSynchronizedFileConfig(Class<T> clazz, String filePath) {
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
