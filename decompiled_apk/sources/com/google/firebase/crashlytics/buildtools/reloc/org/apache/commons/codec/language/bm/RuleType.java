package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm;

/* loaded from: classes10.dex */
public enum RuleType {
    APPROX("approx"),
    EXACT("exact"),
    RULES("rules");

    private final String name;

    RuleType(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
