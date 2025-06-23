package com.baidu.navisdk.module.userclassification;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.v;
import com.baidu.navisdk.util.common.y;
import com.baidu.navisdk.util.http.center.i;
import com.baidu.navisdk.util.http.center.l;
import com.baidu.navisdk.vi.VDeviceAPI;
import com.baidu.nplatform.comapi.MapItem;
import com.kuaishou.weapon.p0.t;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import o0oIxXOx.oO;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: com.baidu.navisdk.module.userclassification.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0298a extends com.baidu.navisdk.util.worker.lite.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f7593a;
        final /* synthetic */ String b;
        final /* synthetic */ com.baidu.navisdk.module.userclassification.b c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0298a(String str, Context context, String str2, com.baidu.navisdk.module.userclassification.b bVar) {
            super(str);
            this.f7593a = context;
            this.b = str2;
            this.c = bVar;
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            a.this.b(this.f7593a, this.b, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@NonNull Context context, String str, @NonNull com.baidu.navisdk.module.userclassification.b bVar) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("CloudUserClassConfigResource", "requestCloudInner --> context = " + context + ", etag = " + str + ", callback = " + bVar);
        }
        if (!y.d(context)) {
            bVar.a(50000, (JSONObject) null);
            return;
        }
        com.baidu.navisdk.util.http.center.e eVar = new com.baidu.navisdk.util.http.center.e();
        eVar.f9300a = false;
        com.baidu.navisdk.util.http.center.b.a().b(com.baidu.navisdk.util.http.b.d().b("UserGroupConfig"), com.baidu.navisdk.util.http.center.c.a(a(str)), new b(this, bVar), eVar);
    }

    public boolean a(@NonNull Context context, String str, @NonNull com.baidu.navisdk.module.userclassification.b bVar) {
        com.baidu.navisdk.util.worker.lite.a.a((com.baidu.navisdk.util.worker.lite.b) new C0298a("CloudUserClassConfigResource::requestAllConfig", context, str, bVar), 10002);
        return true;
    }

    /* loaded from: classes7.dex */
    public class b extends com.baidu.navisdk.util.http.center.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.navisdk.module.userclassification.b f7594a;

        public b(a aVar, com.baidu.navisdk.module.userclassification.b bVar) {
            this.f7594a = bVar;
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str, Throwable th) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("CloudUserClassConfigResource", "requestCloudInner::onFailure --> statusCode = " + i + ", responseString = " + str + ", throwable = " + th);
            }
            this.f7594a.a(i, (JSONObject) null);
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("CloudUserClassConfigResource", "requestCloudInner::onSuccess --> statusCode = " + i + ", responseString = " + str);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject optJSONObject = jSONObject.optJSONObject("usergroup");
                if (jSONObject.optInt("errno") == 304) {
                    this.f7594a.a(304, optJSONObject);
                    c.b(optJSONObject);
                    return;
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
                if (optJSONObject2 == null) {
                    this.f7594a.a(40000, optJSONObject);
                    c.b(optJSONObject);
                } else {
                    this.f7594a.a(optJSONObject2, optJSONObject);
                    c.a(optJSONObject2);
                    c.b(optJSONObject);
                }
            } catch (Exception e) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("CloudUserClassConfigResource", "requestInner --> exception = " + e);
                }
                this.f7594a.a(30000, (JSONObject) null);
            }
        }
    }

    private List<l> a(String str) {
        String str2 = "";
        try {
            ArrayList arrayList = new ArrayList();
            StringBuffer stringBuffer = new StringBuffer();
            String str3 = a0.e() + "";
            arrayList.add(new i("cuid", str3));
            stringBuffer.append("cuid=");
            stringBuffer.append(URLEncoder.encode(str3, "utf-8"));
            arrayList.add(new i(MapItem.KEY_ITEM_SID, "1"));
            stringBuffer.append("&sid=");
            stringBuffer.append(URLEncoder.encode("1", "utf-8"));
            arrayList.add(new i(oO.f31192XO, "0"));
            stringBuffer.append("&os=");
            stringBuffer.append(URLEncoder.encode("0", "utf-8"));
            String str4 = a0.k() + "";
            arrayList.add(new i("sv", str4));
            stringBuffer.append("&sv=");
            stringBuffer.append(URLEncoder.encode(str4, "utf-8"));
            String str5 = a0.b + "";
            arrayList.add(new i("osv", str5));
            stringBuffer.append("&osv=");
            stringBuffer.append(URLEncoder.encode(str5, "utf-8"));
            String str6 = com.baidu.navisdk.framework.b.l() + "";
            arrayList.add(new i("cityid", str6));
            stringBuffer.append("&cityid=");
            stringBuffer.append(URLEncoder.encode(str6, "utf-8"));
            arrayList.add(new i("mb", VDeviceAPI.getPhoneType()));
            stringBuffer.append("&mb=");
            stringBuffer.append(URLEncoder.encode(VDeviceAPI.getPhoneType()));
            arrayList.add(new i("brand", a0.b()));
            stringBuffer.append("&brand=");
            stringBuffer.append(URLEncoder.encode(a0.b(), "utf-8"));
            String g = a0.g();
            arrayList.add(new i(t.r, g));
            stringBuffer.append("&pcn=");
            stringBuffer.append(URLEncoder.encode(g, "utf-8"));
            String str7 = com.baidu.navisdk.framework.b.e() + "";
            if (!str7.equals("null")) {
                str2 = str7;
            }
            arrayList.add(new i("bduss", str2));
            stringBuffer.append("&bduss=");
            stringBuffer.append(URLEncoder.encode(str2, "utf-8"));
            arrayList.add(new i("etag", str));
            stringBuffer.append("&etag=");
            stringBuffer.append(URLEncoder.encode(str, "utf-8"));
            com.baidu.navisdk.util.http.a.a(arrayList);
            String a2 = a(arrayList);
            LogUtil.e("CloudUserClassConfigResource", "getReqParam --> hasSign sign = " + a2);
            arrayList.add(new i(HttpConstants.SIGN, a2));
            stringBuffer.append("&sign=");
            stringBuffer.append(URLEncoder.encode(a2, "utf-8"));
            if (LogUtil.LOGGABLE) {
                LogUtil.e("CloudUserClassConfigResource", "getReqParam --> params = " + ((Object) stringBuffer));
            }
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String a(List<l> list) {
        return v.a("group" + com.baidu.navisdk.util.http.center.c.b(list) + "30e9cc480810c178406912cafbd2fd02");
    }
}
