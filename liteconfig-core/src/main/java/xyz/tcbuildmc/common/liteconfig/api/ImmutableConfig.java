package xyz.tcbuildmc.common.liteconfig.api;

public interface ImmutableConfig<T> extends Config<T> {
    @Override
    default void save() {
        throw new UnsupportedOperationException("This config is immutable.");
    }
}
