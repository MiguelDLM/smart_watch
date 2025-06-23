package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli;

/* loaded from: classes10.dex */
final class Util {
    public static String stripLeadingAndTrailingQuotes(String str) {
        int length = str.length();
        if (length > 1 && str.startsWith("\"") && str.endsWith("\"")) {
            int i = length - 1;
            if (str.substring(1, i).indexOf(34) == -1) {
                return str.substring(1, i);
            }
            return str;
        }
        return str;
    }

    public static String stripLeadingHyphens(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith(HelpFormatter.DEFAULT_LONG_OPT_PREFIX)) {
            return str.substring(2, str.length());
        }
        if (str.startsWith(HelpFormatter.DEFAULT_OPT_PREFIX)) {
            return str.substring(1, str.length());
        }
        return str;
    }
}
