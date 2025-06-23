package com.baidu.mapsdkplatform.comapi.map.a;

import com.baidu.platform.comapi.map.InnerOverlay;
import com.baidu.platform.comapi.map.i;
import com.baidu.platform.comapi.util.JsonBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class a extends InnerOverlay {

    /* renamed from: a, reason: collision with root package name */
    public final List<i> f6169a;
    private boolean d;
    private int e;
    private int f;
    private int g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;

    public a() {
        super(36);
        this.d = false;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = true;
        this.i = false;
        this.j = false;
        this.f6169a = new ArrayList();
        this.k = true;
    }

    public boolean a(i iVar) {
        synchronized (this.f6169a) {
            try {
                if (this.f6169a.contains(iVar)) {
                    return false;
                }
                boolean add = this.f6169a.add(iVar);
                this.k = add;
                return add;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b(boolean z) {
        this.i = z;
    }

    public boolean c() {
        return this.j;
    }

    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public void clear() {
        this.i = false;
        this.j = false;
        synchronized (this.f6169a) {
            this.f6169a.clear();
        }
        super.clear();
    }

    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public String getData() {
        if (this.k) {
            synchronized (this.f6169a) {
                try {
                    if (this.f6169a.size() == 0) {
                        return "";
                    }
                    JsonBuilder jsonBuilder = new JsonBuilder();
                    jsonBuilder.object();
                    if (this.j) {
                        jsonBuilder.key("statuschange").value(1);
                        jsonBuilder.key("onpause").value(this.i ? 1 : 0);
                        jsonBuilder.endObject();
                        setData(jsonBuilder.getJson());
                        this.k = false;
                        return super.getData();
                    }
                    jsonBuilder.key("dataset").arrayValue();
                    Iterator<i> it = this.f6169a.iterator();
                    while (it.hasNext()) {
                        jsonBuilder.objectValue(it.next().a());
                    }
                    jsonBuilder.endArrayValue();
                    jsonBuilder.key("startValue").value(0);
                    jsonBuilder.key("endValue").value(1);
                    if (this.d) {
                        jsonBuilder.key("isNeedRouteAnimate").value(1);
                        jsonBuilder.key("durationTime").value(this.e);
                        jsonBuilder.key("delayTime").value(this.f);
                        jsonBuilder.key("easingCurve").value(this.g);
                        this.d = false;
                    } else {
                        jsonBuilder.key("isNeedRouteAnimate").value(0);
                        jsonBuilder.key("durationTime").value(0);
                        jsonBuilder.key("delayTime").value(0);
                        jsonBuilder.key("easingCurve").value(0);
                    }
                    if (this.h) {
                        jsonBuilder.key("isRotateWhenTrack").value(1);
                    } else {
                        jsonBuilder.key("isRotateWhenTrack").value(0);
                    }
                    jsonBuilder.endObject();
                    setData(jsonBuilder.getJson());
                    this.k = false;
                } finally {
                }
            }
        }
        return super.getData();
    }

    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public void setData(String str) {
        super.setData(str);
        this.k = true;
    }

    public boolean b() {
        return this.i;
    }

    public void c(boolean z) {
        this.j = z;
    }

    public void a() {
        this.k = true;
        UpdateOverlay();
    }

    public void a(boolean z, int i, int i2, int i3) {
        this.d = z;
        this.e = i;
        this.f = i2;
        this.g = i3;
    }

    public void a(boolean z) {
        this.h = z;
    }
}
