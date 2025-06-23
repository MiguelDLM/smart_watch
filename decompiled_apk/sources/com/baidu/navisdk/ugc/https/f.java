package com.baidu.navisdk.ugc.https;

import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.ugc.utils.h;
import com.baidu.navisdk.ugc.utils.j;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.v;
import com.baidu.navisdk.util.http.center.i;
import com.baidu.navisdk.util.http.center.l;
import com.baidu.nplatform.comapi.MapItem;
import com.huawei.openalliance.ad.constant.bb;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import o0oIxXOx.oO;

/* loaded from: classes8.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private List<l> f8198a = new ArrayList();
    private j b = new j();

    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private com.baidu.navisdk.util.http.center.e f8199a = new com.baidu.navisdk.util.http.center.e(true);

        private a() {
        }

        public static a b() {
            return new a();
        }

        private void c() {
            com.baidu.navisdk.util.http.center.e eVar = this.f8199a;
            if (eVar.d == null) {
                eVar.d = new HashMap<>(4, 1.0f);
            }
        }

        public a a(String str) {
            if (!TextUtils.isEmpty(str)) {
                c();
                this.f8199a.d.put("pic", new File(str));
            }
            return this;
        }

        public a b(String str) {
            if (!TextUtils.isEmpty(str)) {
                c();
                this.f8199a.d.put("screenshot_pic", new File(str));
            }
            return this;
        }

        public a c(String str) {
            if (!TextUtils.isEmpty(str)) {
                c();
                this.f8199a.d.put("voice", new File(str));
            }
            return this;
        }

        public a a(ArrayList<String> arrayList, f fVar) {
            if (arrayList != null && !arrayList.isEmpty()) {
                c();
                String str = null;
                for (int i = 0; i < arrayList.size(); i++) {
                    String str2 = arrayList.get(i);
                    if (!TextUtils.isEmpty(str2)) {
                        String str3 = "pic_" + i;
                        this.f8199a.d.put(str3, new File(str2));
                        str = TextUtils.isEmpty(str) ? str3 : str + "," + str3;
                    }
                }
                if (fVar != null) {
                    fVar.q(str);
                }
            }
            return this;
        }

        public com.baidu.navisdk.util.http.center.e a() {
            return this.f8199a;
        }
    }

    private f() {
        d();
    }

    private void d() {
        this.f8198a.add(new i(oO.f31192XO, d.a(0)));
        this.b.a(oO.f31192XO, 0);
        this.f8198a.add(new i("osv", a0.b));
        this.b.a("osv", a0.b);
        this.f8198a.add(new i("sv", a0.c));
        this.b.a("sv", a0.c);
        this.f8198a.add(new i("cuid", a0.e()));
        this.b.a("cuid", a0.e());
        String b = h.c.b();
        this.f8198a.add(new i("city_name", d.a(b)));
        this.b.a("city_name", b);
        String a2 = d.a(d.a());
        this.f8198a.add(new i("cityid", a2));
        this.b.a("cityid", a2);
        this.f8198a.add(new i(bb.G, a0.g()));
        this.b.a(bb.G, a0.g());
        com.baidu.navisdk.util.http.a.a(this.f8198a);
    }

    public static f f() {
        return new f();
    }

    public f A(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8198a.add(new i("to_point", str));
            this.b.a("to_point", str);
        }
        return this;
    }

    public f B(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8198a.add(new i("to_uid", str));
            this.b.a("to_uid", str);
        }
        return this;
    }

    public f C(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8198a.add(new i("user_point", str));
            this.b.a("user_point", str);
        }
        return this;
    }

    public f D(String str) {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule", "setVideoInfo: " + str);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f8198a.add(new i(bb.aO, str));
            this.b.a(bb.aO, str);
        }
        return this;
    }

    public f a(int i) {
        if (i > 0) {
            this.f8198a.add(new i("business_trigger", d.a(i)));
            this.b.a("business_trigger", i);
        }
        return this;
    }

    public f b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8198a.add(new i("contact", str));
            this.b.a("contact", str);
        }
        return this;
    }

    public f c(int i) {
        if (i >= 0) {
            this.f8198a.add(new i("detail_type", d.a(i)));
            this.b.a("detail_type", i);
        }
        return this;
    }

    public f e(int i) {
        if (i > 0) {
            this.f8198a.add(new i("id", d.a(i)));
            this.b.a("id", i);
        }
        return this;
    }

    public f g(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8198a.add(new i("from_point", str));
            this.b.a("from_point", str);
        }
        return this;
    }

    public f h(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8198a.add(new i("from_uid", str));
            this.b.a("from_uid", str);
        }
        return this;
    }

    public f i(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8198a.add(new i("guid", str));
            this.b.a("guid", str);
        }
        return this;
    }

    public f j(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8198a.add(new i("linkid", str));
            this.b.a("linkid", str);
        }
        return this;
    }

    public f k(int i) {
        if (i >= 0) {
            this.f8198a.add(new i("speed_limit", d.a(i)));
            this.b.a("speed_limit", i);
        }
        return this;
    }

    public f l(int i) {
        if (i >= 0) {
            this.f8198a.add(new i("supply", d.a(i)));
            this.b.a("supply", i);
        }
        return this;
    }

    public f m(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8198a.add(new i("mrsl", str));
            this.b.a("mrsl", str);
        }
        return this;
    }

    public f n(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8198a.add(new i("name", str));
            this.b.a("name", str);
        }
        return this;
    }

    public f o(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8198a.add(new i("parent_type", str));
            this.b.a("parent_type", str);
        }
        return this;
    }

    public f p(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8198a.add(new i("photo_point", str));
            this.b.a("photo_point", str);
        }
        return this;
    }

    public f q(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8198a.add(new i("pic_keys", str));
            this.b.a("pic_keys", str);
        }
        return this;
    }

    public f r(String str) {
        if (str != null) {
            this.f8198a.add(new i("point", str));
            this.b.a("point", str);
        }
        return this;
    }

    public f s(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8198a.add(new i("road_name", str));
            this.b.a("road_name", str);
        }
        return this;
    }

    public f t(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8198a.add(new i("session_id", str));
            this.b.a("session_id", str);
        }
        return this;
    }

    public f u(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8198a.add(new i("speech_id", str));
            this.b.a("speech_id", str);
        }
        return this;
    }

    public f v(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8198a.add(new i("start_name", str));
            this.b.a("start_name", str);
        }
        return this;
    }

    public f w(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8198a.add(new i("start_point", str));
            this.b.a("start_point", str);
        }
        return this;
    }

    public f x(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8198a.add(new i("sub_type", str));
            this.b.a("sub_type", str);
        }
        return this;
    }

    public f y(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8198a.add(new i("sug_word", str));
            this.b.a("sug_word", str);
        }
        return this;
    }

    public f z(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8198a.add(new i("to_name", str));
            this.b.a("to_name", str);
        }
        return this;
    }

    public f f(int i) {
        if (i >= 0) {
            this.f8198a.add(new i("is_change", d.a(i)));
            this.b.a("is_change", i);
        }
        return this;
    }

    public f e(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8198a.add(new i("event_id", str));
            this.b.a("event_id", str);
        }
        return this;
    }

    public f b(int i) {
        this.f8198a.add(new i("car_type", d.a(i)));
        this.b.a("car_type", i);
        return this;
    }

    public f g(int i) {
        if (i >= 0) {
            this.f8198a.add(new i("lane_type", d.a(i)));
            this.b.a("lane_type", i);
        }
        return this;
    }

    public f h(int i) {
        if (i >= 0) {
            this.f8198a.add(new i("mark", d.a(i)));
            this.b.a("mark", i);
        }
        return this;
    }

    public f i(int i) {
        if (i != -1) {
            this.f8198a.add(new i("report_way", i + ""));
            this.b.a("report_way", i + "");
        }
        return this;
    }

    public f j(int i) {
        this.f8198a.add(new i(MapItem.KEY_ITEM_SID, d.a(i)));
        this.b.a(MapItem.KEY_ITEM_SID, i);
        return this;
    }

    public f m(int i) {
        if (i >= 0) {
            this.f8198a.add(new i("ugc_supply", d.a(i)));
            this.b.a("ugc_supply", i);
        }
        return this;
    }

    public f a(String str) {
        if (str == null) {
            str = " ";
        }
        this.f8198a.add(new i("content", str));
        this.b.a("content", str);
        return this;
    }

    public f c(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8198a.add(new i("end_name", str));
            this.b.a("end_name", str);
        }
        return this;
    }

    public f k(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8198a.add(new i("linkid_short", str));
            this.b.a("linkid_short", str);
        }
        return this;
    }

    public f l(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8198a.add(new i("linkidx", str));
            this.b.a("linkidx", str);
        }
        return this;
    }

    private void e() {
        String a2 = com.baidu.navisdk.module.cloudconfig.d.a(this.f8198a);
        g gVar = g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule", "ascendingParams: " + a2);
        }
        this.f8198a.add(new i(HttpConstants.SIGN, JNITrajectoryControl.sInstance.getUrlParamsSign(a2)));
    }

    public f f(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8198a.add(new i("from_name", str));
            this.b.a("from_name", str);
        }
        return this;
    }

    public HashMap<String, String> a() {
        e();
        HashMap<String, String> a2 = com.baidu.navisdk.util.http.center.c.a(this.f8198a);
        this.f8198a.clear();
        if (g.UGC.d()) {
            a(a2);
        }
        return a2;
    }

    private void b(String str, String str2) {
        this.f8198a.add(new i(HttpConstants.SIGN, v.a(str + com.baidu.navisdk.module.cloudconfig.d.a(this.f8198a) + str2)));
    }

    public String c() {
        j jVar = this.b;
        return jVar != null ? jVar.toString() : "null";
    }

    public HashMap<String, String> b() {
        e();
        HashMap<String, String> a2 = com.baidu.navisdk.util.http.center.c.a(this.f8198a);
        this.f8198a.clear();
        return a2;
    }

    public HashMap<String, String> a(String str, String str2) {
        b(str, str2);
        HashMap<String, String> a2 = com.baidu.navisdk.util.http.center.c.a(this.f8198a);
        this.f8198a.clear();
        return a2;
    }

    private String b(HashMap<String, String> hashMap) {
        if (!hashMap.containsKey("user_point")) {
            return "user_point";
        }
        if (!hashMap.containsKey("point")) {
            return "point";
        }
        if (!hashMap.containsKey("business_trigger")) {
            return "business_trigger";
        }
        if (!hashMap.containsKey("parent_type")) {
            return "parent_type";
        }
        if (!hashMap.containsKey("osv")) {
            return "osv";
        }
        if (!hashMap.containsKey("sv")) {
            return "sv";
        }
        if (!hashMap.containsKey("cuid")) {
            return "cuid";
        }
        if (!hashMap.containsKey(HttpConstants.SIGN)) {
            return HttpConstants.SIGN;
        }
        if (hashMap.containsKey("zid")) {
            return null;
        }
        return "zid";
    }

    private void a(HashMap<String, String> hashMap) {
        String b = b(hashMap);
        g gVar = g.UGC;
        if (!gVar.b() || TextUtils.isEmpty(b)) {
            return;
        }
        gVar.b("UgcModule", "ugc 上报缺少必选参数 " + b);
        TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "注意：ugc上报缺少必选参数 " + b);
    }

    public f d(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8198a.add(new i("end_point", str));
            this.b.a("end_point", str);
        }
        return this;
    }

    public f d(int i) {
        if (i >= 0) {
            this.f8198a.add(new i("event_pass", d.a(i)));
            this.b.a("event_pass", i);
        }
        return this;
    }
}
