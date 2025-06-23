package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli;

/* loaded from: classes10.dex */
final class OptionValidator {
    private static boolean isValidChar(char c) {
        return Character.isJavaIdentifierPart(c);
    }

    private static boolean isValidOpt(char c) {
        if (!isValidChar(c) && c != '?' && c != '@') {
            return false;
        }
        return true;
    }

    public static void validateOption(String str) throws IllegalArgumentException {
        if (str == null) {
            return;
        }
        if (str.length() == 1) {
            char charAt = str.charAt(0);
            if (!isValidOpt(charAt)) {
                throw new IllegalArgumentException("Illegal option name '" + charAt + "'");
            }
            return;
        }
        for (char c : str.toCharArray()) {
            if (!isValidChar(c)) {
                throw new IllegalArgumentException("The option '" + str + "' contains an illegal character : '" + c + "'");
            }
        }
    }
}
