package ru.iteco.fmhandroid.ui.data.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MenuBarPage {

    public ViewInteraction mainMenu;
    public ViewInteraction mainButton;
    public ViewInteraction newsButton;
    public ViewInteraction aboutButton;
    public ViewInteraction image;
    public ViewInteraction ourMissionButton;
    public ViewInteraction profileButton;
    public ViewInteraction logOut;

    public MenuBarPage() {
        mainMenu = onView(withId(R.id.main_menu_image_button));
        mainButton = onView(withText("Main"));
        newsButton = onView(withText("News"));
        aboutButton = onView(withText("About"));
        image = onView(withId(R.id.trademark_image_view));
        ourMissionButton = onView(withId(R.id.our_mission_image_button));
        profileButton = onView(withId(R.id.authorization_image_button));
        logOut = onView(withText("Log out"));
    }
}
