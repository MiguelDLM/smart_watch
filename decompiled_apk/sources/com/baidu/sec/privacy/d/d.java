package com.baidu.sec.privacy.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.android.common.util.DeviceId;
import com.bluetrum.fota.manager.OtaCommandGenerator;
import com.garmin.fit.Fit;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.digest.MessageDigestAlgorithms;
import com.realsil.sdk.bbpro.core.transportlayer.TransportLayerPacket;
import java.io.File;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import okio.Utf8;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static int f10022a;
    public final Context b;
    public PublicKey c;

    /* loaded from: classes8.dex */
    public static class a {
        public static byte[] a(byte[] bArr) {
            return a(bArr, bArr.length);
        }

        public static byte[] a(byte[] bArr, int i) {
            byte b;
            int i2;
            int i3 = (i / 4) * 3;
            if (i3 == 0) {
                return new byte[0];
            }
            byte[] bArr2 = new byte[i3];
            int i4 = i;
            int i5 = 0;
            while (true) {
                byte b2 = bArr[i4 - 1];
                b = 10;
                if (b2 != 10 && b2 != 13 && b2 != 32 && b2 != 9) {
                    if (b2 != 61) {
                        break;
                    }
                    i5++;
                }
                i4--;
            }
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (i6 < i4) {
                byte b3 = bArr[i6];
                if (b3 != b && b3 != 13 && b3 != 32 && b3 != 9) {
                    if (b3 >= 65 && b3 <= 90) {
                        i2 = b3 + Fit.f11227x0OxxIOxX;
                    } else if (b3 >= 97 && b3 <= 122) {
                        i2 = b3 - 71;
                    } else if (b3 >= 48 && b3 <= 57) {
                        i2 = b3 + 4;
                    } else if (b3 == 43) {
                        i2 = 62;
                    } else {
                        if (b3 != 47) {
                            return null;
                        }
                        i2 = 63;
                    }
                    i8 = ((byte) i2) | (i8 << 6);
                    if (i9 % 4 == 3) {
                        bArr2[i7] = (byte) ((16711680 & i8) >> 16);
                        int i10 = i7 + 2;
                        bArr2[i7 + 1] = (byte) ((65280 & i8) >> 8);
                        i7 += 3;
                        bArr2[i10] = (byte) (i8 & 255);
                    }
                    i9++;
                }
                i6++;
                b = 10;
            }
            if (i5 > 0) {
                int i11 = i8 << (i5 * 6);
                int i12 = i7 + 1;
                bArr2[i7] = (byte) ((i11 & 16711680) >> 16);
                if (i5 == 1) {
                    i7 += 2;
                    bArr2[i12] = (byte) ((i11 & 65280) >> 8);
                } else {
                    i7 = i12;
                }
            }
            byte[] bArr3 = new byte[i7];
            System.arraycopy(bArr2, 0, bArr3, 0, i7);
            return bArr3;
        }
    }

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public ApplicationInfo f10023a;
        public boolean b;
        public int c;
        public boolean d;

        public /* synthetic */ b(com.baidu.sec.privacy.d.e eVar) {
            this();
        }

        public b() {
            this.c = 0;
            this.d = false;
            this.b = false;
        }
    }

    /* loaded from: classes8.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f10024a;
        public String b;
        public int c = 0;

        public static boolean a(int i) {
            return i >= 14;
        }

        public String c() {
            String str = this.b;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            return this.f10024a + "|" + str;
        }

        public static c b(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                String str2 = "0";
                String str3 = "0";
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!d.b("ZGV2aWNlaWQ=").equals(next) && !d.b("dmVy").equals(next)) {
                        str3 = jSONObject.optString(next, "0");
                    }
                }
                String string = jSONObject.getString(d.b("ZGV2aWNlaWQ="));
                jSONObject.getInt(d.b("dmVy"));
                int length = TextUtils.isEmpty(str3) ? 0 : str3.length();
                if (!TextUtils.isEmpty(string)) {
                    c cVar = new c();
                    cVar.f10024a = string;
                    cVar.c = length;
                    if (length >= 14) {
                        return cVar;
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        str2 = str3;
                    }
                    cVar.b = str2;
                    return cVar;
                }
            } catch (Exception e) {
                com.baidu.sec.privacy.d.c.a(e);
            }
            return null;
        }

        public boolean a() {
            return a(this.b);
        }

        public static boolean a(String str) {
            return TextUtils.isEmpty(str);
        }

        public static c a(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            c cVar = new c();
            cVar.f10024a = str;
            int length = TextUtils.isEmpty(str2) ? 0 : str2.length();
            cVar.c = length;
            if (length >= 14) {
                return cVar;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "0";
            }
            cVar.b = str2;
            return cVar;
        }

        public boolean b() {
            return a(this.c);
        }
    }

    /* renamed from: com.baidu.sec.privacy.d.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C0544d {
        public static byte[] a() {
            return new byte[]{48, -126, 3, 99, 48, -126, 2, 75, OtaCommandGenerator.CMD_OTA_INFO, 3, 2, 1, 2, 2, 4, 106, -93, 120, 122, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 48, 97, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 99, 110, 49, 16, 48, 14, 6, 3, 85, 4, 8, 19, 7, 98, 101, 105, 106, 105, 110, 103, 49, 16, 48, 14, 6, 3, 85, 4, 7, 19, 7, 104, 97, 105, 100, 105, 97, 110, 49, 14, 48, 12, 6, 3, 85, 4, 10, 19, 5, 98, 97, 105, 100, 117, 49, 14, 48, 12, 6, 3, 85, 4, 11, 19, 5, 98, 97, 105, 100, 117, 49, 14, 48, 12, 6, 3, 85, 4, 3, 19, 5, 98, 97, 105, 100, 117, 48, 32, 23, 13, 49, 53, 49, 48, 50, 49, 48, 52, 51, 54, 51, 55, 90, 24, 15, 50, 48, 55, 48, 48, 55, 50, 52, 48, 52, 51, 54, 51, 55, 90, 48, 97, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 99, 110, 49, 16, 48, 14, 6, 3, 85, 4, 8, 19, 7, 98, 101, 105, 106, 105, 110, 103, 49, 16, 48, 14, 6, 3, 85, 4, 7, 19, 7, 104, 97, 105, 100, 105, 97, 110, 49, 14, 48, 12, 6, 3, 85, 4, 10, 19, 5, 98, 97, 105, 100, 117, 49, 14, 48, 12, 6, 3, 85, 4, 11, 19, 5, 98, 97, 105, 100, 117, 49, 14, 48, 12, 6, 3, 85, 4, 3, 19, 5, 98, 97, 105, 100, 117, 48, -126, 1, 34, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -126, 1, 15, 0, 48, -126, 1, 10, 2, -126, 1, 1, 0, TransportLayerPacket.SYNC_WORD, -91, -2, -41, Byte.MAX_VALUE, 37, -25, -33, 93, 51, -73, 32, -81, IIIxO.oIX0oI.f236II0XooXoX, 108, 37, 126, 14, -125, 125, -55, -29, 34, -60, 84, -67, -46, 125, -93, -67, -27, 97, 54, 35, 0, -6, 83, 67, -116, 43, -24, 26, 88, -5, 33, 27, -105, 49, 76, -70, -32, 105, -48, 67, 69, 102, OtaCommandGenerator.CMD_GET_INFO, -81, 93, -103, -18, 17, 55, 81, -34, -80, -76, -13, -84, 6, 91, 10, 48, -56, -1, 45, 9, 23, 34, 6, 103, 35, -51, 29, 70, -19, -51, 20, -39, -43, -97, 75, 23, -124, -101, -71, -75, -107, -88, -13, -71, 80, 90, -76, -119, 51, -80, 118, Byte.MIN_VALUE, -12, -108, 98, -29, -27, 60, -119, -74, 110, IIIxO.oIX0oI.f236II0XooXoX, 51, -22, 53, 66, -99, -45, -25, 111, -121, 25, -72, Byte.MAX_VALUE, 3, 51, -100, 57, -90, 116, -59, -117, 74, -71, 121, 59, 19, -8, -109, 33, -14, 76, -105, -127, -23, 5, 99, -82, 22, -99, 51, 78, -26, 77, -52, -29, 121, 42, -76, 20, 2, 116, 111, -76, 2, -78, -90, -54, 81, 115, 82, 50, 124, -83, 96, 20, -40, -118, 105, 90, -70, 120, -33, OtaCommandGenerator.CMD_GET_INFO_TLV, 12, -15, 38, 34, -125, -116, 69, -54, -103, -109, -124, 26, 94, -89, -98, -11, -66, 89, 48, -68, -51, 107, -60, 12, 114, -71, 119, 49, -31, Fit.f11227x0OxxIOxX, 113, -99, 3, -90, 79, -88, -38, -87, -25, -38, 41, 110, -25, 29, 49, 124, -76, -91, 77, -11, -90, 114, -63, 118, -22, -5, -124, 19, 22, -74, -75, 78, 28, 47, Fit.f11239xXoOI00O, 2, 3, 1, 0, 1, -93, 33, 48, 31, 48, 29, 6, 3, 85, 29, 14, 4, 22, 4, 20, -41, -108, 33, -126, -103, 35, 115, -83, 99, 110, -39, 110, -125, -118, Fit.f11239xXoOI00O, 87, -103, 30, 12, -53, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 3, -126, 1, 1, 0, 0, -117, 0, -28, 51, 26, -4, -15, 86, Byte.MAX_VALUE, 14, -101, -48, 121, 115, -53, -72, -22, 4, -83, 49, 106, -15, -44, -116, -105, 19, 65, -32, 65, 92, 21, 51, IIIxO.oIX0oI.f236II0XooXoX, -21, -74, 71, 91, 64, 75, -72, -48, 102, 17, -120, -23, -68, 51, 23, -104, 107, 65, -30, 109, -6, 46, -44, -46, -73, -54, -55, Utf8.REPLACEMENT_BYTE, 77, -54, -11, -51, 27, -1, 114, 86, -80, 28, -89, 29, -20, 49, -8, 57, -7, -30, IIIxO.oIX0oI.f236II0XooXoX, -108, -6, -60, 113, 45, -32, -93, 19, -62, -89, 106, 91, 96, -48, 90, -59, 46, 104, 111, -88, 51, -39, 40, -36, -113, 86, -92, 25, 30, 94, -13, -15, -57, 59, -21, OtaCommandGenerator.CMD_GET_INFO, 104, -50, -3, -121, -90, -43, IIIxO.oIX0oI.f236II0XooXoX, 105, -3, 57, 69, 51, -3, -31, 105, -12, 19, 77, -82, -120, 121, 108, -63, -126, 46, -43, 14, -56, 21, 47, Utf8.REPLACEMENT_BYTE, -104, -7, 113, 57, 100, -9, -12, -101, 107, -77, -64, 91, -104, -61, 0, -7, -72, -19, 75, 12, 111, Byte.MAX_VALUE, -115, -46, -99, OtaCommandGenerator.CMD_GET_INFO, -93, -67, -42, -66, 32, 81, 70, 109, -57, 10, 19, -49, -44, 59, 21, 31, -61, -59, 83, -14, 43, 73, -88, 120, -58, -46, 46, 66, 41, -2, -70, -6, -42, 103, 8, 4, 89, 110, -122, 68, TransportLayerPacket.SYNC_WORD, 62, -68, 13, -117, 35, -52, -6, 106, -91, 91, -62, -56, -26, -41, -109, 68, -102, -43, -29, 113, 43, -126, -127, 122, -47, -30, OtaCommandGenerator.CMD_OTA_INFO, -2, 78, 44, -92, -38, -124, -102, 73, -105, -66, 5, -85, -7, 56};
        }
    }

    /* loaded from: classes8.dex */
    public static final class e {
        public static byte[] a(byte[] bArr) {
            try {
                return MessageDigest.getInstance(MessageDigestAlgorithms.SHA_1).digest(bArr);
            } catch (Exception e) {
                d.a(e);
                return new byte[0];
            }
        }
    }

    static {
        new String(a.a(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 73, IIIxO.oIX0oI.f236II0XooXoX}));
        new String(a.a(new byte[]{90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, IIIxO.oIX0oI.f236II0XooXoX}));
    }

    public d(Context context) {
        this.b = context.getApplicationContext();
        a();
    }

    public static void a(Throwable th) {
    }

    public static String b(String str) {
        return new String(a.a(str.getBytes()));
    }

    public final String d(String str) {
        try {
            return Settings.System.getString(this.b.getContentResolver(), str);
        } catch (Exception e2) {
            a(e2);
            return null;
        }
    }

    public final boolean e(String str) {
        if (this.b.checkPermission(str, Process.myPid(), Process.myUid()) == 0) {
            return true;
        }
        return false;
    }

    public final String f(String str) {
        return "0";
    }

    public static String a(Context context) {
        c b2 = b(context);
        return b2 != null ? b2.c() : "";
    }

    public final c c() {
        return c.a(d("com.baidu.deviceid"), d("bd_setting_i"));
    }

    public static c b(Context context) {
        return new d(context).b();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0033 -> B:8:0x0036). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r4 = this;
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            byte[] r2 = com.baidu.sec.privacy.d.d.C0544d.a()     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            java.lang.String r0 = "X.509"
            java.security.cert.CertificateFactory r0 = java.security.cert.CertificateFactory.getInstance(r0)     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
            java.security.cert.Certificate r0 = r0.generateCertificate(r1)     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
            java.security.PublicKey r0 = r0.getPublicKey()     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
            r4.c = r0     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
            r1.close()     // Catch: java.lang.Exception -> L1e
            goto L36
        L1e:
            r0 = move-exception
            goto L33
        L20:
            r0 = move-exception
            goto L37
        L22:
            r0 = move-exception
            goto L2a
        L24:
            r1 = move-exception
            goto L3a
        L26:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
        L2a:
            a(r0)     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L36
            r1.close()     // Catch: java.lang.Exception -> L1e
            goto L36
        L33:
            a(r0)
        L36:
            return
        L37:
            r3 = r1
            r1 = r0
            r0 = r3
        L3a:
            if (r0 == 0) goto L44
            r0.close()     // Catch: java.lang.Exception -> L40
            goto L44
        L40:
            r0 = move-exception
            a(r0)
        L44:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sec.privacy.d.d.a():void");
    }

    public final c b() {
        List<b> a2 = a(new Intent("com.baidu.intent.action.GALAXY").setPackage(this.b.getPackageName()), true);
        boolean z = false;
        if (a2 == null || a2.size() == 0) {
            for (int i = 0; i < 3; i++) {
            }
        } else {
            boolean z2 = a2.get(0).d;
            if (!z2) {
                for (int i2 = 0; i2 < 3; i2++) {
                }
            }
            z = z2;
        }
        File file = new File(this.b.getFilesDir(), "libcuid.so");
        c b2 = file.exists() ? c.b(a(a(file))) : null;
        if (b2 == null) {
            f10022a |= 16;
            List<b> a3 = a(new Intent("com.baidu.intent.action.GALAXY"), z);
            if (a3 != null) {
                File filesDir = this.b.getFilesDir();
                String name = "files".equals(filesDir.getName()) ? "files" : filesDir.getName();
                for (b bVar : a3) {
                    if (!bVar.b) {
                        File file2 = new File(new File(bVar.f10023a.dataDir, name), "libcuid.so");
                        if (file2.exists() && (b2 = c.b(a(a(file2)))) != null) {
                            break;
                        }
                    }
                }
            }
        }
        if (b2 == null) {
            b2 = c.b(a(d("com.baidu.deviceid.v2")));
        }
        boolean e2 = e(com.kuaishou.weapon.p0.g.i);
        if (b2 == null && e2) {
            f10022a |= 2;
        }
        if (b2 == null) {
            f10022a |= 8;
            b2 = c();
        }
        if (b2 == null && e2) {
            f10022a |= 1;
            f("");
        }
        a(b2);
        return b2;
    }

    public static String a(byte[] bArr) {
        if (bArr != null) {
            String str = "";
            for (byte b2 : bArr) {
                String hexString = Integer.toHexString(b2 & 255);
                str = hexString.length() == 1 ? str + "0" + hexString : str + hexString;
            }
            return str.toLowerCase();
        }
        throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
    }

    public final String[] a(Signature[] signatureArr) {
        int length = signatureArr.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = a(e.a(signatureArr[i].toByteArray()));
        }
        return strArr;
    }

    public static byte[] a(byte[] bArr, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, publicKey);
        return cipher.doFinal(bArr);
    }

    public final List<b> a(Intent intent, boolean z) {
        byte[] a2;
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = this.b.getPackageManager();
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers != null) {
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null && activityInfo.applicationInfo != null) {
                    try {
                        ActivityInfo activityInfo2 = resolveInfo.activityInfo;
                        Bundle bundle = packageManager.getReceiverInfo(new ComponentName(activityInfo2.packageName, activityInfo2.name), 128).metaData;
                        if (bundle != null) {
                            String string = bundle.getString("galaxy_data");
                            if (!TextUtils.isEmpty(string)) {
                                byte[] a3 = a.a(string.getBytes("utf-8"));
                                JSONObject jSONObject = new JSONObject(new String(a3));
                                b bVar = new b(null);
                                bVar.c = jSONObject.getInt("priority");
                                bVar.f10023a = resolveInfo.activityInfo.applicationInfo;
                                if (this.b.getPackageName().equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                                    bVar.b = true;
                                }
                                if (z) {
                                    String string2 = bundle.getString("galaxy_sf");
                                    if (!TextUtils.isEmpty(string2)) {
                                        PackageInfo packageInfo = packageManager.getPackageInfo(resolveInfo.activityInfo.applicationInfo.packageName, 64);
                                        JSONArray jSONArray = jSONObject.getJSONArray("sigs");
                                        int length = jSONArray.length();
                                        String[] strArr = new String[length];
                                        for (int i = 0; i < length; i++) {
                                            strArr[i] = jSONArray.getString(i);
                                        }
                                        if (a(strArr, a(packageInfo.signatures)) && (a2 = a(a.a(string2.getBytes()), this.c)) != null && Arrays.equals(a2, e.a(a3))) {
                                            bVar.d = true;
                                        }
                                    }
                                }
                                arrayList.add(bVar);
                            }
                        }
                    } catch (Exception e2) {
                        a(e2);
                    }
                }
            }
        }
        Collections.sort(arrayList, new com.baidu.sec.privacy.d.e(this));
        return arrayList;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return "";
    }

    public final boolean a(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
            return false;
        }
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            hashSet.add(str);
        }
        HashSet hashSet2 = new HashSet();
        for (String str2 : strArr2) {
            hashSet2.add(str2);
        }
        return hashSet.equals(hashSet2);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(java.io.File r5) {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            r5 = 8192(0x2000, float:1.148E-41)
            char[] r5 = new char[r5]     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1d
            java.io.CharArrayWriter r2 = new java.io.CharArrayWriter     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1d
            r2.<init>()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1d
        Lf:
            int r3 = r1.read(r5)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1d
            if (r3 <= 0) goto L1f
            r4 = 0
            r2.write(r5, r4, r3)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1d
            goto Lf
        L1a:
            r5 = move-exception
            r0 = r1
            goto L3e
        L1d:
            r5 = move-exception
            goto L30
        L1f:
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1d
            r1.close()     // Catch: java.lang.Exception -> L27
            goto L2b
        L27:
            r0 = move-exception
            a(r0)
        L2b:
            return r5
        L2c:
            r5 = move-exception
            goto L3e
        L2e:
            r5 = move-exception
            r1 = r0
        L30:
            a(r5)     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L3d
            r1.close()     // Catch: java.lang.Exception -> L39
            goto L3d
        L39:
            r5 = move-exception
            a(r5)
        L3d:
            return r0
        L3e:
            if (r0 == 0) goto L48
            r0.close()     // Catch: java.lang.Exception -> L44
            goto L48
        L44:
            r0 = move-exception
            a(r0)
        L48:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sec.privacy.d.d.a(java.io.File):java.lang.String");
    }

    public final boolean a(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (cVar.b()) {
            cVar.b = DeviceId.CUIDInfo.I_FIXED;
            return true;
        }
        if (!cVar.a()) {
            return false;
        }
        cVar.b = "0";
        return true;
    }
}
