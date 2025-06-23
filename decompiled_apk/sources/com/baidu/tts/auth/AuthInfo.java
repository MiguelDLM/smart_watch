package com.baidu.tts.auth;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.c3;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.m;
import com.baidu.tts.o;
import com.baidu.tts.w2;
import com.baidu.tts.x2;

/* loaded from: classes8.dex */
public class AuthInfo {

    /* renamed from: a, reason: collision with root package name */
    public w2 f10038a;
    public o.a b;
    public m.a c;
    public TtsError d;

    public int getLeftValidDays() {
        int i = this.c.f10133a;
        if (i >= 10000) {
            return i - 10000;
        }
        return 0;
    }

    public TtsError getMixTtsError() {
        TtsError ttsError;
        TtsError onlineTtsError = getOnlineTtsError();
        TtsError offlineTtsError = getOfflineTtsError();
        if (onlineTtsError != null && offlineTtsError != null) {
            ttsError = c3.a().a(x2.m0);
        } else if (onlineTtsError == null && offlineTtsError != null) {
            ttsError = c3.a().a(x2.O);
        } else if (onlineTtsError != null) {
            ttsError = c3.a().a(x2.d);
        } else {
            ttsError = null;
        }
        if (ttsError == null) {
            return this.d;
        }
        return ttsError;
    }

    public String getNotifyMessage() {
        m.a aVar = this.c;
        if (aVar.b()) {
            return "valid official";
        }
        int i = aVar.f10133a;
        if (i >= 10000) {
            return "valid temp";
        }
        switch (i) {
            case -10:
                return "temp license expired";
            case -9:
            default:
                return "not a valid result";
            case -8:
                return "license not exist or invalid license";
            case -7:
                return "platform unmatched";
            case -6:
                return "will expire after a month";
            case -5:
                return "official license expired";
            case -4:
                return "cuid unmatched";
            case -3:
                return "sign or appcode unmatched";
            case -2:
                return "package name unmatched";
        }
    }

    public m.a getOfflineResult() {
        return this.c;
    }

    public TtsError getOfflineTtsError() {
        m.a aVar = this.c;
        if (aVar != null) {
            return aVar.e;
        }
        return this.d;
    }

    public o.a getOnlineResult() {
        return this.b;
    }

    public TtsError getOnlineTtsError() {
        o.a aVar = this.b;
        if (aVar != null) {
            return aVar.d;
        }
        return this.d;
    }

    public w2 getTtsEnum() {
        return this.f10038a;
    }

    public TtsError getTtsError() {
        TtsError ttsError = this.d;
        if (ttsError == null) {
            int ordinal = this.f10038a.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        return null;
                    }
                    return getMixTtsError();
                }
                return this.c.e;
            }
            return this.b.d;
        }
        return ttsError;
    }

    public boolean isMixSuccess() {
        if (!isOnlineSuccess() && !isOfflineSuccess()) {
            return false;
        }
        return true;
    }

    public boolean isOfflineSuccess() {
        m.a aVar = this.c;
        if (aVar != null && aVar.b()) {
            return true;
        }
        return false;
    }

    public boolean isOnlineSuccess() {
        o.a aVar = this.b;
        if (aVar != null && aVar.a()) {
            return true;
        }
        return false;
    }

    public boolean isSuccess() {
        if (this.d == null) {
            w2 w2Var = this.f10038a;
            if (w2Var == null) {
                return false;
            }
            int ordinal = w2Var.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        return false;
                    }
                    return isMixSuccess();
                }
                return isOfflineSuccess();
            }
            return isOnlineSuccess();
        }
        LoggerProxy.d("AuthInfo", "cause=" + this.d.getThrowable().getMessage());
        return false;
    }

    public void setOfflineResult(m.a aVar) {
        this.c = aVar;
    }

    public void setOnlineResult(o.a aVar) {
        this.b = aVar;
    }

    public void setTtsEnum(w2 w2Var) {
        this.f10038a = w2Var;
    }

    public void setTtsError(TtsError ttsError) {
        this.d = ttsError;
    }
}
