package ru.iteco.fmhandroid.ui.data.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.data.Utility;

public class NewsFilterPage {

    public ViewInteraction title;
    public ViewInteraction category;
    public ViewInteraction startDate;
    public ViewInteraction endDate;
    public ViewInteraction filterButton;
    public ViewInteraction cancelButtonFilter;
    public ViewInteraction emptyNewsImage;
    public ViewInteraction emptyNewsTitle;
    public ViewInteraction refreshButton;
    public ViewInteraction errorMessage;
    public ViewInteraction errorMessageOkButton;

    public NewsFilterPage() {
        title = onView(withId(R.id.filter_news_title_text_view));
        category = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
        startDate = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
        endDate = onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));
        filterButton = onView(withId(R.id.filter_button));
        cancelButtonFilter = onView(withId(R.id.cancel_button));
        emptyNewsImage = onView(withId(R.id.empty_news_list_image_view));
        emptyNewsTitle = onView(withId(R.id.empty_news_list_text_view));
        refreshButton = onView(withId(R.id.news_retry_material_button));
        errorMessage = onView(withId(android.R.id.message));
        errorMessageOkButton = onView(withId(android.R.id.button1));
    }

    public void waitingPageLoad() {
        Allure.step("Ожидание загрузки страницы");
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.filter_news_title_text_view, 7000));
    }
}
