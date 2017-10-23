package dreamteam.com.school.entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import dreamteam.com.school.model.Type;

/**
 * Created by dima on 07.04.17.
 */

@Table(name = "Pupil")
public class DbPupil extends Model {

    public static final String COLUMN_PUPIL_ID = "pupilId";
    public static final String COLUMN_FIRST_NAME = "firstName";
    public static final String COLUMN_LAST_NAME = "lastName";
    public static final String COLUMN_SCHOOL_ID = "schoolId";
    public static final String COLUMN_CLASS_ID = "schoolClassId";
    public static final String COLUMN_PERSONAL_INFO = "personalInfo";
    public static final String COLUMN_PHOTO_URL = "photoUrl";
    public static final String COLUMN_RATING= "rating";

    @Column(name = COLUMN_PUPIL_ID, unique = true, index = true)
    private long pupilId;
    @Column(name = COLUMN_FIRST_NAME)
    private String firstName;
    @Column(name = COLUMN_LAST_NAME)
    private String lastName;
    @Column(name = COLUMN_SCHOOL_ID)
    private int schoolId;
    @Column(name = COLUMN_CLASS_ID)
    private int schoolClassId;
    @Column(name = COLUMN_PERSONAL_INFO)
    private String personalInfo;
    @Column(name = COLUMN_PHOTO_URL)
    private String photoUrl;
    @Column(name = COLUMN_RATING)
    private @Type.Rating int rating;


    public long getPupilId() {
        return pupilId;
    }

    public void setPupilId(long pupilId) {
        this.pupilId = pupilId;
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

    public @Type.Rating int getRating() {
        return rating;
    }

    public void setRating(@Type.Rating int rating) {
        this.rating = rating;
    }
}
