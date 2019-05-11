package ir.ifaeze.facts;

import android.app.Application;

import com.batch.android.Batch;
import com.batch.android.BatchActivityLifecycleHelper;
import com.batch.android.BatchEventData;
import com.batch.android.Config;

public class BatchHelper {
    public static final String BUTTON_CLICKED = "button_clicked";
    private static final String APP_VERSION = "app_";
    private static final String INSTALL = "install";

    public static void initBatch(Application application) {
        Batch.setConfig(new Config("5CC05EBACEB77E6D2ABFCA4D6C0C2C"));
        application.registerActivityLifecycleCallbacks(new BatchActivityLifecycleHelper());
    }

    public static void sendInstallEvent() {
        Batch.User.editor()
                .setAttribute(APP_VERSION, BuildConfig.VERSION_NAME)
                .save();
        BatchEventData data = new BatchEventData();
        data.put(APP_VERSION, BuildConfig.VERSION_NAME);
        Batch.User.trackEvent(INSTALL, null, data);
    }
}
