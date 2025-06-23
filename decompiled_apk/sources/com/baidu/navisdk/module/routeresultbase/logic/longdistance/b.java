package com.baidu.navisdk.module.routeresultbase.logic.longdistance;

import XIXIX.OOXIXo;
import com.baidu.baidunavis.maplayer.e;
import com.baidu.baidunavis.maplayer.g;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    protected d f7511a;

    public b(d dVar) {
        this.f7511a = dVar;
    }

    public int a(long j, double d) {
        double d2 = d * e.k().d();
        if (d2 != OOXIXo.f3760XO) {
            return (int) (j / d2);
        }
        return 0;
    }

    public void a(ArrayList<g> arrayList) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("LongDistanceNaviModel", "showLongDistanceLayerInner --> passItems = " + arrayList + ", mTapListener = " + this.f7511a.k());
        }
        try {
            e.k().a(arrayList, this.f7511a.k());
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("LongDistanceNaviModel", "showLongDistanceLayerInner --> exception = " + e);
            }
        }
    }
}
