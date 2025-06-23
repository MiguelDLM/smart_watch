package com.jieli.jl_rcsp.model.command.file_op;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes10.dex */
public class ReadFileFromDeviceCmd extends CommandWithParamAndResponse<Param, Response> {

    /* loaded from: classes10.dex */
    public static class CancelParam extends Param {
        public byte reason;

        public CancelParam(byte b) {
            super((byte) -127);
            this.reason = b;
        }

        @Override // com.jieli.jl_rcsp.model.command.file_op.ReadFileFromDeviceCmd.Param, com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            return new byte[]{this.op, this.reason};
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter
        public String toString() {
            return "CancelParam{op=" + ((int) this.op) + ", reason=" + ((int) this.reason) + '}';
        }
    }

    /* loaded from: classes10.dex */
    public static class Param extends BaseParameter {
        public static final byte OP_CANCEL = -127;
        public static final byte OP_START_WITH_CLUSTER = 1;
        public static final byte OP_START_WITH_DEV_AND_NAME = 2;
        public static final byte OP_START_WITH_NAME = 0;
        public static final byte OP_STOP = Byte.MIN_VALUE;
        public static final byte OP_UNKNOWN = -1;
        public byte op;

        public Param(byte b) {
            this.op = b;
        }

        public static byte[] getNameData(String str, boolean z) {
            if (!z) {
                return str.getBytes(Charset.forName("gbk"));
            }
            byte[] bytes = "\\U".getBytes();
            byte[] bytes2 = str.getBytes(StandardCharsets.UTF_16LE);
            byte[] bArr = new byte[bytes2.length + bytes.length + 2];
            System.arraycopy(bytes, 0, bArr, 0, bytes.length);
            System.arraycopy(bytes2, 0, bArr, bytes.length, bytes2.length);
            return bArr;
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            return new byte[]{this.op};
        }
    }

    /* loaded from: classes10.dex */
    public static class Response extends CommonResponse {
    }

    /* loaded from: classes10.dex */
    public static class StartResponse extends Response {
        public int size;

        public StartResponse(int i) {
            this.size = i;
        }

        @Override // com.jieli.jl_rcsp.model.base.CommonResponse
        public String toString() {
            return "StartResponse{size=" + this.size + '}';
        }
    }

    /* loaded from: classes10.dex */
    public static class StartWithClusterParam extends Param {
        public int cluster;
        public int devHandler;
        public int offset;

        public StartWithClusterParam(int i, int i2, int i3) {
            super((byte) 1);
            this.offset = i2;
            this.cluster = i3;
            this.devHandler = i;
        }

        @Override // com.jieli.jl_rcsp.model.command.file_op.ReadFileFromDeviceCmd.Param, com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            ByteBuffer allocate = ByteBuffer.allocate(13);
            allocate.put(this.op).putInt(this.devHandler).putInt(this.offset).putInt(this.cluster);
            return allocate.array();
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter
        public String toString() {
            return "StartWithClusterParam{op=" + ((int) this.op) + ", offset=" + this.offset + ", cluster=" + this.cluster + '}';
        }
    }

    /* loaded from: classes10.dex */
    public static class StartWithDevAndNameParam extends Param {
        public int devHandler;
        public String name;
        public int offset;
        public boolean unicode;

        public StartWithDevAndNameParam(int i, int i2, String str, boolean z) {
            super((byte) 2);
            this.offset = i2;
            this.devHandler = i;
            this.name = str;
            this.unicode = z;
        }

        @Override // com.jieli.jl_rcsp.model.command.file_op.ReadFileFromDeviceCmd.Param, com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            byte[] nameData = Param.getNameData(this.name, this.unicode);
            ByteBuffer allocate = ByteBuffer.allocate(nameData.length + 10);
            allocate.put(this.op).putInt(this.devHandler).putInt(this.offset).put((byte) nameData.length).put(nameData);
            return allocate.array();
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter
        public String toString() {
            return "StartWithNameParam{offset=" + this.offset + ", name='" + this.name + "', unicode='" + this.unicode + "'}";
        }
    }

    @Deprecated
    /* loaded from: classes10.dex */
    public static class StartWithNameParam extends Param {
        public String name;
        public int offset;
        public boolean unicode;

        public StartWithNameParam(int i, String str, boolean z) {
            super((byte) 0);
            this.offset = i;
            this.name = str;
            this.unicode = z;
        }

        @Override // com.jieli.jl_rcsp.model.command.file_op.ReadFileFromDeviceCmd.Param, com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            byte[] nameData = Param.getNameData(this.name, this.unicode);
            ByteBuffer allocate = ByteBuffer.allocate(nameData.length + 5);
            allocate.put(this.op).putInt(this.offset).put(nameData);
            return allocate.array();
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter
        public String toString() {
            return "StartWithNameParam{offset=" + this.offset + ", name='" + this.name + "', unicode='" + this.unicode + "'}";
        }
    }

    /* loaded from: classes10.dex */
    public static class StopParam extends Param {
        public byte ret;

        public StopParam(byte b) {
            super(Byte.MIN_VALUE);
            this.ret = b;
        }

        @Override // com.jieli.jl_rcsp.model.command.file_op.ReadFileFromDeviceCmd.Param, com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            return new byte[]{this.op, this.ret};
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter
        public String toString() {
            return "StopParam{op=" + ((int) this.op) + ", ret=" + ((int) this.ret) + '}';
        }
    }

    public ReadFileFromDeviceCmd(Param param) {
        super(36, ReadFileFromDeviceCmd.class.getCanonicalName(), param);
    }
}
