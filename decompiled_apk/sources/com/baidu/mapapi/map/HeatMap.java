package com.baidu.mapapi.map;

import XIXIX.OOXIXo;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.util.SparseIntArray;
import androidx.collection.LongSparseArray;
import com.baidu.mapapi.map.HeatMapAnimation;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.util.SysOSUtil;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes7.dex */
public class HeatMap {
    public static final Gradient DEFAULT_GRADIENT;
    public static final int DEFAULT_MAX_HIGH = 0;
    public static final int DEFAULT_MAX_LEVEL = 22;
    public static final int DEFAULT_MIN_LEVEL = 4;
    public static final double DEFAULT_OPACITY = 0.6d;
    public static final int DEFAULT_RADIUS = 12;
    private static int E = 0;
    private static final String b = "HeatMap";
    private static final SparseIntArray c;
    private static final int[] d;
    private static final float[] e;
    private HashMap<String, Tile> A;
    private ExecutorService B;
    private HashSet<String> C;
    private int D;

    /* renamed from: a, reason: collision with root package name */
    BaiduMap f5811a;
    private int f;
    private boolean g;
    private int h;
    private int i;
    private z<WeightedLatLng> j;
    private Collection<WeightedLatLng> k;
    private List<List<WeightedLatLng>> l;
    private float m;
    protected boolean mIsSetMaxIntensity;
    private float n;
    private HeatMapAnimation o;
    private HeatMapAnimation p;
    private int q;
    private int r;
    private Gradient s;
    private double t;
    private o u;
    private int[] v;
    private float[] w;
    private double[] x;
    private double[] y;
    private List<double[]> z;

    /* loaded from: classes7.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private Collection<WeightedLatLng> f5812a;
        private List<List<WeightedLatLng>> b;
        private int c = 12;
        private int d = 12;
        private Gradient e = HeatMap.DEFAULT_GRADIENT;
        private double f = 0.6d;
        private int g = 0;
        private boolean h = false;
        private int i = 22;
        private int j = 4;
        private float k = 1.0f;
        private float l = 0.0f;
        private boolean m = false;
        private HeatMapAnimation n;
        private HeatMapAnimation o;

        public Builder() {
            HeatMapAnimation.AnimationType animationType = HeatMapAnimation.AnimationType.Linear;
            this.n = new HeatMapAnimation(false, 100, animationType);
            this.o = new HeatMapAnimation(false, 100, animationType);
        }

        public HeatMap build() {
            if (this.f5812a == null && this.b == null) {
                throw new IllegalStateException("BDMapSDKException: No input data: you must use either .data or .weightedData before building");
            }
            return new HeatMap(this, null);
        }

        public Builder data(Collection<LatLng> collection) {
            if (collection != null && !collection.isEmpty()) {
                if (!collection.contains(null)) {
                    return weightedData(HeatMap.c(collection));
                }
                throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
            }
            throw new IllegalArgumentException("BDMapSDKException: No input points.");
        }

        public Builder datas(List<List<LatLng>> list) {
            if (list != null && !list.isEmpty()) {
                if (!list.contains(null)) {
                    return weightedDatas(HeatMap.b(list));
                }
                throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
            }
            throw new IllegalArgumentException("BDMapSDKException: No input datas.");
        }

        public Builder frameAnimation(HeatMapAnimation heatMapAnimation) {
            this.o = heatMapAnimation;
            return this;
        }

        public Builder gradient(Gradient gradient) {
            if (gradient != null) {
                this.e = gradient;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: gradient can not be null");
        }

        public Builder initAnimation(HeatMapAnimation heatMapAnimation) {
            this.n = heatMapAnimation;
            return this;
        }

        public Builder isRadiusMeter(boolean z) {
            this.h = z;
            return this;
        }

        public Builder maxHigh(int i) {
            if (i < 0) {
                return this;
            }
            if (i > 200) {
                this.g = 200;
                return this;
            }
            this.g = i;
            return this;
        }

        public Builder maxIntensity(float f) {
            if (f >= 0.0f && f > this.l) {
                this.k = f;
                this.m = true;
            }
            return this;
        }

        public Builder maxShowLevel(int i) {
            if (i < this.j) {
                return this;
            }
            if (i > 22) {
                this.i = 22;
            }
            this.i = i;
            return this;
        }

        public Builder minIntensity(float f) {
            if (f < 0.0f) {
                this.l = 0.0f;
                return this;
            }
            if (f >= this.k) {
                return this;
            }
            this.l = f;
            return this;
        }

        public Builder minShowLevel(int i) {
            if (i < 4) {
                this.j = 4;
                return this;
            }
            if (i > this.i) {
                return this;
            }
            this.j = i;
            return this;
        }

        public Builder opacity(double d) {
            if (d < OOXIXo.f3760XO) {
                this.f = OOXIXo.f3760XO;
                return this;
            }
            if (d > 1.0d) {
                this.f = 1.0d;
                return this;
            }
            this.f = d;
            return this;
        }

        public Builder radius(int i) {
            if (i < 10) {
                this.c = 10;
                return this;
            }
            if (i > 50) {
                this.c = 50;
                return this;
            }
            this.c = i;
            return this;
        }

        public Builder radiusMeter(int i) {
            if (i < 10) {
                this.d = 10;
                return this;
            }
            if (i > 50) {
                this.d = 50;
                return this;
            }
            this.d = i;
            return this;
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
            if (collection != null && !collection.isEmpty()) {
                if (!collection.contains(null)) {
                    this.f5812a = collection;
                    return this;
                }
                throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
            }
            throw new IllegalArgumentException("BDMapSDKException: No input points.");
        }

        public Builder weightedDatas(List<List<WeightedLatLng>> list) {
            if (list != null && !list.isEmpty()) {
                if (!list.contains(null)) {
                    this.b = list;
                    return this;
                }
                throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
            }
            throw new IllegalArgumentException("BDMapSDKException: No input points.");
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        c = sparseIntArray;
        sparseIntArray.put(3, 8388608);
        sparseIntArray.put(4, 4194304);
        sparseIntArray.put(5, 2097152);
        sparseIntArray.put(6, 1048576);
        sparseIntArray.put(7, 524288);
        sparseIntArray.put(8, 262144);
        sparseIntArray.put(9, 131072);
        sparseIntArray.put(10, 65536);
        sparseIntArray.put(11, 32768);
        sparseIntArray.put(12, 16384);
        sparseIntArray.put(13, 8192);
        sparseIntArray.put(14, 4096);
        sparseIntArray.put(15, 2048);
        sparseIntArray.put(16, 1024);
        sparseIntArray.put(17, 512);
        sparseIntArray.put(18, 256);
        sparseIntArray.put(19, 128);
        sparseIntArray.put(20, 64);
        int[] iArr = {Color.rgb(0, 0, 200), Color.rgb(0, 225, 0), Color.rgb(255, 0, 0)};
        d = iArr;
        float[] fArr = {0.08f, 0.4f, 1.0f};
        e = fArr;
        DEFAULT_GRADIENT = new Gradient(iArr, fArr);
        E = 0;
    }

    public /* synthetic */ HeatMap(Builder builder, q qVar) {
        this(builder);
    }

    private void b(Collection<WeightedLatLng> collection) {
        this.k = collection;
        if (!collection.isEmpty()) {
            o d2 = d(this.k);
            this.u = d2;
            this.j = new z<>(d2);
            Iterator<WeightedLatLng> it = this.k.iterator();
            while (it.hasNext()) {
                this.j.a((z<WeightedLatLng>) it.next());
            }
            this.y = a(this.q);
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: No input points.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Collection<WeightedLatLng> c(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        Iterator<LatLng> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new WeightedLatLng(it.next()));
        }
        return arrayList;
    }

    private synchronized void d() {
        this.A.clear();
    }

    public HeatMapData getData(int i, int i2) {
        List<List<WeightedLatLng>> list;
        if (i2 > 23 || i2 < 4 || ((list = this.l) == null && this.k == null)) {
            return null;
        }
        if (list != null) {
            return b(i, i2);
        }
        if (this.k != null) {
            return a(i, i2);
        }
        return null;
    }

    public int getMaxHigh() {
        return this.f;
    }

    public boolean isFrameAnimation() {
        HeatMapAnimation heatMapAnimation = this.o;
        if (heatMapAnimation == null) {
            return false;
        }
        return heatMapAnimation.getIsAnimation();
    }

    public boolean isInitAnimation() {
        HeatMapAnimation heatMapAnimation = this.p;
        if (heatMapAnimation == null) {
            return false;
        }
        return heatMapAnimation.getIsAnimation();
    }

    public void removeHeatMap() {
        BaiduMap baiduMap = this.f5811a;
        if (baiduMap != null) {
            baiduMap.a(this);
        }
        List<List<WeightedLatLng>> list = this.l;
        if (list != null) {
            list.clear();
        }
        Collection<WeightedLatLng> collection = this.k;
        if (collection != null) {
            collection.clear();
        }
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("grid_size", this.D);
        bundle.putFloat("point_size_meter", this.r * 2);
        bundle.putFloat("point_size", this.q * 2);
        bundle.putFloat("max_hight", this.f);
        bundle.putFloat("alpha", (float) this.t);
        List<List<WeightedLatLng>> list = this.l;
        if (list != null) {
            bundle.putInt("frame_count", list.size());
        } else if (this.k != null) {
            bundle.putInt("frame_count", 1);
        }
        bundle.putIntArray("color_array", this.v);
        bundle.putFloatArray("color_start_points", this.w);
        bundle.putBoolean("is_need_init_animation", this.p.getIsAnimation());
        bundle.putBoolean("is_need_frame_animation", this.o.getIsAnimation());
        bundle.putBoolean("point_size_is_meter", this.g);
        bundle.putInt("init_animation_duration", this.p.getDuration());
        bundle.putInt("init_animation_type", this.p.getAnimationType());
        bundle.putInt("frame_animation_duration", this.o.getDuration());
        bundle.putInt("frame_animation_type", this.o.getAnimationType());
        bundle.putFloat("max_intentity", this.m);
        bundle.putFloat("min_intentity", this.n);
        bundle.putFloat("max_show_level", this.h);
        bundle.putFloat("min_show_level", this.i);
        return bundle;
    }

    public void updateData(Collection<LatLng> collection) {
        if (collection != null && !collection.isEmpty()) {
            if (!collection.contains(null)) {
                updateWeightedData(c(collection));
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
        }
        throw new IllegalArgumentException("BDMapSDKException: No input points.");
    }

    public void updateDatas(List<List<LatLng>> list) {
        if (list != null && !list.isEmpty()) {
            if (!list.contains(null)) {
                updateWeightedDatas(b(list));
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
        }
        throw new IllegalArgumentException("BDMapSDKException: No input datas.");
    }

    public void updateFrameAnimation(HeatMapAnimation heatMapAnimation) {
        this.o = heatMapAnimation;
    }

    public void updateGradient(Gradient gradient) {
        if (gradient != null) {
            this.s = gradient;
            a(gradient);
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: gradient can not be null");
    }

    public void updateIsRadiusMeter(boolean z) {
        this.g = z;
    }

    public void updateMaxHigh(int i) {
        if (i < 0) {
            return;
        }
        if (i > 200) {
            this.f = 200;
        } else {
            this.f = i;
        }
    }

    public void updateMaxIntensity(float f) {
        if (f >= 0.0f && f > this.n) {
            this.m = f;
        }
    }

    public void updateMaxShowLevel(int i) {
        if (i < this.i) {
            return;
        }
        if (i > 22) {
            this.h = 22;
        } else {
            this.h = i;
        }
    }

    public void updateMinIntensity(float f) {
        if (f < 0.0f) {
            this.n = 0.0f;
        } else {
            if (f >= this.m) {
                return;
            }
            this.n = f;
        }
    }

    public void updateMinShowLevel(int i) {
        if (i < 4) {
            this.i = 4;
        } else {
            if (i > this.h) {
                return;
            }
            this.i = i;
        }
    }

    public void updateOpacity(double d2) {
        if (d2 < OOXIXo.f3760XO) {
            this.t = OOXIXo.f3760XO;
        } else if (d2 > 1.0d) {
            this.t = 1.0d;
        } else {
            this.t = d2;
        }
    }

    public void updateRadius(int i) {
        if (i < 10) {
            this.q = 10;
        } else if (i > 50) {
            this.q = 50;
        } else {
            this.q = i;
        }
    }

    public void updateRadiusMeter(int i) {
        if (i < 10) {
            this.r = 10;
        } else if (i > 50) {
            this.r = 50;
        } else {
            this.r = i;
        }
    }

    public void updateWeightedData(Collection<WeightedLatLng> collection) {
        if (collection != null && !collection.isEmpty()) {
            if (!collection.contains(null)) {
                this.k = collection;
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
        }
        throw new IllegalArgumentException("BDMapSDKException: No input points.");
    }

    public void updateWeightedDatas(List<List<WeightedLatLng>> list) {
        if (list != null && !list.isEmpty()) {
            if (!list.contains(null)) {
                this.l = list;
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
        }
        throw new IllegalArgumentException("BDMapSDKException: No input points.");
    }

    private HeatMap(Builder builder) {
        this.f = 200;
        this.g = false;
        this.h = 22;
        this.i = 4;
        this.D = SysOSUtil.getInstance().getScreenWidth() / 2;
        this.A = new HashMap<>();
        this.B = Executors.newFixedThreadPool(1);
        this.C = new HashSet<>();
        this.l = builder.b;
        this.q = builder.c;
        this.r = builder.d;
        this.g = builder.h;
        this.h = builder.i;
        this.i = builder.j;
        boolean z = builder.m;
        this.mIsSetMaxIntensity = z;
        if (!z && this.l != null) {
            this.z = new ArrayList();
            for (int i = 0; i < this.l.size(); i++) {
                List<WeightedLatLng> list = this.l.get(i);
                this.k = list;
                this.u = d(list);
                this.z.add(a(this.q));
            }
        }
        Collection<WeightedLatLng> collection = builder.f5812a;
        this.k = collection;
        if (!this.mIsSetMaxIntensity && collection != null) {
            b(collection);
        }
        this.p = builder.n;
        this.o = builder.o;
        this.f = builder.g;
        this.m = builder.k;
        this.n = builder.l;
        this.s = builder.e;
        this.t = builder.f;
        int i2 = this.q;
        this.x = a(i2, i2 / 3.0d);
        a(this.s);
    }

    private static o d(Collection<WeightedLatLng> collection) {
        Iterator<WeightedLatLng> it = collection.iterator();
        WeightedLatLng next = it.next();
        double d2 = next.getPoint().x;
        double d3 = d2;
        double d4 = next.getPoint().x;
        double d5 = next.getPoint().y;
        double d6 = next.getPoint().y;
        while (it.hasNext()) {
            WeightedLatLng next2 = it.next();
            double d7 = next2.getPoint().x;
            double d8 = next2.getPoint().y;
            if (d7 < d3) {
                d3 = d7;
            }
            if (d7 > d4) {
                d4 = d7;
            }
            if (d8 < d5) {
                d5 = d8;
            }
            if (d8 > d6) {
                d6 = d8;
            }
        }
        return new o(d3, d4, d5, d6);
    }

    private HeatMapData a(int i, int i2) {
        Collection<WeightedLatLng> collection = this.k;
        if (collection == null) {
            return null;
        }
        double[] dArr = this.y;
        return new HeatMapData(collection, dArr != null ? (float) dArr[i2] : 0.0f);
    }

    public void c() {
        this.B.shutdownNow();
    }

    public synchronized void a() {
        this.C.clear();
        this.A.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<List<WeightedLatLng>> b(List<List<LatLng>> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<List<LatLng>> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((List) c(it.next()));
        }
        return arrayList;
    }

    private synchronized void a(String str, Tile tile) {
        this.A.put(str, tile);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3) {
        double d2 = c.get(i3);
        double d3 = (this.q * d2) / 256.0d;
        double d4 = ((2.0d * d3) + d2) / ((r6 * 2) + 256);
        if (i < 0 || i2 < 0) {
            return;
        }
        double d5 = (i * d2) - d3;
        double d6 = ((i + 1) * d2) + d3;
        double d7 = (i2 * d2) - d3;
        double d8 = ((i2 + 1) * d2) + d3;
        o oVar = new o(d5, d6, d7, d8);
        o oVar2 = this.u;
        if (oVar.a(new o(oVar2.f5906a - d3, oVar2.c + d3, oVar2.b - d3, oVar2.d + d3))) {
            Collection<WeightedLatLng> a2 = this.j.a(oVar);
            if (a2.isEmpty()) {
                return;
            }
            int i4 = this.q;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, (i4 * 2) + 256, (i4 * 2) + 256);
            for (WeightedLatLng weightedLatLng : a2) {
                Point point = weightedLatLng.getPoint();
                int i5 = (int) ((point.x - d5) / d4);
                int i6 = (int) ((d8 - point.y) / d4);
                int i7 = this.q;
                if (i5 >= (i7 * 2) + 256) {
                    i5 = (i7 * 2) + 255;
                }
                if (i6 >= (i7 * 2) + 256) {
                    i6 = (i7 * 2) + 255;
                }
                double[] dArr2 = dArr[i5];
                dArr2[i6] = dArr2[i6] + weightedLatLng.intensity;
                d8 = d8;
            }
            Bitmap a3 = a(a(dArr, this.x), this.v, this.y[i3 - 1]);
            Tile a4 = a(a3);
            a3.recycle();
            a(i + "_" + i2 + "_" + i3, a4);
            if (this.A.size() > E) {
                a();
            }
            BaiduMap baiduMap = this.f5811a;
            if (baiduMap != null) {
                baiduMap.a();
            }
        }
    }

    private HeatMapData b(int i, int i2) {
        List<List<WeightedLatLng>> list = this.l;
        if (list == null || i >= list.size()) {
            return null;
        }
        List<WeightedLatLng> list2 = this.l.get(i);
        List<double[]> list3 = this.z;
        return new HeatMapData(list2, (list3 == null || list3.size() <= i) ? 0.0f : (float) this.z.get(i)[i2]);
    }

    public void b() {
        d();
    }

    private void a(Gradient gradient) {
        this.s = gradient;
        this.v = gradient.a(this.t);
        this.w = gradient.a();
    }

    private double[] a(int i) {
        int i2;
        double[] dArr = new double[23];
        int i3 = 4;
        while (true) {
            if (i3 >= 11) {
                break;
            }
            dArr[i3] = a(this.k, this.u, i, (int) (Math.pow(2.0d, i3 - 3) * 1280.0d));
            if (i3 == 4) {
                for (int i4 = 0; i4 < i3; i4++) {
                    dArr[i4] = dArr[i3];
                }
            }
            i3++;
        }
        for (i2 = 11; i2 < 23; i2++) {
            dArr[i2] = dArr[10];
        }
        return dArr;
    }

    private static Tile a(Bitmap bitmap) {
        ByteBuffer allocate = ByteBuffer.allocate(bitmap.getWidth() * bitmap.getHeight() * 4);
        bitmap.copyPixelsToBuffer(allocate);
        return new Tile(256, 256, allocate.array());
    }

    private static double[] a(int i, double d2) {
        double[] dArr = new double[(i * 2) + 1];
        for (int i2 = -i; i2 <= i; i2++) {
            dArr[i2 + i] = Math.exp(((-i2) * i2) / ((2.0d * d2) * d2));
        }
        return dArr;
    }

    private static double[][] a(double[][] dArr, double[] dArr2) {
        int floor = (int) Math.floor(dArr2.length / 2.0d);
        int length = dArr.length;
        int i = length - (floor * 2);
        int i2 = floor + i;
        int i3 = i2 - 1;
        int i4 = 1;
        double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, length);
        int i5 = 0;
        while (true) {
            double d2 = OOXIXo.f3760XO;
            if (i5 >= length) {
                break;
            }
            int i6 = 0;
            while (i6 < length) {
                double d3 = dArr[i5][i6];
                if (d3 != d2) {
                    int i7 = i5 + floor;
                    if (i3 < i7) {
                        i7 = i3;
                    }
                    int i8 = i7 + 1;
                    int i9 = i5 - floor;
                    for (int i10 = floor > i9 ? floor : i9; i10 < i8; i10++) {
                        double[] dArr4 = dArr3[i10];
                        dArr4[i6] = dArr4[i6] + (dArr2[i10 - i9] * d3);
                    }
                }
                i6++;
                d2 = OOXIXo.f3760XO;
            }
            i5++;
        }
        double[][] dArr5 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i, i);
        int i11 = floor;
        while (i11 < i2) {
            int i12 = 0;
            while (i12 < length) {
                double d4 = dArr3[i11][i12];
                if (d4 != OOXIXo.f3760XO) {
                    int i13 = i12 + floor;
                    if (i3 < i13) {
                        i13 = i3;
                    }
                    int i14 = i13 + i4;
                    int i15 = i12 - floor;
                    for (int i16 = floor > i15 ? floor : i15; i16 < i14; i16++) {
                        double[] dArr6 = dArr5[i11 - floor];
                        int i17 = i16 - floor;
                        dArr6[i17] = dArr6[i17] + (dArr2[i16 - i15] * d4);
                    }
                }
                i12++;
                i4 = 1;
            }
            i11++;
            i4 = 1;
        }
        return dArr5;
    }

    private static Bitmap a(double[][] dArr, int[] iArr, double d2) {
        int i = iArr[iArr.length - 1];
        double length = (iArr.length - 1) / d2;
        int length2 = dArr.length;
        int[] iArr2 = new int[length2 * length2];
        for (int i2 = 0; i2 < length2; i2++) {
            for (int i3 = 0; i3 < length2; i3++) {
                double d3 = dArr[i3][i2];
                int i4 = (i2 * length2) + i3;
                int i5 = (int) (d3 * length);
                if (d3 != OOXIXo.f3760XO) {
                    if (i5 < iArr.length) {
                        iArr2[i4] = iArr[i5];
                    } else {
                        iArr2[i4] = i;
                    }
                } else {
                    iArr2[i4] = 0;
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(length2, length2, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr2, 0, length2, 0, 0, length2, length2);
        return createBitmap;
    }

    private static double a(Collection<WeightedLatLng> collection, o oVar, int i, int i2) {
        double d2 = oVar.f5906a;
        double d3 = oVar.c;
        double d4 = oVar.b;
        double d5 = d3 - d2;
        double d6 = oVar.d - d4;
        if (d5 <= d6) {
            d5 = d6;
        }
        double d7 = ((int) ((i2 / (i * 2)) + 0.5d)) / d5;
        LongSparseArray longSparseArray = new LongSparseArray();
        double d8 = OOXIXo.f3760XO;
        for (WeightedLatLng weightedLatLng : collection) {
            int i3 = (int) ((weightedLatLng.getPoint().y - d4) * d7);
            long j = (int) ((weightedLatLng.getPoint().x - d2) * d7);
            LongSparseArray longSparseArray2 = (LongSparseArray) longSparseArray.get(j);
            if (longSparseArray2 == null) {
                longSparseArray2 = new LongSparseArray();
                longSparseArray.put(j, longSparseArray2);
            }
            long j2 = i3;
            Double d9 = (Double) longSparseArray2.get(j2);
            if (d9 == null) {
                d9 = Double.valueOf(OOXIXo.f3760XO);
            }
            LongSparseArray longSparseArray3 = longSparseArray;
            double d10 = d2;
            double doubleValue = d9.doubleValue() + weightedLatLng.intensity;
            longSparseArray2.put(j2, Double.valueOf(doubleValue));
            if (doubleValue > d8) {
                d8 = doubleValue;
            }
            longSparseArray = longSparseArray3;
            d2 = d10;
        }
        return d8;
    }
}
