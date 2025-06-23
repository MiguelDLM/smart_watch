package com.baidu.platform.comapi.map;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class OverlayItem {
    public static final int ALIGN_BOTTON = 2;
    public static final int ALIGN_TOP = 3;
    public static final int ALING_CENTER = 1;

    /* renamed from: a, reason: collision with root package name */
    protected GeoPoint f9627a;
    protected String b;
    protected String c;
    private int e;
    private int f;
    private Bundle m;
    private Bundle n;
    private float o;
    private byte[] p;
    private float q;
    private int s;
    private CoordType i = CoordType.CoordType_BD09;
    private Drawable g = null;
    private int r = 0;
    private int d = 2;
    private String h = "";
    private float j = 0.5f;
    private float k = 1.0f;
    private ArrayList<Bundle> l = new ArrayList<>();

    /* loaded from: classes8.dex */
    public enum AnimEffect {
        NONE,
        GROWTH,
        WAVE,
        SHRINK,
        FADE_OUT,
        FADE_IN,
        GROWTH_FADE_IN,
        SHRINK_FADE_OUT,
        GROWTH_REBOUND,
        ALPHA,
        ANCHOR_GROUTH,
        ROTATE
    }

    /* loaded from: classes8.dex */
    public enum AnimationSubType {
        NONE,
        RADAR
    }

    /* loaded from: classes8.dex */
    public enum CoordType {
        CoordType_BD09LL,
        CoordType_BD09
    }

    public OverlayItem(GeoPoint geoPoint, String str, String str2) {
        this.f9627a = geoPoint;
        this.b = str;
        this.c = str2;
    }

    public void addClickRect(Bundle bundle) {
        if (this.l == null) {
            this.l = new ArrayList<>();
        }
        this.l.add(bundle);
    }

    public float getAnchorX() {
        return this.j;
    }

    public float getAnchorY() {
        return this.k;
    }

    public Bundle getAnimate() {
        return this.m;
    }

    public int getBound() {
        return this.d;
    }

    public ArrayList<Bundle> getClickRect() {
        return this.l;
    }

    public CoordType getCoordType() {
        return this.i;
    }

    public Bundle getDelay() {
        return this.n;
    }

    public float getGeoZ() {
        return this.o;
    }

    public byte[] getGifData() {
        return this.p;
    }

    public String getId() {
        return this.h;
    }

    public int getIndoorPoi() {
        return this.s;
    }

    public int getLevel() {
        return this.e;
    }

    public final Drawable getMarker() {
        return this.g;
    }

    public int getMask() {
        return this.f;
    }

    public float getMultiplyDpi() {
        return this.r;
    }

    public GeoPoint getPoint() {
        return this.f9627a;
    }

    public int getResId() {
        if (getMarker() == null) {
            return -1;
        }
        return getMarker().hashCode();
    }

    public float getScale() {
        return this.q;
    }

    public String getSnippet() {
        return this.c;
    }

    public String getTitle() {
        return this.b;
    }

    public void setAnchor(float f, float f2) {
        this.j = f;
        this.k = f2;
    }

    public void setAnimate(Bundle bundle) {
        this.m = bundle;
    }

    public void setAnimateDuration(int i) {
        if (this.m == null) {
            this.m = new Bundle();
        }
        this.m.putInt("dur", i);
    }

    public void setAnimateEffect(AnimEffect animEffect) {
        if (this.m == null) {
            this.m = new Bundle();
        }
        switch (ac.f9630a[animEffect.ordinal()]) {
            case 1:
                this.m.putInt("type", 1);
                return;
            case 2:
                this.m.putInt("type", 2);
                return;
            case 3:
                this.m.putInt("type", 3);
                return;
            case 4:
                this.m.putInt("type", 4);
                return;
            case 5:
                this.m.putInt("type", 5);
                return;
            case 6:
                this.m.putInt("type", 6);
                return;
            case 7:
                this.m.putInt("type", 7);
                return;
            case 8:
                this.m.putInt("type", 8);
                return;
            case 9:
                this.m.putInt("type", 9);
                return;
            case 10:
                this.m.putInt("type", 10);
                return;
            case 11:
                this.m.putInt("type", 11);
                return;
            default:
                this.m.putInt("type", 0);
                return;
        }
    }

    public void setAnimateEndSize(int i, int i2) {
        if (this.m == null) {
            this.m = new Bundle();
        }
        this.m.putInt("en_w", i);
        this.m.putInt("en_h", i2);
    }

    public void setAnimateStartSize(int i, int i2) {
        if (this.m == null) {
            this.m = new Bundle();
        }
        this.m.putInt("st_w", i);
        this.m.putInt("st_h", i2);
    }

    public void setBound(int i) {
        this.d = i;
    }

    public void setClickRect(ArrayList<Bundle> arrayList) {
        this.l = arrayList;
    }

    public void setCoordType(CoordType coordType) {
        this.i = coordType;
    }

    public void setDelay(Bundle bundle) {
        this.n = bundle;
    }

    public void setGeoPoint(GeoPoint geoPoint) {
        this.f9627a = geoPoint;
    }

    public void setGeoZ(float f) {
        this.o = f;
    }

    public void setGifData(byte[] bArr) {
        this.p = bArr;
    }

    public void setId(String str) {
        this.h = str;
    }

    public void setIndoorPoi(int i) {
        this.s = i;
    }

    public void setLevel(int i) {
        this.e = i;
    }

    public void setMarker(Drawable drawable) {
        this.g = drawable;
    }

    public void setMask(int i) {
        this.f = i;
    }

    public void setMultiplyDpi(int i) {
        this.r = i;
    }

    public void setScale(float f) {
        this.q = f;
    }

    public void setSnippet(String str) {
        this.c = str;
    }

    public void setSubAnimateEffect(AnimationSubType animationSubType) {
        if (this.m == null) {
            this.m = new Bundle();
        }
        if (ac.b[animationSubType.ordinal()] != 1) {
            this.m.putInt("sub_type", 0);
        } else {
            this.m.putInt("sub_type", 1);
        }
    }

    public void setTitle(String str) {
        this.b = str;
    }

    public void setAnchor(int i) {
        if (i == 1) {
            setAnchor(0.5f, 0.5f);
        } else if (i == 2) {
            setAnchor(0.5f, 1.0f);
        } else {
            if (i != 3) {
                return;
            }
            setAnchor(0.5f, 0.0f);
        }
    }
}
