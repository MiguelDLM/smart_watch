package com.baidu.navisdk.util.drivertool;

import XXO0.oIX0oI;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.m0;
import com.baidu.navisdk.util.common.x;
import com.baidu.navisdk.util.common.y;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f9277a = true;
    public static boolean b = false;
    public static boolean c = false;
    public static boolean d = false;
    public static boolean e = false;
    public static int f;
    public static long g;

    public static boolean a() {
        Context a2 = com.baidu.navisdk.framework.a.c().a();
        if (a2 == null) {
            return false;
        }
        if (y.d(a2)) {
            if (b.n().w.booleanValue()) {
                if (!x.t()) {
                    return true;
                }
                b("请在导航前设置");
                return false;
            }
            b("请登录后再试");
            return false;
        }
        b("请开启网络后再试");
        return false;
    }

    public static void b(String str) {
        TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), str);
    }

    public static String c(int i) {
        if (i == 3 || i == 2) {
            return ".png";
        }
        if (i == 1) {
            return ".mp4";
        }
        return null;
    }

    public static String d() {
        File file = new File(m0.j().c() + File.separator + "DrivingTool");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String e() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(x.b());
        stringBuffer.append(HelpFormatter.DEFAULT_OPT_PREFIX);
        stringBuffer.append(b.n().B);
        return stringBuffer.toString();
    }

    public static void f() {
        Map<String, String> map;
        String str;
        String str2 = b.n().p;
        if (!TextUtils.isEmpty(str2) && (map = b.n().l) != null && map.size() > 0) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    if (next.getValue().equals(str2)) {
                        str = next.getKey();
                        break;
                    }
                } else {
                    str = null;
                    break;
                }
            }
            BNSettingManager.setLastDrivingInfo(str2 + "," + str);
            LogUtil.e("drivingTool", "taskid ,taskname " + str2 + ", " + str);
        }
    }

    public static String c() {
        return c.f9276a.format(new Date(g));
    }

    public static int b() {
        return (e.l().c == 1 || e.l().c == 2) ? 2 : 1;
    }

    public static String b(int i) {
        return d() + File.separator + a(i);
    }

    public static void a(boolean z) {
        d = z;
        e = z;
    }

    public static Bitmap a(Bitmap bitmap, String str, String str2, Object obj) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(257);
        if (obj != null) {
            paint.setTextSize(8.0f);
        } else {
            paint.setTextSize(30.0f);
        }
        paint.setColor(-256);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setShadowLayer(3.0f, 1.0f, 1.0f, SupportMenu.CATEGORY_MASK);
        double d2 = height;
        canvas.drawText(str, width / 10, (float) (0.7d * d2), paint);
        canvas.drawText(str2, width / 8, (float) (d2 * 0.9d), paint);
        canvas.save();
        canvas.restore();
        return bitmap;
    }

    public static String a(long j) {
        return c.f9276a.format(new Date(j)).replaceAll(":", "").replace(" ", HelpFormatter.DEFAULT_OPT_PREFIX);
    }

    public static String a(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        if (i == 3) {
            stringBuffer.append("JP");
            stringBuffer.append(HelpFormatter.DEFAULT_OPT_PREFIX);
        } else if (i == 2) {
            stringBuffer.append("ZP");
            stringBuffer.append(HelpFormatter.DEFAULT_OPT_PREFIX);
        } else if (i == 1) {
            stringBuffer.append("LX");
            stringBuffer.append(HelpFormatter.DEFAULT_OPT_PREFIX);
        }
        stringBuffer.append(b.n().x);
        stringBuffer.append(HelpFormatter.DEFAULT_OPT_PREFIX);
        stringBuffer.append(a(Long.parseLong(b.n().h().l)));
        b.n().v = stringBuffer.toString();
        String c2 = c(i);
        if (c2 != null) {
            stringBuffer.append(c2);
        }
        return stringBuffer.toString();
    }

    public static void a(String str) {
        if (BNSettingManager.isShowJavaLog()) {
            String str2 = d() + File.separator + "dtLog.txt";
            String str3 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.getDefault()).format(new Date()) + " " + a("drivingTool", str, new Throwable().getStackTrace()[1]) + "\r\n";
            try {
                FileWriter fileWriter = new FileWriter(str2, true);
                fileWriter.write(str3);
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e2) {
                LogUtil.e("", e2.toString());
            }
        }
    }

    private static String a(String str, String str2, StackTraceElement stackTraceElement) {
        return ("[" + str + "]-" + stackTraceElement.getFileName() + oIX0oI.I0Io.f4096II0xO0 + stackTraceElement.getLineNumber() + "): ") + str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.io.File a(java.lang.String r3, int r4, int r5) {
        /*
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options
            r0.<init>()
            r1 = 1
            r0.inJustDecodeBounds = r1
            android.graphics.BitmapFactory.decodeFile(r3, r0)
            int r4 = a(r0, r4, r5)
            r0.inSampleSize = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "sample size is "
            r4.append(r5)
            int r5 = r0.inSampleSize
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "drivingTool"
            com.baidu.navisdk.util.common.LogUtil.e(r5, r4)
            r4 = 0
            r0.inJustDecodeBounds = r4
            android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeFile(r3, r0)
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG
            r2 = 40
            r5.compress(r1, r2, r0)
            java.io.File r5 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r3 = "-compress"
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r5.<init>(r3)
            r3 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76
            byte[] r3 = r0.toByteArray()     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L6f
            byte[] r0 = r0.toByteArray()     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L6f
            int r0 = r0.length     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L6f
            r1.write(r3, r4, r0)     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L6f
            r1.flush()     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L6f
            r1.close()     // Catch: java.io.IOException -> L6b
            goto L85
        L6b:
            r3 = move-exception
            goto L82
        L6d:
            r3 = move-exception
            goto L71
        L6f:
            r3 = move-exception
            goto L79
        L71:
            r4 = r3
            r3 = r1
            goto L86
        L74:
            r4 = move-exception
            goto L86
        L76:
            r4 = move-exception
            r1 = r3
            r3 = r4
        L79:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L6d
            if (r1 == 0) goto L85
            r1.close()     // Catch: java.io.IOException -> L6b
            goto L85
        L82:
            r3.printStackTrace()
        L85:
            return r5
        L86:
            if (r3 == 0) goto L90
            r3.close()     // Catch: java.io.IOException -> L8c
            goto L90
        L8c:
            r3 = move-exception
            r3.printStackTrace()
        L90:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.util.drivertool.d.a(java.lang.String, int, int):java.io.File");
    }

    public static int a(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 <= i2 && i4 <= i) {
            return 1;
        }
        int round = Math.round(i3 / i2);
        int round2 = Math.round(i4 / i);
        return round < round2 ? round : round2;
    }
}
