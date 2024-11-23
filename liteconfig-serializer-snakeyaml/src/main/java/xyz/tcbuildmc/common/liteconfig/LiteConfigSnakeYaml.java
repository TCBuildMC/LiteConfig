package xyz.tcbuildmc.common.liteconfig;

import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.SafeConstructor;

public final class LiteConfigSnakeYaml {
    public static Yaml defaultYaml() {
        return new Yaml(new SafeConstructor(new LoaderOptions()));
    }
}
