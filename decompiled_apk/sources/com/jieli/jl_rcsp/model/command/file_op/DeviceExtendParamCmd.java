package com.jieli.jl_rcsp.model.command.file_op;

import com.jieli.jl_rcsp.interfaces.cmd.IDataOp;
import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.util.CHexConver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes10.dex */
public class DeviceExtendParamCmd extends CommandWithParamAndResponse<Param, Response> {
    public static final byte OP_DELETE_FILE = 1;
    public static final byte OP_FILE_TRANSFER = 0;
    public static final byte OP_READ_FILE = 2;

    /* loaded from: classes10.dex */
    public static class DeleteFileParam extends DevParam {
        public DeleteFileParam(byte[] bArr) {
            super(bArr);
        }

        public DeleteFileParam(int i) {
            super((byte) 1, i);
        }
    }

    /* loaded from: classes10.dex */
    public static class DevParam extends Param {
        private int dev;

        public DevParam(byte[] bArr) {
            super(bArr);
        }

        public int getDev() {
            return this.dev;
        }

        @Override // com.jieli.jl_rcsp.model.command.file_op.DeviceExtendParamCmd.Param, com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public int parse(byte[] bArr) {
            int i;
            int parse = super.parse(bArr);
            if (parse != 0 && (i = parse + 4) <= bArr.length) {
                this.dev = CHexConver.bytesToInt(bArr, parse, 4);
                return i;
            }
            return parse;
        }

        @Override // com.jieli.jl_rcsp.model.command.file_op.DeviceExtendParamCmd.Param, com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public byte[] toData() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(super.toData());
                byteArrayOutputStream.write(CHexConver.intToBigBytes(this.dev));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }

        @Override // com.jieli.jl_rcsp.model.command.file_op.DeviceExtendParamCmd.Param, com.jieli.jl_rcsp.model.base.BaseParameter
        public String toString() {
            return "DevParam{op=" + ((int) getOp()) + ", dev=" + this.dev + "} ";
        }

        public DevParam(byte b, int i) {
            super(b);
            this.dev = i;
        }
    }

    /* loaded from: classes10.dex */
    public static class FileTransferParam extends DevParam {
        private boolean hasCrc16;

        public FileTransferParam(byte[] bArr) {
            super(bArr);
        }

        public boolean isHasCrc16() {
            return this.hasCrc16;
        }

        @Override // com.jieli.jl_rcsp.model.command.file_op.DeviceExtendParamCmd.DevParam, com.jieli.jl_rcsp.model.command.file_op.DeviceExtendParamCmd.Param, com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public int parse(byte[] bArr) {
            int i;
            int parse = super.parse(bArr);
            if (parse != 0 && (i = parse + 1) <= bArr.length) {
                int byteToInt = CHexConver.byteToInt(bArr[parse]);
                boolean z = true;
                if (byteToInt != 1) {
                    z = false;
                }
                this.hasCrc16 = z;
                return i;
            }
            return parse;
        }

        @Override // com.jieli.jl_rcsp.model.command.file_op.DeviceExtendParamCmd.DevParam, com.jieli.jl_rcsp.model.command.file_op.DeviceExtendParamCmd.Param, com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public byte[] toData() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(super.toData());
                byteArrayOutputStream.write(this.hasCrc16 ? 1 : 0);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }

        @Override // com.jieli.jl_rcsp.model.command.file_op.DeviceExtendParamCmd.DevParam, com.jieli.jl_rcsp.model.command.file_op.DeviceExtendParamCmd.Param, com.jieli.jl_rcsp.model.base.BaseParameter
        public String toString() {
            return "FileTransferParam{hasCrc16=" + this.hasCrc16 + ", dev=" + getDev() + ", op=" + ((int) getOp()) + "} ";
        }

        public FileTransferParam(int i, boolean z) {
            super((byte) 0, i);
            this.hasCrc16 = z;
        }
    }

    /* loaded from: classes10.dex */
    public static class FileTransferResponse extends Response {
        public boolean hasCrc16;

        public FileTransferResponse(byte[] bArr) {
            super(bArr);
        }

        @Override // com.jieli.jl_rcsp.model.command.file_op.DeviceExtendParamCmd.Response, com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public int parse(byte[] bArr) {
            int i;
            int parse = super.parse(bArr);
            if (parse != 0 && (i = parse + 1) <= bArr.length) {
                int byteToInt = CHexConver.byteToInt(bArr[parse]);
                boolean z = true;
                if (byteToInt != 1) {
                    z = false;
                }
                this.hasCrc16 = z;
                return i;
            }
            return parse;
        }

        @Override // com.jieli.jl_rcsp.model.command.file_op.DeviceExtendParamCmd.Response, com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public byte[] toData() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(super.toData());
                byteArrayOutputStream.write(this.hasCrc16 ? 1 : 0);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }

        @Override // com.jieli.jl_rcsp.model.base.CommonResponse
        public String toString() {
            return "FileTransferResponse{hasCrc16=" + this.hasCrc16 + "} ";
        }

        public FileTransferResponse(boolean z) {
            super((byte) 0);
            this.hasCrc16 = z;
        }
    }

    /* loaded from: classes10.dex */
    public static class ReadFileParam extends DevParam {
        public ReadFileParam(byte[] bArr) {
            super(bArr);
        }

        public ReadFileParam(int i) {
            super((byte) 2, i);
        }
    }

    public DeviceExtendParamCmd(Param param) {
        super(39, DeviceExtendParamCmd.class.getSimpleName(), param);
    }

    /* loaded from: classes10.dex */
    public static class Param extends BaseParameter implements IDataOp {
        private byte op;

        public Param(byte[] bArr) {
            parse(bArr);
        }

        public byte getOp() {
            return this.op;
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            return toData();
        }

        public int parse(byte[] bArr) {
            if (bArr == null || bArr.length == 0) {
                return 0;
            }
            this.op = bArr[0];
            return 1;
        }

        public byte[] toData() {
            return new byte[]{this.op};
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter
        public String toString() {
            return "Param{op=" + ((int) this.op) + "} ";
        }

        public Param(byte b) {
            this.op = b;
        }
    }

    /* loaded from: classes10.dex */
    public static class Response extends CommonResponse implements IDataOp {
        private byte op;

        public Response(byte[] bArr) {
            parse(bArr);
        }

        public byte getOp() {
            return this.op;
        }

        public int parse(byte[] bArr) {
            if (bArr == null || bArr.length == 0) {
                return 0;
            }
            this.op = bArr[0];
            return 1;
        }

        public byte[] toData() {
            return new byte[]{this.op};
        }

        public Response(byte b) {
            this.op = b;
        }
    }
}
