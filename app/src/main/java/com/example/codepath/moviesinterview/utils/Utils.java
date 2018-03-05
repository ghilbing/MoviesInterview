package com.example.codepath.moviesinterview.utils;

import java.math.BigDecimal;

/**
 * Created by gretel on 2/28/18.
 */

public class Utils {
    public static float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
}
