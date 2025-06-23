package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base;

import XXO0.oIX0oI;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtCompatible;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.nullness.compatqual.NullableDecl;
import java.io.Serializable;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'LOWER_UNDERSCORE' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@GwtCompatible
/* loaded from: classes10.dex */
public abstract class CaseFormat {
    private static final /* synthetic */ CaseFormat[] $VALUES;
    public static final CaseFormat LOWER_CAMEL;
    public static final CaseFormat LOWER_HYPHEN;
    public static final CaseFormat LOWER_UNDERSCORE;
    public static final CaseFormat UPPER_CAMEL;
    public static final CaseFormat UPPER_UNDERSCORE;
    private final CharMatcher wordBoundary;
    private final String wordSeparator;

    /* loaded from: classes10.dex */
    public static final class StringConverter extends Converter<String, String> implements Serializable {
        private static final long serialVersionUID = 0;
        private final CaseFormat sourceFormat;
        private final CaseFormat targetFormat;

        public StringConverter(CaseFormat caseFormat, CaseFormat caseFormat2) {
            this.sourceFormat = (CaseFormat) Preconditions.checkNotNull(caseFormat);
            this.targetFormat = (CaseFormat) Preconditions.checkNotNull(caseFormat2);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Converter, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Function
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof StringConverter)) {
                return false;
            }
            StringConverter stringConverter = (StringConverter) obj;
            if (!this.sourceFormat.equals(stringConverter.sourceFormat) || !this.targetFormat.equals(stringConverter.targetFormat)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.sourceFormat.hashCode() ^ this.targetFormat.hashCode();
        }

        public String toString() {
            return this.sourceFormat + ".converterTo(" + this.targetFormat + oIX0oI.I0Io.f4095I0Io;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Converter
        public String doBackward(String str) {
            return this.targetFormat.to(this.sourceFormat, str);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Converter
        public String doForward(String str) {
            return this.sourceFormat.to(this.targetFormat, str);
        }
    }

    static {
        CaseFormat caseFormat = new CaseFormat("LOWER_HYPHEN", 0, CharMatcher.is('-'), HelpFormatter.DEFAULT_OPT_PREFIX) { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.CaseFormat.1
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.CaseFormat
            public String convert(CaseFormat caseFormat2, String str) {
                if (caseFormat2 == CaseFormat.LOWER_UNDERSCORE) {
                    return str.replace('-', '_');
                }
                if (caseFormat2 == CaseFormat.UPPER_UNDERSCORE) {
                    return Ascii.toUpperCase(str.replace('-', '_'));
                }
                return super.convert(caseFormat2, str);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.CaseFormat
            public String normalizeWord(String str) {
                return Ascii.toLowerCase(str);
            }
        };
        LOWER_HYPHEN = caseFormat;
        String str = "_";
        CaseFormat caseFormat2 = new CaseFormat("LOWER_UNDERSCORE", 1, CharMatcher.is('_'), str) { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.CaseFormat.2
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.CaseFormat
            public String convert(CaseFormat caseFormat3, String str2) {
                if (caseFormat3 == CaseFormat.LOWER_HYPHEN) {
                    return str2.replace('_', '-');
                }
                if (caseFormat3 == CaseFormat.UPPER_UNDERSCORE) {
                    return Ascii.toUpperCase(str2);
                }
                return super.convert(caseFormat3, str2);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.CaseFormat
            public String normalizeWord(String str2) {
                return Ascii.toLowerCase(str2);
            }
        };
        LOWER_UNDERSCORE = caseFormat2;
        String str2 = "";
        CaseFormat caseFormat3 = new CaseFormat("LOWER_CAMEL", 2, CharMatcher.inRange('A', 'Z'), str2) { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.CaseFormat.3
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.CaseFormat
            public String normalizeWord(String str3) {
                return CaseFormat.firstCharOnlyToUpper(str3);
            }
        };
        LOWER_CAMEL = caseFormat3;
        CaseFormat caseFormat4 = new CaseFormat("UPPER_CAMEL", 3, CharMatcher.inRange('A', 'Z'), str2) { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.CaseFormat.4
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.CaseFormat
            public String normalizeWord(String str3) {
                return CaseFormat.firstCharOnlyToUpper(str3);
            }
        };
        UPPER_CAMEL = caseFormat4;
        CaseFormat caseFormat5 = new CaseFormat("UPPER_UNDERSCORE", 4, CharMatcher.is('_'), str) { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.CaseFormat.5
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.CaseFormat
            public String convert(CaseFormat caseFormat6, String str3) {
                if (caseFormat6 == CaseFormat.LOWER_HYPHEN) {
                    return Ascii.toLowerCase(str3.replace('_', '-'));
                }
                if (caseFormat6 == CaseFormat.LOWER_UNDERSCORE) {
                    return Ascii.toLowerCase(str3);
                }
                return super.convert(caseFormat6, str3);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.CaseFormat
            public String normalizeWord(String str3) {
                return Ascii.toUpperCase(str3);
            }
        };
        UPPER_UNDERSCORE = caseFormat5;
        $VALUES = new CaseFormat[]{caseFormat, caseFormat2, caseFormat3, caseFormat4, caseFormat5};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String firstCharOnlyToUpper(String str) {
        if (!str.isEmpty()) {
            return Ascii.toUpperCase(str.charAt(0)) + Ascii.toLowerCase(str.substring(1));
        }
        return str;
    }

    private String normalizeFirstWord(String str) {
        if (this == LOWER_CAMEL) {
            return Ascii.toLowerCase(str);
        }
        return normalizeWord(str);
    }

    public static CaseFormat valueOf(String str) {
        return (CaseFormat) Enum.valueOf(CaseFormat.class, str);
    }

    public static CaseFormat[] values() {
        return (CaseFormat[]) $VALUES.clone();
    }

    public String convert(CaseFormat caseFormat, String str) {
        StringBuilder sb = null;
        int i = 0;
        int i2 = -1;
        while (true) {
            i2 = this.wordBoundary.indexIn(str, i2 + 1);
            if (i2 == -1) {
                break;
            }
            if (i == 0) {
                sb = new StringBuilder(str.length() + (this.wordSeparator.length() * 4));
                sb.append(caseFormat.normalizeFirstWord(str.substring(i, i2)));
            } else {
                sb.append(caseFormat.normalizeWord(str.substring(i, i2)));
            }
            sb.append(caseFormat.wordSeparator);
            i = this.wordSeparator.length() + i2;
        }
        if (i == 0) {
            return caseFormat.normalizeFirstWord(str);
        }
        sb.append(caseFormat.normalizeWord(str.substring(i)));
        return sb.toString();
    }

    public Converter<String, String> converterTo(CaseFormat caseFormat) {
        return new StringConverter(this, caseFormat);
    }

    public abstract String normalizeWord(String str);

    public final String to(CaseFormat caseFormat, String str) {
        Preconditions.checkNotNull(caseFormat);
        Preconditions.checkNotNull(str);
        if (caseFormat != this) {
            return convert(caseFormat, str);
        }
        return str;
    }

    private CaseFormat(String str, int i, CharMatcher charMatcher, String str2) {
        this.wordBoundary = charMatcher;
        this.wordSeparator = str2;
    }
}
