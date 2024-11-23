package xyz.tcbuildmc.common.liteconfig.io;

import com.google.gson.Gson;

import java.io.File;
import java.nio.file.Path;

public class GsonSynchronizedFileConfig<T> extends GsonFileConfig<T> {
    public GsonSynchronizedFileConfig(Class<T> clazz, File file, Gson gson) {
        super(clazz, file, gson);
    }

    public GsonSynchronizedFileConfig(Class<T> clazz, File file) {
        super(clazz, file);
    }

    public GsonSynchronizedFileConfig(Class<T> clazz, Path path, Gson gson) {
        super(clazz, path, gson);
    }

    public GsonSynchronizedFileConfig(Class<T> clazz, Path path) {
        super(clazz, path);
    }

    public GsonSynchronizedFileConfig(Class<T> clazz, String filePath, Gson gson) {
        super(clazz, filePath, gson);
    }

    public GsonSynchronizedFileConfig(Class<T> clazz, String filePath) {
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
