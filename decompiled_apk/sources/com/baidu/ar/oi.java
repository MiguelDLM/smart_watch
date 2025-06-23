package com.baidu.ar;

import java.io.UnsupportedEncodingException;

/* loaded from: classes7.dex */
public class oi extends RuntimeException {
    private final UnsupportedEncodingException Jl;

    public oi(UnsupportedEncodingException unsupportedEncodingException) {
        if (unsupportedEncodingException == null) {
            throw new IllegalArgumentException();
        }
        this.Jl = unsupportedEncodingException;
    }
}
