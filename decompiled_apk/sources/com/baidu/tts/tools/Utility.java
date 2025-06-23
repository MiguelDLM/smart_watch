package com.baidu.tts.tools;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Base64;
import android.util.DisplayMetrics;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.e3;
import com.google.firebase.crashlytics.buildtools.ndk.NativeSymbolGenerator;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes8.dex */
public class Utility {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f10173a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    public static final Pattern b = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
    public static final Pattern c = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString();
    }

    public static boolean checkPermission(Context context, String str) {
        if (context.checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        return false;
    }

    public static byte[] decrypt2BASE64(String str) {
        if (str != null && str.length() != 0) {
            try {
                byte[] bytes = str.getBytes("utf-8");
                return Base64.decode(bytes, 0, bytes.length, 0);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return new byte[0];
            }
        }
        return null;
    }

    public static String decryptBASE64(String str) {
        if (str != null && str.length() != 0) {
            try {
                byte[] bytes = str.getBytes("utf-8");
                return new String(Base64.decode(bytes, 0, bytes.length, 0), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String decryptGZIP(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            try {
                GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
                byte[] bArr2 = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = gZIPInputStream.read(bArr2, 0, 1024);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } else {
                        gZIPInputStream.close();
                        byteArrayOutputStream.flush();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        return new String(byteArray, "utf-8");
                    }
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static String encryptBASE64(String str) {
        if (str != null && str.length() != 0) {
            try {
                byte[] bytes = str.getBytes("utf-8");
                return new String(Base64.encode(bytes, 0, bytes.length, 0), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] encryptGZIP(String str) {
        if (str != null && str.length() != 0) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(str.getBytes("utf-8"));
                gZIPOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return new byte[0];
            } catch (IOException e2) {
                e2.printStackTrace();
                return new byte[0];
            }
        }
        return null;
    }

    public static String findWakeUpWord(String str, List<String> list) {
        if (str != null && list != null) {
            String replace = str.replace(" ", "");
            for (int i = 0; i < list.size(); i++) {
                String str2 = list.get(i);
                int indexOf = replace.indexOf(str2);
                if (indexOf != -1 && indexOf + 2 + str2.length() <= replace.length()) {
                    return str2;
                }
            }
            return null;
        }
        return null;
    }

    public static String getApkLibPath(Context context) {
        String parent = context.getDir("asr", 0).getParent();
        StringBuilder sb = new StringBuilder();
        sb.append(parent);
        String str = File.separator;
        sb.append(str);
        sb.append(NativeSymbolGenerator.LIB_PREFIX);
        sb.append(str);
        return sb.toString();
    }

    public static String getAppName(Context context) {
        PackageManager packageManager;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = context.getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            packageManager = null;
        }
        if (packageManager != null) {
            return (String) packageManager.getApplicationLabel(applicationInfo);
        }
        return "";
    }

    public static Context getContext() {
        return e3.e().c();
    }

    public static String getCpuModel() {
        String readLine;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
            do {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return null;
                }
            } while (!readLine.contains("Hardware"));
            return readLine.split(":")[1];
        } catch (IOException unused) {
            return null;
        }
    }

    public static int getLastDownloadStatPeriod(Context context) {
        return context.getSharedPreferences("tts", 0).getInt("last_download_stat_period", 0);
    }

    public static long getLastUploadStatTime(Context context) {
        return context.getSharedPreferences("tts", 0).getLong("last_upload_stat_time", 0L);
    }

    public static byte[] getLicenseData(Context context) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = null;
        try {
            try {
                try {
                    fileInputStream = context.openFileInput("baidu_tts_licence.dat");
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read != -1) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            try {
                                break;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    byteArrayOutputStream.close();
                    fileInputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (Exception unused) {
                LoggerProxy.d("Utility", "license not found by default");
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                    throw th;
                } catch (IOException e5) {
                    e5.printStackTrace();
                    throw th;
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0049 -> B:11:0x004c). Please report as a decompilation issue!!! */
    public static byte[] getLicenseDataFromAsset(Context context) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream inputStream = null;
        try {
            try {
                try {
                    inputStream = context.getResources().getAssets().open("baidu_tts_licence.dat");
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read != -1) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            try {
                                break;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    byteArrayOutputStream.close();
                    inputStream.close();
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            throw th;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Exception unused) {
                LoggerProxy.d("Utility", "license not found in assets");
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0054 -> B:14:0x0057). Please report as a decompilation issue!!! */
    public static byte[] getLicenseDataFromFile(String str) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream2 = null;
        try {
            try {
                try {
                    fileInputStream = new FileInputStream(str);
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    try {
                        break;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            byteArrayOutputStream.close();
            fileInputStream.close();
        } catch (Exception unused2) {
            fileInputStream2 = fileInputStream;
            LoggerProxy.d("Utility", "license not found at file: " + str);
            try {
                byteArrayOutputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            try {
                byteArrayOutputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                    throw th;
                } catch (IOException e5) {
                    e5.printStackTrace();
                    throw th;
                }
            }
            throw th;
        }
        return byteArrayOutputStream.toByteArray();
    }

    @SuppressLint({"DefaultLocale"})
    public static int getNetType(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && "wifi".equals(activeNetworkInfo.getTypeName().toLowerCase())) {
            return 1;
        }
        return 3;
    }

    public static NetworkInfo getNetworkInfo(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static String getOS() {
        return "Android";
    }

    public static String getPackageName(Context context) {
        return context.getPackageName();
    }

    public static String getPlatform(Context context) {
        return getOS() + "&" + Build.MODEL + "&" + Build.VERSION.RELEASE + "&" + Build.VERSION.SDK_INT + "&" + getNetType(context);
    }

    public static String getScreen(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
    }

    public static String getSdkName() {
        return "离在线融合TTS SDK";
    }

    public static String getSignatureMD5(Context context) {
        String str = null;
        try {
            try {
                X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray()));
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(x509Certificate.getEncoded());
                str = a(messageDigest.digest());
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (CertificateException e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return str;
    }

    public static String getSystemModel() {
        return Build.MODEL;
    }

    public static List<String> getWakeUpWordFromFile(Context context) {
        InputStream inputStream;
        ArrayList arrayList = new ArrayList();
        try {
            inputStream = context.getResources().getAssets().open("wakeup.cfg");
        } catch (IOException e) {
            e.printStackTrace();
            inputStream = null;
        }
        if (inputStream == null) {
            return arrayList;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            try {
                try {
                    for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                        String trim = readLine.trim();
                        if (!trim.equals("")) {
                            arrayList.add(trim);
                        }
                    }
                    bufferedReader.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (IOException e3) {
                e3.printStackTrace();
                bufferedReader.close();
            }
            return arrayList;
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            throw th;
        }
    }

    public static boolean isIPv4Address(String str) {
        return f10173a.matcher(str).matches();
    }

    public static boolean isIPv6Address(String str) {
        if (!isIPv6StdAddress(str) && !isIPv6HexCompressedAddress(str)) {
            return false;
        }
        return true;
    }

    public static boolean isIPv6HexCompressedAddress(String str) {
        return c.matcher(str).matches();
    }

    public static boolean isIPv6StdAddress(String str) {
        return b.matcher(str).matches();
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo networkInfo = getNetworkInfo(context);
        if (networkInfo != null && networkInfo.isConnected() && networkInfo.isAvailable()) {
            return true;
        }
        return false;
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo networkInfo = getNetworkInfo(context);
        if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x001d -> B:6:0x0020). Please report as a decompilation issue!!! */
    public static void saveLicenseData(Context context, byte[] bArr, int i) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    fileOutputStream = context.openFileOutput("baidu_tts_licence.dat", 0);
                    fileOutputStream.write(bArr, 0, i);
                    fileOutputStream.close();
                } catch (Throwable th) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public static void setLastDownloadStatPeriod(Context context, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences("tts", 0).edit();
        edit.putInt("last_download_stat_period", i);
        edit.commit();
    }

    public static void setLastUploadStatTime(Context context, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences("tts", 0).edit();
        edit.putLong("last_upload_stat_time", j);
        edit.commit();
    }

    public static String stringToMd5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < digest.length; i++) {
                if (Integer.toHexString(digest[i] & 255).length() == 1) {
                    stringBuffer.append("0");
                    stringBuffer.append(Integer.toHexString(digest[i] & 255));
                } else {
                    stringBuffer.append(Integer.toHexString(digest[i] & 255));
                }
            }
            return stringBuffer.toString();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static short[] swapShort(byte[] bArr, int i) {
        Short valueOf;
        if (bArr != null && i >= 2) {
            int i2 = i / 2;
            short[] sArr = new short[i2];
            ByteOrder nativeOrder = ByteOrder.nativeOrder();
            for (int i3 = 0; i3 < i2; i3++) {
                if (nativeOrder.equals(ByteOrder.BIG_ENDIAN)) {
                    int i4 = i3 * 2;
                    valueOf = Short.valueOf((short) ((bArr[i4 + 1] & 255) | ((bArr[i4] << 8) & 255)));
                } else {
                    int i5 = i3 * 2;
                    valueOf = Short.valueOf((short) ((bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8)));
                }
                sArr[i3] = valueOf.shortValue();
            }
            return sArr;
        }
        return null;
    }

    public static String encryptBASE64(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            try {
                return new String(Base64.encode(bArr, 0, bArr.length, 0), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
