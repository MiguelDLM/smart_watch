package com.baidu.tts.aop.tts;

import XXO0.oIX0oI;
import com.baidu.tts.b3;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.x2;

/* loaded from: classes8.dex */
public class TtsError {

    /* renamed from: a, reason: collision with root package name */
    public Throwable f10036a;
    public int b;
    public String c;
    public b3 d;
    public String e;

    public int getCode() {
        return this.b;
    }

    public int getDetailCode() {
        b3 b3Var = this.d;
        if (b3Var != null) {
            return b3Var.f10042a.b;
        }
        return this.b;
    }

    public String getDetailMessage() {
        b3 b3Var = this.d;
        if (b3Var != null) {
            int code = getCode();
            String message = getMessage();
            Throwable throwable = getThrowable();
            x2 x2Var = b3Var.f10042a;
            String str = oIX0oI.I0Io.f4096II0xO0 + x2Var.b + oIX0oI.I0Io.f4095I0Io + x2Var.c;
            if (message != null) {
                str = str + "[(" + code + oIX0oI.I0Io.f4095I0Io + message + "]";
            } else if (code != 0) {
                str = str + "[(" + code + ")]";
            }
            if (throwable != null) {
                return str + "[(cause)" + throwable.toString() + "]";
            }
            return str;
        }
        String str2 = this.c;
        if (str2 == null) {
            return "TtsErrorFlyweight is null";
        }
        return str2;
    }

    public x2 getErrorEnum() {
        b3 b3Var = this.d;
        if (b3Var == null) {
            return null;
        }
        return b3Var.f10042a;
    }

    public String getMessage() {
        return this.c;
    }

    public String getSN() {
        return this.e;
    }

    public Throwable getThrowable() {
        return this.f10036a;
    }

    public b3 getTtsErrorFlyweight() {
        return this.d;
    }

    public void log() {
        LoggerProxy.d("TtsError", "ErrorSn: " + this.e + ", ErrorCode:" + getDetailCode() + ",ErrorMsg: " + getDetailMessage());
    }

    public void setCode(int i) {
        this.b = i;
    }

    public void setMessage(String str) {
        this.c = str;
    }

    public void setSN(String str) {
        this.e = str;
    }

    public void setThrowable(Throwable th) {
        this.f10036a = th;
    }

    public void setTtsErrorFlyweight(b3 b3Var) {
        this.d = b3Var;
    }
}
