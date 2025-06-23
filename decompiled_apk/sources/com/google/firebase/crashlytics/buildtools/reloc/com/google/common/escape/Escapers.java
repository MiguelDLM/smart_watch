package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.escape;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.Beta;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtCompatible;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Preconditions;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.nullness.compatqual.NullableDecl;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.x0xO0oo;

@Beta
@GwtCompatible
/* loaded from: classes10.dex */
public final class Escapers {
    private static final Escaper NULL_ESCAPER = new CharEscaper() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.escape.Escapers.1
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.escape.CharEscaper
        public char[] escape(char c) {
            return null;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.escape.CharEscaper, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.escape.Escaper
        public String escape(String str) {
            return (String) Preconditions.checkNotNull(str);
        }
    };

    @Beta
    /* loaded from: classes10.dex */
    public static final class Builder {
        private final Map<Character, String> replacementMap;
        private char safeMax;
        private char safeMin;
        private String unsafeReplacement;

        @CanIgnoreReturnValue
        public Builder addEscape(char c, String str) {
            Preconditions.checkNotNull(str);
            this.replacementMap.put(Character.valueOf(c), str);
            return this;
        }

        public Escaper build() {
            return new ArrayBasedCharEscaper(this.replacementMap, this.safeMin, this.safeMax) { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.escape.Escapers.Builder.1
                private final char[] replacementChars;

                {
                    char[] cArr;
                    if (Builder.this.unsafeReplacement != null) {
                        cArr = Builder.this.unsafeReplacement.toCharArray();
                    } else {
                        cArr = null;
                    }
                    this.replacementChars = cArr;
                }

                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.escape.ArrayBasedCharEscaper
                public char[] escapeUnsafe(char c) {
                    return this.replacementChars;
                }
            };
        }

        @CanIgnoreReturnValue
        public Builder setSafeRange(char c, char c2) {
            this.safeMin = c;
            this.safeMax = c2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setUnsafeReplacement(@NullableDecl String str) {
            this.unsafeReplacement = str;
            return this;
        }

        private Builder() {
            this.replacementMap = new HashMap();
            this.safeMin = (char) 0;
            this.safeMax = x0xO0oo.f29362I0Io;
            this.unsafeReplacement = null;
        }
    }

    private Escapers() {
    }

    public static UnicodeEscaper asUnicodeEscaper(Escaper escaper) {
        Preconditions.checkNotNull(escaper);
        if (escaper instanceof UnicodeEscaper) {
            return (UnicodeEscaper) escaper;
        }
        if (escaper instanceof CharEscaper) {
            return wrap((CharEscaper) escaper);
        }
        throw new IllegalArgumentException("Cannot create a UnicodeEscaper from: " + escaper.getClass().getName());
    }

    public static Builder builder() {
        return new Builder();
    }

    public static String computeReplacement(CharEscaper charEscaper, char c) {
        return stringOrNull(charEscaper.escape(c));
    }

    public static Escaper nullEscaper() {
        return NULL_ESCAPER;
    }

    private static String stringOrNull(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return new String(cArr);
    }

    private static UnicodeEscaper wrap(final CharEscaper charEscaper) {
        return new UnicodeEscaper() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.escape.Escapers.2
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.escape.UnicodeEscaper
            public char[] escape(int i) {
                int i2;
                int i3;
                if (i < 65536) {
                    return CharEscaper.this.escape((char) i);
                }
                char[] cArr = new char[2];
                Character.toChars(i, cArr, 0);
                char[] escape = CharEscaper.this.escape(cArr[0]);
                char[] escape2 = CharEscaper.this.escape(cArr[1]);
                if (escape == null && escape2 == null) {
                    return null;
                }
                if (escape != null) {
                    i2 = escape.length;
                } else {
                    i2 = 1;
                }
                if (escape2 != null) {
                    i3 = escape2.length;
                } else {
                    i3 = 1;
                }
                char[] cArr2 = new char[i3 + i2];
                if (escape != null) {
                    for (int i4 = 0; i4 < escape.length; i4++) {
                        cArr2[i4] = escape[i4];
                    }
                } else {
                    cArr2[0] = cArr[0];
                }
                if (escape2 != null) {
                    for (int i5 = 0; i5 < escape2.length; i5++) {
                        cArr2[i2 + i5] = escape2[i5];
                    }
                } else {
                    cArr2[i2] = cArr[1];
                }
                return cArr2;
            }
        };
    }

    public static String computeReplacement(UnicodeEscaper unicodeEscaper, int i) {
        return stringOrNull(unicodeEscaper.escape(i));
    }
}
