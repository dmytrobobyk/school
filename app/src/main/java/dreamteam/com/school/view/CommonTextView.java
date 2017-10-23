package dreamteam.com.school.view;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import dreamteam.com.school.Injector;

/**
 * Created by dima on 07.08.17.
 */

public class CommonTextView extends AppCompatTextView {

    public CommonTextView(Context context) {
        super(context);
        setCommonTypeFace();
    }

    public CommonTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCommonTypeFace();
    }

    public CommonTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setCommonTypeFace();
    }

    private void setCommonTypeFace() {
        Injector.getFontsManager().setCommonTypeFace(this, getTypeface() != null ? getTypeface().getStyle() : Typeface.NORMAL);
    }
}
