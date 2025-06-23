package com.realsil.sdk.core.bluetooth.connection.le;

import com.realsil.sdk.core.bluetooth.utils.BluetoothHelper;
import java.util.Locale;

/* loaded from: classes11.dex */
public final class GattConnParams {
    public static final int MAX_RECONNECT_TIMES = 2;

    /* renamed from: a, reason: collision with root package name */
    public String f19490a;
    public boolean b;
    public boolean c;
    public int d;
    public int e;
    public boolean f;

    /* loaded from: classes11.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f19491a;
        public boolean b;
        public boolean c;
        public int d = 1;
        public int e = 2;
        public boolean f;

        public Builder address(String str) {
            this.f19491a = str;
            return this;
        }

        public GattConnParams build() {
            return new GattConnParams(this.f19491a, this.b, this.c, this.d, this.e, this.f);
        }

        public Builder createBond(boolean z) {
            this.b = z;
            return this;
        }

        public Builder hid(boolean z) {
            this.c = z;
            return this;
        }

        public Builder reconnectTimes(int i) {
            this.d = i;
            return this;
        }

        public Builder refreshCache(boolean z) {
            this.f = z;
            return this;
        }

        public Builder transport(int i) {
            this.e = i;
            return this;
        }
    }

    public GattConnParams(String str, boolean z, boolean z2, int i, int i2, boolean z3) {
        this.f19490a = str;
        this.b = z;
        this.c = z2;
        this.d = i;
        this.e = i2;
        this.f = z3;
    }

    public String getAddress() {
        return this.f19490a;
    }

    public int getReconnectTimes() {
        return this.d;
    }

    public int getTransport() {
        return this.e;
    }

    public boolean isCreateBond() {
        return this.b;
    }

    public boolean isHid() {
        return this.c;
    }

    public boolean isRefreshCache() {
        return this.f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ConnectParams{\n");
        sb.append(String.format("\n\taddress=%s， isHid=%b", BluetoothHelper.formatAddress(this.f19490a, true), Boolean.valueOf(this.c)));
        sb.append(String.format("\n\tcreateBond=%b\n", Boolean.valueOf(this.b)));
        Locale locale = Locale.US;
        sb.append(String.format(locale, "\n\ttransport=%d", Integer.valueOf(this.e)));
        sb.append(String.format("\n\trefreshCache=%b\n", Boolean.valueOf(this.f)));
        sb.append(String.format(locale, "\n\treconnectTimes=%d", Integer.valueOf(this.d)));
        sb.append("\n}");
        return sb.toString();
    }
}
