package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class JobInfo extends JsonFieldContainer {

    @OOXIXo
    private String jobId;

    @OOXIXo
    private String logId;

    @OOXIXo
    private String msg;

    @OOXIXo
    private String token;

    @OOXIXo
    private String userId;
    private int waitTime;

    public JobInfo() {
        this(0, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ JobInfo copy$default(JobInfo jobInfo, int i, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = jobInfo.waitTime;
        }
        if ((i2 & 2) != 0) {
            str = jobInfo.jobId;
        }
        String str6 = str;
        if ((i2 & 4) != 0) {
            str2 = jobInfo.msg;
        }
        String str7 = str2;
        if ((i2 & 8) != 0) {
            str3 = jobInfo.logId;
        }
        String str8 = str3;
        if ((i2 & 16) != 0) {
            str4 = jobInfo.token;
        }
        String str9 = str4;
        if ((i2 & 32) != 0) {
            str5 = jobInfo.userId;
        }
        return jobInfo.copy(i, str6, str7, str8, str9, str5);
    }

    public final int component1() {
        return this.waitTime;
    }

    @OOXIXo
    public final String component2() {
        return this.jobId;
    }

    @OOXIXo
    public final String component3() {
        return this.msg;
    }

    @OOXIXo
    public final String component4() {
        return this.logId;
    }

    @OOXIXo
    public final String component5() {
        return this.token;
    }

    @OOXIXo
    public final String component6() {
        return this.userId;
    }

    @OOXIXo
    public final JobInfo copy(int i, @OOXIXo String jobId, @OOXIXo String msg, @OOXIXo String logId, @OOXIXo String token, @OOXIXo String userId) {
        IIX0o.x0xO0oo(jobId, "jobId");
        IIX0o.x0xO0oo(msg, "msg");
        IIX0o.x0xO0oo(logId, "logId");
        IIX0o.x0xO0oo(token, "token");
        IIX0o.x0xO0oo(userId, "userId");
        return new JobInfo(i, jobId, msg, logId, token, userId);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JobInfo)) {
            return false;
        }
        JobInfo jobInfo = (JobInfo) obj;
        return this.waitTime == jobInfo.waitTime && IIX0o.Oxx0IOOO(this.jobId, jobInfo.jobId) && IIX0o.Oxx0IOOO(this.msg, jobInfo.msg) && IIX0o.Oxx0IOOO(this.logId, jobInfo.logId) && IIX0o.Oxx0IOOO(this.token, jobInfo.token) && IIX0o.Oxx0IOOO(this.userId, jobInfo.userId);
    }

    @OOXIXo
    public final String getJobId() {
        return this.jobId;
    }

    @OOXIXo
    public final String getLogId() {
        return this.logId;
    }

    @OOXIXo
    public final String getMsg() {
        return this.msg;
    }

    @OOXIXo
    public final String getToken() {
        return this.token;
    }

    @OOXIXo
    public final String getUserId() {
        return this.userId;
    }

    public final int getWaitTime() {
        return this.waitTime;
    }

    public int hashCode() {
        return (((((((((this.waitTime * 31) + this.jobId.hashCode()) * 31) + this.msg.hashCode()) * 31) + this.logId.hashCode()) * 31) + this.token.hashCode()) * 31) + this.userId.hashCode();
    }

    public final void setJobId(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.jobId = str;
    }

    public final void setLogId(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.logId = str;
    }

    public final void setMsg(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.msg = str;
    }

    public final void setToken(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.token = str;
    }

    public final void setUserId(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.userId = str;
    }

    public final void setWaitTime(int i) {
        this.waitTime = i;
    }

    @OOXIXo
    public String toString() {
        return "JobInfo(waitTime=" + this.waitTime + ", jobId=" + this.jobId + ", msg=" + this.msg + ", logId=" + this.logId + ", token=" + this.token + ", userId=" + this.userId + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ JobInfo(int i, String str, String str2, String str3, String str4, String str5, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? "" : str4, (i2 & 32) == 0 ? str5 : "");
    }

    public JobInfo(int i, @OOXIXo String jobId, @OOXIXo String msg, @OOXIXo String logId, @OOXIXo String token, @OOXIXo String userId) {
        IIX0o.x0xO0oo(jobId, "jobId");
        IIX0o.x0xO0oo(msg, "msg");
        IIX0o.x0xO0oo(logId, "logId");
        IIX0o.x0xO0oo(token, "token");
        IIX0o.x0xO0oo(userId, "userId");
        this.waitTime = i;
        this.jobId = jobId;
        this.msg = msg;
        this.logId = logId;
        this.token = token;
        this.userId = userId;
    }
}
