package xyz.tcbuildmc.common.liteconfig.io;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.nio.file.Path;

public class SnakeYamlSynchronizedFileConfig<T> extends SnakeYamlFileConfig<T> {
    public SnakeYamlSynchronizedFileConfig(Class<T> clazz, File file, Yaml yaml) {
        super(clazz, file, yaml);
    }

    public SnakeYamlSynchronizedFileConfig(Class<T> clazz, File file) {
        super(clazz, file);
    }

    public SnakeYamlSynchronizedFileConfig(Class<T> clazz, Path path, Yaml yaml) {
        super(clazz, path, yaml);
    }

    public SnakeYamlSynchronizedFileConfig(Class<T> clazz, Path path) {
        super(clazz, path);
    }

    public SnakeYamlSynchronizedFileConfig(Class<T> clazz, String filePath, Yaml yaml) {
        super(clazz, filePath, yaml);
    }

    public SnakeYamlSynchronizedFileConfig(Class<T> clazz, String filePath) {
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
