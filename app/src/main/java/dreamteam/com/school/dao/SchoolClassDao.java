package dreamteam.com.school.dao;

import android.support.annotation.Nullable;
import android.util.Log;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Select;

import java.util.List;

import dreamteam.com.school.entity.DbSchool;
import dreamteam.com.school.entity.DbSchoolClass;
import dreamteam.com.school.util.Logger;
import rx.Observable;

/**
 * Created by dima on 07.04.17.
 */

public class SchoolClassDao {
    private static final String LOG_TAG = Logger.getClassTag(SchoolClassDao.class);

    @Nullable
    private DbSchoolClass getSchoolClassById(int schoolClassId) {
        return new Select().from(DbSchoolClass.class)
                .where(DbSchoolClass.COLUMN_SCHOOL_ClASS_ID + " = ?" + schoolClassId)
                .executeSingle();
    }

    public Observable<DbSchoolClass> getSchoolClassByIdAsync(int schoolClassId) {
        return Observable.fromCallable(() -> getSchoolClassById(schoolClassId));
    }

    private List<DbSchoolClass> getSchoolClassesBySchoolId(int schoolId) {
        return new Select().from(DbSchoolClass.class)
                .where(DbSchool.COLUMN_SCHOOL_ID + " = ?" + schoolId)
                .executeSingle();
    }

    public Observable<List<DbSchoolClass>> getSchoolClassesBySchoolIdAsync(int schoolId) {
        return Observable.fromCallable(() -> getSchoolClassesBySchoolId(schoolId));
    }

    public Long saveSchoolClass(DbSchoolClass schoolClass) {
        DbSchoolClass dbSchoolClass = getSchoolClassById(schoolClass.getSchoolClassId());
        if (dbSchoolClass == null) {
            Log.d(LOG_TAG, "School class not font, creating new one");
            dbSchoolClass = new DbSchoolClass();
        }

        dbSchoolClass.setSchoolId(schoolClass.getSchoolId());
        dbSchoolClass.setSchoolClassId(schoolClass.getSchoolClassId());
        dbSchoolClass.setClassName(schoolClass.getClassName());

        return dbSchoolClass.save();
    }

    public void saveSchoolClasses(List<DbSchoolClass> schoolClasses) {
        ActiveAndroid.beginTransaction();
        try {
            for (DbSchoolClass dbSchoolClasses : schoolClasses) {
                saveSchoolClass(dbSchoolClasses);
            }
            ActiveAndroid.setTransactionSuccessful();
        } finally {
            ActiveAndroid.endTransaction();
        }
    }
}
