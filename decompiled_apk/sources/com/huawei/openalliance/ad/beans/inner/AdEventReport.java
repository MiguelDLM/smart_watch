package com.huawei.openalliance.ad.beans.inner;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.annotations.d;
import com.huawei.openalliance.ad.beans.metadata.CtrlExt;
import com.huawei.openalliance.ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.w;
import java.util.List;

@DataKeep
/* loaded from: classes10.dex */
public class AdEventReport {
    private String activityName;
    private int adType;
    private int apiVer;
    private Long clickDTime;
    private Long clickUTime;
    private Integer clickX;
    private Integer clickY;
    private String contentId;
    private String creativeSize;
    private String ctrlExt;

    @d
    private transient CtrlExt ctrlExtObj;
    private String customData;
    private Float density;
    private String destination;
    private Integer endProgress;
    private Long endTime;
    private Long eventTime;
    private String eventType;
    private List<FeedbackInfo> feedbackInfoList;
    private String installType;
    private Integer intentDest;
    private Integer intentFailReason;
    private String isAdContainerSizeMatched;
    private Boolean isReportNow;
    private String jsVersion;
    private List<String> keyWords;
    private Integer mark;
    private boolean mute;
    private boolean phyShow;
    Integer playedTime;
    private String requestId;
    private Integer screenOrientation;
    private Integer screenX;
    private Integer screenY;
    private String shakeAngle;
    private Long showDuration;
    private Integer showRatio;
    private Integer sld;
    private String slotId;
    private String slotPosition;
    private Integer source;
    private Integer startProgress;
    private long startShowTime;
    private Long startTime;
    private String templateId;
    private String uiengineVersion;
    private Integer upX;
    private Integer upY;
    private String userId;
    private long videoTime;
    private int x;
    private int y;
    private String showId = String.valueOf(w.Code());

    @d
    private boolean isFromExSplash = false;
    private int recallSource = 0;
    private boolean isSupportImpCtrl = true;
    private boolean isSupportClickIntvl = true;

    public Integer A() {
        return this.screenOrientation;
    }

    public int B() {
        return this.adType;
    }

    public Integer C() {
        return this.playedTime;
    }

    public String Code() {
        return this.ctrlExt;
    }

    public Integer D() {
        return this.showRatio;
    }

    public long E() {
        return this.startShowTime;
    }

    public Long F() {
        return this.showDuration;
    }

    public List<FeedbackInfo> G() {
        return this.feedbackInfoList;
    }

    public int H() {
        return this.apiVer;
    }

    public void I(int i) {
        this.y = i;
    }

    public String J() {
        return this.templateId;
    }

    public String K() {
        return this.slotId;
    }

    public Integer L() {
        return this.source;
    }

    public Integer M() {
        return this.sld;
    }

    public Integer N() {
        return this.upX;
    }

    public Integer O() {
        return this.upY;
    }

    public Float P() {
        return this.density;
    }

    public int Q() {
        return this.recallSource;
    }

    public String R() {
        return this.slotPosition;
    }

    public void S(Integer num) {
        this.intentFailReason = num;
    }

    public long T() {
        return this.videoTime;
    }

    public Long U() {
        return this.clickUTime;
    }

    public CtrlExt V() {
        if (this.ctrlExtObj == null) {
            this.ctrlExtObj = (CtrlExt) aa.V(this.ctrlExt, CtrlExt.class, new Class[0]);
        }
        return this.ctrlExtObj;
    }

    public Long W() {
        return this.clickDTime;
    }

    public String X() {
        return this.shakeAngle;
    }

    public Integer Y() {
        return this.mark;
    }

    public String Z() {
        return this.contentId;
    }

    public void a(Integer num) {
        this.screenY = num;
    }

    public String aa() {
        return this.uiengineVersion;
    }

    public String ab() {
        return this.jsVersion;
    }

    public String ac() {
        return this.installType;
    }

    public String b() {
        return this.eventType;
    }

    public Long c() {
        return this.startTime;
    }

    public Long d() {
        return this.endTime;
    }

    public Integer e() {
        return this.startProgress;
    }

    public Integer f() {
        return this.endProgress;
    }

    public int g() {
        return this.x;
    }

    public int h() {
        return this.y;
    }

    public String i() {
        return this.destination;
    }

    public List<String> j() {
        return this.keyWords;
    }

    public Integer k() {
        return this.intentDest;
    }

    public Integer l() {
        return this.intentFailReason;
    }

    public String m() {
        return this.showId;
    }

    public String n() {
        return this.requestId;
    }

    public String o() {
        return this.customData;
    }

    public String p() {
        return this.userId;
    }

    public String q() {
        return this.activityName;
    }

    public String r() {
        return this.isAdContainerSizeMatched;
    }

    public Integer s() {
        return this.clickX;
    }

    public Integer t() {
        return this.clickY;
    }

    public String u() {
        return this.creativeSize;
    }

    public boolean v() {
        return this.isFromExSplash;
    }

    public Long w() {
        return this.eventTime;
    }

    public Boolean x() {
        return this.isReportNow;
    }

    public Integer y() {
        return this.screenX;
    }

    public Integer z() {
        return this.screenY;
    }

    public void B(int i) {
        this.recallSource = i;
    }

    public void C(Integer num) {
        this.intentDest = num;
    }

    public void Code(int i) {
        this.adType = i;
    }

    public void D(Integer num) {
        this.clickY = num;
    }

    public void F(Integer num) {
        this.clickX = num;
    }

    public void I(Integer num) {
        this.source = num;
    }

    public void L(Integer num) {
        this.screenX = num;
    }

    public void S(String str) {
        this.customData = str;
    }

    public void V(int i) {
        this.x = i;
    }

    public void Z(int i) {
        this.apiVer = i;
    }

    public void a(String str) {
        this.creativeSize = str;
    }

    public void b(Integer num) {
        this.screenOrientation = num;
    }

    public void c(Integer num) {
        this.sld = num;
    }

    public void d(Integer num) {
        this.upX = num;
    }

    public void e(Integer num) {
        this.upY = num;
    }

    public void f(Integer num) {
        this.mark = num;
    }

    public void g(String str) {
        this.jsVersion = str;
    }

    public void h(String str) {
        this.installType = str;
    }

    public void B(Integer num) {
        this.endProgress = num;
    }

    public void C(Long l) {
        this.clickDTime = l;
    }

    public void Code(long j) {
        this.startShowTime = j;
    }

    public void D(String str) {
        this.activityName = str;
    }

    public void F(String str) {
        this.userId = str;
    }

    public void I(Long l) {
        this.endTime = l;
    }

    public void L(String str) {
        this.isAdContainerSizeMatched = str;
    }

    public boolean S() {
        return this.phyShow;
    }

    public void V(long j) {
        this.videoTime = j;
    }

    public void Z(Integer num) {
        this.startProgress = num;
    }

    public boolean a() {
        return this.mute;
    }

    public void b(String str) {
        this.templateId = str;
    }

    public void c(String str) {
        this.slotId = str;
    }

    public void d(String str) {
        this.slotPosition = str;
    }

    public void e(String str) {
        this.shakeAngle = str;
    }

    public void f(String str) {
        this.uiengineVersion = str;
    }

    public void B(Long l) {
        this.clickUTime = l;
    }

    public void C(String str) {
        this.requestId = str;
    }

    public void Code(CtrlExt ctrlExt) {
        this.ctrlExtObj = ctrlExt;
    }

    public void I(String str) {
        this.eventType = str;
    }

    public void V(Integer num) {
        this.showRatio = num;
    }

    public void Z(Long l) {
        this.eventTime = l;
    }

    public void B(String str) {
        this.showId = str;
    }

    public void Code(Boolean bool) {
        this.isReportNow = bool;
    }

    public void I(boolean z) {
        this.mute = z;
    }

    public void V(Long l) {
        this.startTime = l;
    }

    public void Z(String str) {
        this.destination = str;
    }

    public void Code(Float f) {
        this.density = f;
    }

    public boolean I() {
        return this.isSupportImpCtrl;
    }

    public void V(String str) {
        this.contentId = str;
    }

    public void Z(boolean z) {
        this.isFromExSplash = z;
    }

    public void Code(Integer num) {
        this.playedTime = num;
    }

    public void V(List<FeedbackInfo> list) {
        this.feedbackInfoList = list;
    }

    public void Code(Long l) {
        this.showDuration = l;
    }

    public void V(boolean z) {
        this.phyShow = z;
    }

    public void Code(String str) {
        this.ctrlExt = str;
    }

    public void Code(List<String> list) {
        this.keyWords = list;
    }

    public void Code(boolean z) {
        this.isSupportImpCtrl = z;
    }
}
