package com.realsil.sdk.dfu.utils;

import android.hardware.usb.UsbDevice;
import com.realsil.sdk.core.bluetooth.utils.BluetoothHelper;
import java.util.Locale;
import java.util.UUID;
import org.apache.commons.text.ooOOo0oXI;

/* loaded from: classes11.dex */
public final class ConnectParams {
    public static final int BATTERY_VALUE_F1 = 1;
    public static final int BATTERY_VALUE_F2 = 2;

    /* renamed from: a, reason: collision with root package name */
    public String f19615a;
    public boolean b;
    public String c;
    public boolean d;
    public int e;
    public UUID f;
    public UUID g;
    public UsbDevice h;
    public int i;
    public boolean j;
    public int k;
    public boolean l;

    /* loaded from: classes11.dex */
    public static class Builder {
        public boolean b;
        public boolean d;
        public UsbDevice h;
        public boolean j;
        public boolean l;

        /* renamed from: a, reason: collision with root package name */
        public String f19616a = "";
        public String c = "";
        public int e = 1;
        public UUID f = UUID.fromString("0000d0ff-3c17-d293-8e48-14fe2e4da212");
        public UUID g = UUID.fromString("00006287-3c17-d293-8e48-14fe2e4da212");
        public int i = 2;
        public int k = 1;

        public Builder address(String str) {
            this.f19616a = str;
            return this;
        }

        public Builder batteryValueFormat(int i) {
            this.k = i;
            return this;
        }

        public ConnectParams build() {
            return new ConnectParams(this.f19616a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l);
        }

        public Builder createBond(boolean z) {
            this.b = z;
            return this;
        }

        public Builder dfuServiceUuid(UUID uuid) {
            this.g = uuid;
            return this;
        }

        public Builder hid(boolean z) {
            this.d = z;
            return this;
        }

        public Builder imageFeatureEnabled(boolean z) {
            this.l = z;
            return this;
        }

        public Builder localName(String str) {
            this.c = str;
            return this;
        }

        public Builder otaServiceUuid(UUID uuid) {
            this.f = uuid;
            return this;
        }

        public Builder reconnectTimes(int i) {
            this.e = i;
            return this;
        }

        public Builder refreshCache(boolean z) {
            this.j = z;
            return this;
        }

        public Builder usbDevice(UsbDevice usbDevice) {
            this.h = usbDevice;
            return this;
        }

        public Builder usbGattRxEndpointType(int i) {
            this.i = i;
            return this;
        }
    }

    public String getAddress() {
        return this.f19615a;
    }

    public int getBatteryValueFormat() {
        return this.k;
    }

    public UUID getDfuServiceUuid() {
        return this.g;
    }

    public String getLocalName() {
        return this.c;
    }

    public UUID getOtaServiceUuid() {
        return this.f;
    }

    public int getReconnectTimes() {
        return this.e;
    }

    public UsbDevice getUsbDevice() {
        return this.h;
    }

    public int getUsbGattRxEndpointType() {
        return this.i;
    }

    public boolean isCreateBond() {
        return this.b;
    }

    public boolean isHid() {
        return this.d;
    }

    public boolean isImageFeatureEnabled() {
        return this.l;
    }

    public boolean isRefreshCache() {
        return this.j;
    }

    public String toString() {
        return "ConnectParams{\n" + String.format("localName=%s, address=%s\n", this.c, BluetoothHelper.formatAddress(this.f19615a, true)) + String.format("isHid=%b\n", Boolean.valueOf(this.d)) + String.format("refreshCache=%b\n", Boolean.valueOf(this.j)) + String.format(Locale.US, "reconnectTimes=%d\n", Integer.valueOf(this.e)) + String.format("imageFeatureEnabled=%b\n", Boolean.valueOf(this.l)) + ooOOo0oXI.f33074oOoXoXO;
    }

    public ConnectParams(String str, boolean z, String str2, boolean z2, int i, UUID uuid, UUID uuid2, UsbDevice usbDevice, int i2, boolean z3, int i3, boolean z4) {
        this.e = 1;
        this.f = UUID.fromString("0000d0ff-3c17-d293-8e48-14fe2e4da212");
        UUID.fromString("00006287-3c17-d293-8e48-14fe2e4da212");
        this.f19615a = str;
        this.b = z;
        this.c = str2;
        this.d = z2;
        this.e = i;
        this.f = uuid;
        this.g = uuid2;
        this.h = usbDevice;
        this.i = i2;
        this.j = z3;
        this.k = i3;
        this.l = z4;
    }
}
