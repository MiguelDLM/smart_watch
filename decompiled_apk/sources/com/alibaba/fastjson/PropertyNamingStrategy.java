package com.alibaba.fastjson;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;

/* loaded from: classes.dex */
public enum PropertyNamingStrategy {
    CamelCase,
    PascalCase,
    SnakeCase,
    KebabCase,
    NoChange,
    NeverUseThisValueExceptDefaultValue;

    /* renamed from: com.alibaba.fastjson.PropertyNamingStrategy$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy;

        static {
            int[] iArr = new int[PropertyNamingStrategy.values().length];
            $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy = iArr;
            try {
                iArr[PropertyNamingStrategy.SnakeCase.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[PropertyNamingStrategy.KebabCase.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[PropertyNamingStrategy.PascalCase.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[PropertyNamingStrategy.CamelCase.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[PropertyNamingStrategy.NoChange.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[PropertyNamingStrategy.NeverUseThisValueExceptDefaultValue.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public String translate(String str) {
        int i = AnonymousClass1.$SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[ordinal()];
        int i2 = 0;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return str;
                    }
                    char charAt = str.charAt(0);
                    if (charAt >= 'A' && charAt <= 'Z') {
                        char[] charArray = str.toCharArray();
                        charArray[0] = (char) (charArray[0] + TokenParser.SP);
                        return new String(charArray);
                    }
                    return str;
                }
                char charAt2 = str.charAt(0);
                if (charAt2 >= 'a' && charAt2 <= 'z') {
                    char[] charArray2 = str.toCharArray();
                    charArray2[0] = (char) (charArray2[0] - ' ');
                    return new String(charArray2);
                }
                return str;
            }
            StringBuilder sb = new StringBuilder();
            while (i2 < str.length()) {
                char charAt3 = str.charAt(i2);
                if (charAt3 >= 'A' && charAt3 <= 'Z') {
                    char c = (char) (charAt3 + TokenParser.SP);
                    if (i2 > 0) {
                        sb.append('-');
                    }
                    sb.append(c);
                } else {
                    sb.append(charAt3);
                }
                i2++;
            }
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        while (i2 < str.length()) {
            char charAt4 = str.charAt(i2);
            if (charAt4 >= 'A' && charAt4 <= 'Z') {
                char c2 = (char) (charAt4 + TokenParser.SP);
                if (i2 > 0) {
                    sb2.append('_');
                }
                sb2.append(c2);
            } else {
                sb2.append(charAt4);
            }
            i2++;
        }
        return sb2.toString();
    }
}
