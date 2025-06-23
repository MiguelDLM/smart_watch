package com.univocity.parsers.common;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes13.dex */
public class xxIXOIIO implements oO {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public final oIX0oI<?> f27110II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final x0XOIxOo f27111II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int[] f27112Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public Map<String, Integer> f27113X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public Map<String, Integer> f27114XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final x0oox0.I0Io f27115oIX0oI;

    /* renamed from: I0Io, reason: collision with root package name */
    public boolean f27109I0Io = false;

    /* renamed from: oxoX, reason: collision with root package name */
    public int[] f27116oxoX = null;

    public xxIXOIIO(oIX0oI<?> oix0oi) {
        this.f27110II0XooXoX = oix0oi;
        this.f27115oIX0oI = oix0oi.f27066II0XooXoX;
        this.f27111II0xO0 = oix0oi.f27067II0xO0;
    }

    @Override // com.univocity.parsers.common.oO
    public int I0Io(Enum<?> r7) {
        int[] iArr = this.f27112Oxx0IOOO;
        if (iArr != null && iArr.length == 0) {
            return -1;
        }
        if (r7 == null) {
            if (X0o0xo() == null) {
                throw new IllegalArgumentException("Header name cannot be null.");
            }
            throw new IllegalArgumentException("Header name cannot be null. Use one of the available column names: " + Arrays.asList(X0o0xo()));
        }
        if (iArr == null) {
            String[] X0o0xo2 = X0o0xo();
            if (X0o0xo2 == null) {
                this.f27112Oxx0IOOO = new int[0];
                return -1;
            }
            Enum[] enumArr = (Enum[]) r7.getClass().getEnumConstants();
            int i = Integer.MIN_VALUE;
            for (int i2 = 0; i2 < enumArr.length; i2++) {
                if (i < enumArr[i2].ordinal()) {
                    i = enumArr[i2].ordinal();
                }
            }
            this.f27112Oxx0IOOO = new int[i + 1];
            for (Enum r3 : enumArr) {
                this.f27112Oxx0IOOO[r3.ordinal()] = I0Io.I0Io(X0o0xo2, r3.toString());
            }
        }
        return this.f27112Oxx0IOOO[r7.ordinal()];
    }

    @Override // com.univocity.parsers.common.oO
    public long II0XooXoX() {
        return this.f27115oIX0oI.I0Io();
    }

    @Override // com.univocity.parsers.common.oO
    public int II0xO0(String str) {
        Map<String, Integer> map = this.f27113X0o0xo;
        if (map != null && map.isEmpty()) {
            return -1;
        }
        if (str == null) {
            if (X0o0xo() == null) {
                throw new IllegalArgumentException("Header name cannot be null.");
            }
            throw new IllegalArgumentException("Header name cannot be null. Use one of the available column names: " + Arrays.asList(X0o0xo()));
        }
        if (this.f27113X0o0xo == null) {
            String[] X0o0xo2 = X0o0xo();
            if (X0o0xo2 == null) {
                this.f27113X0o0xo = Collections.emptyMap();
                this.f27114XO = Collections.emptyMap();
                return -1;
            }
            this.f27113X0o0xo = new HashMap(X0o0xo2.length);
            int[] x0XOIxOo2 = x0XOIxOo();
            boolean oOoXoXO2 = oOoXoXO();
            int i = 0;
            if (x0XOIxOo2 != null) {
                if (oOoXoXO2) {
                    while (i < x0XOIxOo2.length) {
                        this.f27113X0o0xo.put(X0o0xo2[x0XOIxOo2[i]], Integer.valueOf(i));
                        i++;
                    }
                } else {
                    while (i < x0XOIxOo2.length) {
                        this.f27113X0o0xo.put(X0o0xo2[i], Integer.valueOf(i));
                        i++;
                    }
                }
            } else {
                while (i < X0o0xo2.length) {
                    this.f27113X0o0xo.put(X0o0xo2[i], Integer.valueOf(i));
                    i++;
                }
            }
            this.f27114XO = new HashMap(X0o0xo2.length);
            for (Map.Entry<String, Integer> entry : this.f27113X0o0xo.entrySet()) {
                this.f27114XO.put(entry.getKey().trim().toLowerCase(), entry.getValue());
            }
        }
        Integer num = this.f27113X0o0xo.get(str);
        if (num == null && (num = this.f27114XO.get(str.trim().toLowerCase())) == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.univocity.parsers.common.oO
    public String OOXIXo() {
        return this.f27110II0XooXoX.oOoXoXO();
    }

    @Override // com.univocity.parsers.common.oO
    public long Oxx0IOOO() {
        return this.f27115oIX0oI.OOXIXo();
    }

    @Override // com.univocity.parsers.common.oO
    public String[] X0o0xo() {
        return this.f27111II0xO0.X0o0xo();
    }

    @Override // com.univocity.parsers.common.oO
    public int XO() {
        return this.f27111II0xO0.I0Io();
    }

    @Override // com.univocity.parsers.common.oO
    public boolean isStopped() {
        return this.f27109I0Io;
    }

    @Override // com.univocity.parsers.common.oO
    public void oIX0oI(long j) {
        this.f27115oIX0oI.oIX0oI(j);
    }

    @Override // com.univocity.parsers.common.oO
    public String oO() {
        char[] oxoX2 = this.f27111II0xO0.f27098Oxx0IOOO.oxoX();
        if (oxoX2 != null) {
            int length = this.f27111II0xO0.f27098Oxx0IOOO.length();
            if (length > oxoX2.length) {
                length = oxoX2.length;
            }
            if (length > 0) {
                return new String(oxoX2, 0, length);
            }
            return null;
        }
        return null;
    }

    @Override // com.univocity.parsers.common.oO
    public boolean oOoXoXO() {
        return this.f27111II0xO0.xxIXOIIO();
    }

    @Override // com.univocity.parsers.common.oO
    public char[] ooOOo0oXI() {
        return this.f27115oIX0oI.x0xO0oo();
    }

    @Override // com.univocity.parsers.common.oO
    public void stop() {
        this.f27109I0Io = true;
    }

    @Override // com.univocity.parsers.common.oO
    public int[] x0XOIxOo() {
        if (this.f27116oxoX == null) {
            this.f27116oxoX = this.f27111II0xO0.XO();
        }
        return this.f27116oxoX;
    }

    @Override // com.univocity.parsers.common.oO
    public String[] x0xO0oo() {
        return this.f27110II0XooXoX.ooOOo0oXI();
    }

    @Override // com.univocity.parsers.common.oO
    public long xoIox() {
        return this.f27111II0xO0.oxoX();
    }

    @Override // com.univocity.parsers.common.oO
    public Map<Long, String> xxIXOIIO() {
        return this.f27110II0XooXoX.xxIXOIIO();
    }
}
