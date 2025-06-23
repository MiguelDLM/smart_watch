package com.jieli.jl_rcsp.model.command;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.util.CHexConver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes10.dex */
public class AlarmExpandCmd extends CommandWithParamAndResponse<Param, Response> {

    /* loaded from: classes10.dex */
    public static class BellArg {
        public final byte[] data;

        public BellArg(byte[] bArr) {
            this.data = bArr;
        }

        private static byte enable(boolean z, byte b) {
            return (byte) (z ? b | 128 : b & Byte.MAX_VALUE);
        }

        public byte getAlarmBellTime() {
            return (byte) (this.data[4] & 31);
        }

        public byte getCount() {
            return (byte) (this.data[2] & 15);
        }

        public byte[] getData() {
            return this.data;
        }

        public byte getIndex() {
            return this.data[1];
        }

        public byte getInterval() {
            return (byte) (this.data[3] & 31);
        }

        public boolean isCanSetAlarmBellTime() {
            if ((this.data[4] & 128) == 128) {
                return true;
            }
            return false;
        }

        public boolean isCanSetCount() {
            if ((this.data[2] & 128) == 128) {
                return true;
            }
            return false;
        }

        public boolean isCanSetInterval() {
            if ((this.data[3] & 128) == 128) {
                return true;
            }
            return false;
        }

        public BellArg setAlarmBellTime(byte b) {
            byte[] bArr = this.data;
            bArr[4] = (byte) (b | (bArr[4] & 224));
            return this;
        }

        public BellArg setCanSetAlarmTime(boolean z) {
            byte[] bArr = this.data;
            bArr[4] = enable(z, bArr[4]);
            return this;
        }

        public BellArg setCanSetCount(boolean z) {
            byte[] bArr = this.data;
            bArr[2] = enable(z, bArr[2]);
            return this;
        }

        public BellArg setCanSetInterval(boolean z) {
            byte[] bArr = this.data;
            bArr[3] = enable(z, bArr[3]);
            return this;
        }

        public BellArg setCount(byte b) {
            byte[] bArr = this.data;
            bArr[2] = (byte) (b | (bArr[2] & 3824));
            return this;
        }

        public BellArg setInterval(byte b) {
            byte[] bArr = this.data;
            bArr[3] = (byte) (b | (bArr[3] & 224));
            return this;
        }

        public String toString() {
            return "BellArgs{data=" + CHexConver.byte2HexStr(this.data) + '}';
        }
    }

    /* loaded from: classes10.dex */
    public static class Param extends BaseParameter {
        private final byte[] data;
        private final byte op;

        public Param(byte b, byte[] bArr) {
            this.op = b;
            this.data = bArr;
        }

        public byte[] getData() {
            return this.data;
        }

        public byte getOp() {
            return this.op;
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            int length;
            byte[] bArr = this.data;
            if (bArr == null) {
                length = 0;
            } else {
                length = bArr.length;
            }
            byte[] bArr2 = new byte[length + 1];
            bArr2[0] = this.op;
            if (bArr != null) {
                System.arraycopy(bArr, 0, bArr2, 1, length);
            }
            return bArr2;
        }
    }

    /* loaded from: classes10.dex */
    public static class ReadRtcBellArgsParams extends Param {
        private final byte mask;

        public ReadRtcBellArgsParams(byte b) {
            super((byte) 0, new byte[]{b});
            this.mask = b;
        }

        public byte getMask() {
            return this.mask;
        }
    }

    /* loaded from: classes10.dex */
    public static class ReadRtcBellArgsResponse extends Response {
        private final List<BellArg> bellArgs;

        public ReadRtcBellArgsResponse(byte b, byte[] bArr) {
            super(b);
            this.bellArgs = fromBytes(bArr);
        }

        public static List<BellArg> fromBytes(byte[] bArr) {
            int i;
            int i2;
            ArrayList arrayList = new ArrayList();
            if (bArr != null && bArr.length >= 1) {
                int i3 = 0;
                while (i3 < bArr.length && (i2 = (i = bArr[i3] + 1) + i3) <= bArr.length && i > 1) {
                    byte[] bArr2 = new byte[i];
                    System.arraycopy(bArr, i3, bArr2, 0, i);
                    arrayList.add(new BellArg(bArr2));
                    i3 = i2;
                }
            }
            return arrayList;
        }

        public List<BellArg> getBellArg() {
            return this.bellArgs;
        }

        @Override // com.jieli.jl_rcsp.model.base.CommonResponse
        public String toString() {
            StringBuilder sb = new StringBuilder();
            List<BellArg> list = this.bellArgs;
            if (list != null) {
                Iterator<BellArg> it = list.iterator();
                while (it.hasNext()) {
                    sb.append(it.next().toString());
                    sb.append("\t");
                }
            }
            return "ReadRtcBellArgsResponse{bellArgs=" + ((Object) sb) + '}';
        }
    }

    /* loaded from: classes10.dex */
    public static class Response extends CommonResponse {
        private final byte op;

        public Response(byte b) {
            this.op = b;
        }

        public byte getOp() {
            return this.op;
        }
    }

    /* loaded from: classes10.dex */
    public static class SetRtcBellArgsParams extends Param {
        private final BellArg bellArg;

        public SetRtcBellArgsParams(BellArg bellArg) {
            super((byte) 1, bellArg.data);
            this.bellArg = bellArg;
        }

        public BellArg getBellArg() {
            return this.bellArg;
        }
    }

    public AlarmExpandCmd(Param param) {
        super(37, AlarmExpandCmd.class.getSimpleName(), param);
    }
}
