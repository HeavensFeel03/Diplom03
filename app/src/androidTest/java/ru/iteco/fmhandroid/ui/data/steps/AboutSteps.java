package ru.iteco.fmhandroid.ui.data.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.data.Utility;
import ru.iteco.fmhandroid.ui.data.page.AboutPage;

public class AboutSteps {


    AboutPage aboutPage = new AboutPage();


    public void waitingPageLoad() {
        Allure.step("Ожидание загрузки страницы");
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.about_version_title_text_view, 7000));
    }

    public void pageVisible() {
        Allure.step("Проверка видимости элементов на странице");
        aboutPage.titleVersion.check(ViewAssertions.matches(isDisplayed()));
        aboutPage.titleVersion.check(matches(ViewMatchers.withText("Version:")));
        aboutPage.versionValue.check(ViewAssertions.matches(isDisplayed()));
        aboutPage.versionValue.check(matches(ViewMatchers.withText("1.0.0")));
        aboutPage.privacyPolicy.check(ViewAssertions.matches(isDisplayed()));
        aboutPage.privacyPolicy.check(matches(ViewMatchers.withText("Privacy Policy:")));
        aboutPage.privacyPolicyLinc.check(ViewAssertions.matches(isDisplayed()));
        aboutPage.termsOfUse.check(ViewAssertions.matches(isDisplayed()));
        aboutPage.termsOfUse.check(matches(ViewMatchers.withText("Terms of use:")));
        aboutPage.termsOfUseLinc.check(ViewAssertions.matches(isDisplayed()));
        aboutPage.infoLabel.check(ViewAssertions.matches(isDisplayed()));
        aboutPage.backButton.check(ViewAssertions.matches(isDisplayed()));
    }

    public void pageClickable() {
        Allure.step("Проверка кликабельности элементов на странице");
        aboutPage.privacyPolicyLinc.check(ViewAssertions.matches(isClickable()));
        aboutPage.termsOfUseLinc.check(ViewAssertions.matches(isClickable()));
        aboutPage.backButton.check(ViewAssertions.matches(isClickable()));
    }

    public void clickBackButton() {
        Allure.step("Возвращение на предыдущую страницу");
        aboutPage.backButton.perform(click());
    }

    public void clickPrivacyPolicyLinc() {
        Allure.step("Переход по ссылке Privacy Policy");
        aboutPage.privacyPolicyLinc.perform(click());
    }

    public void clickTermsOfUseLinc() {
        Allure.step("Переход по ссылке Terms of use");
        aboutPage.termsOfUseLinc.perform(click());
    }

}
