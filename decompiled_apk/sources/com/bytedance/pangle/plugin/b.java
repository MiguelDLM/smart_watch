package com.bytedance.pangle.plugin;

import XXO0.oIX0oI;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import androidx.annotation.NonNull;
import com.baidu.tts.emstatistics.TtsStatsUploadBag;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.a.a;
import com.bytedance.pangle.c.b;
import com.bytedance.pangle.e.f;
import com.bytedance.pangle.e.g;
import com.bytedance.pangle.i;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.e;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.h;
import com.bytedance.pangle.util.l;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.huawei.openalliance.ad.constant.aw;
import com.huawei.openalliance.ad.constant.x;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final i f10584a = i.a();

    /* loaded from: classes8.dex */
    public static class a extends IOException {
        public /* synthetic */ a(String str, byte b) {
            this(str);
        }

        public /* synthetic */ a(String str, Throwable th, byte b) {
            this(str, th);
        }

        private a(String str) {
            super(str);
        }

        private a(String str, Throwable th) {
            super(str, th);
        }
    }

    public static boolean a(final File file, final String str, final int i) {
        final StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("useOpt;");
        final boolean[] zArr = {false};
        try {
            i iVar = f10584a;
            iVar.a(1000, 0, str, i, null);
            com.bytedance.pangle.log.a a2 = com.bytedance.pangle.log.a.a(ZeusLogger.TAG_INSTALL, "PluginInstaller", "install:".concat(String.valueOf(str)));
            a(com.bytedance.pangle.c.b.e, b.a.r, str, i, -1L, null);
            int b = l.a().b(str, i, aw.ah);
            int b2 = l.a().b(str, i, "load");
            int removeApkEntryFlag = GlobalParam.getInstance().getRemoveApkEntryFlag(str);
            if (b > 3 || b2 > 3) {
                removeApkEntryFlag = 0;
            }
            SharedPreferences.Editor edit = l.a().f10637a.edit();
            edit.putInt("remove_entry_flag_" + str + "_" + i, removeApkEntryFlag);
            edit.apply();
            l.a().c(str, i, false);
            g.a(com.bytedance.pangle.d.c.a(str, i));
            com.bytedance.pangle.a.a.a(new a.InterfaceC0555a() { // from class: com.bytedance.pangle.plugin.b.1
                @Override // com.bytedance.pangle.a.a.InterfaceC0555a
                public final void a() {
                    b.a(file, str, i, stringBuffer);
                }
            }, new a.InterfaceC0555a() { // from class: com.bytedance.pangle.plugin.b.2
                @Override // com.bytedance.pangle.a.a.InterfaceC0555a
                public final void a() {
                    final Map f = b.f(file, str, i, stringBuffer);
                    b.c(file, str, i, stringBuffer);
                    b.a(b.g(file, str, i, stringBuffer), str, i, stringBuffer);
                    if (!com.bytedance.pangle.util.i.f() && !com.bytedance.pangle.util.i.b()) {
                        b.a(str, i, f, stringBuffer);
                        zArr[0] = b.a(str, i, false, stringBuffer);
                        b.a(str, i);
                    } else {
                        final boolean[] zArr2 = {false};
                        com.bytedance.pangle.a.a.a(new a.InterfaceC0555a() { // from class: com.bytedance.pangle.plugin.b.2.1
                            @Override // com.bytedance.pangle.a.a.InterfaceC0555a
                            public final void a() {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                b.a(str, i, f, stringBuffer);
                            }
                        }, new a.InterfaceC0555a() { // from class: com.bytedance.pangle.plugin.b.2.2
                            @Override // com.bytedance.pangle.a.a.InterfaceC0555a
                            public final void a() {
                                boolean[] zArr3 = zArr2;
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                zArr3[0] = b.h(file, str, i, stringBuffer);
                            }
                        });
                        zArr[0] = b.a(str, i, zArr2[0], stringBuffer);
                    }
                }
            });
            g.a(file);
            a(com.bytedance.pangle.c.b.f, b.a.s, str, i, a2.a(), stringBuffer.toString());
            a2.a("success");
            iVar.a(1100, 0, str, i, null);
            return true;
        } catch (Throwable th) {
            if (th instanceof a) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed.", th);
            } else {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed unknown error.", th);
                a(com.bytedance.pangle.c.b.f, b.a.t, str, i, -1L, stringBuffer.toString());
                f10584a.a(1100, -1, str, i, th);
            }
            if (zArr[0]) {
                l.a().a(str, i, aw.ah);
            }
            return false;
        }
    }

    public static /* synthetic */ void c(File file, String str, int i, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        byte b = 0;
        try {
            try {
                PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 4096);
                PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 4096);
                List asList = Arrays.asList(packageInfo.requestedPermissions);
                String[] strArr = packageArchiveInfo.requestedPermissions;
                if (strArr != null && strArr.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (String str2 : packageArchiveInfo.requestedPermissions) {
                        if (!asList.contains(str2)) {
                            arrayList.add(str2);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        ZeusLogger.w("PluginInstaller", "The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)));
                        if (GlobalParam.getInstance().checkPermission()) {
                            throw new a("The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)), b);
                        }
                    }
                }
            } catch (Exception e) {
                a(com.bytedance.pangle.c.b.f, b.a.v, str, i, -1L, null);
                f10584a.a(1100, -4, str, i, e);
                throw new a("安装包权限校验失败", e, b);
            }
        } finally {
            stringBuffer.append("checkPermissions cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(x.aL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, List<ZipEntry>> f(File file, String str, int i, StringBuffer stringBuffer) {
        String str2 = "插件包包含so不符合宿主ABI类型";
        if (GlobalParam.getInstance().checkMatchHostAbi()) {
            long currentTimeMillis = System.currentTimeMillis();
            byte b = 0;
            try {
                try {
                    e<Boolean, Map<String, List<ZipEntry>>> a2 = com.bytedance.pangle.d.b.a(file);
                    boolean booleanValue = a2.f10633a.booleanValue();
                    Map<String, List<ZipEntry>> map = a2.b;
                    if (booleanValue) {
                        return map;
                    }
                    throw new a(str2, b);
                } catch (Exception e) {
                    a(com.bytedance.pangle.c.b.f, b.a.A, str, i, -1L, null);
                    f10584a.a(1100, -5, str, i, e);
                    throw new a(str2, e, b);
                }
            } finally {
                stringBuffer.append("checkMatchHostAbi cost:");
                stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
                stringBuffer.append(x.aL);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(File file, String str, int i, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        String b = com.bytedance.pangle.d.c.b(str, i);
        try {
            try {
                h.a(file.getAbsolutePath(), b);
                return b;
            } catch (Exception e) {
                a(com.bytedance.pangle.c.b.f, b.a.w, str, i, -1L, null);
                f10584a.a(1100, -6, str, i, e);
                throw new a("安装包拷贝失败", e, (byte) 0);
            }
        } finally {
            stringBuffer.append("copyApk cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(x.aL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Not initialized variable reg: 17, insn: 0x01ab: MOVE (r9 I:??[OBJECT, ARRAY]) = (r17 I:??[OBJECT, ARRAY]), block:B:102:0x01ab */
    /* JADX WARN: Not initialized variable reg: 17, insn: 0x01b0: MOVE (r9 I:??[OBJECT, ARRAY]) = (r17 I:??[OBJECT, ARRAY]), block:B:100:0x01b0 */
    public static boolean h(File file, String str, int i, StringBuffer stringBuffer) {
        String str2;
        String str3;
        String str4;
        String str5;
        ZipEntry zipEntry;
        String str6 = ".dex";
        String str7 = "classes";
        String str8 = x.aL;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                int i2 = 1;
                try {
                    if (com.bytedance.pangle.util.i.b()) {
                        try {
                            if (file.exists() && str != null) {
                                ZipFile zipFile = null;
                                try {
                                    ZipFile zipFile2 = new ZipFile(file);
                                    try {
                                        ArrayList arrayList = new ArrayList();
                                        File file2 = new File(com.bytedance.pangle.d.c.i(str, i));
                                        com.bytedance.pangle.e.g.a(file2);
                                        int i3 = 1;
                                        while (true) {
                                            StringBuilder sb = new StringBuilder(str7);
                                            sb.append(i3 == i2 ? "" : Integer.valueOf(i3));
                                            sb.append(str6);
                                            ZipEntry entry = zipFile2.getEntry(sb.toString());
                                            if (entry != null) {
                                                StringBuilder sb2 = new StringBuilder();
                                                sb2.append(str7);
                                                String str9 = str8;
                                                try {
                                                    sb2.append(i3 != 1 ? Integer.valueOf(i3) : "");
                                                    sb2.append(str6);
                                                    g.a aVar = new g.a(file2, sb2.toString());
                                                    String str10 = str6;
                                                    int i4 = 0;
                                                    boolean z = false;
                                                    while (i4 < 3 && !z) {
                                                        try {
                                                            com.bytedance.pangle.e.g.a(zipFile2, entry, aVar, str7);
                                                            str5 = str7;
                                                            zipEntry = entry;
                                                            z = true;
                                                        } catch (IOException e) {
                                                            str5 = str7;
                                                            zipEntry = entry;
                                                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to extract entry from " + aVar.getAbsolutePath(), e);
                                                        }
                                                        int i5 = i4 + 1;
                                                        StringBuilder sb3 = new StringBuilder("Plugin-MultiDex Extraction ");
                                                        sb3.append(z ? AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED : "failed");
                                                        sb3.append(" '");
                                                        sb3.append(aVar.getAbsolutePath());
                                                        sb3.append("': length ");
                                                        sb3.append(aVar.length());
                                                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, sb3.toString());
                                                        if (!z) {
                                                            aVar.delete();
                                                            if (aVar.exists()) {
                                                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to delete corrupted secondary dex '" + aVar.getPath() + "'");
                                                            }
                                                        }
                                                        i4 = i5;
                                                        str7 = str5;
                                                        entry = zipEntry;
                                                    }
                                                    String str11 = str7;
                                                    if (z) {
                                                        arrayList.add(aVar);
                                                        i3++;
                                                        str6 = str10;
                                                        str8 = str9;
                                                        str7 = str11;
                                                        i2 = 1;
                                                    } else {
                                                        throw new IOException("Could not create zip file " + aVar.getAbsolutePath() + " for secondary dex (" + i3 + oIX0oI.I0Io.f4095I0Io);
                                                    }
                                                } catch (Throwable th) {
                                                    th = th;
                                                    zipFile = zipFile2;
                                                    com.bytedance.pangle.util.g.a(zipFile);
                                                    throw th;
                                                }
                                            } else {
                                                str4 = str8;
                                                file.getName();
                                                String str12 = str + HelpFormatter.DEFAULT_OPT_PREFIX + i;
                                                SharedPreferences.Editor edit = com.bytedance.pangle.e.g.a().edit();
                                                edit.putInt(str12 + ".dex.number", arrayList.size());
                                                edit.commit();
                                                com.bytedance.pangle.util.g.a(zipFile2);
                                                com.bytedance.pangle.e.b.a(Zeus.getAppApplication()).edit().putInt(str, i).apply();
                                                f.a();
                                                break;
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            } else {
                                throw new IOException("Could not check apk info " + file.getAbsolutePath());
                            }
                        } catch (Exception e2) {
                            e = e2;
                            a(com.bytedance.pangle.c.b.f, b.a.z, str, i, -1L, null);
                            throw new a("dexOpt1失败", e, (byte) 0);
                        } catch (Throwable th4) {
                            th = th4;
                            stringBuffer.append("dexOpt1 cost:");
                            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
                            stringBuffer.append(str8);
                            throw th;
                        }
                    } else {
                        str4 = x.aL;
                        if (com.bytedance.pangle.util.i.f()) {
                            String c = com.bytedance.pangle.d.c.c(str, i);
                            String b = com.bytedance.pangle.d.c.b(str, i);
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(c);
                            String str13 = File.separator;
                            sb4.append(str13);
                            sb4.append(com.bytedance.pangle.e.b.a(b));
                            String sb5 = sb4.toString();
                            if (com.bytedance.pangle.e.b.a(b, c + str13 + com.bytedance.pangle.e.b.a(b)) && com.bytedance.pangle.e.b.a(sb5)) {
                                stringBuffer.append("dexOpt1 cost:");
                                stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
                                stringBuffer.append(str4);
                                return true;
                            }
                        }
                    }
                    String str14 = str4;
                    stringBuffer.append("dexOpt1 cost:");
                    stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
                    stringBuffer.append(str14);
                    return false;
                } catch (Exception e3) {
                    e = e3;
                    str8 = str3;
                } catch (Throwable th5) {
                    th = th5;
                    str8 = str2;
                }
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private static void a(String str, int i, @NonNull String str2, int i2, long j, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt(TtsStatsUploadBag.KEY_HTTP_STATUS_CODE, com.bytedance.pangle.log.b.a(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.b.a(str2));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.b.a(Integer.valueOf(i2)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.bytedance.pangle.log.b.b(Long.valueOf(j))));
            jSONObject2.putOpt("message", com.bytedance.pangle.log.b.a(str3));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.bytedance.pangle.c.b.a().a(str, jSONObject, jSONObject3, jSONObject2);
    }

    public static /* synthetic */ void a(File file, String str, int i, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                if (com.bytedance.pangle.g.e.a(file.getAbsolutePath(), str)) {
                } else {
                    throw new RuntimeException("安装包签名校验失败[1]");
                }
            } catch (Exception e) {
                a(com.bytedance.pangle.c.b.f, b.a.u, str, i, -1L, null);
                f10584a.a(1100, -3, str, i, e);
                throw new a(e.getMessage(), e, (byte) 0);
            }
        } finally {
            stringBuffer.append("checkSignature cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(x.aL);
        }
    }

    public static /* synthetic */ void a(String str, String str2, int i, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        byte b = 0;
        int a2 = new com.bytedance.pangle.res.a.c().a(new File(str), false, sb);
        stringBuffer.append(a2 == 100 ? "modifyRes" : "noModifyRes");
        stringBuffer.append(" cost:");
        stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
        stringBuffer.append(x.aL);
        if (a2 == 100 || a2 == 200) {
            return;
        }
        String sb2 = sb.toString();
        a(com.bytedance.pangle.c.b.f, b.a.B, str2, i, -1L, sb2);
        f10584a.a(1100, -2, str2, i, null);
        throw new a("modifyRes failed. result = " + a2 + ", errorLog = " + sb2, b);
    }

    public static /* synthetic */ void a(String str, int i, Map map, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                com.bytedance.pangle.d.b.a(new File(com.bytedance.pangle.d.c.b(str, i)), new File(com.bytedance.pangle.d.c.d(str, i)), str, (Map<String, List<ZipEntry>>) map);
            } catch (Exception e) {
                a(com.bytedance.pangle.c.b.f, b.a.x, str, i, -1L, com.bytedance.pangle.log.b.a((Object) e));
                f10584a.a(1100, -7, str, i, e);
                throw new a("安装包动态库拷贝失败", e, (byte) 0);
            }
        } finally {
            stringBuffer.append("copySo cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(x.aL);
        }
    }

    public static /* synthetic */ boolean a(String str, int i, boolean z, StringBuffer stringBuffer) {
        int b = l.a().b(str, i);
        boolean z2 = (b & 1) != 0;
        boolean z3 = (b & 2) != 0;
        if (!z2 && !z3) {
            stringBuffer.append("removeEntry skip;");
            return false;
        }
        boolean z4 = z && z2;
        String b2 = com.bytedance.pangle.d.c.b(str, i);
        long currentTimeMillis = System.currentTimeMillis();
        boolean a2 = com.bytedance.pangle.util.b.b.a(b2, z4, z3, str, i, 1);
        stringBuffer.append("removeEntry cost:");
        stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
        stringBuffer.append(x.aL);
        return a2;
    }

    public static /* synthetic */ void a(String str, int i) {
        byte b = 0;
        try {
            if (!com.bytedance.pangle.util.i.e() && !com.bytedance.pangle.util.i.g()) {
                return;
            }
            l.a().b(str, i, false);
            com.bytedance.pangle.e.b.a(Zeus.getAppApplication()).edit().putInt(str, i).apply();
            f.a();
        } catch (Exception e) {
            a(com.bytedance.pangle.c.b.f, b.a.z, str, i, -1L, null);
            throw new a("dexOpt2失败", e, b);
        }
    }
}
