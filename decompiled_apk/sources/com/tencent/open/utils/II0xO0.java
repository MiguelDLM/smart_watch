package com.tencent.open.utils;

import XIXIX.OOXIXo;
import XxXX.Oxx0IOOO;
import XxXX.X0o0xo;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.baidu.navisdk.ui.widget.BNWebViewClient;
import com.google.android.exoplayer2.util.MimeTypes;
import com.huawei.openalliance.ad.constant.aw;
import com.kuaishou.weapon.p0.g;
import com.kwad.sdk.collector.AppStatusRules;
import com.szabh.smable3.entity.BleNotification;
import com.tencent.tauth.Tencent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import org.apache.commons.text.ooOOo0oXI;
import org.json.JSONException;
import org.json.JSONObject;
import xx0.xxIXOIIO;

/* loaded from: classes13.dex */
public class II0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public static String f26958I0Io = "";

    /* renamed from: II0xO0, reason: collision with root package name */
    public static String f26959II0xO0 = "";

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static String f26960Oxx0IOOO = "0123456789ABCDEF";

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static int f26961X0o0xo = -1;

    /* renamed from: XO, reason: collision with root package name */
    public static String f26962XO = null;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static String f26963oIX0oI = "";

    /* renamed from: oxoX, reason: collision with root package name */
    public static String f26964oxoX = "";

    /* renamed from: com.tencent.open.utils.II0xO0$II0xO0, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C1091II0xO0 {

        /* renamed from: I0Io, reason: collision with root package name */
        public long f26965I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public long f26966II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public String f26967oIX0oI;

        public C1091II0xO0(String str, int i) {
            this.f26967oIX0oI = str;
            this.f26966II0xO0 = i;
            if (str != null) {
                this.f26965I0Io = str.length();
            }
        }
    }

    /* loaded from: classes13.dex */
    public static class oIX0oI extends Thread {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ Bundle f26968Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Context f26969XO;

        public oIX0oI(Context context, Bundle bundle) {
            this.f26969XO = context;
            this.f26968Oo = bundle;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                HttpUtils.xoIox(this.f26969XO, "http://cgi.qplus.com/report/report", "GET", this.f26968Oo);
            } catch (Exception e) {
                xxIXOIIO.II0XooXoX("openSDK_LOG.Util", "reportBernoulli has exception: " + e.getMessage());
            }
        }
    }

    public static Bundle I0Io(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            try {
                for (String str2 : str.split("&")) {
                    String[] split = str2.split("=");
                    if (split.length == 2) {
                        bundle.putString(URLDecoder.decode(split[0]), URLDecoder.decode(split[1]));
                    }
                }
                return bundle;
            } catch (Exception unused) {
                return null;
            }
        }
        return bundle;
    }

    public static File I0oOoX(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                if (file.getParentFile().mkdirs()) {
                    file.createNewFile();
                } else {
                    xxIXOIIO.XO("openSDK_LOG.Util", "createFile failed" + str);
                }
            } else {
                file.createNewFile();
            }
        }
        return file;
    }

    public static final String II0XooXoX(Context context) {
        CharSequence applicationLabel;
        if (context != null && (applicationLabel = context.getPackageManager().getApplicationLabel(context.getApplicationInfo())) != null) {
            return applicationLabel.toString();
        }
        return null;
    }

    public static Drawable II0xO0(String str, Context context) {
        InputStream inputStream;
        StringBuilder sb;
        InputStream inputStream2 = null;
        r1 = null;
        Drawable drawable = null;
        if (context == null) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.Util", "context null!");
            return null;
        }
        try {
            inputStream = context.getAssets().open(str);
            try {
                try {
                    drawable = Drawable.createFromStream(inputStream, str);
                    try {
                        inputStream.close();
                    } catch (Exception e) {
                        e = e;
                        sb = new StringBuilder();
                        sb.append("inputStream close exception: ");
                        sb.append(e.getMessage());
                        xxIXOIIO.II0XooXoX("openSDK_LOG.Util", sb.toString());
                        return drawable;
                    }
                } catch (IOException e2) {
                    e = e2;
                    xxIXOIIO.II0XooXoX("openSDK_LOG.Util", "getDrawable exception: " + e.getMessage());
                    try {
                        inputStream.close();
                    } catch (Exception e3) {
                        e = e3;
                        sb = new StringBuilder();
                        sb.append("inputStream close exception: ");
                        sb.append(e.getMessage());
                        xxIXOIIO.II0XooXoX("openSDK_LOG.Util", sb.toString());
                        return drawable;
                    }
                    return drawable;
                }
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                try {
                    inputStream2.close();
                } catch (Exception e4) {
                    xxIXOIIO.II0XooXoX("openSDK_LOG.Util", "inputStream close exception: " + e4.getMessage());
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            inputStream2.close();
            throw th;
        }
        return drawable;
    }

    public static boolean IIX0o() {
        if (Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(X0o0xo.oIX0oI(), g.j) == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x01c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x018d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String IIXOooo(android.content.Context r12, android.net.Uri r13) {
        /*
            Method dump skipped, instructions count: 483
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.II0xO0.IIXOooo(android.content.Context, android.net.Uri):java.lang.String");
    }

    public static boolean IO(Context context, String str) {
        boolean z;
        boolean z2 = false;
        if (ooXIXxIX(context) && Oxx0IOOO.Oxx0IOOO(context, com.tencent.connect.common.II0xO0.f26870oxoX) != null) {
            z = false;
        } else {
            z = true;
        }
        if (z && Oxx0IOOO.Oxx0IOOO(context, com.tencent.connect.common.II0xO0.f26800X0o0xo) != null) {
            z = false;
        }
        if (z && Oxx0IOOO.Oxx0IOOO(context, com.tencent.connect.common.II0xO0.f26792Oxx0IOOO) != null) {
            z = false;
        }
        if (z) {
            if (Oxx0IOOO.x0XOIxOo(context, str) < 0) {
                z2 = true;
            }
            return z2;
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r7v9 */
    public static boolean IXxxXO(File file, File file2) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                    }
                    fileOutputStream = new FileOutputStream((File) file2);
                    try {
                        file2 = new BufferedInputStream(new FileInputStream(file));
                    } catch (IOException e) {
                        e = e;
                        file2 = 0;
                    } catch (OutOfMemoryError e2) {
                        e = e2;
                        file2 = 0;
                    } catch (Throwable th) {
                        th = th;
                        file2 = 0;
                    }
                } catch (IOException e3) {
                    xxIXOIIO.xxIXOIIO("openSDK_LOG.Util", "copyFile error, ", e3);
                    return false;
                }
            } catch (IOException e4) {
                e = e4;
                file2 = 0;
            } catch (OutOfMemoryError e5) {
                e = e5;
                file2 = 0;
            } catch (Throwable th2) {
                th = th2;
                file2 = 0;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        try {
            byte[] bArr = new byte[AppStatusRules.UploadConfig.DEFAULT_FILE_MAX_SIZE];
            while (true) {
                int read = file2.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                    fileOutputStream.flush();
                } else {
                    try {
                        break;
                    } catch (IOException e6) {
                        xxIXOIIO.xxIXOIIO("openSDK_LOG.Util", "copyFile error, ", e6);
                    }
                }
            }
            fileOutputStream.close();
            try {
                file2.close();
            } catch (IOException e7) {
                xxIXOIIO.xxIXOIIO("openSDK_LOG.Util", "copyFile error, ", e7);
            }
            return true;
        } catch (IOException e8) {
            e = e8;
            fileOutputStream2 = fileOutputStream;
            file2 = file2;
            xxIXOIIO.xxIXOIIO("openSDK_LOG.Util", "copyFile error, ", e);
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e9) {
                    xxIXOIIO.xxIXOIIO("openSDK_LOG.Util", "copyFile error, ", e9);
                }
            }
            if (file2 != 0) {
                file2.close();
                file2 = file2;
            }
            return false;
        } catch (OutOfMemoryError e10) {
            e = e10;
            fileOutputStream2 = fileOutputStream;
            file2 = file2;
            xxIXOIIO.xxIXOIIO("openSDK_LOG.Util", "copyFile error, ", e);
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e11) {
                    xxIXOIIO.xxIXOIIO("openSDK_LOG.Util", "copyFile error, ", e11);
                }
            }
            if (file2 != 0) {
                file2.close();
                file2 = file2;
            }
            return false;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e12) {
                    xxIXOIIO.xxIXOIIO("openSDK_LOG.Util", "copyFile error, ", e12);
                }
            }
            if (file2 != 0) {
                try {
                    file2.close();
                    throw th;
                } catch (IOException e13) {
                    xxIXOIIO.xxIXOIIO("openSDK_LOG.Util", "copyFile error, ", e13);
                    throw th;
                }
            }
            throw th;
        }
    }

    public static long Io(String str) {
        FileInputStream fileInputStream = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                return 0L;
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                long available = fileInputStream2.available();
                try {
                    fileInputStream2.close();
                } catch (IOException unused) {
                }
                return available;
            } catch (Exception unused2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                return 0L;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String IoOoX(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(OI0(str));
            byte[] digest = messageDigest.digest();
            if (digest != null) {
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    sb.append(oIX0oI(b >>> 4));
                    sb.append(oIX0oI(b));
                }
                return sb.toString();
            }
            return str;
        } catch (NoSuchAlgorithmException e) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.Util", "encrypt has exception: " + e.getMessage());
            return str;
        }
    }

    public static boolean O0xOxO(String str, String str2) {
        boolean z;
        boolean IIX0o2 = IIX0o();
        if (IIX0o2) {
            z = Oxx0xo(str, str2);
        } else {
            z = false;
        }
        xxIXOIIO.oOoXoXO("openSDK_LOG.Util", "copyImageByCheckPermission() copy succes:" + z + ",hasSDPermission=" + IIX0o2);
        return z;
    }

    public static byte[] OI0(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static String OOXIXo(String str, Activity activity, String str2) {
        String str3;
        try {
            boolean oxxXoxO2 = oxxXoxO(str2);
            xxIXOIIO.oOoXoXO("openSDK_LOG.Util", "doPublishMood() check file: isAppSpecificDir=" + oxxXoxO2 + ",hasSDPermission=" + IIX0o());
            if (!oxxXoxO2) {
                File externalFilesDir = X0o0xo.oIX0oI().getExternalFilesDir("Images");
                if (externalFilesDir != null) {
                    str3 = externalFilesDir.getAbsolutePath() + File.separator + com.tencent.connect.common.II0xO0.f26764O0OOX0IIx;
                } else {
                    File cacheDir = X0o0xo.oIX0oI().getCacheDir();
                    if (cacheDir == null) {
                        xxIXOIIO.II0XooXoX("openSDK_LOG.Util", "getMediaFileUri error, cacheDir is null");
                        return null;
                    }
                    str3 = cacheDir.getAbsolutePath() + File.separator + com.tencent.connect.common.II0xO0.f26764O0OOX0IIx;
                }
                File file = new File(str2);
                String absolutePath = file.getAbsolutePath();
                String str4 = str3 + File.separator + file.getName();
                if (O0xOxO(absolutePath, str4)) {
                    str2 = str4;
                } else {
                    str2 = null;
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                File file2 = new File(str2);
                String authorities = Tencent.getAuthorities(str);
                if (TextUtils.isEmpty(authorities)) {
                    xxIXOIIO.II0XooXoX("openSDK_LOG.Util", "getMediaFileUri error, authorities is null");
                    return null;
                }
                Uri uriForFile = FileProvider.getUriForFile(activity, authorities, file2);
                activity.grantUriPermission("com.tencent.mobileqq", uriForFile, 3);
                return uriForFile.toString();
            }
            xxIXOIIO.II0XooXoX("openSDK_LOG.Util", "getMediaFileUri error, destAppSpecific is null");
            return null;
        } catch (Exception e) {
            xxIXOIIO.xxIXOIIO("openSDK_LOG.Util", "getMediaFileUri error", e);
            return null;
        }
    }

    public static boolean Oo(Context context, boolean z) {
        if ((ooXIXxIX(context) && Oxx0IOOO.Oxx0IOOO(context, com.tencent.connect.common.II0xO0.f26870oxoX) != null) || Oxx0IOOO.x0XOIxOo(context, "4.1") >= 0 || Oxx0IOOO.Oxx0IOOO(context, com.tencent.connect.common.II0xO0.f26800X0o0xo) != null || Oxx0IOOO.Oxx0IOOO(context, com.tencent.connect.common.II0xO0.f26792Oxx0IOOO) != null) {
            return true;
        }
        return false;
    }

    public static boolean OxI(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return true;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo != null) {
            for (NetworkInfo networkInfo : allNetworkInfo) {
                if (networkInfo.isConnectedOrConnecting()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String Oxx0IOOO() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces != null && networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        return nextElement.getHostAddress().toString();
                    }
                }
            }
            return "";
        } catch (SocketException e) {
            xxIXOIIO.Oxx0IOOO("openSDK_LOG.Util", "getUserIp SocketException ", e);
            return "";
        }
    }

    public static boolean Oxx0xo(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            try {
                return IXxxXO(file, I0oOoX(str2));
            } catch (IOException e) {
                xxIXOIIO.Oxx0IOOO("openSDK_LOG.Util", "copy fail from " + str + " to " + str2 + " ", e);
            }
        }
        return false;
    }

    public static Bundle OxxIIOOXO(String str) {
        try {
            URL url = new URL(str.replace("auth://", BNWebViewClient.URL_HTTP_PREFIX));
            Bundle I0Io2 = I0Io(url.getQuery());
            I0Io2.putAll(I0Io(url.getRef()));
            return I0Io2;
        } catch (MalformedURLException unused) {
            return new Bundle();
        }
    }

    public static boolean X00IoxXI(Context context) {
        if (Oxx0IOOO.x0XOIxOo(context, "5.9.5") < 0 && Oxx0IOOO.Oxx0IOOO(context, com.tencent.connect.common.II0xO0.f26800X0o0xo) == null && Oxx0IOOO.Oxx0IOOO(context, com.tencent.connect.common.II0xO0.f26792Oxx0IOOO) == null) {
            return false;
        }
        return true;
    }

    public static String X0IIOO() {
        File X0o0xo2 = X0o0xo.X0o0xo();
        if (X0o0xo2 != null) {
            if (!X0o0xo2.exists()) {
                X0o0xo2.mkdirs();
            }
            return X0o0xo2.toString();
        }
        return null;
    }

    public static Bundle X0o0xo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Bundle bundle = new Bundle();
        bundle.putString("platform", "1");
        bundle.putString("result", str);
        bundle.putString("code", str2);
        bundle.putString("tmcost", str3);
        bundle.putString("rate", str4);
        bundle.putString("cmd", str5);
        bundle.putString("uin", str6);
        bundle.putString("appid", str7);
        bundle.putString("share_type", str8);
        bundle.putString(aw.as, str9);
        bundle.putString("os_ver", Build.VERSION.RELEASE);
        bundle.putString("network", xoX.xxIXOIIO.oIX0oI(X0o0xo.oIX0oI()));
        bundle.putString("apn", xoX.xxIXOIIO.II0xO0(X0o0xo.oIX0oI()));
        bundle.putString("model_name", Build.MODEL);
        bundle.putString("sdk_ver", com.tencent.connect.common.II0xO0.f26901xoIox);
        bundle.putString("packagename", X0o0xo.I0Io());
        bundle.putString("app_ver", XxX0x0xxx(X0o0xo.oIX0oI(), X0o0xo.I0Io()));
        return bundle;
    }

    public static String XI0IXoo(Context context) {
        Location lastKnownLocation;
        if (context == null) {
            return "";
        }
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            Criteria criteria = new Criteria();
            criteria.setCostAllowed(false);
            criteria.setAccuracy(2);
            String bestProvider = locationManager.getBestProvider(criteria, true);
            if (bestProvider == null || (lastKnownLocation = locationManager.getLastKnownLocation(bestProvider)) == null) {
                return "";
            }
            String str = lastKnownLocation.getLatitude() + "*" + lastKnownLocation.getLongitude();
            f26962XO = str;
            return str;
        } catch (Exception e) {
            xxIXOIIO.xxIXOIIO("openSDK_LOG.Util", "getLocation>>>", e);
        }
        return "";
    }

    public static String XIxXXX0x0(Context context, String str) {
        if (context == null) {
            return "";
        }
        xoXoI(context, str);
        return f26959II0xO0;
    }

    public static Bundle XO(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        Bundle bundle = new Bundle();
        bundle.putString("openid", str);
        bundle.putString("report_type", str2);
        bundle.putString("act_type", str3);
        bundle.putString("via", str4);
        bundle.putString("app_id", str5);
        bundle.putString("result", str6);
        bundle.putString("type", str7);
        bundle.putString("login_status", str8);
        bundle.putString("need_user_auth", str9);
        bundle.putString("to_uin", str10);
        bundle.putString("call_source", str11);
        bundle.putString("to_type", str12);
        return bundle;
    }

    public static boolean XOxIOxOx(String str) {
        if (str == null || !new File(str).exists()) {
            return false;
        }
        return true;
    }

    public static String XX(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Base64.encodeToString(str.getBytes("UTF-8"), 2);
            } catch (UnsupportedEncodingException e) {
                xxIXOIIO.II0XooXoX("openSDK_LOG.Util", "convert2Base64String exception: " + e.getMessage());
            }
        }
        return "";
    }

    public static boolean Xx000oIo(Context context, String str) {
        boolean z;
        boolean z2 = false;
        if (ooXIXxIX(context) && Oxx0IOOO.Oxx0IOOO(context, com.tencent.connect.common.II0xO0.f26870oxoX) != null) {
            z = false;
        } else {
            z = true;
        }
        if (z && Oxx0IOOO.Oxx0IOOO(context, com.tencent.connect.common.II0xO0.f26800X0o0xo) != null) {
            z = false;
        }
        if (z && Oxx0IOOO.Oxx0IOOO(context, com.tencent.connect.common.II0xO0.f26792Oxx0IOOO) != null) {
            z = false;
        }
        if (z) {
            if (Oxx0IOOO.x0XOIxOo(context, str) < 0) {
                z2 = true;
            }
            return z2;
        }
        return z;
    }

    public static String XxX0x0xxx(Context context, String str) {
        if (context == null) {
            return "";
        }
        xoXoI(context, str);
        return f26963oIX0oI;
    }

    public static String o0(String str) {
        if (str == null) {
            return null;
        }
        return Base64.encodeToString(oI0IIXIo(str.getBytes(), "JCPTZXEZ"), 3);
    }

    public static boolean o00() {
        File file;
        if (Environment.getExternalStorageState().equals("mounted")) {
            file = Environment.getExternalStorageDirectory();
        } else {
            file = null;
        }
        if (file != null) {
            return true;
        }
        return false;
    }

    public static byte[] oI0IIXIo(byte[] bArr, String str) {
        if (bArr != null) {
            try {
                char[] charArray = str.toCharArray();
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                for (int i = 0; i < length; i++) {
                    bArr2[i] = (byte) (bArr[i] ^ charArray[i % charArray.length]);
                }
                return bArr2;
            } catch (Throwable th) {
                xxIXOIIO.xxIXOIIO("Util", "xor Exception! ", th);
            }
        }
        return bArr;
    }

    public static char oIX0oI(int i) {
        int i2 = i & 15;
        return (char) (i2 < 10 ? i2 + 48 : i2 + 87);
    }

    public static void oO(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(1073741824);
        intent.addFlags(268435456);
        intent.setData(Uri.parse(str3));
        context.startActivity(intent);
    }

    public static boolean oOXoIIIo(Context context) {
        if (Oxx0IOOO.x0XOIxOo(context, "8.1.8") >= 0) {
            return true;
        }
        return false;
    }

    public static String oOoXoXO(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            String num = Integer.toString(b & 255, 16);
            if (num.length() == 1) {
                num = "0" + num;
            }
            sb.append(num);
        }
        return sb.toString();
    }

    public static boolean oo(String str) {
        if (str != null && str.length() != 0) {
            return false;
        }
        return true;
    }

    public static boolean oo0xXOI0I(Context context) {
        if (Oxx0IOOO.x0XOIxOo(context, "8.1.5") >= 0) {
            return true;
        }
        return false;
    }

    public static JSONObject ooOOo0oXI(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (str != null) {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                if (split.length == 2) {
                    try {
                        split[0] = URLDecoder.decode(split[0]);
                        split[1] = URLDecoder.decode(split[1]);
                    } catch (Exception unused) {
                    }
                    try {
                        jSONObject.put(split[0], split[1]);
                    } catch (JSONException e) {
                        xxIXOIIO.II0XooXoX("openSDK_LOG.Util", "decodeUrlToJson has exception: " + e.getMessage());
                    }
                }
            }
        }
        return jSONObject;
    }

    public static boolean ooXIXxIX(Context context) {
        double d;
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            d = Math.sqrt(Math.pow(displayMetrics.widthPixels / displayMetrics.xdpi, 2.0d) + Math.pow(displayMetrics.heightPixels / displayMetrics.ydpi, 2.0d));
        } catch (Throwable unused) {
            d = OOXIXo.f3760XO;
        }
        if (d > 6.5d) {
            return true;
        }
        return false;
    }

    public static Bundle oxoX(String str, String str2, String str3, String str4, String str5, String str6) {
        return XO(str, str3, str4, str2, str5, str6, "", "", "", "", "", "");
    }

    public static boolean oxxXoxO(String str) {
        String X0IIOO2 = X0IIOO();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(X0IIOO2) && str.contains(X0IIOO2)) {
            return true;
        }
        return false;
    }

    public static void x0XOIxOo(Context context, String str, long j, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("appid_for_getting_config", str2);
        bundle.putString("strValue", str2);
        bundle.putString("nValue", str);
        bundle.putString("qver", com.tencent.connect.common.II0xO0.f26901xoIox);
        if (j != 0) {
            bundle.putLong("elt", j);
        }
        new oIX0oI(context, bundle).start();
    }

    public static boolean x0o(Context context) {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.tencent.mtt", 64);
            String str = packageInfo.versionName;
            if (Oxx0IOOO.II0xO0(str, "4.3") >= 0 && !str.startsWith("4.4") && (signatureArr = packageInfo.signatures) != null) {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(signatureArr[0].toByteArray());
                    String oOoXoXO2 = oOoXoXO(messageDigest.digest());
                    messageDigest.reset();
                    if (oOoXoXO2.equals("d8391a394d4a179e6fe7bdb8a301258b")) {
                        return true;
                    }
                } catch (NoSuchAlgorithmException e) {
                    xxIXOIIO.II0XooXoX("openSDK_LOG.Util", "isQQBrowerAvailable has exception: " + e.getMessage());
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static boolean x0xO0oo(Context context, String str) {
        boolean z;
        try {
            z = x0o(context);
        } catch (Exception unused) {
            z = false;
        }
        try {
            if (z) {
                oO(context, "com.tencent.mtt", "com.tencent.mtt.MainActivity", str);
            } else {
                oO(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
            }
            return true;
        } catch (Exception unused2) {
            if (z) {
                try {
                    try {
                        try {
                            oO(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
                            return true;
                        } catch (Exception unused3) {
                            return false;
                        }
                    } catch (Exception unused4) {
                        oO(context, BleNotification.GOOGLE_CHROME, "com.google.android.apps.chrome.Main", str);
                        return true;
                    }
                } catch (Exception unused5) {
                    oO(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                    return true;
                }
            }
            try {
                try {
                    oO(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                    return true;
                } catch (Exception unused6) {
                    return false;
                }
            } catch (Exception unused7) {
                oO(context, BleNotification.GOOGLE_CHROME, "com.google.android.apps.chrome.Main", str);
                return true;
            }
        }
    }

    public static String xI(Context context, String str) {
        if (context == null) {
            return "";
        }
        String XxX0x0xxx2 = XxX0x0xxx(context, str);
        f26958I0Io = XxX0x0xxx2;
        return XxX0x0xxx2;
    }

    public static final boolean xII(String str) {
        if (str == null) {
            return false;
        }
        if (!str.startsWith(BNWebViewClient.URL_HTTP_PREFIX) && !str.startsWith(BNWebViewClient.URL_HTTPS_PREFIX)) {
            return false;
        }
        return true;
    }

    public static JSONObject xXxxox0I(String str) throws JSONException {
        if (str.equals("false")) {
            str = "{value : false}";
        }
        if (str.equals("true")) {
            str = "{value : true}";
        }
        if (str.contains("allback(")) {
            str = str.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
        }
        if (str.contains("online[0]=")) {
            str = "{online:" + str.charAt(str.length() - 2) + ooOOo0oXI.f33074oOoXoXO;
        }
        return new JSONObject(str);
    }

    public static final String xoIox(String str, int i, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "UTF-8";
        }
        try {
            if (str.getBytes(str2).length <= i) {
                return str;
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < str.length()) {
                int i4 = i2 + 1;
                i3 += str.substring(i2, i4).getBytes(str2).length;
                if (i3 > i) {
                    String substring = str.substring(0, i2);
                    if (!TextUtils.isEmpty(str3)) {
                        return substring + str3;
                    }
                    return substring;
                }
                i2 = i4;
            }
            return str;
        } catch (Exception e) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.Util", "Util.subString has exception: " + e.getMessage());
            return str;
        }
    }

    public static void xoXoI(Context context, String str) {
        if (context == null) {
            return;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            String str2 = packageInfo.versionName;
            f26959II0xO0 = str2;
            f26963oIX0oI = str2.substring(0, str2.lastIndexOf(46));
            String str3 = f26959II0xO0;
            f26964oxoX = str3.substring(str3.lastIndexOf(46) + 1, f26959II0xO0.length());
            f26961X0o0xo = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.Util", "getPackageInfo has exception: " + e.getMessage());
        } catch (Exception e2) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.Util", "getPackageInfo has exception: " + e2.getMessage());
        }
    }

    @SuppressLint({"NewApi"})
    public static String xxIXOIIO(Context context, Uri uri) {
        Uri uri2;
        if (uri == null) {
            return null;
        }
        if (DocumentsContract.isDocumentUri(context, uri)) {
            String authority = uri.getAuthority();
            if ("com.android.externalstorage.documents".equals(authority)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                String str = split[0];
                if ("primary".equals(str)) {
                    return Environment.getExternalStorageDirectory().getAbsolutePath().concat("/").concat(split[1]);
                }
                return "/storage/".concat(str).concat("/").concat(split[1]);
            }
            if ("com.android.providers.downloads.documents".equals(authority)) {
                String documentId = DocumentsContract.getDocumentId(uri);
                if (documentId.startsWith("raw:")) {
                    return documentId.replaceFirst("raw:", "");
                }
                return IIXOooo(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(documentId)));
            }
            if ("com.android.providers.media.documents".equals(authority)) {
                String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                String str2 = split2[0];
                if ("image".equals(str2)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str2)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if (MimeTypes.BASE_TYPE_AUDIO.equals(str2)) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                return IIXOooo(context, ContentUris.withAppendedId(uri2, Long.parseLong(split2[1])));
            }
            return null;
        }
        String scheme = uri.getScheme();
        if ("content".equals(scheme)) {
            return IIXOooo(context, uri);
        }
        if (!"file".equals(scheme)) {
            return null;
        }
        return uri.getPath();
    }

    public static JSONObject xxX(String str) {
        try {
            URL url = new URL(str.replace("auth://", BNWebViewClient.URL_HTTP_PREFIX));
            JSONObject ooOOo0oXI2 = ooOOo0oXI(null, url.getQuery());
            ooOOo0oXI(ooOOo0oXI2, url.getRef());
            return ooOOo0oXI2;
        } catch (MalformedURLException unused) {
            return new JSONObject();
        }
    }
}
