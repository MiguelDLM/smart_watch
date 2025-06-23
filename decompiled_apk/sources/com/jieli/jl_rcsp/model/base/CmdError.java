package com.jieli.jl_rcsp.model.base;

import android.text.TextUtils;
import org.apache.commons.text.ooOOo0oXI;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class CmdError {
    private static final String KEY_CMD = "cmd";
    private static final String KEY_CODE = "code";
    private static final String KEY_DESC = "desc";
    private static final String KEY_SUB_CODE = "sub_code";
    private static final String KEY_SUB_DESC = "sub_desc";
    private final int cmdId;
    private final int code;
    private String desc;
    private final int subCode;
    private String subDesc;

    public CmdError(int i, int i2) {
        this(i, i2, 0);
    }

    public static CmdError parseCmdError(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(KEY_CMD) || !jSONObject.has("code") || !jSONObject.has(KEY_SUB_CODE)) {
                return null;
            }
            CmdError cmdError = new CmdError(jSONObject.getInt(KEY_CMD), jSONObject.getInt("code"), jSONObject.getInt(KEY_SUB_CODE));
            if (jSONObject.has("desc")) {
                cmdError.setDesc(jSONObject.getString("desc"));
            }
            if (jSONObject.has(KEY_SUB_DESC)) {
                cmdError.setSubDesc(jSONObject.getString(KEY_SUB_DESC));
            }
            return cmdError;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public int getCmdId() {
        return this.cmdId;
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getSubCode() {
        return this.subCode;
    }

    public String getSubDesc() {
        return this.subDesc;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setSubDesc(String str) {
        this.subDesc = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        sb.append("\"");
        sb.append(KEY_CMD);
        sb.append("\":");
        sb.append(this.cmdId);
        sb.append(", \"");
        sb.append("code");
        sb.append("\":");
        sb.append(this.code);
        if (!TextUtils.isEmpty(this.desc)) {
            sb.append(", \"");
            sb.append("desc");
            sb.append("\":\"");
            sb.append(this.desc);
            sb.append("\"");
        }
        sb.append(", \"");
        sb.append(KEY_SUB_CODE);
        sb.append("\":");
        sb.append(this.subCode);
        if (!TextUtils.isEmpty(this.subDesc)) {
            sb.append(", \"");
            sb.append(KEY_SUB_DESC);
            sb.append("\":\"");
            sb.append(this.subDesc);
            sb.append("\"");
        }
        sb.append(ooOOo0oXI.f33074oOoXoXO);
        return sb.toString();
    }

    public CmdError(int i, int i2, int i3) {
        this.cmdId = i;
        this.code = i2;
        this.subCode = i3;
    }
}
