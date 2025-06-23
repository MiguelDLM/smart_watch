package com.baidu.navisdk.model.modelfactory;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.m0;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class b {
    public String W;
    public String X;
    public String Y;
    public String f0;
    public String g0;
    public String h0;
    public String i0;
    public String j0;
    public int k0;
    public int l0;
    public int m0;
    public String p0;

    /* renamed from: a, reason: collision with root package name */
    public int f6946a = -1;
    public int b = -1;
    public int c = -1;
    public boolean d = true;
    public String e = null;
    public String f = null;
    public String g = null;
    public String h = null;
    public String i = null;
    public boolean j = false;
    public int k = -1;
    public String l = null;
    public String m = null;
    public Bitmap n = null;
    public String o = null;
    public Bitmap p = null;
    public int q = -1;
    public int r = 0;
    public String s = null;
    public String t = null;
    public String u = null;
    public String v = null;
    public String w = null;
    public Bitmap x = null;
    public int y = 0;
    public int z = 0;
    public int A = 0;
    public int B = 0;
    public int C = 0;
    public boolean D = false;
    public String E = null;
    public Bitmap F = null;
    public String G = null;
    public String H = null;
    public String I = null;
    public String J = null;
    public String K = null;
    public Bitmap L = null;
    public Bitmap M = null;
    public Bitmap N = null;
    public Bitmap O = null;
    public Bitmap P = null;
    public String Q = null;
    public String R = null;
    public int S = -1;
    public int T = -1;
    public Bundle U = null;
    public int V = -1;
    public int Z = 0;
    public int a0 = 0;
    public String b0 = null;
    public int c0 = -1;
    public String d0 = null;
    public Bitmap e0 = null;
    public Bundle n0 = null;

    /* renamed from: o0, reason: collision with root package name */
    public int f6947o0 = -1;
    public ArrayList<a> q0 = new ArrayList<>();
    public boolean r0 = false;
    public int s0 = -1;
    public boolean t0 = false;
    public long u0 = -1;
    public String v0 = null;
    public String w0 = null;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f6948a;
        public String b;
        public int c;
        public String d;
        public String e;
        public String f;
        public String[] g;

        public String toString() {
            String str = "";
            if (this.g != null) {
                for (int i = 0; i < this.g.length; i++) {
                    str = str + this.g[i];
                    if (i < this.g.length - 1) {
                        str = str + ", ";
                    }
                }
            }
            return "itemType: " + this.f6948a + ", hint: " + this.b + ", unlock: " + this.c + ", tip: " + this.d + ", hlink: " + this.e + ", hicon: " + this.f + ", list: " + str;
        }
    }

    public boolean a() {
        int i = this.q;
        return i == 2 || i == 3;
    }

    public boolean b() {
        int i = this.q;
        if (i == 1 || i == 3) {
            return true;
        }
        return false;
    }

    public boolean c() {
        Bundle bundle = this.U;
        if (bundle != null && bundle.containsKey("pcBduss") && !TextUtils.isEmpty(bundle.getString("pcBduss"))) {
            return true;
        }
        return false;
    }

    public boolean d() {
        Bundle bundle = this.n0;
        if (bundle != null && bundle.containsKey("pcBduss") && !TextUtils.isEmpty(bundle.getString("pcBduss"))) {
            return true;
        }
        return false;
    }

    public void e() {
        this.t0 = false;
        this.u0 = -1L;
        LogUtil.e("BusinessActivityManager", "resetParking() ");
    }

    public void f() {
        this.r0 = false;
        LogUtil.e("BusinessActivityManager", "resetTrafficJam() ");
    }

    public void g() {
        try {
            Bitmap bitmap = this.n;
            if (bitmap != null && !bitmap.isRecycled()) {
                a(this.n, m0.j().c() + File.separator + "log/navi_logo.jpg");
            }
            Bitmap bitmap2 = this.p;
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                a(this.p, m0.j().c() + File.separator + "log/navi_banner.jpg");
            }
            Bitmap bitmap3 = this.x;
            if (bitmap3 != null && !bitmap3.isRecycled()) {
                a(this.x, m0.j().c() + File.separator + "log/navi_ricon.jpg");
            }
            Bitmap bitmap4 = this.F;
            if (bitmap4 != null && !bitmap4.isRecycled()) {
                a(this.F, m0.j().c() + File.separator + "log/navi_naviendpic.jpg");
            }
            Bitmap bitmap5 = this.L;
            if (bitmap5 != null && !bitmap5.isRecycled()) {
                a(this.L, m0.j().c() + File.separator + "log/navi_envelopePicBtnNormalBitmap.jpg");
            }
            Bitmap bitmap6 = this.M;
            if (bitmap6 != null && !bitmap6.isRecycled()) {
                a(this.M, m0.j().c() + File.separator + "log/navi_envelopePicBtnClickedBitmap.jpg");
            }
            Bitmap bitmap7 = this.N;
            if (bitmap7 != null && !bitmap7.isRecycled()) {
                a(this.N, m0.j().c() + File.separator + "log/navi_envelopePicMidBitmap.jpg");
            }
            Bitmap bitmap8 = this.P;
            if (bitmap8 != null && !bitmap8.isRecycled()) {
                a(this.P, m0.j().c() + File.separator + "log/navi_envelopePicPlusBitmap.jpg");
            }
            Bitmap bitmap9 = this.O;
            if (bitmap9 != null && !bitmap9.isRecycled()) {
                a(this.O, m0.j().c() + File.separator + "log/navi_envelopePicWindowBGBitmap.jpg");
            }
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("", e);
            }
        }
    }

    private void a(Bitmap bitmap, String str) {
        if (bitmap == null || TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        file.deleteOnExit();
        try {
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("", e);
            }
        }
    }
}
