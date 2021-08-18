package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "system:properties"
})

public interface DeviceHost extends Config {

    @Key("deviceHost")
    @DefaultValue("local")
    String getDeviceHost();
}
