package com.baidu.navisdk.skyeye;

import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.jni.nativeif.JNINaviManager;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ZipUtils;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.v;
import com.baidu.navisdk.util.common.y;
import com.baidu.navisdk.vi.VDeviceAPI;
import com.baidu.nplatform.comjni.engine.JNIEngine;
import com.huawei.openalliance.ad.constant.x;
import com.jieli.watchtesttool.tool.upgrade.OTAManager;
import java.io.File;
import java.io.FilenameFilter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipOutputStream;
import o0oIxXOx.oO;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class c {
    public int f;

    /* renamed from: a, reason: collision with root package name */
    private boolean f7999a = false;
    private boolean b = true;
    public boolean c = false;
    public volatile boolean d = false;
    public int e = 0;
    public String g = null;
    public String h = null;
    public String i = null;
    private final ArrayList j = new ArrayList();
    private final ArrayList<String> k = new ArrayList<>();
    private String l = null;

    /* loaded from: classes7.dex */
    public class b implements FilenameFilter {
        public b(c cVar) {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            if (!TextUtils.isEmpty(str) && str.startsWith("eyespy_")) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: com.baidu.navisdk.skyeye.c$c, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0365c implements FilenameFilter {
        public C0365c(c cVar) {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith("coreLog");
        }
    }

    private boolean a(int i) {
        return i == 128 || i == 1024 || i == 512;
    }

    private void g() {
        this.j.clear();
        this.k.clear();
        this.c = false;
        this.g = null;
        this.h = null;
        this.i = null;
    }

    private boolean h() {
        int i = f.c().c.y;
        if (i < 0) {
            i = -1;
        }
        if ((i & this.e) != 0) {
            return true;
        }
        return false;
    }

    public void b() {
        this.j.clear();
    }

    public String[] c() {
        List<String> keyFileList = SDKDebugFileUtil.getKeyFileList(SDKDebugFileUtil.getSdkLogFilePath(), SDKDebugFileUtil.NORMAL_ALL_LOG);
        String engineNetLogPath = SDKDebugFileUtil.getEngineNetLogPath();
        if (new File(engineNetLogPath).exists()) {
            keyFileList.add(engineNetLogPath);
        }
        String[] strArr = new String[keyFileList.size()];
        keyFileList.toArray(strArr);
        return strArr;
    }

    public void d() {
        this.f7999a = f.c().c.x;
    }

    public boolean e() {
        return this.f7999a;
    }

    public void f() {
        this.f7999a = false;
        a(false);
    }

    private int b(int i, com.baidu.navisdk.skyeye.log.a aVar) {
        if (i != 64 && !a(i)) {
            return 10;
        }
        boolean e2 = y.e(com.baidu.navisdk.framework.a.c().a());
        com.baidu.navisdk.skyeye.log.b bVar = aVar == null ? null : aVar.i;
        if (bVar == null) {
            return 10;
        }
        if (e2) {
            return bVar.b;
        }
        return bVar.c;
    }

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.util.http.center.f {
        public a() {
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str) {
            boolean z;
            LogUtil.e("BNEyeSpyPaperModel", "postUserStatus().ok statusCode=" + i + ", s=" + str);
            if (i == 200) {
                try {
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (new JSONObject(str).optInt("errno", -1) == 0) {
                    z = true;
                    c.this.b = z;
                }
            }
            z = false;
            c.this.b = z;
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str, Throwable th) {
            LogUtil.e("BNEyeSpyPaperModel", "postUserStatus().err statusCode=" + i + ", s=" + str);
            c.this.b = false;
        }
    }

    public void a() {
        if (e() && this.b) {
            return;
        }
        this.f7999a = true;
        a(true);
    }

    /* loaded from: classes7.dex */
    public class e extends com.baidu.navisdk.util.http.center.f {
        public e() {
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str) {
            LogUtil.e("BNEyeSpyPaperModel", "responseString:" + str);
            if (i == 200) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("err_no", -1) == 0) {
                        c.this.l = jSONObject.optJSONObject("result").optString("url");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str, Throwable th) {
            LogUtil.e("BNEyeSpyPaperModel", "responseString:" + str);
        }
    }

    private String[] b(com.baidu.navisdk.skyeye.log.b bVar) {
        long j;
        long j2;
        long j3;
        int i;
        if (bVar != null) {
            j = bVar.b();
            j3 = bVar.a();
            if (y.e(com.baidu.navisdk.framework.a.c().a())) {
                i = (bVar.b * 1048576) / 10;
            } else {
                i = (bVar.c * 1048576) / 10;
            }
            j2 = i;
        } else {
            j = -1;
            j2 = 10485760;
            j3 = -1;
        }
        String[] b2 = com.baidu.navisdk.debug.b.k().b(j, j3);
        if (b2 == null) {
            return null;
        }
        return com.baidu.navisdk.debug.c.a(b2, j2);
    }

    private void a(boolean z) {
        String str = "1";
        try {
            StringBuffer stringBuffer = new StringBuffer();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bduss", "");
            stringBuffer.append("bduss=");
            stringBuffer.append(URLEncoder.encode("", "utf-8"));
            hashMap.put("cuid", a0.e());
            stringBuffer.append("&cuid=");
            stringBuffer.append(URLEncoder.encode(a0.e(), "utf-8"));
            hashMap.put("ignoreLogin", "1");
            stringBuffer.append("&ignoreLogin=");
            stringBuffer.append(URLEncoder.encode("1", "utf-8"));
            hashMap.put("option", z ? "1" : "2");
            stringBuffer.append("&option=");
            if (!z) {
                str = "2";
            }
            stringBuffer.append(URLEncoder.encode(str, "utf-8"));
            hashMap.put(oO.f31192XO, "0");
            stringBuffer.append("&os=");
            stringBuffer.append(URLEncoder.encode("0", "utf-8"));
            hashMap.put("osv", VDeviceAPI.getOsVersion());
            stringBuffer.append("&osv=");
            stringBuffer.append(URLEncoder.encode(VDeviceAPI.getOsVersion(), "utf-8"));
            hashMap.put("sv", a0.k());
            stringBuffer.append("&sv=");
            stringBuffer.append(URLEncoder.encode(a0.k(), "utf-8"));
            com.baidu.navisdk.util.http.a.a(hashMap);
            String str2 = "skyeye" + com.baidu.navisdk.util.http.center.c.a(hashMap) + "b428c8dad16d0bc031b4d7ef4e7bec80";
            hashMap.put(HttpConstants.SIGN, v.b(str2).toLowerCase());
            LogUtil.e("BNEyeSpyPaperModel", "postUserStatus().ok signStr=" + str2);
            com.baidu.navisdk.util.http.center.b.a().a(com.baidu.navisdk.util.http.b.d().b("SkyEyeUser"), hashMap, new a(), null);
        } catch (Exception unused) {
        }
    }

    /* loaded from: classes7.dex */
    public class d extends com.baidu.navisdk.util.http.center.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f8001a;
        final /* synthetic */ ArrayList b;

        public d(File file, ArrayList arrayList) {
            this.f8001a = file;
            this.b = arrayList;
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNEyeSpyPaperModel", "uploadFile onSuccess:" + str);
            }
            if (c.this.e == 64) {
                TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "上报成功");
            }
            File file = this.f8001a;
            if (file != null && file.exists()) {
                try {
                    this.f8001a.delete();
                } catch (Exception e) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.printException("", e);
                    }
                }
            }
            c.this.b((ArrayList<String>) this.b);
            c.this.d = false;
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str, Throwable th) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNEyeSpyPaperModel", "uploadFile onFailure :" + str);
            }
            if (c.this.e == 64) {
                TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "上报失败");
            }
            File file = this.f8001a;
            if (file != null && file.exists()) {
                try {
                    this.f8001a.delete();
                } catch (Exception e) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.printException("", e);
                    }
                }
            }
            c.this.d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            File file = new File(it.next());
            try {
                if (file.getName().contains("netUrlLog")) {
                    JNIEngine.removeUrlLog();
                } else {
                    file.delete();
                }
            } catch (Exception e2) {
                g gVar = g.COMMON;
                if (gVar.d()) {
                    gVar.a("", e2);
                }
            }
        }
    }

    private String b(String str) {
        this.l = null;
        com.baidu.navisdk.util.http.center.e eVar = new com.baidu.navisdk.util.http.center.e();
        eVar.f9300a = false;
        eVar.b = "pic";
        eVar.c = new File(str);
        com.baidu.navisdk.util.http.center.b.a().b("https://appnavi.baidu.com/mop/uploadpic?", null, new e(), eVar);
        if (TextUtils.isEmpty(this.l)) {
            return null;
        }
        return this.l;
    }

    public void a(com.baidu.navisdk.skyeye.log.a aVar) {
        if (!h()) {
            LogUtil.e("BNEyeSpyPaperModel", "uploadLogFile return switcher is off");
            return;
        }
        this.d = true;
        if (this.e == 64) {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "正在上报");
        }
        ArrayList<String> a2 = a(this.e, aVar);
        if (a2.isEmpty()) {
            return;
        }
        int b2 = b(this.e, aVar);
        File a3 = a(a2, b2);
        try {
            if (a(a3, b2)) {
                a3.delete();
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("BNEyeSpyPaperModel", "uploadLogFile size is to large delete ");
                }
                this.d = false;
                return;
            }
            try {
                a(this.j);
            } catch (Exception e2) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.printException("", e2);
                }
            }
            try {
                a(a3, a2, false);
            } catch (Exception e3) {
                LogUtil.e("BNEyeSpyPaperModel", "uploadLogFile Exception : " + e3.getMessage());
                this.d = false;
            }
            g();
        } catch (Exception e4) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("", e4);
            }
            a3.delete();
            this.d = false;
        }
    }

    private ArrayList<String> a(int i, com.baidu.navisdk.skyeye.log.a aVar) {
        String[] list;
        String[] strArr;
        com.baidu.navisdk.skyeye.log.b bVar = aVar == null ? null : aVar.i;
        ArrayList<String> arrayList = new ArrayList<>();
        int i2 = 0;
        if (i == 2048) {
            String[] c = c();
            if (c != null) {
                int length = c.length;
                while (i2 < length) {
                    arrayList.add(c[i2]);
                    i2++;
                }
            }
            return arrayList;
        }
        int i3 = this.e;
        if (i3 == 1 || i3 == 2) {
            new com.baidu.navisdk.skyeye.util.a().b();
        }
        if (a(i) && bVar != null && (bVar.i & 8) != 0 && (strArr = bVar.g) != null && strArr.length > 0) {
            for (String str : strArr) {
                arrayList.add(str);
            }
        }
        String initLogPath = JNINaviManager.sInstance.getInitLogPath(0);
        if (!TextUtils.isEmpty(initLogPath)) {
            arrayList.add(initLogPath);
        }
        String initLogPath2 = JNINaviManager.sInstance.getInitLogPath(1);
        if (!TextUtils.isEmpty(initLogPath2)) {
            arrayList.add(initLogPath2);
        }
        String d2 = com.baidu.navisdk.debug.b.k().d();
        File file = TextUtils.isEmpty(d2) ? null : new File(d2);
        if (file != null && file.exists() && (list = file.list(new b(this))) != null && list.length > 0) {
            for (String str2 : list) {
                arrayList.add(d2 + File.separator + str2);
            }
        }
        if (i == 64 || (a(i) && bVar != null && (bVar.i & 4) != 0)) {
            com.baidu.navisdk.debug.b.k().f();
            String[] a2 = a(bVar);
            if (a2 != null) {
                for (String str3 : a2) {
                    arrayList.add(str3);
                }
            }
        }
        if (i != 64 && (!a(i) || bVar == null || (bVar.i & 2) == 0)) {
            File e2 = com.baidu.navisdk.debug.b.k().e();
            String path = e2 != null ? e2.getPath() : null;
            if (!TextUtils.isEmpty(path)) {
                arrayList.add(path);
            }
        } else {
            String[] b2 = b(bVar);
            if (b2 != null) {
                int length2 = b2.length;
                while (i2 < length2) {
                    arrayList.add(b2[i2]);
                    i2++;
                }
            }
        }
        return arrayList;
    }

    private String[] a(com.baidu.navisdk.skyeye.log.b bVar) {
        long j;
        long j2;
        long j3;
        int i;
        if (bVar != null) {
            j = bVar.b();
            j3 = bVar.a();
            if (y.e(com.baidu.navisdk.framework.a.c().a())) {
                i = (bVar.b * 1048576) / 10;
            } else {
                i = (bVar.c * 1048576) / 10;
            }
            j2 = i * 8;
        } else {
            j = -1;
            j2 = 10485760;
            j3 = -1;
        }
        String[] a2 = com.baidu.navisdk.debug.b.k().a(j, j3);
        if (a2 == null) {
            return null;
        }
        return com.baidu.navisdk.debug.c.a(a2, j2);
    }

    private void a(String str) {
        File[] listFiles = new File(str).listFiles(new C0365c(this));
        if (listFiles != null) {
            for (File file : listFiles) {
                try {
                    file.delete();
                } catch (Exception e2) {
                    if (g.EYE_SPY.c()) {
                        g.EYE_SPY.c("delOldUploadZipFile err :" + e2);
                    }
                }
            }
        }
    }

    private File a(ArrayList<String> arrayList, int i) {
        String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String d2 = com.baidu.navisdk.debug.b.k().d();
        a(d2);
        File file = new File(d2, "coreLog" + format + OTAManager.OTA_ZIP_SUFFIX);
        ZipOutputStream zipOutputStream = null;
        try {
            try {
                file.getParentFile().mkdirs();
                zipOutputStream = ZipUtils.getZipOutputStream(file);
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    File file2 = new File(it.next());
                    if (file2.exists()) {
                        g gVar = g.EYE_SPY;
                        if (gVar.b()) {
                            gVar.b("BNEyeSpyPaperModel", "ZipUtils path:" + file2.getPath());
                        }
                        try {
                            if (!a(file2, 10)) {
                                ZipUtils.zip(file2, zipOutputStream, file2.getName());
                            }
                            long length = (file.length() / 1024) / 1024;
                            if (gVar.b()) {
                                gVar.b("BNEyeSpyPaperModel", "ZipUtils tmpSize:" + length);
                            }
                            if (length > i) {
                                break;
                            }
                        } catch (Exception e2) {
                            g gVar2 = g.EYE_SPY;
                            if (gVar2.e()) {
                                gVar2.g("zipAllFile Exception:" + e2.getMessage());
                            }
                        }
                    }
                }
            } finally {
                ZipUtils.closeStrem(zipOutputStream);
            }
        } catch (Exception e3) {
            g gVar3 = g.EYE_SPY;
            if (gVar3.e()) {
                gVar3.g("zipAllFile getZipOutputStream Exception :" + e3.getMessage());
            }
        }
        return file;
    }

    private void a(File file, ArrayList<String> arrayList, boolean z) throws UnsupportedEncodingException {
        com.baidu.navisdk.util.http.center.e eVar = new com.baidu.navisdk.util.http.center.e();
        eVar.f9300a = true;
        eVar.b = "datafile";
        eVar.c = file;
        StringBuffer stringBuffer = new StringBuffer();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("buildtime", a0.c());
        stringBuffer.append("buildtime=");
        stringBuffer.append(URLEncoder.encode(a0.c(), "utf-8"));
        hashMap.put("content", TextUtils.isEmpty(this.g) ? "" : this.g);
        stringBuffer.append("&content=");
        stringBuffer.append(URLEncoder.encode(TextUtils.isEmpty(this.g) ? "" : this.g, "utf-8"));
        hashMap.put("cuid", a0.e());
        stringBuffer.append("&cuid=");
        stringBuffer.append(URLEncoder.encode(a0.e(), "utf-8"));
        hashMap.put("file_type", "2");
        stringBuffer.append("&file_type=");
        stringBuffer.append(URLEncoder.encode("2", "utf-8"));
        hashMap.put("ignoreLogin", "1");
        stringBuffer.append("&ignoreLogin=");
        stringBuffer.append(URLEncoder.encode("1", "utf-8"));
        hashMap.put("mb", "" + VDeviceAPI.getPhoneType());
        stringBuffer.append("&mb=");
        stringBuffer.append(URLEncoder.encode(VDeviceAPI.getPhoneType(), "utf-8"));
        hashMap.put(oO.f31192XO, "0");
        stringBuffer.append("&os=");
        stringBuffer.append(URLEncoder.encode("0", "utf-8"));
        Iterator<String> it = this.k.iterator();
        String str = "";
        while (it.hasNext()) {
            String next = it.next();
            if (TextUtils.isEmpty(str)) {
                str = next;
            } else {
                str = str + x.aL + next;
            }
        }
        hashMap.put("pic", str);
        stringBuffer.append("&pic=");
        stringBuffer.append(URLEncoder.encode(str, "utf-8"));
        hashMap.put("problem_id", "" + this.e);
        stringBuffer.append("&problem_id=");
        stringBuffer.append(URLEncoder.encode("" + this.e, "utf-8"));
        hashMap.put(StatisticConstants.SCREENSHOT, TextUtils.isEmpty(this.i) ? "" : this.i);
        stringBuffer.append("&screenshot=");
        stringBuffer.append(URLEncoder.encode(TextUtils.isEmpty(this.i) ? "" : this.i, "utf-8"));
        hashMap.put("source", "" + this.e);
        stringBuffer.append("&source=");
        stringBuffer.append(URLEncoder.encode("" + this.e, "utf-8"));
        hashMap.put("sv", a0.k());
        stringBuffer.append("&sv=");
        stringBuffer.append(URLEncoder.encode(a0.k(), "utf-8"));
        com.baidu.navisdk.util.http.a.a(hashMap);
        hashMap.put(HttpConstants.SIGN, v.b("skyeye" + com.baidu.navisdk.util.http.center.c.a(hashMap) + "b428c8dad16d0bc031b4d7ef4e7bec80").toLowerCase());
        com.baidu.navisdk.util.http.center.b.a().b(com.baidu.navisdk.util.http.b.d().b("SkyEyePostLog"), hashMap, new d(file, arrayList), eVar);
    }

    public void a(ArrayList arrayList) {
        this.k.clear();
        this.i = null;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String b2 = b((String) arrayList.get(i));
            if (b2 != null) {
                this.k.add(b2);
            }
        }
        if (this.c) {
            LogUtil.e("BNEyeSpyPaperModel", "isScreenShoting wait 1s");
            try {
                Thread.sleep(1000L);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        String str = this.h;
        if (str != null) {
            this.i = b(str);
        }
    }

    private boolean a(File file, int i) {
        return file.length() > ((long) (i * 1048576));
    }
}
