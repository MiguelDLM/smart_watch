package com.kwad.components.ad.fullscreen.b;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.e.c;
import java.text.SimpleDateFormat;
import java.util.Date;

@KsJson
/* loaded from: classes11.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    private static SimpleDateFormat gL = new SimpleDateFormat("yyyy-MM-dd");
    public long gM;
    public int gN;

    public b() {
        this.gM = -1L;
        this.gN = -1;
    }

    public final boolean f(long j) {
        if (this.gM > 0 && j > 0) {
            try {
                return gL.format(new Date(this.gM)).equals(gL.format(new Date(j)));
            } catch (Exception e) {
                c.printStackTraceOnly(e);
            }
        }
        return false;
    }

    public final boolean w(int i) {
        int i2 = this.gN;
        if (i2 > 0 && i2 >= i) {
            return true;
        }
        return false;
    }

    public b(long j, int i) {
        this.gM = j;
        this.gN = 1;
    }
}
