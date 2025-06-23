package O00;

import OXOo.OOXIXo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.net.Uri;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nThirdPartyUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThirdPartyUtils.kt\ncom/sma/androidthirdpartylogin/ThirdPartyUtils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,77:1\n1855#2,2:78\n*S KotlinDebug\n*F\n+ 1 ThirdPartyUtils.kt\ncom/sma/androidthirdpartylogin/ThirdPartyUtils\n*L\n46#1:78,2\n*E\n"})
/* loaded from: classes11.dex */
public final class I0Io {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final I0Io f1137oIX0oI = new I0Io();

    public final boolean I0Io(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        IIX0o.oO(installedPackages, "getInstalledPackages(...)");
        int size = installedPackages.size();
        for (int i = 0; i < size; i++) {
            if (IIX0o.Oxx0IOOO(installedPackages.get(i).packageName, "com.sina.weibo")) {
                return true;
            }
        }
        return false;
    }

    public final boolean II0xO0(@OOXIXo Context context) {
        ApplicationInfo applicationInfo;
        IIX0o.x0xO0oo(context, "context");
        Iterator it = CollectionsKt__CollectionsKt.XOxIOxOx(com.tencent.connect.common.II0xO0.f26792Oxx0IOOO, "com.tencent.mobileqq").iterator();
        while (it.hasNext()) {
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo((String) it.next(), 0);
            } catch (Exception unused) {
                applicationInfo = null;
            }
            if (applicationInfo != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean oIX0oI(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        if (new Intent("android.intent.action.VIEW", Uri.parse("alipays://platformapi/startApp")).resolveActivity(context.getPackageManager()) != null) {
            return true;
        }
        return false;
    }

    public final boolean oxoX(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        IIX0o.oO(installedPackages, "getInstalledPackages(...)");
        int size = installedPackages.size();
        for (int i = 0; i < size; i++) {
            if (IIX0o.Oxx0IOOO(installedPackages.get(i).packageName, "com.tencent.mm")) {
                return true;
            }
        }
        return false;
    }
}
