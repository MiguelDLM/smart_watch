package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class JobDetail extends JsonFieldContainer {

    @OOXIXo
    private String imageSign;

    @OOXIXo
    private String[] images;
    private int jobErrCode;

    @OOXIXo
    private String jobErrMsg;

    @OOXIXo
    private String jobId;
    private int jobStatus;

    @OOXIXo
    private String msg;
    private int status;

    @OOXIXo
    private String token;

    public /* synthetic */ JobDetail(int i, String str, String str2, int i2, int i3, String str3, String str4, String str5, String[] strArr, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? "" : str, (i4 & 4) != 0 ? "" : str2, (i4 & 8) != 0 ? 0 : i2, (i4 & 16) != 0 ? 0 : i3, (i4 & 32) != 0 ? "" : str3, (i4 & 64) != 0 ? "" : str4, (i4 & 128) != 0 ? "" : str5, strArr);
    }

    public final int component1() {
        return this.status;
    }

    @OOXIXo
    public final String component2() {
        return this.msg;
    }

    @OOXIXo
    public final String component3() {
        return this.jobId;
    }

    public final int component4() {
        return this.jobStatus;
    }

    public final int component5() {
        return this.jobErrCode;
    }

    @OOXIXo
    public final String component6() {
        return this.jobErrMsg;
    }

    @OOXIXo
    public final String component7() {
        return this.token;
    }

    @OOXIXo
    public final String component8() {
        return this.imageSign;
    }

    @OOXIXo
    public final String[] component9() {
        return this.images;
    }

    @OOXIXo
    public final JobDetail copy(int i, @OOXIXo String msg, @OOXIXo String jobId, int i2, int i3, @OOXIXo String jobErrMsg, @OOXIXo String token, @OOXIXo String imageSign, @OOXIXo String[] images) {
        IIX0o.x0xO0oo(msg, "msg");
        IIX0o.x0xO0oo(jobId, "jobId");
        IIX0o.x0xO0oo(jobErrMsg, "jobErrMsg");
        IIX0o.x0xO0oo(token, "token");
        IIX0o.x0xO0oo(imageSign, "imageSign");
        IIX0o.x0xO0oo(images, "images");
        return new JobDetail(i, msg, jobId, i2, i3, jobErrMsg, token, imageSign, images);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JobDetail)) {
            return false;
        }
        JobDetail jobDetail = (JobDetail) obj;
        return this.status == jobDetail.status && IIX0o.Oxx0IOOO(this.msg, jobDetail.msg) && IIX0o.Oxx0IOOO(this.jobId, jobDetail.jobId) && this.jobStatus == jobDetail.jobStatus && this.jobErrCode == jobDetail.jobErrCode && IIX0o.Oxx0IOOO(this.jobErrMsg, jobDetail.jobErrMsg) && IIX0o.Oxx0IOOO(this.token, jobDetail.token) && IIX0o.Oxx0IOOO(this.imageSign, jobDetail.imageSign) && IIX0o.Oxx0IOOO(this.images, jobDetail.images);
    }

    @OOXIXo
    public final String getImageSign() {
        return this.imageSign;
    }

    @OOXIXo
    public final String[] getImages() {
        return this.images;
    }

    public final int getJobErrCode() {
        return this.jobErrCode;
    }

    @OOXIXo
    public final String getJobErrMsg() {
        return this.jobErrMsg;
    }

    @OOXIXo
    public final String getJobId() {
        return this.jobId;
    }

    public final int getJobStatus() {
        return this.jobStatus;
    }

    @OOXIXo
    public final String getMsg() {
        return this.msg;
    }

    public final int getStatus() {
        return this.status;
    }

    @OOXIXo
    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        return (((((((((((((((this.status * 31) + this.msg.hashCode()) * 31) + this.jobId.hashCode()) * 31) + this.jobStatus) * 31) + this.jobErrCode) * 31) + this.jobErrMsg.hashCode()) * 31) + this.token.hashCode()) * 31) + this.imageSign.hashCode()) * 31) + Arrays.hashCode(this.images);
    }

    public final void setImageSign(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.imageSign = str;
    }

    public final void setImages(@OOXIXo String[] strArr) {
        IIX0o.x0xO0oo(strArr, "<set-?>");
        this.images = strArr;
    }

    public final void setJobErrCode(int i) {
        this.jobErrCode = i;
    }

    public final void setJobErrMsg(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.jobErrMsg = str;
    }

    public final void setJobId(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.jobId = str;
    }

    public final void setJobStatus(int i) {
        this.jobStatus = i;
    }

    public final void setMsg(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.msg = str;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void setToken(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.token = str;
    }

    @OOXIXo
    public String toString() {
        return "JobDetail(status=" + this.status + ", msg=" + this.msg + ", jobId=" + this.jobId + ", jobStatus=" + this.jobStatus + ", jobErrCode=" + this.jobErrCode + ", jobErrMsg=" + this.jobErrMsg + ", token=" + this.token + ", imageSign=" + this.imageSign + ", images=" + Arrays.toString(this.images) + HexStringBuilder.COMMENT_END_CHAR;
    }

    public JobDetail(int i, @OOXIXo String msg, @OOXIXo String jobId, int i2, int i3, @OOXIXo String jobErrMsg, @OOXIXo String token, @OOXIXo String imageSign, @OOXIXo String[] images) {
        IIX0o.x0xO0oo(msg, "msg");
        IIX0o.x0xO0oo(jobId, "jobId");
        IIX0o.x0xO0oo(jobErrMsg, "jobErrMsg");
        IIX0o.x0xO0oo(token, "token");
        IIX0o.x0xO0oo(imageSign, "imageSign");
        IIX0o.x0xO0oo(images, "images");
        this.status = i;
        this.msg = msg;
        this.jobId = jobId;
        this.jobStatus = i2;
        this.jobErrCode = i3;
        this.jobErrMsg = jobErrMsg;
        this.token = token;
        this.imageSign = imageSign;
        this.images = images;
    }
}
