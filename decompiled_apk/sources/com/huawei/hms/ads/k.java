package com.huawei.hms.ads;

import android.content.Context;
import android.util.Log;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.IHiAd;

/* loaded from: classes10.dex */
public class k {
    private static final String Code = "AdsInitialization";
    private static k I;
    private static final Object V = new Object();
    private Context B;
    private RequestOptions C;
    private IHiAd Z;

    public static k Code() {
        k kVar;
        synchronized (V) {
            try {
                if (I == null) {
                    I = new k();
                }
                kVar = I;
            } catch (Throwable th) {
                throw th;
            }
        }
        return kVar;
    }

    private boolean S() {
        if (this.Z != null) {
            return true;
        }
        Log.i(Code, "HwMobileAds.initialize() must be called prior");
        return false;
    }

    public boolean B() {
        IHiAd iHiAd = this.Z;
        if (iHiAd == null) {
            return true;
        }
        return iHiAd.isAppInstalledNotify();
    }

    public int C() {
        IHiAd iHiAd = this.Z;
        if (iHiAd == null) {
            return 0;
        }
        return iHiAd.getAppActivateStyle();
    }

    public RequestOptions I() {
        if (S()) {
            return this.Z.getRequestConfiguration();
        }
        if (this.C == null) {
            this.C = new RequestOptions.Builder().build();
        }
        return this.C;
    }

    public String V() {
        return "13.4.72.300";
    }

    public Context Z() {
        return this.B;
    }

    public void Code(float f) {
        if (f < 0.0f || f > 1.0f) {
            Log.i(Code, "volume must be a value between 0 and 1.");
        } else if (S()) {
            this.Z.setAppVolume(f);
        }
    }

    public void V(int i) {
        IHiAd iHiAd = this.Z;
        if (iHiAd == null) {
            return;
        }
        iHiAd.setAppActivateStyle(i);
    }

    public void Code(int i) {
        IHiAd iHiAd = this.Z;
        if (iHiAd == null) {
            return;
        }
        iHiAd.setBrand(i);
    }

    public void V(boolean z) {
        IHiAd iHiAd = this.Z;
        if (iHiAd == null) {
            return;
        }
        iHiAd.setAppInstalledNotify(z);
    }

    public void Code(Context context) {
        Code(context, null);
    }

    public void Code(Context context, String str) {
        if (this.Z != null) {
            return;
        }
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null.");
        }
        synchronized (V) {
            try {
                this.B = context.getApplicationContext();
                if (this.Z == null) {
                    IHiAd hiAd = HiAd.getInstance(context);
                    this.Z = hiAd;
                    hiAd.initLog(true, 3);
                    RequestOptions requestOptions = this.C;
                    if (requestOptions != null) {
                        this.Z.setRequestConfiguration(requestOptions);
                    }
                    this.Z.enableUserInfo(true);
                    this.Z.setApplicationCode(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void Code(InformationController informationController) {
        IHiAd iHiAd = this.Z;
        if (iHiAd == null) {
            return;
        }
        iHiAd.setInfoController(informationController);
    }

    public void Code(RequestOptions requestOptions) {
        if (S()) {
            this.Z.setRequestConfiguration(requestOptions);
        } else {
            this.C = requestOptions;
        }
    }

    public void Code(String str) {
        IHiAd iHiAd = this.Z;
        if (iHiAd == null) {
            return;
        }
        iHiAd.setConsent(str);
    }

    public void Code(boolean z) {
        if (S()) {
            this.Z.setAppMuted(z);
        }
    }
}
