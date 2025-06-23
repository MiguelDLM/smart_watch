package com.baidu.platform.comapi.map;

import android.graphics.Point;
import android.view.MotionEvent;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes8.dex */
public interface ak {
    void a();

    void a(MotionEvent motionEvent);

    void a(com.baidu.mapsdkplatform.comapi.map.w wVar);

    void a(GeoPoint geoPoint);

    void a(String str);

    void a(GL10 gl10, com.baidu.mapsdkplatform.comapi.map.w wVar);

    void a(boolean z);

    void a(boolean z, int i);

    boolean a(Point point, Point point2, com.baidu.mapsdkplatform.comapi.map.w wVar);

    boolean a(Point point, com.baidu.mapsdkplatform.comapi.map.w wVar);

    boolean a(MotionEvent motionEvent, float f, float f2, com.baidu.mapsdkplatform.comapi.map.w wVar);

    void b();

    void b(com.baidu.mapsdkplatform.comapi.map.w wVar);

    void b(GeoPoint geoPoint);

    boolean b(Point point, Point point2, com.baidu.mapsdkplatform.comapi.map.w wVar);

    boolean b(String str);

    void c();

    void c(com.baidu.mapsdkplatform.comapi.map.w wVar);

    void c(GeoPoint geoPoint);

    boolean c(Point point, Point point2, com.baidu.mapsdkplatform.comapi.map.w wVar);

    void d();

    void d(GeoPoint geoPoint);

    boolean d(Point point, Point point2, com.baidu.mapsdkplatform.comapi.map.w wVar);

    void e(GeoPoint geoPoint);
}
