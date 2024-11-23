package ru.iteco.fmhandroid.ui.data.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;

import ru.iteco.fmhandroid.R;

public class FilterNewsPage {

    public ViewInteraction title;
    public ViewInteraction category;
    public ViewInteraction startDate;
    public ViewInteraction endDate;
    public ViewInteraction checkBoxActive;
    public ViewInteraction checkBoxNotActive;
    public ViewInteraction filterButton;
    public ViewInteraction cancelButtonFilter;
    public ViewInteraction emptyNewsImage;
    public ViewInteraction emptyNewsTitle;
    public ViewInteraction refreshButton;
    public ViewInteraction errorMessage;
    public ViewInteraction errorMessageOkButton;

    public FilterNewsPage() {
        title = Espresso.onView(ViewMatchers.withId(R.id.filter_news_title_text_view));
        category = Espresso.onView(ViewMatchers.withId(R.id.news_item_category_text_auto_complete_text_view));
        startDate = Espresso.onView(ViewMatchers.withId(R.id.news_item_publish_date_start_text_input_edit_text));
        endDate = Espresso.onView(ViewMatchers.withId(R.id.news_item_publish_date_end_text_input_edit_text));
        checkBoxActive = Espresso.onView(ViewMatchers.withId(R.id.filter_news_active_material_check_box));
        checkBoxNotActive = Espresso.onView(ViewMatchers.withId(R.id.filter_news_inactive_material_check_box));
        filterButton = Espresso.onView(ViewMatchers.withId(R.id.filter_button));
        cancelButtonFilter = Espresso.onView(ViewMatchers.withId(R.id.cancel_button));
        emptyNewsImage = onView(withId(R.id.empty_news_list_image_view));
        emptyNewsTitle = onView(withId(R.id.empty_news_list_text_view));
        refreshButton = onView(withText("REFRESH"));
        errorMessage = onView(withId(android.R.id.message));
        errorMessageOkButton = onView(withId(android.R.id.button1));
    }
}
