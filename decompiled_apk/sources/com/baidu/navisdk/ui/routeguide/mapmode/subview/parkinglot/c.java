package com.baidu.navisdk.ui.routeguide.mapmode.subview.parkinglot;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.datastruct.r;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes8.dex */
public class c {
    public static String a(int i) {
        switch (i) {
            case 10:
                return "地上";
            case 11:
                return "路边";
            case 12:
                return "室内";
            case 13:
                return "综合";
            default:
                return "";
        }
    }

    public static boolean b(r rVar) {
        return TextUtils.isEmpty(rVar.q) && TextUtils.isEmpty(a(rVar.p)) && TextUtils.isEmpty(a(rVar.r));
    }

    public static String a(boolean z) {
        if (z) {
            return "预约";
        }
        return null;
    }

    public static boolean a(r rVar) {
        return rVar.e < 0 && rVar.g <= 0 && TextUtils.isEmpty(rVar.n);
    }

    public static Drawable a(int i, boolean z) {
        if (i == 1) {
            if (z) {
                return JarUtils.getResources().getDrawable(R.drawable.nsdk_drawable_arrive_dest_park_two_blue);
            }
            return JarUtils.getResources().getDrawable(R.drawable.nsdk_drawable_arrive_dest_park_two_red);
        }
        if (i != 2) {
            if (z) {
                return JarUtils.getResources().getDrawable(R.drawable.nsdk_drawable_arrive_dest_park_one_blue);
            }
            return JarUtils.getResources().getDrawable(R.drawable.nsdk_drawable_arrive_dest_park_one_red);
        }
        if (z) {
            return JarUtils.getResources().getDrawable(R.drawable.nsdk_drawable_arrive_dest_park_three_blue);
        }
        return JarUtils.getResources().getDrawable(R.drawable.nsdk_drawable_arrive_dest_park_three_red);
    }

    public static int b(ArrayList<r> arrayList, boolean z) {
        int a2;
        int d;
        if (LogUtil.LOGGABLE) {
            LogUtil.printList("ParkingLotUtil", "getParkRecycleViewHeight", "destParkPoiList", arrayList);
            LogUtil.e("ParkingLotUtil", "getParkRecycleViewHeight() --> isOrientationPortrait = " + z);
        }
        int i = 0;
        int size = arrayList == null ? 0 : arrayList.size();
        if (z) {
            a2 = com.baidu.navisdk.pronavi.util.a.h.d();
        } else {
            a2 = com.baidu.navisdk.ui.routeguide.utils.a.f9151a.a();
        }
        int statusBarHeight = ((((a2 - ScreenUtil.getInstance().getStatusBarHeight(com.baidu.navisdk.framework.a.c().b())) - com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_48dp)) - com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_54dp)) - 2) - com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_4dp);
        if (arrayList != null) {
            Iterator<r> it = arrayList.iterator();
            while (it.hasNext()) {
                r next = it.next();
                if (!a(next) && !b(next)) {
                    d = com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_92dp);
                } else {
                    d = com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_70dp);
                }
                i += d + size;
            }
        }
        return Math.min(statusBarHeight, i);
    }

    public static int a(ArrayList<r> arrayList, boolean z) {
        return b(arrayList, z) + com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_48dp) + com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_50dp) + 2;
    }
}
