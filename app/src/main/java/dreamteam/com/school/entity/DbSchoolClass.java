package dreamteam.com.school.entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.List;

/**
 * Created by dima on 07.04.17.
 */

@Table(name = "SchoolClass")
public class DbSchoolClass extends Model {

    public static final String COLUMN_SCHOOL_ID = "schoolId";
    public static final String COLUMN_SCHOOL_ClASS_ID = "schoolClassId";
    public static final String COLUMN_CLASS_NAME = "className";

    @Column(name = COLUMN_SCHOOL_ClASS_ID, unique = true, index = true)
    private int schoolClassId;
    @Column(name = COLUMN_SCHOOL_ID)
    private int schoolId;
    @Column(name = COLUMN_CLASS_NAME)
    private String className;
    private List<DbPupil> pupilsList;

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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<DbPupil> getPupilsList() {
        return pupilsList;
    }

    public void setPupilsList(List<DbPupil> pupilsList) {
        this.pupilsList = pupilsList;
    }
}
