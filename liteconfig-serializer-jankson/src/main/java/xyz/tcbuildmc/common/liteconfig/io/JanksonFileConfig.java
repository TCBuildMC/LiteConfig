package xyz.tcbuildmc.common.liteconfig.io;

import blue.endless.jankson.Jankson;
import blue.endless.jankson.api.SyntaxError;
import xyz.tcbuildmc.common.liteconfig.LiteConfigJankson;
import xyz.tcbuildmc.common.liteconfig.util.FileUtils;

import java.io.File;
import java.nio.file.Path;

public class JanksonFileConfig<T> extends FileConfig<T> {
    private final Jankson jankson;

    public JanksonFileConfig(Class<T> clazz, File file, Jankson jankson) {
        super(clazz, file);
        this.jankson = jankson;
    }

    public JanksonFileConfig(Class<T> clazz, File file) {
        this(clazz, file, LiteConfigJankson.defaultJankson());
    }

    public JanksonFileConfig(Class<T> clazz, Path path, Jankson jankson) {
        super(clazz, path);
        this.jankson = jankson;
    }

    public JanksonFileConfig(Class<T> clazz, Path path) {
        this(clazz, path, LiteConfigJankson.defaultJankson());
    }

    public JanksonFileConfig(Class<T> clazz, String filePath, Jankson jankson) {
        super(clazz, filePath);
        this.jankson = jankson;
    }

    public JanksonFileConfig(Class<T> clazz, String filePath) {
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

    @Override
    public void save() {
        String json = this.jankson.toJson(this.instance).toJson(true, true);
        FileUtils.write(this.file, json);

//        StringBuilder sb = new StringBuilder();
//
//        if (this.clazz.isAnnotationPresent(Comment.class)) {
//            CommentUtils.appendComment(sb, this.clazz.getDeclaredAnnotation(Comment.class));
//        }
//
//        ReflectionUtils.iterateFields(this.clazz, f -> {
//            if (f.isAnnotationPresent(Comment.class)) {
//                CommentUtils.appendComment(sb, f.getDeclaredAnnotation(Comment.class));
//            }
//
//            try {
//                Object o = f.get(this.instance);
//                String json = this.jankson.toJson(o).toJson(true, true);
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
