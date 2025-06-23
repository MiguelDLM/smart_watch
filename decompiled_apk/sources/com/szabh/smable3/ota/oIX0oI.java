package com.szabh.smable3.ota;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import java.util.Arrays;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;
import kotlin.text.OxI;
import kotlin.text.StringsKt___StringsKt;

/* loaded from: classes13.dex */
public abstract class oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public int f26486I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public I0Io f26487II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public Context f26488oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @oOoXoXO
    public String f26489oxoX;

    public oIX0oI(@OOXIXo Context context, @OOXIXo I0Io callback) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(callback, "callback");
        this.f26488oIX0oI = context;
        this.f26487II0xO0 = callback;
        this.f26486I0Io = -1;
    }

    public static /* synthetic */ void oOoXoXO(oIX0oI oix0oi, int i, String str, double d, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                str = "";
            }
            if ((i2 & 4) != 0) {
                d = XIXIX.OOXIXo.f3760XO;
            }
            oix0oi.OOXIXo(i, str, d);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateOtaStatus");
    }

    public static /* synthetic */ void xoIox(oIX0oI oix0oi, String str, String str2, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                z = false;
            }
            oix0oi.xxIXOIIO(str, str2, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startOTA");
    }

    @OOXIXo
    public final Context I0Io() {
        return this.f26488oIX0oI;
    }

    public final void II0XooXoX(int i) {
        this.f26486I0Io = i;
    }

    @oOoXoXO
    public final String II0xO0() {
        return this.f26489oxoX;
    }

    public final void OOXIXo(int i, @OOXIXo String error, double d) {
        IIX0o.x0xO0oo(error, "error");
        this.f26486I0Io = i;
        if (i != 4 && i != 5) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("updateOtaStatus -> otaStatus:" + i);
        }
        this.f26487II0xO0.oIX0oI(d, i, error);
    }

    public final void Oxx0IOOO(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "<set-?>");
        this.f26488oIX0oI = context;
    }

    public void X0o0xo() {
    }

    public final void XO(@oOoXoXO String str) {
        this.f26489oxoX = str;
    }

    @OOXIXo
    public final String oIX0oI(@OOXIXo String address) {
        IIX0o.x0xO0oo(address, "address");
        long parseLong = Long.parseLong(OxI.IIOIX(address, ":", "", false, 4, null), kotlin.text.II0xO0.oIX0oI(16)) + 1;
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format("%012X", Arrays.copyOf(new Object[]{Long.valueOf(parseLong)}, 1));
        IIX0o.oO(format, "format(...)");
        return CollectionsKt___CollectionsKt.OoIXo(StringsKt___StringsKt.X0OXI(format, 2), ":", null, null, 0, null, null, 62, null);
    }

    public final int oxoX() {
        return this.f26486I0Io;
    }

    public void xxIXOIIO(@OOXIXo String filePath, @oOoXoXO String str, boolean z) {
        IIX0o.x0xO0oo(filePath, "filePath");
    }
}
