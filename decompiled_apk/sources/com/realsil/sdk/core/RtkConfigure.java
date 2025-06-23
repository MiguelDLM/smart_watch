package com.realsil.sdk.core;

import androidx.annotation.NonNull;
import com.szabh.smable3.entity.BleDeviceInfo;

/* loaded from: classes11.dex */
public final class RtkConfigure {

    /* renamed from: a, reason: collision with root package name */
    public boolean f19475a;
    public boolean b;
    public boolean c;
    public String d;
    public int e;

    /* loaded from: classes11.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public RtkConfigure f19476a = new RtkConfigure();

        public RtkConfigure build() {
            return this.f19476a;
        }

        public Builder debugEnabled(boolean z) {
            this.f19476a.setDebugEnabled(z);
            return this;
        }

        public Builder devModeEnabled(boolean z) {
            this.f19476a.setDevModeEnabled(z);
            return this;
        }

        public Builder globalLogLevel(int i) {
            this.f19476a.setGlobalLogLevel(i);
            return this;
        }

        public Builder logTag(@NonNull String str) {
            this.f19476a.setLogTag(str);
            return this;
        }

        public Builder printLog(boolean z) {
            this.f19476a.setPrintLog(z);
            return this;
        }
    }

    public int getGlobalLogLevel() {
        return this.e;
    }

    public String getLogTag() {
        return this.d;
    }

    public boolean isDebugEnabled() {
        return this.b;
    }

    public boolean isDevModeEnabled() {
        return this.f19475a;
    }

    public boolean isPrintLog() {
        return this.c;
    }

    public void setDebugEnabled(boolean z) {
        this.b = z;
    }

    public void setDevModeEnabled(boolean z) {
        this.f19475a = z;
    }

    public void setGlobalLogLevel(int i) {
        this.e = i;
    }

    public void setLogTag(String str) {
        this.d = str;
    }

    public void setPrintLog(boolean z) {
        this.c = z;
    }

    public String toString() {
        return "RtkConfigure{" + String.format("\n\tdebugEnabled=%b, printLog=%b, logTag=%s, globalLogLevel=0x%02X", Boolean.valueOf(this.b), Boolean.valueOf(this.c), this.d, Integer.valueOf(this.e)) + "\n}";
    }

    public RtkConfigure() {
        this.f19475a = true;
        this.b = true;
        this.c = true;
        this.d = BleDeviceInfo.PLATFORM_REALTEK;
        this.e = 1;
    }
}
