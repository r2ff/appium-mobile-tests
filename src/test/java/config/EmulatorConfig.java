package config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.LoadPolicy(MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/local.properties"
})

public interface EmulatorConfig extends Config {

    @Key("emulator.app")
    @DefaultValue("src/test/resources/app-alpha-universal-release.apk")
    String getEmulatorApp();

    @Key("emulator.url")
    @DefaultValue("http://127.0.0.1:4723/wd/hub")
    String getEmulatorUrl();

    @Key("local.device.name")
    @DefaultValue("Pixel_4_API_30")
    String getEmulatorDevice();

    @Key("local.os.version")
    @DefaultValue("11.0")
    String getEmulatorOsVersion();
}