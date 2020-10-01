package com.company.a1.firstTask;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpV4Converter {

    private static final Long MAX_DECIMAL = 4294967295L;

    private static final String IPV4_REGEX =
            "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                    "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                    "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                    "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

    private static final Pattern IPv4_PATTERN = Pattern.compile(IPV4_REGEX);

    public static long transformDotDecimalIpV4ToDecimalNumber(String stringIp) {

        if (stringIp == null) {
            throw new NullPointerException("Exception: ip is null!");
        }

        if (!isValidateDecimalDotIp(stringIp)) {
            throw new NumberFormatException("Exception: ip format is not valid");
        }

        int[] nums = new int[4];
        int count = 0;

        for (String retval : stringIp.split("\\.", 4)) {
            nums[count++] = Integer.parseInt(retval);
        }

        return formulaOfTransferDotDecimalIpV4ToDecimalNumber(nums);
    }

    public static long formulaOfTransferDotDecimalIpV4ToDecimalNumber(int[] partsOfIpV4) {

        long res = 0;

        for (int i = 0, k = partsOfIpV4.length - 1; i < partsOfIpV4.length; i++, k--) {
            res = (long) (res + partsOfIpV4[i] * Math.pow(256, k));
        }

        return res;
    }

    public static String transformDecimalNumberToDotDecimalIpV4(long ip) {

        if (!isValidateDecimalIp(ip)) {
            return "Не существует такого представления IpV4 эквивалентное заданному числу.";
        }

        return ((ip >> 24) & 0xFF) + "."
                + ((ip >> 16) & 0xFF) + "."
                + ((ip >> 8) & 0xFF) + "."
                + (ip & 0xFF);

    }

    private static boolean isValidateDecimalIp(long number) {
        return number <= MAX_DECIMAL && number >= 0;
    }

    private static boolean isValidateDecimalDotIp(String ip) {
        if (ip == null) {
            return false;
        }
        Matcher matcher = IPv4_PATTERN.matcher(ip);
        return matcher.matches();
    }
}
