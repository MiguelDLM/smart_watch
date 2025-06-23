package com.iflytek.sparkchain.core;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import com.iflytek.sparkchain.core.BaseLibrary;
import com.iflytek.sparkchain.plugins.utils.Utils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes10.dex */
public class Auth {

    /* renamed from: a, reason: collision with root package name */
    private final String f17450a;
    private Context b;
    private String c;
    private CoreListener d;
    private AuthListener e;

    /* loaded from: classes10.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static Auth f17451a = new Auth();
    }

    static {
        try {
            System.loadLibrary(Utils.TAG);
        } catch (Exception e) {
            Log.e("AEE", "loadLibrary:" + e.toString());
        }
    }

    private Auth() {
        this.f17450a = Auth.class.getSimpleName();
        this.d = null;
        this.e = null;
    }

    public static Auth d() {
        return b.f17451a;
    }

    public Context a() {
        return this.b;
    }

    public String b() {
        return getDeviceId(this.b);
    }

    public String c() {
        return this.c;
    }

    public native String getDeviceId(Context context);

    public native int getOaIdWeightValue();

    public native int getState();

    public native int initAndCheck(Context context, String str, String str2, String str3, int i, String str4, String str5, boolean z, boolean z2, int i2, long j, boolean z3, String str6, int i3, String str7, String str8, String str9, String str10);

    public native int release();

    public native void reset(Context context);

    private String b(Context context) {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        AssetManager assets = a().getAssets();
        if (assets == null) {
            return "";
        }
        try {
            String[] list = assets.list("aikit_resources");
            if (list.length <= 0) {
                return "";
            }
            String str = context.getFilesDir().toString() + "/aikit_resources/";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdir();
            }
            Log.d(this.f17450a, "resources in assets,count = " + list.length);
            for (String str2 : list) {
                if (!new File(str + str2).exists()) {
                    FileOutputStream fileOutputStream2 = null;
                    try {
                        inputStream = assets.open("aikit_resources/" + str2);
                        try {
                            try {
                                fileOutputStream = new FileOutputStream(str + str2);
                            } catch (Throwable th) {
                                th = th;
                            }
                        } catch (Exception unused) {
                        }
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read <= -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            Log.d(this.f17450a, "resources:" + str2 + " copy from assets to:" + str + "success!");
                            inputStream.close();
                            fileOutputStream.close();
                        } catch (Exception unused2) {
                            fileOutputStream2 = fileOutputStream;
                            Log.e(this.f17450a, "resources:" + str2 + "copy from assets failed!:");
                            inputStream.close();
                            fileOutputStream2.close();
                            return "";
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream2 = fileOutputStream;
                            inputStream.close();
                            fileOutputStream2.close();
                            throw th;
                        }
                    } catch (Exception unused3) {
                        inputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = null;
                    }
                }
            }
            return str;
        } catch (IOException unused4) {
            Log.d(this.f17450a, "auth init info:no resources dir in aar");
            assets.close();
            return "";
        }
    }

    public void a(int i, int i2) {
        AuthListener authListener = this.e;
        if (authListener == null && (authListener = this.d) == null) {
            return;
        }
        authListener.onAuthStateChange(ErrType.valueOf(i), i2);
    }

    public void a(Context context) {
        this.b = context;
    }

    public void b(Context context, BaseLibrary.Params params) {
        Log.i(this.f17450a, "require oaid");
        a(context, params);
    }

    public void a(Context context, BaseLibrary.Params params) {
        if (params.resDir.isEmpty()) {
            params.resDir = b(context);
        }
        int initAndCheck = initAndCheck(context, params.getAppId(), params.getApiKey(), params.getApiSecret(), params.getAuthType(), params.getLicenseFile(), params.getWorkDir(), params.isLogOpen(), params.isiLogOpen(), params.getiLogMaxCount(), params.getiLogMaxSize(), params.isRecordOpen(), params.getCustomDeviceId(), params.getAuthInterval(), params.getResDir(), params.getBatchID(), params.getCfgFile(), params.getAbility());
        Log.i(this.f17450a, "auth init ret:" + initAndCheck);
        a(ErrType.AUTH.getValue(), initAndCheck);
    }

    public void a(AuthListener authListener) {
        this.e = authListener;
    }

    public void a(CoreListener coreListener) {
        this.d = coreListener;
    }
}
