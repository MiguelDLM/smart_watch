package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm;

import XXO0.oIX0oI;
import java.io.InputStream;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

/* loaded from: classes10.dex */
public class Languages {
    public static final String ANY = "any";
    public static final LanguageSet ANY_LANGUAGE;
    private static final Map<NameType, Languages> LANGUAGES = new EnumMap(NameType.class);
    public static final LanguageSet NO_LANGUAGES;
    private final Set<String> languages;

    /* loaded from: classes10.dex */
    public static abstract class LanguageSet {
        public static LanguageSet from(Set<String> set) {
            if (set.isEmpty()) {
                return Languages.NO_LANGUAGES;
            }
            return new SomeLanguages(set);
        }

        public abstract boolean contains(String str);

        public abstract String getAny();

        public abstract boolean isEmpty();

        public abstract boolean isSingleton();

        public abstract LanguageSet merge(LanguageSet languageSet);

        public abstract LanguageSet restrictTo(LanguageSet languageSet);
    }

    /* loaded from: classes10.dex */
    public static final class SomeLanguages extends LanguageSet {
        private final Set<String> languages;

        @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Languages.LanguageSet
        public boolean contains(String str) {
            return this.languages.contains(str);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Languages.LanguageSet
        public String getAny() {
            return this.languages.iterator().next();
        }

        public Set<String> getLanguages() {
            return this.languages;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Languages.LanguageSet
        public boolean isEmpty() {
            return this.languages.isEmpty();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Languages.LanguageSet
        public boolean isSingleton() {
            if (this.languages.size() == 1) {
                return true;
            }
            return false;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Languages.LanguageSet
        public LanguageSet merge(LanguageSet languageSet) {
            if (languageSet == Languages.NO_LANGUAGES) {
                return this;
            }
            if (languageSet == Languages.ANY_LANGUAGE) {
                return languageSet;
            }
            HashSet hashSet = new HashSet(this.languages);
            Iterator<String> it = ((SomeLanguages) languageSet).languages.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next());
            }
            return LanguageSet.from(hashSet);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Languages.LanguageSet
        public LanguageSet restrictTo(LanguageSet languageSet) {
            if (languageSet == Languages.NO_LANGUAGES) {
                return languageSet;
            }
            if (languageSet == Languages.ANY_LANGUAGE) {
                return this;
            }
            SomeLanguages someLanguages = (SomeLanguages) languageSet;
            HashSet hashSet = new HashSet(Math.min(this.languages.size(), someLanguages.languages.size()));
            for (String str : this.languages) {
                if (someLanguages.languages.contains(str)) {
                    hashSet.add(str);
                }
            }
            return LanguageSet.from(hashSet);
        }

        public String toString() {
            return "Languages(" + this.languages.toString() + oIX0oI.I0Io.f4095I0Io;
        }

        private SomeLanguages(Set<String> set) {
            this.languages = Collections.unmodifiableSet(set);
        }
    }

    static {
        for (NameType nameType : NameType.values()) {
            LANGUAGES.put(nameType, getInstance(langResourceName(nameType)));
        }
        NO_LANGUAGES = new LanguageSet() { // from class: com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Languages.1
            @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Languages.LanguageSet
            public boolean contains(String str) {
                return false;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Languages.LanguageSet
            public String getAny() {
                throw new NoSuchElementException("Can't fetch any language from the empty language set.");
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Languages.LanguageSet
            public boolean isEmpty() {
                return true;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Languages.LanguageSet
            public boolean isSingleton() {
                return false;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Languages.LanguageSet
            public LanguageSet merge(LanguageSet languageSet) {
                return languageSet;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Languages.LanguageSet
            public LanguageSet restrictTo(LanguageSet languageSet) {
                return this;
            }

            public String toString() {
                return "NO_LANGUAGES";
            }
        };
        ANY_LANGUAGE = new LanguageSet() { // from class: com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Languages.2
            @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Languages.LanguageSet
            public boolean contains(String str) {
                return true;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Languages.LanguageSet
            public String getAny() {
                throw new NoSuchElementException("Can't fetch any language from the any language set.");
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Languages.LanguageSet
            public boolean isEmpty() {
                return false;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Languages.LanguageSet
            public boolean isSingleton() {
                return false;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Languages.LanguageSet
            public LanguageSet merge(LanguageSet languageSet) {
                return languageSet;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Languages.LanguageSet
            public LanguageSet restrictTo(LanguageSet languageSet) {
                return languageSet;
            }

            public String toString() {
                return "ANY_LANGUAGE";
            }
        };
    }

    private Languages(Set<String> set) {
        this.languages = set;
    }

    public static Languages getInstance(NameType nameType) {
        return LANGUAGES.get(nameType);
    }

    private static String langResourceName(NameType nameType) {
        return String.format("com/google/firebase/crashlytics/buildtools/reloc/org/apache/commons/codec/language/bm/%s_languages.txt", nameType.getName());
    }

    public Set<String> getLanguages() {
        return this.languages;
    }

    public static Languages getInstance(String str) {
        HashSet hashSet = new HashSet();
        InputStream resourceAsStream = Languages.class.getClassLoader().getResourceAsStream(str);
        if (resourceAsStream != null) {
            Scanner scanner = new Scanner(resourceAsStream, "UTF-8");
            while (true) {
                boolean z = false;
                while (scanner.hasNextLine()) {
                    try {
                        String trim = scanner.nextLine().trim();
                        if (z) {
                            if (trim.endsWith("*/")) {
                                break;
                            }
                        } else if (trim.startsWith("/*")) {
                            z = true;
                        } else if (trim.length() > 0) {
                            hashSet.add(trim);
                        }
                    } catch (Throwable th) {
                        scanner.close();
                        throw th;
                    }
                }
                scanner.close();
                return new Languages(Collections.unmodifiableSet(hashSet));
            }
        }
        throw new IllegalArgumentException("Unable to resolve required resource: " + str);
    }
}
