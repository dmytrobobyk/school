package dreamteam.com.school.dao;

import android.support.annotation.Nullable;

import com.activeandroid.query.Select;

import java.util.List;

import dreamteam.com.school.entity.DbTeacher;
import dreamteam.com.school.util.Logger;
import rx.Observable;

/**
 * Created by dima on 10.04.17.
 */

public class TeacherDao {
    private static final String LOG_TAG = Logger.getClassTag(TeacherDao.class);

    @Nullable
    private DbTeacher getTeacherById(long teacherId) {
        return new Select().from(DbTeacher.class)
                .where(DbTeacher.COLUMN_TEACHER_ID + " = ?", teacherId)
                .executeSingle();
    }

    public Observable<DbTeacher> getTeacherByIdAsync(long teacherId) {
        return Observable.fromCallable(() -> getTeacherById(teacherId));
    }

    @Nullable
    private DbTeacher getTeacherByClassId(int schoolClassId) {
        return new Select().from(DbTeacher.class)
                .where(DbTeacher.COLUMN_SCHOOL_CLASS_ID + " = ?" + schoolClassId)
                .executeSingle();
    }

    public Observable<DbTeacher> getTeacherByClassIdAsync(int schoolClassId) {
        return Observable.fromCallable(() -> getTeacherByClassId(schoolClassId));
    }

    @Nullable
    private List<DbTeacher> getTeachersBySchoolId(int schoolId) {
        return new Select().from(DbTeacher.class)
                .where(DbTeacher.COLUMN_SCHOOL_ID + " = ?", schoolId)
                .executeSingle();
    }

    public Observable<List<DbTeacher>> getTeachersBySchoolIdAsync(int schoolId) {
        return Observable.fromCallable(() -> getTeachersBySchoolId(schoolId));
    }

}
