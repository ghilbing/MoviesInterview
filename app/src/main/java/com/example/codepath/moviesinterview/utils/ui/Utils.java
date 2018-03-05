package com.example.codepath.moviesinterview.utils.ui;

import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by gretel on 2/28/18.
 */

public class Utils {
    public static float convertDPToPixels(Resources resources, int dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics());
    }
}
