package com.huawei.hms.ads;

import android.content.Context;
import com.garmin.fit.X0xOO;
import com.goodix.ble.libcomx.ptmodel.PtStep;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.openalliance.ad.utils.d;

@GlobalApi
/* loaded from: classes10.dex */
public class BannerAdSize extends AdSize {

    @GlobalApi
    public static final BannerAdSize BANNER_SIZE_360_57 = new BannerAdSize(360, 57);

    @GlobalApi
    public static final BannerAdSize BANNER_SIZE_360_144 = new BannerAdSize(360, 144);

    @GlobalApi
    public static final BannerAdSize BANNER_SIZE_320_50 = new BannerAdSize(X0xOO.f13583O0o0, 50);

    @GlobalApi
    public static final BannerAdSize BANNER_SIZE_DYNAMIC = new BannerAdSize(-3, -4);

    @GlobalApi
    public static final BannerAdSize BANNER_SIZE_468_60 = new BannerAdSize(468, 60);

    @GlobalApi
    public static final BannerAdSize BANNER_SIZE_INVALID = new BannerAdSize(0, 0);

    @GlobalApi
    public static final BannerAdSize BANNER_SIZE_320_100 = new BannerAdSize(X0xOO.f13583O0o0, 100);

    @GlobalApi
    public static final BannerAdSize BANNER_SIZE_728_90 = new BannerAdSize(PtStep.EVT_JUDGE_UPDATED, 90);

    @GlobalApi
    public static final BannerAdSize BANNER_SIZE_300_250 = new BannerAdSize(300, 250);

    @GlobalApi
    public static final BannerAdSize BANNER_SIZE_SMART = new BannerAdSize(-1, -2);

    @GlobalApi
    public static final BannerAdSize BANNER_SIZE_160_600 = new BannerAdSize(160, 600);

    @GlobalApi
    public static final BannerAdSize BANNER_SIZE_ADVANCED = new BannerAdSize(-1, -5, 1);

    @GlobalApi
    public BannerAdSize(int i, int i2) {
        super(i, i2);
    }

    private static BannerAdSize Code(Context context, int i, int i2) {
        int Z = d.Z(context, i2);
        return Z == 0 ? BANNER_SIZE_INVALID : new BannerAdSize(i, d.Code(i, Z), 1);
    }

    private boolean V() {
        return this.C == 0 && this.S == 0;
    }

    @GlobalApi
    public static BannerAdSize getCurrentDirectionBannerSize(Context context, int i) {
        return Code(context, i, 0);
    }

    @GlobalApi
    public static BannerAdSize getLandscapeBannerSize(Context context, int i) {
        return Code(context, i, 2);
    }

    @GlobalApi
    public static BannerAdSize getPortraitBannerSize(Context context, int i) {
        return Code(context, i, 1);
    }

    @Override // com.huawei.hms.ads.AdSize
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.huawei.hms.ads.AdSize
    @GlobalApi
    public final int getHeight() {
        return super.getHeight();
    }

    @Override // com.huawei.hms.ads.AdSize
    @GlobalApi
    public final int getHeightPx(Context context) {
        return super.getHeightPx(context);
    }

    @Override // com.huawei.hms.ads.AdSize
    @GlobalApi
    public final int getWidth() {
        return super.getWidth();
    }

    @Override // com.huawei.hms.ads.AdSize
    @GlobalApi
    public final int getWidthPx(Context context) {
        return super.getWidthPx(context);
    }

    @Override // com.huawei.hms.ads.AdSize
    public final int hashCode() {
        return toString().hashCode();
    }

    @GlobalApi
    public final boolean isAutoHeightSize() {
        return this.S == -2;
    }

    @GlobalApi
    public final boolean isDynamicSize() {
        return this.C == -3 && this.S == -4;
    }

    @GlobalApi
    public final boolean isFullWidthSize() {
        return this.C == -1;
    }

    public final String toString() {
        if (isDynamicSize()) {
            return "fluid";
        }
        if (Code()) {
            return "smart_banner";
        }
        if (V()) {
            return "invalid";
        }
        return (isFullWidthSize() ? "FULL_WIDTH" : String.valueOf(this.C)) + "x" + (isAutoHeightSize() ? "AUTO_HEIGHT" : String.valueOf(this.S));
    }

    private BannerAdSize(int i, int i2, int i3) {
        super(i, i2);
        this.F = i3;
    }

    private boolean Code() {
        return this.C == -1 && this.S == -2;
    }
}
