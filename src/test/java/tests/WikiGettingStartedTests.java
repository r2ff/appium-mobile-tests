package tests;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class WikiGettingStartedTests extends TestBase{

    @Test
    @DisplayName("Verify getting started")
    void verifyText() {
        step("Verify text The free Encyclopedia", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("The free Encyclopedia")));
        step("Tap Continue", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Verify text New ways to explore", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("New ways to explore")));
        step("Tap Continue", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Verify text Reading lists with sync", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("Reading lists with sync")));
        step("Tap Continue", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Press Getting Started button", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button"))
                    .click();
        });
        step("Search Wikipedia should be appear", () -> {
            $( $(MobileBy.AccessibilityId("Search Wikipedia")).shouldBe(appear));
        });
    }
}
