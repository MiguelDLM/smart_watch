package com.huawei.openalliance.ad.inter.data;

import android.text.TextUtils;
import com.huawei.hms.ads.AdvertiserInfo;
import com.huawei.hms.ads.DefaultTemplate;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.ad.beans.metadata.ContentExt;
import com.huawei.openalliance.ad.beans.metadata.CtrlExt;
import com.huawei.openalliance.ad.beans.metadata.DelayInfo;
import com.huawei.openalliance.ad.beans.metadata.ImpEX;
import com.huawei.openalliance.ad.beans.metadata.InteractCfg;
import com.huawei.openalliance.ad.beans.metadata.MediaFile;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.metadata.Om;
import com.huawei.openalliance.ad.beans.metadata.PromoteInfo;
import com.huawei.openalliance.ad.beans.metadata.v3.Asset;
import com.huawei.openalliance.ad.beans.metadata.v3.TemplateData;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.w;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@DataKeep
/* loaded from: classes10.dex */
public class AdContentData implements Serializable {
    private static final long serialVersionUID = 5884097865724973073L;
    private String abilityDetailInfoEncode;
    private String adChoiceIcon;
    private String adChoiceUrl;
    private int apiVer;
    private List<Asset> assets;
    private String bannerRefSetting;
    private List<Integer> clickActionList;
    private List<AdvertiserInfo> compliance;
    private String contentDownMethod;
    private List<ContentExt> contentExts;
    private String contentId;
    private String cshareUrl;
    private String ctrlExt;

    @com.huawei.openalliance.ad.annotations.d
    private transient CtrlExt ctrlExtObj;
    private String ctrlSwitchs;
    private String cur;
    private String customData;
    private DefaultTemplate defaultTemplate;
    private DelayInfo delayInfo;
    private String detailUrl;
    private int displayCount;
    private long endTime;
    private List<ImpEX> ext;
    private List<FeedbackInfo> feedbackInfoList;
    private int height;
    private String hwChannelId;
    private String intentUri;
    private InteractCfg interactCfg;
    private int interactiontype;
    private String isAdContainerSizeMatched;
    private boolean isDownloaded;
    private boolean isJssdkInWhiteList;
    private boolean isLast;
    private boolean isVastAd;
    private List<JSFeedbackInfo> jsFeedbackInfos;
    private List<String> keyWords;
    private List<String> keyWordsType;
    private int landingTitleFlag;
    private long lastShowTime;
    private String logo2Pos;
    private String logo2Text;
    private String lurl;

    @com.huawei.openalliance.ad.annotations.a
    private String metaData;

    @com.huawei.openalliance.ad.annotations.d
    private MetaData metaDataObj;
    private boolean needAppDownload;
    private String nurl;

    @com.huawei.openalliance.ad.annotations.a
    private List<Om> om;

    @com.huawei.openalliance.ad.annotations.a
    private List<Om> omArgs;
    Integer playedTime;

    @com.huawei.openalliance.ad.annotations.a
    private Float price;
    private int priority;
    private String proDesc;
    private String recordtaskinfo;
    private String requestId;
    private Integer requestType;
    private int rewardAmount;
    private String rewardType;
    private int sequence;
    private String skipText;
    private int skipTextHeight;
    private String skipTextPos;
    private int skipTextSize;
    private String slotId;
    private String splashMediaPath;
    private int splashPreContentFlag;
    private long startShowTime;
    private long startTime;
    private String style;
    private String taskId;
    private String templateContent;
    private TemplateData templateData;
    private int templateId;
    private String templateIdV3;
    private String templateStyle;
    private String templateUrl;
    private String transparencyTplUrl;
    private String uniqueId;
    private int useGaussianBlur;
    private String userId;
    private transient VideoConfiguration videoConfiguration;
    private long videoTime;
    private String webConfig;
    private String whyThisAd;
    private int width;
    private String showId = String.valueOf(w.Code());
    private int sdkVer = com.huawei.hms.ads.base.a.B;
    private int showAppLogoFlag = 1;
    private int creativeType = 2;
    private int adType = -1;
    private boolean autoDownloadApp = false;
    private boolean directReturnVideoAd = false;
    private int linkedVideoMode = 0;
    private boolean isFromExSplash = false;
    private boolean isSpare = false;
    private int splashSkipBtnDelayTime = -111111;
    private int splashShowTime = -111111;
    private int recallSource = 0;
    private boolean isSupportImpCtrl = true;
    private boolean transparencySwitch = false;
    private boolean transparencyOpen = false;

    public static long P() {
        return serialVersionUID;
    }

    public void A(String str) {
        this.lurl = str;
    }

    public String B() {
        return this.skipText;
    }

    public String C() {
        return this.metaData;
    }

    public String Code() {
        return this.ctrlExt;
    }

    public String D() {
        return this.showId;
    }

    public int E() {
        return this.templateId;
    }

    public Integer F() {
        return this.playedTime;
    }

    public String G() {
        return this.templateContent;
    }

    public boolean H() {
        return this.directReturnVideoAd;
    }

    public void I(int i) {
        this.height = i;
    }

    public int J() {
        return this.linkedVideoMode;
    }

    public int K() {
        return this.sequence;
    }

    public String L() {
        return this.slotId;
    }

    public String M() {
        return this.requestId;
    }

    public String N() {
        return this.rewardType;
    }

    public int O() {
        return this.rewardAmount;
    }

    public long Q() {
        return this.lastShowTime;
    }

    public int R() {
        return this.displayCount;
    }

    public MetaData S() {
        if (this.metaDataObj == null) {
            this.metaDataObj = (MetaData) aa.V(this.metaData, MetaData.class, new Class[0]);
        }
        return this.metaDataObj;
    }

    public int T() {
        return this.splashPreContentFlag;
    }

    public MetaData U() {
        return this.metaDataObj;
    }

    public CtrlExt V() {
        if (this.ctrlExtObj == null) {
            this.ctrlExtObj = (CtrlExt) aa.V(this.ctrlExt, CtrlExt.class, new Class[0]);
        }
        return this.ctrlExtObj;
    }

    public List<String> W() {
        return this.keyWordsType;
    }

    public int X() {
        return this.landingTitleFlag;
    }

    public String Y() {
        return this.webConfig;
    }

    public int Z() {
        return this.adType;
    }

    public String a() {
        return this.contentId;
    }

    public InteractCfg aA() {
        return this.interactCfg;
    }

    public long aB() {
        return this.startShowTime;
    }

    public List<FeedbackInfo> aC() {
        return this.feedbackInfoList;
    }

    public boolean aD() {
        return this.isVastAd;
    }

    public String aE() {
        return this.templateIdV3;
    }

    public int aF() {
        return this.apiVer;
    }

    public String aG() {
        return ay.V(this.abilityDetailInfoEncode);
    }

    public String aH() {
        return this.hwChannelId;
    }

    public List<Asset> aI() {
        return this.assets;
    }

    public TemplateData aJ() {
        return this.templateData;
    }

    public String aK() {
        return this.templateStyle;
    }

    public List<AdvertiserInfo> aL() {
        return this.compliance;
    }

    public List<JSFeedbackInfo> aM() {
        return this.jsFeedbackInfos;
    }

    public int aN() {
        return this.recallSource;
    }

    public String aO() {
        return this.templateUrl;
    }

    public String aP() {
        return this.transparencyTplUrl;
    }

    public boolean aQ() {
        return this.transparencySwitch;
    }

    public boolean aR() {
        return this.transparencyOpen;
    }

    public long aS() {
        return this.videoTime;
    }

    public String aT() {
        return this.cshareUrl;
    }

    public DefaultTemplate aU() {
        return this.defaultTemplate;
    }

    public String aV() {
        return this.cur;
    }

    public Float aW() {
        return this.price;
    }

    public String aX() {
        return this.nurl;
    }

    public String aY() {
        return this.lurl;
    }

    public String aZ() {
        return this.style;
    }

    public String aa() {
        return this.uniqueId;
    }

    public String ab() {
        return this.isAdContainerSizeMatched;
    }

    public String ac() {
        return this.whyThisAd;
    }

    public String ad() {
        return this.adChoiceUrl;
    }

    public String ae() {
        return this.adChoiceIcon;
    }

    public boolean af() {
        return this.isLast;
    }

    public int ag() {
        return this.skipTextSize;
    }

    public int ah() {
        return this.skipTextHeight;
    }

    public List<Om> ai() {
        return this.om;
    }

    public List<Om> aj() {
        return this.omArgs;
    }

    public String ak() {
        return this.contentDownMethod;
    }

    public int al() {
        return this.useGaussianBlur;
    }

    public String am() {
        return this.isAdContainerSizeMatched;
    }

    public DelayInfo an() {
        return this.delayInfo;
    }

    public String ao() {
        return this.bannerRefSetting;
    }

    public boolean ap() {
        return this.isFromExSplash;
    }

    public boolean aq() {
        return this.isSpare;
    }

    public int ar() {
        return this.splashSkipBtnDelayTime;
    }

    public int as() {
        return this.splashShowTime;
    }

    public String at() {
        return this.customData;
    }

    public String au() {
        return this.userId;
    }

    public String av() {
        return this.proDesc;
    }

    public boolean aw() {
        return this.isJssdkInWhiteList;
    }

    public Integer ax() {
        return this.requestType;
    }

    public List<ImpEX> ay() {
        return this.ext;
    }

    public List<ContentExt> az() {
        return this.contentExts;
    }

    public String b() {
        return this.taskId;
    }

    public int c() {
        return this.showAppLogoFlag;
    }

    public long d() {
        return this.endTime;
    }

    public long e() {
        return this.startTime;
    }

    public int f() {
        return this.width;
    }

    public int g() {
        return this.height;
    }

    public String h() {
        return this.splashMediaPath;
    }

    public String i() {
        return this.detailUrl;
    }

    public int j() {
        return this.interactiontype;
    }

    public int k() {
        return this.priority;
    }

    public int l() {
        return this.creativeType;
    }

    public String m() {
        return this.intentUri;
    }

    public void n() {
        this.displayCount++;
        this.priority = 1;
        this.lastShowTime = w.Code();
    }

    public List<String> o() {
        return this.keyWords;
    }

    public String p() {
        return this.skipTextPos;
    }

    public List<Integer> q() {
        return this.clickActionList;
    }

    public String r() {
        return this.logo2Text;
    }

    public String s() {
        return this.logo2Pos;
    }

    public com.huawei.openalliance.ad.beans.metadata.VideoInfo t() {
        MetaData S = S();
        if (S != null) {
            return S.V();
        }
        return null;
    }

    public MediaFile u() {
        MetaData S = S();
        if (S != null) {
            return S.h();
        }
        return null;
    }

    public String v() {
        return this.ctrlSwitchs;
    }

    public String w() {
        return this.recordtaskinfo;
    }

    public void x(String str) {
        this.cshareUrl = str;
    }

    public AppInfo y() {
        ApkInfo e;
        MetaData S = S();
        if (S == null || (e = S.e()) == null) {
            return null;
        }
        AppInfo appInfo = new AppInfo(e);
        appInfo.V(this.uniqueId);
        appInfo.Code(S.c());
        appInfo.a(S.I());
        return appInfo;
    }

    public PromoteInfo z() {
        MetaData S = S();
        if (S == null) {
            return null;
        }
        return S.f();
    }

    public boolean A() {
        return this.needAppDownload;
    }

    public void B(int i) {
        this.templateId = i;
    }

    public void C(int i) {
        this.linkedVideoMode = i;
    }

    public void Code(int i) {
        this.showAppLogoFlag = i;
    }

    public void D(int i) {
        this.useGaussianBlur = i;
    }

    public void E(String str) {
        this.style = str;
    }

    public void F(int i) {
        this.skipTextHeight = i;
    }

    public void I(long j) {
        this.startTime = j;
    }

    public void L(int i) {
        this.displayCount = i;
    }

    public void S(int i) {
        this.skipTextSize = i;
    }

    public void V(int i) {
        this.width = i;
    }

    public void Z(int i) {
        this.priority = i;
    }

    public void a(int i) {
        this.creativeType = i;
    }

    public void b(int i) {
        this.interactiontype = i;
    }

    public void c(int i) {
        this.splashPreContentFlag = i;
    }

    public void d(int i) {
        this.adType = i;
    }

    public void e(int i) {
        this.landingTitleFlag = i;
    }

    public void f(int i) {
        this.sequence = i;
    }

    public void g(int i) {
        this.rewardAmount = i;
    }

    public void h(int i) {
        this.apiVer = i;
    }

    public void i(int i) {
        this.recallSource = i;
    }

    public void j(String str) {
        this.logo2Pos = str;
    }

    public void k(String str) {
        this.contentDownMethod = str;
    }

    public void l(String str) {
        this.webConfig = str;
    }

    public void m(String str) {
        this.ctrlSwitchs = str;
    }

    public void n(String str) {
        this.recordtaskinfo = str;
    }

    public void o(String str) {
        this.rewardType = str;
    }

    public void p(String str) {
        this.isAdContainerSizeMatched = str;
    }

    public void q(String str) {
        this.customData = ay.S(str);
    }

    public void r(String str) {
        this.userId = ay.S(str);
    }

    public void s(String str) {
        this.proDesc = str;
    }

    public void t(String str) {
        this.templateIdV3 = str;
    }

    public void u(String str) {
        this.hwChannelId = str;
    }

    public void v(String str) {
        this.templateUrl = str;
    }

    public void w(String str) {
        this.transparencyTplUrl = str;
    }

    public boolean x() {
        return true;
    }

    public void y(String str) {
        this.cur = str;
    }

    public void z(String str) {
        this.nurl = str;
    }

    public void B(long j) {
        this.videoTime = j;
    }

    public void C(String str) {
        this.taskId = str;
    }

    public void Code(long j) {
        this.lastShowTime = j;
    }

    public void D(String str) {
        this.requestId = str;
    }

    public void F(String str) {
        this.templateContent = str;
    }

    public void I(String str) {
        this.showId = str;
    }

    public void L(String str) {
        this.whyThisAd = str;
    }

    public void S(String str) {
        this.uniqueId = str;
    }

    public void V(long j) {
        this.endTime = j;
    }

    public void Z(long j) {
        this.startShowTime = j;
    }

    public void a(String str) {
        this.adChoiceUrl = str;
    }

    public void b(String str) {
        this.adChoiceIcon = str;
    }

    public void c(String str) {
        this.isAdContainerSizeMatched = str;
    }

    public void d(String str) {
        this.splashMediaPath = str;
    }

    public void e(String str) {
        this.detailUrl = str;
    }

    public void f(String str) {
        this.intentUri = str;
    }

    public void g(String str) {
        this.skipText = str;
    }

    public void h(String str) {
        this.skipTextPos = str;
    }

    public void i(String str) {
        this.logo2Text = str;
    }

    public void B(String str) {
        this.contentId = str;
    }

    public void C(List<ContentExt> list) {
        this.contentExts = list;
    }

    public void Code(DefaultTemplate defaultTemplate) {
        this.defaultTemplate = defaultTemplate;
    }

    public void D(List<AdvertiserInfo> list) {
        this.compliance = list;
    }

    public void F(List<FeedbackInfo> list) {
        this.feedbackInfoList = list;
    }

    public void I(List<String> list) {
        this.keyWords = list;
    }

    public void L(List<FeedbackInfo> list) {
        if (ad.Code(list)) {
            return;
        }
        this.jsFeedbackInfos = new ArrayList();
        for (FeedbackInfo feedbackInfo : list) {
            if (feedbackInfo != null) {
                this.jsFeedbackInfos.add(new JSFeedbackInfo(feedbackInfo));
            }
        }
    }

    public void S(List<ImpEX> list) {
        this.ext = list;
    }

    public void V(Integer num) {
        this.playedTime = num;
    }

    public void Z(String str) {
        this.slotId = str;
    }

    public void a(boolean z) {
        this.transparencyOpen = z && !TextUtils.isEmpty(this.transparencyTplUrl);
    }

    public void B(List<Integer> list) {
        this.clickActionList = list;
    }

    public void C(boolean z) {
        this.isFromExSplash = z;
    }

    public void Code(VideoConfiguration videoConfiguration) {
        this.videoConfiguration = videoConfiguration;
    }

    public void D(boolean z) {
        this.isVastAd = z;
    }

    public void F(boolean z) {
        this.isJssdkInWhiteList = z;
    }

    public void I(boolean z) {
        this.needAppDownload = z;
    }

    public void L(boolean z) {
        this.transparencySwitch = z;
    }

    public void S(boolean z) {
        this.isSpare = z;
    }

    public void V(String str) {
        this.metaData = str;
        this.metaDataObj = null;
    }

    public void Z(List<String> list) {
        this.keyWordsType = list;
    }

    public void B(boolean z) {
        this.directReturnVideoAd = z;
    }

    public void Code(CtrlExt ctrlExt) {
        this.ctrlExtObj = ctrlExt;
    }

    public boolean I() {
        return this.isSupportImpCtrl;
    }

    public void V(List<Om> list) {
        this.omArgs = list;
    }

    public void Z(boolean z) {
        this.isLast = z;
    }

    public void Code(DelayInfo delayInfo) {
        this.delayInfo = delayInfo;
    }

    public void V(boolean z) {
        this.autoDownloadApp = z;
    }

    public void Code(InteractCfg interactCfg) {
        this.interactCfg = interactCfg;
    }

    public void Code(MetaData metaData) {
        this.metaDataObj = metaData;
    }

    public void Code(Float f) {
        this.price = f;
    }

    public void Code(Integer num) {
        this.requestType = num;
    }

    public void Code(String str) {
        this.ctrlExt = str;
    }

    public void Code(List<Om> list) {
        this.om = list;
    }

    public void Code(boolean z) {
        this.isSupportImpCtrl = z;
    }
}
