package ru.iteco.fmhandroid.ui.data.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.data.Utility;

public class LoveIsAllPage {
    public ViewInteraction title;
    public ViewInteraction materialCard;
    public ViewInteraction imageCard;
    public ViewInteraction itemTitle;
    public ViewInteraction itemTextCard;
    public ViewInteraction viewCardButton;

    public LoveIsAllPage() {
        title = onView(withId(R.id.our_mission_title_text_view));
        materialCard = onView(allOf(withId(R.id.our_mission_item_list_recycler_view), Utility.
                childAtPosition(withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")), 0)));
        imageCard = onView(withId(R.id.our_mission_item_image_view));
        itemTitle = onView(withId(R.id.our_mission_item_title_text_view));
        itemTextCard = onView(allOf(withId(R.id.our_mission_item_description_text_view),
                withParent(withParent(withId(R.id.our_mission_item_material_card_view))),
                isDisplayed()));
        viewCardButton = onView(withId(R.id.our_mission_item_open_card_image_button));
    }
}
