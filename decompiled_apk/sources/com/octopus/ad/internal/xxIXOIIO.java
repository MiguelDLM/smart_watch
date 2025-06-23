package com.octopus.ad.internal;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.octopus.ad.internal.oO;
import java.util.ArrayList;
import x0.OI0;
import x0.ooXIXxIX;
import x0.x0o;
import x0.xI;

/* loaded from: classes11.dex */
public class xxIXOIIO extends ooXIXxIX {

    /* renamed from: I0Io, reason: collision with root package name */
    public String f19089I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public ArrayList<String> f19090II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public II0xO0 f19091Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f19092X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public Context f19093XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public oO f19094oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public ooXIXxIX.II0xO0 f19095xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public String f19096xxIXOIIO;

    /* loaded from: classes11.dex */
    public class II0xO0 implements oO.I0Io {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public long f19098oIX0oI;

        public II0xO0() {
            this.f19098oIX0oI = 0L;
        }

        @Override // com.octopus.ad.internal.oO.I0Io
        public void a(boolean z) {
            if (z) {
                this.f19098oIX0oI += 250;
            } else {
                this.f19098oIX0oI = 0L;
            }
            if (this.f19098oIX0oI >= 500) {
                xxIXOIIO.this.oOoXoXO();
            }
        }
    }

    public xxIXOIIO(String str, String str2, oO oOVar, Context context, ArrayList<String> arrayList) {
        super(false);
        this.f19092X0o0xo = false;
        this.f19096xxIXOIIO = "";
        this.f19089I0Io = str2;
        this.f19094oxoX = oOVar;
        this.f19091Oxx0IOOO = new II0xO0();
        this.f19093XO = context;
        this.f19090II0XooXoX = arrayList;
        this.f19096xxIXOIIO = str;
    }

    public static xxIXOIIO xoIox(String str, String str2, oO oOVar, Context context, ArrayList<String> arrayList) {
        if (oOVar == null) {
            return null;
        }
        xxIXOIIO xxixoiio = new xxIXOIIO(str, str2, oOVar, context, arrayList);
        oOVar.oxoX(xxixoiio.f19091Oxx0IOOO);
        return xxixoiio;
    }

    @Override // x0.ooXIXxIX
    public void II0XooXoX(xI xIVar) {
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18703ooOOo0oXI, "Impression tracked.");
        ooXIXxIX.II0xO0 iI0xO0 = this.f19095xoIox;
        if (iI0xO0 != null && xIVar != null) {
            iI0xO0.oIX0oI(xIVar.X0o0xo(), xIVar.oxoX());
        }
    }

    public xxIXOIIO OOXIXo(ooXIXxIX.II0xO0 iI0xO0) {
        this.f19095xoIox = iI0xO0;
        return this;
    }

    @Override // x0.ooXIXxIX
    public String Oxx0IOOO() {
        View oIX0oI2 = this.f19094oxoX.oIX0oI();
        if (oIX0oI2 != null) {
            if (!TextUtils.isEmpty(this.f19096xxIXOIIO)) {
                this.f19089I0Io = this.f19089I0Io.replace("__REQUESTUUID__", this.f19096xxIXOIIO);
            }
            return x0o.oO(0, oIX0oI2, this.f19089I0Io);
        }
        return OI0.XO(this.f19089I0Io, "", "", "", "", "", "", "");
    }

    public final synchronized void oOoXoXO() {
        Context context;
        try {
            if (!this.f19092X0o0xo && (context = this.f19093XO) != null) {
                x0OxxIOxX.oxoX II0xO02 = x0OxxIOxX.oxoX.II0xO0(context.getApplicationContext());
                if (II0xO02.XO(this.f19093XO)) {
                    XO();
                    this.f19094oxoX.Oxx0IOOO(this.f19091Oxx0IOOO);
                    this.f19091Oxx0IOOO = null;
                } else {
                    II0xO02.oxoX(this.f19089I0Io, this.f19093XO);
                }
                this.f19092X0o0xo = true;
                this.f19090II0XooXoX.remove(this.f19089I0Io);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
