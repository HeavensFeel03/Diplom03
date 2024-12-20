package ru.iteco.fmhandroid.ui.test;

import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;

import android.content.Intent;

import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.page.AboutPage;
import ru.iteco.fmhandroid.ui.data.steps.AboutSteps;
import ru.iteco.fmhandroid.ui.data.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.data.steps.MenuBarSteps;

@DisplayName("Сценарии тестирования страницы AboutPage")
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AboutPageTest {
    AuthorizationSteps authPage = new AuthorizationSteps();
    MenuBarSteps menuBar = new MenuBarSteps();
    AboutSteps aboutSteps = new AboutSteps();
    AboutPage aboutPage = new AboutPage();

    @Rule
    public ActivityScenarioRule<AppActivity> ActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        try {
            menuBar.openAboutPage();
        } catch (Exception e) {
            authPage.authUser();
            menuBar.openAboutPage();
            aboutPage.waitingPageLoad();
        }

    }


    @Description("Открытие ссылки Privacy Policy")
    @Test
    public void shouldOpeningPrivacyPolicyLink() {
        Intents.init();
        aboutSteps.clickPrivacyPolicyLinc();
        intended(hasData("https://vhospice.org/#/privacy-policy"));
        intended(hasAction(Intent.ACTION_VIEW));
        Intents.release();
    }


    @Description("Открытие ссылки Terms of use")
    @Test
    public void shouldOpeningTermsOfUseLink() {
        Intents.init();
        aboutSteps.clickTermsOfUseLinc();
        intended(hasData("https://vhospice.org/#/terms-of-use"));
        intended(hasAction(Intent.ACTION_VIEW));
        Intents.release();
    }

}


