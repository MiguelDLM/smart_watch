package com.kwad.components.offline.api.tk.model.report;

import com.huawei.openalliance.ad.constant.bn;
import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class TKExceptionUploadParams extends BaseOfflineCompoJsonParse<TKExceptionUploadParams> {
    public String bizExtraInfo;
    public String bundleId;
    public String bundleSource;
    public String bundleType;
    public String bundleVersionCode;
    public String businessName;
    public long clientTimeStamp;
    public int containerType;
    public String error;
    public String errorType;
    public String key;
    public String sdkVersion;
    public String sessionId;
    public String taskId;
    public String templateId;
    public String templateVersionCode;
    public int v8SoType;

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(TKExceptionUploadParams tKExceptionUploadParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.key = jSONObject.optString("key");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(this.key)) {
            this.key = "";
        }
        this.error = jSONObject.optString("error");
        if (obj.toString().equals(this.error)) {
            this.error = "";
        }
        this.v8SoType = jSONObject.optInt("v8SoType");
        this.bundleType = jSONObject.optString("bundleType");
        if (obj.toString().equals(this.bundleType)) {
            this.bundleType = "";
        }
        this.bundleSource = jSONObject.optString("bundleSource");
        if (obj.toString().equals(this.bundleSource)) {
            this.bundleSource = "";
        }
        this.bundleId = jSONObject.optString("bundleId");
        if (obj.toString().equals(this.bundleId)) {
            this.bundleId = "";
        }
        this.bundleVersionCode = jSONObject.optString("bundleVersionCode");
        if (obj.toString().equals(this.bundleVersionCode)) {
            this.bundleVersionCode = "";
        }
        this.businessName = jSONObject.optString("businessName");
        if (obj.toString().equals(this.businessName)) {
            this.businessName = "";
        }
        this.taskId = jSONObject.optString("taskId");
        if (obj.toString().equals(this.taskId)) {
            this.taskId = "";
        }
        this.templateId = jSONObject.optString("templateId");
        if (obj.toString().equals(this.templateId)) {
            this.templateId = "";
        }
        this.templateVersionCode = jSONObject.optString("templateVersionCode");
        if (obj.toString().equals(this.templateVersionCode)) {
            this.templateVersionCode = "";
        }
        this.sdkVersion = jSONObject.optString(bn.f.Code);
        if (obj.toString().equals(this.sdkVersion)) {
            this.sdkVersion = "";
        }
        this.sessionId = jSONObject.optString("sessionId");
        if (obj.toString().equals(this.sessionId)) {
            this.sessionId = "";
        }
        this.bizExtraInfo = jSONObject.optString("biz_extra_info");
        if (obj.toString().equals(this.bizExtraInfo)) {
            this.bizExtraInfo = "";
        }
        this.errorType = jSONObject.optString("errorType");
        if (obj.toString().equals(this.errorType)) {
            this.errorType = "";
        }
        this.containerType = jSONObject.optInt("container_type");
        this.clientTimeStamp = jSONObject.optLong("clientTimeStamp");
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(TKExceptionUploadParams tKExceptionUploadParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = this.error;
        if (str != null && !str.equals("")) {
            t.putValue(jSONObject, "error", this.error);
        }
        int i = this.v8SoType;
        if (i != 0) {
            t.putValue(jSONObject, "v8SoType", i);
        }
        String str2 = this.bundleType;
        if (str2 != null && !str2.equals("")) {
            t.putValue(jSONObject, "bundleType", this.bundleType);
        }
        String str3 = this.bundleSource;
        if (str3 != null && !str3.equals("")) {
            t.putValue(jSONObject, "bundleSource", this.bundleSource);
        }
        String str4 = this.bundleId;
        if (str4 != null && !str4.equals("")) {
            t.putValue(jSONObject, "bundleId", this.bundleId);
        }
        String str5 = this.bundleVersionCode;
        if (str5 != null && !str5.equals("")) {
            t.putValue(jSONObject, "bundleVersionCode", this.bundleVersionCode);
        }
        String str6 = this.businessName;
        if (str6 != null && !str6.equals("")) {
            t.putValue(jSONObject, "businessName", this.businessName);
        }
        String str7 = this.taskId;
        if (str7 != null && !str7.equals("")) {
            t.putValue(jSONObject, "taskId", this.taskId);
        }
        String str8 = this.templateId;
        if (str8 != null && !str8.equals("")) {
            t.putValue(jSONObject, "templateId", this.templateId);
        }
        String str9 = this.templateVersionCode;
        if (str9 != null && !str9.equals("")) {
            t.putValue(jSONObject, "templateVersionCode", this.templateVersionCode);
        }
        String str10 = this.sdkVersion;
        if (str10 != null && !str10.equals("")) {
            t.putValue(jSONObject, bn.f.Code, this.sdkVersion);
        }
        String str11 = this.sessionId;
        if (str11 != null && !str11.equals("")) {
            t.putValue(jSONObject, "sessionId", this.sessionId);
        }
        String str12 = this.bizExtraInfo;
        if (str12 != null && !str12.equals("")) {
            t.putValue(jSONObject, "biz_extra_info", this.bizExtraInfo);
        }
        String str13 = this.errorType;
        if (str13 != null && !str13.equals("")) {
            t.putValue(jSONObject, "errorType", this.errorType);
        }
        int i2 = this.containerType;
        if (i2 != 0) {
            t.putValue(jSONObject, "container_type", i2);
        }
        long j = this.clientTimeStamp;
        if (j != 0) {
            t.putValue(jSONObject, "clientTimeStamp", j);
        }
        return jSONObject;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(TKExceptionUploadParams tKExceptionUploadParams) {
        return toJson(tKExceptionUploadParams, (JSONObject) null);
    }
}
