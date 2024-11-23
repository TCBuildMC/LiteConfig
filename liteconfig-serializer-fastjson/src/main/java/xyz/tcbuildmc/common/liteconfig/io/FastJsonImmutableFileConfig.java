package xyz.tcbuildmc.common.liteconfig.io;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import xyz.tcbuildmc.common.liteconfig.util.FileUtils;

import java.io.File;
import java.nio.file.Path;

public class FastJsonImmutableFileConfig<T> extends ImmutableFileConfig<T> {
    public FastJsonImmutableFileConfig(Class<T> clazz, File file) {
        super(clazz, file);
    }

    public FastJsonImmutableFileConfig(Class<T> clazz, Path path) {
        super(clazz, path);
    }

    public FastJsonImmutableFileConfig(Class<T> clazz, String filePath) {
        super(clazz, filePath);
    }

    @Override
    public void load() {
        String json = FileUtils.read(this.file);
        this.instance = JSON.parseObject(json, new TypeReference<T>() {});
    }
}
