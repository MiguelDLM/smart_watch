package com.baidu.navisdk.behavrules;

/* loaded from: classes7.dex */
public enum d {
    SUCCESS("Success"),
    FALSE("False"),
    ERROR_STOP("error_stop"),
    ERROR_WAIT("error_wait"),
    ERROR_RESETVALUE("error_resetvalue"),
    FALSE_MATCH_ONCE("false_match_once");


    /* renamed from: a, reason: collision with root package name */
    private String f6645a;

    d(String str) {
        this.f6645a = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f6645a;
    }
}
