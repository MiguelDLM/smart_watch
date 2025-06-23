package com.baidu.navisdk.ui.routeguide.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.l0;

/* loaded from: classes8.dex */
public class i {
    private static i q;
    private String d;
    private String e;
    private int m;
    private int n;
    private boolean p;

    /* renamed from: a, reason: collision with root package name */
    private boolean f8946a = false;
    private boolean b = false;
    private Bundle c = null;
    private Bitmap f = null;
    private Bitmap g = null;
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int o = 0;

    private Bundle c(String str, boolean z, int i, int i2, Bundle bundle) {
        String str2;
        String str3;
        int i3;
        int i4;
        int i5;
        String str4;
        String str5;
        boolean z2;
        String str6;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "getData: " + str + ", " + z + ", " + bundle);
        }
        if (!RouteGuideParams.RasterType.GRID.equals(str) && !RouteGuideParams.RasterType.DIRECT_BOARD.equals(str)) {
            return null;
        }
        int i6 = bundle.getInt(RouteGuideParams.RGKey.ExpandMap.AddDistance, 0);
        String string = bundle.getString(RouteGuideParams.RGKey.ExpandMap.BgName);
        String string2 = bundle.getString(RouteGuideParams.RGKey.ExpandMap.ArrowName);
        String string3 = bundle.getString("road_name");
        if (!bundle.containsKey("icon_name")) {
            str2 = RouteGuideParams.RGKey.ExpandMap.ArrowName;
            str3 = "road_name";
            i3 = -1;
        } else {
            String string4 = bundle.getString("icon_name");
            if (l0.c(string4)) {
                str3 = "road_name";
                i3 = -1;
            } else {
                this.p = true;
                str3 = "road_name";
                i3 = a0.I().e(string4);
            }
            StringBuilder sb = new StringBuilder();
            str2 = RouteGuideParams.RGKey.ExpandMap.ArrowName;
            sb.append("RasterRoadMap.getData() iconname=");
            sb.append(string4);
            sb.append(", resid=");
            sb.append(i3);
            LogUtil.e("RouteGuide", sb.toString());
        }
        if (!z) {
            this.h = i6;
            if (gVar.d()) {
                gVar.e("RouteGuide", "getData mCurrentAddDistance: " + this.h);
            }
        }
        int i7 = bundle.containsKey(RouteGuideParams.RGKey.ExpandMap.GridmapKind) ? bundle.getInt(RouteGuideParams.RGKey.ExpandMap.GridmapKind) : 0;
        if (bundle.containsKey(RouteGuideParams.RGKey.ExpandMap.TagContent)) {
            i5 = i6;
            str4 = bundle.getString(RouteGuideParams.RGKey.ExpandMap.TagContent);
            i4 = i3;
        } else {
            i4 = i3;
            i5 = i6;
            str4 = null;
        }
        if (bundle.containsKey(RouteGuideParams.RGKey.ExpandMap.ForbidAnimation)) {
            str5 = RouteGuideParams.RGKey.ExpandMap.TagContent;
            z2 = bundle.getBoolean(RouteGuideParams.RGKey.ExpandMap.ForbidAnimation, false);
        } else {
            str5 = RouteGuideParams.RGKey.ExpandMap.TagContent;
            z2 = true;
        }
        if (!gVar.d()) {
            str6 = RouteGuideParams.RGKey.ExpandMap.ForbidAnimation;
        } else {
            StringBuilder sb2 = new StringBuilder();
            str6 = RouteGuideParams.RGKey.ExpandMap.ForbidAnimation;
            sb2.append("BG=");
            sb2.append(string);
            sb2.append("  AR=");
            sb2.append(string2);
            sb2.append("  RN=");
            sb2.append(string3);
            sb2.append("  TD=");
            sb2.append(i);
            sb2.append("  RD=");
            sb2.append(i);
            sb2.append(", gridmapKind=");
            sb2.append(i7);
            sb2.append(", TagContent=");
            sb2.append(str4);
            sb2.append(", forbidAnimation=");
            sb2.append(z2);
            gVar.e("RouteGuide", sb2.toString());
        }
        Bundle bundle2 = new Bundle();
        this.c = bundle2;
        bundle2.putString(RouteGuideParams.RGKey.ExpandMap.RasterType, str);
        this.c.putBoolean(RouteGuideParams.RGKey.ExpandMap.UpdateProgress, z);
        this.c.putString(RouteGuideParams.RGKey.ExpandMap.BgName, string);
        this.c.putString(str2, string2);
        this.c.putString(str3, string3);
        this.c.putInt(RouteGuideParams.RGKey.ExpandMap.TotalDist, i);
        this.c.putInt(RouteGuideParams.RGKey.ExpandMap.RemainDist, i2);
        this.c.putInt(RouteGuideParams.RGKey.ExpandMap.GridmapKind, i7);
        this.c.putString(str5, str4);
        this.c.putInt("resid", i4);
        this.c.putInt(RouteGuideParams.RGKey.ExpandMap.AddDistance, i5);
        this.c.putBoolean(str6, z2);
        this.c.putBoolean("remain_dist_hide", bundle.getBoolean("remain_dist_hide", false));
        if (gVar.d()) {
            gVar.e("RouteGuide", "getData mLastestData : " + this.c);
        }
        return this.c;
    }

    public static i s() {
        if (q == null) {
            q = new i();
        }
        return q;
    }

    public int a(int i) {
        if (i != 1) {
            if (i == 2) {
                return 4;
            }
            if (i != 4) {
                return i != 6 ? 0 : 3;
            }
            return 1;
        }
        return 2;
    }

    public Bundle b(String str, boolean z, int i, int i2, Bundle bundle) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "getGridData: " + str + ", " + z + ", " + bundle);
        }
        if (RouteGuideParams.RasterType.GRID.equals(str)) {
            return c(str, z, i, i2, bundle);
        }
        return null;
    }

    public int d() {
        return this.o;
    }

    public Bundle e() {
        return this.c;
    }

    public String f() {
        Bundle bundle = this.c;
        if (bundle != null) {
            return bundle.getString("road_name");
        }
        return "未知路";
    }

    public int g() {
        int h = h();
        int i = this.c.getInt(RouteGuideParams.RGKey.ExpandMap.TotalDist);
        if (h <= 0 || i <= 0) {
            return 100;
        }
        return ((i - h) * 100) / i;
    }

    public int h() {
        Bundle bundle = this.c;
        if (bundle != null) {
            return bundle.getInt(RouteGuideParams.RGKey.ExpandMap.RemainDist);
        }
        return 0;
    }

    public int i() {
        return this.h;
    }

    public int j() {
        return this.i;
    }

    public boolean k() {
        return this.f8946a;
    }

    public boolean l() {
        return this.p;
    }

    public boolean m() {
        if (this.f != null) {
            return true;
        }
        return false;
    }

    public boolean n() {
        return this.b;
    }

    public void o() {
        Bitmap bitmap;
        try {
            if (com.baidu.navisdk.k.f6861a && (bitmap = this.g) != null && !bitmap.isRecycled()) {
                this.g.recycle();
            }
            this.g = null;
        } catch (Exception unused) {
            this.g = null;
        }
    }

    public void p() {
        Bitmap bitmap;
        try {
            if (com.baidu.navisdk.k.f6861a && (bitmap = this.f) != null && !bitmap.isRecycled()) {
                this.f.recycle();
            }
            this.f = null;
        } catch (Exception unused) {
            this.f = null;
        }
    }

    public void q() {
        o();
        p();
        this.f8946a = false;
        this.b = false;
        Bundle bundle = this.c;
        if (bundle != null) {
            bundle.clear();
            this.c = null;
        }
        this.d = null;
        this.e = null;
    }

    public void r() {
        a(false);
        this.p = false;
    }

    public void a(String str) {
    }

    public boolean a() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "dingbbin canEnlargeViewHide() mLatestAddDistance is " + this.i + " mCurrentAddDistance is " + this.h);
        }
        return this.i == this.h;
    }

    public Bundle b(boolean z, Bundle bundle) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "getStreetViewData: " + bundle + "," + z);
        }
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        this.c = bundle2;
        bundle2.putString(RouteGuideParams.RGKey.ExpandMap.RasterType, RouteGuideParams.RasterType.STREET);
        this.c.putBoolean(RouteGuideParams.RGKey.ExpandMap.UpdateProgress, z);
        if (bundle.containsKey("road_name")) {
            this.c.putString("road_name", b(bundle.getString("road_name")));
        }
        if (bundle.containsKey(RouteGuideParams.RGKey.ExpandMap.StreetUid)) {
            String string = bundle.getString(RouteGuideParams.RGKey.ExpandMap.StreetUid);
            this.c.putString(RouteGuideParams.RGKey.ExpandMap.StreetUid, string);
            a(string);
        }
        if (bundle.containsKey(RouteGuideParams.RGKey.ExpandMap.TotalDist)) {
            this.c.putInt(RouteGuideParams.RGKey.ExpandMap.TotalDist, bundle.getInt(RouteGuideParams.RGKey.ExpandMap.TotalDist));
        }
        if (bundle.containsKey(RouteGuideParams.RGKey.ExpandMap.RemainDist)) {
            this.c.putInt(RouteGuideParams.RGKey.ExpandMap.RemainDist, bundle.getInt(RouteGuideParams.RGKey.ExpandMap.RemainDist));
        }
        if (bundle.containsKey(RouteGuideParams.RGKey.ExpandMap.AddDistance) && !z) {
            this.h = bundle.getInt(RouteGuideParams.RGKey.ExpandMap.AddDistance);
            if (gVar.d()) {
                gVar.e("RouteGuide", "getStreetViewData mCurrentAddDistance: " + this.h);
            }
        }
        if (bundle.containsKey(RouteGuideParams.RGKey.ExpandMap.StreetImageType)) {
            this.c.putInt(RouteGuideParams.RGKey.ExpandMap.StreetImageType, bundle.getInt(RouteGuideParams.RGKey.ExpandMap.StreetImageType, -1));
        }
        if (bundle.containsKey(RouteGuideParams.RGKey.ExpandMap.StreetImageSource)) {
            this.c.putInt(RouteGuideParams.RGKey.ExpandMap.StreetImageSource, bundle.getInt(RouteGuideParams.RGKey.ExpandMap.StreetImageSource, -1));
        }
        this.c.putBoolean("remain_dist_hide", bundle.getBoolean("remain_dist_hide", false));
        if (!z) {
            byte[] byteArray = bundle.getByteArray(RouteGuideParams.RGKey.ExpandMap.ImageBytes);
            if (byteArray != null && byteArray.length > 0) {
                LogUtil.e("RouteGuide", "getStreetViewData BG Image Buf is not Null!");
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                    this.f = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
                } catch (OutOfMemoryError unused) {
                    this.f = null;
                }
            } else {
                LogUtil.e("RouteGuide", "getStreetViewData BG Image Buf is Null!");
            }
        }
        return this.c;
    }

    public void a(Bundle bundle) {
        if (bundle == null || !bundle.containsKey(RouteGuideParams.RGKey.ExpandMap.AddDistance)) {
            return;
        }
        this.i = bundle.getInt(RouteGuideParams.RGKey.ExpandMap.AddDistance);
    }

    public Bundle a(String str, boolean z, int i, int i2, Bundle bundle) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "getDirectBoardData: " + str + ", " + z + ", " + bundle);
        }
        if (RouteGuideParams.RasterType.DIRECT_BOARD.equals(str)) {
            return c(str, z, i, i2, bundle);
        }
        return null;
    }

    public Bundle a(boolean z, Bundle bundle) {
        int i;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "getCommonWindowData: " + bundle + "," + z);
        }
        if (bundle == null) {
            LogUtil.e("RouteGuide", "!# getVectorMapData param bundle is null");
            return null;
        }
        if (bundle.containsKey("icon_name")) {
            String string = bundle.getString("icon_name");
            i = a0.I().e(string);
            LogUtil.e("RouteGuide", "RasterRoadMap.getVectorMapData() iconname=" + string + ", resid=" + i);
        } else {
            i = -1;
        }
        Bundle bundle2 = new Bundle();
        this.c = bundle2;
        bundle2.putString(RouteGuideParams.RGKey.ExpandMap.RasterType, RouteGuideParams.RasterType.COMMON_WINDOW);
        this.c.putBoolean(RouteGuideParams.RGKey.ExpandMap.UpdateProgress, z);
        if (bundle.containsKey("road_name")) {
            this.c.putString("road_name", bundle.getString("road_name"));
        }
        if (bundle.containsKey(RouteGuideParams.RGKey.ExpandMap.TotalDist)) {
            this.c.putInt(RouteGuideParams.RGKey.ExpandMap.TotalDist, bundle.getInt(RouteGuideParams.RGKey.ExpandMap.TotalDist));
        }
        if (bundle.containsKey(RouteGuideParams.RGKey.ExpandMap.RemainDist)) {
            this.c.putInt(RouteGuideParams.RGKey.ExpandMap.RemainDist, bundle.getInt(RouteGuideParams.RGKey.ExpandMap.RemainDist));
        }
        if (bundle.containsKey(RouteGuideParams.RGKey.ExpandMap.AddDistance) && !z) {
            this.h = bundle.getInt(RouteGuideParams.RGKey.ExpandMap.AddDistance);
        }
        if (!z && LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "commonwindow show, getCommonWindowData setCurrentAddDist " + this.h);
        }
        this.c.putInt("resid", i);
        if (bundle.containsKey(RouteGuideParams.RGKey.ExpandMap.REPLACE_TEXT)) {
            this.c.putString(RouteGuideParams.RGKey.ExpandMap.REPLACE_TEXT, bundle.getString(RouteGuideParams.RGKey.ExpandMap.REPLACE_TEXT));
        }
        this.c.putBoolean("remain_dist_hide", bundle.getBoolean("remain_dist_hide", false));
        if (bundle.containsKey(RouteGuideParams.RGKey.ExpandMap.REPLACE_ARROW_MAP)) {
            String string2 = bundle.getString(RouteGuideParams.RGKey.ExpandMap.REPLACE_ARROW_MAP);
            this.c.putString(RouteGuideParams.RGKey.ExpandMap.REPLACE_ARROW_MAP, string2);
            if (!TextUtils.isEmpty(string2)) {
                int e = a0.I().e(string2);
                LogUtil.e("RouteGuide", "arrowMapIconName=" + string2 + ", arrowMapResId=" + e);
                this.c.putInt(RouteGuideParams.RGKey.ExpandMap.REPLACE_ARROW_MAP_RES_ID, e);
            }
        }
        return this.c;
    }

    public Bundle c(boolean z, Bundle bundle) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "getVectorMapData: " + bundle);
        }
        if (bundle == null) {
            LogUtil.e("RouteGuide", "!# getVectorMapData param bundle is null");
            return null;
        }
        int i = -1;
        if (bundle.containsKey("icon_name")) {
            String string = bundle.getString("icon_name");
            if (!l0.c(string)) {
                this.p = true;
                i = a0.I().e(string);
            }
            if (gVar.d()) {
                LogUtil.e("RouteGuide", "RasterRoadMap.getVectorMapData() iconname=" + string + ", resid=" + i);
            }
        }
        Bundle bundle2 = new Bundle();
        this.c = bundle2;
        bundle2.putString(RouteGuideParams.RGKey.ExpandMap.RasterType, RouteGuideParams.RasterType.VECTOR);
        this.c.putBoolean(RouteGuideParams.RGKey.ExpandMap.UpdateProgress, z);
        if (bundle.containsKey("road_name")) {
            this.c.putString("road_name", bundle.getString("road_name"));
        }
        if (bundle.containsKey(RouteGuideParams.RGKey.ExpandMap.TotalDist)) {
            this.c.putInt(RouteGuideParams.RGKey.ExpandMap.TotalDist, bundle.getInt(RouteGuideParams.RGKey.ExpandMap.TotalDist));
        }
        if (bundle.containsKey(RouteGuideParams.RGKey.ExpandMap.RemainDist)) {
            this.c.putInt(RouteGuideParams.RGKey.ExpandMap.RemainDist, bundle.getInt(RouteGuideParams.RGKey.ExpandMap.RemainDist));
        }
        if (bundle.containsKey(RouteGuideParams.RGKey.ExpandMap.AddDistance) && !z) {
            this.h = bundle.getInt(RouteGuideParams.RGKey.ExpandMap.AddDistance);
            if (gVar.d()) {
                gVar.e("RouteGuide", "getVectorMapData mCurrentAddDistance: " + this.h);
            }
        }
        this.c.putInt("resid", i);
        this.c.putInt(RouteGuideParams.RGKey.ExpandMap.LastCarPosX, this.j);
        this.c.putInt(RouteGuideParams.RGKey.ExpandMap.LastCarPosY, this.k);
        this.c.putInt(RouteGuideParams.RGKey.ExpandMap.LastCarRotate, this.l);
        this.c.putInt(RouteGuideParams.RGKey.ExpandMap.CarPosX, bundle.getInt(RouteGuideParams.RGKey.ExpandMap.CarPosX, 0));
        this.c.putInt(RouteGuideParams.RGKey.ExpandMap.CarPosY, bundle.getInt(RouteGuideParams.RGKey.ExpandMap.CarPosY, 0));
        this.c.putInt(RouteGuideParams.RGKey.ExpandMap.CarRotate, bundle.getInt(RouteGuideParams.RGKey.ExpandMap.CarRotate, 0));
        this.c.putBoolean("remain_dist_hide", bundle.getBoolean("remain_dist_hide", false));
        if (!z) {
            this.c.putInt(RouteGuideParams.RGKey.ExpandMap.LastCarPosX, 0);
            this.c.putInt(RouteGuideParams.RGKey.ExpandMap.LastCarPosY, 0);
            this.c.putInt(RouteGuideParams.RGKey.ExpandMap.LastCarRotate, 0);
            int[] intArray = bundle.getIntArray(RouteGuideParams.RGKey.ExpandMap.ImageBytes);
            if (intArray != null) {
                this.m = bundle.getInt(RouteGuideParams.RGKey.ExpandMap.ImageWidth, 0);
                this.n = bundle.getInt(RouteGuideParams.RGKey.ExpandMap.ImageHeight, 0);
                if (!s().a(intArray, this.m, this.n)) {
                    LogUtil.e("RouteGuide", "!# setRasterImage fail");
                    return null;
                }
            } else {
                LogUtil.e("RouteGuide", "!# null vector image buffer!");
                return null;
            }
        }
        return this.c;
    }

    private String b(String str) {
        return ("地图上的点".equals(str) || "我的位置".equals(str) || "未知路".equals(str) || "无名路".equals(str)) ? "目的地" : str;
    }

    public void a(boolean z) {
        this.f8946a = z;
        this.b = z;
    }

    public void b(boolean z) {
        this.b = z;
    }

    public synchronized boolean a(String str, String str2) {
        boolean z;
        Bitmap bitmap;
        Bitmap bitmap2;
        try {
            if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                LogUtil.e("RouteGuide", "isRasterImageValid===>bgName=" + str + ", arrowName=" + str2);
            }
            if (!TextUtils.isEmpty(str) && !str.equals(this.d)) {
                if (com.baidu.navisdk.k.f6861a && (bitmap2 = this.f) != null && !bitmap2.isRecycled()) {
                    this.f.recycle();
                }
                this.f = null;
                this.d = str;
                byte[] rasterExpandMapImage = BNRouteGuider.getInstance().getRasterExpandMapImage(this.d, 1);
                if (rasterExpandMapImage != null && rasterExpandMapImage.length > 0) {
                    LogUtil.e("RouteGuide", "BG Image Buf is not Null!");
                    try {
                        this.f = BitmapFactory.decodeByteArray(rasterExpandMapImage, 0, rasterExpandMapImage.length);
                    } catch (OutOfMemoryError unused) {
                        this.f = null;
                    }
                }
            }
            if (!TextUtils.isEmpty(str2) && !str2.equals(this.e)) {
                if (com.baidu.navisdk.k.f6861a && (bitmap = this.g) != null && !bitmap.isRecycled()) {
                    this.g.recycle();
                }
                this.g = null;
                this.e = str2;
                byte[] rasterExpandMapImage2 = BNRouteGuider.getInstance().getRasterExpandMapImage(this.e, 2);
                if (rasterExpandMapImage2 != null && rasterExpandMapImage2.length > 0) {
                    LogUtil.e("RouteGuide", "Arrow Image Buf is not Null!");
                    try {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inPreferredConfig = Bitmap.Config.RGB_565;
                        this.g = BitmapFactory.decodeByteArray(rasterExpandMapImage2, 0, rasterExpandMapImage2.length, options);
                    } catch (OutOfMemoryError unused2) {
                        this.g = null;
                    }
                }
            }
            z = (this.g == null || this.f == null) ? false : true;
            if (z) {
                Bundle bundle = this.c;
                int i = bundle != null ? bundle.getInt(RouteGuideParams.RGKey.ExpandMap.AddDistance, 0) : 0;
                long elapsedRealtime = LogUtil.LOGGABLE ? SystemClock.elapsedRealtime() : 0L;
                boolean rasterExpandMapInfoStatus = BNRouteGuider.getInstance().setRasterExpandMapInfoStatus(i, 1);
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RouteGuide", "SetRasterExpandMapInfoStatus-> addDist=" + i + ", setStatusResult=" + rasterExpandMapInfoStatus + ", time=" + (SystemClock.elapsedRealtime() - elapsedRealtime));
                }
            } else {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.q.1.1", "1", null, null);
            }
        } catch (Throwable th) {
            throw th;
        }
        return z;
    }

    public Bitmap b() {
        return this.g;
    }

    public void b(int i) {
        this.o = i;
    }

    public synchronized boolean a(int[] iArr, int i, int i2) {
        if (iArr != null) {
            if (iArr.length > 0 && i > 0 && i2 > 0) {
                LogUtil.e("RouteGuide", "!# setRasterImage: image width=" + i + ", height=" + i2);
                p();
                try {
                    this.f = Bitmap.createBitmap(iArr, i, i2, Bitmap.Config.ARGB_8888);
                } catch (OutOfMemoryError unused) {
                    this.f = null;
                }
                if (this.f == null) {
                    LogUtil.e("RouteGuide", "!# setRasterImage: create bitmap failed!!!!");
                }
                o();
                return true;
            }
        }
        LogUtil.e("RouteGuide", "!# setRasterImage: null imageBuf!!");
        return false;
    }

    public Bitmap c() {
        return this.f;
    }
}
