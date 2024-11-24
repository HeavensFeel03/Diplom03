package ru.iteco.fmhandroid.ui.data.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.hasChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.core.IsNot.not;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.data.Utility;
import ru.iteco.fmhandroid.ui.data.page.MainPage;

public class MainSteps {

    MainPage mainPage = new MainPage();


    public void pageVisible() {
        Allure.step("Проверка видимости элементов на странице");
        mainPage.title.check(matches(isDisplayed()));
        mainPage.allNewsButton.check(matches(isDisplayed()));
        mainPage.allNewsButton.check(matches(withText("ALL NEWS")));
        mainPage.viewAllNewsButton.check(matches(isDisplayed()));

    }

    public void pageClickable() {
        Allure.step("Проверка кликабельности элементов на странице");
        mainPage.allNewsButton.check(matches(isClickable()));
        mainPage.viewAllNewsButton.check(matches(isClickable()));
    }

    public void pageInisible() {
        Allure.step("Проверка что часть элементов скрыта элементов на странице");
        mainPage.title.check(matches(isDisplayed()));
        mainPage.title.check(matches(withText("News")));
        mainPage.viewAllNewsButton.check(matches(isDisplayed()));
        allNewsInvisible();
    }

    public void clickViewAllNews() {
        Allure.step("Разворачивание/сворачивание всех новостей");
        mainPage.viewAllNewsButton.perform((click()));
    }

    public void allNewsVisible() {
        Allure.step("Проверка видимости раздела All News на странице MainPage");
        mainPage.cardNews.check(matches(isDisplayed()));
        mainPage.imageNews.check(matches(isDisplayed()));
        mainPage.dateNews.check(matches(isDisplayed()));
        mainPage.titleNews.check(matches(isDisplayed()));
        mainPage.textNews.check(matches(not(isDisplayed())));
        mainPage.viewNewsButton.check(matches(isDisplayed()));
    }

    public void allNewsInvisible() {
        Allure.step("Проверка что скрыты все элементы  All News на странице MainPage");
        mainPage.cardNews.check(matches(not(isDisplayed())));
        mainPage.imageNews.check(matches(not(isDisplayed())));
        mainPage.dateNews.check(matches(not(isDisplayed())));
        mainPage.titleNews.check(matches(not(isDisplayed())));
        mainPage.textNews.check(matches(not(isDisplayed())));
        mainPage.viewNewsImage.check(matches(not(isDisplayed())));
        mainPage.viewNewsButton.check(doesNotExist());

    }

    public void clickView(int position) {
        Allure.step("Разворачивание карточки новости по заданной позиции");
        mainPage.cardNews.perform(actionOnItemAtPosition(position, click()));
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.news_item_description_text_view, 7000));

    }

    public void childCount(int child) {
        Allure.step("Проверка колличества карточек новостей");
        mainPage.cardNews.check(matches(hasChildCount(child)));
    }

    public void textNewsVisible() {
        Allure.step("Проверка видимости текста новости после разворачивания блока новости");
        mainPage.textNews.check(matches(isDisplayed()));
    }

    public void textNewsInvisible() {
        Allure.step("Проверка невидимости текста новости после сворачивания блока новости");
        mainPage.textNews.check(matches(not(isDisplayed())));
    }

    public NewsSteps openAllNews() {
        Allure.step("Переход в раздел All news");
        mainPage.allNewsButton.perform(click());
        return new NewsSteps();
    }

}
