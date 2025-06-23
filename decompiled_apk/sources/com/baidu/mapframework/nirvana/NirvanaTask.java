package com.baidu.mapframework.nirvana;

import org.apache.commons.text.ooOOo0oXI;

/* loaded from: classes7.dex */
public class NirvanaTask {

    /* renamed from: a, reason: collision with root package name */
    private String f6075a = "";
    private ExceptionCallback b;

    public void appendDescription(String str) {
        this.f6075a += " | " + str;
    }

    public String getDescription() {
        return this.f6075a;
    }

    public ExceptionCallback getExceptionCallback() {
        return this.b;
    }

    public void setExceptionCallback(ExceptionCallback exceptionCallback) {
        this.b = exceptionCallback;
    }

    public String toString() {
        return "NirvanaTask{description='" + this.f6075a + ooOOo0oXI.f33074oOoXoXO;
    }
}
