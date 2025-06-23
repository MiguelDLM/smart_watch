package com.jieli.jl_rcsp.model.parameter;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.util.CHexConver;
import java.nio.charset.StandardCharsets;

/* loaded from: classes10.dex */
public class StartFileTransferParam extends BaseParameter {
    private byte flag;
    private String path;
    private int size;

    public StartFileTransferParam(String str, int i) {
        if (str != null && !str.isEmpty()) {
            this.path = str;
            this.size = i;
            return;
        }
        throw new IllegalArgumentException("文件路径不能为空!!!");
    }

    public StartFileTransferParam enableDataNeedResponse(boolean z) {
        if (z) {
            this.flag = (byte) (this.flag | 1);
        } else {
            this.flag = (byte) (this.flag & 254);
        }
        return this;
    }

    public byte getFlag() {
        return this.flag;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
    public byte[] getParamData() {
        byte[] bytes = this.path.getBytes(StandardCharsets.UTF_8);
        byte[] bArr = new byte[bytes.length + 5];
        bArr[0] = this.flag;
        System.arraycopy(CHexConver.intToBigBytes(this.size), 0, bArr, 1, 4);
        System.arraycopy(bytes, 0, bArr, 5, bytes.length);
        return bArr;
    }

    public String getPath() {
        return this.path;
    }

    public int getSize() {
        return this.size;
    }

    public StartFileTransferParam setFlag(byte b) {
        this.flag = b;
        return this;
    }

    public StartFileTransferParam setPath(String str) {
        this.path = str;
        return this;
    }

    public StartFileTransferParam setSize(int i) {
        this.size = i;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter
    public String toString() {
        return "StartFileTransferParam{flag=" + ((int) this.flag) + ", path='" + this.path + "', size=" + this.size + "}\n" + super.toString();
    }
}
