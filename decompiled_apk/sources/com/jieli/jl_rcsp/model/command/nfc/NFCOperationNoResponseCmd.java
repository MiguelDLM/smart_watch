package com.jieli.jl_rcsp.model.command.nfc;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.model.base.CommandWithParam;
import com.jieli.jl_rcsp.util.CHexConver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes10.dex */
public class NFCOperationNoResponseCmd extends CommandWithParam<Param> {

    /* loaded from: classes10.dex */
    public static class NotifyDefaultNfcParam extends Param {
        private final int flag;
        private final short id;

        public NotifyDefaultNfcParam(int i, short s) {
            super(i, 5);
            this.flag = 2;
            this.id = s;
        }

        public int getFlag() {
            return this.flag;
        }

        public short getId() {
            return this.id;
        }

        @Override // com.jieli.jl_rcsp.model.command.nfc.NFCOperationNoResponseCmd.Param, com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(super.getParamData());
                byteArrayOutputStream.write((byte) this.flag);
                byteArrayOutputStream.write(CHexConver.shortToBigBytes(this.id));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
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

        public int getOp() {
            return this.op;
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(CHexConver.intToBigBytes(this.devHandler));
                byteArrayOutputStream.write((byte) this.op);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }
    }

    /* loaded from: classes10.dex */
    public static class StopSyncParam extends Param {
        private final int reason;

        public StopSyncParam(int i, int i2) {
            super(i, 1);
            this.reason = i2;
        }

        @Override // com.jieli.jl_rcsp.model.command.nfc.NFCOperationNoResponseCmd.Param, com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(super.getParamData());
                byteArrayOutputStream.write((byte) this.reason);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }

        public int getReason() {
            return this.reason;
        }
    }

    public NFCOperationNoResponseCmd(Param param) {
        super(164, NFCOperationNoResponseCmd.class.getSimpleName(), param);
    }
}
