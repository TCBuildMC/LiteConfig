package xyz.tcbuildmc.common.liteconfig.io;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import xyz.tcbuildmc.common.liteconfig.LiteConfigGson;
import xyz.tcbuildmc.common.liteconfig.util.FileUtils;

import java.io.File;
import java.nio.file.Path;

public class GsonImmutableFileConfig<T> extends ImmutableFileConfig<T> {
    private final Gson gson;

    public GsonImmutableFileConfig(Class<T> clazz, File file, Gson gson) {
        super(clazz, file);
        this.gson = gson;
    }

    public GsonImmutableFileConfig(Class<T> clazz, File file) {
        this(clazz, file, LiteConfigGson.defaultGson());
    }

    public GsonImmutableFileConfig(Class<T> clazz, Path path, Gson gson) {
        super(clazz, path);
        this.gson = gson;
    }

    public GsonImmutableFileConfig(Class<T> clazz, Path path) {
        this(clazz, path, LiteConfigGson.defaultGson());
    }

    public GsonImmutableFileConfig(Class<T> clazz, String filePath, Gson gson) {
        super(clazz, filePath);
        this.gson = gson;
    }

    public GsonImmutableFileConfig(Class<T> clazz, String filePath) {
        this(clazz, filePath, LiteConfigGson.defaultGson());
    }

    @Override
    public void load() {
        String json = FileUtils.read(this.file);
        this.instance = this.gson.fromJson(json, new TypeToken<T>() {});
    }
}
