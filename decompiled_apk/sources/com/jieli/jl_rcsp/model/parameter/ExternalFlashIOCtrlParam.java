package com.jieli.jl_rcsp.model.parameter;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class ExternalFlashIOCtrlParam extends BaseParameter {
    private short crc16;
    private byte[] data;
    private String filePath;
    private int flag;
    private int offset;
    private int op;
    private int size;
    private boolean isFinalData = true;
    private boolean isOpEnd = false;
    private int watchOp = 0;

    private int getParamSize() {
        int length;
        int length2;
        String str;
        String str2;
        int i = this.op;
        if (i == 8) {
            return 4;
        }
        if (i != 11) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i == 5 && !this.isOpEnd && (str2 = this.filePath) != null) {
                                    length = str2.getBytes().length;
                                    return length + 2;
                                }
                            }
                        } else {
                            int i2 = this.watchOp;
                            if ((i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5) && (str = this.filePath) != null) {
                                return 2 + str.getBytes().length;
                            }
                        }
                    } else if (!this.isOpEnd) {
                        String str3 = this.filePath;
                        if (str3 != null) {
                            length2 = str3.getBytes().length;
                            return length2 + 6;
                        }
                        return 6;
                    }
                    return 2;
                }
                return 8;
            }
            byte[] bArr = this.data;
            if (bArr != null) {
                length2 = bArr.length;
                return length2 + 6;
            }
            return 6;
        }
        String str4 = this.filePath;
        if (str4 != null) {
            length = str4.getBytes().length;
            return length + 2;
        }
        return 2;
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

    public int getFlag() {
        return this.flag;
    }

    public int getOffset() {
        return this.offset;
    }

    public int getOp() {
        return this.op;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
    public byte[] getParamData() {
        String str;
        String str2;
        byte[] bArr = new byte[getParamSize()];
        bArr[0] = CHexConver.intToByte(this.op);
        bArr[1] = CHexConver.intToByte(this.flag);
        int i = this.op;
        if (i != 8) {
            if (i != 11) {
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (i != 4) {
                                    if (i == 5 && !this.isOpEnd && (str2 = this.filePath) != null && str2.getBytes().length > 0) {
                                        System.arraycopy(this.filePath.getBytes(), 0, bArr, 2, this.filePath.getBytes().length);
                                    }
                                }
                            } else {
                                int i2 = this.watchOp;
                                if ((i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5) && (str = this.filePath) != null && str.getBytes().length > 0) {
                                    System.arraycopy(this.filePath.getBytes(), 0, bArr, 2, this.filePath.getBytes().length);
                                }
                            }
                        } else if (!this.isOpEnd) {
                            System.arraycopy(CHexConver.intToBigBytes(this.size), 0, bArr, 2, 4);
                            String str3 = this.filePath;
                            if (str3 != null && str3.getBytes().length > 0) {
                                System.arraycopy(this.filePath.getBytes(), 0, bArr, 6, this.filePath.getBytes().length);
                            }
                        }
                    }
                    System.arraycopy(CHexConver.intToBigBytes(this.offset), 0, bArr, 2, 4);
                    System.arraycopy(CHexConver.int2byte2(this.size), 0, bArr, 6, 2);
                } else {
                    System.arraycopy(CHexConver.intToBigBytes(this.offset), 0, bArr, 2, 4);
                    byte[] bArr2 = this.data;
                    if (bArr2 != null && bArr2.length > 0) {
                        System.arraycopy(bArr2, 0, bArr, 6, bArr2.length);
                    }
                }
            } else {
                String str4 = this.filePath;
                if (str4 != null && str4.getBytes().length > 0) {
                    System.arraycopy(this.filePath.getBytes(), 0, bArr, 2, this.filePath.getBytes().length);
                }
            }
        } else {
            System.arraycopy(CHexConver.shortToBigBytes(this.crc16), 0, bArr, 2, 2);
        }
        return bArr;
    }

    public int getSize() {
        return this.size;
    }

    public int getWatchOp() {
        return this.watchOp;
    }

    public boolean isFinalData() {
        return this.isFinalData;
    }

    public boolean isOpEnd() {
        return this.isOpEnd;
    }

    public ExternalFlashIOCtrlParam setCrc16(short s) {
        this.crc16 = s;
        return this;
    }

    public ExternalFlashIOCtrlParam setData(byte[] bArr) {
        this.data = bArr;
        return this;
    }

    public ExternalFlashIOCtrlParam setFilePath(String str) {
        this.filePath = str;
        return this;
    }

    public ExternalFlashIOCtrlParam setFinalData(boolean z) {
        this.isFinalData = z;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0021, code lost:
    
        if (r2 != 9) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.jieli.jl_rcsp.model.parameter.ExternalFlashIOCtrlParam setFlag(int r4) {
        /*
            r3 = this;
            r3.flag = r4
            r0 = r4 & 1
            r1 = 1
            if (r0 != 0) goto L9
            r0 = 1
            goto La
        L9:
            r0 = 0
        La:
            int r2 = r3.op
            if (r2 == 0) goto L2c
            if (r2 == r1) goto L2c
            r1 = 2
            if (r2 == r1) goto L28
            r1 = 3
            if (r2 == r1) goto L24
            r4 = 5
            if (r2 == r4) goto L28
            r4 = 6
            if (r2 == r4) goto L28
            r4 = 7
            if (r2 == r4) goto L28
            r4 = 9
            if (r2 == r4) goto L28
            goto L2f
        L24:
            r3.setWatchOp(r4)
            goto L2f
        L28:
            r3.setOpEnd(r0)
            goto L2f
        L2c:
            r3.setFinalData(r0)
        L2f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jieli.jl_rcsp.model.parameter.ExternalFlashIOCtrlParam.setFlag(int):com.jieli.jl_rcsp.model.parameter.ExternalFlashIOCtrlParam");
    }

    public ExternalFlashIOCtrlParam setOffset(int i) {
        this.offset = i;
        return this;
    }

    public ExternalFlashIOCtrlParam setOp(int i) {
        this.op = i;
        return this;
    }

    public ExternalFlashIOCtrlParam setOpEnd(boolean z) {
        this.isOpEnd = z;
        return this;
    }

    public ExternalFlashIOCtrlParam setSize(int i) {
        this.size = i;
        return this;
    }

    public ExternalFlashIOCtrlParam setWatchOp(int i) {
        this.watchOp = i;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter
    public String toString() {
        return "ExternalFlashIOCtrlParam{op=" + this.op + ", flag=" + this.flag + ", offset=" + this.offset + ", size=" + this.size + ", filePath='" + this.filePath + "', isFinalData=" + this.isFinalData + ", isOpEnd=" + this.isOpEnd + ", watchOp=" + this.watchOp + ", crc16=" + CHexConver.byte2HexStr(CHexConver.shortToBigBytes(this.crc16)) + "} " + super.toString();
    }
}
