package com.sma.smartv3.ui.device;

import android.graphics.drawable.Drawable;
import com.goodix.ble.libcomx.util.HexStringBuilder;

/* loaded from: classes12.dex */
public final class x0XOIxOo {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.oOoXoXO
    public String f22917I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.oOoXoXO
    public String f22918II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Drawable f22919oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public boolean f22920oxoX;

    @OXOo.oOoXoXO
    public final String I0Io() {
        return this.f22917I0Io;
    }

    public final void II0XooXoX(@OXOo.oOoXoXO String str) {
        this.f22917I0Io = str;
    }

    @OXOo.oOoXoXO
    public final String II0xO0() {
        return this.f22918II0xO0;
    }

    public final void Oxx0IOOO(@OXOo.oOoXoXO String str) {
        this.f22918II0xO0 = str;
    }

    public final void X0o0xo(boolean z) {
        this.f22920oxoX = z;
    }

    public final void XO(@OXOo.oOoXoXO Drawable drawable) {
        this.f22919oIX0oI = drawable;
    }

    @OXOo.oOoXoXO
    public final Drawable oIX0oI() {
        return this.f22919oIX0oI;
    }

    public final boolean oxoX() {
        return this.f22920oxoX;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "AppInfo(icon=" + this.f22919oIX0oI + ", name=" + this.f22918II0xO0 + ", packageName=" + this.f22917I0Io + ", isEnabled=" + this.f22920oxoX + HexStringBuilder.COMMENT_END_CHAR;
    }
}
