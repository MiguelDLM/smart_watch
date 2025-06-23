package com.kwad.sdk.crash.offline.monitor.mem.message;

import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class OfflineMemExceptionMessage extends ExceptionMessage {
    private static final String MSG_QUEUE_DETAIL = "mMessageQueueDetail";
    private static final String REASON = "mReason";
    private static final String TAG = "OfflineMemExceptionMessage";
    private static final String THREAD_DETAIL = "mThreadDetail";
    private static final String THREAD_STATUS = "mThreadStatus";
    private static final long serialVersionUID = 2116476830162477948L;
    public String mReason = "";
    public String mMessageQueueDetail = "";
    public String mThreadDetail = "";
    public String mThreadStatus = "";

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage
    public String getTypePrefix() {
        return "offline_mem_";
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.mReason = jSONObject.optString(REASON);
        this.mMessageQueueDetail = jSONObject.optString(MSG_QUEUE_DETAIL);
        this.mThreadDetail = jSONObject.optString(THREAD_DETAIL);
        this.mThreadStatus = jSONObject.optString(THREAD_STATUS);
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        t.putValue(json, REASON, this.mReason);
        t.putValue(json, MSG_QUEUE_DETAIL, this.mMessageQueueDetail);
        t.putValue(json, THREAD_DETAIL, this.mThreadDetail);
        t.putValue(json, THREAD_STATUS, this.mThreadStatus);
        return json;
    }
}
