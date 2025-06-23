package com.baidu.mapsdkplatform.comapi.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.graphics.Point;
import android.view.animation.Interpolator;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;

/* loaded from: classes7.dex */
public class l extends c {

    /* renamed from: a, reason: collision with root package name */
    private Animator f6139a = null;
    private long b = 0;
    private Interpolator c = null;
    private TypeEvaluator d = null;
    private Animation.AnimationListener e = null;
    private int f = 1;
    private int g = 0;
    private Object[] h;

    @TargetApi(11)
    /* loaded from: classes7.dex */
    public class a implements TypeEvaluator {
        public a() {
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float f, Object obj, Object obj2) {
            LatLng latLng = (LatLng) obj;
            LatLng latLng2 = (LatLng) obj2;
            double d = latLng.longitude;
            double d2 = f;
            double d3 = d + ((latLng2.longitude - d) * d2);
            double d4 = latLng.latitude;
            return new LatLng(d4 + (d2 * (latLng2.latitude - d4)), d3);
        }
    }

    @TargetApi(11)
    /* loaded from: classes7.dex */
    public class b implements TypeEvaluator {
        public b() {
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float f, Object obj, Object obj2) {
            Point point = (Point) obj;
            Point point2 = (Point) obj2;
            return new Point((int) (point.x + ((point2.x - r0) * f)), (int) (point.y + (f * (point2.y - r5))));
        }
    }

    public l(LatLng... latLngArr) {
        this.h = latLngArr;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void b(int i) {
        if (i > 0 || i == -1) {
            this.g = i;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void c(int i) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(long j) {
        if (j < 0) {
            j = 0;
        }
        this.b = j;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void b() {
        Animator animator = this.f6139a;
        if (animator != null) {
            animator.cancel();
            this.f6139a = null;
        }
    }

    public int c() {
        return this.f;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Interpolator interpolator) {
        this.c = interpolator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(TypeEvaluator typeEvaluator) {
        this.d = typeEvaluator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(int i) {
        this.f = i;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Animation.AnimationListener animationListener) {
        this.e = animationListener;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Marker marker, Animation animation) {
        ObjectAnimator a2 = a(marker);
        this.f6139a = a2;
        a(a2);
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a() {
        Animator animator = this.f6139a;
        if (animator == null) {
            return;
        }
        animator.start();
    }

    public l(Point... pointArr) {
        this.h = pointArr;
    }

    @TargetApi(11)
    public ObjectAnimator a(Marker marker) {
        ObjectAnimator ofObject;
        if (marker.isFixed()) {
            if (this.h[0] instanceof Point) {
                ofObject = ObjectAnimator.ofObject(marker, "fixedScreenPosition", new b(), this.h);
            } else {
                throw new ClassCastException("BDMapSDKException: if the marker is fixed on screen, the parameters of Transformation must be android.graphics.Point");
            }
        } else {
            Object[] objArr = this.h;
            if (objArr[0] instanceof LatLng) {
                TypeEvaluator typeEvaluator = this.d;
                if (typeEvaluator != null) {
                    ofObject = ObjectAnimator.ofObject(marker, RequestParameters.POSITION, typeEvaluator, objArr);
                } else {
                    ofObject = ObjectAnimator.ofObject(marker, RequestParameters.POSITION, new a(), this.h);
                }
            } else {
                throw new ClassCastException("BDMapSDKException: if the marker isn't fixed on screen, the parameters of Transformation must be Latlng");
            }
        }
        if (ofObject != null) {
            ofObject.setRepeatCount(this.g);
            ofObject.setRepeatMode(c());
            ofObject.setDuration(this.b);
            Interpolator interpolator = this.c;
            if (interpolator != null) {
                ofObject.setInterpolator(interpolator);
            }
        }
        return ofObject;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Animator animator) {
        if (animator == null) {
            return;
        }
        animator.addListener(new m(this));
    }
}
