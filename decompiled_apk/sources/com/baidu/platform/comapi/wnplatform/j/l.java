package com.baidu.platform.comapi.wnplatform.j;

import android.os.Bundle;
import android.os.Handler;
import com.baidu.mapapi.walknavi.params.WalkNaviLaunchParam;
import com.baidu.mapsdkplatform.comapi.map.MessageCenter;
import com.baidu.platform.comapi.wnplatform.e.e;
import com.szabh.smable3.entity.Languages;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class l extends com.baidu.platform.comapi.walknavi.a {
    private List<f> c;
    private List<g> d;
    private Handler h;

    /* renamed from: a, reason: collision with root package name */
    private g f9929a = null;
    private e b = null;
    private int e = 1;
    private int f = 0;
    private boolean g = false;

    public l() {
        m mVar = new m(this);
        this.h = mVar;
        MessageCenter.registMessage(2008, mVar);
        MessageCenter.registMessage(4099, this.h);
        d();
    }

    private void d() {
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        MessageCenter.unregistMessage(4099, this.h);
        MessageCenter.unregistMessage(2008, this.h);
        this.f9929a = null;
        this.d = null;
        this.b = null;
        this.g = false;
        this.h = null;
    }

    public com.baidu.platform.comapi.wnplatform.e.a b() {
        return com.baidu.platform.comapi.walknavi.b.a().K().n();
    }

    public void c() {
        com.baidu.platform.comapi.walknavi.b.a().K().c();
    }

    public void b(g gVar) {
        List<g> list = this.d;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.d.remove(gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle a(int i) {
        return com.baidu.platform.comapi.walknavi.b.a().K().b(i);
    }

    public com.baidu.platform.comapi.wnplatform.e.a a() {
        if (this.f != 0) {
            return com.baidu.platform.comapi.walknavi.b.a().K().a(this.f);
        }
        return null;
    }

    public void b(f fVar) {
        List<f> list = this.c;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.c.remove(fVar);
    }

    private String b(WalkNaviLaunchParam walkNaviLaunchParam) {
        com.baidu.platform.comapi.wnplatform.e.e eVar = new com.baidu.platform.comapi.wnplatform.e.e();
        eVar.a("qt", "walkplan");
        eVar.a("sn", walkNaviLaunchParam.getStartNodeInfo().toQuery());
        eVar.a(Languages.DEFAULT_LANGUAGE, walkNaviLaunchParam.getEndNodeInfo().toQuery());
        eVar.a("run", 0);
        eVar.a("mt_rt", -1);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < walkNaviLaunchParam.getViaNodes().size(); i++) {
            try {
                jSONArray.put(new JSONObject(walkNaviLaunchParam.getViaNodes().get(i).toQuery()));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (jSONArray.length() != 0) {
            eVar.a("wp", jSONArray.toString());
        }
        int citycode = walkNaviLaunchParam.getStartNodeInfo().getCitycode();
        if (citycode != -1) {
            eVar.a("c", 131);
            eVar.a("sc", citycode);
        }
        int citycode2 = walkNaviLaunchParam.getEndNodeInfo().getCitycode();
        if (citycode2 != -1) {
            eVar.a("ec", citycode2);
        }
        eVar.a("version", 6);
        eVar.a("rp_format", "pb");
        eVar.a("from_navi", 0);
        eVar.a("spath_type", 1);
        eVar.b(13);
        eVar.a(true);
        eVar.b(false);
        eVar.a(e.a.PROTOBUF);
        eVar.a(e.b.GET);
        eVar.a(208);
        return eVar.toString();
    }

    public void a(g gVar) {
        if (gVar != null) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            if (this.d.contains(gVar)) {
                return;
            }
            this.d.add(gVar);
        }
    }

    public void a(f fVar) {
        if (fVar != null) {
            if (this.c == null) {
                this.c = new ArrayList();
            }
            if (this.c.contains(fVar)) {
                return;
            }
            this.c.add(fVar);
        }
    }

    public boolean a(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        return com.baidu.platform.comapi.walknavi.b.a().K().a(iArr, iArr2, iArr3, iArr4);
    }

    public boolean a(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, String[] strArr, String[] strArr2) {
        return com.baidu.platform.comapi.walknavi.b.a().K().a(iArr, iArr2, iArr3, iArr4, strArr, strArr2);
    }

    public int a(int i, int i2, int i3, int i4, byte[] bArr) {
        List<g> list = this.d;
        if (list != null && list.size() > 0) {
            Iterator<g> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
        return com.baidu.platform.comapi.walknavi.b.a().K().a(i, i2, i3, i4, bArr);
    }

    public int a(WalkNaviLaunchParam walkNaviLaunchParam) {
        List<f> list = this.c;
        if (list != null && list.size() > 0) {
            Iterator<f> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
        this.f = com.baidu.platform.comapi.walknavi.b.a().K().a(b(walkNaviLaunchParam));
        return 0;
    }
}
