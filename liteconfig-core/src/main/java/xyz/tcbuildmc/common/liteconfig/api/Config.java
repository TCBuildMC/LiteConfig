package xyz.tcbuildmc.common.liteconfig.api;

public interface Config<T> {
    void load();

    void save();

    T getInstance();

    boolean isPresent();
}
