package xyz.tcbuildmc.common.liteconfig.io;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import xyz.tcbuildmc.common.liteconfig.util.FileUtils;

import java.io.File;
import java.nio.file.Path;

public class FastJsonFileConfig<T> extends FileConfig<T> {
    public FastJsonFileConfig(Class<T> clazz, File file) {
        super(clazz, file);
    }

    public FastJsonFileConfig(Class<T> clazz, Path path) {
        super(clazz, path);
    }


    public FastJsonFileConfig(Class<T> clazz, String filePath) {
        super(clazz, filePath);
    }

    @Override
    public void load() {
        String json = FileUtils.read(this.file);
        this.instance = JSON.parseObject(json, new TypeReference<T>() {});
    }

    @Override
    public void save() {
        String json = JSON.toJSONString(this.instance);
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
