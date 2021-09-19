package tests;

import com.codeborne.selenide.Configuration;
import config.DeviceHost;
import config.EmulatorConfig;
import config.LocalConfig;
import drivers.BrowserStackMobileDriver;
import drivers.LocalMobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.Attach.getSessionId;

public class TestBase {

    static DeviceHost config = ConfigFactory.create(DeviceHost.class, System.getProperties());

    @BeforeAll
    public static void setup() {
        addListener("AllureSelenide", new AllureSelenide());

        switch (config.getDeviceHost()) {
            case "browserstack":
                Configuration.browser = BrowserStackMobileDriver.class.getName();
                break;
            case "local":
                Configuration.browser = LocalMobileDriver.class.getName();
                break;
            case "emulator":
                Configuration.browser = EmulatorConfig.class.getName();
                break;
            default:
                Configuration.browser = LocalMobileDriver.class.getName();
                break;
        }
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void startDriver() {
        open();
    }

    @AfterEach
    public void afterEach() {
//        String sessionId = getSessionId();
//
//        Attach.screenshotAs("Last screenshot");
//        Attach.pageSource();
////        Attach.browserConsoleLogs();
        closeWebDriver();
//        Attach.attachVideo(sessionId);

    }
}