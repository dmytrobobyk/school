package dreamteam.com.school.view;

import android.graphics.Typeface;
import android.widget.TextView;

import dreamteam.com.school.model.Type;
import dreamteam.com.school.util.FontsUtil;

/**
 * Created by dima on 07.08.17.
 */

public class FontsManager {

    private Typeface titleTypeFace;
    private Typeface commonTypeFace;

    public FontsManager(String titleAssetPath, String commonAssetPath) {
        titleTypeFace = FontsUtil.getTypeFace(titleAssetPath);
        commonTypeFace = FontsUtil.getTypeFace(commonAssetPath);
    }

    public void setTitleTypeFace(TextView textView, int style) {
        setTypeface(textView, titleTypeFace, style);
    }

    public void setCommonTypeFace(TextView textView, int style) {
        setTypeface(textView, commonTypeFace, style);
    }

    public void setTypeface(TextView textView, Typeface typeface, @Type.TypefaceStyle int style) {
        textView.setTypeface(typeface, style);
    }
}
