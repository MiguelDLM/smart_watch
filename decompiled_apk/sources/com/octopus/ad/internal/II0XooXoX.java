package com.octopus.ad.internal;

import android.content.Context;
import android.text.TextUtils;
import x0.ooXIXxIX;
import x0.xI;
import x0.xII;

/* loaded from: classes11.dex */
public class II0XooXoX extends ooXIXxIX {

    /* renamed from: I0Io, reason: collision with root package name */
    public final String f18608I0Io;

    public II0XooXoX(String str) {
        super(false);
        this.f18608I0Io = str;
    }

    @Override // x0.ooXIXxIX
    public void II0XooXoX(xI xIVar) {
        if (xIVar != null && !TextUtils.isEmpty(xIVar.oxoX())) {
            try {
                Context x0xO0oo2 = xoIox.oIX0oI().x0xO0oo();
                if (!"{}".equals(xIVar.oxoX())) {
                    xII.ooOOo0oXI(x0xO0oo2, "responseBody", xIVar.oxoX());
                    o0IXXIx.xoIox.II0xO0().oxoX().execute(new o0IXXIx.II0xO0(x0xO0oo2));
                }
                xII.ooOOo0oXI(x0xO0oo2, "lastReqTime", Long.valueOf(o0IXXIx.x0XOIxOo.II0XooXoX()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // x0.ooXIXxIX
    public String Oxx0IOOO() {
        return this.f18608I0Io;
    }
}
