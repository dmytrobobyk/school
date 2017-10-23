package dreamteam.com.school.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;

/**
 * Created by dima on 25.09.17.
 */

public class CustomLeadingMarginSpan implements LeadingMarginSpan.LeadingMarginSpan2 {
    private int margin;
    private int lines;

    public CustomLeadingMarginSpan(int lines, int margin) {
        this.margin = margin;
        this.lines = lines;
    }

    @Override
    public int getLeadingMargin(boolean first) {
        if (first) {
            return margin;
        } else {
            return 0;
        }
    }

    @Override
    public void drawLeadingMargin(Canvas c, Paint p, int x, int dir,
                                  int top, int baseline, int bottom, CharSequence text,
                                  int start, int end, boolean first, Layout layout) {
    }

    @Override
    public int getLeadingMarginLineCount() {
        return lines;
    }
}