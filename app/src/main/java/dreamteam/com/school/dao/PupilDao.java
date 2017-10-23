package dreamteam.com.school.dao;

import android.support.annotation.Nullable;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Select;

import java.util.List;

import dreamteam.com.school.entity.DbPupil;
import dreamteam.com.school.util.Logger;
import rx.Observable;

/**
 * Created by dima on 07.04.17.
 */

public class PupilDao {
    private static final String LOG_TAG = Logger.getClassTag(PupilDao.class);

    @Nullable
    private DbPupil getPupilById(long pupilId) {
        return new Select().from(DbPupil.class)
                .where(DbPupil.COLUMN_PUPIL_ID + " = ?", pupilId)
                .executeSingle();
    }

    public Observable<DbPupil> getPupilByIdAsync(long pupilId) {
        return Observable.fromCallable(() -> getPupilById(pupilId));
    }

    @Nullable
    private List<DbPupil> getPupilsBySchoolId(int schoolId) {
        return new Select().from(DbPupil.class)
                .where(DbPupil.COLUMN_SCHOOL_ID + " = ?", schoolId)
                .execute();
    }

    public Observable<List<DbPupil>> getPupilsBySchoolIdAsync(int schoolId) {
        return Observable.fromCallable(() -> getPupilsBySchoolId(schoolId));
    }

    @Nullable
    private List<DbPupil> getPupilsInClass(int classId, int schoolId) {
        return new Select().from(DbPupil.class)
                .where(DbPupil.COLUMN_CLASS_ID + " = ?", classId)
                .and(DbPupil.COLUMN_SCHOOL_ID + " = ?", schoolId)
                .executeSingle();
    }

    public Observable<List<DbPupil>> getPupilsInClassAsync(int classId, int schoolId) {
        return Observable.fromCallable(() -> getPupilsInClass(classId, schoolId));
    }

    public Long savePupil(DbPupil pupil) {
        DbPupil dbPupil = getPupilById(pupil.getPupilId());
        if (dbPupil == null) {
            Logger.d(LOG_TAG, "Pupil didn't found, creating new one");
            dbPupil = new DbPupil();
        }

        dbPupil.setPupilId(pupil.getPupilId());
        dbPupil.setFirstName(pupil.getFirstName());
        dbPupil.setLastName(pupil.getLastName());
        dbPupil.setSchoolId(pupil.getSchoolId());
        dbPupil.setSchoolClassId(pupil.getSchoolClassId());
        dbPupil.setPersonalInfo(pupil.getPersonalInfo());
        dbPupil.setPhotoUrl(pupil.getPhotoUrl());
        dbPupil.setRating(pupil.getRating());

        return dbPupil.save();
    }

    public void savePupils(List<DbPupil> pupils) {
        ActiveAndroid.beginTransaction();
        try {
            for(DbPupil dbPupil : pupils){
                savePupil(dbPupil);
            }
            ActiveAndroid.setTransactionSuccessful();
        }
        finally {
            ActiveAndroid.endTransaction();
        }
    }
}
