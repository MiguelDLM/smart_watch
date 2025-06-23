package com.baidu.navisdk.module.newguide.settings;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.module.routepreference.j;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class h extends com.baidu.navisdk.ui.routeguide.repository.a {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<com.baidu.navisdk.module.newguide.settings.model.e> f7272a;
    private ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> b;
    private ArrayList<j> c;
    private MutableLiveData<ArrayList<com.baidu.navisdk.module.newguide.settings.model.e>> d = new MutableLiveData<>();
    private MutableLiveData<ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a>> e = new MutableLiveData<>();
    private MutableLiveData<ArrayList<j>> f = new MutableLiveData<>();

    @Nullable
    private com.baidu.navisdk.module.newguide.settings.model.e a(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingsRepository", "createGroupModel: " + i);
        }
        com.baidu.navisdk.module.newguide.settings.model.e eVar = new com.baidu.navisdk.module.newguide.settings.model.e();
        eVar.f7278a = i;
        if (i == 1) {
            eVar.b = "快捷功能";
            return eVar;
        }
        if (i == 2) {
            eVar.b = "导航路线";
            return eVar;
        }
        if (i == 3) {
            eVar.b = "导航语音";
            return eVar;
        }
        if (i == 4) {
            eVar.b = "导航显示";
            return eVar;
        }
        if (i == 5) {
            eVar.b = "辅助功能";
            if (com.baidu.navisdk.function.b.FUNC_ASSIST_ITEMS.a()) {
                return eVar;
            }
        }
        return null;
    }

    private static String g() {
        if (!com.baidu.navisdk.j.d()) {
            return "4&3&2&1&5";
        }
        return "1&2&4&3&&5";
    }

    private void h() {
        ArrayList<j> c = com.baidu.navisdk.module.routepreference.i.j().c();
        this.c = c;
        Iterator<j> it = c.iterator();
        while (it.hasNext()) {
            j next = it.next();
            next.d = next.a();
            next.c = next.c();
        }
        a(this.f, this.c);
    }

    private void i() {
        com.baidu.navisdk.module.newguide.settings.model.e a2;
        String proSettingGroupRank = BNCommSettingManager.getInstance().getProSettingGroupRank();
        if (TextUtils.isEmpty(proSettingGroupRank)) {
            proSettingGroupRank = g();
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingsRepository", "loadSettingGroup: " + proSettingGroupRank);
        }
        String[] split = proSettingGroupRank.split("&");
        if (split.length == 0) {
            if (gVar.c()) {
                gVar.c("RGSettingsRepository", "loadSettingGroup rankIds.length == 0");
                return;
            }
            return;
        }
        ArrayList<com.baidu.navisdk.module.newguide.settings.model.e> arrayList = this.f7272a;
        if (arrayList == null) {
            this.f7272a = new ArrayList<>(split.length);
        } else {
            arrayList.clear();
        }
        for (String str : split) {
            try {
                int parseInt = Integer.parseInt(str);
                if ((parseInt != 2 || com.baidu.navisdk.function.b.FUNC_SETTING_ROUTE_SORT.a()) && (a2 = a(parseInt)) != null) {
                    this.f7272a.add(a2);
                }
            } catch (Exception e) {
                if (com.baidu.navisdk.util.common.g.PRO_NAV.c()) {
                    com.baidu.navisdk.util.common.g.PRO_NAV.c("RGSettingsRepository", "loadSettingGroup: " + e.toString());
                }
            }
        }
        a(this.d, this.f7272a);
    }

    public LiveData<ArrayList<com.baidu.navisdk.module.newguide.settings.model.e>> b() {
        return this.d;
    }

    public LiveData<ArrayList<j>> c() {
        return this.f;
    }

    public LiveData<ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a>> d() {
        return this.e;
    }

    public void e() {
        i();
        f();
        h();
    }

    public void f() {
        ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> b = new com.baidu.navisdk.module.newguide.settings.shortcut.repository.a().b();
        if (!b.equals(this.b)) {
            this.b = b;
            a(this.e, b);
        }
    }

    public void a(ArrayList<com.baidu.navisdk.module.newguide.settings.model.e> arrayList) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingsRepository", "saveSettingGroupRank: " + arrayList);
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            sb.append(arrayList.get(i).f7278a);
            if (i != size - 1) {
                sb.append("&");
            }
        }
        String proSettingGroupRank = BNCommSettingManager.getInstance().getProSettingGroupRank();
        String sb2 = sb.toString();
        if (sb2.equals(proSettingGroupRank)) {
            return;
        }
        BNCommSettingManager.getInstance().saveProSettingGroupRank(sb2);
        this.f7272a = arrayList;
        a(this.d, arrayList);
    }

    public void a() {
        ArrayList<com.baidu.navisdk.module.newguide.settings.model.e> arrayList = this.f7272a;
        if (arrayList != null) {
            arrayList.clear();
            a(this.d, this.f7272a);
        }
        ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> arrayList2 = this.b;
        if (arrayList2 != null) {
            arrayList2.clear();
            a(this.e, this.b);
        }
        ArrayList<j> arrayList3 = this.c;
        if (arrayList3 != null) {
            arrayList3.clear();
            a(this.f, this.c);
        }
    }
}
