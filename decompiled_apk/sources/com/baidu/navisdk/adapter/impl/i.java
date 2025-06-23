package com.baidu.navisdk.adapter.impl;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.baidu.navisdk.framework.b;
import com.baidu.navisdk.framework.interfaces.s;
import com.baidu.navisdk.module.init.c;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static i f6511a;

    /* loaded from: classes7.dex */
    public class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f6512a;

        public a(i iVar, Context context) {
            this.f6512a = context;
        }

        @Override // com.baidu.navisdk.framework.b.a
        public Bundle a(int i, int i2, Object obj, Object... objArr) {
            if (67 == i && 14 == i2) {
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a(new com.baidu.navcore.ui.c());
                return null;
            }
            if (19 == i) {
                com.baidu.navisdk.f.a().onFloatViewClicked();
                return null;
            }
            if (92 == i) {
                float a2 = com.baidu.navisdk.adapter.impl.base.mapsensor.b.c().a();
                Bundle bundle = new Bundle();
                bundle.putFloat("map_sensor_angle", a2);
                return bundle;
            }
            if (124 == i) {
                com.baidu.navcore.ui.b bVar = new com.baidu.navcore.ui.b();
                bVar.setArguments((Bundle) obj);
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a(bVar);
                return null;
            }
            if (125 == i) {
                com.baidu.navcore.ui.a aVar = new com.baidu.navcore.ui.a();
                aVar.setArguments((Bundle) obj);
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a(aVar);
                return null;
            }
            if (113 == i) {
                return new Bundle();
            }
            return null;
        }

        @Override // com.baidu.navisdk.framework.b.a
        public Object b(int i, int i2, Object obj, Object... objArr) {
            if (i == 130) {
                return new com.baidu.navisdk.e(com.baidu.navisdk.b.f().c());
            }
            return null;
        }

        @Override // com.baidu.navisdk.framework.b.a
        public boolean c(int i, int i2, Object obj, Object... objArr) {
            int checkSelfPermission;
            s l;
            if (i != 68) {
                if (i != 93) {
                    if (i != 98) {
                        if (i != 2021) {
                            if (i != 73) {
                                if (i == 74 && (l = com.baidu.navisdk.framework.interfaces.c.p().l()) != null && l.d0()) {
                                    return l.o();
                                }
                            } else {
                                s l2 = com.baidu.navisdk.framework.interfaces.c.p().l();
                                if (l2 != null && l2.d0()) {
                                    return l2.a((ArrayList) obj);
                                }
                            }
                        } else {
                            if (Build.VERSION.SDK_INT >= 23) {
                                try {
                                    checkSelfPermission = this.f6512a.checkSelfPermission(com.kuaishou.weapon.p0.g.g);
                                    if (checkSelfPermission != 0) {
                                        return false;
                                    }
                                    return true;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            return true;
                        }
                    } else {
                        if (!(obj instanceof JSONObject)) {
                            return false;
                        }
                        g.a().a((JSONObject) obj);
                        return true;
                    }
                } else if (obj instanceof com.baidu.navisdk.framework.interfaces.opendatasturct.b) {
                    g.a().a((com.baidu.navisdk.framework.interfaces.opendatasturct.b) obj);
                } else if (obj instanceof com.baidu.navisdk.framework.interfaces.opendatasturct.a) {
                    g.a().a((com.baidu.navisdk.framework.interfaces.opendatasturct.a) obj);
                }
                return false;
            }
            return BaiduNaviManager.d().a((String) obj);
        }
    }

    private i() {
    }

    public static i a() {
        if (f6511a == null) {
            f6511a = new i();
        }
        return f6511a;
    }

    public void a(Context context, String str, String str2, String str3, com.baidu.navisdk.framework.interfaces.b bVar) {
        com.baidu.navisdk.module.init.b.g().a(context, new c.a().a(str).b(str2).c(str3).d(com.baidu.navcore.a.d().c()).a(new com.baidu.navcore.http.e()).a(new com.baidu.navcore.http.f()).a(new com.baidu.navcore.http.b()).a(bVar).a(new a(this, context)).a());
    }
}
