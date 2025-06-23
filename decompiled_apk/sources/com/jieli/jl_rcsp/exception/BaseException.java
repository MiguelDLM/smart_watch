package com.jieli.jl_rcsp.exception;

/* loaded from: classes.dex */
abstract class BaseException extends Exception {
    public BaseException() {
    }

    public abstract int getErrorCode();

    public BaseException(String str) {
        super(str);
    }
}
