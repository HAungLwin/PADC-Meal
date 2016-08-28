package abc.htetaunglwin.padc_meal.components;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import abc.htetaunglwin.padc_meal.utils.MMFontUtils;



public class MMTextView extends TextView{

    public MMTextView(Context context) {
        super(context);
        if (!isInEditMode())
            MMFontUtils.setMMFont(this);
    }

    public MMTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode())
            MMFontUtils.setMMFont(this);
    }

    public MMTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode())
            MMFontUtils.setMMFont(this);
    }
}
