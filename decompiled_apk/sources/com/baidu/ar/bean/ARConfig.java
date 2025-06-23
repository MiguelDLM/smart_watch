package com.baidu.ar.bean;

import android.text.TextUtils;
import com.baidu.ar.ARType;
import com.baidu.ar.constants.ARConfigKey;
import com.baidu.ar.kp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class ARConfig {
    private static final String AR_SDK_SALT_FIGURE = "777078ec21930de508131ba36035de6b";
    public static final int LAUNCH_AR_TAB = 2;
    public static final int LAUNCH_AR_TAB_CASE = 3;
    public static final int LAUNCH_MODE_H5 = 1;
    public static final int LAUNCH_MODE_TAKE_PICTURE = 0;
    public static int TYPE_VPS = 11;
    public static boolean isQAMockOpen = false;
    private static String mARExtraInfo = "";
    private static String mARId = null;
    private static int mARInitialType = -1;
    private static String mARKey = null;
    private static int mARLaunchMode = 0;
    private static String mARPath = null;
    private static int mARType = -1;
    private static String mArFrom = null;
    private static String mArValue = null;
    private static boolean mIsNeedLastPreview = false;
    private static String mNavigation3DofARKey = "10327252";
    private static String mNavigation6DofARKey = "10327251";
    private static String sCUID = "";
    public static String sFeaPointsDir;

    public static String getARExtraInfo() {
        return mARExtraInfo;
    }

    public static String getARId() {
        return mARId;
    }

    public static int getARInitialType() {
        return mARInitialType;
    }

    public static String getARKey() {
        return mARKey;
    }

    public static int getARLaunchMode() {
        return mARLaunchMode;
    }

    public static String getARPath() {
        return mARPath;
    }

    public static int getARType() {
        return mARType;
    }

    public static String getArFrom() {
        return mArFrom;
    }

    public static String getArValue() {
        return mArValue;
    }

    public static String getCUID() {
        return sCUID;
    }

    public static String getNavigation3DofARKey() {
        return mNavigation3DofARKey;
    }

    public static String getNavigation6DofARKey() {
        return mNavigation6DofARKey;
    }

    public static Object[] getSignatureAndTime() {
        return getSignatureAndTime(DuMixARConfig.getAipAppId(), DuMixARConfig.getAPIKey());
    }

    public static void initARConfig(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            mArValue = str;
            setARKey(jSONObject.has("ar_key") ? jSONObject.getString("ar_key") : jSONObject.has(ARConfigKey.OLD_AR_KEY) ? jSONObject.getString(ARConfigKey.OLD_AR_KEY) : null);
            setARPath(jSONObject.has(ARConfigKey.AR_PATH) ? jSONObject.getString(ARConfigKey.AR_PATH) : null);
            String string = jSONObject.has("ar_type") ? jSONObject.getString("ar_type") : jSONObject.has("arType") ? jSONObject.getString("arType") : null;
            if (TextUtils.isEmpty(string)) {
                setARType(ARType.TRACK_2D.getTypeValue());
            } else {
                setARType(Integer.parseInt(string));
                setARInitialType(Integer.parseInt(string));
            }
            String string2 = jSONObject.has(ARConfigKey.AR_LAUNCH_MODE) ? jSONObject.getString(ARConfigKey.AR_LAUNCH_MODE) : null;
            if (TextUtils.isEmpty(string2)) {
                setARLaunchMode(0);
            } else {
                setARLaunchMode(Integer.parseInt(string2));
            }
            String string3 = jSONObject.has(ARConfigKey.AR_ID) ? jSONObject.getString(ARConfigKey.AR_ID) : null;
            setARId(string3);
            if (TextUtils.isEmpty(getARKey()) && string3 != null) {
                try {
                    setARKey(new JSONObject(string3).optString("content_id"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (jSONObject.has(ARConfigKey.AR_FROM)) {
                setArFrom(jSONObject.getString(ARConfigKey.AR_FROM));
            }
            if (jSONObject.has(ARConfigKey.AR_NEED_LAST_PREVIEW)) {
                setIsNeedLastPreview(jSONObject.getBoolean(ARConfigKey.AR_NEED_LAST_PREVIEW));
            }
            if (jSONObject.has(ARConfigKey.EXTRA_INFO)) {
                setARExtraInfo(jSONObject.getString(ARConfigKey.EXTRA_INFO));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean isBox() {
        return "2".equals(DuMixARConfig.getAipAppId()) && !"com.baidu.ar.boxdemo".equals(DuMixARConfig.getPackageName());
    }

    public static boolean isNeedLastPreview() {
        return mIsNeedLastPreview;
    }

    public static boolean isOpen() {
        return isOpen(DuMixARConfig.getAipAppId());
    }

    public static void setARExtraInfo(String str) {
        mARExtraInfo = str;
    }

    public static void setARId(String str) {
        mARId = str;
    }

    public static void setARInitialType(int i) {
        mARInitialType = i;
    }

    public static void setARKey(String str) {
        mARKey = str;
    }

    public static void setARLaunchMode(int i) {
        mARLaunchMode = i;
    }

    public static void setARPath(String str) {
        mARPath = str;
    }

    public static void setARType(int i) {
        mARType = i;
    }

    public static void setArFrom(String str) {
        mArFrom = str;
    }

    public static void setCUID(String str) {
        sCUID = str;
    }

    public static void setIsNeedLastPreview(boolean z) {
        mIsNeedLastPreview = z;
    }

    public static Object[] getSignatureAndTime(String str, String str2) {
        Object[] objArr = new Object[2];
        long currentTimeMillis = System.currentTimeMillis();
        if (isOpen(str)) {
            objArr[0] = kp.cp(str + AR_SDK_SALT_FIGURE + currentTimeMillis);
        } else {
            objArr[0] = kp.cp(str + str2 + AR_SDK_SALT_FIGURE + currentTimeMillis);
        }
        objArr[1] = Long.valueOf(currentTimeMillis);
        return objArr;
    }

    public static boolean isOpen(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return Long.parseLong(str) > 10000;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
