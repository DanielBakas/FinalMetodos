package com.mms.util;

import java.util.HashMap;
import java.util.Map;

public class MathUtils {
    public final static int scale = 4;
    public final static float decimalLimit = (float) Math.pow(10, -scale);
    public final static int infinity = (int) Math.pow(5, scale);

    public static int factorial(int n) {
        if (n > 30) return infinity;
        if (n <= 1) return 1;

        Map<Integer, Integer> factorials = new HashMap<>();
        factorials.put(0, 1);
        for (int i = 1; i <= n; ++i) {
            int fact = i * factorials.get(i - 1);
            if (i == n)
                return fact;
            factorials.put(i, fact);
        }
        return -1;
    }
}
