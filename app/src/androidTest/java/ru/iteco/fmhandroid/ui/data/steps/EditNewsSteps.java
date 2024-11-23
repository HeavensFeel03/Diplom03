package ru.iteco.fmhandroid.ui.data.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
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
import ru.iteco.fmhandroid.ui.data.page.EditNewsPage;

public class EditNewsSteps {

    EditNewsPage editNews = new EditNewsPage();


    public void waitingPageLoad() {
        Allure.step("Ожидание загрузки страницы");
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.custom_app_bar_title_text_view, 7000));
    }

    public void clickCancelButton() {
        Allure.step("Закрытие окна редактирования новости");
        editNews.cancelButton.perform(click());
    }

    public void cancelWindowVisible() {
        Allure.step("Проверка видимости элементов модального окна");
        editNews.cancelButtonMessage.check(matches(isDisplayed()));
        editNews.cancelButtonMessage.check(matches(withText("The changes won't be saved, do you really want to log out?")));
        editNews.cancelCancelButton.check(matches(isDisplayed()));
        editNews.cancelCancelButton.check(matches(withText("CANCEL")));
        editNews.cancelOkButton.check(matches(isDisplayed()));
        editNews.cancelOkButton.check(matches(withText("OK")));
    }

    public void exit() {
        Allure.step("Закрытие окна редактирования новости");
        editNews.cancelOkButton.perform(click());
    }

    public void continueEditing() {
        Allure.step("Продолжить редактирование");
        editNews.cancelCancelButton.perform(click());
    }

    public void editCategory(String data) {
        Allure.step("Изменение категории");
        editNews.categoryValue.perform(replaceText(data));
    }
}
