package com.jieli.jl_rcsp.model.parameter;

import android.text.TextUtils;
import com.jieli.jl_rcsp.model.base.BaseParameter;

/* loaded from: classes10.dex */
public class PhoneCallRequestParam extends BaseParameter {
    public static final int TYPE_LAST_NUMBER = 0;
    public static final int TYPE_SPECIAL_NUMBER = 1;
    private String number;
    private int type;

    public PhoneCallRequestParam(String str) {
        this.number = str;
    }

    public String getNumber() {
        return this.number;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
    public byte[] getParamData() {
        if (TextUtils.isEmpty(this.number)) {
            return new byte[]{0};
        }
        byte[] bytes = this.number.getBytes();
        byte[] bArr = new byte[bytes.length + 1];
        bArr[0] = 1;
        System.arraycopy(bytes, 0, bArr, 1, bytes.length);
        return bArr;
    }

    public int getType() {
        return this.type;
    }

    public PhoneCallRequestParam setNumber(String str) {
        this.number = str;
        return this;
    }

    public PhoneCallRequestParam setType(int i) {
        this.type = i;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter
    public String toString() {
        return "PhoneCallRequestParam{type=" + this.type + ", number='" + this.number + "'}";
    }
}
