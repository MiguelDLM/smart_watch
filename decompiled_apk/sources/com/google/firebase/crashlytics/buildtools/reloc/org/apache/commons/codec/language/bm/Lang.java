package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Languages;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* loaded from: classes10.dex */
public class Lang {
    private static final String LANGUAGE_RULES_RN = "com/google/firebase/crashlytics/buildtools/reloc/org/apache/commons/codec/language/bm/%s_lang.txt";
    private static final Map<NameType, Lang> Langs = new EnumMap(NameType.class);
    private final Languages languages;
    private final List<LangRule> rules;

    /* loaded from: classes10.dex */
    public static final class LangRule {
        private final boolean acceptOnMatch;
        private final Set<String> languages;
        private final Pattern pattern;

        public boolean matches(String str) {
            return this.pattern.matcher(str).find();
        }

        private LangRule(Pattern pattern, Set<String> set, boolean z) {
            this.pattern = pattern;
            this.languages = set;
            this.acceptOnMatch = z;
        }
    }

    static {
        for (NameType nameType : NameType.values()) {
            Langs.put(nameType, loadFromResource(String.format(LANGUAGE_RULES_RN, nameType.getName()), Languages.getInstance(nameType)));
        }
    }

    private Lang(List<LangRule> list, Languages languages) {
        this.rules = Collections.unmodifiableList(list);
        this.languages = languages;
    }

    public static Lang instance(NameType nameType) {
        return Langs.get(nameType);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ad, code lost:
    
        throw new java.lang.IllegalArgumentException("Malformed line '" + r4 + "' in language resource '" + r9 + "'");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Lang loadFromResource(java.lang.String r9, com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Languages r10) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.Class<com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Lang> r1 = com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Lang.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            java.io.InputStream r1 = r1.getResourceAsStream(r9)
            if (r1 == 0) goto Lbb
            java.util.Scanner r2 = new java.util.Scanner
            java.lang.String r3 = "UTF-8"
            r2.<init>(r1, r3)
            r1 = 0
        L19:
            r3 = 0
        L1a:
            boolean r4 = r2.hasNextLine()     // Catch: java.lang.Throwable -> L2f
            if (r4 == 0) goto Lae
            java.lang.String r4 = r2.nextLine()     // Catch: java.lang.Throwable -> L2f
            if (r3 == 0) goto L32
        */
        //  java.lang.String r5 = "*/"
        /*
            boolean r4 = r4.endsWith(r5)     // Catch: java.lang.Throwable -> L2f
            if (r4 == 0) goto L1a
            goto L19
        L2f:
            r9 = move-exception
            goto Lb7
        L32:
            java.lang.String r5 = "/*"
            boolean r5 = r4.startsWith(r5)     // Catch: java.lang.Throwable -> L2f
            r6 = 1
            if (r5 == 0) goto L3d
            r3 = 1
            goto L1a
        L3d:
            java.lang.String r5 = "//"
            int r5 = r4.indexOf(r5)     // Catch: java.lang.Throwable -> L2f
            if (r5 < 0) goto L4a
            java.lang.String r5 = r4.substring(r1, r5)     // Catch: java.lang.Throwable -> L2f
            goto L4b
        L4a:
            r5 = r4
        L4b:
            java.lang.String r5 = r5.trim()     // Catch: java.lang.Throwable -> L2f
            int r7 = r5.length()     // Catch: java.lang.Throwable -> L2f
            if (r7 != 0) goto L56
            goto L1a
        L56:
            java.lang.String r7 = "\\s+"
            java.lang.String[] r5 = r5.split(r7)     // Catch: java.lang.Throwable -> L2f
            int r7 = r5.length     // Catch: java.lang.Throwable -> L2f
            r8 = 3
            if (r7 != r8) goto L8a
            r4 = r5[r1]     // Catch: java.lang.Throwable -> L2f
            java.util.regex.Pattern r4 = java.util.regex.Pattern.compile(r4)     // Catch: java.lang.Throwable -> L2f
            r6 = r5[r6]     // Catch: java.lang.Throwable -> L2f
            java.lang.String r7 = "\\+"
            java.lang.String[] r6 = r6.split(r7)     // Catch: java.lang.Throwable -> L2f
            r7 = 2
            r5 = r5[r7]     // Catch: java.lang.Throwable -> L2f
            java.lang.String r7 = "true"
            boolean r5 = r5.equals(r7)     // Catch: java.lang.Throwable -> L2f
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Lang$LangRule r7 = new com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Lang$LangRule     // Catch: java.lang.Throwable -> L2f
            java.util.HashSet r8 = new java.util.HashSet     // Catch: java.lang.Throwable -> L2f
            java.util.List r6 = java.util.Arrays.asList(r6)     // Catch: java.lang.Throwable -> L2f
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L2f
            r6 = 0
            r7.<init>(r4, r8, r5)     // Catch: java.lang.Throwable -> L2f
            r0.add(r7)     // Catch: java.lang.Throwable -> L2f
            goto L1a
        L8a:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L2f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2f
            r0.<init>()     // Catch: java.lang.Throwable -> L2f
            java.lang.String r1 = "Malformed line '"
            r0.append(r1)     // Catch: java.lang.Throwable -> L2f
            r0.append(r4)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r1 = "' in language resource '"
            r0.append(r1)     // Catch: java.lang.Throwable -> L2f
            r0.append(r9)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r9 = "'"
            r0.append(r9)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r9 = r0.toString()     // Catch: java.lang.Throwable -> L2f
            r10.<init>(r9)     // Catch: java.lang.Throwable -> L2f
            throw r10     // Catch: java.lang.Throwable -> L2f
        Lae:
            r2.close()
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Lang r9 = new com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Lang
            r9.<init>(r0, r10)
            return r9
        Lb7:
            r2.close()
            throw r9
        Lbb:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Unable to resolve required resource:org/apache/commons/codec/language/bm/%s_lang.txt"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Lang.loadFromResource(java.lang.String, com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Languages):com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Lang");
    }

    public String guessLanguage(String str) {
        Languages.LanguageSet guessLanguages = guessLanguages(str);
        if (guessLanguages.isSingleton()) {
            return guessLanguages.getAny();
        }
        return Languages.ANY;
    }

    public Languages.LanguageSet guessLanguages(String str) {
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        HashSet hashSet = new HashSet(this.languages.getLanguages());
        for (LangRule langRule : this.rules) {
            if (langRule.matches(lowerCase)) {
                if (langRule.acceptOnMatch) {
                    hashSet.retainAll(langRule.languages);
                } else {
                    hashSet.removeAll(langRule.languages);
                }
            }
        }
        Languages.LanguageSet from = Languages.LanguageSet.from(hashSet);
        if (from.equals(Languages.NO_LANGUAGES)) {
            return Languages.ANY_LANGUAGE;
        }
        return from;
    }
}
