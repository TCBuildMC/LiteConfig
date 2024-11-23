package xyz.tcbuildmc.common.liteconfig.api;

import org.jetbrains.annotations.Nullable;

public abstract class AbstractConfig<T> implements Config<T> {
    protected final Class<T> clazz;
    @Nullable
    protected T instance;

    public AbstractConfig(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Nullable
    @Override
    public T getInstance() {
        return this.instance;
    }

    @Override
    public boolean isPresent() {
        return this.instance != null;
    }
}
