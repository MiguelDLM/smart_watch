package com.univocity.parsers.common;

import com.univocity.parsers.common.OOXIXo;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes13.dex */
public abstract class X0o0xo<F extends OOXIXo> {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public String[] f27053OOXIXo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public F f27057oIX0oI;

    /* renamed from: xoIox, reason: collision with root package name */
    public IXxxXO f27059xoIox;

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f27052II0xO0 = null;

    /* renamed from: I0Io, reason: collision with root package name */
    public int f27050I0Io = 4096;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f27058oxoX = 512;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f27055X0o0xo = true;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f27056XO = true;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public boolean f27054Oxx0IOOO = true;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public OXIOoo0X0.xoIox f27051II0XooXoX = null;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public boolean f27060xxIXOIIO = true;

    public X0o0xo() {
        OxI(I0Io());
    }

    public abstract F I0Io();

    public OXIOoo0X0.OOXIXo<?> II0XooXoX() {
        return (OXIOoo0X0.OOXIXo) this.f27051II0XooXoX;
    }

    public final void II0xO0() {
        if (!this.f27060xxIXOIIO) {
            return;
        }
        Oxx0xo();
    }

    public void IIX0o(boolean z) {
        this.f27055X0o0xo = z;
    }

    public OXIOoo0X0.OOXIXo<Integer> IIXOooo(Integer... numArr) {
        return o00(new OXIOoo0X0.II0XooXoX(), numArr);
    }

    public final boolean IXxxXO() {
        return this.f27060xxIXOIIO;
    }

    public void O0xOxO(String... strArr) {
        if (strArr != null && strArr.length != 0) {
            this.f27053OOXIXo = strArr;
        } else {
            this.f27053OOXIXo = null;
        }
    }

    public boolean OOXIXo() {
        return this.f27054Oxx0IOOO;
    }

    public boolean Oo() {
        return this.f27055X0o0xo;
    }

    public void OxI(F f) {
        if (f != null) {
            this.f27057oIX0oI = f;
            return;
        }
        throw new IllegalArgumentException("Format cannot be null");
    }

    public OXIOoo0X0.xoIox Oxx0IOOO() {
        return this.f27051II0XooXoX;
    }

    public void Oxx0xo() {
    }

    public OXIOoo0X0.OOXIXo<String> OxxIIOOXO(String... strArr) {
        return o00(new OXIOoo0X0.xxIXOIIO(), strArr);
    }

    public void X0IIOO(boolean z) {
        this.f27054Oxx0IOOO = z;
    }

    public OXIOoo0X0.OOXIXo<String> X0o0xo(String... strArr) {
        return o00(new OXIOoo0X0.X0o0xo(), strArr);
    }

    public void XI0IXoo(boolean z) {
        this.f27056XO = z;
    }

    public void XIxXXX0x0(int i) {
        this.f27050I0Io = i;
    }

    public OXIOoo0X0.OOXIXo<Integer> XO(Integer... numArr) {
        return o00(new OXIOoo0X0.oxoX(), numArr);
    }

    public void XxX0x0xxx(String str) {
        this.f27052II0xO0 = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> OXIOoo0X0.OOXIXo<T> o00(OXIOoo0X0.OOXIXo<T> oOXIXo, T... tArr) {
        this.f27051II0XooXoX = (OXIOoo0X0.xoIox) oOXIXo;
        oOXIXo.oxoX(tArr);
        return oOXIXo;
    }

    public OXIOoo0X0.OOXIXo<Enum> oI0IIXIo(Enum... enumArr) {
        return o00(new OXIOoo0X0.Oxx0IOOO(), enumArr);
    }

    public void oIX0oI(Map<String, Object> map) {
        String oIX0oI2;
        map.put("Null value", this.f27052II0xO0);
        map.put("Maximum number of characters per column", Integer.valueOf(this.f27050I0Io));
        map.put("Maximum number of columns", Integer.valueOf(this.f27058oxoX));
        map.put("Skip empty lines", Boolean.valueOf(this.f27055X0o0xo));
        map.put("Ignore trailing whitespaces", Boolean.valueOf(this.f27056XO));
        map.put("Ignore leading whitespaces", Boolean.valueOf(this.f27054Oxx0IOOO));
        OXIOoo0X0.xoIox xoiox = this.f27051II0XooXoX;
        if (xoiox == null) {
            oIX0oI2 = "none";
        } else {
            oIX0oI2 = xoiox.oIX0oI();
        }
        map.put("Selected fields", oIX0oI2);
        map.put("Headers", Arrays.toString(this.f27053OOXIXo));
        map.put("Auto configuration enabled", Boolean.valueOf(this.f27060xxIXOIIO));
        map.put("RowProcessor error handler", this.f27059xoIox);
    }

    public String oO() {
        return this.f27052II0xO0;
    }

    public boolean oOoXoXO() {
        return this.f27056XO;
    }

    public int ooOOo0oXI() {
        return this.f27050I0Io;
    }

    public final void ooXIXxIX(boolean z) {
        X0IIOO(z);
        XI0IXoo(z);
    }

    public OXIOoo0X0.OOXIXo<Enum> oxoX(Enum... enumArr) {
        return o00(new OXIOoo0X0.I0Io(), enumArr);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(':');
        TreeMap treeMap = new TreeMap();
        oIX0oI(treeMap);
        for (Map.Entry entry : treeMap.entrySet()) {
            sb.append("\n\t");
            sb.append((String) entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
        }
        sb.append("Format configuration:\n\t");
        sb.append(xxIXOIIO().toString());
        return sb.toString();
    }

    public int x0XOIxOo() {
        return this.f27058oxoX;
    }

    public IXxxXO x0xO0oo() {
        IXxxXO iXxxXO = this.f27059xoIox;
        if (iXxxXO == null) {
            return ooOOo0oXI.f27084oIX0oI;
        }
        return iXxxXO;
    }

    public void xXxxox0I(IXxxXO iXxxXO) {
        this.f27059xoIox = iXxxXO;
    }

    public String[] xoIox() {
        return this.f27053OOXIXo;
    }

    public final void xoXoI(boolean z) {
        this.f27060xxIXOIIO = z;
    }

    public F xxIXOIIO() {
        return this.f27057oIX0oI;
    }

    public void xxX(int i) {
        this.f27058oxoX = i;
    }
}
