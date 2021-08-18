package config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.LoadPolicy(MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/browserstack.properties"
})

public interface BrowserStackConfig extends Config {

    @Key("browserstack.user")
    String getBrowserStackUser();

    @Key("browserstack.key")
    String getBrowserStackKey();

    @Key("browserstack.app")
    @DefaultValue("bs://f7e8d1faabb67c79d7a3a6ae6f25c0cc5828b58f")
    String getBrowserStackApp();

    @Key("browserstack.url")
    @DefaultValue("http://hub.browserstack.com/wd/hub")
    String getBrowserStackUrl();

    @Key("browserstack.device")
    @DefaultValue("Google Pixel 3")
    String getBrowserStackDevice();

    @Key("browserstack.os.version")
    @DefaultValue("9.0")
    String getBrowserStackOsVersion();
}