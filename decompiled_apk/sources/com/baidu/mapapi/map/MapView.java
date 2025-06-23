package com.baidu.mapapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.common.util.DeviceId;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.logstatistics.SDKLogFactory;
import com.baidu.platform.comapi.map.MapSurfaceView;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes7.dex */
public final class MapView extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5829a = "MapView";
    private static String b;
    private static int c;
    private static int d;
    private static final SparseIntArray r;
    private int A;
    private int B;
    private boolean C;
    private MapSurfaceView e;
    private BaiduMap f;
    private ImageView g;
    private Bitmap h;
    private com.baidu.mapsdkplatform.comapi.map.ac i;
    private Point j;
    private Point k;
    private RelativeLayout l;
    private TextView m;
    private TextView n;
    private ImageView o;
    private Context p;
    private com.baidu.mapsdkplatform.comapi.c q;
    private int s;
    private boolean t;
    private boolean u;
    private float v;
    private int w;
    private int x;
    private int y;
    private int z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        r = sparseIntArray;
        sparseIntArray.append(3, 2000000);
        sparseIntArray.append(4, 1000000);
        sparseIntArray.append(5, 500000);
        sparseIntArray.append(6, 200000);
        sparseIntArray.append(7, 100000);
        sparseIntArray.append(8, 50000);
        sparseIntArray.append(9, 25000);
        sparseIntArray.append(10, 20000);
        sparseIntArray.append(11, 10000);
        sparseIntArray.append(12, 5000);
        sparseIntArray.append(13, 2000);
        sparseIntArray.append(14, 1000);
        sparseIntArray.append(15, 500);
        sparseIntArray.append(16, 200);
        sparseIntArray.append(17, 100);
        sparseIntArray.append(18, 50);
        sparseIntArray.append(19, 20);
        sparseIntArray.append(20, 10);
        sparseIntArray.append(21, 5);
        sparseIntArray.append(22, 2);
        sparseIntArray.append(23, 2);
        sparseIntArray.append(24, 2);
        sparseIntArray.append(25, 2);
        sparseIntArray.append(26, 2);
    }

    public MapView(Context context) {
        super(context);
        this.q = new s(this);
        this.s = LogoPosition.logoPostionleftBottom.ordinal();
        this.t = true;
        this.u = true;
        this.C = false;
        a(context, (BaiduMapOptions) null);
    }

    @Deprecated
    public static void setCustomMapStylePath(String str) {
        if (str != null && str.length() != 0) {
            if (new File(str).exists()) {
                b = str;
                return;
            }
            throw new RuntimeException("BDMapSDKException: please check whether the customMapStylePath file exits");
        }
        throw new RuntimeException("BDMapSDKException: customMapStylePath String is illegal");
    }

    @Deprecated
    public static void setIconCustom(int i) {
        d = i;
    }

    @Deprecated
    public static void setLoadCustomMapStyleFileMode(int i) {
        c = i;
    }

    @Deprecated
    public static void setMapCustomEnable(boolean z) {
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof MapViewLayoutParams) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            super.addView(view, layoutParams);
        }
    }

    public void cancelRenderMap() {
    }

    public final LogoPosition getLogoPosition() {
        int i = this.s;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return LogoPosition.logoPostionleftBottom;
                        }
                        return LogoPosition.logoPostionRightTop;
                    }
                    return LogoPosition.logoPostionRightBottom;
                }
                return LogoPosition.logoPostionCenterTop;
            }
            return LogoPosition.logoPostionCenterBottom;
        }
        return LogoPosition.logoPostionleftTop;
    }

    public final BaiduMap getMap() {
        BaiduMap baiduMap = this.f;
        baiduMap.f5790a = this;
        return baiduMap;
    }

    public final int getMapLevel() {
        return r.get(Math.round(this.e.getZoomLevel()));
    }

    public Point getScaleControlPosition() {
        return this.j;
    }

    public int getScaleControlViewHeight() {
        return this.A;
    }

    public int getScaleControlViewWidth() {
        return this.B;
    }

    public Point getZoomControlsPosition() {
        return this.k;
    }

    public boolean handleMultiTouch(float f, float f2, float f3, float f4) {
        return false;
    }

    public void handleTouchDown(float f, float f2) {
    }

    public boolean handleTouchMove(float f, float f2) {
        return false;
    }

    public boolean handleTouchUp(float f, float f2) {
        return false;
    }

    public boolean inRangeOfView(float f, float f2) {
        MapSurfaceView mapSurfaceView = this.e;
        if (mapSurfaceView != null && mapSurfaceView.inRangeOfView(f, f2)) {
            return true;
        }
        return false;
    }

    public boolean isShowScaleControl() {
        return this.u;
    }

    public void onCreate(Context context, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (this.j != null) {
            this.j = (Point) bundle.getParcelable("scalePosition");
        }
        if (this.k != null) {
            this.k = (Point) bundle.getParcelable("zoomPosition");
        }
        this.t = bundle.getBoolean("mZoomControlEnabled");
        this.u = bundle.getBoolean("mScaleControlEnabled");
        this.s = bundle.getInt("logoPosition");
        setPadding(bundle.getInt("paddingLeft"), bundle.getInt("paddingTop"), bundle.getInt("paddingRight"), bundle.getInt("paddingBottom"));
    }

    public final void onDestroy() {
        BaiduMap baiduMap = this.f;
        if (baiduMap != null) {
            baiduMap.c();
        }
        MapSurfaceView mapSurfaceView = this.e;
        if (mapSurfaceView != null) {
            mapSurfaceView.unInit();
        }
        Bitmap bitmap = this.h;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.h.recycle();
            this.h = null;
        }
        if (b != null) {
            b = null;
        }
        com.baidu.mapsdkplatform.comapi.a.a().b(this.q);
        this.i.b();
        BMapManager.destroy();
        com.baidu.mapsdkplatform.comapi.map.i.b();
        this.p = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        Point point;
        int measuredHeight;
        int measuredWidth;
        int measuredWidth2;
        int childCount = getChildCount();
        a(this.g);
        if (((getWidth() - this.w) - this.x) - this.g.getMeasuredWidth() > 0 && ((getHeight() - this.y) - this.z) - this.g.getMeasuredHeight() > 0) {
            f = ((getWidth() - this.w) - this.x) / getWidth();
            f2 = ((getHeight() - this.y) - this.z) / getHeight();
        } else {
            this.w = 0;
            this.x = 0;
            this.z = 0;
            this.y = 0;
            f = 1.0f;
            f2 = 1.0f;
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                MapSurfaceView mapSurfaceView = this.e;
                if (childAt == mapSurfaceView) {
                    mapSurfaceView.layout(0, 0, getWidth(), getHeight());
                } else {
                    ImageView imageView = this.g;
                    if (childAt == imageView) {
                        float f3 = f * 5.0f;
                        int i6 = (int) (this.w + f3);
                        int i7 = (int) (this.x + f3);
                        float f4 = 5.0f * f2;
                        int i8 = (int) (this.y + f4);
                        int i9 = (int) (this.z + f4);
                        int i10 = this.s;
                        if (i10 != 1) {
                            if (i10 != 2) {
                                if (i10 != 3) {
                                    if (i10 != 4) {
                                        if (i10 != 5) {
                                            measuredHeight = getHeight() - i9;
                                            measuredWidth = this.g.getMeasuredWidth() + i6;
                                            i8 = measuredHeight - this.g.getMeasuredHeight();
                                        } else {
                                            measuredHeight = i8 + imageView.getMeasuredHeight();
                                            measuredWidth = getWidth() - i7;
                                            measuredWidth2 = this.g.getMeasuredWidth();
                                        }
                                    } else {
                                        measuredHeight = getHeight() - i9;
                                        i8 = measuredHeight - this.g.getMeasuredHeight();
                                        measuredWidth = getWidth() - i7;
                                        measuredWidth2 = this.g.getMeasuredWidth();
                                    }
                                    i6 = measuredWidth - measuredWidth2;
                                } else {
                                    measuredHeight = i8 + imageView.getMeasuredHeight();
                                    i6 = (((getWidth() - this.g.getMeasuredWidth()) + this.w) - this.x) / 2;
                                    measuredWidth = (((getWidth() + this.g.getMeasuredWidth()) + this.w) - this.x) / 2;
                                }
                            } else {
                                measuredHeight = getHeight() - i9;
                                i8 = measuredHeight - this.g.getMeasuredHeight();
                                i6 = (((getWidth() - this.g.getMeasuredWidth()) + this.w) - this.x) / 2;
                                measuredWidth = (((getWidth() + this.g.getMeasuredWidth()) + this.w) - this.x) / 2;
                            }
                        } else {
                            measuredHeight = imageView.getMeasuredHeight() + i8;
                            measuredWidth = this.g.getMeasuredWidth() + i6;
                        }
                        this.g.layout(i6, i8, measuredWidth, measuredHeight);
                    } else {
                        com.baidu.mapsdkplatform.comapi.map.ac acVar = this.i;
                        if (childAt == acVar) {
                            if (acVar.a()) {
                                a(this.i);
                                Point point2 = this.k;
                                if (point2 == null) {
                                    int height = (int) (((getHeight() - 15) * f2) + this.y);
                                    int width = (int) (((getWidth() - 15) * f) + this.w);
                                    int measuredWidth3 = width - this.i.getMeasuredWidth();
                                    int measuredHeight2 = height - this.i.getMeasuredHeight();
                                    if (this.s == 4) {
                                        height -= this.g.getMeasuredHeight();
                                        measuredHeight2 -= this.g.getMeasuredHeight();
                                    }
                                    this.i.layout(measuredWidth3, measuredHeight2, width, height);
                                } else {
                                    com.baidu.mapsdkplatform.comapi.map.ac acVar2 = this.i;
                                    int i11 = point2.x;
                                    acVar2.layout(i11, point2.y, acVar2.getMeasuredWidth() + i11, this.k.y + this.i.getMeasuredHeight());
                                }
                            }
                        } else {
                            RelativeLayout relativeLayout = this.l;
                            if (childAt == relativeLayout) {
                                a(relativeLayout);
                                Point point3 = this.j;
                                if (point3 == null) {
                                    this.B = this.l.getMeasuredWidth();
                                    this.A = this.l.getMeasuredHeight();
                                    int i12 = (int) (this.w + (5.0f * f));
                                    int height2 = (getHeight() - ((int) ((this.z + (f2 * 5.0f)) + 56.0f))) - this.g.getMeasuredHeight();
                                    this.l.layout(i12, height2, this.B + i12, this.A + height2);
                                } else {
                                    RelativeLayout relativeLayout2 = this.l;
                                    int i13 = point3.x;
                                    relativeLayout2.layout(i13, point3.y, relativeLayout2.getMeasuredWidth() + i13, this.j.y + this.l.getMeasuredHeight());
                                }
                            } else {
                                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                                if (layoutParams instanceof MapViewLayoutParams) {
                                    MapViewLayoutParams mapViewLayoutParams = (MapViewLayoutParams) layoutParams;
                                    if (mapViewLayoutParams.c == MapViewLayoutParams.ELayoutMode.absoluteMode) {
                                        point = mapViewLayoutParams.b;
                                    } else {
                                        GeoPoint ll2mc = CoordUtil.ll2mc(mapViewLayoutParams.f5830a);
                                        if (this.e.getBaseMap() != null) {
                                            point = this.e.getBaseMap().a(ll2mc);
                                        } else {
                                            point = new Point();
                                        }
                                    }
                                    a(childAt);
                                    int measuredWidth4 = childAt.getMeasuredWidth();
                                    int measuredHeight3 = childAt.getMeasuredHeight();
                                    float f5 = mapViewLayoutParams.d;
                                    float f6 = mapViewLayoutParams.e;
                                    int i14 = ((int) (point.x - (f5 * measuredWidth4))) + mapViewLayoutParams.g;
                                    int i15 = ((int) (point.y - (f6 * measuredHeight3))) + mapViewLayoutParams.f;
                                    childAt.layout(i14, i15, measuredWidth4 + i14, measuredHeight3 + i15);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final void onPause() {
        this.e.onPause();
    }

    public final void onResume() {
        this.e.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        BaiduMap baiduMap;
        if (bundle != null && (baiduMap = this.f) != null) {
            bundle.putParcelable("mapstatus", baiduMap.getMapStatus());
            bundle.putBoolean("mZoomControlEnabled", this.t);
            bundle.putBoolean("mScaleControlEnabled", this.u);
            bundle.putInt("logoPosition", this.s);
            bundle.putInt("paddingLeft", this.w);
            bundle.putInt("paddingTop", this.y);
            bundle.putInt("paddingRight", this.x);
            bundle.putInt("paddingBottom", this.z);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (view == this.g) {
            return;
        }
        if (e()) {
            super.removeView(view);
        } else {
            com.baidu.platform.comapi.util.j.a(new x(this, view), 0L);
        }
    }

    public void renderMap() {
    }

    public void setCustomStyleFilePathAndMode(String str, int i) {
    }

    public final void setLogoPosition(LogoPosition logoPosition) {
        if (logoPosition == null) {
            this.s = LogoPosition.logoPostionleftBottom.ordinal();
        } else {
            this.s = logoPosition.ordinal();
        }
        requestLayout();
    }

    public void setMapCustomStyle(MapCustomStyleOptions mapCustomStyleOptions, CustomMapStyleCallBack customMapStyleCallBack) {
        if (mapCustomStyleOptions == null) {
            return;
        }
        String customMapStyleId = mapCustomStyleOptions.getCustomMapStyleId();
        if (customMapStyleId != null && !customMapStyleId.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.map.e.a().a(this.p, customMapStyleId, new t(this, customMapStyleCallBack, mapCustomStyleOptions));
            return;
        }
        String localCustomStyleFilePath = mapCustomStyleOptions.getLocalCustomStyleFilePath();
        if (localCustomStyleFilePath != null && !localCustomStyleFilePath.isEmpty()) {
            a(localCustomStyleFilePath, "");
            setMapCustomStyleEnable(true);
        }
    }

    public void setMapCustomStyleEnable(boolean z) {
        MapSurfaceView mapSurfaceView = this.e;
        if (mapSurfaceView != null && mapSurfaceView.getBaseMap() != null) {
            this.e.getBaseMap().q(z);
        }
    }

    public void setMapCustomStylePath(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(DeviceId.CUIDInfo.I_FIXED, "local");
        hashMap.put(ExifInterface.LONGITUDE_EAST, "1");
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "CS", "0", hashMap);
        a(str, "");
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.w = i;
        this.y = i2;
        this.x = i3;
        this.z = i4;
    }

    public void setScaleControlPosition(Point point) {
        int i;
        if (point != null && (i = point.x) >= 0 && point.y >= 0 && i <= getWidth() && point.y <= getHeight()) {
            this.j = point;
            requestLayout();
        }
    }

    public void setUpViewEventToMapView(MotionEvent motionEvent) {
        this.e.onTouchEvent(motionEvent);
    }

    public final void setZOrderMediaOverlay(boolean z) {
        MapSurfaceView mapSurfaceView = this.e;
        if (mapSurfaceView == null) {
            return;
        }
        mapSurfaceView.setZOrderMediaOverlay(z);
    }

    public void setZoomControlsPosition(Point point) {
        int i;
        if (point != null && (i = point.x) >= 0 && point.y >= 0 && i <= getWidth() && point.y <= getHeight()) {
            this.k = point;
            requestLayout();
        }
    }

    public void showScaleControl(boolean z) {
        int i;
        RelativeLayout relativeLayout = this.l;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        relativeLayout.setVisibility(i);
        this.u = z;
    }

    public void showZoomControls(boolean z) {
        int i;
        if (this.i.a()) {
            com.baidu.mapsdkplatform.comapi.map.ac acVar = this.i;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            acVar.setVisibility(i);
            this.t = z;
        }
    }

    private void b() {
        HashMap hashMap = new HashMap();
        if (c()) {
            hashMap.put(ExifInterface.GPS_DIRECTION_TRUE, "1");
        } else {
            hashMap.put(ExifInterface.GPS_DIRECTION_TRUE, "0");
        }
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "M", "0", hashMap);
    }

    private boolean c() {
        try {
            Class.forName("com.baidu.bmfmap.map.FlutterMapView");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        com.baidu.mapsdkplatform.comapi.map.ac acVar = this.i;
        if (acVar == null || !acVar.a() || this.e.getBaseMap() == null) {
            return;
        }
        float f = this.e.getBaseMap().E().f6196a;
        this.i.b(f > this.e.getBaseMap().b);
        this.i.a(f < this.e.getBaseMap().f6178a);
    }

    private boolean e() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    private void c(Context context) {
        this.l = new RelativeLayout(context);
        this.l.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.m = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        this.m.setTextColor(Color.parseColor("#FFFFFF"));
        this.m.setTextSize(2, 11.0f);
        TextView textView = this.m;
        textView.setTypeface(textView.getTypeface(), 1);
        this.m.setLayoutParams(layoutParams);
        this.m.setId(Integer.MAX_VALUE);
        this.l.addView(this.m);
        this.n = new TextView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.width = -2;
        layoutParams2.height = -2;
        layoutParams2.addRule(14);
        this.n.setTextColor(Color.parseColor("#000000"));
        this.n.setTextSize(2, 11.0f);
        this.n.setLayoutParams(layoutParams2);
        this.l.addView(this.n);
        this.o = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.width = -2;
        layoutParams3.height = -2;
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, this.m.getId());
        ImageView imageView = this.o;
        if (imageView != null) {
            imageView.setLayoutParams(layoutParams3);
            Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a("icon_scale.9.png", context);
            if (a2 != null) {
                byte[] ninePatchChunk = a2.getNinePatchChunk();
                if (NinePatch.isNinePatchChunk(ninePatchChunk)) {
                    this.o.setBackgroundDrawable(new NinePatchDrawable(a2, ninePatchChunk, new Rect(), null));
                }
            }
            this.l.addView(this.o);
        }
        addView(this.l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MapCustomStyleOptions mapCustomStyleOptions) {
        if (!TextUtils.isEmpty(str)) {
            a(str, "");
            setMapCustomStyleEnable(true);
            return;
        }
        String localCustomStyleFilePath = mapCustomStyleOptions.getLocalCustomStyleFilePath();
        if (TextUtils.isEmpty(localCustomStyleFilePath)) {
            return;
        }
        a(localCustomStyleFilePath, "");
        setMapCustomStyleEnable(true);
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.q = new s(this);
        this.s = LogoPosition.logoPostionleftBottom.ordinal();
        this.t = true;
        this.u = true;
        this.C = false;
        a(context, (BaiduMapOptions) null);
    }

    private void b(Context context) {
        com.baidu.mapsdkplatform.comapi.map.ac acVar = new com.baidu.mapsdkplatform.comapi.map.ac(context, false);
        this.i = acVar;
        if (acVar.a()) {
            this.i.b(new v(this));
            this.i.a(new w(this));
            addView(this.i);
        }
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions) {
        Point point;
        Point point2;
        LogoPosition logoPosition;
        this.p = context;
        com.baidu.mapsdkplatform.comapi.map.i.a();
        BMapManager.init();
        if (SysOSUtil.getAuthToken() != null) {
            com.baidu.platform.comapi.util.h.a(SysOSUtil.getAuthToken());
        } else {
            com.baidu.mapsdkplatform.comapi.a.a().a(this.q);
            com.baidu.mapsdkplatform.comapi.a.a().c();
        }
        a(context, baiduMapOptions, b, c);
        a(context);
        b(context);
        if (baiduMapOptions != null && !baiduMapOptions.h) {
            this.i.setVisibility(4);
        }
        c(context);
        if (baiduMapOptions != null && !baiduMapOptions.i) {
            this.l.setVisibility(4);
        }
        if (baiduMapOptions != null && (logoPosition = baiduMapOptions.j) != null) {
            this.s = logoPosition.ordinal();
        }
        if (baiduMapOptions != null && (point2 = baiduMapOptions.l) != null) {
            this.k = point2;
        }
        if (baiduMapOptions != null && (point = baiduMapOptions.k) != null) {
            this.j = point;
        }
        b();
    }

    public MapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.q = new s(this);
        this.s = LogoPosition.logoPostionleftBottom.ordinal();
        this.t = true;
        this.u = true;
        this.C = false;
        a(context, (BaiduMapOptions) null);
    }

    public MapView(Context context, BaiduMapOptions baiduMapOptions) {
        super(context);
        this.q = new s(this);
        this.s = LogoPosition.logoPostionleftBottom.ordinal();
        this.t = true;
        this.u = true;
        this.C = false;
        a(context, baiduMapOptions);
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions, String str, int i) {
        this.e = new MapSurfaceView(context);
        if (baiduMapOptions != null) {
            this.f = new BaiduMap(context, this.e, baiduMapOptions.a());
        } else {
            this.f = new BaiduMap(context, this.e, (com.baidu.mapsdkplatform.comapi.map.u) null);
        }
        addView(this.e);
        u uVar = new u(this);
        if (this.e.getBaseMap() != null) {
            this.e.getBaseMap().a(uVar);
        }
    }

    private void a(Context context) {
        String str;
        int densityDpi = SysOSUtil.getDensityDpi();
        if (densityDpi < 180) {
            str = "logo_l.png";
        } else {
            str = "logo_h.png";
        }
        Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(str, context);
        if (a2 == null) {
            return;
        }
        if (densityDpi > 480) {
            Matrix matrix = new Matrix();
            matrix.postScale(2.0f, 2.0f);
            this.h = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
        } else if (densityDpi > 320) {
            Matrix matrix2 = new Matrix();
            matrix2.postScale(1.5f, 1.5f);
            this.h = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix2, true);
        } else {
            this.h = a2;
        }
        if (this.h != null) {
            ImageView imageView = new ImageView(context);
            this.g = imageView;
            imageView.setImageBitmap(this.h);
            addView(this.g);
        }
    }

    private void a(View view) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        }
        int i = layoutParams.width;
        if (i > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        int i2 = layoutParams.height;
        if (i2 > 0) {
            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        } else {
            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(makeMeasureSpec, makeMeasureSpec2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        MapSurfaceView mapSurfaceView = this.e;
        if (mapSurfaceView == null || mapSurfaceView.getBaseMap() == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.e(f5829a, "customStyleFilePath is empty or null, please check!");
            return;
        }
        if (!str.endsWith(".sty")) {
            Log.e(f5829a, "customStyleFile format is incorrect , please check!");
        } else if (!new File(str).exists()) {
            Log.e(f5829a, "customStyleFile does not exist , please check!");
        } else {
            this.e.getBaseMap().b(str, str2);
        }
    }
}
