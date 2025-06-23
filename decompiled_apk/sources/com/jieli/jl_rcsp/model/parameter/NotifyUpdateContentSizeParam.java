package com.jieli.jl_rcsp.model.parameter;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class NotifyUpdateContentSizeParam extends BaseParameter {
    private int contentSize;
    private int currentProgress = 0;

    public NotifyUpdateContentSizeParam(int i) {
        this.contentSize = i;
    }

    public int getContentSize() {
        return this.contentSize;
    }

    public int getCurrentProgress() {
        return this.currentProgress;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
    public byte[] getParamData() {
        if (this.currentProgress <= 0) {
            return CHexConver.intToBigBytes(this.contentSize);
        }
        byte[] bArr = new byte[8];
        byte[] intToBigBytes = CHexConver.intToBigBytes(this.contentSize);
        byte[] intToBigBytes2 = CHexConver.intToBigBytes(this.currentProgress);
        System.arraycopy(intToBigBytes, 0, bArr, 0, intToBigBytes.length);
        System.arraycopy(intToBigBytes2, 0, bArr, intToBigBytes.length, intToBigBytes2.length);
        return bArr;
    }

    public NotifyUpdateContentSizeParam setContentSize(int i) {
        this.contentSize = i;
        return this;
    }

    public NotifyUpdateContentSizeParam setCurrentProgress(int i) {
        this.currentProgress = i;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter
    public String toString() {
        return "NotifyUpdateContentSizeParam{contentSize=" + this.contentSize + ", currentProgress=" + this.currentProgress + "} " + super.toString();
    }
}
