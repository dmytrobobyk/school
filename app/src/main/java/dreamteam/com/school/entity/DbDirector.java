package dreamteam.com.school.entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by dima on 11.09.17.
 */

@Table(name = "Director")
public class DbDirector extends Model {

    public static final String COLUMN_DIRECTOR_ID = "directorId";
    public static final String COLUMN_SCHOOL_ID = "schoolId";
    public static final String COLUMN_FIRST_NAME = "firstName";
    public static final String COLUMN_LAST_NAME = "lastName";
    public static final String COLUMN_STORY = "directorDescription";
    public static final String COLUMN_DIRECTOR_PHOTO = "directorPhoto";

    @Column(name = COLUMN_DIRECTOR_ID, unique = true, index = true)
    private int directorId;
    @Column(name = COLUMN_SCHOOL_ID)
    private int schoolId;
    @Column(name = COLUMN_FIRST_NAME)
    private String firstName;
    @Column(name = COLUMN_LAST_NAME)
    private String lastName;
    @Column(name = COLUMN_STORY)
    private String directorDescription;
    @Column(name = COLUMN_DIRECTOR_PHOTO)
    private String directorPhoto;

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
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

    public String getDirectorDescription() {
        return directorDescription;
    }

    public void setDirectorDescription(String directorDescription) {
        this.directorDescription = directorDescription;
    }

    public String getDirectorPhoto() {
        return directorPhoto;
    }

    public void setDirectorPhoto(String directorPhoto) {
        this.directorPhoto = directorPhoto;
    }
}
