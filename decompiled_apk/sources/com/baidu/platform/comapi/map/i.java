package com.baidu.platform.comapi.map;

import android.text.TextUtils;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comapi.util.JsonBuilder;
import com.facebook.appevents.internal.ViewHierarchyConstants;

/* loaded from: classes8.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    protected ap f9663a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public String i;
    public boolean j;
    protected double[] l;
    protected double[] m;
    protected int[] n;
    protected JsonBuilder r;
    public float k = 5.0f;
    private boolean u = false;
    private int v = 0;
    private int w = 0;
    protected GeoPoint o = new GeoPoint(0, 0);
    protected GeoPoint p = new GeoPoint(0, 0);
    protected boolean q = true;
    protected int s = -1;
    protected int t = 0;

    public i(ap apVar) {
        this.f9663a = apVar;
    }

    public abstract String a();

    public String a(int i) {
        JsonBuilder jsonBuilder = new JsonBuilder();
        this.r = jsonBuilder;
        jsonBuilder.object();
        int i2 = 0;
        if (i == 0) {
            this.r.key("path").arrayValue();
            if (this.l != null) {
                int i3 = 0;
                while (true) {
                    double[] dArr = this.l;
                    if (i3 >= dArr.length) {
                        break;
                    }
                    this.r.value(dArr[i3]);
                    i3++;
                }
            }
            this.r.endArrayValue();
            this.r.key("arrColor").arrayValue();
            if (this.n != null) {
                int i4 = 0;
                while (true) {
                    int[] iArr = this.n;
                    if (i4 >= iArr.length) {
                        break;
                    }
                    this.r.value(iArr[i4]);
                    i4++;
                }
            }
            this.r.endArrayValue();
            this.r.key("useColorArray").value(this.g);
        } else if (i == 1) {
            this.r.key("sgeo");
            this.r.object();
            this.r.key("bound").arrayValue();
            GeoPoint geoPoint = this.o;
            if (geoPoint != null && this.p != null) {
                this.r.value(geoPoint.getLongitude());
                this.r.value(this.o.getLatitude());
                this.r.value(this.p.getLongitude());
                this.r.value(this.p.getLatitude());
            }
            this.r.endArrayValue();
            if (this.t == 4) {
                this.r.key("type").value(3);
            } else {
                this.r.key("type").value(this.t);
            }
            this.r.key("elements").arrayValue();
            this.r.object();
            this.r.key("points").arrayValue();
            if (this.l != null) {
                int i5 = 0;
                while (true) {
                    double[] dArr2 = this.l;
                    if (i5 >= dArr2.length) {
                        break;
                    }
                    this.r.value(dArr2[i5]);
                    i5++;
                }
            }
            this.r.endArrayValue();
            this.r.endObject();
            this.r.endArrayValue();
            this.r.endObject();
        }
        this.r.key("ud").value(String.valueOf(hashCode()));
        this.r.key(MapBundleKey.MapObjKey.OBJ_DIR).value(0);
        ap apVar = this.f9663a;
        if (apVar != null && apVar.a() != 0) {
            this.r.key(MapBundleKey.MapObjKey.OBJ_NORMALSTYTLE).value(this.f9663a.a());
            this.r.key(MapBundleKey.MapObjKey.OBJ_FOCUSSTYTLE).value(this.f9663a.a());
            this.r.key("ty").value(32);
        } else {
            int i6 = this.t;
            if (i6 == 3) {
                this.r.key("ty").value(3100);
            } else if (i6 == 4) {
                this.r.key("ty").value(3200);
            } else {
                this.r.key("ty").value(-1);
            }
        }
        this.r.key(MapBundleKey.MapObjKey.OBJ_OFFSET).value(0);
        this.r.key("in").value(0);
        this.r.key("tx").value("");
        this.r.key("dis").value(0);
        this.r.key("align").value(0);
        if (this.b) {
            this.r.key("dash").value(1);
            this.r.key("ty").value(this.t);
        }
        if (this.c) {
            this.r.key("trackMove").object();
            this.r.key("pointStyle").value(((aq) this.f9663a).e());
            this.r.endObject();
        }
        if (this.e) {
            this.r.key("cancelDataReduction").value(1);
        } else {
            this.r.key("cancelDataReduction").value(0);
        }
        if (this.f) {
            this.r.key("cancelSmooth").value(1);
        } else {
            this.r.key("cancelSmooth").value(0);
        }
        if (this.j) {
            this.r.key("isTrackBloom").value(1);
            this.r.key("bloomSpeed").value(this.k);
        } else {
            this.r.key("isTrackBloom").value(0);
        }
        if (this.d) {
            this.r.key("pointMove").object();
            if (this.h) {
                this.r.key("use3dPoint").value(1);
            } else {
                this.r.key("use3dPoint").value(0);
            }
            if (this.u) {
                this.r.key("duration").value(this.v);
                this.r.key("easingCurve").value(this.w);
                this.u = false;
            } else {
                this.r.key("duration").value(0);
                this.r.key("easingCurve").value(0);
            }
            this.r.key("pointArray").arrayValue();
            if (this.m != null) {
                while (true) {
                    double[] dArr3 = this.m;
                    if (i2 >= dArr3.length) {
                        break;
                    }
                    this.r.value(dArr3[i2]);
                    i2++;
                }
            }
            this.r.endArrayValue();
            if (!TextUtils.isEmpty(this.i)) {
                this.r.key("imagePath").value(this.i);
            }
            this.r.endObject();
        }
        this.r.key("style").object();
        if (this.f9663a != null) {
            this.r.key(ViewHierarchyConstants.DIMENSION_WIDTH_KEY).value(this.f9663a.c());
            this.r.key("color").value(ap.c(this.f9663a.b()));
            int i7 = this.t;
            if (i7 == 3 || i7 == 4) {
                this.r.key("scolor").value(ap.c(this.f9663a.d()));
            }
        }
        this.r.endObject();
        this.r.endObject();
        return this.r.toString();
    }

    public void a(boolean z, int i, int i2) {
        this.u = z;
        this.v = i;
        this.w = i2;
    }
}
