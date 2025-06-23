package com.jieli.jl_rcsp.model.response;

import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class ExternalFlashIOCtrlResponse extends CommonResponse {
    private short crc16;
    private byte[] data;
    private String filePath;
    private int result;
    private int size;
    private String version;

    public ExternalFlashIOCtrlResponse(int i) {
        setResult(i);
    }

    public short getCrc16() {
        return this.crc16;
    }

    public byte[] getData() {
        return this.data;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public int getResult() {
        return this.result;
    }

    public int getSize() {
        return this.size;
    }

    public String getVersion() {
        return this.version;
    }

    public ExternalFlashIOCtrlResponse setCrc16(short s) {
        this.crc16 = s;
        return this;
    }

    public ExternalFlashIOCtrlResponse setData(byte[] bArr) {
        this.data = bArr;
        return this;
    }

    public ExternalFlashIOCtrlResponse setFilePath(String str) {
        this.filePath = str;
        return this;
    }

    public ExternalFlashIOCtrlResponse setResult(int i) {
        this.result = i;
        return this;
    }

    public ExternalFlashIOCtrlResponse setSize(int i) {
        this.size = i;
        return this;
    }

    public ExternalFlashIOCtrlResponse setVersion(String str) {
        this.version = str;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.base.CommonResponse
    public String toString() {
        return "ExternalFlashIOCtrlResponse{result=" + this.result + ", size=" + this.size + ", filePath='" + this.filePath + "', version='" + this.version + "', crc16=" + CHexConver.byte2HexStr(CHexConver.shortToBigBytes(this.crc16)) + "} " + super.toString();
    }
}
