package dreamteam.com.school.dao;

import android.support.annotation.Nullable;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Select;

import java.util.List;

import dreamteam.com.school.entity.DbSchool;
import dreamteam.com.school.util.Logger;
import rx.Observable;

/**
 * Created by dima on 10.04.17.
 */

public class SchoolDao {
    private static final String LOG_TAG = Logger.getClassTag(SchoolDao.class);

    @Nullable
    private DbSchool getSchoolById(long schoolId) {
        return new Select().from(DbSchool.class)
                .where(DbSchool.COLUMN_SCHOOL_ID + " = ?", schoolId)
                .executeSingle();
    }

    public Observable<DbSchool> getSchoolByIdAsync(int schoolId) {
        return Observable.fromCallable(() -> getSchoolById(schoolId));
    }

    @Nullable
    public List<DbSchool> getAllSchools() {
        return new Select().from(DbSchool.class).execute();
    }

    public Observable<List<DbSchool>> getAllSchoolsAsync() {
        return Observable.fromCallable(() -> getAllSchools());
    }

    public void saveSchool(DbSchool school) {
        DbSchool dbSchool = getSchoolById(school.getSchoolId());
        if (dbSchool == null) {
            Logger.d(LOG_TAG, "School not font, creating new one");
            dbSchool = new DbSchool();
        }

        dbSchool.setSchoolId(school.getSchoolId());
        dbSchool.setSchoolName(school.getSchoolName());
        dbSchool.setSchoolCountry(school.getSchoolCountry());
        dbSchool.setPhotoUrl(school.getPhotoUrl());
        dbSchool.setSchoolCity(school.getSchoolCity());
        dbSchool.setSchoolDescription(school.getSchoolDescription());
        dbSchool.setLogoUrl(school.getLogoUrl());
        dbSchool.setWebsiteUrl(school.getWebsiteUrl());

        dbSchool.save();
    }

    public void saveSchools(List<DbSchool> schools) {
        ActiveAndroid.beginTransaction();
        try {
            for (DbSchool dbSchool : schools) {
                saveSchool(dbSchool);
            }
            ActiveAndroid.setTransactionSuccessful();
        } finally {
            ActiveAndroid.endTransaction();
        }
    }
}
