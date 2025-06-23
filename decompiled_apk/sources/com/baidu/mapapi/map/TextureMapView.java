package com.baidu.mapapi.map;

import android.annotation.SuppressLint;
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
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.logstatistics.SDKLogFactory;
import com.baidu.platform.comapi.map.MapTextureView;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes7.dex */
public final class TextureMapView extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5866a = "TextureMapView";
    private static String i;
    private static int j;
    private static int k;
    private static final SparseArray<Integer> q;
    private int A;
    private int B;
    private boolean C;
    private MapTextureView b;
    private BaiduMap c;
    private ImageView d;
    private Bitmap e;
    private com.baidu.mapsdkplatform.comapi.map.ac f;
    private Point g;
    private Point h;
    private RelativeLayout l;
    private TextView m;
    private TextView n;
    private ImageView o;
    private Context p;
    private com.baidu.mapsdkplatform.comapi.c r;
    private float s;
    private int t;
    private boolean u;
    private boolean v;
    private int w;
    private int x;
    private int y;
    private int z;

    static {
        SparseArray<Integer> sparseArray = new SparseArray<>();
        q = sparseArray;
        sparseArray.append(3, 2000000);
        sparseArray.append(4, 1000000);
        sparseArray.append(5, 500000);
        sparseArray.append(6, 200000);
        sparseArray.append(7, 100000);
        sparseArray.append(8, 50000);
        sparseArray.append(9, 25000);
        sparseArray.append(10, 20000);
        sparseArray.append(11, 10000);
        sparseArray.append(12, 5000);
        sparseArray.append(13, 2000);
        sparseArray.append(14, 1000);
        sparseArray.append(15, 500);
        sparseArray.append(16, 200);
        sparseArray.append(17, 100);
        sparseArray.append(18, 50);
        sparseArray.append(19, 20);
        sparseArray.append(20, 10);
        sparseArray.append(21, 5);
        sparseArray.append(22, 2);
    }

    public TextureMapView(Context context) {
        super(context);
        this.r = new af(this);
        this.t = LogoPosition.logoPostionleftBottom.ordinal();
        this.u = true;
        this.v = true;
        this.C = false;
        a(context, (BaiduMapOptions) null);
    }

    @Deprecated
    public static void setCustomMapStylePath(String str) {
        if (str != null && str.length() != 0) {
            if (new File(str).exists()) {
                i = str;
                return;
            }
            throw new RuntimeException("BDMapSDKException: please check whether the customMapStylePath file exits");
        }
        throw new RuntimeException("BDMapSDKException: customMapStylePath String is illegal");
    }

    @Deprecated
    public static void setIconCustom(int i2) {
        k = i2;
    }

    @Deprecated
    public static void setLoadCustomMapStyleFileMode(int i2) {
        j = i2;
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

    public final LogoPosition getLogoPosition() {
        int i2 = this.t;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
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
        BaiduMap baiduMap = this.c;
        baiduMap.b = this;
        return baiduMap;
    }

    public final int getMapLevel() {
        return q.get((int) this.b.getBaseMap().E().f6196a).intValue();
    }

    public Point getScaleControlPosition() {
        return this.g;
    }

    public int getScaleControlViewHeight() {
        return this.B;
    }

    public int getScaleControlViewWidth() {
        return this.B;
    }

    public void onCreate(Context context, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (this.g != null) {
            this.g = (Point) bundle.getParcelable("scalePosition");
        }
        if (this.h != null) {
            this.h = (Point) bundle.getParcelable("zoomPosition");
        }
        this.u = bundle.getBoolean("mZoomControlEnabled");
        this.v = bundle.getBoolean("mScaleControlEnabled");
        this.t = bundle.getInt("logoPosition");
        setPadding(bundle.getInt("paddingLeft"), bundle.getInt("paddingTop"), bundle.getInt("paddingRight"), bundle.getInt("paddingBottom"));
    }

    public final void onDestroy() {
        if (this.p != null) {
            this.b.onDestroy();
        }
        Bitmap bitmap = this.e;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.e.recycle();
        }
        com.baidu.mapsdkplatform.comapi.a.a().b(this.r);
        this.f.b();
        BMapManager.destroy();
        com.baidu.mapsdkplatform.comapi.map.i.b();
        this.p = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"NewApi"})
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        float f;
        float f2;
        Point point;
        int measuredHeight;
        int measuredWidth;
        int measuredWidth2;
        int childCount = getChildCount();
        a(this.d);
        if (((getWidth() - this.w) - this.x) - this.d.getMeasuredWidth() > 0 && ((getHeight() - this.y) - this.z) - this.d.getMeasuredHeight() > 0) {
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
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt != null) {
                MapTextureView mapTextureView = this.b;
                if (childAt == mapTextureView) {
                    mapTextureView.layout(0, 0, getWidth(), getHeight());
                } else {
                    ImageView imageView = this.d;
                    if (childAt == imageView) {
                        float f3 = f * 5.0f;
                        int i7 = (int) (this.w + f3);
                        int i8 = (int) (this.x + f3);
                        float f4 = 5.0f * f2;
                        int i9 = (int) (this.y + f4);
                        int i10 = (int) (this.z + f4);
                        int i11 = this.t;
                        if (i11 != 1) {
                            if (i11 != 2) {
                                if (i11 != 3) {
                                    if (i11 != 4) {
                                        if (i11 != 5) {
                                            measuredHeight = getHeight() - i10;
                                            measuredWidth = this.d.getMeasuredWidth() + i7;
                                            i9 = measuredHeight - this.d.getMeasuredHeight();
                                        } else {
                                            measuredHeight = i9 + imageView.getMeasuredHeight();
                                            measuredWidth = getWidth() - i8;
                                            measuredWidth2 = this.d.getMeasuredWidth();
                                        }
                                    } else {
                                        measuredHeight = getHeight() - i10;
                                        i9 = measuredHeight - this.d.getMeasuredHeight();
                                        measuredWidth = getWidth() - i8;
                                        measuredWidth2 = this.d.getMeasuredWidth();
                                    }
                                    i7 = measuredWidth - measuredWidth2;
                                } else {
                                    measuredHeight = i9 + imageView.getMeasuredHeight();
                                    i7 = (((getWidth() - this.d.getMeasuredWidth()) + this.w) - this.x) / 2;
                                    measuredWidth = (((getWidth() + this.d.getMeasuredWidth()) + this.w) - this.x) / 2;
                                }
                            } else {
                                measuredHeight = getHeight() - i10;
                                i9 = measuredHeight - this.d.getMeasuredHeight();
                                i7 = (((getWidth() - this.d.getMeasuredWidth()) + this.w) - this.x) / 2;
                                measuredWidth = (((getWidth() + this.d.getMeasuredWidth()) + this.w) - this.x) / 2;
                            }
                        } else {
                            measuredHeight = imageView.getMeasuredHeight() + i9;
                            measuredWidth = this.d.getMeasuredWidth() + i7;
                        }
                        this.d.layout(i7, i9, measuredWidth, measuredHeight);
                    } else {
                        com.baidu.mapsdkplatform.comapi.map.ac acVar = this.f;
                        if (childAt == acVar) {
                            if (acVar.a()) {
                                a(this.f);
                                Point point2 = this.h;
                                if (point2 == null) {
                                    int height = (int) (((getHeight() - 15) * f2) + this.y);
                                    int width = (int) (((getWidth() - 15) * f) + this.w);
                                    int measuredWidth3 = width - this.f.getMeasuredWidth();
                                    int measuredHeight2 = height - this.f.getMeasuredHeight();
                                    if (this.t == 4) {
                                        height -= this.d.getMeasuredHeight();
                                        measuredHeight2 -= this.d.getMeasuredHeight();
                                    }
                                    this.f.layout(measuredWidth3, measuredHeight2, width, height);
                                } else {
                                    com.baidu.mapsdkplatform.comapi.map.ac acVar2 = this.f;
                                    int i12 = point2.x;
                                    acVar2.layout(i12, point2.y, acVar2.getMeasuredWidth() + i12, this.h.y + this.f.getMeasuredHeight());
                                }
                            }
                        } else {
                            RelativeLayout relativeLayout = this.l;
                            if (childAt == relativeLayout) {
                                a(relativeLayout);
                                Point point3 = this.g;
                                if (point3 == null) {
                                    this.B = this.l.getMeasuredWidth();
                                    this.A = this.l.getMeasuredHeight();
                                    int i13 = (int) (this.w + (5.0f * f));
                                    int height2 = (getHeight() - ((int) ((this.z + (f2 * 5.0f)) + 56.0f))) - this.d.getMeasuredHeight();
                                    this.l.layout(i13, height2, this.B + i13, this.A + height2);
                                } else {
                                    RelativeLayout relativeLayout2 = this.l;
                                    int i14 = point3.x;
                                    relativeLayout2.layout(i14, point3.y, relativeLayout2.getMeasuredWidth() + i14, this.g.y + this.l.getMeasuredHeight());
                                }
                            } else {
                                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                                if (layoutParams instanceof MapViewLayoutParams) {
                                    MapViewLayoutParams mapViewLayoutParams = (MapViewLayoutParams) layoutParams;
                                    if (mapViewLayoutParams.c == MapViewLayoutParams.ELayoutMode.absoluteMode) {
                                        point = mapViewLayoutParams.b;
                                    } else {
                                        GeoPoint ll2mc = CoordUtil.ll2mc(mapViewLayoutParams.f5830a);
                                        if (this.b.getBaseMap() != null) {
                                            point = this.b.getBaseMap().a(ll2mc);
                                        } else {
                                            point = new Point();
                                        }
                                    }
                                    a(childAt);
                                    int measuredWidth4 = childAt.getMeasuredWidth();
                                    int measuredHeight3 = childAt.getMeasuredHeight();
                                    float f5 = mapViewLayoutParams.d;
                                    float f6 = mapViewLayoutParams.e;
                                    int i15 = ((int) (point.x - (f5 * measuredWidth4))) + mapViewLayoutParams.g;
                                    int i16 = ((int) (point.y - (f6 * measuredHeight3))) + mapViewLayoutParams.f;
                                    childAt.layout(i15, i16, measuredWidth4 + i15, measuredHeight3 + i16);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final void onPause() {
        this.b.onPause();
    }

    public final void onResume() {
        this.b.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        BaiduMap baiduMap;
        if (bundle != null && (baiduMap = this.c) != null) {
            bundle.putParcelable("mapstatus", baiduMap.getMapStatus());
            Point point = this.g;
            if (point != null) {
                bundle.putParcelable("scalePosition", point);
            }
            Point point2 = this.h;
            if (point2 != null) {
                bundle.putParcelable("zoomPosition", point2);
            }
            bundle.putBoolean("mZoomControlEnabled", this.u);
            bundle.putBoolean("mScaleControlEnabled", this.v);
            bundle.putInt("logoPosition", this.t);
            bundle.putInt("paddingLeft", this.w);
            bundle.putInt("paddingTop", this.y);
            bundle.putInt("paddingRight", this.x);
            bundle.putInt("paddingBottom", this.z);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (view == this.d) {
            return;
        }
        if (e()) {
            super.removeView(view);
        } else {
            com.baidu.platform.comapi.util.j.a(new ak(this, view), 0L);
        }
    }

    public void setCustomStyleFilePathAndMode(String str, int i2) {
    }

    public final void setLogoPosition(LogoPosition logoPosition) {
        if (logoPosition == null) {
            this.t = LogoPosition.logoPostionleftBottom.ordinal();
        } else {
            this.t = logoPosition.ordinal();
        }
        requestLayout();
    }

    public void setMapCustomStyle(MapCustomStyleOptions mapCustomStyleOptions, CustomMapStyleCallBack customMapStyleCallBack) {
        if (mapCustomStyleOptions == null) {
            return;
        }
        String customMapStyleId = mapCustomStyleOptions.getCustomMapStyleId();
        if (customMapStyleId != null && !customMapStyleId.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.map.e.a().a(this.p, customMapStyleId, new ag(this, customMapStyleCallBack, mapCustomStyleOptions));
            return;
        }
        String localCustomStyleFilePath = mapCustomStyleOptions.getLocalCustomStyleFilePath();
        if (localCustomStyleFilePath != null && !localCustomStyleFilePath.isEmpty()) {
            a(localCustomStyleFilePath, "");
        }
    }

    public void setMapCustomStyleEnable(boolean z) {
        MapTextureView mapTextureView = this.b;
        if (mapTextureView == null) {
            return;
        }
        mapTextureView.getBaseMap().q(z);
    }

    public void setMapCustomStylePath(String str) {
        a(str, "");
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        this.w = i2;
        this.y = i3;
        this.x = i4;
        this.z = i5;
    }

    public void setScaleControlPosition(Point point) {
        int i2;
        if (point != null && (i2 = point.x) >= 0 && point.y >= 0 && i2 <= getWidth() && point.y <= getHeight()) {
            this.g = point;
            requestLayout();
        }
    }

    public void setZoomControlsPosition(Point point) {
        int i2;
        if (point != null && (i2 = point.x) >= 0 && point.y >= 0 && i2 <= getWidth() && point.y <= getHeight()) {
            this.h = point;
            requestLayout();
        }
    }

    public void showScaleControl(boolean z) {
        int i2;
        RelativeLayout relativeLayout = this.l;
        if (z) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        relativeLayout.setVisibility(i2);
        this.v = z;
    }

    public void showZoomControls(boolean z) {
        int i2;
        if (this.f.a()) {
            com.baidu.mapsdkplatform.comapi.map.ac acVar = this.f;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            acVar.setVisibility(i2);
            this.u = z;
        }
    }

    private void b() {
        HashMap hashMap = new HashMap();
        if (c()) {
            hashMap.put(ExifInterface.GPS_DIRECTION_TRUE, "1");
        } else {
            hashMap.put(ExifInterface.GPS_DIRECTION_TRUE, "0");
        }
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "M", "0.1", hashMap);
    }

    private boolean c() {
        try {
            Class.forName("com.baidu.bmfmap.map.FlutterTextureMapView");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        com.baidu.mapsdkplatform.comapi.map.ac acVar = this.f;
        if (acVar == null || !acVar.a()) {
            return;
        }
        float f = this.b.getBaseMap().E().f6196a;
        this.f.b(f > this.b.getBaseMap().b);
        this.f.a(f < this.b.getBaseMap().f6178a);
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
        this.o.setLayoutParams(layoutParams3);
        Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a("icon_scale.9.png", context);
        byte[] ninePatchChunk = a2.getNinePatchChunk();
        NinePatch.isNinePatchChunk(ninePatchChunk);
        this.o.setBackgroundDrawable(new NinePatchDrawable(a2, ninePatchChunk, new Rect(), null));
        this.l.addView(this.o);
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

    public TextureMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.r = new af(this);
        this.t = LogoPosition.logoPostionleftBottom.ordinal();
        this.u = true;
        this.v = true;
        this.C = false;
        a(context, (BaiduMapOptions) null);
    }

    private void b(Context context) {
        com.baidu.mapsdkplatform.comapi.map.ac acVar = new com.baidu.mapsdkplatform.comapi.map.ac(context);
        this.f = acVar;
        if (acVar.a()) {
            this.f.b(new ai(this));
            this.f.a(new aj(this));
            addView(this.f);
        }
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions) {
        Point point;
        Point point2;
        LogoPosition logoPosition;
        setBackgroundColor(-1);
        this.p = context;
        com.baidu.mapsdkplatform.comapi.map.i.a();
        BMapManager.init();
        if (SysOSUtil.getAuthToken() != null) {
            com.baidu.platform.comapi.util.h.a(SysOSUtil.getAuthToken());
        } else {
            com.baidu.mapsdkplatform.comapi.a.a().a(this.r);
            com.baidu.mapsdkplatform.comapi.a.a().c();
        }
        a(context, baiduMapOptions, i, k);
        a(context);
        b(context);
        if (baiduMapOptions != null && !baiduMapOptions.h) {
            this.f.setVisibility(4);
        }
        c(context);
        if (baiduMapOptions != null && !baiduMapOptions.i) {
            this.l.setVisibility(4);
        }
        if (baiduMapOptions != null && (logoPosition = baiduMapOptions.j) != null) {
            this.t = logoPosition.ordinal();
        }
        if (baiduMapOptions != null && (point2 = baiduMapOptions.l) != null) {
            this.h = point2;
        }
        if (baiduMapOptions != null && (point = baiduMapOptions.k) != null) {
            this.g = point;
        }
        b();
    }

    public TextureMapView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.r = new af(this);
        this.t = LogoPosition.logoPostionleftBottom.ordinal();
        this.u = true;
        this.v = true;
        this.C = false;
        a(context, (BaiduMapOptions) null);
    }

    public TextureMapView(Context context, BaiduMapOptions baiduMapOptions) {
        super(context);
        this.r = new af(this);
        this.t = LogoPosition.logoPostionleftBottom.ordinal();
        this.u = true;
        this.v = true;
        this.C = false;
        a(context, baiduMapOptions);
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions, String str, int i2) {
        MapTextureView mapTextureView = new MapTextureView(context);
        this.b = mapTextureView;
        addView(mapTextureView);
        if (baiduMapOptions != null) {
            this.c = new BaiduMap(context, this.b, baiduMapOptions.a());
        } else {
            this.c = new BaiduMap(context, this.b, (com.baidu.mapsdkplatform.comapi.map.u) null);
        }
        this.b.getBaseMap().a(new ah(this));
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
        if (densityDpi > 480) {
            Matrix matrix = new Matrix();
            matrix.postScale(2.0f, 2.0f);
            this.e = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
        } else if (densityDpi > 320 && densityDpi <= 480) {
            Matrix matrix2 = new Matrix();
            matrix2.postScale(1.5f, 1.5f);
            this.e = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix2, true);
        } else {
            this.e = a2;
        }
        if (this.e != null) {
            ImageView imageView = new ImageView(context);
            this.d = imageView;
            imageView.setImageBitmap(this.e);
            addView(this.d);
        }
    }

    private void a(View view) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        }
        int i2 = layoutParams.width;
        if (i2 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        int i3 = layoutParams.height;
        if (i3 > 0) {
            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        } else {
            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(makeMeasureSpec, makeMeasureSpec2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        MapTextureView mapTextureView = this.b;
        if (mapTextureView == null || mapTextureView.getBaseMap() == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.e(f5866a, "customStyleFilePath is empty or null, please check!");
            return;
        }
        if (!str.endsWith(".sty")) {
            Log.e(f5866a, "customStyleFile format is incorrect , please check!");
        } else if (!new File(str).exists()) {
            Log.e(f5866a, "customStyleFile does not exist , please check!");
        } else {
            this.b.getBaseMap().b(str, str2);
        }
    }
}
