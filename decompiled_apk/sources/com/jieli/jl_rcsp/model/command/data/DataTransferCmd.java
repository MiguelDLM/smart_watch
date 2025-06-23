package com.jieli.jl_rcsp.model.command.data;

import com.jieli.jl_rcsp.interfaces.cmd.IParamBase;
import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.util.CHexConver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes10.dex */
public class DataTransferCmd extends CommandBase<Param, Response> {

    /* loaded from: classes10.dex */
    public static class CustomReplyParam extends Param {
        private final byte[] customData;

        public CustomReplyParam(byte[] bArr) {
            super(new byte[0]);
            this.customData = bArr;
        }

        @Override // com.jieli.jl_rcsp.model.command.data.DataTransferCmd.Param, com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            return this.customData;
        }
    }

    public DataTransferCmd(Param param) {
        this(2, param);
    }

    /* loaded from: classes10.dex */
    public static class DataTransferParam extends Param {
        private short crc;
        private byte[] data;
        private boolean isEnd;
        private int len;
        private int offset;
        private int seq;
        private int type;

        public DataTransferParam(byte[] bArr) {
            super(bArr);
            parsePayload(getPayload());
        }

        private static byte[] getPayload(int i, boolean z, int i2, short s, int i3, byte[] bArr) {
            int i4;
            int length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(i);
            if (z) {
                i4 = 32768 | i2;
            } else {
                i4 = i2 & 32767;
            }
            try {
                byteArrayOutputStream.write(CHexConver.int2byte2(i4));
                byteArrayOutputStream.write(CHexConver.shortToBigBytes(s));
                byteArrayOutputStream.write(CHexConver.intToBigBytes(i3));
                if (bArr == null) {
                    length = 0;
                } else {
                    length = bArr.length;
                }
                byteArrayOutputStream.write(CHexConver.int2byte2(length));
                if (length > 0) {
                    byteArrayOutputStream.write(bArr);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }

        private void parsePayload(byte[] bArr) {
            if (bArr != null && bArr.length >= 11) {
                this.type = CHexConver.byteToInt(bArr[0]);
                boolean z = true;
                int bytesToInt = CHexConver.bytesToInt(bArr, 1, 2);
                this.seq = bytesToInt & 127;
                if ((bytesToInt >> 15) != 1) {
                    z = false;
                }
                this.isEnd = z;
                this.crc = (short) CHexConver.bytesToInt(bArr, 3, 2);
                this.offset = CHexConver.bytesToInt(bArr, 5, 4);
                int bytesToInt2 = CHexConver.bytesToInt(bArr, 9, 2);
                this.len = bytesToInt2;
                if (bArr.length > 11) {
                    int min = Math.min(bytesToInt2, bArr.length - 11);
                    this.len = min;
                    byte[] bArr2 = new byte[min];
                    this.data = bArr2;
                    System.arraycopy(bArr, 11, bArr2, 0, min);
                    return;
                }
                this.len = 0;
                this.data = new byte[0];
            }
        }

        public short getCrc() {
            return this.crc;
        }

        public byte[] getData() {
            return this.data;
        }

        public int getLen() {
            return this.len;
        }

        public int getOffset() {
            return this.offset;
        }

        public int getSeq() {
            return this.seq;
        }

        public int getType() {
            return this.type;
        }

        public boolean isEnd() {
            return this.isEnd;
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter
        public String toString() {
            return "DataTransferParam{op=" + getOp() + ", type=" + this.type + ", isEnd=" + this.isEnd + ", seq=" + this.seq + ", crc=" + ((int) this.crc) + ", offset=" + this.offset + ", len=" + this.len + ", data=" + CHexConver.byte2HexStr(this.data) + "} ";
        }

        public DataTransferParam(int i, boolean z, int i2, short s, int i3, byte[] bArr) {
            super(1, getPayload(i, z, i2, s, i3, bArr));
            this.type = i;
            this.isEnd = z;
            this.seq = i2;
            this.crc = s;
            this.offset = i3;
            this.data = bArr;
        }
    }

    /* loaded from: classes10.dex */
    public static class DataTransferResponse extends Response {
        private boolean isEnd;
        private byte[] message;
        private int result;
        private int seq;
        private int type;

        public DataTransferResponse(byte[] bArr) {
            super(bArr);
            parseResponseData(getResponse());
        }

        private static byte[] getResponseData(int i, boolean z, int i2, int i3, byte[] bArr) {
            int i4;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(i);
            if (z) {
                i4 = 32768 | i2;
            } else {
                i4 = i2 & 32767;
            }
            try {
                byteArrayOutputStream.write(CHexConver.int2byte2(i4));
                byteArrayOutputStream.write(i3);
                if (bArr != null && bArr.length > 0) {
                    byteArrayOutputStream.write(bArr);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }

        private void parseResponseData(byte[] bArr) {
            if (bArr != null && bArr.length >= 4) {
                this.type = CHexConver.byteToInt(bArr[0]);
                boolean z = true;
                int bytesToInt = CHexConver.bytesToInt(bArr, 1, 2);
                this.seq = bytesToInt & 127;
                if ((bytesToInt >> 15) != 1) {
                    z = false;
                }
                this.isEnd = z;
                this.result = CHexConver.byteToInt(bArr[3]);
                if (bArr.length > 4) {
                    int length = bArr.length - 4;
                    byte[] bArr2 = new byte[length];
                    this.message = bArr2;
                    System.arraycopy(bArr, 4, bArr2, 0, length);
                    return;
                }
                this.message = new byte[0];
            }
        }

        public byte[] getMessage() {
            return this.message;
        }

        public int getResult() {
            return this.result;
        }

        public int getSeq() {
            return this.seq;
        }

        public int getType() {
            return this.type;
        }

        public boolean isEnd() {
            return this.isEnd;
        }

        @Override // com.jieli.jl_rcsp.model.command.data.DataTransferCmd.Response, com.jieli.jl_rcsp.model.base.CommonResponse
        public String toString() {
            return "DataTransferResponse{type=" + this.type + ", isEnd=" + this.isEnd + ", seq=" + this.seq + ", result=" + this.result + ", message=" + CHexConver.byte2HexStr(this.message) + "} " + super.toString();
        }

        public DataTransferResponse(int i, boolean z, int i2, int i3, byte[] bArr) {
            super(1, getResponseData(i, z, i2, i3, bArr));
        }
    }

    /* loaded from: classes10.dex */
    public static class Param extends BaseParameter {
        private int op;
        private byte[] payload;

        public Param(byte[] bArr) {
            parseData(bArr);
        }

        public int getOp() {
            return this.op;
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(this.op);
            byte[] bArr = this.payload;
            if (bArr != null && bArr.length > 0) {
                try {
                    byteArrayOutputStream.write(bArr);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return byteArrayOutputStream.toByteArray();
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter
        public byte[] getPayload() {
            return this.payload;
        }

        public void parseData(byte[] bArr) {
            if (bArr != null && bArr.length >= 1) {
                this.op = CHexConver.byteToInt(bArr[0]);
                if (bArr.length > 1) {
                    int length = bArr.length - 1;
                    byte[] bArr2 = new byte[length];
                    this.payload = bArr2;
                    System.arraycopy(bArr, 1, bArr2, 0, length);
                    return;
                }
                this.payload = new byte[0];
            }
        }

        public Param(int i, byte[] bArr) {
            this.op = i;
            this.payload = bArr;
        }
    }

    /* loaded from: classes10.dex */
    public static class ReadDataParam extends TransferParam {
        private int receiveDataLimit;
        private int sendDataLimit;

        public ReadDataParam(byte[] bArr) {
            super(bArr);
            parseParams(getParam());
        }

        public static byte[] getParams(int i, int i2) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(CHexConver.int2byte2(i));
                byteArrayOutputStream.write(CHexConver.int2byte2(i2));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }

        private void parseParams(byte[] bArr) {
            if (bArr != null && bArr.length >= 4) {
                this.sendDataLimit = CHexConver.bytesToInt(bArr, 0, 2);
                this.receiveDataLimit = CHexConver.bytesToInt(bArr, 2, 2);
            }
        }

        public int getReceiveDataLimit() {
            return this.receiveDataLimit;
        }

        public int getSendDataLimit() {
            return this.sendDataLimit;
        }

        @Override // com.jieli.jl_rcsp.model.command.data.DataTransferCmd.TransferParam, com.jieli.jl_rcsp.model.base.BaseParameter
        public String toString() {
            return "ReadDataParam{sendDataLimit=" + this.sendDataLimit + ", receiveDataLimit=" + this.receiveDataLimit + "} " + super.toString();
        }

        public ReadDataParam(int i, int i2, int i3, int i4) {
            super(0, i, i2, getParams(i3, i4));
            this.sendDataLimit = i3;
            this.receiveDataLimit = i4;
        }
    }

    /* loaded from: classes10.dex */
    public static class ReadDataResponse extends TransferParamResponse {
        private short crc;
        private int dataLen;
        private int receiveDataLimit;
        private int result;
        private int sendDataLimit;

        public ReadDataResponse(byte[] bArr) {
            super(bArr);
            parseResponseData(getData());
        }

        private static byte[] getResponseData(int i, int i2, short s, int i3, int i4) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(i);
            try {
                byteArrayOutputStream.write(CHexConver.intToBigBytes(i2));
                byteArrayOutputStream.write(CHexConver.shortToBigBytes(s));
                byteArrayOutputStream.write(CHexConver.int2byte2(i3));
                byteArrayOutputStream.write(CHexConver.int2byte2(i4));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }

        private void parseResponseData(byte[] bArr) {
            if (bArr != null && bArr.length >= 11) {
                this.result = CHexConver.byteToInt(bArr[0]);
                this.dataLen = CHexConver.bytesToInt(bArr, 1, 4);
                this.crc = (short) CHexConver.bytesToInt(bArr, 5, 2);
                this.sendDataLimit = CHexConver.bytesToInt(bArr, 7, 2);
                this.receiveDataLimit = CHexConver.bytesToInt(bArr, 9, 2);
            }
        }

        public short getCrc() {
            return this.crc;
        }

        public int getDataLen() {
            return this.dataLen;
        }

        public int getReceiveDataLimit() {
            return this.receiveDataLimit;
        }

        public int getResult() {
            return this.result;
        }

        public int getSendDataLimit() {
            return this.sendDataLimit;
        }

        @Override // com.jieli.jl_rcsp.model.command.data.DataTransferCmd.TransferParamResponse, com.jieli.jl_rcsp.model.command.data.DataTransferCmd.Response, com.jieli.jl_rcsp.model.base.CommonResponse
        public String toString() {
            return "ReadDataResponse{result=" + this.result + ", dataLen=" + this.dataLen + ", crc=" + ((int) this.crc) + ", sendDataLimit=" + this.sendDataLimit + ", receiveDataLimit=" + this.receiveDataLimit + "} " + super.toString();
        }

        public ReadDataResponse(int i, int i2, int i3, int i4, short s, int i5, int i6) {
            super(0, i, i2, getResponseData(i3, i4, s, i5, i6));
            this.result = i3;
            this.dataLen = i4;
            this.crc = s;
            this.sendDataLimit = i5;
            this.receiveDataLimit = i6;
        }
    }

    /* loaded from: classes10.dex */
    public static class Response extends CommonResponse implements IParamBase {
        private int op;
        private byte[] response;

        public Response(byte[] bArr) {
            parseData(bArr);
        }

        private void parseData(byte[] bArr) {
            if (bArr != null && bArr.length >= 1) {
                this.op = CHexConver.byteToInt(bArr[0]);
                if (bArr.length > 1) {
                    int length = bArr.length - 1;
                    byte[] bArr2 = new byte[length];
                    this.response = bArr2;
                    System.arraycopy(bArr, 1, bArr2, 0, length);
                    return;
                }
                this.response = new byte[0];
            }
        }

        public int getOp() {
            return this.op;
        }

        @Override // com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(this.op);
            byte[] bArr = this.response;
            if (bArr != null && bArr.length > 0) {
                try {
                    byteArrayOutputStream.write(bArr);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return byteArrayOutputStream.toByteArray();
        }

        public byte[] getResponse() {
            return this.response;
        }

        @Override // com.jieli.jl_rcsp.model.base.CommonResponse
        public String toString() {
            return "Response{op=" + this.op + ", response=" + CHexConver.byte2HexStr(this.response) + "} ";
        }

        public Response(int i, byte[] bArr) {
            this.op = i;
            this.response = bArr;
        }
    }

    /* loaded from: classes10.dex */
    public static class SendDataParam extends TransferParam {
        private short crc;
        private int dataLen;
        private int receiveDataLimit;
        private int sendDataLimit;

        public SendDataParam(byte[] bArr) {
            super(bArr);
            parseParams(getParam());
        }

        private static byte[] getParams(int i, short s, int i2, int i3) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(CHexConver.intToBigBytes(i));
                byteArrayOutputStream.write(CHexConver.shortToBigBytes(s));
                byteArrayOutputStream.write(CHexConver.int2byte2(i2));
                byteArrayOutputStream.write(CHexConver.int2byte2(i3));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }

        private void parseParams(byte[] bArr) {
            if (bArr != null && bArr.length >= 10) {
                this.dataLen = CHexConver.bytesToInt(bArr, 0, 4);
                this.crc = (short) CHexConver.bytesToInt(bArr, 4, 2);
                this.sendDataLimit = CHexConver.bytesToInt(bArr, 6, 2);
                this.receiveDataLimit = CHexConver.bytesToInt(bArr, 8, 2);
            }
        }

        public short getCrc() {
            return this.crc;
        }

        public int getDataLen() {
            return this.dataLen;
        }

        public int getReceiveDataLimit() {
            return this.receiveDataLimit;
        }

        public int getSendDataLimit() {
            return this.sendDataLimit;
        }

        @Override // com.jieli.jl_rcsp.model.command.data.DataTransferCmd.TransferParam, com.jieli.jl_rcsp.model.base.BaseParameter
        public String toString() {
            return "SendDataParam{dataLen=" + this.dataLen + ", crc=" + ((int) this.crc) + ", sendDataLimit=" + this.sendDataLimit + ", receiveDataLimit=" + this.receiveDataLimit + "} " + super.toString();
        }

        public SendDataParam(int i, int i2, int i3, short s, int i4, int i5) {
            super(1, i, i2, getParams(i3, s, i4, i5));
            this.dataLen = i3;
            this.crc = s;
            this.sendDataLimit = i4;
            this.receiveDataLimit = i5;
        }
    }

    /* loaded from: classes10.dex */
    public static class SendDataResponse extends TransferParamResponse {
        private int receiveDataLimit;
        private int result;
        private int sendDataLimit;

        public SendDataResponse(byte[] bArr) {
            super(bArr);
            parseResponseData(getData());
        }

        private static byte[] getResponseData(int i, int i2, int i3) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(i);
            try {
                byteArrayOutputStream.write(CHexConver.int2byte2(i2));
                byteArrayOutputStream.write(CHexConver.int2byte2(i3));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }

        private void parseResponseData(byte[] bArr) {
            if (bArr != null && bArr.length >= 5) {
                this.result = CHexConver.byteToInt(bArr[0]);
                this.sendDataLimit = CHexConver.bytesToInt(bArr, 1, 2);
                this.receiveDataLimit = CHexConver.bytesToInt(bArr, 3, 2);
            }
        }

        public int getReceiveDataLimit() {
            return this.receiveDataLimit;
        }

        public int getResult() {
            return this.result;
        }

        public int getSendDataLimit() {
            return this.sendDataLimit;
        }

        @Override // com.jieli.jl_rcsp.model.command.data.DataTransferCmd.TransferParamResponse, com.jieli.jl_rcsp.model.command.data.DataTransferCmd.Response, com.jieli.jl_rcsp.model.base.CommonResponse
        public String toString() {
            return "SendDataResponse{result=" + this.result + ", sendDataLimit=" + this.sendDataLimit + ", receiveDataLimit=" + this.receiveDataLimit + "} " + super.toString();
        }

        public SendDataResponse(int i, int i2, int i3, int i4, int i5, int i6) {
            super(i, i2, i3, getResponseData(i4, i5, i6));
            this.result = i4;
            this.sendDataLimit = i5;
            this.receiveDataLimit = i6;
        }
    }

    /* loaded from: classes10.dex */
    public static class TransferParam extends Param {
        private byte[] param;
        private int type;
        private int version;
        private int way;

        public TransferParam(byte[] bArr) {
            super(bArr);
            parsePayload(getPayload());
        }

        private static byte[] getPayload(int i, int i2, int i3, byte[] bArr) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(i);
            byteArrayOutputStream.write(i2);
            byteArrayOutputStream.write(i3);
            if (bArr != null && bArr.length > 0) {
                try {
                    byteArrayOutputStream.write(bArr);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return byteArrayOutputStream.toByteArray();
        }

        private void parsePayload(byte[] bArr) {
            if (bArr != null && bArr.length >= 3) {
                this.way = CHexConver.byteToInt(bArr[0]);
                this.type = CHexConver.byteToInt(bArr[1]);
                this.version = CHexConver.byteToInt(bArr[2]);
                if (bArr.length > 3) {
                    int length = bArr.length - 3;
                    byte[] bArr2 = new byte[length];
                    this.param = bArr2;
                    System.arraycopy(bArr, 3, bArr2, 0, length);
                    return;
                }
                this.param = new byte[0];
            }
        }

        public byte[] getParam() {
            return this.param;
        }

        public int getType() {
            return this.type;
        }

        public int getVersion() {
            return this.version;
        }

        public int getWay() {
            return this.way;
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter
        public String toString() {
            return "TransferParam{op=" + getOp() + ", way=" + this.way + ", type=" + this.type + ", version=" + this.version + ", param=" + CHexConver.byte2HexStr(this.param) + "} ";
        }

        public TransferParam(int i, int i2, int i3, byte[] bArr) {
            super(0, getPayload(i, i2, i3, bArr));
            this.way = i;
            this.type = i2;
            this.version = i3;
            this.param = bArr;
        }
    }

    /* loaded from: classes10.dex */
    public static class TransferParamResponse extends Response {
        private byte[] data;
        private int type;
        private int version;
        private int way;

        public TransferParamResponse(byte[] bArr) {
            super(bArr);
            parseResponseData(getResponse());
        }

        private static byte[] getResponseData(int i, int i2, int i3, byte[] bArr) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(i);
            byteArrayOutputStream.write(i2);
            byteArrayOutputStream.write(i3);
            if (bArr != null && bArr.length > 0) {
                try {
                    byteArrayOutputStream.write(bArr);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return byteArrayOutputStream.toByteArray();
        }

        private void parseResponseData(byte[] bArr) {
            if (bArr != null && bArr.length >= 3) {
                this.way = CHexConver.byteToInt(bArr[0]);
                this.type = CHexConver.byteToInt(bArr[1]);
                this.version = CHexConver.byteToInt(bArr[2]);
                if (bArr.length > 3) {
                    int length = bArr.length - 3;
                    byte[] bArr2 = new byte[length];
                    this.data = bArr2;
                    System.arraycopy(bArr, 3, bArr2, 0, length);
                    return;
                }
                this.data = new byte[0];
            }
        }

        public byte[] getData() {
            return this.data;
        }

        public int getType() {
            return this.type;
        }

        public int getVersion() {
            return this.version;
        }

        public int getWay() {
            return this.way;
        }

        @Override // com.jieli.jl_rcsp.model.command.data.DataTransferCmd.Response, com.jieli.jl_rcsp.model.base.CommonResponse
        public String toString() {
            return "TransferParamResponse{op=" + getOp() + ", way=" + this.way + ", type=" + this.type + ", version=" + this.version + ", data=" + CHexConver.byte2HexStr(this.data) + "} ";
        }

        public TransferParamResponse(int i, int i2, int i3, byte[] bArr) {
            super(0, getResponseData(i, i2, i3, bArr));
            this.way = i;
            this.type = i2;
            this.version = i3;
            this.data = bArr;
        }
    }

    public DataTransferCmd(int i, Param param) {
        super(48, DataTransferCmd.class.getSimpleName(), i);
        setParam(param);
    }

    /* loaded from: classes10.dex */
    public static class CancelTransferParam extends Param {
        private int reason;

        public CancelTransferParam(byte[] bArr) {
            super(bArr);
            this.reason = -1;
            parsePayload(getPayload());
        }

        private void parsePayload(byte[] bArr) {
            if (bArr != null && bArr.length != 0) {
                this.reason = CHexConver.byteToInt(bArr[0]);
            }
        }

        public int getReason() {
            return this.reason;
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter
        public String toString() {
            return "CancelTransferParam{reason=" + this.reason + '}';
        }

        public CancelTransferParam(int i) {
            super(2, new byte[]{(byte) i});
            this.reason = i;
        }
    }
}
