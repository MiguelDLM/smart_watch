package com.tencent.open.utils;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import xx0.xxIXOIIO;

/* loaded from: classes13.dex */
public class oIX0oI {

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f26973II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Context f26976oIX0oI;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static Map<String, oIX0oI> f26971Oxx0IOOO = Collections.synchronizedMap(new HashMap());

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static String f26970II0XooXoX = null;

    /* renamed from: I0Io, reason: collision with root package name */
    public JSONObject f26972I0Io = null;

    /* renamed from: oxoX, reason: collision with root package name */
    public long f26977oxoX = 0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f26974X0o0xo = 0;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f26975XO = true;

    /* renamed from: com.tencent.open.utils.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class C1092oIX0oI extends Thread {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Bundle f26979XO;

        public C1092oIX0oI(Bundle bundle) {
            this.f26979XO = bundle;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                oIX0oI.this.II0XooXoX(II0xO0.xXxxox0I(HttpUtils.xoIox(oIX0oI.this.f26976oIX0oI, "https://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", "GET", this.f26979XO).f26967oIX0oI));
            } catch (Exception e) {
                e.printStackTrace();
            }
            oIX0oI.this.f26974X0o0xo = 0;
        }
    }

    public oIX0oI(Context context, String str) {
        this.f26976oIX0oI = null;
        this.f26973II0xO0 = null;
        this.f26976oIX0oI = context.getApplicationContext();
        this.f26973II0xO0 = str;
        X0o0xo();
        xxIXOIIO();
    }

    public static oIX0oI oxoX(Context context, String str) {
        oIX0oI oix0oi;
        synchronized (f26971Oxx0IOOO) {
            try {
                xxIXOIIO.IXxxXO("openSDK_LOG.OpenConfig", "getInstance begin");
                if (str != null) {
                    f26970II0XooXoX = str;
                }
                if (str == null && (str = f26970II0XooXoX) == null) {
                    str = "0";
                }
                oix0oi = f26971Oxx0IOOO.get(str);
                if (oix0oi == null) {
                    oix0oi = new oIX0oI(context, str);
                    f26971Oxx0IOOO.put(str, oix0oi);
                }
                xxIXOIIO.IXxxXO("openSDK_LOG.OpenConfig", "getInstance end");
            } catch (Throwable th) {
                throw th;
            }
        }
        return oix0oi;
    }

    public final void II0XooXoX(JSONObject jSONObject) {
        ooOOo0oXI("cgi back, do update");
        this.f26972I0Io = jSONObject;
        Oxx0IOOO("com.tencent.open.config.json", jSONObject.toString());
        this.f26977oxoX = SystemClock.elapsedRealtime();
    }

    public int II0xO0(String str) {
        ooOOo0oXI("get " + str);
        oOoXoXO();
        return this.f26972I0Io.optInt(str);
    }

    public final String OOXIXo(String str) {
        InputStream open;
        String str2;
        String str3 = "";
        try {
            try {
                if (this.f26973II0xO0 != null) {
                    str2 = str + FileUtils.FILE_EXTENSION_SEPARATOR + this.f26973II0xO0;
                } else {
                    str2 = str;
                }
                open = this.f26976oIX0oI.openFileInput(str2);
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        } catch (FileNotFoundException unused) {
            open = this.f26976oIX0oI.getAssets().open(str);
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, Charset.forName("UTF-8")));
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            try {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        open.close();
                        bufferedReader.close();
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            } catch (Throwable th) {
                try {
                    open.close();
                    bufferedReader.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                throw th;
            }
        }
        str3 = stringBuffer.toString();
        open.close();
        bufferedReader.close();
        return str3;
    }

    public final void Oxx0IOOO(String str, String str2) {
        try {
            if (this.f26973II0xO0 != null) {
                str = str + FileUtils.FILE_EXTENSION_SEPARATOR + this.f26973II0xO0;
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.f26976oIX0oI.openFileOutput(str, 0), Charset.forName("UTF-8"));
            outputStreamWriter.write(str2);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final void X0o0xo() {
        try {
            this.f26972I0Io = new JSONObject(OOXIXo("com.tencent.open.config.json"));
        } catch (JSONException unused) {
            this.f26972I0Io = new JSONObject();
        }
    }

    public final void oOoXoXO() {
        int optInt = this.f26972I0Io.optInt("Common_frequency");
        if (optInt == 0) {
            optInt = 1;
        }
        if (SystemClock.elapsedRealtime() - this.f26977oxoX >= optInt * 3600000) {
            xxIXOIIO();
        }
    }

    public final void ooOOo0oXI(String str) {
        if (this.f26975XO) {
            xxIXOIIO.IXxxXO("openSDK_LOG.OpenConfig", str + "; appid: " + this.f26973II0xO0);
        }
    }

    public boolean xoIox(String str) {
        ooOOo0oXI("get " + str);
        oOoXoXO();
        Object opt = this.f26972I0Io.opt(str);
        if (opt == null) {
            return false;
        }
        if (opt instanceof Integer) {
            return !opt.equals(0);
        }
        if (!(opt instanceof Boolean)) {
            return false;
        }
        return ((Boolean) opt).booleanValue();
    }

    public final void xxIXOIIO() {
        if (this.f26974X0o0xo != 0) {
            ooOOo0oXI("update thread is running, return");
            return;
        }
        this.f26974X0o0xo = 1;
        Bundle bundle = new Bundle();
        bundle.putString("appid", this.f26973II0xO0);
        bundle.putString("appid_for_getting_config", this.f26973II0xO0);
        bundle.putString("status_os", Build.VERSION.RELEASE);
        bundle.putString("status_machine", Build.MODEL);
        bundle.putString("status_version", Build.VERSION.SDK);
        bundle.putString("sdkv", com.tencent.connect.common.II0xO0.f26901xoIox);
        bundle.putString("sdkp", "a");
        new C1092oIX0oI(bundle).start();
    }
}
