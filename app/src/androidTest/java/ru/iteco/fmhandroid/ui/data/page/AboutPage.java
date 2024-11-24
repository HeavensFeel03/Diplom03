package ru.iteco.fmhandroid.ui.data.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.data.Utility;

public class AboutPage {

    public ViewInteraction titleVersion;
    public ViewInteraction versionValue;
    public ViewInteraction privacyPolicy;
    public ViewInteraction privacyPolicyLinc;
    public ViewInteraction termsOfUse;
    public ViewInteraction termsOfUseLinc;
    public ViewInteraction infoLabel;
    public ViewInteraction backButton;


    public AboutPage() {
        titleVersion = onView(withId(R.id.about_version_title_text_view));
        versionValue = onView(withId(R.id.about_version_value_text_view));
        privacyPolicy = onView(withId(R.id.about_privacy_policy_label_text_view));
        privacyPolicyLinc = onView(withId(R.id.about_privacy_policy_value_text_view));
        termsOfUse = onView(withId(R.id.about_terms_of_use_label_text_view));
        termsOfUseLinc = onView(withId(R.id.about_terms_of_use_value_text_view));
        infoLabel = onView(withId(R.id.about_company_info_label_text_view));
        backButton = onView(withId(R.id.about_back_image_button));
    }

    public void waitingPageLoad() {
        Allure.step("Ожидание загрузки страницы");
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.about_version_title_text_view, 7000));
    }
}
