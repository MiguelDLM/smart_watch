package com.baidu.mapapi.map.offline;

import com.baidu.mapsdkplatform.comapi.map.i;
import com.baidu.mapsdkplatform.comapi.map.m;
import com.baidu.mapsdkplatform.comapi.map.n;
import com.baidu.mapsdkplatform.comapi.map.p;
import com.baidu.mapsdkplatform.comapi.map.q;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.platform.comapi.logstatistics.SDKLogFactory;
import com.vtrump.vtble.Oxx0IOOO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class MKOfflineMap {
    public static final int TYPE_DOWNLOAD_UPDATE = 0;
    public static final int TYPE_NETWORK_ERROR = 2;
    public static final int TYPE_NEW_OFFLINE = 6;
    public static final int TYPE_VER_UPDATE = 4;

    /* renamed from: a, reason: collision with root package name */
    private static final String f5907a = "MKOfflineMap";
    private n b;
    private MKOfflineMapListener c;

    public void destroy() {
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "OFF", "1", null);
        this.b.d(0);
        this.b.b((r) null);
        this.b.b();
        i.b();
    }

    public ArrayList<MKOLUpdateElement> getAllUpdateInfo() {
        ArrayList<q> e = this.b.e();
        if (e == null) {
            return null;
        }
        ArrayList<MKOLUpdateElement> arrayList = new ArrayList<>();
        Iterator<q> it = e.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getUpdatElementFromLocalMapElement(it.next().a()));
        }
        return arrayList;
    }

    public ArrayList<MKOLSearchRecord> getHotCityList() {
        ArrayList<m> c = this.b.c();
        if (c == null) {
            return null;
        }
        ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
        Iterator<m> it = c.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo(it.next()));
        }
        return arrayList;
    }

    public ArrayList<MKOLSearchRecord> getOfflineCityList() {
        ArrayList<m> d = this.b.d();
        if (d == null) {
            return null;
        }
        ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
        Iterator<m> it = d.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo(it.next()));
        }
        return arrayList;
    }

    public MKOLUpdateElement getUpdateInfo(int i) {
        q g = this.b.g(i);
        if (g == null) {
            return null;
        }
        return OfflineMapUtil.getUpdatElementFromLocalMapElement(g.a());
    }

    @Deprecated
    public int importOfflineData() {
        return importOfflineData(false);
    }

    public boolean init(MKOfflineMapListener mKOfflineMapListener) {
        i.a();
        n a2 = n.a();
        this.b = a2;
        if (a2 == null) {
            return false;
        }
        a2.a(new a(this));
        this.c = mKOfflineMapListener;
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "OFF", "0", null);
        return true;
    }

    public boolean pause(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(Oxx0IOOO.f27277xI, Integer.valueOf(i));
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "OFF", "4", hashMap);
        return this.b.c(i);
    }

    public boolean remove(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(Oxx0IOOO.f27277xI, Integer.valueOf(i));
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "OFF", "5", hashMap);
        return this.b.e(i);
    }

    public ArrayList<MKOLSearchRecord> searchCity(String str) {
        ArrayList<m> a2 = this.b.a(str);
        if (a2 == null) {
            return null;
        }
        ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
        Iterator<m> it = a2.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo(it.next()));
        }
        return arrayList;
    }

    public boolean start(int i) {
        int i2;
        HashMap hashMap = new HashMap();
        if (this.b == null) {
            hashMap.put(Oxx0IOOO.f27277xI, "null");
            SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "OFF", "2", hashMap);
            return false;
        }
        hashMap.put(Oxx0IOOO.f27277xI, Integer.valueOf(i));
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "OFF", "2", hashMap);
        if (this.b.e() != null) {
            Iterator<q> it = this.b.e().iterator();
            while (it.hasNext()) {
                p pVar = it.next().f6191a;
                if (pVar.f6190a == i) {
                    if (!pVar.j && (i2 = pVar.l) != 2 && i2 != 3 && i2 != 6) {
                        return false;
                    }
                    return this.b.b(i);
                }
            }
        }
        return this.b.a(i);
    }

    public boolean update(int i) {
        HashMap hashMap = new HashMap();
        if (this.b == null) {
            hashMap.put(Oxx0IOOO.f27277xI, "null");
            SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "OFF", "3", hashMap);
            return false;
        }
        hashMap.put(Oxx0IOOO.f27277xI, Integer.valueOf(i));
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "OFF", "3", hashMap);
        if (this.b.e() != null) {
            Iterator<q> it = this.b.e().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                p pVar = it.next().f6191a;
                if (pVar.f6190a == i) {
                    if (pVar.j) {
                        return this.b.f(i);
                    }
                }
            }
        }
        return false;
    }

    @Deprecated
    public int importOfflineData(boolean z) {
        int i;
        int i2;
        ArrayList<q> e = this.b.e();
        if (e != null) {
            i = e.size();
            i2 = i;
        } else {
            i = 0;
            i2 = 0;
        }
        this.b.a(z, true);
        ArrayList<q> e2 = this.b.e();
        if (e2 != null) {
            i2 = e2.size();
        }
        return i2 - i;
    }
}
