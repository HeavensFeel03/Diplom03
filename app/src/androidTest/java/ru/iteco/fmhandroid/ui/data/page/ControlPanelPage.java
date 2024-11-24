package ru.iteco.fmhandroid.ui.data.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static ru.iteco.fmhandroid.ui.data.data.Utility.childAtPosition;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.data.Utility;

public class ControlPanelPage {

    public ViewInteraction title;
    public ViewInteraction sortButton;
    public ViewInteraction filterButton;
    public ViewInteraction createButton;
    public ViewInteraction deleteButton;
    public ViewInteraction deleteMessage;
    public ViewInteraction deleteCancelButton;
    public ViewInteraction deleteOkButton;
    public ViewInteraction editButton;
    public ViewInteraction viewButton;
    public ViewInteraction textNews;


    public ControlPanelPage() {
        title = onView(withText("Control panel"));
        sortButton = onView(withId(R.id.sort_news_material_button));
        filterButton = onView(withId(R.id.filter_news_material_button));
        createButton = onView(withId(R.id.add_news_image_view));
        deleteButton = onView(
                Utility.childAtPosition(
                        withId(R.id.news_item_material_card_view),
                        0));
        deleteMessage = onView(withId(android.R.id.message));
        deleteCancelButton = onView(withId(android.R.id.button2));
        deleteOkButton = onView(withId(android.R.id.button1));
        editButton = onView(withId(R.id.edit_news_item_image_view));
        viewButton = onView(allOf(withId(R.id.news_list_recycler_view),
                childAtPosition(
                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                        0)));
        textNews = onView(withId(R.id.news_item_description_text_view));

    }

    public void waitingPageLoad() {
        Allure.step("Ожидание загрузки страницы");
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.sort_news_material_button, 7000));
    }
}
