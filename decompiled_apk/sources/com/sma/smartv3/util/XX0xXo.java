package com.sma.smartv3.util;

import com.sma.smartv3.ble.ProductManager;

/* loaded from: classes12.dex */
public final class XX0xXo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final XX0xXo f24343oIX0oI = new XX0xXo();

    public final boolean I0Io(int i, @OXOo.OOXIXo String platform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(platform, "platform");
        if (Oxx0xo(platform)) {
            return ProductManager.f20544oIX0oI.o0oxo0oI(i);
        }
        if (ProductManager.IXX(ProductManager.f20544oIX0oI, i, false, 2, null)) {
            return true;
        }
        return false;
    }

    public final boolean II0XooXoX(int i) {
        return i == 7 || i == 8 || i == 12 || i == 13 || i == 20;
    }

    public final boolean II0xO0(int i) {
        return ProductManager.f20544oIX0oI.OxO(i);
    }

    public final boolean IXxxXO(int i) {
        return i == 7 || i == 8 || i == 10 || i == 47 || i == 12 || i == 13 || i == 20 || i == 21;
    }

    public final boolean OOXIXo(int i) {
        return i == 7 || i == 8 || i == 10 || i == 12 || i == 20;
    }

    public final boolean Oo(int i) {
        return i == 47 || i == 52;
    }

    public final boolean Oxx0IOOO(int i) {
        return i == 13 || i == 21;
    }

    public final boolean Oxx0xo(@OXOo.OOXIXo String platform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(platform, "platform");
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (!productManager.xxx00() && !productManager.o0Xo(platform)) {
            return false;
        }
        return true;
    }

    public final boolean X0o0xo(int i) {
        return i == 7 || i == 8 || i == 9 || i == 12 || i == 13 || i == 19 || i == 20 || i == 33 || i == 47 || i == 50;
    }

    public final boolean XO(int i) {
        return i == 47;
    }

    public final boolean oIX0oI(int i) {
        return i == 7 || i == 8 || i == 9 || i == 12 || i == 13 || i == 19 || i == 20 || i == 50;
    }

    public final boolean oO(int i) {
        return i == 10 || i == 17 || i == 28;
    }

    public final boolean oOoXoXO(int i) {
        return i == 7 || i == 10 || i == 20 || i == 28 || i == 12 || i == 13;
    }

    public final boolean ooOOo0oXI(int i) {
        return i == 7 || i == 8 || i == 10 || i == 17 || i == 20 || i == 28 || i == 70 || i == 81 || i == 12 || i == 13;
    }

    public final boolean oxoX(int i, @OXOo.OOXIXo String platform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(platform, "platform");
        if (i == 1) {
            return xxIXOIIO(i);
        }
        if (Oxx0xo(platform)) {
            return II0xO0(i);
        }
        return false;
    }

    public final boolean x0XOIxOo(int i) {
        return i == 7 || i == 8 || i == 12 || i == 20;
    }

    public final boolean x0xO0oo(int i) {
        if (i != 7 && i != 8 && i != 12 && i != 13 && i != 20 && i != 34 && i != 47 && i != 49) {
            switch (i) {
                case 16:
                case 17:
                case 18:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public final boolean xoIox(int i) {
        return i == 7 || i == 8 || i == 12 || i == 20 || i == 47;
    }

    public final boolean xxIXOIIO(int i) {
        return i == 10 || i == 13 || i == 17 || i == 28;
    }
}
