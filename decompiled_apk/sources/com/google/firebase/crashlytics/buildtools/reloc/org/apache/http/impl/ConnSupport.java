package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.config.ConnectionConfig;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;

/* loaded from: classes10.dex */
public final class ConnSupport {
    public static CharsetDecoder createDecoder(ConnectionConfig connectionConfig) {
        if (connectionConfig == null) {
            return null;
        }
        Charset charset = connectionConfig.getCharset();
        CodingErrorAction malformedInputAction = connectionConfig.getMalformedInputAction();
        CodingErrorAction unmappableInputAction = connectionConfig.getUnmappableInputAction();
        if (charset == null) {
            return null;
        }
        CharsetDecoder newDecoder = charset.newDecoder();
        if (malformedInputAction == null) {
            malformedInputAction = CodingErrorAction.REPORT;
        }
        CharsetDecoder onMalformedInput = newDecoder.onMalformedInput(malformedInputAction);
        if (unmappableInputAction == null) {
            unmappableInputAction = CodingErrorAction.REPORT;
        }
        return onMalformedInput.onUnmappableCharacter(unmappableInputAction);
    }

    public static CharsetEncoder createEncoder(ConnectionConfig connectionConfig) {
        Charset charset;
        if (connectionConfig == null || (charset = connectionConfig.getCharset()) == null) {
            return null;
        }
        CodingErrorAction malformedInputAction = connectionConfig.getMalformedInputAction();
        CodingErrorAction unmappableInputAction = connectionConfig.getUnmappableInputAction();
        CharsetEncoder newEncoder = charset.newEncoder();
        if (malformedInputAction == null) {
            malformedInputAction = CodingErrorAction.REPORT;
        }
        CharsetEncoder onMalformedInput = newEncoder.onMalformedInput(malformedInputAction);
        if (unmappableInputAction == null) {
            unmappableInputAction = CodingErrorAction.REPORT;
        }
        return onMalformedInput.onUnmappableCharacter(unmappableInputAction);
    }
}
