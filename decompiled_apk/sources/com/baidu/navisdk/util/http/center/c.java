package com.baidu.navisdk.util.http.center;

import com.baidu.navisdk.util.common.LogUtil;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public class c {
    public static HashMap<String, String> a(List<l> list) {
        StringBuffer stringBuffer;
        if (LogUtil.LOGGABLE) {
            stringBuffer = new StringBuffer();
            stringBuffer.append("hch.formatParams() ");
        } else {
            stringBuffer = null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        if (list != null) {
            for (l lVar : list) {
                if (lVar != null) {
                    hashMap.put(lVar.a(), lVar.b());
                    if (LogUtil.LOGGABLE && stringBuffer != null) {
                        stringBuffer.append(", " + lVar.a() + "=" + lVar.b());
                    }
                }
            }
        }
        if (LogUtil.LOGGABLE && stringBuffer != null) {
            LogUtil.e("HCH", stringBuffer.toString());
        }
        return hashMap;
    }

    public static String b(List<l> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        int size = list.size();
        String[] strArr = new String[size];
        for (int i = 0; i < list.size(); i++) {
            try {
                try {
                    strArr[i] = (URLEncoder.encode(list.get(i).a(), "utf-8") + "=") + URLEncoder.encode(list.get(i).b(), "utf-8");
                } catch (Exception e) {
                    e.printStackTrace();
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("sortSequenceWithAscendingOder", "position 2,e:" + e);
                    }
                    return null;
                }
            } catch (Exception e2) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("sortSequenceWithAscendingOder", "position 1,e:" + e2);
                }
                e2.printStackTrace();
                return null;
            }
        }
        Arrays.sort(strArr);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < size; i2++) {
            stringBuffer.append(strArr[i2]);
            if (i2 != size - 1) {
                stringBuffer.append("&");
            }
        }
        return stringBuffer.toString();
    }

    public static String a(HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.size() <= 0) {
            return null;
        }
        int size = hashMap.size();
        String[] strArr = new String[size];
        int i = 0;
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            try {
                try {
                    strArr[i] = (URLEncoder.encode(entry.getKey(), "utf-8") + "=") + URLEncoder.encode(entry.getValue(), "utf-8");
                    i++;
                } catch (Exception e) {
                    e.printStackTrace();
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("sortSequenceWithAscendingOder", "position 2,e:" + e);
                    }
                    return null;
                }
            } catch (Exception e2) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("sortSequenceWithAscendingOder", "position 1,e:" + e2);
                }
                e2.printStackTrace();
                return null;
            }
        }
        Arrays.sort(strArr);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append(strArr[i2]);
            if (i2 != size - 1) {
                sb.append("&");
            }
        }
        return sb.toString();
    }

    public static String a(String str, List<l> list) {
        StringBuffer stringBuffer = new StringBuffer(str);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                stringBuffer.append(URLEncoder.encode(list.get(i).a(), "utf-8"));
                stringBuffer.append("=");
                stringBuffer.append(URLEncoder.encode(list.get(i).b(), "utf-8"));
                if (i != size - 1) {
                    stringBuffer.append("&");
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return stringBuffer.toString();
    }
}
