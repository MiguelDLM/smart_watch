package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Rect;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.huawei.android.app.ActivityManagerEx;
import com.huawei.android.app.HwMultiWindowEx;
import com.huawei.android.content.pm.ApplicationInfoEx;
import com.huawei.android.fsm.HwFoldScreenManagerEx;
import com.huawei.android.view.DisplaySideRegionEx;
import com.huawei.android.view.WindowManagerEx;

/* loaded from: classes10.dex */
public class ct extends co {
    private static final String Code = "HwSysApiImpl";
    private static final byte[] I = new byte[0];
    private static cw V;

    private ct(Context context) {
    }

    private static cw V(Context context) {
        cw cwVar;
        synchronized (I) {
            try {
                if (V == null) {
                    V = new ct(context);
                }
                cwVar = V;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cwVar;
    }

    @Override // com.huawei.hms.ads.co, com.huawei.hms.ads.cw
    public String B() {
        return "com.huawei.android.os.BuildEx";
    }

    @Override // com.huawei.hms.ads.co, com.huawei.hms.ads.cw
    public String C() {
        return "com.huawei.android.os.SystemPropertiesEx";
    }

    @Override // com.huawei.hms.ads.co, com.huawei.hms.ads.cw
    public int Code(ApplicationInfo applicationInfo) {
        return new ApplicationInfoEx(applicationInfo).getHwFlags();
    }

    @Override // com.huawei.hms.ads.co, com.huawei.hms.ads.cw
    public String I() {
        return "com.huawei.android.net.wifi.WifiManagerCommonEx";
    }

    @Override // com.huawei.hms.ads.co, com.huawei.hms.ads.cw
    public int S() {
        return HwFoldScreenManagerEx.getDisplayMode();
    }

    @Override // com.huawei.hms.ads.co, com.huawei.hms.ads.cw
    public String Z() {
        return "com.huawei.android.os.BuildEx$VERSION";
    }

    @Override // com.huawei.hms.ads.co, com.huawei.hms.ads.cw
    public Rect Code(WindowInsets windowInsets) {
        DisplaySideRegionEx displaySideRegion = WindowManagerEx.LayoutParamsEx.getDisplaySideRegion(windowInsets);
        if (displaySideRegion != null) {
            return displaySideRegion.getSafeInsets();
        }
        return null;
    }

    @Override // com.huawei.hms.ads.co, com.huawei.hms.ads.cw
    public boolean V() {
        return HwFoldScreenManagerEx.isFoldable();
    }

    public static cw Code(Context context) {
        return V(context);
    }

    @Override // com.huawei.hms.ads.co, com.huawei.hms.ads.cw
    public void Code(WindowManager.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return;
        }
        new WindowManagerEx.LayoutParamsEx(layoutParams).setDisplaySideMode(1);
    }

    @Override // com.huawei.hms.ads.co, com.huawei.hms.ads.cw
    public boolean Code() {
        return HwMultiWindowEx.isInMultiWindowMode();
    }

    @Override // com.huawei.hms.ads.co, com.huawei.hms.ads.cw
    public boolean Code(Activity activity) {
        if (activity == null) {
            return false;
        }
        try {
            return ActivityManagerEx.getActivityWindowMode(activity) == 102;
        } catch (Throwable unused) {
            fb.I(Code, "isFreedomWindowMode error");
            return false;
        }
    }
}
