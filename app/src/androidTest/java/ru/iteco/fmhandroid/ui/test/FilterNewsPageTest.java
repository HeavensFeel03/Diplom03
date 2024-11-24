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
import ru.iteco.fmhandroid.ui.data.data.Helper;
import ru.iteco.fmhandroid.ui.data.page.FilterNewsPage;
import ru.iteco.fmhandroid.ui.data.page.MenuBarPage;
import ru.iteco.fmhandroid.ui.data.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.data.steps.ControlPanelSteps;
import ru.iteco.fmhandroid.ui.data.steps.FilterNewsSteps;
import ru.iteco.fmhandroid.ui.data.steps.MenuBarSteps;
import ru.iteco.fmhandroid.ui.data.steps.NewsSteps;


@DisplayName("Сценарии тестирования страницы FilterNews")
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class FilterNewsPageTest {
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    NewsSteps newsPage = new NewsSteps();
    MenuBarSteps menuBar = new MenuBarSteps();
    MenuBarPage menuBarPage = new MenuBarPage();
    ControlPanelSteps controlPanel = new ControlPanelSteps();
    FilterNewsSteps controlPanelFilterPage = new FilterNewsSteps();
    FilterNewsPage filterNewsPage = new FilterNewsPage();

    @Rule
    public ActivityScenarioRule<AppActivity> ActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        try {
            menuBarPage.waitingPageLoad();
            menuBar.openNewsPage();
            newsPage.clickControlPanel();
            controlPanel.clickFilter();
            filterNewsPage.waitingPageLoad();
        } catch (Exception e) {
            authorizationSteps.authUser();
            menuBar.openNewsPage();
            newsPage.clickControlPanel();
            controlPanel.clickFilter();
            filterNewsPage.waitingPageLoad();
        }
    }


    @Description("Проверка видимости текста ошибки при фильтрации только по дате начала и закрытие модального окна")
    @Test
    public void shouldBeErrorTextWhenFilteringOnlyByStartDate() {
        controlPanelFilterPage.addStartDate(Helper.getСurrentDate());
        controlPanelFilterPage.clickFilter();
        controlPanelFilterPage.errorVisible();
        controlPanelFilterPage.clickErrorMessageOkButton();
        controlPanelFilterPage.pageVisible();
        controlPanelFilterPage.clickCancel();
    }


    @Description("Фильтрация с установлением категории и и будущих дат и обновление страницы ")
    @Test
    public void ShouldBeRefreshButtonVisible() {
        controlPanelFilterPage.addCategory(Helper.getCategory(7));
        controlPanelFilterPage.addStartDate(Helper.generateDate(70));
        controlPanelFilterPage.addEndDate(Helper.generateDate(79));
        controlPanelFilterPage.clickFilter();
        controlPanelFilterPage.clickRefreshVisible();
    }


    @Description("Фильтрация с использованием чек-бокса Active")
    @Test
    public void shouldBeFilteringWithCheckBoxActive() {
        controlPanelFilterPage.addCategory(Helper.getCategory(5));
        controlPanelFilterPage.addStartDate(Helper.generateDate(-770));
        controlPanelFilterPage.addEndDate(Helper.generateDate(2));
        controlPanelFilterPage.clickActiveCheckBox();
        controlPanelFilterPage.clickFilter();

    }


}
