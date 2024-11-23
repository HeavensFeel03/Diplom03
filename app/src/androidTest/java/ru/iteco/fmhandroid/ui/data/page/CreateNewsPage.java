package ru.iteco.fmhandroid.ui.data.page;

import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class CreateNewsPage {

    public ViewInteraction creatingTitle;
    public ViewInteraction newsTitle;
    public ViewInteraction categoryBox;
    public ViewInteraction titleBox;
    public ViewInteraction publicationDate;
    public ViewInteraction time;
    public ViewInteraction description;
    public ViewInteraction switcher;
    public ViewInteraction saveButton;
    public ViewInteraction cancelButton;
    public ViewInteraction cancelButtonMessage;
    public ViewInteraction cancelCancelButton;
    public ViewInteraction cancelOkButton;

    public CreateNewsPage() {
        creatingTitle = Espresso.onView(withId(R.id.custom_app_bar_title_text_view));
        newsTitle = Espresso.onView(withId(R.id.custom_app_bar_sub_title_text_view));
        categoryBox = Espresso.onView(withId(R.id.news_item_category_text_auto_complete_text_view));
        titleBox = Espresso.onView(withId(R.id.news_item_title_text_input_edit_text));
        publicationDate = Espresso.onView(withId(R.id.news_item_publish_date_text_input_edit_text));
        time = Espresso.onView(withId(R.id.news_item_publish_time_text_input_edit_text));
        description = Espresso.onView(withId(R.id.news_item_description_text_input_edit_text));
        switcher = Espresso.onView(withId(R.id.switcher));
        saveButton = Espresso.onView(withId(R.id.save_button));
        cancelButton = Espresso.onView(withId(R.id.cancel_button));
        cancelButtonMessage = Espresso.onView(withId(android.R.id.message));
        cancelCancelButton = Espresso.onView(withId(android.R.id.button2));
        cancelOkButton = Espresso.onView(withId(android.R.id.button1));
    }
}
