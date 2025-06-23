package com.baidu.navisdk.module.carlogo.control;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ZipUtils;
import com.baidu.navisdk.util.common.s;
import com.baidu.navisdk.util.common.y;
import com.baidu.navisdk.util.common.z;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<com.baidu.navisdk.module.carlogo.datas.c> f7067a;
    private com.baidu.navisdk.module.carlogo.interfaces.a b;
    private boolean c;
    private com.baidu.navisdk.module.carlogo.listeners.d d;
    private ConcurrentHashMap<String, com.baidu.navisdk.module.carlogo.datas.b> e;
    private final Object f;
    private ConcurrentHashMap<String, com.baidu.navisdk.module.carlogo.datas.b> g;
    private final Object h;
    private int i;
    private com.baidu.navisdk.util.worker.f j;
    private com.baidu.navisdk.module.carlogo.listeners.c k;
    private boolean l;
    private int m;

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.util.worker.f<String, String> {
        public a(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            if (c.this.d != null) {
                c.this.d.a(null);
            }
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements com.baidu.navisdk.module.carlogo.listeners.d {
        public b() {
        }

        @Override // com.baidu.navisdk.module.carlogo.listeners.d
        public void a(String str) {
            if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                LogUtil.e("BN3DDataManager", "request3DList.onSuccess responseStr = " + str);
            }
            boolean c = c.this.c(str);
            c.this.c = false;
            if (c.this.d != null) {
                if (c) {
                    c.this.d.a(null);
                } else {
                    c.this.d.onFailed();
                }
            }
        }

        @Override // com.baidu.navisdk.module.carlogo.listeners.d
        public void onFailed() {
            if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                LogUtil.e("BN3DDataManager", "request3DList.onFailed: ");
            }
            c.this.c = false;
            if (c.this.d != null) {
                c.this.d.onFailed();
            }
        }

        @Override // com.baidu.navisdk.module.carlogo.listeners.d
        public void onStart() {
            if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                LogUtil.e("BN3DDataManager", "request3DList.onStart: ");
            }
            if (c.this.d != null) {
                c.this.d.onStart();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends com.baidu.navisdk.util.worker.f<String, String> {
        public d(String str, String str2) {
            super(str, str2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            com.baidu.navisdk.module.carlogo.datas.b bVar;
            com.baidu.navisdk.module.carlogo.datas.b bVar2;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                LogUtil.e(com.baidu.navisdk.util.worker.g.TAG, "mainThread download zip failed.execute: ");
            }
            c.this.a(2, (String) this.inData);
            if (c.this.g != null) {
                bVar = (com.baidu.navisdk.module.carlogo.datas.b) c.this.g.remove(this.inData);
                if (gVar.d()) {
                    LogUtil.e(com.baidu.navisdk.util.worker.g.TAG, "mainThread download zip failed.execute otherRequest: " + bVar);
                }
                if (bVar != null) {
                    bVar.b.a((String) this.inData);
                }
            } else {
                bVar = null;
            }
            if (c.this.e != null && (bVar2 = (com.baidu.navisdk.module.carlogo.datas.b) c.this.e.remove(this.inData)) != null && !bVar2.equals(bVar)) {
                bVar2.b.a((String) this.inData);
            }
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class e extends com.baidu.navisdk.util.worker.f<Boolean, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7072a;
        final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, Boolean bool, String str2, String str3) {
            super(str, bool);
            this.f7072a = str2;
            this.b = str3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            com.baidu.navisdk.module.carlogo.datas.b bVar;
            if (((Boolean) this.inData).booleanValue()) {
                c.this.a(this.f7072a, this.b);
            } else {
                c.this.a(2, this.f7072a);
            }
            if (c.this.g != null) {
                bVar = (com.baidu.navisdk.module.carlogo.datas.b) c.this.g.remove(this.f7072a);
                if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                    LogUtil.e(com.baidu.navisdk.util.worker.g.TAG, "mainThread zip onSuccess.execute otherRequest: " + bVar);
                }
                if (bVar != null) {
                    if (((Boolean) this.inData).booleanValue()) {
                        bVar.b.a(this.f7072a, this.b);
                    } else {
                        bVar.b.a(this.f7072a);
                    }
                }
            } else {
                bVar = null;
            }
            if (c.this.e != null) {
                com.baidu.navisdk.module.carlogo.datas.b bVar2 = (com.baidu.navisdk.module.carlogo.datas.b) c.this.e.remove(this.f7072a);
                if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                    LogUtil.e(com.baidu.navisdk.util.worker.g.TAG, "mainThread zip onSuccess.execute: " + this.inData);
                }
                if (bVar2 != null && !bVar2.equals(bVar)) {
                    if (((Boolean) this.inData).booleanValue()) {
                        bVar2.b.a(this.f7072a, this.b);
                    } else {
                        bVar2.b.a(this.f7072a);
                    }
                }
            }
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class f extends com.baidu.navisdk.util.worker.f<Integer, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7073a;
        final /* synthetic */ int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, Integer num, String str2, int i) {
            super(str, num);
            this.f7073a = str2;
            this.b = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            com.baidu.navisdk.module.carlogo.datas.b bVar;
            com.baidu.navisdk.module.carlogo.datas.b bVar2;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                LogUtil.e(com.baidu.navisdk.util.worker.g.TAG, "mainThread zip onProgress.execute: " + this.inData);
            }
            if (c.this.g != null) {
                bVar = (com.baidu.navisdk.module.carlogo.datas.b) c.this.g.get(this.f7073a);
                if (gVar.d()) {
                    LogUtil.e(com.baidu.navisdk.util.worker.g.TAG, "mainThread zip onProgress.execute otherRequest: " + bVar);
                }
                if (bVar != null && bVar.f7076a) {
                    bVar.b.a(this.b, this.f7073a);
                }
            } else {
                bVar = null;
            }
            if (c.this.e != null && (bVar2 = (com.baidu.navisdk.module.carlogo.datas.b) c.this.e.get(this.f7073a)) != null && bVar2.f7076a && !bVar2.equals(bVar)) {
                bVar2.b.a(((Integer) this.inData).intValue(), this.f7073a);
            }
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public static final class h {

        /* renamed from: a, reason: collision with root package name */
        private static c f7074a = new c(null);
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    private void d() {
        if (this.e == null) {
            ArrayList<com.baidu.navisdk.module.carlogo.datas.c> arrayList = this.f7067a;
            int size = arrayList != null ? arrayList.size() : 8;
            synchronized (this.f) {
                try {
                    if (this.e == null) {
                        this.e = new ConcurrentHashMap<>(size);
                    }
                } finally {
                }
            }
        }
    }

    private void e() {
        if (this.g == null) {
            synchronized (this.h) {
                try {
                    if (this.g == null) {
                        this.g = new ConcurrentHashMap<>(2);
                    }
                } finally {
                }
            }
        }
    }

    private void f() {
        if (this.j != null) {
            com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.j, true);
            this.j = null;
        }
        this.d = null;
        ConcurrentHashMap<String, com.baidu.navisdk.module.carlogo.datas.b> concurrentHashMap = this.e;
        if (concurrentHashMap != null) {
            if (concurrentHashMap.isEmpty()) {
                this.e = null;
                return;
            }
            if (this.k == null) {
                this.k = new g(this);
            }
            Iterator<String> it = this.e.keySet().iterator();
            while (it.hasNext()) {
                com.baidu.navisdk.module.carlogo.datas.b bVar = this.e.get(it.next());
                if (bVar != null) {
                    bVar.b = this.k;
                    bVar.f7076a = false;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements com.baidu.navisdk.module.carlogo.listeners.c {
        public g(c cVar) {
        }

        @Override // com.baidu.navisdk.module.carlogo.listeners.c
        public void a(String str) {
            if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                LogUtil.e("BN3DDataManager", "removeAllDownloadListener.onFailed: " + str);
            }
        }

        @Override // com.baidu.navisdk.module.carlogo.listeners.c
        public void a(String str, String str2) {
            if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                LogUtil.e("BN3DDataManager", "removeAllDownloadListener.onSuccess: " + str);
            }
        }

        @Override // com.baidu.navisdk.module.carlogo.listeners.c
        public void a(int i, String str) {
            if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                LogUtil.e("BN3DDataManager", "removeAllDownloadListener.onProgress: " + str);
            }
        }
    }

    private c() {
        this.c = false;
        this.f = new Object();
        this.h = new Object();
        this.i = -1;
        this.l = false;
        this.m = -1;
        this.b = new com.baidu.navisdk.module.carlogo.control.b();
    }

    public static c c() {
        return h.f7074a;
    }

    /* renamed from: com.baidu.navisdk.module.carlogo.control.c$c, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0234c implements com.baidu.navisdk.module.carlogo.listeners.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7070a;
        final /* synthetic */ boolean b;

        public C0234c(int i, boolean z) {
            this.f7070a = i;
            this.b = z;
        }

        @Override // com.baidu.navisdk.module.carlogo.listeners.c
        public void a(String str) {
            if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                LogUtil.e("BN3DDataManager", "downloadZipFile.onFailure: " + str);
            }
            c.this.b(str);
        }

        @Override // com.baidu.navisdk.module.carlogo.listeners.c
        public void a(String str, String str2) {
            if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                LogUtil.e("BN3DDataManager", "downloadZipFile.onSuccess: " + str + ", filePath:" + str2);
            }
            c.this.a(str, str2, this.f7070a, this.b);
        }

        @Override // com.baidu.navisdk.module.carlogo.listeners.c
        public void a(int i, String str) {
            if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                LogUtil.e("BN3DDataManager", "downloadZipFile.onProgress: " + i + ", url:" + str);
            }
            c.this.b(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str) {
        ArrayList<com.baidu.navisdk.module.carlogo.datas.c> arrayList;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            LogUtil.e("BN3DDataManager", "parse3DListData: " + str);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("errno", -1);
            if (optInt != 0) {
                if (gVar.d()) {
                    LogUtil.e("BN3DDataManager", "parse3DListData errno:" + optInt + ", errmsg:" + jSONObject.optString("errmsg", ""));
                }
                return false;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                if (gVar.d()) {
                    LogUtil.e("BN3DDataManager", "parse3DListData dataJson == null");
                }
                return false;
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray == null) {
                if (gVar.d()) {
                    LogUtil.e("BN3DDataManager", "parse3DListData listJson == null");
                }
                return false;
            }
            int length = optJSONArray.length();
            ArrayList<com.baidu.navisdk.module.carlogo.datas.c> arrayList2 = this.f7067a;
            if (arrayList2 != null) {
                arrayList2.clear();
            } else {
                this.f7067a = new ArrayList<>(length);
            }
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    com.baidu.navisdk.module.carlogo.datas.c cVar = new com.baidu.navisdk.module.carlogo.datas.c();
                    if (cVar.a(jSONObject2, false) && cVar.d() && (arrayList = this.f7067a) != null) {
                        arrayList.add(cVar);
                        if (cVar.f) {
                            this.i = cVar.f7077a;
                        }
                    }
                }
            }
            ArrayList<com.baidu.navisdk.module.carlogo.datas.c> arrayList3 = this.f7067a;
            if (arrayList3 != null && !arrayList3.isEmpty()) {
                if (!com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                    return true;
                }
                LogUtil.e("BN3DDataManager", "parse3DListData: " + Arrays.toString(this.f7067a.toArray()));
                return true;
            }
            if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                LogUtil.e("BN3DDataManager", "parse3DListData end m3DModelList is empty ");
            }
            return false;
        } catch (JSONException e2) {
            e2.printStackTrace();
            LogUtil.printCallStack();
            LogUtil.e("BN3DDataManager", "parse3DListData: " + e2);
            return false;
        }
    }

    public void b(int i, String str, com.baidu.navisdk.module.carlogo.listeners.c cVar, boolean z, int i2, boolean z2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            LogUtil.e("BN3DDataManager", "downloadZipFromOthers id:" + i + ", url:" + str + "," + z2);
        }
        String c = com.baidu.navisdk.module.carlogo.a.c(str, "");
        if (gVar.d()) {
            gVar.e("BN3DDataManager", "downloadZipFromOthers:" + c);
        }
        if (TextUtils.isEmpty(c)) {
            a(i, str, cVar, z, i2, z2);
        } else if (cVar != null) {
            cVar.a(str, c);
        }
    }

    public void a(com.baidu.navisdk.module.carlogo.listeners.d dVar, int i) {
        ArrayList<com.baidu.navisdk.module.carlogo.datas.c> arrayList;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            LogUtil.e("BN3DDataManager", "request3DList: " + i + ", lastVehicle:" + this.m);
        }
        if (this.m != i && (arrayList = this.f7067a) != null) {
            arrayList.clear();
        }
        this.m = i;
        this.d = dVar;
        if (this.c) {
            if (gVar.d()) {
                LogUtil.e("BN3DDataManager", "request3DList 正在加载中");
                return;
            }
            return;
        }
        ArrayList<com.baidu.navisdk.module.carlogo.datas.c> arrayList2 = this.f7067a;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            com.baidu.navisdk.module.carlogo.listeners.d dVar2 = this.d;
            if (dVar2 != null) {
                dVar2.onStart();
            }
            this.j = new a("request3DList-" + c.class.getSimpleName(), null);
            com.baidu.navisdk.util.worker.c.a().a(this.j, new com.baidu.navisdk.util.worker.e(99, 0), 1000L);
            return;
        }
        this.c = true;
        this.b.a(com.baidu.navisdk.util.http.b.d().b("carLogo3DList"), new b(), i);
    }

    private String d(int i) {
        if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
            LogUtil.e("BN3DDataManager", "getFilePathSaveKey: " + i);
        }
        return String.format(Locale.getDefault(), "bn_3d_carlogo_path_%d", Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.f) new d("download3DZipFile.failed", str), new com.baidu.navisdk.util.worker.e(2, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str) {
        ConcurrentHashMap<String, com.baidu.navisdk.module.carlogo.datas.b> concurrentHashMap = this.e;
        if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
            com.baidu.navisdk.module.carlogo.datas.b bVar = this.e.get(str);
            if (bVar == null) {
                if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                    LogUtil.e("BN3DDataManager", "handlerDownloadZipProgress request == null");
                    return;
                }
                return;
            }
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                LogUtil.e("BN3DDataManager", "handlerDownloadZipProgress: " + bVar + "; progress:" + i);
            }
            if (bVar.f7076a) {
                if (i - bVar.c < 9 && i < 100) {
                    if (gVar.d()) {
                        LogUtil.e("BN3DDataManager", "handlerDownloadZipProgress progress - request.currentProgress < 7");
                        return;
                    }
                    return;
                } else {
                    bVar.c = i;
                    com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.f) new f("download3DZipProgress", Integer.valueOf(i), str, i), new com.baidu.navisdk.util.worker.e(2, 0));
                    return;
                }
            }
            return;
        }
        if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
            LogUtil.e("BN3DDataManager", "handlerDownloadZipProgress mAllDownloadZipRequestMap == null OR empty ");
        }
    }

    public void a(int i, String str, com.baidu.navisdk.module.carlogo.listeners.c cVar, boolean z, int i2) {
        if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
            LogUtil.e("BN3DDataManager", "downloadZipFileFrom3DPanel id:" + i + ", url:" + str);
        }
        a(i, str, new com.baidu.navisdk.module.carlogo.datas.b(z, i2, cVar, str), true);
    }

    public int b() {
        if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
            LogUtil.e("BN3DDataManager", "getCurrentPosition mCurrentSelectedCarLogoId: " + this.i);
        }
        ArrayList<com.baidu.navisdk.module.carlogo.datas.c> arrayList = this.f7067a;
        if (arrayList == null || arrayList.isEmpty() || this.i < 0) {
            return 0;
        }
        for (int i = 0; i < this.f7067a.size(); i++) {
            com.baidu.navisdk.module.carlogo.datas.c cVar = this.f7067a.get(i);
            if (cVar != null && cVar.f7077a == this.i) {
                return i;
            }
        }
        return 0;
    }

    public void a(int i, String str, com.baidu.navisdk.module.carlogo.listeners.c cVar, boolean z, int i2, boolean z2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            LogUtil.e("BN3DDataManager", "downloadZipFromOthers id:" + i + ", url:" + str + "," + z2);
        }
        e();
        this.g.put(str, new com.baidu.navisdk.module.carlogo.datas.b(z, i2, cVar, str));
        boolean a2 = a(i, str, new com.baidu.navisdk.module.carlogo.datas.b(z, i2, cVar, str), z2);
        if (gVar.d()) {
            LogUtil.e("BN3DDataManager", "downloadZipFromOthers: " + a2);
        }
        if (a2) {
            return;
        }
        this.g.remove(str);
    }

    private void c(int i) {
        String str = BNSettingManager.get3DCarLogoFilePath(d(i), null);
        if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
            LogUtil.e("BN3DDataManager", "deleteOldFile: " + i + ", oldPath:" + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            s.b(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                LogUtil.e("BN3DDataManager", "deleteOldFile: " + e2.getMessage());
            }
        }
    }

    public void b(int i) {
        if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
            LogUtil.e("BN3DDataManager", "setCurrentCarLogoId mCurrentSelectedCarLogoId:" + this.i + ", id:" + i);
        }
        this.i = i;
    }

    private boolean a(int i, String str, com.baidu.navisdk.module.carlogo.datas.b bVar, boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            LogUtil.e("BN3DDataManager", "downloadZipFile id:" + i + ", url:" + str);
        }
        if (TextUtils.isEmpty(str)) {
            if (bVar != null) {
                bVar.b.a(str);
            }
            return false;
        }
        String a2 = com.baidu.navisdk.module.carlogo.a.a(str, "");
        if (gVar.d()) {
            LogUtil.e("BN3DDataManager", "downloadZipFile createCacheFilePath:" + a2);
        }
        if (TextUtils.isEmpty(a2)) {
            if (bVar != null) {
                bVar.b.a(str);
            }
            return false;
        }
        d();
        if (this.e.containsKey(str)) {
            this.e.put(str, bVar);
            return true;
        }
        this.e.put(str, bVar);
        a(3, str);
        this.b.a(str, new C0234c(i, z), a2);
        return true;
    }

    private void c(int i, String str) {
        if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
            LogUtil.e("BN3DDataManager", "saveCarLogoFilePath: " + i + ", filePath:" + str);
        }
        BNSettingManager.set3DCarLogoFilePath(d(i), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i, boolean z) {
        boolean z2;
        ConcurrentHashMap<String, com.baidu.navisdk.module.carlogo.datas.b> concurrentHashMap = this.e;
        if ((concurrentHashMap != null ? concurrentHashMap.get(str) : null) == null) {
            if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                LogUtil.e("BN3DDataManager", "onSuccess fileListener == null, url: " + str);
            }
            try {
                s.b(str2);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                LogUtil.printCallStack();
                return;
            }
        }
        c(i);
        String b2 = com.baidu.navisdk.module.carlogo.a.b(str2, "");
        try {
            a(new File(str2), b2, z);
            z2 = true;
        } catch (Throwable th) {
            th.printStackTrace();
            LogUtil.printCallStack();
            if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                LogUtil.e("BN3DDataManager", "asyncDownload3DZipFile unzip exception:" + th);
            }
            z2 = false;
        }
        if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
            LogUtil.e("BN3DDataManager", "downloadZipFile onSuccess isUnzipSuccess: " + z2);
        }
        if (!z2) {
            try {
                s.b(b2);
            } catch (IOException e3) {
                e3.printStackTrace();
                if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                    LogUtil.e("BN3DDataManager", "asyncDownload3DZipFile delete file failed");
                }
            }
        } else {
            c(i, b2);
        }
        com.baidu.navisdk.util.common.g.PRO_NAV.d();
        try {
            s.b(str2);
        } catch (Exception e4) {
            e4.printStackTrace();
            LogUtil.printCallStack();
        }
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.f) new e("download3dZipSuccess", Boolean.valueOf(z2), str, b2), new com.baidu.navisdk.util.worker.e(2, 0));
    }

    public boolean a(com.baidu.navisdk.module.carlogo.datas.c cVar) {
        boolean z;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            LogUtil.e("BN3DDataManager", "cancelDownload: " + cVar);
        }
        if (cVar == null || cVar.g()) {
            return false;
        }
        com.baidu.navisdk.module.carlogo.interfaces.a aVar = this.b;
        if (aVar != null) {
            cVar.p = 4;
            z = aVar.a(cVar.i, null);
        } else {
            z = false;
        }
        if (gVar.d()) {
            LogUtil.e("BN3DDataManager", "cancelDownload result: " + z);
        }
        if (z) {
            ConcurrentHashMap<String, com.baidu.navisdk.module.carlogo.datas.b> concurrentHashMap = this.e;
            if (concurrentHashMap != null) {
                concurrentHashMap.remove(cVar.i);
            }
            ConcurrentHashMap<String, com.baidu.navisdk.module.carlogo.datas.b> concurrentHashMap2 = this.g;
            if (concurrentHashMap2 != null) {
                concurrentHashMap2.remove(cVar.i);
            }
            String c = com.baidu.navisdk.module.carlogo.a.c(cVar.i, "");
            if (!TextUtils.isEmpty(c)) {
                try {
                    s.b(c);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                        LogUtil.e("BN3DDataManager", "cancelDownload del file exception: " + e2.toString());
                    }
                }
                if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                    LogUtil.e("BN3DDataManager", "cancelDownload del file success: ");
                }
            }
            cVar.q = 0;
            cVar.p = 2;
        } else if (cVar.p == 4) {
            cVar.p = 3;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            LogUtil.e("BN3DDataManager", "update3DModel url: " + str + ", unzipFilePath:" + str2);
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        ArrayList<com.baidu.navisdk.module.carlogo.datas.c> arrayList = this.f7067a;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (gVar.d()) {
                LogUtil.e("BN3DDataManager", "update3DModel: " + Arrays.toString(this.f7067a.toArray()));
            }
            Iterator<com.baidu.navisdk.module.carlogo.datas.c> it = this.f7067a.iterator();
            while (it.hasNext()) {
                com.baidu.navisdk.module.carlogo.datas.c next = it.next();
                if (next != null && str.equals(next.i)) {
                    next.p = 1;
                    next.o = str2;
                    next.j();
                    return;
                }
            }
            return;
        }
        if (gVar.d()) {
            LogUtil.e("BN3DDataManager", "update3DModel m3DModelList is empty: ");
        }
    }

    public ArrayList<com.baidu.navisdk.module.carlogo.datas.c> a() {
        return this.f7067a;
    }

    @Nullable
    public com.baidu.navisdk.module.carlogo.datas.c a(int i) {
        if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
            LogUtil.e("BN3DDataManager", "get3DModelById: " + i);
        }
        ArrayList<com.baidu.navisdk.module.carlogo.datas.c> arrayList = this.f7067a;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<com.baidu.navisdk.module.carlogo.datas.c> it = this.f7067a.iterator();
            while (it.hasNext()) {
                com.baidu.navisdk.module.carlogo.datas.c next = it.next();
                if (next != null && next.f7077a == i) {
                    return next;
                }
            }
        }
        return null;
    }

    @Nullable
    public com.baidu.navisdk.module.carlogo.datas.c a(String str) {
        ArrayList<com.baidu.navisdk.module.carlogo.datas.c> arrayList;
        if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
            LogUtil.e("BN3DDataManager", "get3DModelByZipUrl: " + str);
        }
        if (!TextUtils.isEmpty(str) && (arrayList = this.f7067a) != null && !arrayList.isEmpty()) {
            Iterator<com.baidu.navisdk.module.carlogo.datas.c> it = this.f7067a.iterator();
            while (it.hasNext()) {
                com.baidu.navisdk.module.carlogo.datas.c next = it.next();
                if (next != null && str.equals(next.i)) {
                    return next;
                }
            }
        }
        return null;
    }

    public boolean a(com.baidu.navisdk.module.carlogo.datas.a aVar, int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            LogUtil.e("BN3DDataManager", "changeColorUserClick: " + aVar + ", id:" + i);
        }
        ArrayList<com.baidu.navisdk.module.carlogo.datas.c> arrayList = this.f7067a;
        if (arrayList == null || arrayList.isEmpty()) {
            if (gVar.d()) {
                LogUtil.e("BN3DDataManager", "changeColorUserClick m3DModelList == null ");
            }
            return false;
        }
        if (aVar == null) {
            if (gVar.d()) {
                LogUtil.e("BN3DDataManager", "changeColorUserClick gifModel == null");
            }
            return false;
        }
        Iterator<com.baidu.navisdk.module.carlogo.datas.c> it = this.f7067a.iterator();
        while (it.hasNext()) {
            com.baidu.navisdk.module.carlogo.datas.c next = it.next();
            if (next.f7077a == i) {
                next.n = aVar.c;
                return true;
            }
        }
        return false;
    }

    public void a(com.baidu.navisdk.module.carlogo.datas.c cVar, Context context) {
        com.baidu.navisdk.module.carlogo.interfaces.a aVar;
        if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
            LogUtil.e("BN3DDataManager", "setUsedColorAndCarLogoToServer: " + cVar);
        }
        if (cVar == null) {
            return;
        }
        ArrayList<com.baidu.navisdk.module.carlogo.datas.c> arrayList = this.f7067a;
        if (arrayList != null) {
            Iterator<com.baidu.navisdk.module.carlogo.datas.c> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.navisdk.module.carlogo.datas.c next = it.next();
                if (next != null) {
                    if (next.f7077a == cVar.f7077a) {
                        next.n = cVar.n;
                        next.g = cVar.f();
                        next.f = true;
                    } else if (next.f) {
                        next.f = false;
                        next.g = null;
                    }
                }
            }
        }
        if (z.b(context) && (aVar = this.b) != null) {
            aVar.a(com.baidu.navisdk.util.http.b.d().b("carLogoSet"), cVar.f7077a, cVar.f());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, String str) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            LogUtil.e("BN3DDataManager", "changeDownloadStatus: " + i + ", url:" + str);
        }
        ArrayList<com.baidu.navisdk.module.carlogo.datas.c> arrayList = this.f7067a;
        if (arrayList == null) {
            if (gVar.d()) {
                LogUtil.e("BN3DDataManager", "changeDownloadStatus: m3DModelList == null");
            }
            return false;
        }
        Iterator<com.baidu.navisdk.module.carlogo.datas.c> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.navisdk.module.carlogo.datas.c next = it.next();
            if (next != null && str.equals(next.i)) {
                next.p = i;
                return true;
            }
        }
        return false;
    }

    public void a(com.baidu.navisdk.module.carlogo.listeners.c cVar, boolean z) {
        com.baidu.navisdk.module.carlogo.datas.b bVar;
        if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
            LogUtil.e("BN3DDataManager", "recoverPanelDownloadListener: " + cVar);
        }
        ConcurrentHashMap<String, com.baidu.navisdk.module.carlogo.datas.b> concurrentHashMap = this.e;
        if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
            return;
        }
        for (String str : this.e.keySet()) {
            if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                LogUtil.e("BN3DDataManager", "recoverPanelDownloadListener: key:" + str);
            }
            if (a(3, str) && (bVar = this.e.get(str)) != null) {
                bVar.b = cVar;
                bVar.f7076a = z;
            }
        }
    }

    public boolean a(Context context) {
        boolean z = (this.l || y.b(context, 1)) ? false : true;
        if (z) {
            this.l = true;
        }
        return z;
    }

    private void a(File file, String str, boolean z) throws IOException {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            LogUtil.e("BN3DDataManager", "unzip " + file + " " + str + "," + z);
        }
        if (file != null && !TextUtils.isEmpty(str)) {
            ZipFile zipFile = new ZipFile(file);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                if (!nextElement.isDirectory() && !nextElement.getName().contains("../")) {
                    String name = nextElement.getName();
                    if (!name.contains("__MACOSX") && !name.contains(".DS_Store")) {
                        if (z && name.contains("/")) {
                            String[] split = name.split("/");
                            name = split[split.length - 1];
                        }
                        if (!name.startsWith(FileUtils.FILE_EXTENSION_SEPARATOR)) {
                            ZipUtils.writeToFile(new File(str, name), zipFile.getInputStream(nextElement));
                        }
                    }
                }
            }
            zipFile.close();
            File[] listFiles = new File(str).listFiles();
            if (listFiles != null && listFiles.length == 1 && listFiles[0].isDirectory() && s.a(listFiles[0].getAbsolutePath(), str)) {
                try {
                    s.a(listFiles[0]);
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            return;
        }
        if (gVar.d()) {
            LogUtil.e("BN3DDataManager", "unzipPart : path or partName is null");
        }
        throw new IOException("unzipPart : path or partName is null");
    }

    public void a(boolean z) {
        this.c = false;
        this.d = null;
        this.m = -1;
        this.i = -1;
        ArrayList<com.baidu.navisdk.module.carlogo.datas.c> arrayList = this.f7067a;
        if (arrayList != null) {
            arrayList.clear();
            this.f7067a = null;
        }
        f();
        if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
            LogUtil.e("BN3DDataManager", "onDestroy: " + z);
        }
    }
}
