package com.kwad.sdk.api;

import android.location.Location;
import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;
import java.util.List;

@KsAdSdkApi
@Keep
/* loaded from: classes11.dex */
public abstract class KsCustomController {
    @KsAdSdkApi
    @Keep
    public boolean canReadInstalledPackages() {
        return true;
    }

    @KsAdSdkApi
    @Keep
    public boolean canReadLocation() {
        return true;
    }

    @KsAdSdkApi
    @Keep
    public boolean canUseMacAddress() {
        return true;
    }

    @KsAdSdkApi
    @Keep
    public boolean canUseNetworkState() {
        return true;
    }

    @KsAdSdkApi
    @Keep
    public boolean canUseOaid() {
        return true;
    }

    @KsAdSdkApi
    @Keep
    public boolean canUsePhoneState() {
        return true;
    }

    @KsAdSdkApi
    @Keep
    public boolean canUseStoragePermission() {
        return true;
    }

    @KsAdSdkApi
    @Keep
    public String getAndroidId() {
        return "";
    }

    @KsAdSdkApi
    @Keep
    public String getImei() {
        return "";
    }

    @KsAdSdkApi
    @Keep
    public String[] getImeis() {
        return null;
    }

    @KsAdSdkApi
    @Keep
    public List<String> getInstalledPackages() {
        return null;
    }

    @KsAdSdkApi
    @Keep
    public Location getLocation() {
        return null;
    }

    @KsAdSdkApi
    @Keep
    public String getMacAddress() {
        return "";
    }

    @KsAdSdkApi
    @Keep
    public String getOaid() {
        return "";
    }
}
