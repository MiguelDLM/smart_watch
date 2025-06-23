package com.jieli.jl_rcsp.model.command.watch;

import com.jieli.jl_rcsp.exception.ParseDataException;
import com.jieli.jl_rcsp.interfaces.cmd.IDataOp;
import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.model.base.CommandWithParam;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes10.dex */
public class ReceiveHealthDataCmd extends CommandWithParam<Param> {

    /* loaded from: classes10.dex */
    public static class Param extends BaseParameter implements IDataOp {
        public byte[] data;
        public byte packageCount;
        public byte packageId;
        public byte version;

        public Param(byte[] bArr) throws ParseDataException {
            int parse = parse(bArr);
            if (parse >= 0) {
                return;
            }
            throw new ParseDataException(1, "Failed to parse data. size = " + parse, bArr);
        }

        @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public int parse(byte[] bArr) {
            this.data = new byte[0];
            if (bArr == null || bArr.length == 0) {
                return 0;
            }
            if (bArr.length < 3) {
                return -1;
            }
            this.version = bArr[0];
            this.packageCount = bArr[1];
            this.packageId = bArr[2];
            if (bArr.length > 3) {
                int length = bArr.length - 3;
                byte[] bArr2 = new byte[length];
                this.data = bArr2;
                System.arraycopy(bArr, 3, bArr2, 0, length);
            }
            return bArr.length;
        }

        @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public byte[] toData() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(this.version);
            byteArrayOutputStream.write(this.packageCount);
            byteArrayOutputStream.write(this.packageId);
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
    }

    public ReceiveHealthDataCmd(Param param) {
        super(162, ReceiveHealthDataCmd.class.getSimpleName(), param);
    }
}
