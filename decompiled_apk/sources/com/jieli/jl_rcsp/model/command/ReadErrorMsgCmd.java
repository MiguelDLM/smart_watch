package com.jieli.jl_rcsp.model.command;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.util.CHexConver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes10.dex */
public class ReadErrorMsgCmd extends CommandWithParamAndResponse<ReadErrorMsgParam, ReadErrorMsgResponse> {

    /* loaded from: classes10.dex */
    public static class ReadErrorMsgParam extends BaseParameter {
        public static final int READ_START = 0;
        public static final int READ_STOP = 1;
        private int op;

        public int getOp() {
            return this.op;
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            return new byte[]{CHexConver.intToByte(this.op)};
        }

        public void parseData(byte[] bArr) {
            if (bArr != null && bArr.length > 0) {
                setOp(CHexConver.byteToInt(bArr[0]));
            }
        }

        public void setOp(int i) {
            this.op = i;
        }
    }

    /* loaded from: classes10.dex */
    public static class ReadErrorMsgResponse extends CommonResponse {
        private short crc;
        private int size;

        public short getCrc() {
            return this.crc;
        }

        public int getSize() {
            return this.size;
        }

        public void parseData(byte[] bArr) {
            if (bArr != null && bArr.length >= 4) {
                setSize(CHexConver.bytesToInt(bArr, 0, 4));
                if (6 > bArr.length) {
                    return;
                }
                setCrc(CHexConver.bytesToShort(bArr[4], bArr[5]));
            }
        }

        public void setCrc(short s) {
            this.crc = s;
        }

        public void setSize(int i) {
            this.size = i;
        }
    }

    /* loaded from: classes10.dex */
    public static class ResponseReadResult extends ReadErrorMsgParam {
        private short crc;
        private int size;

        public short getCrc() {
            return this.crc;
        }

        @Override // com.jieli.jl_rcsp.model.command.ReadErrorMsgCmd.ReadErrorMsgParam, com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(CHexConver.intToBigBytes(this.size));
                byteArrayOutputStream.write(CHexConver.shortToBigBytes(this.crc));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }

        public int getSize() {
            return this.size;
        }

        public void setCrc(short s) {
            this.crc = s;
        }

        public void setSize(int i) {
            this.size = i;
        }
    }

    public ReadErrorMsgCmd(ReadErrorMsgParam readErrorMsgParam) {
        super(41, ReadErrorMsgCmd.class.getSimpleName(), readErrorMsgParam);
    }
}
