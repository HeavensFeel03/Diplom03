package ru.iteco.fmhandroid.ui.data.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.data.Utility;

public class MainPage {

    public ViewInteraction title;
    public ViewInteraction allNewsButton;
    public ViewInteraction cardNews;
    public ViewInteraction imageNews;
    public ViewInteraction dateNews;
    public ViewInteraction titleNews;
    public ViewInteraction textNews;
    public ViewInteraction viewAllNewsButton;
    public ViewInteraction viewNewsImage;
    public ViewInteraction viewNewsButton;


    public MainPage() {
        title = onView(withText("News"));
        allNewsButton = onView(withId(R.id.all_news_text_view));
        cardNews = onView(Utility.childAtPosition(allOf(withId
                (R.id.all_news_cards_block_constraint_layout)), 0));
        imageNews = onView(withId(R.id.category_icon_image_view));
        dateNews = onView(withId(R.id.news_item_date_text_view));
        titleNews = onView(withId(R.id.news_item_title_text_view));
        textNews = onView(withId(R.id.news_item_description_text_view));
        viewAllNewsButton = onView(withId(R.id.expand_material_button));
        viewNewsImage = onView(withId(R.id.view_news_item_image_view));
        viewNewsButton = onView(withId(R.id.news_list_recycler_view));

    }

    public void waitingPageLoad() {
        Allure.step("Ожидание загрузки страницы");
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.all_news_text_view, 7000));
    }
}
