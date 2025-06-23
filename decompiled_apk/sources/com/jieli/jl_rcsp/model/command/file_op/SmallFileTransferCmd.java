package com.jieli.jl_rcsp.model.command.file_op;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.util.CHexConver;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public class SmallFileTransferCmd extends CommandWithParamAndResponse<Param, Response> {
    public static final byte FLAG_FIRST_PACKET = 1;
    public static final byte OP_ADD_FILE = 2;
    public static final byte OP_DELETE_FILE = 4;
    public static final byte OP_QUERY_BY_TYPE = 0;
    public static final byte OP_READ_FILE = 1;
    public static final byte OP_UPDATE_FILE = 3;
    public static final byte TYPE_BLOOD_OXYGEN = 4;
    public static final byte TYPE_CALL_LOG = 8;
    public static final byte TYPE_CONTACTS = 1;
    public static final byte TYPE_HEART_RATE = 3;
    public static final byte TYPE_MESSAGE_SYNC = 6;
    public static final byte TYPE_SLEEP = 5;
    public static final byte TYPE_SPORTS_RECORD = 2;
    public static final byte TYPE_STEP = 9;
    public static final byte TYPE_WEATHER = 7;

    /* loaded from: classes10.dex */
    public static class AddFileParam extends Param {
        public AddFileParam(byte b, short s, short s2, byte[] bArr, short s3) {
            super((byte) 2, ByteBuffer.allocate(bArr.length + 7).put(b).putShort(s).putShort(s2).put(CHexConver.shortToBigBytes(s3)).put(bArr).array());
        }
    }

    /* loaded from: classes10.dex */
    public static class AddFileResponse extends ResultResponse {
        public short id;

        public AddFileResponse(byte[] bArr) {
            super(bArr[0]);
            if (bArr.length >= 3) {
                this.id = CHexConver.bytesToShort(bArr[1], bArr[2]);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class DeleteFileParam extends Param {
        public DeleteFileParam(byte b, short s) {
            super((byte) 4, ByteBuffer.allocate(3).put(b).putShort(s).array());
        }
    }

    /* loaded from: classes10.dex */
    public static class Param extends BaseParameter {
        public byte[] data;
        public byte op;

        public Param(byte b, byte[] bArr) {
            this.op = b;
            this.data = bArr;
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            return ByteBuffer.allocate(this.data.length + 1).put(this.op).put(this.data).array();
        }
    }

    /* loaded from: classes10.dex */
    public static class QueryParam extends Param {
        public QueryParam(byte b) {
            super((byte) 0, new byte[]{b});
        }
    }

    /* loaded from: classes10.dex */
    public static class QueryResponse extends Response {
        private final List<File> files = new ArrayList();
        private final byte version;

        /* loaded from: classes10.dex */
        public static class File {
            public short id;
            public int size;
            public byte type;

            public File(byte b, short s, int i) {
                this.type = b;
                this.id = s;
                this.size = i;
            }
        }

        public QueryResponse(byte b, byte[] bArr) {
            this.version = bArr[0];
            int i = 1;
            while (i < bArr.length) {
                if (this.version == 0) {
                    this.files.add(new File(b, CHexConver.bytesToShort(bArr[i], bArr[i + 1]), CHexConver.bytesToInt(bArr[i + 2], bArr[i + 3])));
                    i += 4;
                }
            }
        }

        public List<File> getFiles() {
            return this.files;
        }
    }

    /* loaded from: classes10.dex */
    public static class ReadFileParam extends Param {
        public ReadFileParam(byte b, short s, short s2, short s3, byte b2) {
            super((byte) 1, ByteBuffer.allocate(8).put(b).putShort(s).putShort(s2).putShort(s3).put(b2).array());
        }
    }

    /* loaded from: classes10.dex */
    public static class ReadFileResponse extends Response {
        public short crc;
        public byte[] fileData;
        public byte ret;

        public ReadFileResponse(byte[] bArr) {
            byte b = bArr[0];
            this.ret = b;
            if (b == 0) {
                this.fileData = new byte[bArr.length - 3];
                this.crc = CHexConver.bytesToShort(bArr[1], bArr[2]);
                byte[] bArr2 = this.fileData;
                System.arraycopy(bArr, 3, bArr2, 0, bArr2.length);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class Response extends CommonResponse {
    }

    /* loaded from: classes10.dex */
    public static class ResultResponse extends Response {
        public byte ret;

        public ResultResponse(byte b) {
            this.ret = b;
        }
    }

    /* loaded from: classes10.dex */
    public static class UpdateFileParam extends Param {
        public UpdateFileParam(byte b, short s, short s2, short s3, byte[] bArr, short s4) {
            super((byte) 3, ByteBuffer.allocate(bArr.length + 9).put(b).putShort(s).putShort(s2).putShort(s3).putShort(s4).put(bArr).array());
        }
    }

    public SmallFileTransferCmd(Param param) {
        super(40, SmallFileTransferCmd.class.getSimpleName(), param);
    }
}
