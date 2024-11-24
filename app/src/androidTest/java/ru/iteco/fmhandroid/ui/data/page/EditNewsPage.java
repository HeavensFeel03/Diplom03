package ru.iteco.fmhandroid.ui.data.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.data.Utility;

public class EditNewsPage {
    public ViewInteraction categoryValue;
    public ViewInteraction cancelButton;
    public ViewInteraction cancelButtonMessage;
    public ViewInteraction cancelCancelButton;
    public ViewInteraction cancelOkButton;


    public EditNewsPage() {
        categoryValue = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
        cancelButton = onView(withId(R.id.cancel_button));
        cancelButtonMessage = onView(withId(android.R.id.message));
        cancelCancelButton = onView(withId(android.R.id.button2));
        cancelOkButton = onView(withId(android.R.id.button1));

    }

    public void waitingPageLoad() {
        Allure.step("Ожидание загрузки страницы");
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.custom_app_bar_title_text_view, 7000));
    }
}
