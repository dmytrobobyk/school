package dreamteam.com.school.dao;

import android.support.annotation.Nullable;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Select;

import java.util.List;

import dreamteam.com.school.entity.DbDirector;
import dreamteam.com.school.util.Logger;
import rx.Observable;

/**
 * Created by dima on 11.09.17.
 */

public class DirectorDao {
    private static final String LOG_TAG = Logger.getClassTag(DirectorDao.class);

    @Nullable
    private DbDirector getDirectorBySchoolId(int schoolId) {
        return new Select().from(DbDirector.class)
                .where(DbDirector.COLUMN_SCHOOL_ID + " = ?", schoolId)
                .executeSingle();
    }

    public Observable<DbDirector> getDbDirectorBySchoolIdAsync(int schoolId) {
        return Observable.fromCallable(() -> getDirectorBySchoolId(schoolId));
    }

    public void saveDirector(DbDirector director, int schoolId) {
        DbDirector dbDirector = getDirectorBySchoolId(schoolId);
        if (dbDirector == null) {
            Logger.d(LOG_TAG, "Director didn't found. Creating new one");
            dbDirector = new DbDirector();
        }

        dbDirector.setDirectorId(director.getDirectorId());
        dbDirector.setSchoolId(director.getSchoolId());
        dbDirector.setFirstName(director.getFirstName());
        dbDirector.setLastName(director.getLastName());
        dbDirector.setDirectorDescription(director.getDirectorDescription());
        dbDirector.setDirectorPhoto(director.getDirectorPhoto());

        dbDirector.save();
    }

    public void saveDirectors(List<DbDirector> directorList) {
        ActiveAndroid.beginTransaction();
        try {
            for (DbDirector dbDirector : directorList) {
                saveDirector(dbDirector, dbDirector.getSchoolId());
            }
            ActiveAndroid.setTransactionSuccessful();
        } finally {
            ActiveAndroid.endTransaction();
        }
    }
}
