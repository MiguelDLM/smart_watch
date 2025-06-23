package com.baidu.android.common.util;

import IIIxO.oIX0oI;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.system.ErrnoException;
import android.system.Os;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.security.AESUtil;
import com.baidu.android.common.security.Base64;
import com.baidu.android.common.security.MD5Util;
import com.baidu.android.common.security.SHA1Util;
import com.huawei.openalliance.ad.constant.ah;
import com.kuaishou.weapon.p0.g;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import javax.crypto.Cipher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class DeviceId {
    private static final String ACTION_GLAXY_CUID = "com.baidu.intent.action.GALAXY";
    private static final String AES_KEY = new String(Base64.decode(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 73, oIX0oI.f236II0XooXoX})) + new String(Base64.decode(new byte[]{90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, oIX0oI.f236II0XooXoX}));
    private static final boolean CONFIG_WRITE_V1_STORAGE = false;
    private static final boolean DEBUG = false;
    private static final String DEFAULT_TM_DEVICEID = "";
    private static final String EXT_DIR = "backups/.SystemConfig";
    private static final String EXT_FILE = ".cuid";
    private static final String EXT_FILE_V2 = ".cuid2";
    private static final String KEY_DEVICE_ID = "com.baidu.deviceid";
    private static final String KEY_DEVICE_ID_V2 = "com.baidu.deviceid.v2";
    private static final String KEY_FLAG = "bd_setting_i";
    private static final String META_KEY_GALAXY_SF = "galaxy_sf";
    private static final String META_KEY_GLAXY_DATA = "galaxy_data";
    private static final String OLD_EXT_DIR = "baidu";
    private static final String RSA_ALGORITHM = "RSA/ECB/PKCS1Padding";
    private static final int SDK_ANDROID_M = 23;
    private static final String SELF_CUID_FILE = "libcuid.so";
    private static final int STORAGE_SDCARD_V1 = 4;
    private static final int STORAGE_SDCARD_V2 = 8;
    private static final int STORAGE_SELF_FILE = 16;
    private static final int STORAGE_SYSTEM_SETTING_V1 = 1;
    private static final int STORAGE_SYSTEM_SETTING_V2 = 2;
    private static final int S_IRGRP = 32;
    private static final int S_IROTH = 4;
    private static final int S_IRUSR = 256;
    private static final int S_IRWXG = 56;
    private static final int S_IRWXO = 7;
    private static final int S_IRWXU = 448;
    private static final int S_IWGRP = 16;
    private static final int S_IWOTH = 2;
    private static final int S_IWUSR = 128;
    private static final int S_IXGRP = 8;
    private static final int S_IXOTH = 1;
    private static final int S_IXUSR = 64;
    private static final String TAG = "DeviceId";
    private static CUIDInfo sCachedCuidInfo = null;
    private static final String sDEncoded = "ZGV2aWNlaWQ=";
    private static boolean sDataCuidInfoShable = true;
    private static final String sIEncoded = "aW1laQ==";
    private static final String sVEncoded = "dmVy";
    private final Context mContext;
    private PublicKey mPublicKey;
    private int mSaveMask = 0;

    /* loaded from: classes7.dex */
    public static class CUIDBuddyInfo {
        public ApplicationInfo appInfo;
        public boolean isSelf;
        public int priority;
        public boolean sigMatched;

        private CUIDBuddyInfo() {
            this.priority = 0;
            this.sigMatched = false;
            this.isSelf = false;
        }
    }

    /* loaded from: classes7.dex */
    public static class CUIDInfo {
        public static final String I_EMPTY = "0";
        public static final String I_FIXED = "O";
        public static final int PROTOCAL_MAX_LENGTH = 14;
        private static final int VERSION_DEF = 2;
        public String deviceId;
        public String flag;
        public int oldValueLength;
        public int version;

        private CUIDInfo() {
            this.version = 2;
            this.oldValueLength = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static CUIDInfo createCuidInfoFromV1Cache(String str, String str2) {
            int length;
            if (!TextUtils.isEmpty(str)) {
                CUIDInfo cUIDInfo = new CUIDInfo();
                cUIDInfo.deviceId = str;
                if (TextUtils.isEmpty(str2)) {
                    length = 0;
                } else {
                    length = str2.length();
                }
                cUIDInfo.oldValueLength = length;
                if (length < 14) {
                    if (TextUtils.isEmpty(str2)) {
                        str2 = "0";
                    }
                    cUIDInfo.flag = str2;
                }
                return cUIDInfo;
            }
            return null;
        }

        public static CUIDInfo createFromJson(String str) {
            int length;
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
                    if (!DeviceId.getBase64DecodeStr(DeviceId.sDEncoded).equals(next) && !DeviceId.getBase64DecodeStr(DeviceId.sVEncoded).equals(next)) {
                        str3 = jSONObject.optString(next, "0");
                    }
                }
                String string = jSONObject.getString(DeviceId.getBase64DecodeStr(DeviceId.sDEncoded));
                int i = jSONObject.getInt(DeviceId.getBase64DecodeStr(DeviceId.sVEncoded));
                if (TextUtils.isEmpty(str3)) {
                    length = 0;
                } else {
                    length = str3.length();
                }
                if (!TextUtils.isEmpty(string)) {
                    CUIDInfo cUIDInfo = new CUIDInfo();
                    cUIDInfo.deviceId = string;
                    cUIDInfo.version = i;
                    cUIDInfo.oldValueLength = length;
                    if (length < 14) {
                        if (!TextUtils.isEmpty(str3)) {
                            str2 = str3;
                        }
                        cUIDInfo.flag = str2;
                    }
                    return cUIDInfo;
                }
            } catch (JSONException e) {
                DeviceId.handleThrowable(e);
            }
            return null;
        }

        public static boolean isIENormal(int i) {
            return i >= 14;
        }

        public String getFinalCUID() {
            String str = this.flag;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            return this.deviceId + "|" + str;
        }

        public boolean isIENull() {
            return isIENull(this.flag);
        }

        public String toPersitString() {
            try {
                return new JSONObject().put(DeviceId.getBase64DecodeStr(DeviceId.sDEncoded), this.deviceId).put(DeviceId.getBase64DecodeStr(DeviceId.sIEncoded), this.flag).put(DeviceId.getBase64DecodeStr(DeviceId.sVEncoded), this.version).toString();
            } catch (JSONException e) {
                DeviceId.handleThrowable(e);
                return null;
            }
        }

        public static boolean isIENull(String str) {
            return TextUtils.isEmpty(str);
        }

        public boolean isIENormal() {
            return isIENormal(this.oldValueLength);
        }
    }

    /* loaded from: classes7.dex */
    public static class TargetApiSupport {
        public static boolean doChmodSafely(String str, int i) {
            try {
                Os.chmod(str, i);
                return true;
            } catch (ErrnoException e) {
                DeviceId.handleThrowable(e);
                return false;
            } catch (Exception e2) {
                DeviceId.handleThrowable(e2);
                return false;
            }
        }
    }

    private DeviceId(Context context) {
        this.mContext = context.getApplicationContext();
        initPublicKey();
    }

    private static String byte2hex(byte[] bArr) {
        if (bArr != null) {
            String str = "";
            for (byte b : bArr) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    str = str + "0" + hexString;
                } else {
                    str = str + hexString;
                }
            }
            return str.toLowerCase();
        }
        throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkSelfPermission(String str) {
        if (this.mContext.checkPermission(str, Process.myPid(), Process.myUid()) == 0) {
            return true;
        }
        return false;
    }

    private List<CUIDBuddyInfo> collectBuddyInfos(Intent intent, boolean z) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = this.mContext.getPackageManager();
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers != null) {
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null && activityInfo.applicationInfo != null) {
                    try {
                        ActivityInfo activityInfo2 = resolveInfo.activityInfo;
                        Bundle bundle = packageManager.getReceiverInfo(new ComponentName(activityInfo2.packageName, activityInfo2.name), 128).metaData;
                        if (bundle != null) {
                            String string = bundle.getString(META_KEY_GLAXY_DATA);
                            if (!TextUtils.isEmpty(string)) {
                                byte[] decode = Base64.decode(string.getBytes("utf-8"));
                                JSONObject jSONObject = new JSONObject(new String(decode));
                                CUIDBuddyInfo cUIDBuddyInfo = new CUIDBuddyInfo();
                                cUIDBuddyInfo.priority = jSONObject.getInt("priority");
                                cUIDBuddyInfo.appInfo = resolveInfo.activityInfo.applicationInfo;
                                if (this.mContext.getPackageName().equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                                    cUIDBuddyInfo.isSelf = true;
                                }
                                if (z) {
                                    String string2 = bundle.getString(META_KEY_GALAXY_SF);
                                    if (!TextUtils.isEmpty(string2)) {
                                        PackageInfo packageInfo = packageManager.getPackageInfo(resolveInfo.activityInfo.applicationInfo.packageName, 64);
                                        JSONArray jSONArray = jSONObject.getJSONArray("sigs");
                                        int length = jSONArray.length();
                                        String[] strArr = new String[length];
                                        for (int i = 0; i < length; i++) {
                                            strArr[i] = jSONArray.getString(i);
                                        }
                                        if (isSigsEqual(strArr, formatAndroidSigArray(packageInfo.signatures))) {
                                            byte[] decryptByPublicKey = decryptByPublicKey(Base64.decode(string2.getBytes()), this.mPublicKey);
                                            byte[] sha1 = SHA1Util.sha1(decode);
                                            if (decryptByPublicKey != null && Arrays.equals(decryptByPublicKey, sha1)) {
                                                cUIDBuddyInfo.sigMatched = true;
                                            }
                                        }
                                    }
                                }
                                arrayList.add(cUIDBuddyInfo);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        Collections.sort(arrayList, new Comparator<CUIDBuddyInfo>() { // from class: com.baidu.android.common.util.DeviceId.1
            @Override // java.util.Comparator
            public int compare(CUIDBuddyInfo cUIDBuddyInfo2, CUIDBuddyInfo cUIDBuddyInfo3) {
                int i2 = cUIDBuddyInfo3.priority - cUIDBuddyInfo2.priority;
                if (i2 == 0) {
                    boolean z2 = cUIDBuddyInfo2.isSelf;
                    if (z2 && cUIDBuddyInfo3.isSelf) {
                        return 0;
                    }
                    if (z2) {
                        return -1;
                    }
                    if (cUIDBuddyInfo3.isSelf) {
                        return 1;
                    }
                }
                return i2;
            }
        });
        return arrayList;
    }

    private static byte[] decryptByPublicKey(byte[] bArr, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(2, publicKey);
        return cipher.doFinal(bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String decryptCUIDInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String str2 = AES_KEY;
            return new String(AESUtil.decrypt(str2, str2, Base64.decode(str.getBytes())));
        } catch (Exception e) {
            handleThrowable(e);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String encryptCUIDInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String str2 = AES_KEY;
            return Base64.encode(AESUtil.encrypt(str2, str2, str.getBytes()), "utf-8");
        } catch (UnsupportedEncodingException e) {
            handleThrowable(e);
            return "";
        } catch (Exception e2) {
            handleThrowable(e2);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fixCUIDInfoByIE(CUIDInfo cUIDInfo) {
        if (cUIDInfo.isIENormal()) {
            cUIDInfo.flag = CUIDInfo.I_FIXED;
            return true;
        }
        if (cUIDInfo.isIENull()) {
            cUIDInfo.flag = "0";
            return true;
        }
        return false;
    }

    private String[] formatAndroidSigArray(Signature[] signatureArr) {
        int length = signatureArr.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = byte2hex(SHA1Util.sha1(signatureArr[i].toByteArray()));
        }
        return strArr;
    }

    private static String getAndroidId(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getBase64DecodeStr(String str) {
        return new String(Base64.decode(str.getBytes()));
    }

    public static String getCUID(Context context) {
        return getOrCreateCUIDInfo(context).getFinalCUID();
    }

    private CUIDInfo getCUIDInfo() {
        boolean z;
        CUIDInfo cUIDInfo;
        String str;
        String str2;
        List<CUIDBuddyInfo> collectBuddyInfos = collectBuddyInfos(new Intent(ACTION_GLAXY_CUID).setPackage(this.mContext.getPackageName()), true);
        boolean z2 = false;
        if (collectBuddyInfos != null && collectBuddyInfos.size() != 0) {
            z = collectBuddyInfos.get(0).sigMatched;
            if (!z) {
                for (int i = 0; i < 3; i++) {
                    Log.w(TAG, "galaxy config err, In the release version of the signature should be matched");
                }
            }
        } else {
            for (int i2 = 0; i2 < 3; i2++) {
                Log.w(TAG, "galaxy lib host missing meta-data,make sure you know the right way to integrate galaxy");
            }
            z = false;
        }
        File file = new File(this.mContext.getFilesDir(), SELF_CUID_FILE);
        if (file.exists()) {
            cUIDInfo = CUIDInfo.createFromJson(decryptCUIDInfo(getFileContent(file)));
        } else {
            cUIDInfo = null;
        }
        if (cUIDInfo == null) {
            this.mSaveMask |= 16;
            List<CUIDBuddyInfo> collectBuddyInfos2 = collectBuddyInfos(new Intent(ACTION_GLAXY_CUID), z);
            if (collectBuddyInfos2 != null) {
                File filesDir = this.mContext.getFilesDir();
                String str3 = "files";
                if (!"files".equals(filesDir.getName())) {
                    Log.e(TAG, "fetal error:: app files dir name is unexpectedly :: " + filesDir.getAbsolutePath());
                    str3 = filesDir.getName();
                }
                for (CUIDBuddyInfo cUIDBuddyInfo : collectBuddyInfos2) {
                    if (!cUIDBuddyInfo.isSelf) {
                        File file2 = new File(new File(cUIDBuddyInfo.appInfo.dataDir, str3), SELF_CUID_FILE);
                        if (file2.exists() && (cUIDInfo = CUIDInfo.createFromJson(decryptCUIDInfo(getFileContent(file2)))) != null) {
                            break;
                        }
                    }
                }
            }
        }
        if (cUIDInfo == null) {
            cUIDInfo = CUIDInfo.createFromJson(decryptCUIDInfo(getSystemSettingValue(KEY_DEVICE_ID_V2)));
        }
        boolean checkSelfPermission = checkSelfPermission(g.i);
        if (cUIDInfo == null && checkSelfPermission) {
            this.mSaveMask |= 2;
            cUIDInfo = getCuidInfoFromExternalV2();
        }
        if (cUIDInfo == null) {
            this.mSaveMask |= 8;
            cUIDInfo = getCUidInfoFromSystemSettingV1();
        }
        if (cUIDInfo == null && checkSelfPermission) {
            this.mSaveMask |= 1;
            str = getDefaultFlag("");
            cUIDInfo = getExternalV1DeviceId(str);
            z2 = true;
        } else {
            str = null;
        }
        if (cUIDInfo == null) {
            this.mSaveMask |= 4;
            if (!z2) {
                str = getDefaultFlag("");
            }
            cUIDInfo = new CUIDInfo();
            String androidId = getAndroidId(this.mContext);
            if (Build.VERSION.SDK_INT < 23) {
                str2 = str + androidId + UUID.randomUUID().toString();
            } else {
                str2 = "com.baidu" + androidId;
            }
            cUIDInfo.deviceId = MD5Util.toMd5(str2.getBytes(), true);
            cUIDInfo.flag = str;
        }
        fixCUIDInfoByIE(cUIDInfo);
        writeJobThread(cUIDInfo);
        return cUIDInfo;
    }

    private CUIDInfo getCUidInfoFromSystemSettingV1() {
        return CUIDInfo.createCuidInfoFromV1Cache(getSystemSettingValue(KEY_DEVICE_ID), getSystemSettingValue(KEY_FLAG));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CUIDInfo getCuidInfoFromExternalV2() {
        File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
        if (file.exists()) {
            String fileContent = getFileContent(file);
            if (!TextUtils.isEmpty(fileContent)) {
                try {
                    String str = AES_KEY;
                    return CUIDInfo.createFromJson(new String(AESUtil.decrypt(str, str, Base64.decode(fileContent.getBytes()))));
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getDefaultFlag(String str) {
        return "0";
    }

    public static String getDeviceID(Context context) {
        return getOrCreateCUIDInfo(context).deviceId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CUIDInfo getExternalV1DeviceId(String str) {
        String str2;
        String[] split;
        String str3 = "";
        File file = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
        if (!file.exists()) {
            file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append("\r\n");
            }
            bufferedReader.close();
            String str4 = AES_KEY;
            split = new String(AESUtil.decrypt(str4, str4, Base64.decode(sb.toString().getBytes()))).split("=");
        } catch (FileNotFoundException | IOException | Exception unused) {
        }
        if (split != null && split.length == 2) {
            str2 = split[0];
            try {
                str3 = split[1];
            } catch (FileNotFoundException | IOException | Exception unused2) {
            }
            return CUIDInfo.createCuidInfoFromV1Cache(str3, str2);
        }
        str2 = "";
        return CUIDInfo.createCuidInfoFromV1Cache(str3, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getFileContent(java.io.File r5) {
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
            handleThrowable(r0)
        L2b:
            return r5
        L2c:
            r5 = move-exception
            goto L3e
        L2e:
            r5 = move-exception
            r1 = r0
        L30:
            handleThrowable(r5)     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L3d
            r1.close()     // Catch: java.lang.Exception -> L39
            goto L3d
        L39:
            r5 = move-exception
            handleThrowable(r5)
        L3d:
            return r0
        L3e:
            if (r0 == 0) goto L48
            r0.close()     // Catch: java.lang.Exception -> L44
            goto L48
        L44:
            r0 = move-exception
            handleThrowable(r0)
        L48:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.common.util.DeviceId.getFileContent(java.io.File):java.lang.String");
    }

    private static CUIDInfo getOrCreateCUIDInfo(Context context) {
        if (sCachedCuidInfo == null) {
            synchronized (CUIDInfo.class) {
                try {
                    if (sCachedCuidInfo == null) {
                        SystemClock.uptimeMillis();
                        sCachedCuidInfo = new DeviceId(context).getCUIDInfo();
                        SystemClock.uptimeMillis();
                    }
                } finally {
                }
            }
        }
        return sCachedCuidInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSystemSettingValue(String str) {
        try {
            return Settings.System.getString(this.mContext.getContentResolver(), str);
        } catch (Exception e) {
            handleThrowable(e);
            return null;
        }
    }

    private Runnable getWriteRunnable(final CUIDInfo cUIDInfo) {
        return new Runnable() { // from class: com.baidu.android.common.util.DeviceId.2
            @Override // java.lang.Runnable
            public void run() {
                int length;
                CUIDInfo cUIDInfo2 = new CUIDInfo();
                CUIDInfo cUIDInfo3 = cUIDInfo;
                cUIDInfo2.flag = cUIDInfo3.flag;
                cUIDInfo2.deviceId = cUIDInfo3.deviceId;
                File file = new File(DeviceId.this.mContext.getFilesDir(), DeviceId.SELF_CUID_FILE);
                String encryptCUIDInfo = DeviceId.encryptCUIDInfo(cUIDInfo2.toPersitString());
                if (!file.exists()) {
                    DeviceId.this.writeToCuidFile(encryptCUIDInfo);
                } else {
                    CUIDInfo createFromJson = CUIDInfo.createFromJson(DeviceId.decryptCUIDInfo(DeviceId.getFileContent(file)));
                    if (createFromJson != null) {
                        if (DeviceId.this.fixCUIDInfoByIE(createFromJson)) {
                            DeviceId.this.writeToCuidFile(DeviceId.encryptCUIDInfo(createFromJson.toPersitString()));
                        }
                    } else if (createFromJson == null) {
                        DeviceId.this.writeToCuidFile(encryptCUIDInfo);
                    }
                }
                boolean hasWriteSettingsPermission = DeviceId.this.hasWriteSettingsPermission();
                if (hasWriteSettingsPermission) {
                    String systemSettingValue = DeviceId.this.getSystemSettingValue(DeviceId.KEY_DEVICE_ID_V2);
                    if (TextUtils.isEmpty(systemSettingValue)) {
                        DeviceId.this.tryPutSystemSettingValue(DeviceId.KEY_DEVICE_ID_V2, encryptCUIDInfo);
                    } else {
                        CUIDInfo createFromJson2 = CUIDInfo.createFromJson(DeviceId.decryptCUIDInfo(systemSettingValue));
                        if (createFromJson2 != null) {
                            if (DeviceId.this.fixCUIDInfoByIE(createFromJson2)) {
                                DeviceId.this.tryPutSystemSettingValue(DeviceId.KEY_DEVICE_ID_V2, DeviceId.encryptCUIDInfo(createFromJson2.toPersitString()));
                            }
                        } else if (createFromJson2 == null) {
                            DeviceId.this.tryPutSystemSettingValue(DeviceId.KEY_DEVICE_ID_V2, encryptCUIDInfo);
                        }
                    }
                }
                boolean checkSelfPermission = DeviceId.this.checkSelfPermission(g.j);
                if (checkSelfPermission) {
                    if (!new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2").exists()) {
                        DeviceId.setExternalV2DeviceId(encryptCUIDInfo);
                    } else {
                        CUIDInfo cuidInfoFromExternalV2 = DeviceId.this.getCuidInfoFromExternalV2();
                        if (cuidInfoFromExternalV2 != null) {
                            if (DeviceId.this.fixCUIDInfoByIE(cuidInfoFromExternalV2)) {
                                DeviceId.setExternalV2DeviceId(DeviceId.encryptCUIDInfo(cuidInfoFromExternalV2.toPersitString()));
                            }
                        } else if (cuidInfoFromExternalV2 == null) {
                            DeviceId.setExternalV2DeviceId(encryptCUIDInfo);
                        }
                    }
                }
                if (hasWriteSettingsPermission) {
                    String systemSettingValue2 = DeviceId.this.getSystemSettingValue(DeviceId.KEY_FLAG);
                    if (TextUtils.isEmpty(systemSettingValue2)) {
                        length = 0;
                    } else {
                        length = systemSettingValue2.length();
                    }
                    if (CUIDInfo.isIENormal(length)) {
                        DeviceId.this.tryPutSystemSettingValue(DeviceId.KEY_FLAG, CUIDInfo.I_FIXED);
                    } else if (CUIDInfo.isIENull(systemSettingValue2)) {
                        DeviceId.this.tryPutSystemSettingValue(DeviceId.KEY_FLAG, "0");
                    }
                }
                if (checkSelfPermission && new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid").exists()) {
                    CUIDInfo externalV1DeviceId = DeviceId.this.getExternalV1DeviceId(DeviceId.this.getDefaultFlag(""));
                    if (externalV1DeviceId != null && DeviceId.this.fixCUIDInfoByIE(externalV1DeviceId)) {
                        DeviceId.setExternalDeviceId(externalV1DeviceId.flag, externalV1DeviceId.deviceId);
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleThrowable(Throwable th) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasWriteSettingsPermission() {
        return checkSelfPermission("android.permission.WRITE_SETTINGS");
    }

    private void initPublicKey() {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            try {
                byteArrayInputStream = new ByteArrayInputStream(CuidCertStore.getCertBytes());
                try {
                    this.mPublicKey = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream).getPublicKey();
                    byteArrayInputStream.close();
                } catch (Exception unused) {
                    byteArrayInputStream2 = byteArrayInputStream;
                    if (byteArrayInputStream2 != null) {
                        byteArrayInputStream2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (Exception e) {
                            handleThrowable(e);
                        }
                    }
                    throw th;
                }
            } catch (Exception e2) {
                handleThrowable(e2);
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            byteArrayInputStream = null;
            th = th3;
        }
    }

    private boolean isSigsEqual(String[] strArr, String[] strArr2) {
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

    public static void setCuidDataShable(Context context, boolean z) {
        File file = new File(context.getApplicationContext().getFilesDir(), SELF_CUID_FILE);
        Context applicationContext = context.getApplicationContext();
        if (file.exists()) {
            if (sCachedCuidInfo == null) {
                tryToModifyChmodForSelfFile(applicationContext, z);
            } else if (sDataCuidInfoShable != z) {
                tryToModifyChmodForSelfFile(applicationContext, z);
            }
        }
        sDataCuidInfoShable = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setExternalDeviceId(String str, String str2) {
        File file;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file2 = new File(Environment.getExternalStorageDirectory(), EXT_DIR);
        File file3 = new File(file2, EXT_FILE);
        try {
            if (file2.exists() && !file2.isDirectory()) {
                Random random = new Random();
                File parentFile = file2.getParentFile();
                String name = file2.getName();
                do {
                    file = new File(parentFile, name + random.nextInt() + ".tmp");
                } while (file.exists());
                file2.renameTo(file);
                file.delete();
            }
            file2.mkdirs();
            FileWriter fileWriter = new FileWriter(file3, false);
            String str3 = AES_KEY;
            fileWriter.write(Base64.encode(AESUtil.encrypt(str3, str3, (str + "=" + str2).getBytes()), "utf-8"));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException | Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setExternalV2DeviceId(String str) {
        File file;
        File file2 = new File(Environment.getExternalStorageDirectory(), EXT_DIR);
        File file3 = new File(file2, EXT_FILE_V2);
        try {
            if (file2.exists() && !file2.isDirectory()) {
                Random random = new Random();
                File parentFile = file2.getParentFile();
                String name = file2.getName();
                do {
                    file = new File(parentFile, name + random.nextInt() + ".tmp");
                } while (file.exists());
                file2.renameTo(file);
                file.delete();
            }
            file2.mkdirs();
            FileWriter fileWriter = new FileWriter(file3, false);
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException | Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tryPutSystemSettingValue(String str, String str2) {
        try {
            return Settings.System.putString(this.mContext.getContentResolver(), str, str2);
        } catch (Exception e) {
            handleThrowable(e);
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    private static boolean tryToModifyChmodForSelfFile(Context context, boolean z) {
        int i;
        File file = new File(context.getApplicationContext().getFilesDir(), SELF_CUID_FILE);
        if (!file.exists()) {
            return false;
        }
        if (z) {
            i = 436;
        } else {
            i = ah.s;
        }
        return TargetApiSupport.doChmodSafely(file.getAbsolutePath(), i);
    }

    private synchronized void writeJobThread(CUIDInfo cUIDInfo) {
        new Thread(getWriteRunnable(cUIDInfo)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public boolean writeToCuidFile(String str) {
        int i;
        if (sDataCuidInfoShable && Build.VERSION.SDK_INT < 24) {
            i = 1;
        } else {
            i = 0;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                fileOutputStream = this.mContext.openFileOutput(SELF_CUID_FILE, i);
                fileOutputStream.write(str.getBytes());
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (Exception e) {
                    handleThrowable(e);
                }
                if (i == 0 && sDataCuidInfoShable) {
                    return TargetApiSupport.doChmodSafely(new File(this.mContext.getFilesDir(), SELF_CUID_FILE).getAbsolutePath(), 436);
                }
                if (sDataCuidInfoShable) {
                    return true;
                }
                return TargetApiSupport.doChmodSafely(new File(this.mContext.getFilesDir(), SELF_CUID_FILE).getAbsolutePath(), ah.s);
            } catch (Throwable th) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e2) {
                        handleThrowable(e2);
                    }
                }
                throw th;
            }
        } catch (Exception e3) {
            handleThrowable(e3);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e4) {
                    handleThrowable(e4);
                }
            }
            return false;
        }
    }

    private static void writeToFile(File file, byte[] bArr) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e) {
                    handleThrowable(e);
                }
            } catch (IOException e2) {
                e = e2;
            } catch (SecurityException e3) {
                e = e3;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e4) {
            e = e4;
            fileOutputStream2 = fileOutputStream;
            handleThrowable(e);
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (SecurityException e5) {
            e = e5;
            fileOutputStream2 = fileOutputStream;
            handleThrowable(e);
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e6) {
                    handleThrowable(e6);
                }
            }
            throw th;
        }
    }
}
