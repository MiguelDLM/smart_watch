package com.huawei.openalliance.ad.beans.metadata;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.annotations.c;
import java.io.Serializable;
import java.util.List;

@DataKeep
/* loaded from: classes10.dex */
public class ApkInfo implements Serializable {
    private static final long serialVersionUID = 5884421861234973073L;
    private String actName;
    private String afDlBtnText;
    private long allAreaPopDelay;
    private String appDesc;
    private String appName;
    private int autoOpenAfterInstall;
    private List<Integer> btnClickActionList;
    private String channelInfo;
    private int checkSha256Flag;
    private String contentBtnAction;
    private String contiBtn;
    private String detailUrl;
    private String developerName;
    private String dlBtnText;
    private long fileSize;

    @c(Code = "hasper")
    private Integer hasPermission;

    @c(Code = TTDownloadField.TT_APP_ICON)
    @com.huawei.openalliance.ad.annotations.a
    private String iconUrl;
    private InstallConfig installConfig;
    private String installPermiText;
    private String installPureModeText;
    private String intent;
    private String intentPackage;
    private String nextInstallWays;
    private int noAlertTime;
    private String packageName;
    private String permissionUrl;
    private List<Permission> permissions;
    private int popUpAfterInstallNew;
    private String popUpAfterInstallText;
    private int popUpStyle;
    private String priorInstallWay;
    private String pureModeText;
    private String realPkgName;
    private String reservedPkgName;

    @com.huawei.openalliance.ad.annotations.a
    private String secondUrl;
    private String sha256;
    private int trafficReminder;

    @com.huawei.openalliance.ad.annotations.a
    private String url;
    private String versionCode;
    private String versionName;
    private String permPromptForCard = "1";
    private String permPromptForLanding = "0";
    private int channelInfoSaveLimit = -2;
    private int popNotify = 1;
    private int appType = 1;

    public String A() {
        return this.installPermiText;
    }

    public String B() {
        return this.url;
    }

    public long C() {
        return this.fileSize;
    }

    public String Code() {
        return this.packageName;
    }

    public String D() {
        return this.appName;
    }

    public String E() {
        return this.pureModeText;
    }

    public String F() {
        return this.secondUrl;
    }

    public String G() {
        return this.installPureModeText;
    }

    public String H() {
        return this.contiBtn;
    }

    public String I() {
        return this.detailUrl;
    }

    public String J() {
        return this.reservedPkgName;
    }

    public String K() {
        return this.realPkgName;
    }

    public List<Permission> L() {
        return this.permissions;
    }

    public String M() {
        return this.developerName;
    }

    public String N() {
        return this.versionName;
    }

    public int O() {
        return this.autoOpenAfterInstall;
    }

    public String S() {
        return this.sha256;
    }

    public String V() {
        return this.permissionUrl;
    }

    public String Z() {
        return this.versionCode;
    }

    public String a() {
        return this.priorInstallWay;
    }

    public String b() {
        return this.contentBtnAction;
    }

    public InstallConfig c() {
        return this.installConfig;
    }

    public String d() {
        String str = this.permPromptForCard;
        return str == null ? "1" : str;
    }

    public String e() {
        String str = this.permPromptForLanding;
        return str == null ? "0" : str;
    }

    public int f() {
        return this.popUpAfterInstallNew;
    }

    public String g() {
        return this.popUpAfterInstallText;
    }

    public String h() {
        return this.channelInfo;
    }

    public String i() {
        return this.iconUrl;
    }

    public int j() {
        return this.channelInfoSaveLimit;
    }

    public String k() {
        return this.appDesc;
    }

    public int l() {
        return this.noAlertTime;
    }

    public int m() {
        return this.trafficReminder;
    }

    public String n() {
        return this.intent;
    }

    public String o() {
        return this.intentPackage;
    }

    public String p() {
        return this.dlBtnText;
    }

    public String q() {
        return this.afDlBtnText;
    }

    public int r() {
        return this.popNotify;
    }

    public Integer s() {
        return this.hasPermission;
    }

    public String t() {
        return this.nextInstallWays;
    }

    public int u() {
        return this.checkSha256Flag;
    }

    public String v() {
        return this.actName;
    }

    public List<Integer> w() {
        return this.btnClickActionList;
    }

    public int x() {
        return this.appType;
    }

    public long y() {
        return this.allAreaPopDelay;
    }

    public int z() {
        return this.popUpStyle;
    }

    public void B(int i) {
        this.popNotify = i;
    }

    public void C(int i) {
        this.checkSha256Flag = i;
    }

    public void Code(int i) {
        this.popUpAfterInstallNew = i;
    }

    public void D(int i) {
        this.autoOpenAfterInstall = i;
    }

    public void F(int i) {
        this.popUpStyle = i;
    }

    public void I(int i) {
        this.noAlertTime = i;
    }

    public void L(String str) {
        this.contentBtnAction = str;
    }

    public void S(int i) {
        this.appType = i;
    }

    public void V(int i) {
        this.channelInfoSaveLimit = i;
    }

    public void Z(int i) {
        this.trafficReminder = i;
    }

    public void a(String str) {
        this.permPromptForCard = str;
    }

    public void b(String str) {
        this.permPromptForLanding = str;
    }

    public void c(String str) {
        this.popUpAfterInstallText = str;
    }

    public void d(String str) {
        this.channelInfo = str;
    }

    public void e(String str) {
        this.iconUrl = str;
    }

    public void f(String str) {
        this.appDesc = str;
    }

    public void g(String str) {
        this.intent = str;
    }

    public void h(String str) {
        this.intentPackage = str;
    }

    public void i(String str) {
        this.dlBtnText = str;
    }

    public void j(String str) {
        this.afDlBtnText = str;
    }

    public void k(String str) {
        this.nextInstallWays = str;
    }

    public void l(String str) {
        this.actName = str;
    }

    public void m(String str) {
        this.installPermiText = str;
    }

    public void n(String str) {
        this.pureModeText = str;
    }

    public void o(String str) {
        this.installPureModeText = str;
    }

    public void p(String str) {
        this.contiBtn = str;
    }

    public void q(String str) {
        this.reservedPkgName = str;
    }

    public void r(String str) {
        this.realPkgName = str;
    }

    public void s(String str) {
        this.developerName = str;
    }

    public void t(String str) {
        this.versionName = str;
    }

    public void B(String str) {
        this.url = str;
    }

    public void C(String str) {
        this.sha256 = str;
    }

    public void Code(long j) {
        this.fileSize = j;
    }

    public void D(String str) {
        this.priorInstallWay = str;
    }

    public void F(String str) {
        this.appName = str;
    }

    public void I(String str) {
        this.detailUrl = str;
    }

    public void S(String str) {
        this.secondUrl = str;
    }

    public void V(long j) {
        this.allAreaPopDelay = j;
    }

    public void Z(String str) {
        this.versionCode = str;
    }

    public void Code(InstallConfig installConfig) {
        this.installConfig = installConfig;
    }

    public void V(String str) {
        this.permissionUrl = str;
    }

    public void Code(Integer num) {
        this.hasPermission = num;
    }

    public void V(List<Integer> list) {
        this.btnClickActionList = list;
    }

    public void Code(String str) {
        this.packageName = str;
    }

    public void Code(List<Permission> list) {
        this.permissions = list;
    }
}
