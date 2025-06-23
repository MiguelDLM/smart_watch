package com.jieli.jl_rcsp.model.command.watch;

import com.jieli.jl_rcsp.exception.ParseDataException;
import com.jieli.jl_rcsp.interfaces.cmd.IDataOp;
import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.util.CHexConver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes10.dex */
public class RequestHealthDataCmd extends CommandBase<Param, Response> {
    public RequestHealthDataCmd(Param param) {
        this(2, param);
    }

    public RequestHealthDataCmd(int i, Param param) {
        super(160, RequestHealthDataCmd.class.getSimpleName(), i);
        setParam(param);
    }

    /* loaded from: classes10.dex */
    public static class Param extends BaseParameter implements IDataOp {
        public int mask;
        public byte[] subMask;
        public byte version;

        public Param(byte[] bArr) throws ParseDataException {
            int parse = parse(bArr);
            if (parse >= 0) {
                return;
            }
            throw new ParseDataException(1, "Failure to parse data. size = " + parse, bArr);
        }

        private void checkMaskAndSubMaskRelation(int i, byte[] bArr) {
            int i2 = 0;
            for (int i3 = 0; i3 < 32; i3++) {
                if (CHexConver.getBitByPosition(i, i3) == 1) {
                    i2++;
                }
            }
            if (i2 != 0) {
                if (bArr.length == i2) {
                    return;
                } else {
                    throw new IllegalArgumentException("mask set count not equal to subMask length");
                }
            }
            throw new IllegalArgumentException("mask must not be 0x00");
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            return toData();
        }

        @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public int parse(byte[] bArr) {
            this.subMask = new byte[0];
            if (bArr == null || bArr.length == 0) {
                return 0;
            }
            if (bArr.length < 5) {
                return -1;
            }
            this.mask = CHexConver.bytesToInt(bArr, 0, 4);
            this.version = bArr[4];
            if (5 >= bArr.length) {
                return 5;
            }
            int length = bArr.length - 5;
            byte[] bArr2 = new byte[length];
            this.subMask = bArr2;
            System.arraycopy(bArr, 5, bArr2, 0, length);
            return 5 + this.subMask.length;
        }

        @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public byte[] toData() {
            byte[] bArr = new byte[this.subMask.length + 5];
            byte[] intToBigBytes = CHexConver.intToBigBytes(this.mask);
            System.arraycopy(intToBigBytes, 0, bArr, 0, intToBigBytes.length);
            bArr[4] = this.version;
            byte[] bArr2 = this.subMask;
            System.arraycopy(bArr2, 0, bArr, 5, bArr2.length);
            return bArr;
        }

        public Param(int i, byte b, byte... bArr) {
            checkMaskAndSubMaskRelation(i, bArr);
            this.mask = i;
            this.version = b;
            this.subMask = bArr;
        }
    }

    /* loaded from: classes10.dex */
    public static class Response extends CommonResponse implements IDataOp {
        public byte[] data;
        public byte flag;
        public byte ret;

        public Response(byte[] bArr) throws ParseDataException {
            int parse = parse(bArr);
            if (parse >= 0) {
                setRawData(bArr);
                return;
            }
            throw new ParseDataException(1, "Failed to parse data. size = " + parse, this.data);
        }

        public byte[] getData() {
            return this.data;
        }

        public byte getFlag() {
            return this.flag;
        }

        public byte getRet() {
            return this.ret;
        }

        @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public int parse(byte[] bArr) {
            this.data = new byte[0];
            if (bArr == null || bArr.length == 0) {
                return 0;
            }
            if (bArr.length < 2) {
                return -1;
            }
            this.ret = bArr[0];
            this.flag = bArr[1];
            if (2 >= bArr.length) {
                return 2;
            }
            int length = bArr.length - 2;
            byte[] bArr2 = new byte[length];
            this.data = bArr2;
            System.arraycopy(bArr, 2, bArr2, 0, length);
            return 2 + this.data.length;
        }

        @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public byte[] toData() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(this.ret);
            byteArrayOutputStream.write(this.flag);
            byte[] bArr = this.data;
            if (bArr != null && bArr.length > 0) {
                try {
                    byteArrayOutputStream.write(bArr);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return byteArrayOutputStream.toByteArray();
        }

        public Response(byte b, byte b2, byte[] bArr) {
            this.ret = b;
            this.flag = b2;
            this.data = bArr;
        }
    }
}
