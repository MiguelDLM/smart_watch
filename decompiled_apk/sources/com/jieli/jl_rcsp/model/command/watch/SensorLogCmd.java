package com.jieli.jl_rcsp.model.command.watch;

import com.jieli.jl_rcsp.exception.ParseDataException;
import com.jieli.jl_rcsp.interfaces.cmd.IDataOp;
import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.model.base.CommandWithParam;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class SensorLogCmd extends CommandWithParam<Param> {
    public SensorLogCmd(Param param) {
        super(163, SensorLogCmd.class.getSimpleName(), param);
    }

    /* loaded from: classes10.dex */
    public static class Param extends BaseParameter implements IDataOp {
        public byte[] data;
        private int mask;
        public int type;

        public Param(byte[] bArr) throws ParseDataException {
            if (parse(bArr) < 0) {
                throw new ParseDataException(1, "Failed to parse data.", bArr);
            }
        }

        public int getMask() {
            return this.mask;
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            return toData();
        }

        @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public int parse(byte[] bArr) {
            this.data = new byte[0];
            if (bArr == null || bArr.length == 0) {
                return 0;
            }
            if (bArr.length < 4) {
                return -1;
            }
            this.type = CHexConver.bytesToInt(bArr, 0, 4);
            if (bArr.length > 4) {
                int length = bArr.length - 4;
                byte[] bArr2 = new byte[length];
                this.data = bArr2;
                System.arraycopy(bArr, 4, bArr2, 0, length);
            }
            return bArr.length;
        }

        @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public byte[] toData() {
            return CHexConver.intToBigBytes(this.mask);
        }

        public Param(int i) {
            this.mask = i;
        }
    }
}
