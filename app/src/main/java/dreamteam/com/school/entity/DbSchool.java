package dreamteam.com.school.entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by dima on 07.04.17.
 */

@Table(name = "School")
public class DbSchool extends Model {

    public static final String COLUMN_SCHOOL_ID = "schoolId";
    public static final String COLUMN_SCHOOL_NAME = "schoolName";
    public static final String COLUMN_SCHOOL_COUNTRY = "schoolCountry";
    public static final String COLUMN_SCHOOL_CITY = "schoolCity";
    public static final String COLUMN_SCHOOL_DESCRIPTION = "schoolDescription";
    public static final String COLUMN_PHOTO_URL = "photoUrl";
    public static final String COLUMN_LOGO_URL = "logoUrl";
    public static final String COLUMN_WEBSITE_URL = "websiteUrl";

    @Column(name = COLUMN_SCHOOL_ID, unique = true, index = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    private int schoolId;
    @Column(name = COLUMN_SCHOOL_NAME)
    private String schoolName;
    @Column(name = COLUMN_SCHOOL_CITY)
    private String schoolCity;
    @Column(name = COLUMN_SCHOOL_COUNTRY)
    private String schoolCountry;
    @Column(name = COLUMN_SCHOOL_DESCRIPTION)
    private String schoolDescription;
    @Column(name = COLUMN_PHOTO_URL)
    private String photoUrl;
    @Column(name = COLUMN_LOGO_URL)
    private String logoUrl;
    @Column(name = COLUMN_WEBSITE_URL)
    private String websiteUrl;

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolCity() {
        return schoolCity;
    }

    public void setSchoolCity(String schoolCity) {
        this.schoolCity = schoolCity;
    }

    public String getSchoolDescription() {
        return schoolDescription;
    }

    public void setSchoolDescription(String schoolDescription) {
        this.schoolDescription = schoolDescription;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolCountry() {
        return schoolCountry;
    }

    public void setSchoolCountry(String schoolCountry) {
        this.schoolCountry = schoolCountry;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }
}
