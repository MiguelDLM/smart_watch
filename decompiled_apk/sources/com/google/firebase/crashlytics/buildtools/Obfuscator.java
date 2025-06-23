package com.google.firebase.crashlytics.buildtools;

import com.sma.smartv3.ble.ProductManager;

/* loaded from: classes10.dex */
public class Obfuscator {
    private final Vendor vendor;
    private final String version;

    /* loaded from: classes10.dex */
    public enum Vendor {
        PROGUARD("proguard"),
        DEXGUARD("dexguard"),
        R8(ProductManager.f20465X0IIOO);

        private final String name;

        Vendor(String str) {
            this.name = str;
        }

        public String getName() {
            return this.name;
        }
    }

    public Obfuscator(Vendor vendor, String str) {
        this.vendor = vendor;
        this.version = str;
    }

    public Vendor getVendor() {
        return this.vendor;
    }

    public String getVersion() {
        return this.version;
    }
}
