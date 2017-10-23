package dreamteam.com.school.util;

import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import dreamteam.com.school.Injector;
import dreamteam.com.school.view.CustomLeadingMarginSpan;

/**
 * Created by dima on 24.09.17.
 */

public class TextUtils {

    public static void setSpannableString(TextView textView, String text) {
        SpannableString content = new SpannableString(text);
        content.setSpan(new UnderlineSpan(), 0, text.length(), 0);
        textView.setText(content);
    }

    public static void setWrappedText(ImageView imageView, String photoUrl, TextView textView, String text) {

        int leftMargin = imageView.getWidth();
        Glide.with(Injector.getContext())
                .load(photoUrl)
                .into(imageView);

        SpannableString ss = new SpannableString(text);
        // tabulation for first 8 lines
        ss.setSpan(new CustomLeadingMarginSpan(8, leftMargin), 0, ss.length(), 0);
        textView.setText(ss);
    }
}
