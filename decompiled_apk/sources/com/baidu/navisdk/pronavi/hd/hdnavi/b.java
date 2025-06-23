package com.baidu.navisdk.pronavi.hd.hdnavi;

import OXOo.OOXIXo;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import java.util.HashMap;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<Integer, Boolean> f7728a;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new a(null);
    }

    public final void b() {
        SparseArray<String> sparseArray = com.baidu.navisdk.module.cloudconfig.f.c().I.f;
        IIX0o.oO(sparseArray, "CloudlConfigDataModel.ge…dNaviConfig.diyKeyUrlMaps");
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            int keyAt = sparseArray.keyAt(i);
            String str = sparseArray.get(keyAt);
            IIX0o.oO(str, "diyMaps.get(key)");
            a(keyAt, str);
        }
    }

    /* renamed from: com.baidu.navisdk.pronavi.hd.hdnavi.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0318b implements com.baidu.navisdk.module.carlogo.listeners.c {
        final /* synthetic */ int b;

        public C0318b(int i) {
            this.b = i;
        }

        @Override // com.baidu.navisdk.module.carlogo.listeners.c
        public void a(@OOXIXo String url) {
            IIX0o.x0xO0oo(url, "url");
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGHDResource", "setHDCarLogoData downloadHDLogo.onFailed: " + url);
            }
            b.this.b(this.b);
        }

        @Override // com.baidu.navisdk.module.carlogo.listeners.c
        public void a(@OOXIXo String url, @OOXIXo String filePath) {
            IIX0o.x0xO0oo(url, "url");
            IIX0o.x0xO0oo(filePath, "filePath");
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGHDResource", "setHDCarLogoData downloadHDLogo(), filePath = " + filePath + ",url = " + url);
            }
            BNMapController.getInstance().setDIYDataToMap(this.b, filePath, null);
            b.this.a(this.b, true);
        }

        @Override // com.baidu.navisdk.module.carlogo.listeners.c
        public void a(int i, @OOXIXo String url) {
            IIX0o.x0xO0oo(url, "url");
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGHDResource", "setHDCarLogoData downloadHDLogo(), url =" + url + ", progress = " + i);
            }
        }
    }

    private final void a(int i, String str) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDResource", "setHDCarLogoData: " + i + ", " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (a(i)) {
            if (gVar.d()) {
                gVar.e("RGHDResource", "setHDCarLogoData: isSettingOrDone");
                return;
            }
            return;
        }
        a(i, false);
        String c = com.baidu.navisdk.module.carlogo.a.c(str, "");
        if (gVar.d()) {
            gVar.e("RGHDResource", "setHDCarLogoData: " + c);
        }
        if (!TextUtils.isEmpty(c)) {
            BNMapController.getInstance().setDIYDataToMap(i, c, null);
            a(i, true);
        } else {
            com.baidu.navisdk.module.carlogo.control.c.c().b(Integer.MAX_VALUE - i, str, new C0318b(i), false, 200, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDResource", "removeSetDiyResult: " + i);
        }
        HashMap<Integer, Boolean> hashMap = this.f7728a;
        if (hashMap != null) {
            hashMap.remove(Integer.valueOf(i));
        }
    }

    private final boolean a(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDResource", "isSettingOrDone: " + i);
        }
        HashMap<Integer, Boolean> hashMap = this.f7728a;
        return hashMap != null && hashMap.containsKey(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i, boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDResource", "updateSetDiyResult: " + i + ", b:" + z);
        }
        if (this.f7728a == null) {
            this.f7728a = new HashMap<>(8, 1.0f);
        }
        HashMap<Integer, Boolean> hashMap = this.f7728a;
        IIX0o.ooOOo0oXI(hashMap);
        hashMap.put(Integer.valueOf(i), Boolean.valueOf(z));
    }

    public final void a() {
        HashMap<Integer, Boolean> hashMap = this.f7728a;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f7728a = null;
    }
}
