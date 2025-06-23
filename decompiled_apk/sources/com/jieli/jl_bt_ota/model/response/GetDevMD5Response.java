package com.jieli.jl_bt_ota.model.response;

import com.jieli.jl_bt_ota.model.base.CommonResponse;

/* loaded from: classes10.dex */
public class GetDevMD5Response extends CommonResponse {
    private String md5;

    public GetDevMD5Response(String str) {
        setMd5(str);
    }

    public String getMd5() {
        return this.md5;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    @Override // com.jieli.jl_bt_ota.model.base.CommonResponse
    public String toString() {
        return "GetDevMD5Response{md5='" + this.md5 + "'} " + super.toString();
    }
}
