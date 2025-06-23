package com.jieli.jl_rcsp.model.command.nfc;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.util.CHexConver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes10.dex */
public class NFCOperationCmd extends CommandWithParamAndResponse<Param, Response> {

    /* loaded from: classes10.dex */
    public static class DefaultNfcParam extends Param {
        private final int flag;
        private final byte[] value;

        public DefaultNfcParam(int i, int i2, byte[] bArr) {
            super(i, 5);
            this.flag = i2;
            this.value = bArr;
        }

        public int getFlag() {
            return this.flag;
        }

        @Override // com.jieli.jl_rcsp.model.command.nfc.NFCOperationCmd.Param, com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(super.getParamData());
                byteArrayOutputStream.write((byte) this.flag);
                byte[] bArr = this.value;
                if (bArr != null && bArr.length > 0) {
                    byteArrayOutputStream.write(bArr);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }

        public byte[] getValue() {
            return this.value;
        }
    }

    /* loaded from: classes10.dex */
    public static class DeleteMsgParam extends Param {
        private final short id;

        public DeleteMsgParam(int i, short s) {
            super(i, 3);
            this.id = s;
        }

        public short getId() {
            return this.id;
        }

        @Override // com.jieli.jl_rcsp.model.command.nfc.NFCOperationCmd.Param, com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(super.getParamData());
                byteArrayOutputStream.write(CHexConver.shortToBigBytes(this.id));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }
    }

    /* loaded from: classes10.dex */
    public static class GetDefaultNfcParam extends DefaultNfcParam {
        public GetDefaultNfcParam(int i) {
            super(i, 0, null);
        }
    }

    /* loaded from: classes10.dex */
    public static class GetDefaultNfcResponse extends Response {
        private final short id;

        public GetDefaultNfcResponse(int i, short s) {
            super(i);
            this.id = s;
        }

        public short getId() {
            return this.id;
        }
    }

    /* loaded from: classes10.dex */
    public static class InsertFileEndParam extends Param {
        private final String fileName;

        public InsertFileEndParam(int i, String str) {
            super(i, 7);
            this.fileName = str;
        }

        public String getFileName() {
            return this.fileName;
        }

        @Override // com.jieli.jl_rcsp.model.command.nfc.NFCOperationCmd.Param, com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(super.getParamData());
                String str = this.fileName;
                if (str != null) {
                    byteArrayOutputStream.write(str.getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }
    }

    /* loaded from: classes10.dex */
    public static class InsertFileParam extends Param {
        private final String fileName;
        private final int fileSize;

        public InsertFileParam(int i, int i2, String str) {
            super(i, 6);
            this.fileSize = i2;
            this.fileName = str;
        }

        public String getFileName() {
            return this.fileName;
        }

        public int getFileSize() {
            return this.fileSize;
        }

        @Override // com.jieli.jl_rcsp.model.command.nfc.NFCOperationCmd.Param, com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(super.getParamData());
                byteArrayOutputStream.write(CHexConver.intToBigBytes(this.fileSize));
                String str = this.fileName;
                if (str != null) {
                    byteArrayOutputStream.write(str.getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }
    }

    /* loaded from: classes10.dex */
    public static class ModifyMsgParam extends Param {
        private final short id;
        private final int mask;
        private final byte[] value;

        public ModifyMsgParam(int i, short s, int i2, byte[] bArr) {
            super(i, 2);
            this.id = s;
            this.mask = i2;
            this.value = bArr;
        }

        public short getId() {
            return this.id;
        }

        public int getMask() {
            return this.mask;
        }

        @Override // com.jieli.jl_rcsp.model.command.nfc.NFCOperationCmd.Param, com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(super.getParamData());
                byteArrayOutputStream.write(CHexConver.shortToBigBytes(this.id));
                byteArrayOutputStream.write(CHexConver.intToBigBytes(this.mask));
                byte[] bArr = this.value;
                if (bArr != null && bArr.length > 0) {
                    byteArrayOutputStream.write(bArr);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }

        public byte[] getValue() {
            return this.value;
        }
    }

    /* loaded from: classes10.dex */
    public static class NotifyNfcParam extends Param {
        public NotifyNfcParam(int i) {
            super(i, 4);
        }

        @Override // com.jieli.jl_rcsp.model.command.nfc.NFCOperationCmd.Param, com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            return super.getParamData();
        }
    }

    /* loaded from: classes10.dex */
    public static class Param extends BaseParameter {
        private final int devHandler;
        private final int op;

        public Param(int i, int i2) {
            this.devHandler = i;
            this.op = i2;
        }

        public int getDevHandler() {
            return this.devHandler;
        }

        public int getOp() {
            return this.op;
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(CHexConver.intToBigBytes(this.devHandler));
                byteArrayOutputStream.write((byte) getOp());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }
    }

    /* loaded from: classes10.dex */
    public static class Response extends CommonResponse {
        private final int result;

        public Response(int i) {
            this.result = i;
        }

        public int getResult() {
            return this.result;
        }
    }

    /* loaded from: classes10.dex */
    public static class SetDefaultNfcParam extends DefaultNfcParam {
        private final short id;

        public SetDefaultNfcParam(int i, short s) {
            super(i, 1, CHexConver.shortToBigBytes(s));
            this.id = s;
        }

        public short getId() {
            return this.id;
        }
    }

    /* loaded from: classes10.dex */
    public static class StartSyncParam extends Param {
        public StartSyncParam(int i) {
            super(i, 0);
        }

        @Override // com.jieli.jl_rcsp.model.command.nfc.NFCOperationCmd.Param, com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            return super.getParamData();
        }
    }

    public NFCOperationCmd(Param param) {
        super(164, NFCOperationCmd.class.getSimpleName(), param);
    }
}
