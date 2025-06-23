package com.baidu.navisdk.yellowtipdata.model;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.github.appintro.AppIntroBaseFragmentKt;
import com.huawei.openalliance.ad.constant.bn;
import com.huawei.openalliance.ad.constant.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class a {
    private static final a i = new a();
    private C0519a[] e;

    /* renamed from: a, reason: collision with root package name */
    public int f9455a = 20;
    public String[] b = null;
    public CopyOnWriteArrayList<d> c = null;
    private String[] d = null;
    private SparseArray<d> f = null;
    private c g = null;
    private ArrayList<b> h = null;

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f9457a = -1;
        public String b;
        public int c;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f9457a != bVar.f9457a || this.c != bVar.c) {
                return false;
            }
            String str = this.b;
            String str2 = bVar.b;
            if (str != null) {
                return str.equals(str2);
            }
            if (str2 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int i2 = this.f9457a * 31;
            String str = this.b;
            if (str != null) {
                i = str.hashCode();
            } else {
                i = 0;
            }
            return ((i2 + i) * 31) + this.c;
        }

        public String toString() {
            return "GroupInfo{id=" + this.f9457a + ", name='" + this.b + "', size=" + this.c + '}';
        }
    }

    /* loaded from: classes8.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f9458a;
        public int b;
        public String c;
        public int d;
        public int e;

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("url:" + this.f9458a + x.aL);
            stringBuffer.append("icon:" + this.b + x.aL);
            stringBuffer.append("title:" + this.c + x.aL);
            stringBuffer.append("bgColor:" + this.d + x.aL);
            stringBuffer.append("show:" + this.e + x.aL);
            return stringBuffer.toString();
        }
    }

    /* loaded from: classes8.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private int f9459a;
        private String b;
        private int c;
        private String d;
        private int e;
        private boolean f;
        private int g;
        private int h;
        private String i;
        private String j;
        private int k;
        private int l;

        public d() {
            this.k = -1;
            this.l = 0;
        }

        public String toString() {
            return "TipsType{type=" + this.f9459a + ", name='" + this.b + "', priority=" + this.c + ", text='" + this.d + "', innavi=" + this.e + ", isSpeedy=" + this.f + ", clickAction=" + this.g + ", navClickAction=" + this.h + ", confirmText='" + this.i + "', cancelText='" + this.j + "', groupId=" + this.k + ", previewClickType=" + this.l + '}';
        }

        public d a(boolean z) {
            this.f = z;
            return this;
        }

        public String b() {
            return this.i;
        }

        public d c(String str) {
            this.b = str;
            return this;
        }

        public d d(String str) {
            this.d = str;
            return this;
        }

        public d e(int i) {
            this.l = i;
            return this;
        }

        public d f(int i) {
            this.c = i;
            return this;
        }

        public d g(int i) {
            this.f9459a = i;
            return this;
        }

        public d a(int i) {
            this.g = i;
            return this;
        }

        public d b(String str) {
            this.i = str;
            if (this.f9459a == 39 && TextUtils.isEmpty(str)) {
                this.i = "换回";
            }
            return this;
        }

        public d c(int i) {
            this.e = i;
            return this;
        }

        public d d(int i) {
            this.h = i;
            return this;
        }

        public d(int i, String str, int i2, String str2, int i3) {
            this.k = -1;
            this.l = 0;
            this.f9459a = i;
            this.b = str;
            this.c = i2;
            this.d = str2;
            this.e = i3;
        }

        public String a() {
            return this.j;
        }

        public int c() {
            return this.h;
        }

        public d a(String str) {
            this.j = str;
            if (this.f9459a == 39 && TextUtils.isEmpty(str)) {
                this.j = "取消";
            }
            return this;
        }

        public d b(int i) {
            this.k = i;
            return this;
        }

        public d(int i, String str, int i2, String str2, int i3, boolean z) {
            this(i, str, i2, str2, i3);
            this.f = z;
        }

        public d(int i, String str, int i2, String str2, int i3, int i4, int i5, boolean z) {
            this(i, str, i2, str2, i3, z);
            this.g = i4;
            this.h = i5;
        }

        public d(int i, String str, int i2, String str2, int i3, int i4, int i5, String str3, String str4, boolean z) {
            this(i, str, i2, str2, i3, i4, i5, z);
            this.j = str3;
            this.i = str4;
        }
    }

    private a() {
    }

    private C0519a[] b(JSONObject jSONObject) {
        if (jSONObject.opt("routeExplainIcons") == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (jSONObject.opt("routeExplainIcons") instanceof JSONArray) {
            JSONArray optJSONArray = jSONObject.optJSONArray("routeExplainIcons");
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                if (optJSONArray.opt(i2) instanceof JSONObject) {
                    LogUtil.e("parseJson", "obj:" + optJSONArray.opt(i2));
                    arrayList.add(C0519a.a(((JSONObject) optJSONArray.opt(i2)).optString("url"), ((JSONObject) optJSONArray.opt(i2)).optInt("unique_style", 0) == 1));
                } else {
                    arrayList.add(C0519a.a(optJSONArray.optString(i2)));
                }
            }
        } else {
            JSONObject optJSONObject = jSONObject.optJSONObject("routeExplainIcons");
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (optJSONObject.opt(next) instanceof JSONObject) {
                    arrayList.add(C0519a.a(((JSONObject) optJSONObject.opt(next)).optString("url"), ((JSONObject) optJSONObject.opt(next)).optInt("unique_style", 0) == 1));
                } else {
                    arrayList.add(C0519a.a(optJSONObject.optString(next)));
                }
            }
        }
        return (C0519a[]) arrayList.toArray(new C0519a[arrayList.size()]);
    }

    public static a c() {
        return i;
    }

    private synchronized void d() {
        this.f9455a = 10;
        this.b = new String[]{"#FFFFFF", "#FFFFFF", "#F75B5B"};
        CopyOnWriteArrayList<d> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.c = copyOnWriteArrayList;
        copyOnWriteArrayList.add(new d(0, "在转离", 0, null, 0).b(0));
        this.c.add(new d(1, "离转在", 0, null, 0).b(0));
        this.c.add(new d(2, "网络连接中断", 0, null, 0, true).b(0));
        this.c.add(new d(3, "本地化车牌设置提示", 31, null, 0, true).e(3).b(2));
        this.c.add(new d(4, "本地化可以/无法避开提示", 20, null, 0, true).b(0).e(3));
        this.c.add(new d(5, "非官方云端干预信息", 20, null, 0).b(0).e(25));
        this.c.add(new d(6, "官方云端干预信息", 7, null, 0).b(0));
        this.c.add(new d(7, "躲避拥堵", 105, null, 0, true).b(1).e(25));
        this.c.add(new d(8, "路线雷达进入提示", 0, null, 0).b(1));
        this.c.add(new d(9, "轨迹路线提示", 10, null, 0));
        this.c.add(new d(10, "官方事故提醒", 115, null, 0, true).b(1).e(25));
        this.c.add(new d(11, "恶劣天气", 0, null, 0).b(1).e(5));
        this.c.add(new d(12, "长途服务区", 0, null, 0).b(1));
        this.c.add(new d(13, "终点纠错", 2, null, 0));
        this.c.add(new d(14, "轮渡提示", 61, null, 0).b(1).e(5));
        this.c.add(new d(15, "路线排序", 0, null, 0).b(0).e(5));
        this.c.add(new d(16, "离线优先", 0, null, 0).b(0));
        this.c.add(new d(17, "途径路小黄条", 0, null, 0).b(0));
        this.c.add(new d(18, "WIFI提示", 9, null, 0));
        this.c.add(new d(19, "离线数据实效小黄条", 0, null, 0).b(0));
        this.c.add(new d(20, "拥堵度提示", 101, null, 0).b(1).e(5));
        this.c.add(new d(21, "终点推荐", 51, null, 0).b(0));
        this.c.add(new d(22, "事故展示", 111, null, 0).b(1).e(25));
        this.c.add(new d(23, "运营小黄条", 18, null, 0).b(0).e(3));
        this.c.add(new d(24, "营业时间危险", 41, null, 0).b(1).e(5));
        this.c.add(new d(25, "营业时间关闭", 11, null, 0).b(0).e(5));
        this.c.add(new d(26, "灰度库提示", 71, null, 0).b(1).e(5));
        this.c.add(new d(27, "高速优先-无高速路线", 42, null, 0, true).b(2).e(5));
        this.c.add(new d(28, "高速优先-首条绕路", 42, null, 0, true).b(1).e(5));
        this.c.add(new d(29, "灰不走高速-都走高速", 42, null, 0, true).b(1).e(5));
        this.c.add(new d(30, "不走高速-起点在高速", 42, null, 0, true).b(1).e(5));
        this.c.add(new d(31, "非官方云端干预信息——已避开", 95, null, 1).b(1).e(25));
        this.c.add(new d(32, "ugc消息提醒", 0, null, 0).b(1).e(5));
        this.c.add(new d(33, "openapi小黄条", 21, null, 1).b(1).e(5));
        this.c.add(new d(34, "空载驶入小黄条", 55, null, 1).b(0).e(5));
        this.c.add(new d(35, "未来出行通用小黄条", 108, null, 0).b(0));
        this.c.add(new d(36, "深圳服务端运营小黄条", 141, null, 0).b(1).e(3));
        this.c.add(new d(37, "深国际化算路提示", 25, null, 0).b(1).e(5));
        this.c.add(new d(38, "停车难度预测", 138, null, 0).b(1));
        this.c.add(new d(39, "终点智能替换", 15, null, 1, 2, 2, true).a("取消").b("换回").e(3).b(0));
        this.c.add(new d(40, "高速费限时免费", 35, null, 0));
        this.c.add(new d(41, "终点 PGC 调度（不可点击）", 20, null, 1).b(0).e(5));
        this.c.add(new d(42, "驾车页收藏-路线排入top3", 35, null, 0).b(1).e(3));
        this.c.add(new d(43, "驾车页收藏-路线未排入top3", 36, null, 0).b(1).e(3));
        this.c.add(new d(44, "收藏夹-本地化可点击", 22, null, 0).b(0).e(3));
        this.c.add(new d(45, "收藏夹-收藏路线变化", 22, null, 0).b(1).e(5));
        this.c.add(new d(46, "极端路面状况预测", 33, null, 1).b(1).e(3));
        this.c.add(new d(47, "节假日高速免费提示小黄条", 108, null, 0, true).b(1).e(5));
        this.c.add(new d(48, "非车牌限行直跳提示", 15, null, 1, 2, 2, "取消", "可通行", false).b(0).e(3));
        this.c.add(new d(49, "购物中心子点引导", 51, null, 1, 2, 2, "取消", "商铺门前", false).b(1));
        this.c.add(new d(50, "路况预测", 101, null, 0).b(1).e(3));
        this.c.add(new d(51, "预上线已避开", 94, null, 1).b(1).e(25));
        this.c.add(new d(52, "预上线未避开", 20, null, 1).b(0).e(25));
        this.c.add(new d(53, "小路", 100, null, 1).b(1).e(25));
        this.c.add(new d(54, "路线全局解释", 102, null, 1));
        this.c.add(new d(55, "工商商业化项目", 300, null, 0).b(1).e(5));
        this.c.add(new d(56, "部分路线需要轮渡/步行，请合理安排出行", 103, null, 1, true).b(1));
        this.c.add(new d(57, "货车硬限已规避", 90, null, 1).b(1));
        this.c.add(new d(58, "货车硬限无法规避", 18, null, 1).b(0));
        this.c.add(new d(59, "货车软限已规避", 101, null, 1).b(1));
        this.c.add(new d(60, "货车软限无法规避", 50, null, 1).b(0));
        this.c.add(new d(61, "途径高架桥梁路段，请注意行车安全", 25, null, 0).b(1).e(25));
        this.c.add(new d(62, "外埠车辆需办理进京证，请提前办理", 350, null, 0, true).b(1).e(3));
        this.c.add(new d(63, "xx路（路面颠簸）/（路面未铺设）/（无路灯），已为您避开", 100, null, 1).b(1).e(25));
        this.c.add(new d(64, "导航保障运营黄条", 70, null, 0, true).e(3));
        this.c.add(new d(68, "无法规避通行证限行", 15, null, 0, 1, 0, false).b("去添加").e(3).b(0));
        this.c.add(new d(69, "已规避通行证限行", 22, null, 0, 1, 0, false).b("去添加").e(3).b(1));
        this.c.add(new d(70, "POI人流量提示", 71, null, 0, 0, 0, false).e(5).b(1));
        this.c.add(new d(71, "通行费预估提示", 65, null, 0, 0, 0, false).e(5).b(1));
        this.c.add(new d(72, "分时段交规/普通交规/紧急大门无法避开提示", 20, null, 0, 4, 0, false).e(25).b(0));
        this.c.add(new d(73, "非机动车道无法避开提示", 20, null, 0, 4, 0, false).e(25).b(0));
        this.c.add(new d(74, "窄路无法避开提示", 20, null, 0, 4, 0, false).e(25).b(0));
        this.c.add(new d(75, "颠簸无法避开提示", 20, null, 0, 4, 0, false).e(25).b(0));
        this.c.add(new d(76, "非机动车道避开提示", 32, null, 0, 4, 0, false).e(25).b(1));
        this.c.add(new d(77, "窄路避开提示", 32, null, 0, 4, 0, false).e(25).b(1));
        this.c.add(new d(78, "颠簸避开提示", 32, null, 0, 4, 0, false).e(25).b(1));
        this.c.add(new d(79, "跨多车道避开提示", 32, null, 0, 4, 0, false).e(25).b(1));
        this.c.add(new d(80, "避开个人熟路拥堵", 32, null, 0, 4, 0, false).e(25));
        this.c.add(new d(81, "避开常规路线拥堵", 32, null, 0, 4, 0, false).e(25));
        this.c.add(new d(82, "避开最短路线拥堵", 32, null, 0, 4, 0, false).e(25));
        this.c.add(new d(83, "避开紧急大门/分时段/普通交规", 32, null, 0, 4, 0, false).e(25));
        this.c.add(new d(84, "终点接驳步导", 32, null, 0, 4, 0, false).e(25));
        this.c.add(new d(85, "疑似阻断已避开", 32, null, 0, 4, 0, false).e(25));
        this.c.add(new d(86, "疑似阻断避不开", 32, null, 0, 4, 0, false).e(25));
        this.c.add(new d(97, "新手途经高速提示-新手运营位", 20, null, 0, 4, 0, false).e(25));
        this.c.add(new d(127, "ACE黄条-小度条", 70, null, 0, 4, 0, false).e(25));
        this.c.add(new d(133, "智慧高速-小黄条", 50, null, 0, 4, 0, false).e(25));
        this.c.add(new d(134, "新手模式非第一次展示-小黄条", 1, null, 0, 4, 0, false).e(25));
        this.c.add(new d(135, "自驾游-小黄条", 10, null, 0, 4, 0, false).e(25));
        this.c.add(new d(136, "新能源-小黄条", 30, null, 0, 4, 0, false).e(25));
        this.c.add(new d(137, "新手模式第一次展示-小黄条", 40, null, 0, 4, 0, false).e(25));
        this.c.add(new d(138, "智能停车", 60, null, 0, 4, 0, false).e(25));
        this.f = new SparseArray<>();
        Iterator<d> it = this.c.iterator();
        while (it.hasNext()) {
            d next = it.next();
            this.f.append(next.f9459a, next);
        }
    }

    private void e() {
        if (LogUtil.LOGGABLE) {
            SparseArray<d> sparseArray = this.f;
            if (sparseArray == null) {
                LogUtil.e("BNYellowBannerTipsModel", "printYBannerCloudConfig,mTipsTypeMap is null");
            } else if (sparseArray.size() < 1) {
                LogUtil.e("BNYellowBannerTipsModel", "printYBannerCloudConfig,mTipsTypeMap is empty");
            } else {
                LogUtil.e("BNYellowBannerTipsModel", "printYBannerCloudConfig,mTipsTypeMap:" + this.f.toString());
            }
            ArrayList<b> arrayList = this.h;
            if (arrayList == null) {
                LogUtil.e("BNYellowBannerTipsModel", "printYBannerCloudConfig,mGroupInfoList is null");
            } else if (arrayList.size() < 1) {
                LogUtil.e("BNYellowBannerTipsModel", "printYBannerCloudConfig,mGroupInfoList is empty");
            } else {
                LogUtil.e("BNYellowBannerTipsModel", "printYBannerCloudConfig,mGroupInfoList:" + Arrays.toString(this.h.toArray()));
            }
            C0519a[] c0519aArr = this.e;
            if (c0519aArr == null) {
                LogUtil.e("BNYellowBannerTipsModel", "printYBannerCloudConfig,mExplainIcons is null");
                return;
            }
            if (c0519aArr.length < 1) {
                LogUtil.e("BNYellowBannerTipsModel", "printYBannerCloudConfig,mExplainIcons is empty");
                return;
            }
            LogUtil.e("BNYellowBannerTipsModel", "printYBannerCloudConfig,mExplainIcons:" + Arrays.toString(this.e));
        }
    }

    private void f() {
        this.f9455a = 10;
        this.d = null;
        this.b = null;
        this.c = null;
        this.f = null;
        this.h = null;
        this.e = null;
        this.g = null;
    }

    private void g() {
        try {
            ArrayList arrayList = new ArrayList(this.c);
            int size = arrayList.size();
            int[] iArr = new int[size];
            int[] iArr2 = new int[size];
            int[] iArr3 = new int[size];
            for (int i2 = 0; i2 < size; i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar != null) {
                    iArr[i2] = dVar.f9459a;
                    iArr2[i2] = dVar.c;
                    iArr3[i2] = dVar.e;
                } else {
                    LogUtil.e("BNYellowBannerTipsModel", "setYBarTypeAndPriorityArray --> copyTipsType.get(" + i2 + ") is null!");
                }
            }
            JNIGuidanceControl.getInstance().setYBarTypeAndPriorityArray(1, iArr, iArr2, iArr3);
            JNIGuidanceControl.getInstance().setYBarTypeAndPriorityArray(2, iArr, iArr2, iArr3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void a(JSONObject jSONObject) {
        try {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("yellow_tips");
                this.f9455a = jSONObject2.getInt("expire_time");
                this.d = a(jSONObject2.getString("icons"));
                this.e = b(jSONObject2);
                this.b = a(jSONObject2.getString("bgcolors"));
                if (this.c == null) {
                    this.c = new CopyOnWriteArrayList<>();
                }
                if (this.f == null) {
                    this.f = new SparseArray<>();
                }
                JSONArray jSONArray = jSONObject2.getJSONArray("types");
                int i2 = 0;
                int i3 = 0;
                while (i3 < jSONArray.length()) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i3);
                    String string = jSONObject3.getString("priority");
                    String optString = jSONObject3.optString("innavi");
                    int optInt = jSONObject3.optInt("in_speedy");
                    int optInt2 = jSONObject3.optInt("clickAction");
                    int optInt3 = jSONObject3.optInt("group_id", -1);
                    int optInt4 = jSONObject3.optInt("previewClickAction", i2);
                    int optInt5 = jSONObject3.optInt("naviClickAction");
                    String optString2 = jSONObject3.optString("cancelText");
                    String optString3 = jSONObject3.optString("confirmText");
                    if (TextUtils.isEmpty(string)) {
                        string = "0";
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = "0";
                    }
                    int i4 = jSONObject3.getInt("type");
                    JSONArray jSONArray2 = jSONArray;
                    String string2 = jSONObject3.getString("name");
                    String str = optString;
                    String string3 = jSONObject3.getString("text");
                    String str2 = i4 == 46 ? "1" : str;
                    JSONObject jSONObject4 = jSONObject2;
                    d dVar = new d();
                    d c2 = dVar.g(i4).c(string2).f(Integer.parseInt(string)).d(string3).c(Integer.parseInt(str2));
                    boolean z = true;
                    if (optInt != 1) {
                        z = false;
                    }
                    c2.a(z).a(optInt2).d(optInt5).b(optString3).b(optInt3).e(optInt4).a(optString2);
                    this.c.add(dVar);
                    this.f.append(i4, dVar);
                    i3++;
                    jSONArray = jSONArray2;
                    jSONObject2 = jSONObject4;
                    i2 = 0;
                }
                JSONObject jSONObject5 = jSONObject2;
                if (jSONObject.optJSONObject("yellow_tips_h5") != null) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("yellow_tips_h5");
                    c cVar = new c();
                    this.g = cVar;
                    cVar.f9458a = optJSONObject.optString("url");
                    this.g.b = optJSONObject.optInt(x.cD);
                    this.g.d = optJSONObject.optInt(AppIntroBaseFragmentKt.ARG_BG_COLOR);
                    this.g.c = optJSONObject.optString("title");
                    this.g.e = optJSONObject.optInt(bn.b.V);
                }
                if (this.h == null) {
                    this.h = new ArrayList<>();
                }
                if (jSONObject5.optJSONArray("group_info") != null) {
                    JSONArray optJSONArray = jSONObject5.optJSONArray("group_info");
                    if (optJSONArray.length() > 0) {
                        for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i5);
                            if (optJSONObject2 != null) {
                                b bVar = new b();
                                bVar.f9457a = optJSONObject2.optInt(MapBundleKey.MapObjKey.OBJ_SL_INDEX);
                                bVar.b = optJSONObject2.optString("name");
                                this.h.add(bVar);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                f();
                e.printStackTrace();
            }
            e();
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean h(int i2) {
        if (this.f == null) {
            d();
        }
        d dVar = this.f.get(i2);
        if (dVar != null) {
            return dVar.f;
        }
        return false;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append("expireTime:" + this.f9455a + x.aL);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                String[] strArr = this.d;
                if (strArr == null || i3 >= strArr.length) {
                    break;
                }
                stringBuffer.append("icons" + i3 + ":" + this.d[i3] + x.aL);
                i3++;
            }
            int i4 = 0;
            while (true) {
                String[] strArr2 = this.b;
                if (strArr2 == null || i4 >= strArr2.length) {
                    break;
                }
                stringBuffer.append("bgcolors" + i4 + ":" + this.b[i4] + x.aL);
                i4++;
            }
            while (true) {
                CopyOnWriteArrayList<d> copyOnWriteArrayList = this.c;
                if (copyOnWriteArrayList == null || i2 >= copyOnWriteArrayList.size()) {
                    break;
                }
                stringBuffer.append("TipsTypeList" + i2 + ":" + this.c.get(i2).toString() + x.aL);
                i2++;
            }
        } catch (Exception unused) {
            LogUtil.e("Navi", "toString Exception");
        }
        return stringBuffer.toString();
    }

    public String c(int i2) {
        if (this.f == null) {
            d();
        }
        d dVar = this.f.get(i2);
        if (dVar != null) {
            return dVar.i;
        }
        return "确认";
    }

    /* renamed from: com.baidu.navisdk.yellowtipdata.model.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0519a {

        /* renamed from: a, reason: collision with root package name */
        private String f9456a;
        private boolean b;

        public static C0519a a(String str, boolean z) {
            C0519a c0519a = new C0519a();
            if (!TextUtils.isEmpty(str)) {
                str = str.replace("\"", "").replace("\\", "");
            }
            c0519a.f9456a = str;
            c0519a.b = z;
            return c0519a;
        }

        public String toString() {
            return "ExplainIcon{url='" + this.f9456a + "', uniqueStyle=" + this.b + '}';
        }

        public static C0519a a(String str) {
            C0519a c0519a = new C0519a();
            if (!TextUtils.isEmpty(str)) {
                str = str.replace("\"", "").replace("\\", "");
            }
            c0519a.f9456a = str;
            return c0519a;
        }
    }

    public int f(int i2) {
        if (this.f == null) {
            d();
        }
        d dVar = this.f.get(i2);
        if (dVar != null) {
            return dVar.c;
        }
        return Integer.MAX_VALUE;
    }

    public final d g(int i2) {
        if (this.f == null) {
            d();
        }
        return this.f.get(i2);
    }

    public int e(int i2) {
        if (this.f == null) {
            d();
        }
        d dVar = this.f.get(i2);
        if (dVar != null) {
            return dVar.l;
        }
        return 0;
    }

    public void b() {
        if (this.d == null || this.b == null || this.c == null) {
            d();
        }
        g();
        LogUtil.e("BNYellowBannerTipsModel:", toString());
    }

    public int b(int i2) {
        if (this.f == null) {
            d();
        }
        d dVar = this.f.get(i2);
        if (dVar != null) {
            return dVar.g;
        }
        return 0;
    }

    private String[] a(String str) {
        try {
            if (str.startsWith("[")) {
                str = str.substring(1);
            }
            if (str.endsWith("]")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str == null) {
                return null;
            }
            String[] split = str.split(",");
            for (int i2 = 0; i2 < split.length; i2++) {
                String replace = split[i2].replace("\"", "");
                split[i2] = replace;
                split[i2] = replace.replace("\\", "");
            }
            return split;
        } catch (Exception unused) {
            return null;
        }
    }

    public String[] a() {
        return this.d;
    }

    public String a(int i2) {
        if (this.f == null) {
            d();
        }
        d dVar = this.f.get(i2);
        if (dVar != null) {
            return dVar.j;
        }
        return "取消";
    }

    public int d(int i2) {
        if (this.f == null) {
            d();
        }
        d dVar = this.f.get(i2);
        if (dVar != null) {
            return dVar.k;
        }
        return -1;
    }
}
