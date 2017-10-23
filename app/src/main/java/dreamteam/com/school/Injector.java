package dreamteam.com.school;

import android.content.Context;

import dreamteam.com.school.view.FontsManager;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dima on 13.04.17.
 */

public class Injector {

    static Context context;
    static Scheduler ioScheduler = Schedulers.io();
    static Scheduler mainScheduler = AndroidSchedulers.mainThread();
    static FontsManager fontsManager;

    public static Context getContext() {
        return context;
    }

    public static Scheduler getIoScheduler() {
        return ioScheduler;
    }

    public static Scheduler getMainScheduler() {
        return mainScheduler;
    }

    public static FontsManager getFontsManager() {
        return fontsManager;
    }
}
