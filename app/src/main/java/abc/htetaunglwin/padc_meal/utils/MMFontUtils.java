package abc.htetaunglwin.padc_meal.utils;

import android.content.Context;
import android.graphics.Typeface;

import android.widget.TextView;


import abc.htetaunglwin.padc_meal.MealApp;

/**
 * Created by aung on 6/25/16.
 */
public class MMFontUtils {

    private static Typeface mmTypeFace;

    static {
        Context context = MealApp.getContext();
        mmTypeFace = Typeface.createFromAsset(context.getAssets(), "fonts/Zawgyi.ttf");
    }

    public static void setMMFont(TextView view) {
        view.setTypeface(mmTypeFace);
    }


}
