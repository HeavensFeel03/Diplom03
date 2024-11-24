package ru.iteco.fmhandroid.ui.data.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.data.Utility;

public class NewsPage {
    public ViewInteraction titleContainer;
    public ViewInteraction title;
    public ViewInteraction sortButton;
    public ViewInteraction filterButton;
    public ViewInteraction controlPanelButton;
    public ViewInteraction textNews;
    public ViewInteraction viewNewsButton;

    public NewsPage() {
        titleContainer = onView(withId(R.id.container_list_news_include));
        title = onView(withText("News"));
        sortButton = onView(withId(R.id.sort_news_material_button));
        filterButton = onView(withId(R.id.filter_news_material_button));
        controlPanelButton = onView(withId(R.id.edit_news_material_button));
        textNews = onView(withId(R.id.news_item_description_text_view));
        viewNewsButton = onView(withId(R.id.news_list_recycler_view));
    }

    public void waitingPageLoad() {
        Allure.step("Ожидание загрузки страницы");
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.container_list_news_include, 7000));
    }
}
