package dreamteam.com.school.entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by dima on 07.04.17.
 */

@Table(name = "Teacher")
public class DbTeacher extends Model {

    public static final String COLUMN_TEACHER_ID = "teacherId";
    public static final String COLUMN_FIRST_NAME = "firstName";
    public static final String COLUMN_LAST_NAME = "lastName";
    public static final String COLUMN_PATRONYMIC = "patronymic";
    public static final String COLUMN_SCHOOL_ID = "schoolId";
    public static final String COLUMN_SCHOOL_CLASS_ID = "schoolClassId";
    public static final String COLUMN_PERSONAL_INFO = "personalInfo";
    public static final String COLUMN_PHOTO_URL = "photoUrl";

    @Column(name = COLUMN_TEACHER_ID, unique = true, index = true)
    private long teacherId;
    @Column(name = COLUMN_FIRST_NAME)
    private String firstName;
    @Column(name = COLUMN_LAST_NAME)
    private String lastName;
    @Column(name = COLUMN_PATRONYMIC)
    private String patronymic;
    @Column(name = COLUMN_SCHOOL_ID)
    private int schoolId;
    @Column(name = COLUMN_SCHOOL_CLASS_ID)
    private int schoolClassId;
    @Column(name = COLUMN_PERSONAL_INFO)
    private String personalInfo;
    @Column(name = COLUMN_PHOTO_URL)
    private String photoUrl;

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public int getSchoolClassId() {
        return schoolClassId;
    }

    public void setSchoolClassId(int schoolClassId) {
        this.schoolClassId = schoolClassId;
    }

    public String getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(String personalInfo) {
        this.personalInfo = personalInfo;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
