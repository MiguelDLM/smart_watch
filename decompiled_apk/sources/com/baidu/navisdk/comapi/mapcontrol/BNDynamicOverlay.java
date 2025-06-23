package com.baidu.navisdk.comapi.mapcontrol;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.navisdk.model.datastruct.b;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.map.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes7.dex */
public class BNDynamicOverlay {
    private static final String TAG = "BNDynamicMap";
    private j mMapController;
    private final List<OnClickListener> mOnClickedListenerList = new CopyOnWriteArrayList();

    /* loaded from: classes7.dex */
    public interface ExtraType {
        public static final int Car = 1;
        public static final int EndNode = 4;
        public static final int Route = 5;
        public static final int StartNode = 2;
        public static final int ViaNode = 3;
    }

    /* loaded from: classes7.dex */
    public interface Key {
        public static final int ACE_CUR_STALL_BUBBLE = 972;
        public static final int ACE_RECOMMEND_STALL_BUBBLE = 900;
        public static final int ACE_REC_PARK_LAYER = 974;
        public static final int DEST_RECOMMEND_NAVI_TIP = 10023;
        public static final int DEST_RECOMMEND_POI = 10022;
        public static final int DEST_REC_LAYER = 989;
        public static final int MOSS_TIP_BUBBLE = 991;
        public static final int NAVI_MAY_STOP_BUBBLE_LAYER = 985;
        public static final int NEW_ENG_CHARGE_MAP_LAYER = 988;
        public static final int NE_APPROACH_BUBBLE = 100;
        public static final int NE_CHARGE_DRAW_LINE = 982;
        public static final int NE_CHARGING_END_BUBBLE = 997;
        public static final int NE_CHARGING_STATION = 996;
        public static final int NE_LIGHT_CIRCLE = 984;
        public static final int ROUTE_ACE_BUBBLE = 978;
        public static final int ROUTE_AROUND_NE_CS_BUBBLE = 994;
        public static final int ROUTE_END_ICON = 101;
        public static final int ROUTE_END_NAME = 990;
        public static final int ROUTE_EXPLAIN = 999;
        public static final int ROUTE_EXPLAIN_BUBBLE = 992;
        public static final int ROUTE_TRIP_NAVI_TIP = 993;
        public static final int SERVICE_AREA_ADD_VIA = 986;
    }

    /* loaded from: classes7.dex */
    public interface OnClickListener {
        void onClicked(int i, int i2, String str, @NonNull MapItem mapItem);
    }

    /* loaded from: classes7.dex */
    public interface Type {
        public static final int All = 1;
        public static final int No = 0;
        public static final int Route = 2;
        public static final int Whitelist = 3;
    }

    private void focusBySid(int i, int i2, String[] strArr) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "focusBySid --> key:" + i + " type:" + i2 + " ids:" + Arrays.toString(strArr));
        }
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.a(i, i2, strArr);
    }

    private void show(int i, int i2, long[] jArr) {
        show(i, i2, jArr, null);
    }

    private void showBySid(int i, int i2, String[] strArr) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "showBySid --> key:" + i + " type:" + i2 + " ids:" + Arrays.toString(strArr));
        }
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.b(i, i2, strArr);
    }

    public void addClickedListener(OnClickListener onClickListener) {
        if (this.mOnClickedListenerList.contains(onClickListener)) {
            return;
        }
        this.mOnClickedListenerList.add(onClickListener);
    }

    public void cancelFocusAll(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "cancelFocusAll --> key:" + i);
        }
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.a(i, 0, (long[]) null);
    }

    public void cancelFocusAllBySid(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "cancelFocusAllBySid --> key = " + i);
        }
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.a(i, 0, (String[]) null);
    }

    public void cancelFocusIds(int i, long... jArr) {
        focus(i, 0, jArr);
    }

    public void cancelFocusIdsBySid(int i, String... strArr) {
        focusBySid(i, 0, strArr);
    }

    public void cancelZoom(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "cancelZoom --> key = " + i);
        }
        zoom(i, 0, null, null);
    }

    public void cancelZoomBySid(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "cancelZoomBySid --> key = " + i);
        }
        zoomBySid(i, 0, null, null);
    }

    public void clear(int i) {
        setDataSet(i, (List<b>) new ArrayList());
    }

    public void focus(int i, int i2, long[] jArr) {
        focus(i, i2, jArr, null);
    }

    public void focusAll(int i) {
        focus(i, 1, null);
    }

    public void focusAllBySid(int i) {
        focusBySid(i, 1, null);
    }

    public void focusIds(int i, long... jArr) {
        focus(i, 3, jArr);
    }

    public void focusIdsBySid(int i, String... strArr) {
        focusBySid(i, 3, strArr);
    }

    public void hideAll(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "hideAll --> key = " + i);
        }
        show(i, 0, null);
    }

    public void hideAllBySid(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "hideAllBySid --> key = " + i);
        }
        showBySid(i, 0, null);
    }

    public void onClicked(@NonNull MapItem mapItem) {
        Iterator<OnClickListener> it = this.mOnClickedListenerList.iterator();
        while (it.hasNext()) {
            it.next().onClicked(mapItem.mBzid, mapItem.mItemID, mapItem.mItemSID, mapItem);
        }
    }

    public void removeClickedListener(OnClickListener onClickListener) {
        this.mOnClickedListenerList.remove(onClickListener);
    }

    public void setDataSet(int i, List<b> list) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "setDataSet --> key = " + i + " dataSet:" + list.toString());
        }
        if (this.mMapController == null) {
            return;
        }
        ArrayList<Bundle> arrayList = new ArrayList<>();
        Iterator<b> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().a());
        }
        this.mMapController.a(i, arrayList);
    }

    public boolean setDynamicLayerShowKeys(int... iArr) {
        if (this.mMapController == null) {
            g.MAP.c(TAG, "mMapController is null");
            return false;
        }
        g gVar = g.MAP;
        if (gVar.d()) {
            gVar.e(TAG, "setDynamicLayerShowKeys --> keys = " + Arrays.toString(iArr));
        }
        return this.mMapController.a(iArr);
    }

    public void setMapController(j jVar) {
        this.mMapController = jVar;
    }

    public void showAll(int i) {
        show(i, 1, null);
    }

    public void showAllBySid(int i) {
        showBySid(i, 1, null);
    }

    public void showIds(int i, long... jArr) {
        show(i, 3, jArr);
    }

    public void showIdsBySid(int i, String... strArr) {
        showBySid(i, 3, strArr);
    }

    public void unInit() {
        this.mMapController = null;
    }

    public void zoom(int i, int i2, long[] jArr, int[] iArr) {
        zoom(i, i2, jArr, iArr, 3, 21);
    }

    public void zoomAll(int i) {
        zoom(i, 1, null, null);
    }

    public void zoomAllBySid(int i) {
        zoomBySid(i, 1, null, null);
    }

    public void zoomBySid(int i, int i2, String[] strArr, int[] iArr) {
        zoomBySid(i, i2, strArr, iArr, 3, 21);
    }

    public void zoomIds(int i, long... jArr) {
        zoom(i, 3, jArr, null);
    }

    public void zoomIdsBySid(int i, String... strArr) {
        zoomBySid(i, 3, strArr, null);
    }

    public void cancelFocusIds(int i, long[] jArr, int[] iArr) {
        focus(i, 0, jArr, iArr);
    }

    public void focus(int i, int i2, long[] jArr, int[] iArr) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "focus --> key:" + i + " type:" + i2 + " ids:" + Arrays.toString(jArr) + " rIds:" + Arrays.toString(iArr));
        }
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.a(i, i2, jArr, iArr);
    }

    public void show(int i, int i2, long[] jArr, int[] iArr) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "show --> key:" + i + " type:" + i2 + " ids:" + Arrays.toString(jArr) + " rIds:" + Arrays.toString(iArr));
        }
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.b(i, i2, jArr, iArr);
    }

    public void zoom(int i, int i2, long[] jArr, int[] iArr, int i3, int i4) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "zoom --> key:" + i + " type:" + i2 + " ids:" + Arrays.toString(jArr) + " extraTypes:" + Arrays.toString(iArr) + " minLevel:" + i3 + " maxLevel:" + i4);
        }
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.a(i, i2, jArr, iArr, i3, i4);
    }

    public void zoomAll(int i, int i2, int i3) {
        zoom(i, 1, null, null, i2, i3);
    }

    public void zoomAllBySid(int i, int i2, int i3) {
        zoomBySid(i, 1, null, null, i2, i3);
    }

    public void zoomBySid(int i, int i2, String[] strArr, int[] iArr, int i3, int i4) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "zoomBySid --> key:" + i + " type:" + i2 + " ids:" + Arrays.toString(strArr) + " extraTypes:" + Arrays.toString(iArr) + " minLevel:" + i3 + " maxLevel:" + i4);
        }
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.a(i, i2, strArr, iArr, i3, i4);
    }

    public void zoomIds(int i, int i2, int i3, long... jArr) {
        zoom(i, 3, jArr, null, i2, i3);
    }

    public void zoomIdsBySid(int i, int i2, int i3, String... strArr) {
        zoomBySid(i, 3, strArr, null, i2, i3);
    }

    public void cancelZoom(int i, int i2, int i3) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "cancelZoom2 --> key = " + i);
        }
        zoom(i, 0, null, null, i2, i3);
    }

    public void cancelZoomBySid(int i, int i2, int i3) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "cancelZoomBySid2 --> key = " + i);
        }
        zoomBySid(i, 0, null, null, i2, i3);
    }

    public void setDataSet(int i, ArrayList<Bundle> arrayList) {
        this.mMapController.a(i, arrayList);
    }
}
