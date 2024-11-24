package ru.iteco.fmhandroid.ui.test;

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
import ru.iteco.fmhandroid.ui.data.page.CreateNewsPage;
import ru.iteco.fmhandroid.ui.data.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.data.steps.ControlPanelSteps;
import ru.iteco.fmhandroid.ui.data.steps.CreateNewsSteps;
import ru.iteco.fmhandroid.ui.data.steps.MenuBarSteps;
import ru.iteco.fmhandroid.ui.data.steps.NewsSteps;


@DisplayName("Сценарии тестирования страницы CreateNews")
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class CreateNewsPageTest {
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    NewsSteps newsPage = new NewsSteps();
    MenuBarSteps menuBar = new MenuBarSteps();
    ControlPanelSteps controlPanel = new ControlPanelSteps();
    CreateNewsSteps controlPanelCreatePage = new CreateNewsSteps();
    CreateNewsPage createNewsPage = new CreateNewsPage();

    @Rule
    public ActivityScenarioRule<AppActivity> ActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        try {
            menuBar.openNewsPage();
            newsPage.clickControlPanel();
            controlPanel.clickCreate();
            createNewsPage.waitingPageLoad();
        } catch (Exception e) {
            authorizationSteps.authUser();
            menuBar.openNewsPage();
            newsPage.clickControlPanel();
            controlPanel.clickCreate();
            createNewsPage.waitingPageLoad();
        }
    }


    @Description("Создание новости и проверка видимости созданной новости")
    @Test
    public void shouldBeCreateAndVisibleNews() {
        controlPanelCreatePage.createNews2();
        createNewsPage.waitingPageLoad();
        controlPanel.clickSort();
        controlPanel.titleNewsVisible("Найден котенок");
    }

}
