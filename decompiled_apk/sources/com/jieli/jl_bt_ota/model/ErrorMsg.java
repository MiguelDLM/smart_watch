package com.jieli.jl_bt_ota.model;

import android.text.TextUtils;
import org.apache.commons.text.ooOOo0oXI;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class ErrorMsg {
    private static final String KEY_CODE = "code";
    private static final String KEY_DESC = "desc";
    private static final String KEY_MESSAGE = "message";
    private static final String KEY_SUB_CODE = "sub_code";
    private final int code;
    private final String codeDesc;
    private final int subCode;
    private String subMessage;

    public ErrorMsg(int i, String str, int i2, String str2) {
        this.code = i;
        this.codeDesc = str;
        this.subCode = i2;
        this.subMessage = str2;
    }

    public static ErrorMsg parseJson(String str) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("code") && jSONObject.has(KEY_SUB_CODE)) {
                if (jSONObject.has("desc")) {
                    str2 = jSONObject.getString("desc");
                } else {
                    str2 = null;
                }
                if (jSONObject.has("message")) {
                    str3 = jSONObject.getString("message");
                } else {
                    str3 = null;
                }
                return new ErrorMsg(jSONObject.getInt("code"), str2, jSONObject.getInt(KEY_SUB_CODE), str3);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String toJsonString() {
        StringBuilder sb = new StringBuilder("{");
        sb.append("\"");
        sb.append("code");
        sb.append("\":");
        sb.append(this.code);
        if (!TextUtils.isEmpty(this.codeDesc)) {
            sb.append(", \"");
            sb.append("desc");
            sb.append("\":\"");
            sb.append(this.codeDesc);
            sb.append("\"");
        }
        sb.append(", \"");
        sb.append(KEY_SUB_CODE);
        sb.append("\":");
        sb.append(this.subCode);
        if (!TextUtils.isEmpty(this.subMessage)) {
            sb.append(", \"");
            sb.append("message");
            sb.append("\":\"");
            sb.append(this.subMessage);
            sb.append("\"");
        }
        sb.append(ooOOo0oXI.f33074oOoXoXO);
        return sb.toString();
    }

    public Integer getCode() {
        return Integer.valueOf(this.code);
    }

    public String getCodeDesc() {
        return this.codeDesc;
    }

    public int getSubCode() {
        return this.subCode;
    }

    public String getSubMessage() {
        return this.subMessage;
    }

    public void setSubMessage(String str) {
        this.subMessage = str;
    }

    public String toString() {
        return toJsonString();
    }
}
