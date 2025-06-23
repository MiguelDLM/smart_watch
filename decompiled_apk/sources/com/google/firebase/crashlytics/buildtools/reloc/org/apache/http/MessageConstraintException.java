package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http;

import java.nio.charset.CharacterCodingException;

/* loaded from: classes10.dex */
public class MessageConstraintException extends CharacterCodingException {
    private static final long serialVersionUID = 6077207720446368695L;
    private final String message;

    public MessageConstraintException(String str) {
        this.message = str;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }
}
