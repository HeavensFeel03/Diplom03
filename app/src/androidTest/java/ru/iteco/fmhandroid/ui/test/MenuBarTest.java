package ru.iteco.fmhandroid.ui.test;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.page.MenuBarPage;
import ru.iteco.fmhandroid.ui.data.steps.AboutSteps;
import ru.iteco.fmhandroid.ui.data.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.data.steps.LoveIsAllSteps;
import ru.iteco.fmhandroid.ui.data.steps.MenuBarSteps;
import ru.iteco.fmhandroid.ui.data.steps.NewsSteps;

@DisplayName("Сценарии тестирования панели управления")
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class MenuBarTest {
    AuthorizationSteps authPage = new AuthorizationSteps();
    MenuBarSteps menuBar = new MenuBarSteps();
    MenuBarPage menuBarPage = new MenuBarPage();
    AboutSteps aboutPage = new AboutSteps();
    NewsSteps newsPage = new NewsSteps();
    LoveIsAllSteps ourMissionPage = new LoveIsAllSteps();

    @Rule
    public ActivityScenarioRule<AppActivity> ActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        try {
            menuBarPage.waitingPageLoad();
        } catch (Exception e) {
            authPage.authUser();
            menuBarPage.waitingPageLoad();
        }
    }


    @Description("Открытие меню и проверка видимости меню")
    @Test
    public void shouldBeMainMenuVisible() {
        menuBar.openMenu();
        menuBar.mainMenuVisible();
    }


    @Description("Переход на страницу AboutPage")
    @Test
    public void shouldBeAboutPageVisible() {
        menuBar.openAboutPage();
        aboutPage.pageVisible();
    }


    @Description("Переход на страницу OurMission")
    @Test
    public void shouldBeOurMissionVisible() {
        menuBar.openOurMission();
        ourMissionPage.pageVisible();
    }


    @Description("Открытие меню профиля и проверка видимости элементов")
    @Test
    public void shouldBeProfileMenuVisible() {
        menuBar.openProfileMenu();
        menuBar.profileMenuVisible();
    }

}
