package dreamteam.com.school.model;

import android.graphics.Typeface;
import android.support.annotation.IntDef;

/**
 * Created by dima on 07.08.17.
 */

public interface Type {

    @IntDef({Typeface.BOLD, Typeface.BOLD_ITALIC, Typeface.ITALIC, Typeface.NORMAL})
    @interface TypefaceStyle {
    }

    @IntDef({Rating.A, Rating.B, Rating.C, Rating.D})
    @interface Rating {
        int D = 2;
        int C = 3;
        int B = 4;
        int A = 5;
    }

}
