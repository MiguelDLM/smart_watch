package com.adp.sdk.utils;

import com.adp.sdk.dto.ADPConfig;
import com.kwad.sdk.api.KsCustomController;

public class e extends KsCustomController {

    /* renamed from: a  reason: collision with root package name */
    private boolean f740a;
    private ADPConfig b;

    public static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static e f741a = new e();
    }

    public static e a() {
        return b.f741a;
    }

    public boolean canReadInstalledPackages() {
        boolean z;
        ADPConfig aDPConfig = this.b;
        if (aDPConfig != null) {
            z = aDPConfig.getPermissionAppListBoolean();
        } else {
            z = true;
        }
        if (this.f740a && z) {
            return super.canReadInstalledPackages();
        }
        return false;
    }

    public boolean canReadLocation() {
        if (!this.f740a) {
            return false;
        }
        return super.canReadLocation();
    }

    public boolean canUseMacAddress() {
        if (!this.f740a) {
            return false;
        }
        return super.canUseMacAddress();
    }

    public boolean canUseNetworkState() {
        if (!this.f740a) {
            return false;
        }
        return super.canUseNetworkState();
    }

    public boolean canUseOaid() {
        if (!this.f740a) {
            return false;
        }
        return super.canUseOaid();
    }

    public boolean canUsePhoneState() {
        if (!this.f740a) {
            return false;
        }
        return super.canUsePhoneState();
    }

    public boolean canUseStoragePermission() {
        if (!this.f740a) {
            return false;
        }
        return super.canUseStoragePermission();
    }

    private e() {
    }

    public e a(boolean z, ADPConfig aDPConfig) {
        this.f740a = z;
        this.b = aDPConfig;
        return this;
    }
}
