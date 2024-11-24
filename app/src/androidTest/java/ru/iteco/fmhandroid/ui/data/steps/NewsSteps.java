package ru.iteco.fmhandroid.ui.data.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.data.Utility;
import ru.iteco.fmhandroid.ui.data.page.NewsPage;

public class NewsSteps {
    NewsPage newsPage = new NewsPage();


    public void pageVisible() {
        Allure.step("Проверка видимости элементов на странице");
        newsPage.titleContainer.check(matches(isDisplayed()));
        newsPage.title.check(matches(isDisplayed()));
        newsPage.sortButton.check(matches(isDisplayed()));
        newsPage.filterButton.check(matches(isDisplayed()));
        newsPage.controlPanelButton.check(matches(isDisplayed()));
        newsPage.viewNewsButton.check(matches(isDisplayed()));
    }

    public void clickView(int position) {
        Allure.step("Разворачивание/сворачивание карточки новости по заданной позиции");
        newsPage.viewNewsButton.perform(actionOnItemAtPosition(position, scrollTo()));
        newsPage.viewNewsButton.perform(actionOnItemAtPosition(position, click()));
    }

    public void textNewsInvisible() {
        Allure.step("Проверка невидимости текста новости после сворачивания блока новости");
        newsPage.textNews.check(matches(not(isDisplayed())));
    }

    public NewsFilterSteps clickFilter() {
        Allure.step("Открытие фильтра");
        newsPage.filterButton.perform(click());
        return new NewsFilterSteps();
    }

    public void clickSort() {
        Allure.step("Нажатие на кнопку сортировки");
        newsPage.sortButton.perform(click());
    }

    public void clickControlPanel() {
        Allure.step("Открытие страницы Сontrol Panel");
        newsPage.controlPanelButton.perform(click());
        new ControlPanelSteps();
    }

}
