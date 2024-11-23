package ru.iteco.fmhandroid.ui.data.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.data.Utility;
import ru.iteco.fmhandroid.ui.data.page.FilterNewsPage;

public class FilterNewsSteps {
    FilterNewsPage filterNewsPage = new FilterNewsPage();


    public void waitingPageLoad() {
        Allure.step("Ожидание загрузки страницы");
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.filter_news_title_text_view, 7000));
    }

    public void pageVisible() {
        Allure.step("Проверка видимости элементов на странице");
        filterNewsPage.title.check(matches(isDisplayed()));
        filterNewsPage.title.check(matches(ViewMatchers.withText("Filter news")));
        filterNewsPage.category.check(matches(isDisplayed()));
        filterNewsPage.startDate.check(matches(isDisplayed()));
        filterNewsPage.endDate.check(matches(isDisplayed()));
        filterNewsPage.checkBoxActive.check(matches(isDisplayed()));
        filterNewsPage.checkBoxActive.check(matches(ViewMatchers.withText("Active")));
        filterNewsPage.checkBoxNotActive.check(matches(isDisplayed()));
        filterNewsPage.checkBoxNotActive.check(matches(ViewMatchers.withText("Not active")));
        filterNewsPage.filterButton.check(matches(isDisplayed()));
        filterNewsPage.filterButton.check(matches(ViewMatchers.withText("FILTER")));
        filterNewsPage.cancelButtonFilter.check(matches(isDisplayed()));
        filterNewsPage.cancelButtonFilter.check(matches(ViewMatchers.withText("CANCEL")));
    }

    public void pageClicable() {
        Allure.step("Проверка кликабельности элементов на странице");
        filterNewsPage.category.check(matches(isClickable()));
        filterNewsPage.startDate.check(matches(isClickable()));
        filterNewsPage.endDate.check(matches(isClickable()));
        filterNewsPage.checkBoxActive.check(matches(isClickable()));
        filterNewsPage.checkBoxNotActive.check(matches(isClickable()));
        filterNewsPage.filterButton.check(matches(isClickable()));
        filterNewsPage.cancelButtonFilter.check(matches(isClickable()));
    }

    public void addCategory(String data) {
        Allure.step("Ввод категории");
        filterNewsPage.category.perform(replaceText(data));
    }

    public void addStartDate(String value) {
        Allure.step("Ввод даты начала");
        filterNewsPage.startDate.perform(replaceText(value), closeSoftKeyboard());
    }

    public void addEndDate(String value) {
        Allure.step("Ввод даты окончания");
        filterNewsPage.endDate.perform(replaceText(value), closeSoftKeyboard());
    }

    public void clickActiveCheckBox() {
        Allure.step("Нажатие на чек-бокс Active");
        filterNewsPage.checkBoxActive.perform(click());
    }

    public void clickNotActiveCheckBox() {
        Allure.step("Нажатие на чек-бокс NotActive");
        filterNewsPage.checkBoxNotActive.perform(click());
    }

    public void emptyNewsVisible() {
        Allure.step("Проверка видимости страницы без новостей");
        filterNewsPage.emptyNewsImage.check(matches(isDisplayed()));
        filterNewsPage.emptyNewsTitle.check(matches(isDisplayed()));
        filterNewsPage.emptyNewsTitle.check(matches(ViewMatchers.withText("There is nothing here yet�")));
        filterNewsPage.refreshButton.check(matches(isDisplayed()));
        filterNewsPage.refreshButton.check(matches(ViewMatchers.withText("REFRESH")));
    }

    public void clickRefreshVisible() {
        Allure.step("Проверка видимости кнопки REFRESH");
        filterNewsPage.refreshButton.check(matches(isDisplayed()));
    }

    public void clickRefresh() {
        Allure.step("Нажатие на кнопку REFRESH");
        filterNewsPage.refreshButton.perform(click());
    }

    public void clickCancel() {
        Allure.step("Нажатие на кнопку CANCEL");
        filterNewsPage.cancelButtonFilter.perform(click());
    }

    public void clickFilter() {
        Allure.step("Нажатие на кнопку FILTER");
        filterNewsPage.filterButton.perform(click());
    }

    public void errorVisible() {
        Allure.step("Видимость модального окна с текстом ошибки");
        filterNewsPage.errorMessage.check(matches(isDisplayed()));
        filterNewsPage.errorMessage.check(matches(withText("Wrong period")));
        filterNewsPage.errorMessageOkButton.check(matches(isDisplayed()));
        filterNewsPage.errorMessageOkButton.check(matches(withText("OK")));
    }

    public void clickErrorMessageOkButton() {
        Allure.step("Закрытие модального окна с текстом ошибки");
        filterNewsPage.errorMessageOkButton.perform(click());
    }
}

