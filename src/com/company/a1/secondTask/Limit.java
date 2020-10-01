package com.company.a1.secondTask;

public class Limit {
    private static final int ROUNDING_FACTOR = 1000000;

    public static float limit(int n) {

        float res = 1;
        float previousRes;
        float part = 1;
        int i = 0;

        do {
            previousRes = res;
            res += 1 / ((n - i) * part);
            part *= (n - i);
            i++;
            if (i == n) return res;
        } while (previousRes * ROUNDING_FACTOR < res * ROUNDING_FACTOR);

        return res;
    }
}
