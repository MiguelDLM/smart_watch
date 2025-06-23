package com.baidu.navisdk.util.common;

import O0OOX0IIx.oxoX;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import o0oIxXOx.oO;

@SuppressLint({"NewApi"})
/* loaded from: classes8.dex */
public class m0 {
    public static String j = "BaiduNavi";
    private static String k;

    /* renamed from: a, reason: collision with root package name */
    String f9240a;
    String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private Context i;

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static m0 f9241a = new m0();
    }

    private void b(AssetManager assetManager) throws Exception {
        a(assetManager, "naviDataCfg.dat");
        a(assetManager, "naviDataCfg_i18n.dat");
    }

    private void c(String str) {
        try {
            if (new File(str).exists()) {
                File file = new File(str + File.separator + ".nomedia");
                if (file.exists()) {
                    return;
                }
                file.createNewFile();
            }
        } catch (Throwable unused) {
        }
    }

    private void d(String str) {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    private void i() {
        if (this.i == null) {
            return;
        }
        LogUtil.e("SysOSAPI", "BNDownloadUIManager: isFirstShow checkDataVerNotMatch");
        e0.a(this.i).b("SP_KEY_SHOW_TOAST_FOR_LINKID", true);
    }

    public static m0 j() {
        return b.f9241a;
    }

    public void a(Context context, String str, String str2) {
        this.i = context;
        a(context);
        b(str2);
        a(str);
        SDKDebugFileUtil.setSDCardPath(c());
        SDKDebugFileUtil.setModuleFileName(a());
    }

    public String e() {
        return this.f;
    }

    public String f() {
        return this.e;
    }

    public void g() {
        Context context = this.i;
        if (context == null) {
            return;
        }
        try {
            AssetManager assets = context.getResources().getAssets();
            b(assets);
            a(assets);
        } catch (Exception e) {
            LogUtil.e("", e.toString());
        }
    }

    public Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putString(IAdInterListener.AdProdType.PRODUCT_CPU, "");
        bundle.putString("resid", "01");
        bundle.putString("channel", a0.g);
        bundle.putString("glr", this.f9240a);
        bundle.putString("glv", this.b);
        bundle.putString("mb", a0.f9218a);
        bundle.putString("sv", a0.c);
        bundle.putString(oO.f31192XO, a0.b);
        bundle.putInt("dpi_x", ScreenUtil.getInstance().getDPI());
        bundle.putInt("dpi_y", ScreenUtil.getInstance().getDPI());
        bundle.putString(TKDownloadReason.KSAD_TK_NET, y.b(this.i));
        bundle.putString("imrand", a0.f());
        bundle.putByteArray(oxoX.f1377Oxx0IOOO, a0.h());
        return bundle;
    }

    private m0() {
        this.f9240a = "";
        this.b = "";
    }

    public void b(String str) {
        k = str;
    }

    public String b() {
        return this.g;
    }

    public String d() {
        return k;
    }

    public String c() {
        return this.h;
    }

    public void a(Context context) {
        this.c = context.getFilesDir().getAbsolutePath() + "/nmap";
        this.d = context.getFilesDir().getAbsolutePath();
        this.e = context.getCacheDir().getAbsolutePath();
        d(this.c);
        d(this.d);
        d(this.e);
    }

    public void a(String str) {
        this.f = str;
        String str2 = k;
        if (str2 != null && !TextUtils.isEmpty(str2)) {
            j = k + "/bnav";
        }
        String str3 = str + "/" + j;
        d(str3);
        c(str3);
        this.h = str3;
        String str4 = this.h + "/cache";
        this.g = str4;
        d(str4);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(android.content.res.AssetManager r14, java.lang.String r15) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.util.common.m0.a(android.content.res.AssetManager, java.lang.String):void");
    }

    private void a(AssetManager assetManager) throws Exception {
        File file = new File(c());
        if (!file.exists()) {
            file.mkdirs();
            LogUtil.e("SysOSAPI", " init root path");
        }
        try {
            File file2 = new File(c() + "/navi/pub");
            if (!file2.exists()) {
                file2.mkdirs();
            }
            String[] strArr = {"catalog.dat", "district.dat", "guidance_polyphone.dat", "rg.tpl"};
            String[] strArr2 = {"/navi/pub/catalog.dat", "/navi/pub/district.dat", "/navi/pub/guidance_polyphone.dat", "/navi/pub/rg.tpl"};
            long a2 = a0.a();
            for (int i = 0; i < 4; i++) {
                InputStream open = assetManager.open(strArr[i]);
                long available = open.available();
                File file3 = new File(c() + strArr2[i]);
                if (file3.exists() && file3.lastModified() > a2 && available == file3.length()) {
                    open.close();
                } else {
                    byte[] bArr = new byte[(int) available];
                    open.read(bArr);
                    open.close();
                    if (file3.exists()) {
                        file3.delete();
                    }
                    file3.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file3);
                    fileOutputStream.write(bArr);
                    fileOutputStream.close();
                }
            }
        } catch (Exception e) {
            LogUtil.e("", e.toString());
        }
    }

    public String a() {
        return this.d;
    }
}
