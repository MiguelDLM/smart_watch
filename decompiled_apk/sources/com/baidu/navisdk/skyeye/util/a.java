package com.baidu.navisdk.skyeye.util;

import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.debug.b;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.p0;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* loaded from: classes7.dex */
public class a implements p0.b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f8010a = false;
    private p0 b = null;
    private String c;
    private SDKDebugFileUtil d;

    public a() {
        this.c = null;
        String d = b.k().d();
        this.c = d;
        this.d = SDKDebugFileUtil.get(d, "eyespy_systemlog", false, false);
    }

    private void c() {
        LogUtil.e("BNEyeSpyPaperSystemLog", "writeAndUploadSystemLog: --> start");
        try {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -d -v time").getInputStream()));
                int i = 0;
                do {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    this.d.add(readLine);
                    i += readLine.length();
                    if (i > 1048576) {
                        break;
                    }
                } while (this.f8010a);
                bufferedReader.close();
                SDKDebugFileUtil.end(this.c, "eyespy_systemlog");
            } catch (Exception e) {
                e.printStackTrace();
                SDKDebugFileUtil.end(this.c, "eyespy_systemlog");
            }
        } catch (Throwable th) {
            SDKDebugFileUtil.end(this.c, "eyespy_systemlog");
            throw th;
        }
    }

    public void a() {
        this.f8010a = false;
        this.b.a();
    }

    public void b() {
        this.f8010a = true;
        p0 p0Var = new p0();
        this.b = p0Var;
        p0Var.a(3);
        c();
    }

    @Override // com.baidu.navisdk.util.common.p0.b
    public void onTick(int i) {
        if (i == 0) {
            a();
        }
    }
}
