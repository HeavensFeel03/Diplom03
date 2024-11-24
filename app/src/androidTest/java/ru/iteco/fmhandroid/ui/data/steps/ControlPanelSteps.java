package ru.iteco.fmhandroid.ui.data.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;
import static ru.iteco.fmhandroid.ui.data.data.Utility.childAtPosition;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.data.Utility;
import ru.iteco.fmhandroid.ui.data.page.ControlPanelPage;

public class ControlPanelSteps {

    ControlPanelPage controlPanelPage = new ControlPanelPage();


    public void pageVisible() {
        Allure.step("Проверка видимости элементов на странице");
        controlPanelPage.title.check(matches(isDisplayed()));
        controlPanelPage.sortButton.check(matches(isDisplayed()));
        controlPanelPage.filterButton.check(matches(isDisplayed()));
        controlPanelPage.createButton.check(matches(isDisplayed()));
        controlPanelPage.editButton.check(matches(isDisplayed()));
        controlPanelPage.viewButton.check(matches(isDisplayed()));

    }

    public void pageClickable() {
        Allure.step("Проверка кликабельности элементов на странице");
        controlPanelPage.sortButton.check(matches(isClickable()));
        controlPanelPage.filterButton.check(matches(isClickable()));
        controlPanelPage.createButton.check(matches(isClickable()));
    }

    public void scroll(int position) {
        Allure.step("Пролистать до заданной позиции");
        controlPanelPage.viewButton.perform(actionOnItemAtPosition(position, scrollTo()));
    }

    public void clickView(int position) {
        Allure.step("Разворачивание карточки новости по заданной позиции");
        controlPanelPage.viewButton.perform(actionOnItemAtPosition(position, click()));
    }

    public void titleNewsVisible(String title) {
        Allure.step("Видимость заголовка новости на странице");
        ViewInteraction textView2 = onView(
                allOf(withId(R.id.news_item_title_text_view), withText(title),
                        withParent(withParent(withId(R.id.news_item_material_card_view))),
                        isDisplayed()));
        textView2.check(matches(withText(title)));
    }

    public void textNewsVisible() {
        Allure.step("Видимость текста  после разворачивания карточки новости");
        controlPanelPage.textNews.check(matches(isDisplayed()));
    }

    public void textNewsInvisible() {
        Allure.step("Невидимость текста после сворачивания карточки новости");
        controlPanelPage.textNews.check(matches(not(isDisplayed())));
    }

    public void clickSort() {
        Allure.step("Нажатие на кнопку сортировки");
        controlPanelPage.sortButton.perform(click());
    }

    public FilterNewsSteps clickFilter() {
        Allure.step("Открытие фильтра");
        controlPanelPage.filterButton.perform(click());
        return new FilterNewsSteps();
    }

    public CreateNewsSteps clickCreate() {
        Allure.step("Открытие страницы создания новости");
        controlPanelPage.createButton.perform(click());
        return new CreateNewsSteps();
    }

    public void clickDelete(int position) {
        Allure.step("Нажатие на кнопку удалить по заданной позиции");
        controlPanelPage.deleteButton.perform(actionOnItemAtPosition(position, click()));
    }

    public EditNewsSteps clickEdit() {
        Allure.step("Открытие страницы редактирования новости");
        controlPanelPage.editButton.perform(click());
        return new EditNewsSteps();
    }

    public void checkViewNews(int index) {
        Allure.step("Развернуть выбранную новость");
        controlPanelPage.viewButton.perform(actionOnItemAtPosition(index, click()));
    }

    public void textVisible(String text) {
        Allure.step("Проверка видимости описания новости");
        ViewInteraction textView = onView(
                allOf(withId(R.id.news_item_description_text_view), withText(text),
                        withParent(withParent(withId(R.id.news_item_material_card_view))),
                        isDisplayed()));
    }

    public void deleteWindowVisible() {
        Allure.step("Проверка видимости окна удалить");

        controlPanelPage.deleteMessage.check(matches(withText("Are you sure you want to permanently delete the document? These changes cannot be reversed in the future.")));
        controlPanelPage.deleteCancelButton.check(matches(withText("CANCEL")));
        controlPanelPage.deleteOkButton.check(matches(withText("OK")));
    }

    public void clickCancel() {
        Allure.step("Нажатие на кнопку CANCEL");
        controlPanelPage.deleteCancelButton.perform(click());
    }

    public void clickОк() {
        Allure.step("Нажатие на кнопку OK");
        controlPanelPage.deleteOkButton.perform(click());
    }
}
