package com.huawei.hms.ads.jsb.inner.data;

import android.text.TextUtils;
import com.huawei.hms.ads.AdvertiserInfo;
import com.huawei.hms.ads.ja;
import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.beans.metadata.AdSource;
import com.huawei.openalliance.ad.beans.metadata.CtrlExt;
import com.huawei.openalliance.ad.beans.metadata.ImpEX;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.RewardItem;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.ay;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@DataKeep
/* loaded from: classes10.dex */
public class H5Ad {
    private String adChoiceUrl;
    private int adType;
    private List<AdvertiserInfo> advertiserInfos;
    private int apiVer;
    private App app;
    private String bannerRefSetting;
    private String clickBtnTxt;
    private String contentId;
    private int creativeType;
    private CtrlExt ctrlExt;
    private String desc;
    private String dspLogo;
    private String dspName;
    private long endTime;
    private Map<String, String> ext;
    private ImageInfo icon;
    private List<ImageInfo> imgList;
    private int interactionType;
    private boolean isGaussianBlur;
    private boolean isSilentReserve;
    private List<String> keywords;
    private String label;
    private String logo2Text;
    private MediaFile mediaFile;
    private int minEffectiveShowRatio;
    private long minEffectiveShowTime;
    private String requestId;
    private RewardItem rewardItem;
    private int sequence;
    private boolean showAppElement;
    private String showId;
    private String slotId;
    private String source;
    private long startShowtime;
    private String taskId;
    private String templateId;
    private String title;
    private boolean transparencyOpen;
    private String uniqueId;
    private Video video;

    public H5Ad() {
        this.apiVer = 2;
    }

    public String B() {
        return this.slotId;
    }

    public String C() {
        return this.taskId;
    }

    public String Code() {
        return this.uniqueId;
    }

    public String D() {
        return this.desc;
    }

    public String F() {
        return this.title;
    }

    public String I() {
        return this.requestId;
    }

    public String L() {
        return this.source;
    }

    public int S() {
        return this.adType;
    }

    public String V() {
        return this.showId;
    }

    public String Z() {
        return this.contentId;
    }

    public ImageInfo a() {
        return this.icon;
    }

    public List<ImageInfo> b() {
        return this.imgList;
    }

    public Video c() {
        return this.video;
    }

    public App d() {
        return this.app;
    }

    public String e() {
        return this.clickBtnTxt;
    }

    public int f() {
        return this.creativeType;
    }

    public int g() {
        return this.interactionType;
    }

    public long h() {
        return this.endTime;
    }

    public long i() {
        return this.minEffectiveShowTime;
    }

    public int j() {
        return this.minEffectiveShowRatio;
    }

    public int k() {
        return this.sequence;
    }

    public String l() {
        return this.dspName;
    }

    public String m() {
        return this.dspLogo;
    }

    public String n() {
        return this.logo2Text;
    }

    public List<AdvertiserInfo> o() {
        return this.advertiserInfos;
    }

    public long p() {
        return this.startShowtime;
    }

    public boolean q() {
        return this.showAppElement;
    }

    public H5Ad(AdContentData adContentData) {
        this.apiVer = 2;
        if (adContentData == null) {
            return;
        }
        this.isSilentReserve = ja.b(adContentData.v());
        this.requestId = adContentData.M();
        this.uniqueId = adContentData.aa();
        this.showId = adContentData.D();
        this.slotId = adContentData.L();
        this.contentId = adContentData.a();
        this.taskId = adContentData.b();
        this.adType = adContentData.Z();
        this.creativeType = adContentData.l();
        this.interactionType = adContentData.j();
        this.endTime = adContentData.d();
        this.sequence = adContentData.K();
        this.adChoiceUrl = adContentData.ad();
        this.ctrlExt = adContentData.V();
        if (!ad.Code(adContentData.o())) {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = adContentData.o().iterator();
            while (it.hasNext()) {
                arrayList.add(ay.S(it.next()));
            }
            this.keywords = arrayList;
        }
        boolean z = false;
        this.isGaussianBlur = adContentData.al() == 1;
        this.bannerRefSetting = adContentData.ao();
        this.logo2Text = adContentData.r();
        MetaData S = adContentData.S();
        if (S != null) {
            this.minEffectiveShowRatio = S.D();
            this.minEffectiveShowTime = S.F();
            this.desc = S.B();
            List<com.huawei.openalliance.ad.beans.metadata.ImageInfo> S2 = S.S();
            if (S2 != null && !S2.isEmpty()) {
                this.icon = new ImageInfo(S2.get(0));
            }
            this.imgList = V(S.d());
            AdSource Code = AdSource.Code(S.l());
            if (Code != null) {
                this.dspName = Code.Code();
                this.dspLogo = Code.V();
            }
            this.source = S.L();
            this.clickBtnTxt = S.Code();
            this.title = S.Z();
            this.label = S.L();
            this.mediaFile = new MediaFile(S.h(), S.k());
            this.showAppElement = S.o();
        }
        if (adContentData.aQ() && !TextUtils.isEmpty(adContentData.aP())) {
            z = true;
        }
        this.transparencyOpen = z;
        if (adContentData.t() != null) {
            this.video = new Video(adContentData.t());
        }
        if (adContentData.O() > 0 && adContentData.N() != null) {
            this.rewardItem = new RewardItem(adContentData.N(), adContentData.O());
        }
        if (adContentData.y() != null) {
            this.app = new App(adContentData.y());
        }
        List<ImpEX> ay = adContentData.ay();
        HashMap hashMap = new HashMap();
        if (!ad.Code(ay)) {
            for (ImpEX impEX : ay) {
                hashMap.put(impEX.Code(), impEX.V());
            }
        }
        this.ext = hashMap;
        if (!ad.Code(adContentData.aL())) {
            this.advertiserInfos = adContentData.aL();
        }
        this.apiVer = adContentData.aF();
        this.templateId = adContentData.aE();
    }

    private List<ImageInfo> V(List<com.huawei.openalliance.ad.beans.metadata.ImageInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            Iterator<com.huawei.openalliance.ad.beans.metadata.ImageInfo> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new ImageInfo(it.next()));
            }
        }
        return arrayList;
    }

    public void Code(long j) {
        this.startShowtime = j;
    }

    public void Code(List<AdvertiserInfo> list) {
        this.advertiserInfos = list;
    }
}
