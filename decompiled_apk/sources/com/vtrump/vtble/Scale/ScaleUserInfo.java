package com.vtrump.vtble.Scale;

import XIXIX.OOXIXo;

/* loaded from: classes13.dex */
public class ScaleUserInfo {

    /* renamed from: I0Io, reason: collision with root package name */
    public int f27356I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public double f27357II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f27358oIX0oI = 1;

    /* loaded from: classes13.dex */
    public enum Gender {
        MALE(0),
        FEMALE(1),
        ATHELETE_MALE(2),
        ATHELETE_FEMALE(3),
        MALE_BABY(4),
        FEMALE_BABY(5);

        public final int nativeInt;

        Gender(int i) {
            this.nativeInt = i;
        }
    }

    public int I0Io() {
        return this.f27356I0Io;
    }

    public ScaleUserInfo II0XooXoX(double d) {
        this.f27357II0xO0 = d;
        return this;
    }

    public double II0xO0() {
        return this.f27357II0xO0;
    }

    public boolean Oxx0IOOO() {
        return this.f27356I0Io % 2 == 0;
    }

    public boolean X0o0xo() {
        int i = this.f27356I0Io;
        return i == 2 || i == 3;
    }

    public boolean XO() {
        int i = this.f27356I0Io;
        if (i != 4 && i != 5) {
            return false;
        }
        double d = this.f27357II0xO0;
        return d >= OOXIXo.f3760XO && d <= 42.0d;
    }

    public ScaleUserInfo oIX0oI() {
        int i = this.f27356I0Io;
        int i2 = 1;
        if (i != 0) {
            if (i == 1) {
                this.f27356I0Io = 0;
            } else {
                i2 = 3;
                if (i != 2) {
                    if (i == 3) {
                        this.f27356I0Io = 2;
                    }
                }
            }
            return this;
        }
        this.f27356I0Io = i2;
        return this;
    }

    public int oxoX() {
        return this.f27358oIX0oI;
    }

    public ScaleUserInfo xoIox(int i) {
        this.f27358oIX0oI = i;
        return this;
    }

    public ScaleUserInfo xxIXOIIO(int i) {
        this.f27356I0Io = i;
        return this;
    }
}
