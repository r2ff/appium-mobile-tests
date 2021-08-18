package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserStackConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BrowserStackMobileDriver implements WebDriverProvider {

    static BrowserStackConfig config = ConfigFactory.create(BrowserStackConfig.class, System.getProperties());

    public static URL getBrowserstackUrl() {
        try {
            return new URL(config.getBrowserStackUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        // Set your access credentials
        desiredCapabilities.setCapability("browserstack.user", config.getBrowserStackUser());
        desiredCapabilities.setCapability("browserstack.key", config.getBrowserStackKey());

        // Set URL of the application under test
        desiredCapabilities.setCapability("app", config.getBrowserStackApp());

        // Specify device and os_version for testing Samsung Galaxy Tab S3 Google Pixel 3
        desiredCapabilities.setCapability("device", config.getBrowserStackDevice());
        desiredCapabilities.setCapability("os_version", config.getBrowserStackOsVersion());

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", "Java Project");
        desiredCapabilities.setCapability("build", "Java Android");
        desiredCapabilities.setCapability("name", "first_test");

        return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);
    }

    private String getAbsolutePath(String filePath) {
        File file = new File(filePath);
        assertTrue(file.exists(), filePath + " not found");

        return file.getAbsolutePath();
    }
}
