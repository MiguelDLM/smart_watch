package com.bytedance.sdk.openadsdk.mediation.init;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class MediationConfigUserInfoForSegment implements Serializable {
    public static final String GENDER_FEMALE = "female";
    public static final String GENDER_MALE = "male";
    public static final String GENDER_UNKNOWN = "unknown";
    public final String TAG = "TTMediationSDK";

    /* renamed from: a, reason: collision with root package name */
    private String f10873a = "";
    private String b = "";
    private String c = "";
    private int d = 0;
    private String e = "";
    private String f = "";
    private Map<String, String> g;

    public static boolean checkValid(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("[A-Za-z0-9-_]{1,100}");
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b2, code lost:
    
        if (r7 == null) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r6 != r7) goto L4
            return r0
        L4:
            r1 = 0
            if (r7 == 0) goto Lbc
            java.lang.Class r2 = r6.getClass()
            java.lang.Class r3 = r7.getClass()
            if (r2 == r3) goto L13
            goto Lbc
        L13:
            com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment r7 = (com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment) r7
            int r2 = r6.getAge()
            int r3 = r7.getAge()
            if (r2 != r3) goto L67
            java.lang.String r2 = r6.getUserValueGroup()
            java.lang.String r3 = r7.getUserValueGroup()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L67
            java.lang.String r2 = r6.getUserId()
            java.lang.String r3 = r7.getUserId()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L67
            java.lang.String r2 = r6.getChannel()
            java.lang.String r3 = r7.getChannel()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L67
            java.lang.String r2 = r6.getSubChannel()
            java.lang.String r3 = r7.getSubChannel()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L67
            java.lang.String r2 = r6.getGender()
            java.lang.String r3 = r7.getGender()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L67
            r2 = 1
            goto L68
        L67:
            r2 = 0
        L68:
            java.util.Map r7 = r7.getCustomInfos()
            java.util.Map<java.lang.String, java.lang.String> r3 = r6.g
            if (r3 == 0) goto Lb0
            if (r7 == 0) goto Lb0
            int r3 = r3.size()
            int r4 = r7.size()
            if (r3 == r4) goto L7e
        L7c:
            r7 = 0
            goto Lb5
        L7e:
            java.util.Map<java.lang.String, java.lang.String> r3 = r6.g
            java.util.Set r3 = r3.keySet()
            java.util.Iterator r3 = r3.iterator()
        L88:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto Lb4
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L9b
            goto L88
        L9b:
            java.util.Map<java.lang.String, java.lang.String> r5 = r6.g
            java.lang.Object r5 = r5.get(r4)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.Object r4 = r7.get(r4)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.equals(r5, r4)
            if (r4 != 0) goto L88
            goto L7c
        Lb0:
            if (r3 != 0) goto L7c
            if (r7 != 0) goto L7c
        Lb4:
            r7 = 1
        Lb5:
            if (r2 == 0) goto Lba
            if (r7 == 0) goto Lba
            goto Lbb
        Lba:
            r0 = 0
        Lbb:
            return r0
        Lbc:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment.equals(java.lang.Object):boolean");
    }

    public int getAge() {
        return this.d;
    }

    @Nullable
    public String getChannel() {
        return this.b;
    }

    @Nullable
    public Map<String, String> getCustomInfos() {
        return this.g;
    }

    @Nullable
    public String getGender() {
        return this.e;
    }

    @Nullable
    public String getSubChannel() {
        return this.c;
    }

    @Nullable
    public String getUserId() {
        return this.f10873a;
    }

    @Nullable
    public String getUserValueGroup() {
        return this.f;
    }

    public void setAge(int i) {
        this.d = i;
    }

    public void setChannel(String str) {
        if (checkValid(str)) {
            this.b = str;
        } else {
            Log.e("TTMediationSDK", "流量分组channer字段存在不合法输入");
        }
    }

    public void setCustomInfos(Map<String, String> map) {
        this.g = new HashMap();
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null) {
                    if (!checkValid(entry.getKey())) {
                        Log.e("TTMediationSDK", "流量分组" + entry.getKey() + "字段存在不合法输入");
                    } else if (!checkValid(entry.getValue())) {
                        Log.e("TTMediationSDK", "流量分组" + entry.getKey() + "字段的值" + entry.getValue() + "存在不合法输入");
                    } else {
                        this.g.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
    }

    public void setGender(String str) {
        if (checkValid(str)) {
            this.e = str;
        } else {
            Log.e("TTMediationSDK", "流量分组gender字段存在不合法输入");
        }
    }

    public void setSubChannel(String str) {
        if (checkValid(str)) {
            this.c = str;
        } else {
            Log.e("TTMediationSDK", "流量分组sub_channer字段存在不合法输入");
        }
    }

    public void setUserId(String str) {
        if (checkValid(str)) {
            this.f10873a = str;
        } else {
            Log.e("TTMediationSDK", "流量分组user_id字段存在不合法输入");
        }
    }

    public void setUserValueGroup(String str) {
        if (checkValid(str)) {
            this.f = str;
        } else {
            Log.e("TTMediationSDK", "流量分组user_value_group字段存在不合法输入");
        }
    }
}
