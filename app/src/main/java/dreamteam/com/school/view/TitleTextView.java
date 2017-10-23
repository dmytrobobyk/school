package dreamteam.com.school.view;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import dreamteam.com.school.Injector;

/**
 * Created by dima on 07.08.17.
 */

public class TitleTextView extends AppCompatTextView {

    public TitleTextView(Context context) {
        super(context);
        setTitleTypeFace();
    }

    public TitleTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTitleTypeFace();
    }

    public TitleTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTitleTypeFace();
    }

    private void setTitleTypeFace() {
        Injector.getFontsManager().setTitleTypeFace(this, getTypeface() != null ? getTypeface().getStyle() : Typeface.NORMAL);
    }
}
