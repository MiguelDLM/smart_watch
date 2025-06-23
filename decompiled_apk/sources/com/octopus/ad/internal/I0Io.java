package com.octopus.ad.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.kuaishou.weapon.p0.t;
import com.octopus.ad.R;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;
import x0.x0o;

/* loaded from: classes11.dex */
public class I0Io {

    /* renamed from: Oo, reason: collision with root package name */
    public static HashSet<String> f18591Oo;

    /* renamed from: I0Io, reason: collision with root package name */
    public String f18592I0Io;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public String f18597X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public WeakReference<Context> f18599oIX0oI;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public String f18601oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public boolean f18602ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public String f18603oxoX;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public String f18605x0xO0oo;

    /* renamed from: II0xO0, reason: collision with root package name */
    public l f18594II0xO0 = l.PREFETCH;

    /* renamed from: XO, reason: collision with root package name */
    public int f18598XO = 3;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public boolean f18596Oxx0IOOO = false;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f18593II0XooXoX = -1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f18607xxIXOIIO = -1;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f18606xoIox = -1;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f18595OOXIXo = -1;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public boolean f18604x0XOIxOo = false;

    /* renamed from: oO, reason: collision with root package name */
    public boolean f18600oO = false;

    public I0Io(Context context, String str) {
        this.f18605x0xO0oo = "";
        this.f18599oIX0oI = new WeakReference<>(context);
        this.f18605x0xO0oo = str;
    }

    public void I0Io(l lVar) {
        this.f18594II0xO0 = lVar;
    }

    public void II0XooXoX(String str) {
        this.f18603oxoX = str;
    }

    public void II0xO0(int i) {
        this.f18598XO = i;
    }

    public int IIXOooo() {
        return this.f18595OOXIXo;
    }

    public int IXxxXO() {
        if (this.f18594II0xO0 == l.BANNER) {
            return this.f18593II0XooXoX;
        }
        return -1;
    }

    public String O0xOxO() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            if (XO().getResources().getConfiguration().orientation == 2) {
                str = IAdInterListener.AdReqParam.HEIGHT;
            } else {
                str = t.c;
            }
            this.f18601oOoXoXO = str;
            if (!x0o.II0XooXoX(str)) {
                jSONObject.put("mOrientation", this.f18601oOoXoXO);
            }
            if (this.f18593II0XooXoX > 0 && this.f18607xxIXOIIO > 0) {
                jSONObject.put(MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE, this.f18593II0XooXoX + "x" + this.f18607xxIXOIIO);
            }
            int IIXOooo2 = IIXOooo();
            int OxxIIOOXO2 = OxxIIOOXO();
            if (IIXOooo2 > 0 && OxxIIOOXO2 > 0) {
                l lVar = this.f18594II0xO0;
                l lVar2 = l.INTERSTITIAL;
                if (!lVar.equals(lVar2) && (this.f18593II0XooXoX < 0 || this.f18607xxIXOIIO < 0)) {
                    jSONObject.put("max_size", OxxIIOOXO2 + "x" + IIXOooo2);
                } else if (this.f18594II0xO0.equals(lVar2)) {
                    jSONObject.put(MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE, OxxIIOOXO2 + "x" + IIXOooo2);
                }
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18709xxIXOIIO, "Failed to encode adUnitParams, err = " + e.getMessage());
            return "";
        }
    }

    public void OOXIXo(int i) {
        this.f18607xxIXOIIO = i;
    }

    public void Oo(int i) {
        this.f18595OOXIXo = i;
    }

    public boolean OxI() {
        if (!x0o.II0XooXoX(xoIox.oIX0oI().OOXIXo()) && !x0o.II0XooXoX(this.f18592I0Io)) {
            return true;
        }
        com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.no_identification));
        return false;
    }

    public void Oxx0IOOO(int i) {
        this.f18593II0XooXoX = i;
    }

    public int Oxx0xo() {
        if (this.f18594II0xO0 == l.BANNER) {
            return this.f18607xxIXOIIO;
        }
        return -1;
    }

    public int OxxIIOOXO() {
        return this.f18606xoIox;
    }

    public void X0o0xo(boolean z) {
        this.f18604x0XOIxOo = z;
    }

    public Context XO() {
        if (this.f18599oIX0oI.get() != null) {
            return this.f18599oIX0oI.get();
        }
        return null;
    }

    public l o00() {
        return this.f18594II0xO0;
    }

    public boolean oI0IIXIo() {
        return this.f18602ooOOo0oXI;
    }

    public String oIX0oI() {
        return this.f18605x0xO0oo;
    }

    public void oO(int i) {
        this.f18606xoIox = i;
    }

    public void oOoXoXO(String str) {
        this.f18597X0o0xo = str;
    }

    public void ooOOo0oXI(boolean z) {
        this.f18596Oxx0IOOO = z;
    }

    public void oxoX(String str) {
        this.f18592I0Io = str;
    }

    public String x0XOIxOo() {
        return this.f18603oxoX;
    }

    public String x0xO0oo() {
        return this.f18597X0o0xo;
    }

    public String xoIox() {
        return this.f18592I0Io;
    }

    public boolean xoXoI() {
        return this.f18596Oxx0IOOO;
    }

    public void xxIXOIIO(boolean z) {
        this.f18602ooOOo0oXI = z;
    }
}
