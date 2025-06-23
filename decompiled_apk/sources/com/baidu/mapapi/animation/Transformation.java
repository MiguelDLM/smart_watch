package com.baidu.mapapi.animation;

import android.graphics.Point;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.a.l;

/* loaded from: classes7.dex */
public class Transformation extends Animation {
    public Transformation(LatLng... latLngArr) {
        if (latLngArr != null && latLngArr.length != 0) {
            this.bdAnimation = new l(latLngArr);
            return;
        }
        throw new NullPointerException("BDMapSDKException: the latlngs is null");
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void cancel() {
        this.bdAnimation.b();
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.bdAnimation.a(animationListener);
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void setDuration(long j) {
        this.bdAnimation.a(j);
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void setInterpolator(Interpolator interpolator) {
        this.bdAnimation.a(interpolator);
    }

    public void setRepeatCount(int i) {
        this.bdAnimation.b(i);
    }

    public void setRepeatMode(Animation.RepeatMode repeatMode) {
        if (repeatMode == Animation.RepeatMode.RESTART) {
            this.bdAnimation.a(1);
        } else if (repeatMode == Animation.RepeatMode.REVERSE) {
            this.bdAnimation.a(2);
        }
    }

    public Transformation(Point... pointArr) {
        if (pointArr != null && pointArr.length != 0) {
            this.bdAnimation = new l(pointArr);
            return;
        }
        throw new NullPointerException("BDMapSDKException: the points is null");
    }
}
