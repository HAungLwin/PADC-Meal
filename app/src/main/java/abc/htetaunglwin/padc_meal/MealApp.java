package abc.htetaunglwin.padc_meal;

import android.app.Application;
import android.content.Context;


public class MealApp extends Application {
    public static final String TAG = "MealApp";

    private static Context context;
    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
