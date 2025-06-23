package com.adp.sdk.utils;

import com.adp.sdk.dto.ADPConfig;
import com.kwad.sdk.api.KsCustomController;

/* loaded from: classes.dex */
public class e extends KsCustomController {

    /* renamed from: a, reason: collision with root package name */
    private boolean f4734a;
    private ADPConfig b;

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static e f4735a = new e();
    }

    public static e a() {
        return b.f4735a;
    }

    @Override // com.kwad.sdk.api.KsCustomController
    public boolean canReadInstalledPackages() {
        boolean z;
        ADPConfig aDPConfig = this.b;
        if (aDPConfig != null) {
            z = aDPConfig.getPermissionAppListBoolean();
        } else {
            z = true;
        }
        if (!this.f4734a || !z) {
            return false;
        }
        return super.canReadInstalledPackages();
    }

    @Override // com.kwad.sdk.api.KsCustomController
    public boolean canReadLocation() {
        if (!this.f4734a) {
            return false;
        }
        return super.canReadLocation();
    }

    @Override // com.kwad.sdk.api.KsCustomController
    public boolean canUseMacAddress() {
        if (!this.f4734a) {
            return false;
        }
        return super.canUseMacAddress();
    }

    @Override // com.kwad.sdk.api.KsCustomController
    public boolean canUseNetworkState() {
        if (!this.f4734a) {
            return false;
        }
        return super.canUseNetworkState();
    }

    @Override // com.kwad.sdk.api.KsCustomController
    public boolean canUseOaid() {
        if (!this.f4734a) {
            return false;
        }
        return super.canUseOaid();
    }

    @Override // com.kwad.sdk.api.KsCustomController
    public boolean canUsePhoneState() {
        if (!this.f4734a) {
            return false;
        }
        return super.canUsePhoneState();
    }

    @Override // com.kwad.sdk.api.KsCustomController
    public boolean canUseStoragePermission() {
        if (!this.f4734a) {
            return false;
        }
        return super.canUseStoragePermission();
    }

    private e() {
    }

    public e a(boolean z, ADPConfig aDPConfig) {
        this.f4734a = z;
        this.b = aDPConfig;
        return this;
    }
}
