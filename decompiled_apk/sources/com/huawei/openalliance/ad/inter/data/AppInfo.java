package com.huawei.openalliance.ad.inter.data;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.ad.beans.metadata.InstallConfig;
import com.huawei.openalliance.ad.beans.metadata.Permission;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.bf;
import com.huawei.openalliance.ad.utils.w;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@DataKeep
/* loaded from: classes10.dex */
public class AppInfo implements com.huawei.openalliance.ad.inter.listeners.l, Serializable {
    private static final String TAG = "AppInfo";
    private static final long serialVersionUID = 30414300;
    private String actName;
    private String afDlBtnText;
    private long allAreaPopDelay;
    private String appDesc;
    private String appDetailsUrl;
    private String appName;
    private int appType;
    private int autoOpenAfterInstall;
    private List<Integer> btnClickActionList;
    private boolean checkSha256;
    private String contentInstallBtnAction;
    private String contiBtn;
    private String curInstallWay;
    private String developerName;
    private String dlBtnText;
    private String downloadUrl;
    private long fileSize;
    private Integer hasPermissions;
    private String iconUrl;
    private InstallConfig installConfig;
    private String installPermiText;
    private String installPureModeText;
    private String intent;
    private String intentPackage;
    private String intentUri;
    private String nextInstallWays;
    private String packageName;
    private boolean permPromptForCard;
    private boolean permPromptForLanding;
    private String permissionUrl;
    private List<PermissionEntity> permissions;
    private int popNotify;
    private String popUpAfterInstallText;
    private int popUpStyle;
    private String priorInstallWay;
    private String privacyUrl;
    private String pureModeText;
    private String realPkgName;
    private transient String remoteAfDlBtnText;
    private transient String remoteDlBtnText;
    private String reservedPkgName;
    private String safeDownloadUrl;
    private String sha256;
    private int trafficReminder;
    private String uniqueId;
    private String versionCode;
    private String versionName;

    /* renamed from: com.huawei.openalliance.ad.inter.data.AppInfo$3, reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[com.huawei.openalliance.ad.download.app.k.values().length];
            Code = iArr;
            try {
                iArr[com.huawei.openalliance.ad.download.app.k.INSTALLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[com.huawei.openalliance.ad.download.app.k.DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public AppInfo() {
        this.permPromptForCard = true;
        this.permPromptForLanding = false;
        this.appType = 1;
    }

    public static long J() {
        return serialVersionUID;
    }

    public String A() {
        return this.actName;
    }

    @com.huawei.openalliance.ad.annotations.b
    public long B() {
        return this.fileSize;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String C() {
        return this.sha256;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String Code() {
        return this.packageName;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String D() {
        return this.intentUri;
    }

    public List<Integer> E() {
        return this.btnClickActionList;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String F() {
        return this.safeDownloadUrl;
    }

    public int G() {
        return this.appType;
    }

    public long H() {
        return this.allAreaPopDelay;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String I() {
        return this.iconUrl;
    }

    public int K() {
        return this.popUpStyle;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String L() {
        String str = this.appName;
        return str == null ? "" : str;
    }

    public String M() {
        return this.installPermiText;
    }

    public String N() {
        return this.pureModeText;
    }

    public String O() {
        return this.installPureModeText;
    }

    public String P() {
        return this.contiBtn;
    }

    public String Q() {
        return this.reservedPkgName;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String R() {
        return this.realPkgName;
    }

    public void S(String str) {
        this.afDlBtnText = str;
    }

    public String T() {
        return this.contentInstallBtnAction;
    }

    public int U() {
        return this.autoOpenAfterInstall;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String V() {
        return this.versionCode;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String Z() {
        return this.downloadUrl;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String a() {
        String str = this.appDesc;
        return str == null ? "" : str;
    }

    @com.huawei.openalliance.ad.annotations.b
    public List<PermissionEntity> b() {
        return this.permissions;
    }

    public void c(String str) {
        this.nextInstallWays = str;
    }

    public void d(String str) {
        this.curInstallWay = str;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String e() {
        return this.uniqueId;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String f() {
        String str = this.developerName;
        return str == null ? "" : str;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String g() {
        String str = this.versionName;
        return str == null ? "" : str;
    }

    public int h() {
        return this.trafficReminder;
    }

    public String i() {
        return TextUtils.isEmpty(this.priorInstallWay) ? "4" : this.priorInstallWay;
    }

    public String j() {
        return this.intent;
    }

    public String k() {
        return this.intentPackage;
    }

    public String l() {
        return this.dlBtnText;
    }

    public String m() {
        return this.afDlBtnText;
    }

    public String n() {
        return this.remoteDlBtnText;
    }

    public String o() {
        return this.remoteAfDlBtnText;
    }

    public int p() {
        return this.popNotify;
    }

    public String q() {
        return this.popUpAfterInstallText;
    }

    public String r() {
        return this.privacyUrl;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.l
    @com.huawei.openalliance.ad.annotations.b
    public String s() {
        return this.privacyUrl;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.l
    @com.huawei.openalliance.ad.annotations.b
    public String t() {
        return this.permissionUrl;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.l
    @com.huawei.openalliance.ad.annotations.b
    public String u() {
        return this.appDetailsUrl;
    }

    public boolean v() {
        Integer num = this.hasPermissions;
        return num != null ? num.intValue() == 1 : !ad.Code(this.permissions);
    }

    public boolean w() {
        if (TextUtils.isEmpty(this.packageName)) {
            return false;
        }
        String z = z();
        if (TextUtils.isEmpty(z)) {
            return false;
        }
        return z.equals("8") || z.equals("6") || z.equals("5");
    }

    public String x() {
        return this.nextInstallWays;
    }

    public String y() {
        return this.curInstallWay;
    }

    public String z() {
        String y = y();
        return TextUtils.isEmpty(y) ? i() : y;
    }

    public AppInfo(ApkInfo apkInfo) {
        this.permPromptForCard = true;
        this.permPromptForLanding = false;
        this.appType = 1;
        if (apkInfo != null) {
            this.appName = ay.V(apkInfo.D());
            this.iconUrl = apkInfo.i();
            this.packageName = apkInfo.Code();
            this.versionCode = apkInfo.Z();
            this.versionName = apkInfo.N();
            this.developerName = ay.V(apkInfo.M());
            this.downloadUrl = apkInfo.B();
            this.appDetailsUrl = apkInfo.I();
            this.permissionUrl = apkInfo.V();
            this.fileSize = apkInfo.C();
            this.sha256 = apkInfo.S();
            this.checkSha256 = apkInfo.u() == 0;
            this.safeDownloadUrl = apkInfo.F();
            this.permPromptForCard = "1".equals(apkInfo.d());
            this.permPromptForLanding = "1".equals(apkInfo.e());
            this.dlBtnText = ay.V(apkInfo.p());
            this.afDlBtnText = ay.V(apkInfo.q());
            this.popNotify = apkInfo.r();
            this.popUpAfterInstallText = apkInfo.g();
            Code(apkInfo.L());
            this.iconUrl = apkInfo.i();
            this.appDesc = ay.V(apkInfo.k());
            this.trafficReminder = apkInfo.m();
            String a2 = apkInfo.a();
            if (!TextUtils.isEmpty(a2)) {
                this.priorInstallWay = a2;
            }
            String b = apkInfo.b();
            if (!TextUtils.isEmpty(b)) {
                this.contentInstallBtnAction = b;
            }
            this.installConfig = apkInfo.c();
            this.curInstallWay = this.priorInstallWay;
            this.intent = apkInfo.n();
            this.intentPackage = apkInfo.o();
            this.hasPermissions = apkInfo.s();
            this.nextInstallWays = apkInfo.t();
            this.actName = apkInfo.v();
            this.btnClickActionList = apkInfo.w();
            this.appType = apkInfo.x();
            this.allAreaPopDelay = apkInfo.y();
            this.popUpStyle = apkInfo.z();
            this.installPermiText = apkInfo.A();
            this.pureModeText = apkInfo.E();
            this.installPureModeText = apkInfo.E();
            this.contiBtn = apkInfo.H();
            this.reservedPkgName = apkInfo.J();
            this.realPkgName = apkInfo.K();
            this.autoOpenAfterInstall = apkInfo.O();
        }
    }

    public void B(String str) {
        this.intentPackage = str;
    }

    public void C(String str) {
        this.dlBtnText = str;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String Code(com.huawei.openalliance.ad.download.app.k kVar) {
        int i = AnonymousClass3.Code[kVar.ordinal()];
        if (i == 1) {
            return this.afDlBtnText;
        }
        if (i != 2) {
            return null;
        }
        return this.dlBtnText;
    }

    public void D(String str) {
        this.remoteAfDlBtnText = str;
    }

    public void F(String str) {
        this.remoteDlBtnText = str;
    }

    public void I(int i) {
        this.popUpStyle = i;
    }

    public void L(String str) {
        this.popUpAfterInstallText = str;
    }

    @com.huawei.openalliance.ad.annotations.b
    public boolean S() {
        return this.checkSha256;
    }

    public void Z(String str) {
        this.intent = str;
    }

    public void a(String str) {
        this.privacyUrl = str;
    }

    public void b(String str) {
        this.packageName = str;
    }

    @com.huawei.openalliance.ad.annotations.b
    public boolean c() {
        return this.permPromptForCard;
    }

    @com.huawei.openalliance.ad.annotations.b
    public boolean d() {
        return this.permPromptForLanding;
    }

    public void e(String str) {
        this.actName = str;
    }

    public void f(String str) {
        this.installPermiText = str;
    }

    public void g(String str) {
        this.pureModeText = str;
    }

    public void h(String str) {
        this.installPureModeText = str;
    }

    public void i(String str) {
        this.contiBtn = str;
    }

    public void j(String str) {
        this.reservedPkgName = str;
    }

    public void k(String str) {
        this.realPkgName = str;
    }

    public void l(String str) {
        this.contentInstallBtnAction = str;
    }

    public void I(String str) {
        this.priorInstallWay = str;
    }

    public void V(int i) {
        this.appType = i;
    }

    public void Code(int i) {
        this.popNotify = i;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.l
    @com.huawei.openalliance.ad.annotations.b
    public void V(final Context context) {
        if (TextUtils.isEmpty(this.permissionUrl)) {
            fb.V(TAG, "load privacy link is empty.");
        } else {
            bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.data.AppInfo.2
                @Override // java.lang.Runnable
                public void run() {
                    w.Code(context, AppInfo.this.permissionUrl);
                }
            });
        }
    }

    public void Code(long j) {
        this.allAreaPopDelay = j;
    }

    public void V(String str) {
        this.uniqueId = str;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.l
    @com.huawei.openalliance.ad.annotations.b
    public void Code(final Context context) {
        if (TextUtils.isEmpty(this.privacyUrl)) {
            fb.V(TAG, "load privacy link is empty.");
        } else {
            bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.data.AppInfo.1
                @Override // java.lang.Runnable
                public void run() {
                    w.Code(context, AppInfo.this.privacyUrl);
                }
            });
        }
    }

    public void V(List<Integer> list) {
        this.btnClickActionList = list;
    }

    public void Code(String str) {
        this.intentUri = str;
    }

    public void Code(List<Permission> list) {
        StringBuilder sb;
        String sb2;
        if (list == null || list.size() <= 0) {
            return;
        }
        try {
            ArrayMap arrayMap = new ArrayMap();
            for (Permission permission : list) {
                List list2 = (List) arrayMap.get(permission.V());
                if (list2 == null) {
                    list2 = new ArrayList();
                    arrayMap.put(permission.V(), list2);
                }
                list2.add(new PermissionEntity(ay.V(permission.Code()), 1));
            }
            this.permissions = new ArrayList();
            for (Map.Entry entry : arrayMap.entrySet()) {
                this.permissions.add(new PermissionEntity(ay.V((String) entry.getKey()), 0));
                this.permissions.addAll((Collection) entry.getValue());
            }
        } catch (RuntimeException e) {
            sb2 = "parsePermission RuntimeException:" + e.getClass().getSimpleName();
            fb.Z(TAG, sb2);
        } catch (Exception e2) {
            e = e2;
            sb = new StringBuilder();
            sb.append("parsePermission Exception:");
            sb.append(e.getClass().getSimpleName());
            sb2 = sb.toString();
            fb.Z(TAG, sb2);
        } catch (Throwable th) {
            e = th;
            sb = new StringBuilder();
            sb.append("parsePermission Exception:");
            sb.append(e.getClass().getSimpleName());
            sb2 = sb.toString();
            fb.Z(TAG, sb2);
        }
    }
}
