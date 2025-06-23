package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.input;

/* loaded from: classes10.dex */
public interface TailerListener {
    void fileNotFound();

    void fileRotated();

    void handle(Exception exc);

    void handle(String str);

    void init(Tailer tailer);
}
