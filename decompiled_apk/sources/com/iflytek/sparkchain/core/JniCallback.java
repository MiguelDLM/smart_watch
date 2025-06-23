package com.iflytek.sparkchain.core;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.firebase.crashlytics.buildtools.ndk.NativeSymbolGenerator;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.iflytek.sparkchain.utils.ByteUtil;
import com.iflytek.sparkchain.utils.DeviceIdUtil;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class JniCallback extends DeviceIdUtil {
    private static final String license_dir = "dir_empty";
    private static final String license_extension = "extension";
    private static final String license_sp_key = "protocol_sp";
    private static final String license_version = "d";

    /* loaded from: classes10.dex */
    public class JniAuthTimer {
        public int code;
        public long expireTime;
        public long leftTime;

        public JniAuthTimer() {
        }
    }

    /* loaded from: classes10.dex */
    public class JniOutput {
        public int code;
        public byte[] data;

        public JniOutput() {
        }

        public List<AiResponse> formatData() {
            return JniCallback.collectData(this.data, false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void authFormatFilt(java.lang.String r11) {
        /*
            java.lang.String r0 = "device"
            java.lang.String r1 = "license"
            android.content.Context r2 = com.iflytek.sparkchain.utils.DeviceIdUtil.getContext()
            if (r2 != 0) goto Lb
            return
        Lb:
            android.content.Context r2 = com.iflytek.sparkchain.utils.DeviceIdUtil.getContext()
            r3 = 0
            android.content.SharedPreferences r11 = r2.getSharedPreferences(r11, r3)
            java.lang.String r2 = "extension"
            java.lang.String r3 = ""
            java.lang.String r4 = r11.getString(r2, r3)
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L23
            return
        L23:
            java.lang.String r4 = "level"
            java.lang.String r5 = r11.getString(r4, r3)
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L55
            java.lang.String r5 = r11.getString(r4, r3)
            org.json.JSONObject r6 = new org.json.JSONObject
            r6.<init>()
            r6.put(r4, r5)     // Catch: org.json.JSONException -> L3c
            goto L40
        L3c:
            r5 = move-exception
            r5.printStackTrace()
        L40:
            java.lang.String r5 = r6.toString()
            java.lang.String r5 = encodeAuthInfo(r5)
            android.content.SharedPreferences$Editor r6 = r11.edit()
            r6.putString(r2, r5)
            r6.remove(r4)
            r6.apply()
        L55:
            java.lang.String r5 = "protocol_sp"
            java.lang.String r6 = r11.getString(r5, r3)
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto Lcd
            java.lang.String r6 = r11.getString(r5, r3)
            java.lang.String r6 = decodeAuthInfoMd5(r6)
            boolean r7 = r6.isEmpty()
            if (r7 == 0) goto L70
            return
        L70:
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch: org.json.JSONException -> L9f
            r7.<init>(r6)     // Catch: org.json.JSONException -> L9f
            java.lang.String r6 = r7.getString(r1)     // Catch: org.json.JSONException -> L9f
            java.lang.String r8 = r7.getString(r0)     // Catch: org.json.JSONException -> L9d
            java.lang.String r9 = r7.getString(r4)     // Catch: org.json.JSONException -> La1
            boolean r10 = r9.isEmpty()     // Catch: org.json.JSONException -> La1
            if (r10 != 0) goto La8
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch: org.json.JSONException -> La1
            r10.<init>()     // Catch: org.json.JSONException -> La1
            r10.put(r4, r9)     // Catch: org.json.JSONException -> L90
            goto L94
        L90:
            r4 = move-exception
            r4.printStackTrace()     // Catch: org.json.JSONException -> La1
        L94:
            java.lang.String r4 = r7.toString()     // Catch: org.json.JSONException -> La1
            java.lang.String r3 = encodeAuthInfo(r4)     // Catch: org.json.JSONException -> La1
            goto La8
        L9d:
            r8 = r3
            goto La1
        L9f:
            r6 = r3
            r8 = r6
        La1:
            java.lang.String r4 = "Auth"
            java.lang.String r7 = "authFormatFilt rawStr imperfect"
            android.util.Log.w(r4, r7)
        La8:
            android.content.SharedPreferences$Editor r11 = r11.edit()
            boolean r4 = r6.isEmpty()
            if (r4 != 0) goto Lb5
            r11.putString(r1, r6)
        Lb5:
            boolean r1 = r8.isEmpty()
            if (r1 != 0) goto Lbe
            r11.putString(r0, r8)
        Lbe:
            boolean r0 = r3.isEmpty()
            if (r0 != 0) goto Lc7
            r11.putString(r2, r3)
        Lc7:
            r11.remove(r5)
            r11.apply()
        Lcd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.sparkchain.core.JniCallback.authFormatFilt(java.lang.String):void");
    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    public static boolean chatOnError(int i, String str, int i2, int i3, String str2) {
        ChatListener chatListener = AiHelper.getInst().getChatListener();
        if (chatListener == null) {
            return false;
        }
        chatListener.onChatError(new AIChatHandle(AiHelper.getInst().getUsrContext(i), str, i2), i3, str2);
        return true;
    }

    public static boolean chatOnOutput(int i, String str, int i2, String str2, String str3, String str4, int i3) {
        ChatListener chatListener = AiHelper.getInst().getChatListener();
        if (chatListener == null) {
            return false;
        }
        chatListener.onChatOutput(new AIChatHandle(AiHelper.getInst().getUsrContext(i), str, i2), str2, str3, str4, i3);
        return true;
    }

    public static boolean chatTokenCount(int i, String str, int i2, int i3, int i4, int i5) {
        ChatListener chatListener = AiHelper.getInst().getChatListener();
        if (chatListener == null) {
            return false;
        }
        AIChatHandle aIChatHandle = new AIChatHandle(AiHelper.getInst().getUsrContext(i), str, i2);
        aIChatHandle.setUsrContextIndex(i);
        chatListener.onChatToken(aIChatHandle, i3, i4, i5);
        return true;
    }

    @RequiresApi(api = 24)
    public static void clearKey(String str, String str2) {
        if (!str2.equals(license_dir)) {
            doReflex(str2);
        }
        if (DeviceIdUtil.getContext() == null) {
            return;
        }
        SharedPreferences.Editor edit = DeviceIdUtil.getContext().getSharedPreferences(str.replace(IOUtils.DIR_SEPARATOR_UNIX, '.'), 0).edit();
        edit.clear();
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<AiResponse> collectData(byte[] bArr, boolean z) {
        ArrayList arrayList = new ArrayList();
        int length = bArr.length;
        int i = 0;
        while (true) {
            AiResponse aiResponse = new AiResponse();
            int i2 = i + 4;
            if (i2 <= length) {
                aiResponse.setType(ByteUtil.byteArrayToInt(bArr, i));
                if (!z) {
                    int i3 = i + 8;
                    if (i3 > length) {
                        break;
                    }
                    aiResponse.setStatus(ByteUtil.byteArrayToInt(bArr, i2));
                    i2 = i3;
                }
                int i4 = i2 + 4;
                if (i4 > length) {
                    break;
                }
                int byteArrayToInt = ByteUtil.byteArrayToInt(bArr, i2);
                if (byteArrayToInt > 0) {
                    i2 = i4 + byteArrayToInt;
                    if (i2 > length) {
                        break;
                    }
                    aiResponse.setKey(bArr, i4, byteArrayToInt);
                }
                int i5 = i2 + 4;
                if (i5 > length) {
                    break;
                }
                int byteArrayToInt2 = ByteUtil.byteArrayToInt(bArr, i2);
                if (byteArrayToInt2 > 0) {
                    i2 = i5 + byteArrayToInt2;
                    if (i2 > length) {
                        break;
                    }
                    aiResponse.setValue(bArr, i5, byteArrayToInt2);
                    aiResponse.setLen(byteArrayToInt2);
                }
                i = i2;
                arrayList.add(aiResponse);
            } else {
                break;
            }
        }
        return arrayList;
    }

    private static List<AiResponse> collectDataEvent(byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        int length = bArr.length;
        int i = 0;
        while (true) {
            AiResponse aiResponse = new AiResponse();
            int i2 = i + 4;
            if (i2 <= length) {
                aiResponse.setType(ByteUtil.byteArrayToInt(bArr, i));
                int i3 = i + 8;
                if (i3 > length) {
                    break;
                }
                int byteArrayToInt = ByteUtil.byteArrayToInt(bArr, i2);
                if (byteArrayToInt > 0) {
                    i2 = i3 + byteArrayToInt;
                    if (i2 > length) {
                        break;
                    }
                    aiResponse.setKey(bArr, i3, byteArrayToInt);
                }
                int i4 = i2 + 4;
                if (i4 > length) {
                    break;
                }
                int byteArrayToInt2 = ByteUtil.byteArrayToInt(bArr, i2);
                if (byteArrayToInt2 > 0) {
                    i2 = i4 + byteArrayToInt2;
                    if (i2 > length) {
                        break;
                    }
                    aiResponse.setValue(bArr, i4, byteArrayToInt2);
                    aiResponse.setLen(byteArrayToInt2);
                }
                i = i2;
                arrayList.add(aiResponse);
            } else {
                break;
            }
        }
        return arrayList;
    }

    public static String decodeAuthInfo(String str) {
        if (str.isEmpty()) {
            return "";
        }
        String hexStringToString = hexStringToString(str);
        return !hexStringToString.substring(0, 1).equals("d") ? "" : hexStringToString.substring(1);
    }

    public static String decodeAuthInfoMd5(String str) {
        if (str.isEmpty()) {
            return "";
        }
        String hexStringToString = hexStringToString(str);
        return (hexStringToString.substring(0, 1).equals("d") && getEnMD5String(hexStringToString.substring(33)).equals(hexStringToString.substring(1, 33))) ? hexStringToString.substring(33) : "";
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0026 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String delExtValueFromStr(java.lang.String r2, java.lang.String r3) {
        /*
            boolean r0 = r2.isEmpty()
            java.lang.String r1 = ""
            if (r0 == 0) goto L9
            return r1
        L9:
            java.lang.String r2 = decodeAuthInfo(r2)
            boolean r0 = r2.isEmpty()
            if (r0 == 0) goto L14
            return r1
        L14:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> L1f
            r0.<init>(r2)     // Catch: org.json.JSONException -> L1f
            r0.remove(r3)     // Catch: org.json.JSONException -> L1d
            goto L24
        L1d:
            r2 = move-exception
            goto L21
        L1f:
            r2 = move-exception
            r0 = 0
        L21:
            r2.printStackTrace()
        L24:
            if (r0 != 0) goto L27
            return r1
        L27:
            java.lang.String r2 = r0.toString()
            java.lang.String r2 = encodeAuthInfo(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.sparkchain.core.JniCallback.delExtValueFromStr(java.lang.String, java.lang.String):java.lang.String");
    }

    public static void delKey(String str, String str2, String str3) {
        SharedPreferences.Editor edit;
        if (!str2.equals(license_dir)) {
            doReflex(str2);
        }
        if (DeviceIdUtil.getContext() == null) {
            return;
        }
        SharedPreferences sharedPreferences = DeviceIdUtil.getContext().getSharedPreferences(str.replace(IOUtils.DIR_SEPARATOR_UNIX, '.'), 0);
        if (isExtensionKey(str3)) {
            String delExtValueFromStr = delExtValueFromStr(sharedPreferences.getString("extension", ""), str3);
            if (delExtValueFromStr.isEmpty()) {
                return;
            }
            edit = sharedPreferences.edit();
            edit.putString("extension", delExtValueFromStr);
        } else {
            edit = sharedPreferences.edit();
            edit.remove(str3);
        }
        edit.apply();
    }

    private static void doReflex(String str) {
        try {
            Field declaredField = ContextWrapper.class.getDeclaredField("mBase");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(DeviceIdUtil.getContext().getApplicationContext());
            Field declaredField2 = obj.getClass().getDeclaredField("mPreferencesDir");
            declaredField2.setAccessible(true);
            declaredField2.set(obj, new File(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encodeAuthInfo(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("d");
        stringBuffer.append(str);
        return stringToHexString(stringBuffer.toString());
    }

    public static String encodeAuthInfoMd5(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("d");
        stringBuffer.append(getEnMD5String(str));
        stringBuffer.append(str);
        return stringToHexString(stringBuffer.toString());
    }

    private static String findNativeLibraryPath(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return ((PathClassLoader) context.getClassLoader()).findLibrary(str);
    }

    public static String getEnMD5String(String str) {
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("md5");
            messageDigest.reset();
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String getExtValueFromStr(String str, String str2) {
        String decodeAuthInfo = decodeAuthInfo(str);
        if (decodeAuthInfo.isEmpty()) {
            return "";
        }
        try {
            return new JSONObject(decodeAuthInfo).getString(str2);
        } catch (JSONException unused) {
            return "";
        }
    }

    public static String getKey(String str, String str2, String str3) {
        if (!str2.equals(license_dir)) {
            doReflex(str2);
        }
        if (DeviceIdUtil.getContext() == null) {
            return "";
        }
        String replace = str.replace(IOUtils.DIR_SEPARATOR_UNIX, '.');
        authFormatFilt(replace);
        SharedPreferences sharedPreferences = DeviceIdUtil.getContext().getSharedPreferences(replace, 0);
        return isExtensionKey(str3) ? getExtValueFromStr(sharedPreferences.getString("extension", ""), str3) : sharedPreferences.getString(str3, "");
    }

    public static String gp(String str) {
        if (str.startsWith(NativeSymbolGenerator.LIB_PREFIX)) {
            str = str.substring(3);
        }
        if (str.endsWith(".so")) {
            str = str.substring(0, str.length() - 3);
        }
        return findNativeLibraryPath(Auth.d().a().getApplicationContext(), str);
    }

    private static byte[] hexStrToBytes(String str) {
        if (TextUtils.isEmpty(str) || str.length() == 0) {
            return null;
        }
        if (str.length() % 2 == 1) {
            str = "0" + str;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        char[] charArray = str.toCharArray();
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            bArr[i] = (byte) ((charToByte(charArray[i]) << 4) | charToByte(charArray[i2]));
            i = i2;
        }
        return bArr;
    }

    public static byte[] hexStringToByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    public static String hexStringToString(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String replace = str.replace(" ", "");
        int length = replace.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            try {
                bArr[i] = (byte) (Integer.parseInt(replace.substring(i2, i2 + 2), 16) & 255);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            return new String(bArr, "gbk");
        } catch (Exception e2) {
            e2.printStackTrace();
            return replace;
        }
    }

    public static boolean isExtensionKey(String str) {
        return (str.isEmpty() || str.equals(DeviceRequestsHelper.DEVICE_INFO_DEVICE) || str.equals("license")) ? false : true;
    }

    public static void onError(String str, int i, int i2, int i3, String str2) {
        AiResponseListener listener = AiHelper.getInst().getListener();
        if (listener != null) {
            listener.onError(str, i, i3, str2, AiHelper.getInst().getUsrContext(i2));
        }
    }

    public static boolean onEvent(String str, int i, int i2, int i3, byte[] bArr) {
        AiResponseListener listener = AiHelper.getInst().getListener();
        if (listener == null) {
            return false;
        }
        listener.onEvent(str, i, i3, collectData(bArr, true), AiHelper.getInst().getUsrContext(i2));
        return true;
    }

    public static boolean onResult(String str, int i, int i2, byte[] bArr) {
        AiResponseListener listener = AiHelper.getInst().getListener();
        if (listener == null) {
            Log.w("AEELog", "onResult：listener == null");
            return false;
        }
        List<AiResponse> collectData = collectData(bArr, false);
        if (collectData.isEmpty()) {
            Log.e("AEELog", "outputs null in jni!");
            return true;
        }
        listener.onResult(str, i, collectData, AiHelper.getInst().getUsrContext(i2));
        return true;
    }

    public static void sdkStateChange(int i, int i2) {
        Auth.d().a(i, i2);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(2:3|(7:5|6|(1:8)|9|10|11|12))|20|(0)|9|10|11|12) */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0026, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0027, code lost:
    
        r1.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String setExtValueToStr(java.lang.String r1, java.lang.String r2, java.lang.String r3) {
        /*
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto L1a
            java.lang.String r1 = decodeAuthInfo(r1)
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto L1a
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> L16
            r0.<init>(r1)     // Catch: org.json.JSONException -> L16
            goto L1b
        L16:
            r1 = move-exception
            r1.printStackTrace()
        L1a:
            r0 = 0
        L1b:
            if (r0 != 0) goto L22
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
        L22:
            r0.put(r2, r3)     // Catch: org.json.JSONException -> L26
            goto L2a
        L26:
            r1 = move-exception
            r1.printStackTrace()
        L2a:
            java.lang.String r1 = r0.toString()
            java.lang.String r1 = encodeAuthInfo(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.sparkchain.core.JniCallback.setExtValueToStr(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static void setKey(String str, String str2, String str3, String str4) {
        SharedPreferences.Editor edit;
        if (!str2.equals(license_dir)) {
            doReflex(str2);
        }
        if (DeviceIdUtil.getContext() == null) {
            return;
        }
        SharedPreferences sharedPreferences = DeviceIdUtil.getContext().getSharedPreferences(str, 0);
        if (isExtensionKey(str3)) {
            String extValueToStr = setExtValueToStr(sharedPreferences.getString("extension", ""), str3, str4);
            edit = sharedPreferences.edit();
            edit.putString("extension", extValueToStr);
        } else {
            edit = sharedPreferences.edit();
            edit.putString(str3, str4);
        }
        edit.apply();
    }

    public static String stringToHexString(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            stringBuffer.append(Integer.toHexString(str.charAt(i)));
        }
        return stringBuffer.toString();
    }
}
