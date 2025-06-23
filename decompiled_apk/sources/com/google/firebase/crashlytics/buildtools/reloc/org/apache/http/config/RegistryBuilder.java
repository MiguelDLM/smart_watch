package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.config;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.Args;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes10.dex */
public final class RegistryBuilder<I> {
    private final Map<String, I> items = new HashMap();

    public static <I> RegistryBuilder<I> create() {
        return new RegistryBuilder<>();
    }

    public Registry<I> build() {
        return new Registry<>(this.items);
    }

    public RegistryBuilder<I> register(String str, I i) {
        Args.notEmpty(str, "ID");
        Args.notNull(i, "Item");
        this.items.put(str.toLowerCase(Locale.ROOT), i);
        return this;
    }

    public String toString() {
        return this.items.toString();
    }
}
