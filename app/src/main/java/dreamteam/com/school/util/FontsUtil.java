package dreamteam.com.school.util;

import android.graphics.Typeface;

import dreamteam.com.school.Injector;

/**
 * Created by dima on 07.08.17.
 */

public class FontsUtil {

    public final static String ROBOTO_CONDENSED_BOLD = "fonts/RobotoCondensed-Bold.ttf";
    public final static String ROBOTO_CONDENSED_REGULAR = "fonts/RobotoCondensed-Bold.ttf";

    public static Typeface getTypeFace(String assetTypeFacePath) {
        return Typeface.createFromAsset(Injector.getContext().getAssets(), assetTypeFacePath);
    }
}
