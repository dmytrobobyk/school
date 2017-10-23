package dreamteam.com.school;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;

import dreamteam.com.school.util.FontsUtil;
import dreamteam.com.school.view.FontsManager;

/**
 * Created by dima on 01.08.17.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initializeDb();
        Injector.context = this;
        Injector.fontsManager = new FontsManager(FontsUtil.ROBOTO_CONDENSED_BOLD, FontsUtil.ROBOTO_CONDENSED_REGULAR);
    }

    private void initializeDb() {
        Configuration configuration = new Configuration.Builder(this).setDatabaseName("schools.db").setDatabaseVersion(1).create();
        ActiveAndroid.initialize(configuration);
    }
}
