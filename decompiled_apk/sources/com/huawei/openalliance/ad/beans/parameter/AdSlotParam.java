package com.huawei.openalliance.ad.beans.parameter;

import com.huawei.hms.ads.App;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.annotations.b;
import com.huawei.openalliance.ad.annotations.d;
import com.huawei.openalliance.ad.beans.metadata.ImpEX;
import com.huawei.openalliance.ad.beans.metadata.Location;
import com.huawei.openalliance.ad.beans.metadata.Video;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.ai;
import com.huawei.openalliance.ad.utils.ay;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@DataKeep
/* loaded from: classes10.dex */
public class AdSlotParam {
    private static final String TAG = "AdSlotParam";
    private Integer adHeight;
    private List<String> adIds;
    private int adType;
    private Integer adWidth;
    private Integer adsLocSwitch;
    private String agcAaid;
    private Integer allowMobileTraffic;
    private App appInfo;
    private Integer bannerRefFlag;
    private String belongCountry;
    private Integer brand;
    private String contentBundle;

    @d
    private Map<String, String> contentBundleMap;
    private String contentUrl;
    private List<String> detailedCreativeTypeList;
    private int deviceType;
    private Integer endMode;
    private int gender;
    private Integer gpsSwitch;
    private int height;
    private Integer imageOrientation;
    private boolean isPreload;
    private boolean isRequestMultipleImages;
    private Integer isSmart;
    private String jssdkVersion;
    private Set<String> keyWordsSet;
    private Integer linkedMode;
    private Location location;
    private int maxCount;
    private Integer mediaGpsSwitch;
    private boolean needDownloadImage;
    private int orientation;
    private String requestAgent;
    private String requestId;
    private RequestOptions requestOptions;
    private String requestSequence;
    private Integer requestType;
    private Integer sdkType;
    private boolean sharePd;
    private Integer splashStartMode;
    private Integer splashType;
    private boolean supportTptAd;
    private boolean test;
    private String testDeviceId;
    private int totalDuration;
    private String uiEngineVer;
    private Map<String, Integer> unsupportedTags;
    private Video video;
    private int width;

    @b
    /* loaded from: classes10.dex */
    public static final class a {
        private Map<String, Integer> A;
        private Video D;
        private String G;
        private String S;

        /* renamed from: a, reason: collision with root package name */
        private android.location.Location f17370a;
        private RequestOptions b;
        private int c;
        private String d;
        private String e;
        private Set<String> f;
        private int g;
        private Integer h;
        private Integer j;
        private String k;
        private Integer m;
        private Integer n;
        private Integer o;
        private App p;
        private int q;
        private Integer r;
        private Integer s;
        private String t;
        private List<String> u;
        private Integer v;
        private String w;
        private Map<String, String> x;
        private String y;
        private Integer z;
        private List<String> Code = new ArrayList(0);
        private int V = 1;
        private boolean I = false;
        private int Z = 4;
        private int B = 0;
        private int C = 0;
        private boolean F = false;
        private int L = 3;
        private boolean i = true;
        private boolean l = true;
        private boolean E = false;

        public Location Code() {
            android.location.Location location = this.f17370a;
            if (location == null) {
                return null;
            }
            return new Location(Double.valueOf(location.getLongitude()), Double.valueOf(this.f17370a.getLatitude()));
        }

        @b
        public a D(int i) {
            this.q = i;
            return this;
        }

        @b
        public a I(int i) {
            this.B = i;
            return this;
        }

        @b
        public a S(int i) {
            this.c = i;
            return this;
        }

        @b
        public a B(int i) {
            this.g = i;
            return this;
        }

        @b
        public a C(int i) {
            this.L = i;
            return this;
        }

        @b
        public a Code(int i) {
            this.V = i;
            return this;
        }

        public String D() {
            return this.t;
        }

        @b
        public a F(int i) {
            this.j = Integer.valueOf(i);
            return this;
        }

        @b
        public a I(Integer num) {
            this.n = num;
            return this;
        }

        public a L(int i) {
            this.o = Integer.valueOf(i);
            return this;
        }

        public a S(String str) {
            this.G = str;
            return this;
        }

        public RequestOptions V() {
            return this.b;
        }

        @b
        public a Z(int i) {
            this.C = i;
            return this;
        }

        public String a() {
            return this.y;
        }

        public a B(String str) {
            this.t = str;
            return this;
        }

        public a C(Integer num) {
            this.s = num;
            return this;
        }

        @b
        public a Code(android.location.Location location) {
            this.f17370a = location;
            return this;
        }

        public a F(String str) {
            this.y = str;
            return this;
        }

        @b
        public a I(String str) {
            this.e = str;
            return this;
        }

        public Integer L() {
            return this.v;
        }

        @b
        public AdSlotParam S() {
            return new AdSlotParam(this);
        }

        @b
        public a V(int i) {
            this.Z = i;
            return this;
        }

        @b
        public a Z(Integer num) {
            this.z = num;
            return this;
        }

        public Integer B() {
            return this.m;
        }

        @b
        public a C(String str) {
            Map<String, String> map = (Map) aa.V(str, Map.class, new Class[0]);
            if (ai.Code(map)) {
                fb.I(AdSlotParam.TAG, "contentBundle info is empty or not json string");
            } else {
                String V = AdSlotParam.V(map);
                this.x = map;
                this.w = V;
            }
            return this;
        }

        public a Code(App app) {
            this.p = app;
            return this;
        }

        public Integer F() {
            return this.r;
        }

        @b
        public void I(boolean z) {
            this.l = z;
        }

        @b
        public a V(Integer num) {
            this.m = num;
            return this;
        }

        @b
        public a Z(String str) {
            this.k = str;
            return this;
        }

        public void B(Integer num) {
            this.r = num;
        }

        public Integer C() {
            return this.n;
        }

        @b
        public a Code(RequestOptions requestOptions) {
            this.b = requestOptions;
            return this;
        }

        public boolean I() {
            return this.l;
        }

        public void S(Integer num) {
            this.v = num;
        }

        @b
        public a V(String str) {
            this.d = str;
            return this;
        }

        public a Z(boolean z) {
            this.E = z;
            return this;
        }

        @b
        public a Code(Boolean bool) {
            this.F = bool.booleanValue();
            return this;
        }

        @b
        public a V(List<Integer> list) {
            if (list == null) {
                return this;
            }
            if (list.size() > 100) {
                list = list.subList(0, 100);
            }
            this.u = new ArrayList(list.size());
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                this.u.add(Integer.toString(it.next().intValue()));
            }
            return this;
        }

        public List<String> Z() {
            return this.u;
        }

        @b
        public a Code(Integer num) {
            this.h = num;
            return this;
        }

        @b
        public a V(boolean z) {
            this.i = z;
            return this;
        }

        @b
        public a Code(String str) {
            this.S = str;
            return this;
        }

        @b
        public a Code(List<String> list) {
            this.Code = list;
            return this;
        }

        @b
        public a Code(Map<String, Integer> map) {
            this.A = map;
            return this;
        }

        @b
        public a Code(Set<String> set) {
            this.f = set;
            return this;
        }

        @b
        public a Code(boolean z) {
            this.I = z;
            return this;
        }

        @b
        public void Code(Video video) {
            this.D = video;
        }
    }

    @b
    public AdSlotParam() {
        this.isPreload = false;
        this.sharePd = true;
        this.adType = 3;
        this.needDownloadImage = false;
        this.isRequestMultipleImages = true;
        this.supportTptAd = false;
    }

    public RequestOptions B() {
        return this.requestOptions;
    }

    public Integer C() {
        return this.allowMobileTraffic;
    }

    public Integer D() {
        return this.adsLocSwitch;
    }

    public Integer F() {
        return this.splashStartMode;
    }

    public int I() {
        return this.deviceType;
    }

    public Integer L() {
        return this.gpsSwitch;
    }

    public Integer S() {
        return this.splashType;
    }

    public int V() {
        return this.orientation;
    }

    public Location Z() {
        return this.location;
    }

    public Integer a() {
        return this.mediaGpsSwitch;
    }

    public Integer b() {
        return this.brand;
    }

    public String c() {
        return this.requestId;
    }

    public List<String> d() {
        return this.detailedCreativeTypeList;
    }

    public String e() {
        return this.agcAaid;
    }

    public Integer f() {
        return this.endMode;
    }

    public AdSlotParam g() {
        AdSlotParam adSlotParam = new AdSlotParam();
        adSlotParam.adIds = this.adIds;
        adSlotParam.orientation = this.orientation;
        adSlotParam.test = this.test;
        adSlotParam.deviceType = this.deviceType;
        adSlotParam.width = this.width;
        adSlotParam.height = this.height;
        adSlotParam.requestSequence = this.requestSequence;
        adSlotParam.video = this.video;
        adSlotParam.isPreload = this.isPreload;
        adSlotParam.sharePd = this.sharePd;
        adSlotParam.requestOptions = this.requestOptions;
        adSlotParam.location = this.location;
        adSlotParam.gender = this.gender;
        adSlotParam.contentUrl = this.contentUrl;
        adSlotParam.requestAgent = this.requestAgent;
        adSlotParam.keyWordsSet = this.keyWordsSet;
        adSlotParam.maxCount = this.maxCount;
        adSlotParam.belongCountry = this.belongCountry;
        adSlotParam.isSmart = this.isSmart;
        adSlotParam.needDownloadImage = this.needDownloadImage;
        adSlotParam.imageOrientation = this.imageOrientation;
        adSlotParam.isRequestMultipleImages = this.isRequestMultipleImages;
        adSlotParam.adWidth = this.adWidth;
        adSlotParam.adHeight = this.adHeight;
        adSlotParam.allowMobileTraffic = this.allowMobileTraffic;
        adSlotParam.totalDuration = this.totalDuration;
        adSlotParam.splashStartMode = this.splashStartMode;
        adSlotParam.splashType = this.splashType;
        adSlotParam.adsLocSwitch = this.adsLocSwitch;
        adSlotParam.gpsSwitch = this.gpsSwitch;
        adSlotParam.mediaGpsSwitch = this.mediaGpsSwitch;
        adSlotParam.brand = this.brand;
        adSlotParam.bannerRefFlag = this.bannerRefFlag;
        adSlotParam.detailedCreativeTypeList = this.detailedCreativeTypeList;
        adSlotParam.requestType = this.requestType;
        adSlotParam.contentBundle = this.contentBundle;
        adSlotParam.contentBundleMap = this.contentBundleMap;
        adSlotParam.agcAaid = this.agcAaid;
        adSlotParam.endMode = this.endMode;
        adSlotParam.unsupportedTags = this.unsupportedTags;
        adSlotParam.supportTptAd = this.supportTptAd;
        adSlotParam.jssdkVersion = this.jssdkVersion;
        return adSlotParam;
    }

    public Integer h() {
        return this.linkedMode;
    }

    private AdSlotParam(a aVar) {
        this.isPreload = false;
        this.sharePd = true;
        this.adType = 3;
        this.needDownloadImage = false;
        this.isRequestMultipleImages = true;
        this.supportTptAd = false;
        this.adIds = aVar.Code;
        this.orientation = aVar.V;
        this.test = aVar.I;
        this.deviceType = aVar.Z;
        this.width = aVar.B;
        this.height = aVar.C;
        this.requestSequence = aVar.S;
        this.video = aVar.D;
        this.isPreload = aVar.F;
        this.adType = aVar.L;
        this.requestOptions = aVar.b;
        this.location = aVar.Code();
        this.gender = aVar.c;
        this.contentUrl = aVar.d;
        this.requestAgent = aVar.e;
        this.keyWordsSet = aVar.f;
        this.maxCount = aVar.g;
        this.isSmart = aVar.h;
        this.needDownloadImage = aVar.i;
        this.imageOrientation = aVar.j;
        this.testDeviceId = aVar.k;
        this.isRequestMultipleImages = aVar.l;
        this.adWidth = aVar.m;
        this.adHeight = aVar.n;
        this.allowMobileTraffic = aVar.o;
        this.appInfo = aVar.p;
        this.totalDuration = aVar.q;
        this.brand = aVar.r;
        this.bannerRefFlag = aVar.s;
        this.requestId = aVar.t;
        this.detailedCreativeTypeList = aVar.u;
        this.requestType = aVar.v;
        this.contentBundle = aVar.w;
        this.contentBundleMap = aVar.x;
        this.agcAaid = aVar.y;
        this.endMode = aVar.z;
        this.unsupportedTags = aVar.A;
        this.supportTptAd = aVar.E;
        this.jssdkVersion = aVar.G;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String V(Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new ImpEX(entry.getKey(), ay.S(entry.getValue())));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("contentBundle", arrayList);
        return aa.V(hashMap);
    }

    public void B(int i) {
        this.height = i;
    }

    public void C(Integer num) {
        this.adsLocSwitch = num;
    }

    public List<String> Code() {
        return this.adIds;
    }

    public void D(Integer num) {
        this.brand = num;
    }

    public void F(Integer num) {
        this.mediaGpsSwitch = num;
    }

    public void I(int i) {
        this.deviceType = i;
    }

    public void L(Integer num) {
        this.linkedMode = num;
    }

    public void S(Integer num) {
        this.gpsSwitch = num;
    }

    public void Z(int i) {
        this.width = i;
    }

    public void a(Integer num) {
        this.sdkType = num;
    }

    public void B(Integer num) {
        this.splashStartMode = num;
    }

    public void Code(int i) {
        this.adType = i;
    }

    public void I(Integer num) {
        this.allowMobileTraffic = num;
    }

    public void V(int i) {
        this.orientation = i;
    }

    public void Z(Integer num) {
        this.splashType = num;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void B(String str) {
        Map<String, String> map;
        Map map2 = (Map) aa.V(str, Map.class, new Class[0]);
        if (ai.Code(map2) || ai.Code(this.contentBundleMap)) {
            if (ai.Code(map2)) {
                return;
            }
            fb.V(TAG, "set auto content Bundle");
            map = (Map) aa.V(str, Map.class, new Class[0]);
            if (ai.Code(map)) {
                fb.I(TAG, "auto contentBundle info is empty or not json string");
                return;
            }
        } else {
            fb.V(TAG, "merge auto content Bundle");
            for (Map.Entry entry : map2.entrySet()) {
                String str2 = (String) entry.getKey();
                String str3 = (String) entry.getValue();
                if (!this.contentBundleMap.containsKey(str2) && !ay.Code(str3)) {
                    this.contentBundleMap.put(str2, map2.get(str2));
                }
            }
            if (this.contentBundleMap.containsKey("content") && this.contentBundleMap.containsKey(x.cm)) {
                this.contentBundleMap.remove(x.cm);
            }
            map = this.contentBundleMap;
        }
        this.contentBundle = V(map);
    }

    public void Code(App app) {
        this.appInfo = app;
    }

    public void I(String str) {
        this.agcAaid = str;
    }

    public void V(Integer num) {
        this.adHeight = num;
    }

    public void Z(String str) {
        this.uiEngineVer = str;
    }

    public void Code(RequestOptions requestOptions) {
        this.requestOptions = requestOptions;
    }

    public void V(String str) {
        this.requestId = str;
    }

    public void Code(Location location) {
        this.location = location;
    }

    public void V(boolean z) {
        this.sharePd = z;
    }

    public void Code(Integer num) {
        this.adWidth = num;
    }

    public void Code(String str) {
        this.belongCountry = str;
    }

    public void Code(boolean z) {
        this.isPreload = z;
    }
}
