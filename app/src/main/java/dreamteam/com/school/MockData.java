package dreamteam.com.school;

import java.util.ArrayList;
import java.util.List;

import dreamteam.com.school.dao.DirectorDao;
import dreamteam.com.school.dao.PupilDao;
import dreamteam.com.school.dao.SchoolDao;
import dreamteam.com.school.entity.DbDirector;
import dreamteam.com.school.entity.DbPupil;
import dreamteam.com.school.entity.DbSchool;
import dreamteam.com.school.model.Type;

/**
 * Created by dima on 26.04.17.
 */

public class MockData {

    private static SchoolDao schoolDao = new SchoolDao();
    private static PupilDao pupilDao = new PupilDao();
    private static DirectorDao directorDao = new DirectorDao();

    public static void saveSchools() {
        schoolDao.saveSchools(getSchoolsList());
    }

    public static void savePupils() {
        pupilDao.savePupils(getPupilList());
    }

    public static void saveDirector() {
        directorDao.saveDirector(getSchoolDirector(), getSchoolDirector().getSchoolId());
    }

    private static List<DbSchool> getSchoolsList() {
        DbSchool school1 = new DbSchool();
        school1.setSchoolId(1);
        school1.setSchoolName("The Lawrenceville school");
        school1.setSchoolCity("Lawrenceville");
        school1.setSchoolCountry("USA");
        school1.setPhotoUrl("https://static1.squarespace.com/static/546402e2e4b0eec8affdf270/t/560e99d1e4b01a86193fffe6/1443797472197/?format=300w");
        school1.setSchoolDescription("The Lawrenceville School, founded in 1810, is considered a National Historic Landmark; this is reflected in the campuses’ old-world architecture and landscaping. Instructors at Lawrenceville use the Harkness Method, which encourages Socratic round-table discussion and ample open dialogue between teacher and student.+The Lawrenceville School, founded in 1810, is considered a National Historic Landmark; this is reflected in the campuses’ old-world architecture and landscaping. Instructors at Lawrenceville use the Harkness Method, which encourages Socratic round-table discussion and ample open dialogue between teacher and student.");
        school1.setLogoUrl("https://upload.wikimedia.org/wikipedia/en/a/aa/Westview_High_School_logo.png");
        school1.setWebsiteUrl("https://www.lawrenceville.org/page");

        DbSchool school2 = new DbSchool();
        school2.setSchoolId(2);
        school2.setSchoolName("Phillips Exeter academy");
        school2.setSchoolCity("Exeter");
        school2.setSchoolCountry("USA");
        school2.setPhotoUrl("https://c1.staticflickr.com/4/3012/2932479631_afea79784b_b.jpg");
        school2.setSchoolDescription("Phillips Exeter Academy, informally Exeter, was founded by American education patron Jon Phillips in 1781. The preparatory school is also known for its pioneering and development of the Harkness Method, which is now widely used by private schools around the world.");
        school2.setLogoUrl("http://www.fromthestandsal.com/wp-content/uploads/2014/06/japan-logo.png");
        school2.setWebsiteUrl("https://www.exeter.edu");

        DbSchool school3 = new DbSchool();
        school3.setSchoolId(3);
        school3.setSchoolName("Lakeside school");
        school3.setSchoolCity("Seattle");
        school3.setSchoolCountry("USA");
        school3.setPhotoUrl("https://media.licdn.com/media/p/6/000/234/049/12389d0.png");
        school3.setSchoolDescription("Lakeside School counts Microsoft founders Bill Gates and Paul Allen as its alums, both known for their self-driven innovation and independent thinking. This legacy is a testament to the school’s principal philosophy, which emphasizes \"effective educators to lead students to take responsibility for learning\".");
        school3.setLogoUrl("http://www.usmge.com/images/cases/logo-gilman.gif");
        school3.setWebsiteUrl("https://www.lakesideschool.org");

        DbSchool school4 = new DbSchool();
        school4.setSchoolId(4);
        school4.setSchoolName("The latin school of chicago");
        school4.setSchoolCity("Seattle");
        school4.setSchoolCountry("USA");
        school4.setPhotoUrl("https://stoppingbyisacs.files.wordpress.com/2015/08/latin-entrance.jpg");
        school4.setSchoolDescription("The Latin School’s urban campus in the Gold Coast neighborhood boasts highly modern amenities reflective of its location, and at the same time holds a rich and unique history. Founded in 1888 by a group of parents seeking a better education for their children, the school’s first class included ten students and was taught by Mabel Slade Vickery.");
        school4.setLogoUrl("https://upload.wikimedia.org/wikipedia/en/thumb/f/f9/CD_Tenerife_logo.svg/447px-CD_Tenerife_logo.svg.png");
        school4.setWebsiteUrl("https://www.latinschool.org");

        DbSchool school5 = new DbSchool();
        school5.setSchoolId(5);
        school5.setSchoolName("Detroit country day school");
        school5.setSchoolCity("Detroit");
        school5.setSchoolCountry("USA");
        school5.setPhotoUrl("https://media.licdn.com/media/p/6/000/234/049/12389d0.png");
        school5.setSchoolDescription("Based upon the Country Day School model, Detroit Country is a co-educational institution that emphasizes art, academia and athletics equally. Each student, in addition to full coursework, must participate in two competitive ‘sports’ (one of the two can be a non-athletic activity such as debate team or chess) and are encouraged to participate in both clubs and community service.");
        school5.setLogoUrl("http://www.stowford.devon.sch.uk/_site/images/design/logo.png");
        school5.setWebsiteUrl("https://www.dcds.edu/index.cfm?&LockSSL=true");

        DbSchool school6 = new DbSchool();
        school6.setSchoolId(6);
        school6.setSchoolName("Harvard-Westlake school");
        school6.setSchoolCity("Los Angeles");
        school6.setSchoolCountry("USA");
        school6.setPhotoUrl("https://static1.squarespace.com/static/50556f87c4aad0824d1f1534/t/55073366e4b02d4e9af783a2/1426535298869/");
        school6.setSchoolDescription("This co-educational day school is the product of a 1991 merger between the Havard School for Boys and the Westlake School for Girls. It has since grown to a body of 1,600 students, but maintains a student teacher ratio of eight to one. Of the 194 full-time faculty, 161 hold either a master’s or doctoral degree.");
        school6.setLogoUrl("https://is3-ssl.mzstatic.com/image/thumb/Purple111/v4/12/68/39/126839c2-af21-f9f9-4fea-7b71f227886c/source/256x256bb.jpg");
        school6.setWebsiteUrl("http://www.hw.com");

        DbSchool school7 = new DbSchool();
        school7.setSchoolId(7);
        school7.setSchoolName("The Harker school");
        school7.setSchoolCity("San Jose");
        school7.setSchoolCountry("USA");
        school7.setPhotoUrl("http://des-ae.com/wp-content/uploads/2013/05/Harker1.jpg");
        school7.setSchoolDescription("With a unique history beginning in 1893, The Harker School began as a small institution for boys, later became a military academy, and settled as a co-educational preparatory school in 1998. Hailed for its scholarly achievement, it was recently called \"The it school for our next Einsteins\" by the San Jose Mercury News. ");
        school7.setLogoUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/Seal_of_St._Xavier_High_School_%28Cincinnati%29.png/240px-Seal_of_St._Xavier_High_School_%28Cincinnati%29.png");
        school7.setWebsiteUrl("https://www.harker.org");

        DbSchool school8 = new DbSchool();
        school8.setSchoolId(8);
        school8.setSchoolName("Polytechnic school");
        school8.setSchoolCity("California");
        school8.setSchoolCountry("USA");
        school8.setPhotoUrl("http://hmcarchitects.com/wp-content/uploads/image005.jpg");
        school8.setSchoolDescription("Polytechnic School, or Poly, was the first non-sectarian and non-profit school founded in California. From its inception in 1907, the private institution has placed a great emphasis on a well-rounded education (the name means literally \"many arts\"), and in recent years, has earned a strong reputation for college preparation. ");
        school8.setLogoUrl("http://www.gandhinagarportal.com/wp-content/uploads/2011/09/st-xaviers-gnr-logo.jpg");
        school8.setWebsiteUrl("https://www.polytechnic.org/page/Home");

        List<DbSchool> schoolList = new ArrayList<>();
        schoolList.add(school1);
        schoolList.add(school2);
        schoolList.add(school3);
        schoolList.add(school4);
        schoolList.add(school5);
        schoolList.add(school6);
        schoolList.add(school7);
        schoolList.add(school8);

        return schoolList;
    }

    private static List<DbPupil> getPupilList() {
        DbPupil dbPupil1 = new DbPupil();
        dbPupil1.setPupilId(1);
        dbPupil1.setSchoolId(1);
        dbPupil1.setFirstName("Margaret");
        dbPupil1.setLastName("Stross");
        dbPupil1.setPersonalInfo(Injector.getContext().getString(R.string.string_pupil_description));
        dbPupil1.setPhotoUrl("http://i2.dailyrecord.co.uk/incoming/article8998729.ece/ALTERNATES/s615/JS101382891.jpg");
        dbPupil1.setSchoolClassId(1);
        dbPupil1.setRating(Type.Rating.A);

        DbPupil dbPupil2 = new DbPupil();
        dbPupil2.setPupilId(2);
        dbPupil2.setSchoolId(1);
        dbPupil2.setFirstName("Sarah");
        dbPupil2.setLastName("Rewot");
        dbPupil2.setPersonalInfo(Injector.getContext().getString(R.string.string_pupil_description));
        dbPupil2.setPhotoUrl("https://image.shutterstock.com/z/stock-photo-asian-primary-school-pupil-reading-a-book-in-classroom-604258028.jpg");
        dbPupil2.setSchoolClassId(2);
        dbPupil2.setRating(Type.Rating.A);

        DbPupil dbPupil3 = new DbPupil();
        dbPupil3.setPupilId(3);
        dbPupil3.setSchoolId(1);
        dbPupil3.setFirstName("Jake");
        dbPupil3.setLastName("Hult");
        dbPupil3.setPersonalInfo(Injector.getContext().getString(R.string.string_pupil_description));
        dbPupil3.setPhotoUrl("http://www.killermont.e-dunbarton.sch.uk/_files/images/new2012/kp_303.jpg");
        dbPupil3.setSchoolClassId(10);
        dbPupil3.setRating(Type.Rating.C);

        DbPupil dbPupil4 = new DbPupil();
        dbPupil4.setPupilId(4);
        dbPupil4.setSchoolId(1);
        dbPupil4.setFirstName("Andrew");
        dbPupil4.setLastName("Gloor");
        dbPupil4.setPersonalInfo(Injector.getContext().getString(R.string.string_pupil_description));
        dbPupil4.setPhotoUrl("https://d2td6mzj4f4e1e.cloudfront.net/wp-content/uploads/sites/7/2013/07/tonbridge-school-pupil-300x200.jpg");
        dbPupil4.setSchoolClassId(5);
        dbPupil4.setRating(Type.Rating.B);

        DbPupil dbPupil5 = new DbPupil();
        dbPupil5.setPupilId(5);
        dbPupil5.setSchoolId(1);
        dbPupil5.setFirstName("Rebeca");
        dbPupil5.setLastName("Nater");
        dbPupil5.setPersonalInfo(Injector.getContext().getString(R.string.string_pupil_description));
        dbPupil5.setPhotoUrl("https://thumbs.dreamstime.com/z/asian-primary-school-pupil-reading-book-classroom-elementary-schoolgirl-thick-88341352.jpg");
        dbPupil5.setSchoolClassId(7);

        DbPupil dbPupil6 = new DbPupil();
        dbPupil6.setPupilId(6);
        dbPupil6.setSchoolId(1);
        dbPupil6.setFirstName("Alison");
        dbPupil6.setLastName("Fressco");
        dbPupil6.setPersonalInfo(Injector.getContext().getString(R.string.string_pupil_description));
        dbPupil6.setPhotoUrl("http://cdn.images.express.co.uk/img/dynamic/78/590x/secondary/maths-child-pupil-Asia-737503.jpg");
        dbPupil6.setSchoolClassId(1);
        dbPupil6.setRating(Type.Rating.A);

        List<DbPupil> dbPupilList = new ArrayList<>();
        dbPupilList.add(dbPupil1);
        dbPupilList.add(dbPupil2);
        dbPupilList.add(dbPupil3);
        dbPupilList.add(dbPupil4);
        dbPupilList.add(dbPupil5);
        dbPupilList.add(dbPupil6);

        return dbPupilList;
    }

    private static DbDirector getSchoolDirector() {
        DbDirector dbDirector = new DbDirector();
        dbDirector.setDirectorId(1);
        dbDirector.setSchoolId(1);
        dbDirector.setFirstName("David");
        dbDirector.setLastName("Hardis");
        dbDirector.setDirectorPhoto("http://www.internationalschool.info/littlestar/wp-content/uploads/2014/01/bibs-director.jpg");
        dbDirector.setDirectorDescription(Injector.getContext().getString(R.string.string_director_description));

        return dbDirector;
    }
}
