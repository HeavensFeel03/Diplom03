package ru.iteco.fmhandroid.ui.test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

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
import ru.iteco.fmhandroid.ui.data.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.data.steps.ControlPanelSteps;
import ru.iteco.fmhandroid.ui.data.steps.CreateNewsSteps;
import ru.iteco.fmhandroid.ui.data.steps.FilterNewsSteps;
import ru.iteco.fmhandroid.ui.data.steps.MenuBarSteps;
import ru.iteco.fmhandroid.ui.data.steps.NewsSteps;


@DisplayName("Сценарии тестирования страницы ControlPanel")
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ControlPanelTest {
    AuthorizationSteps authPage = new AuthorizationSteps();
    NewsSteps newsPage = new NewsSteps();
    MenuBarSteps menuBar = new MenuBarSteps();
    ControlPanelSteps controlPanel = new ControlPanelSteps();
    FilterNewsSteps controlPanelFilterPage = new FilterNewsSteps();
    CreateNewsSteps controlPanelCreatePage = new CreateNewsSteps();

    @Rule
    public ActivityScenarioRule<AppActivity> ActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        try {
            menuBar.openNewsPage();
            newsPage.clickControlPanel();
            controlPanel.waitingPageLoad();
        } catch (Exception e) {
            authPage.authUser();
            menuBar.openNewsPage();
            newsPage.clickControlPanel();
            controlPanel.waitingPageLoad();
        }
    }


    @Description("Разворачивание карточки новости по заданной позиции")
    @Test
    public void shouldBeViewNewsOnPosition() {
        controlPanel.scroll(2);
        controlPanel.clickView(2);
    }


    @Description("Сортировка")
    @Test
    public void shouldBeSortingNews() {
        controlPanel.clickSort();
    }


    @Description("Открытие страницы фильтрации")
    @Test
    public void shouldBeControlPanelFilterPageVisible() {
        controlPanel.clickFilter();
        controlPanelFilterPage.pageVisible();
        controlPanelFilterPage.clickCancel();
    }


    @Description("Открытие страницы создания новости")
    @Test
    public void shouldBeControlPanelCreatePageVisible() {
        controlPanel.clickCreate();
        controlPanelCreatePage.pageVisible();
    }


    @Description("Создать новость и проверить ее видимость на странице")
    @Test
    public void shouldBeVisibleNewCreateNews() {
        onView(withText("Groundhog Day")).check(doesNotExist());
        controlPanel.clickCreate();
        controlPanelCreatePage.createNews();
        controlPanel.textVisible("Groundhog Day");
    }

}
