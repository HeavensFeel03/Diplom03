package ru.iteco.fmhandroid.ui.data.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.data.Utility;
import ru.iteco.fmhandroid.ui.data.page.LoveIsAllPage;

public class LoveIsAllSteps {

    LoveIsAllPage loveIsAllPage = new LoveIsAllPage();

    public void waitingPageLoad() {
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.our_mission_title_text_view, 7000));
    }

    public void pageVisible() {
        Allure.step("Проверка видимости элементов на странице");
        loveIsAllPage.title.check(matches(isDisplayed()));
        loveIsAllPage.title.check(matches(withText("Love is all")));

    }

    public void clickView(int position) {
        Allure.step("Разворачивание/сворачивание карточки с цитатой по заданной позиции");
        loveIsAllPage.materialCard.perform(actionOnItemAtPosition(position, click()));
    }

    public void textCardVisible(String text) {
        Allure.step("Проверка видимости текста после разворачивания карточки с цитатой");
        loveIsAllPage.itemTextCard.check(matches(withText(text)));
        loveIsAllPage.itemTextCard.check(matches(isDisplayed()));
    }

    public void textCardInvisible() {
        Allure.step("Проверка невидимости текста  после сворачивания  карточки с цитатой");
        loveIsAllPage.itemTextCard.check(matches(not(isDisplayed())));
    }
}

