package com.baidu.ai.speech.realtime.full.download;

import com.sma.smartv3.network.BaiDu;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class Result {
    public static final String TYPE_FIN_TEXT = "FIN_TEXT";
    public static final String TYPE_HEARTBEAT = "HEARTBEAT";
    public static final String TYPE_MID_TEXT = "MID_TEXT";
    private long endTime;
    private String errMsg;
    private int errNo;
    private long logId;
    private String orignalJsonStr;
    private long receiveTime = System.currentTimeMillis();
    private String result;
    private String sn;
    private long startTime;
    private String type;

    public Result(String jsonStr) throws JSONException {
        this.startTime = -1L;
        this.endTime = -1L;
        this.orignalJsonStr = jsonStr;
        JSONObject jSONObject = new JSONObject(jsonStr);
        this.type = jSONObject.getString("type");
        if (isHeartBeat()) {
            return;
        }
        this.errNo = jSONObject.getInt("err_no");
        this.errMsg = jSONObject.getString("err_msg");
        this.type = jSONObject.getString("type");
        this.result = jSONObject.optString("result");
        if (jSONObject.has(BaiDu.START_TIME)) {
            this.startTime = jSONObject.getLong(BaiDu.START_TIME);
            this.endTime = jSONObject.getLong("end_time");
        }
        this.logId = jSONObject.getLong("log_id");
        this.sn = jSONObject.optString("sn");
    }

    public long getEndTime() {
        return this.endTime;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public int getErrNo() {
        return this.errNo;
    }

    public long getLogId() {
        return this.logId;
    }

    public String getOrignalJsonStr() {
        return this.orignalJsonStr;
    }

    public long getReceiveTime() {
        return this.receiveTime;
    }

    public String getResult() {
        return this.result;
    }

    public String getSn() {
        return this.sn;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public String getType() {
        return this.type;
    }

    public boolean isError() {
        if (this.errNo != 0) {
            return true;
        }
        return false;
    }

    public boolean isFin() {
        return TYPE_FIN_TEXT.equals(this.type);
    }

    public boolean isHeartBeat() {
        return TYPE_HEARTBEAT.equals(this.type);
    }
}
