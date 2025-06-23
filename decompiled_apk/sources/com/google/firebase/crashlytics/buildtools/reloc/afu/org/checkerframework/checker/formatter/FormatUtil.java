package com.google.firebase.crashlytics.buildtools.reloc.afu.org.checkerframework.checker.formatter;

import com.google.firebase.crashlytics.buildtools.reloc.afu.org.checkerframework.checker.formatter.qual.ConversionCategory;
import com.google.firebase.crashlytics.buildtools.reloc.afu.org.checkerframework.checker.formatter.qual.ReturnsFormat;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IllegalFormatConversionException;
import java.util.IllegalFormatException;
import java.util.MissingFormatArgumentException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.XIxXXX0x0;

/* loaded from: classes10.dex */
public class FormatUtil {
    private static final String formatSpecifier = "%(\\d+\\$)?([-#+ 0,(\\<]*)?(\\d+)?(\\.\\d+)?([tT])?([a-zA-Z%])";
    private static Pattern fsPattern = Pattern.compile(formatSpecifier);

    /* loaded from: classes10.dex */
    public static class Conversion {
        private final ConversionCategory cath;
        private final int index;

        public Conversion(char c, int i) {
            this.index = i;
            this.cath = ConversionCategory.fromConversionChar(c);
        }

        public ConversionCategory category() {
            return this.cath;
        }

        public int index() {
            return this.index;
        }
    }

    /* loaded from: classes10.dex */
    public static class ExcessiveOrMissingFormatArgumentException extends MissingFormatArgumentException {
        private static final long serialVersionUID = 17000126;
        private final int expected;
        private final int found;

        public ExcessiveOrMissingFormatArgumentException(int i, int i2) {
            super(HelpFormatter.DEFAULT_OPT_PREFIX);
            this.expected = i;
            this.found = i2;
        }

        public int getExpected() {
            return this.expected;
        }

        public int getFound() {
            return this.found;
        }

        @Override // java.util.MissingFormatArgumentException, java.lang.Throwable
        public String getMessage() {
            return String.format("Expected %d arguments but found %d.", Integer.valueOf(this.expected), Integer.valueOf(this.found));
        }
    }

    /* loaded from: classes10.dex */
    public static class IllegalFormatConversionCategoryException extends IllegalFormatConversionException {
        private static final long serialVersionUID = 17000126;
        private final ConversionCategory expected;
        private final ConversionCategory found;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public IllegalFormatConversionCategoryException(com.google.firebase.crashlytics.buildtools.reloc.afu.org.checkerframework.checker.formatter.qual.ConversionCategory r4, com.google.firebase.crashlytics.buildtools.reloc.afu.org.checkerframework.checker.formatter.qual.ConversionCategory r5) {
            /*
                r3 = this;
                java.lang.String r0 = r4.chars
                int r0 = r0.length()
                r1 = 0
                if (r0 != 0) goto Lc
                r0 = 45
                goto L12
            Lc:
                java.lang.String r0 = r4.chars
                char r0 = r0.charAt(r1)
            L12:
                java.lang.Class[] r2 = r5.types
                if (r2 != 0) goto L19
                java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
                goto L1d
            L19:
                java.lang.Class[] r2 = r5.types
                r1 = r2[r1]
            L1d:
                r3.<init>(r0, r1)
                r3.expected = r4
                r3.found = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.buildtools.reloc.afu.org.checkerframework.checker.formatter.FormatUtil.IllegalFormatConversionCategoryException.<init>(com.google.firebase.crashlytics.buildtools.reloc.afu.org.checkerframework.checker.formatter.qual.ConversionCategory, com.google.firebase.crashlytics.buildtools.reloc.afu.org.checkerframework.checker.formatter.qual.ConversionCategory):void");
        }

        public ConversionCategory getExpected() {
            return this.expected;
        }

        public ConversionCategory getFound() {
            return this.found;
        }

        @Override // java.util.IllegalFormatConversionException, java.lang.Throwable
        public String getMessage() {
            return String.format("Expected category %s but found %s.", this.expected, this.found);
        }
    }

    @ReturnsFormat
    public static String asFormat(String str, ConversionCategory... conversionCategoryArr) throws IllegalFormatException {
        ConversionCategory[] formatParameterCategories = formatParameterCategories(str);
        if (formatParameterCategories.length == conversionCategoryArr.length) {
            for (int i = 0; i < conversionCategoryArr.length; i++) {
                if (conversionCategoryArr[i] != formatParameterCategories[i]) {
                    throw new IllegalFormatConversionCategoryException(conversionCategoryArr[i], formatParameterCategories[i]);
                }
            }
            return str;
        }
        throw new ExcessiveOrMissingFormatArgumentException(conversionCategoryArr.length, formatParameterCategories.length);
    }

    private static char conversionCharFromFormat(Matcher matcher) {
        String group = matcher.group(5);
        if (group == null) {
            return matcher.group(6).charAt(0);
        }
        return group.charAt(0);
    }

    public static ConversionCategory[] formatParameterCategories(String str) throws IllegalFormatException {
        ConversionCategory conversionCategory;
        ConversionCategory conversionCategory2;
        tryFormatSatisfiability(str);
        Conversion[] parse = parse(str);
        HashMap hashMap = new HashMap();
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        for (Conversion conversion : parse) {
            int index = conversion.index();
            if (index != -1) {
                if (index != 0) {
                    i3 = index - 1;
                } else {
                    i2++;
                    i3 = i2;
                }
            }
            i = Math.max(i, i3);
            Integer valueOf = Integer.valueOf(i3);
            if (hashMap.containsKey(Integer.valueOf(i3))) {
                conversionCategory2 = (ConversionCategory) hashMap.get(Integer.valueOf(i3));
            } else {
                conversionCategory2 = ConversionCategory.UNUSED;
            }
            hashMap.put(valueOf, ConversionCategory.intersect(conversionCategory2, conversion.category()));
        }
        ConversionCategory[] conversionCategoryArr = new ConversionCategory[i + 1];
        for (int i4 = 0; i4 <= i; i4++) {
            if (hashMap.containsKey(Integer.valueOf(i4))) {
                conversionCategory = (ConversionCategory) hashMap.get(Integer.valueOf(i4));
            } else {
                conversionCategory = ConversionCategory.UNUSED;
            }
            conversionCategoryArr[i4] = conversionCategory;
        }
        return conversionCategoryArr;
    }

    private static int indexFromFormat(Matcher matcher) {
        String group = matcher.group(1);
        if (group != null) {
            return Integer.parseInt(group.substring(0, group.length() - 1));
        }
        if (matcher.group(2) == null || !matcher.group(2).contains(String.valueOf(XIxXXX0x0.f29542X0o0xo))) {
            return 0;
        }
        return -1;
    }

    private static Conversion[] parse(String str) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = fsPattern.matcher(str);
        while (matcher.find()) {
            char conversionCharFromFormat = conversionCharFromFormat(matcher);
            if (conversionCharFromFormat != '%' && conversionCharFromFormat != 'n') {
                arrayList.add(new Conversion(conversionCharFromFormat, indexFromFormat(matcher)));
            }
        }
        return (Conversion[]) arrayList.toArray(new Conversion[arrayList.size()]);
    }

    public static void tryFormatSatisfiability(String str) throws IllegalFormatException {
        String.format(str, null);
    }
}
