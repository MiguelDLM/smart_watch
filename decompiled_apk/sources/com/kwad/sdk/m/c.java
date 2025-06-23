package com.kwad.sdk.m;

import com.ksad.json.annotation.KsJson;
import java.util.List;

@KsJson
/* loaded from: classes11.dex */
public class c extends com.kwad.sdk.core.response.a.a {
    public List<String> aOr;
    public List<a> aOs;
    public List<com.kwad.sdk.m.a.a> aOt;
    public long funcSwitch;
    public long byteCount = 1000;
    public double sampleRate = 1.0d;

    @KsJson
    /* loaded from: classes11.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String aOu;
        public String aOv;
    }

    private boolean dX(int i) {
        if (Lk() || (this.funcSwitch & i) == 0) {
            return false;
        }
        return true;
    }

    public final boolean Lk() {
        if ((this.funcSwitch & 1) == 0) {
            return true;
        }
        return false;
    }

    public final boolean Ll() {
        return dX(4);
    }

    public final boolean Lm() {
        return dX(16);
    }
}
