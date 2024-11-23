package xyz.tcbuildmc.common.liteconfig.io;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import xyz.tcbuildmc.common.liteconfig.LiteConfigGson;
import xyz.tcbuildmc.common.liteconfig.util.FileUtils;

import java.io.File;
import java.nio.file.Path;

public class GsonFileConfig<T> extends FileConfig<T> {
    private final Gson gson;

    public GsonFileConfig(Class<T> clazz, File file, Gson gson) {
        super(clazz, file);
        this.gson = gson;
    }

    public GsonFileConfig(Class<T> clazz, File file) {
        this(clazz, file, LiteConfigGson.defaultGson());
    }

    public GsonFileConfig(Class<T> clazz, Path path, Gson gson) {
        super(clazz, path);
        this.gson = gson;
    }

    public GsonFileConfig(Class<T> clazz, Path path) {
        this(clazz, path, LiteConfigGson.defaultGson());
    }

    public GsonFileConfig(Class<T> clazz, String filePath, Gson gson) {
        super(clazz, filePath);
        this.gson = gson;
    }

    public GsonFileConfig(Class<T> clazz, String filePath) {
        this(clazz, filePath, LiteConfigGson.defaultGson());
    }

    @Override
    public void load() {
        String json = FileUtils.read(this.file);
        this.instance = this.gson.fromJson(json, new TypeToken<T>() {});
    }

    @Override
    public void save() {
        String json = this.gson.toJson(this.instance);
        FileUtils.write(this.file, json);

//        StringBuilder sb = new StringBuilder();
//
//        ReflectionUtils.iterateFields(this.clazz, f -> {
//            try {
//                Object o = f.get(this.instance);
//                String json = this.gson.toJson(o);
//
//                if (f.isAnnotationPresent(Name.class)) {
//                    json = json.replaceFirst(f.getName(), f.getDeclaredAnnotation(Name.class).value());
//                }
//                sb.append(json)
//                        .append(FileUtils.getLineSeparator());
//            } catch (IllegalAccessException e) {
//                throw new RuntimeException(e);
//            }
//        });
//
//        sb.deleteCharAt(sb.length() - 1);
//        FileUtils.write(this.file, sb.toString());
    }
}
