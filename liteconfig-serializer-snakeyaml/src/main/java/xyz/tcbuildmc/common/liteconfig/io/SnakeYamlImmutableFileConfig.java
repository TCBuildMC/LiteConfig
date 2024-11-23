package xyz.tcbuildmc.common.liteconfig.io;

import org.yaml.snakeyaml.Yaml;
import xyz.tcbuildmc.common.liteconfig.LiteConfigSnakeYaml;
import xyz.tcbuildmc.common.liteconfig.util.FileUtils;

import java.io.File;
import java.nio.file.Path;

public class SnakeYamlImmutableFileConfig<T> extends ImmutableFileConfig<T> {
    private final Yaml yaml;

    public SnakeYamlImmutableFileConfig(Class<T> clazz, File file, Yaml yaml) {
        super(clazz, file);
        this.yaml = yaml;
    }

    public SnakeYamlImmutableFileConfig(Class<T> clazz, File file) {
        this(clazz, file, LiteConfigSnakeYaml.defaultYaml());
    }

    public SnakeYamlImmutableFileConfig(Class<T> clazz, Path path, Yaml yaml) {
        super(clazz, path);
        this.yaml = yaml;
    }

    public SnakeYamlImmutableFileConfig(Class<T> clazz, Path path) {
        this(clazz, path, LiteConfigSnakeYaml.defaultYaml());
    }

    public SnakeYamlImmutableFileConfig(Class<T> clazz, String filePath, Yaml yaml) {
        super(clazz, filePath);
        this.yaml = yaml;
    }

    public SnakeYamlImmutableFileConfig(Class<T> clazz, String filePath) {
        this(clazz, filePath, LiteConfigSnakeYaml.defaultYaml());
    }

    @Override
    public void load() {
        String yaml = FileUtils.read(this.file);
        this.instance = this.yaml.loadAs(yaml, this.clazz); // FIXME
    }
}
