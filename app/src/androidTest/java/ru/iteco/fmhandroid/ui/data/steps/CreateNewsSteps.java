package ru.iteco.fmhandroid.ui.data.steps;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.data.Helper;
import ru.iteco.fmhandroid.ui.data.data.Utility;
import ru.iteco.fmhandroid.ui.data.page.CreateNewsPage;

public class CreateNewsSteps {
    CreateNewsPage createNewsPage = new CreateNewsPage();


    public void waitingPageLoad() {
        Allure.step("Ожидание загрузки страницы");
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.custom_app_bar_title_text_view, 7000));
    }

    public void pageVisible() {
        Allure.step("Проверка видимости элементов на странице");
        createNewsPage.creatingTitle.check(matches(isDisplayed()));
        createNewsPage.creatingTitle.check(matches(withText("Creating")));
        createNewsPage.newsTitle.check(matches(isDisplayed()));
        createNewsPage.newsTitle.check(matches(withText("News")));
        createNewsPage.categoryBox.check(matches(isDisplayed()));
        createNewsPage.titleBox.check(matches(isDisplayed()));
        createNewsPage.publicationDate.check(matches(isDisplayed()));
        createNewsPage.time.check(matches(isDisplayed()));
        createNewsPage.description.check(matches(isDisplayed()));
        createNewsPage.switcher.check(matches(isDisplayed()));
        createNewsPage.switcher.check(matches(withText("Active")));
        createNewsPage.saveButton.check(matches(isDisplayed()));
        createNewsPage.saveButton.check(matches(withText("SAVE")));
        createNewsPage.cancelButton.check(matches(isDisplayed()));
        createNewsPage.cancelButton.check(matches(withText("CANCEL")));
    }

    public void pageClickable() {
        Allure.step("Проверка кликабельности элементов на странице");
        createNewsPage.categoryBox.check(matches(isClickable()));
        createNewsPage.titleBox.check(matches(isClickable()));
        createNewsPage.publicationDate.check(matches(isClickable()));
        createNewsPage.time.check(matches(isClickable()));
        createNewsPage.description.check(matches(isClickable()));
        createNewsPage.switcher.check(matches(isClickable()));
        createNewsPage.saveButton.check(matches(isClickable()));
        createNewsPage.cancelButton.check(matches(isClickable()));
    }

    public void cancelWindowVisible() {
        Allure.step("Видимости элементов в модальном окне");
        createNewsPage.cancelButtonMessage.check(matches(isDisplayed()));
        createNewsPage.cancelButtonMessage.check(matches(withText("The changes won't be saved, do you really want to log out?")));
        createNewsPage.cancelCancelButton.check(matches(isDisplayed()));
        createNewsPage.cancelCancelButton.check(matches(withText("CANCEL")));
        createNewsPage.cancelOkButton.check(matches(isDisplayed()));
        createNewsPage.cancelOkButton.check(matches(withText("OK")));
    }

    public void createNews() {
        Allure.step("Создание первой новости");
        createNewsPage.categoryBox.perform(replaceText(Helper.getCategory(5)));
        createNewsPage.titleBox.perform(replaceText("Groundhog Day"));
        createNewsPage.publicationDate.perform(replaceText(Helper.generateDate(0)));
        createNewsPage.time.perform(replaceText(Helper.addTime(17, 20)));
        createNewsPage.description.perform(replaceText("День сурка (англ. Groundhog Day) — традиционный праздник в США и Канаде, отмечаемый ежегодно 2 февраля."));
        createNewsPage.saveButton.perform(click());
    }

    public void createNews2() {
        Allure.step("Создание второй новости");
        createNewsPage.categoryBox.perform(replaceText(Helper.getCategory(1)));
        createNewsPage.titleBox.perform(replaceText("Найден котенок"));
        createNewsPage.publicationDate.perform(replaceText(Helper.getСurrentDate()));
        createNewsPage.time.perform(replaceText(Helper.getСurrentTime(0)));
        createNewsPage.description.perform(replaceText("Найден рыжый котенок"));
        closeSoftKeyboard();
        createNewsPage.saveButton.perform(click());
    }

}

