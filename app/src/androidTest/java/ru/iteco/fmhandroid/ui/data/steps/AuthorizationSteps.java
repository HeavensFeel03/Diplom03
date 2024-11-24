package ru.iteco.fmhandroid.ui.data.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.data.Helper;
import ru.iteco.fmhandroid.ui.data.data.Utility;
import ru.iteco.fmhandroid.ui.data.page.AuthorizationPage;

public class AuthorizationSteps {

    AuthorizationPage authorizationPage = new AuthorizationPage();


    public void pageVisible() {
        Allure.step("Проверка видимости элементов на странице");
        authorizationPage.title.check(matches(isDisplayed()));
        authorizationPage.loginField.check(matches(isDisplayed()));
        authorizationPage.passwordField.check(matches(isDisplayed()));
        authorizationPage.button.check(matches(isDisplayed()));
        authorizationPage.button.check(matches(ViewMatchers.withText("SIGN IN")));
    }

    public void pageClickable() {
        Allure.step("Проверка кликабельности элементов на странице");
        authorizationPage.loginField.check(matches(isClickable()));
        authorizationPage.passwordField.check(matches(isClickable()));
        authorizationPage.button.check(matches(isClickable()));
    }

    public void addLogin(String login) {
        Allure.step("Ввод логина");
        authorizationPage.loginField.perform(replaceText(login), closeSoftKeyboard());
    }

    public void deleteLogin() {
        Allure.step("Удаление логина");
        authorizationPage.loginField.perform(clearText(), closeSoftKeyboard());
    }

    public void addPassword(String password) {
        Allure.step("Ввод пароля");
        authorizationPage.passwordField.perform(replaceText(password), closeSoftKeyboard());
    }

    public void deletePassword() {
        Allure.step("Удаление пароля");
        authorizationPage.passwordField.perform(clearText(), closeSoftKeyboard());
    }

    public void authUser() {
        Allure.step("Авторизация пользователя");
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.login_text_input_layout, 7000));
        addLogin(Helper.getValidLogin());
        addPassword(Helper.getValidPassword());
        clickButton();
    }

    public void clickButton() {
        Allure.step("Нажатие кнопки SIGN IN");
        authorizationPage.button.perform(click());
    }

    public void errorMessageText(String text, View decorView) {
        Allure.step("Появление окна с текстом ошибки");
        onView(withText(text))
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }

}


