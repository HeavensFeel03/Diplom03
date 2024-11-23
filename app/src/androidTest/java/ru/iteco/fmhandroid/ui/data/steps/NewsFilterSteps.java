package ru.iteco.fmhandroid.ui.data.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.data.Utility;
import ru.iteco.fmhandroid.ui.data.page.NewsFilterPage;

public class NewsFilterSteps {
    NewsFilterPage newsFilterPage = new NewsFilterPage();


    public void waitingPageLoad() {
        Allure.step("Ожидание загрузки страницы");
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.filter_news_title_text_view, 7000));
    }

    public void pageVisible() {
        Allure.step("Проверка видимости элементов на странице");
        newsFilterPage.title.check(matches(isDisplayed()));
        newsFilterPage.title.check(matches(withText("Filter news")));
        newsFilterPage.category.check(matches(isDisplayed()));
        newsFilterPage.startDate.check(matches(isDisplayed()));
        newsFilterPage.endDate.check(matches(isDisplayed()));
        newsFilterPage.filterButton.check(matches(isDisplayed()));
        newsFilterPage.filterButton.check(matches(withText("FILTER")));
        newsFilterPage.cancelButtonFilter.check(matches(isDisplayed()));
        newsFilterPage.cancelButtonFilter.check(matches(withText("CANCEL")));
    }

    public void addCategory(String data) {
        Allure.step("Ввод категории");
        newsFilterPage.category.perform(replaceText(data));
    }

    public void addStartDate(String value) {
        Allure.step("Ввод даты начала");
        newsFilterPage.startDate.perform(replaceText(value), closeSoftKeyboard());
    }

    public void addEndDate(String value) {
        Allure.step("Ввод даты окончания");
        newsFilterPage.endDate.perform(replaceText(value), closeSoftKeyboard());
    }

    public void clickFilter() {
        Allure.step("Нажатие на кнопку FILTER");
        newsFilterPage.filterButton.perform(click());
    }

    public void clickCancel() {
        Allure.step("Нажатие на кнопку CANCEL");
        newsFilterPage.cancelButtonFilter.perform(click());
    }

    public void emptyNewsVisible() {
        Allure.step("Проверка видимости страницы без новостей");
        newsFilterPage.emptyNewsImage.check(matches(isDisplayed()));
        newsFilterPage.emptyNewsTitle.check(matches(isDisplayed()));
        newsFilterPage.emptyNewsTitle.check(matches(withText("There is nothing here yet�")));
        newsFilterPage.refreshButton.check(matches(isDisplayed()));
        newsFilterPage.refreshButton.check(matches(withText("REFRESH")));
    }

    public void clickRefresh() {
        Allure.step("Нажатие на кнопку REFRESH");
        newsFilterPage.refreshButton.perform(click());
    }

    public void errorVisible() {
        Allure.step("Проверка видимости модального окна с текстом ошибки");
        newsFilterPage.errorMessage.check(matches(isDisplayed()));
        newsFilterPage.errorMessage.check(matches(withText("Wrong period")));
        newsFilterPage.errorMessageOkButton.check(matches(isDisplayed()));
        newsFilterPage.errorMessageOkButton.check(matches(withText("OK")));
    }

    public void clickErrorMessageOkButton() {
        Allure.step("Закрытие модального окна с текстом ошибки");
        newsFilterPage.errorMessageOkButton.perform(click());
    }
}


