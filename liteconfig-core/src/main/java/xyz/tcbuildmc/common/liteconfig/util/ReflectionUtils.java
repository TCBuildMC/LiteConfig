package xyz.tcbuildmc.common.liteconfig.util;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.function.Consumer;

public final class ReflectionUtils {
    public static void iterateFields(Class<?> clazz, Consumer<Field> consumer) {
        Arrays.stream(clazz.getDeclaredFields())
                .forEach(f -> {
                    boolean access = f.isAccessible();
                    if (!access) {
                        f.setAccessible(true);
                    }

                    consumer.accept(f);
                    f.setAccessible(access);
                });
    }
}
