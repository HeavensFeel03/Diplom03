package ru.iteco.fmhandroid.ui.data.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.data.Utility;
import ru.iteco.fmhandroid.ui.data.page.AboutPage;
import ru.iteco.fmhandroid.ui.data.page.MenuBarPage;

public class MenuBarSteps {

    MenuBarPage menuBarPage = new MenuBarPage();
    //AboutPage aboutPage = new AboutPage();


    public void pageVisible() {
        Allure.step("Проверка видимости элементов на странице");
        menuBarPage.mainMenu.check(matches(isDisplayed()));
        menuBarPage.image.check(matches(isDisplayed()));
        menuBarPage.ourMissionButton.check(matches(isDisplayed()));
        menuBarPage.profileButton.check(matches(isDisplayed()));
    }

    public void pageClickable() {
        Allure.step("Проверка кликабельности элементов на странице");
        menuBarPage.mainMenu.check(matches(isClickable()));
        menuBarPage.ourMissionButton.check(matches(isDisplayed()));
        menuBarPage.profileButton.check(matches(isClickable()));
    }

    public void openMenu() {
        Allure.step("Открытие главного меню");
        menuBarPage.mainMenu.perform(click());
    }

    public void mainMenuVisible() {
        Allure.step("Проверка видимости главного меню");
        menuBarPage.mainButton.check(matches(isDisplayed()));
        menuBarPage.newsButton.check(matches(isDisplayed()));
        menuBarPage.aboutButton.check(matches(isDisplayed()));
    }

    public MainSteps openMainPage() {
        Allure.step("Открытие страницы Main");
        menuBarPage.mainMenu.perform(click());
        menuBarPage.mainButton.perform(click());
        return new MainSteps();
    }

    public NewsSteps openNewsPage() {
        Allure.step("Открытие страницы News");
        menuBarPage.waitingPageLoad();
        menuBarPage.mainMenu.perform(click());
        menuBarPage.newsButton.perform(click());
        return new NewsSteps();
    }

    public AboutSteps openAboutPage() {
        Allure.step("Отркытие страницы About");
        menuBarPage.waitingPageLoad();
        menuBarPage.mainMenu.perform(click());
        menuBarPage.aboutButton.perform(click());
        return new AboutSteps();
    }

    public LoveIsAllSteps openOurMission() {
        Allure.step("Открытие страницы Our Mission");
        menuBarPage.waitingPageLoad();
        menuBarPage.ourMissionButton.perform(click());
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.our_mission_title_text_view, 7000));
        return new LoveIsAllSteps();
    }

    public void openProfileMenu() {
        Allure.step("Открытие меню профиля");
        menuBarPage.profileButton.perform(click());

    }

    public void profileMenuVisible() {
        Allure.step("Проверка видимости меню профиля");
        menuBarPage.logOut.check(matches(isDisplayed()));
        menuBarPage.logOut.check(matches(ViewMatchers.withText("Log out")));
    }

    public AuthorizationSteps exitProfile() {
        Allure.step("Выход из профиля");
        menuBarPage.waitingPageLoad();
        menuBarPage.profileButton.perform(click());
        Utility.waitDisplayed(android.R.id.content, 7000);
        menuBarPage.logOut.perform(click());
        return new AuthorizationSteps();
    }
}
