package com.kwad.components.offline.api.core.api;

/* loaded from: classes11.dex */
public interface ILogcat {
    void d(String str, String str2);

    void e(String str, String str2);

    void e(String str, String str2, Throwable th);

    void i(String str, String str2);

    void printStackTrace(Throwable th);

    void printStackTraceOnly(Throwable th);

    void v(String str, String str2);

    void v(String str, String str2, boolean z);

    void w(String str, String str2);

    void w(String str, String str2, boolean z);
}
