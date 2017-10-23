package dreamteam.com.school.util;

import dreamteam.com.school.Injector;
import dreamteam.com.school.R;
import dreamteam.com.school.model.Type;

/**
 * Created by dima on 16.09.17.
 */

public class ClassUtil {

    public static String formatRating(@Type.Rating int rating){
        switch (rating) {
            case Type.Rating.A:
                return Injector.getContext().getString(R.string.mark_A);
            case Type.Rating.B:
                return Injector.getContext().getString(R.string.mark_B);
            case Type.Rating.C:
                return Injector.getContext().getString(R.string.mark_C);
            case Type.Rating.D:
                return Injector.getContext().getString(R.string.mark_D);
            default:
                return Injector.getContext().getString(R.string.no_marks);
        }
    }

}
