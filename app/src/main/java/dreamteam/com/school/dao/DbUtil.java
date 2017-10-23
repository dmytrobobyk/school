package dreamteam.com.school.dao;

import android.content.Context;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;
import com.activeandroid.util.Log;

import java.io.File;

/**
 * Created by dima on 01.08.17.
 */

public class DbUtil {
    private static final String LOG_TAG = DbUtil.class.getName();
    public static final int TRUE = 1;
    private static final int FALSE = 0;

//    public static void initializeDatabase(Configuration configuration) {
//        try {
//            ActiveAndroid.initialize(configuration);
//        } catch (Exception e) {
//            Log.e(LOG_TAG, e);
//            // if exception occurred during database initialization
//            // we try to remove database and reinitialize it
//
//            removeDatabase(configuration.getContext());
//            ActiveAndroid.initialize(configuration);
//        }
//    }

//    private static void removeDatabase(Context context) {
//        try {
//            ActiveAndroid.dispose();
//        } catch (Exception e) {
//            Log.e(LOG_TAG, e);
//        }
//
//        File databaseDir = new File(FileUtils.getAppDataDir(context), "databases");
//        FileUtils.deleteRecursive(databaseDir);
//    }

}
