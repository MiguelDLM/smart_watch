package com.jieli.jl_rcsp.model.command.watch;

import com.jieli.jl_rcsp.exception.ParseDataException;
import com.jieli.jl_rcsp.interfaces.cmd.IDataOp;
import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.RcspUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes10.dex */
public class SportsInfoStatusSyncCmd extends CommandBase<Param, Response> {
    public static final byte OP_APP_STOP_SPORTS = 2;
    public static final byte OP_FIRMWARE_STOP_SPORTS = 3;
    public static final byte OP_PAUSE_SPORTS = 4;
    public static final byte OP_READ_REAL_DATA = 6;
    public static final byte OP_READ_SPORTS_INFO = 0;
    public static final byte OP_RESUME_SPORTS = 5;
    public static final byte OP_SET_REAL_DATA_READ_INTERVAL = 7;
    public static final byte OP_START_SPORTS = 1;
    public static final byte SPORTS_STATUS_RUNNING = 1;
    public static final byte SPORTS_STATUS_STOP = 0;
    public static final byte SPORTS_TYPE_INDOOR = 2;
    public static final byte SPORTS_TYPE_OUTDOOR = 1;

    /* loaded from: classes10.dex */
    public static class AppStopSportsParam extends Param {
        public AppStopSportsParam(byte[] bArr) throws ParseDataException {
            super(bArr);
        }

        @Override // com.jieli.jl_rcsp.model.command.watch.SportsInfoStatusSyncCmd.Param
        public int getParamType() {
            return 2;
        }

        public AppStopSportsParam() {
            super((byte) 2, new byte[0]);
        }
    }

    /* loaded from: classes10.dex */
    public static class AppStopSportsResponse extends Response {
        public short fileId;
        public int fileSize;
        public int restoreTime;
        public int stopTime;
        public byte[] strengthIntervalTimer;

        public AppStopSportsResponse(byte[] bArr) throws ParseDataException {
            super(bArr);
        }

        private static byte[] convertResponseData(int i, int i2, short s, int i3, byte[] bArr) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(CHexConver.intToBigBytes(i));
                byteArrayOutputStream.write(CHexConver.intToBigBytes(i2));
                byteArrayOutputStream.write(CHexConver.shortToBigBytes(s));
                byteArrayOutputStream.write(CHexConver.int2byte2(i3));
                if (bArr != null && bArr.length > 0) {
                    byteArrayOutputStream.write(bArr);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }

        @Override // com.jieli.jl_rcsp.model.command.watch.SportsInfoStatusSyncCmd.Response
        public int getResponseType() {
            return 2;
        }

        @Override // com.jieli.jl_rcsp.model.command.watch.SportsInfoStatusSyncCmd.Response, com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public int parse(byte[] bArr) {
            this.strengthIntervalTimer = new byte[0];
            int parse = super.parse(bArr);
            if (parse <= 0) {
                return 0;
            }
            byte[] responseData = getResponseData();
            if (responseData != null && responseData.length != 0) {
                if (responseData.length < 12) {
                    return -1;
                }
                this.stopTime = CHexConver.bytesToInt(responseData, 0, 4);
                this.restoreTime = CHexConver.bytesToInt(responseData, 4, 4);
                this.fileId = CHexConver.bytesToShort(responseData, 8);
                this.fileSize = CHexConver.bytesToInt(responseData, 10, 2);
                if (12 < responseData.length) {
                    int length = responseData.length - 12;
                    byte[] bArr2 = new byte[length];
                    this.strengthIntervalTimer = bArr2;
                    System.arraycopy(responseData, 12, bArr2, 0, length);
                }
            }
            return parse;
        }

        @Override // com.jieli.jl_rcsp.model.base.CommonResponse
        public String toString() {
            return "AppStopExerciseResponse{stopTime=" + this.stopTime + ", restoreTime=" + this.restoreTime + ", strengthIntervalTimer=" + Arrays.toString(this.strengthIntervalTimer) + '}';
        }

        public AppStopSportsResponse(int i, int i2, short s, int i3, byte[] bArr) {
            super(2, convertResponseData(i, i2, s, i3, bArr));
            this.stopTime = i;
            this.restoreTime = i2;
            this.fileId = s;
            this.fileSize = i3;
            this.strengthIntervalTimer = bArr;
        }
    }

    /* loaded from: classes10.dex */
    public static class PauseSportsParam extends Param {
        public PauseSportsParam(byte[] bArr) throws ParseDataException {
            super(bArr);
        }

        @Override // com.jieli.jl_rcsp.model.command.watch.SportsInfoStatusSyncCmd.Param
        public int getParamType() {
            return 4;
        }

        public PauseSportsParam() {
            super((byte) 4, new byte[0]);
        }
    }

    /* loaded from: classes10.dex */
    public static class ReadRealDataParam extends Param {
        public ReadRealDataParam(byte[] bArr) throws ParseDataException {
            super(bArr);
        }

        @Override // com.jieli.jl_rcsp.model.command.watch.SportsInfoStatusSyncCmd.Param
        public int getParamType() {
            return 6;
        }

        public ReadRealDataParam() {
            super((byte) 6, new byte[0]);
        }
    }

    /* loaded from: classes10.dex */
    public static class ReadRealDataResponse extends Response {
        public float distance;
        public int duration;
        public int exerciseStatus;
        public int heartRate;
        public int kcal;
        public float pace;
        public float speed;
        public int step;
        public int stepFreq;
        public int stride;
        public byte version;

        public ReadRealDataResponse(byte[] bArr) throws ParseDataException {
            super(bArr);
        }

        private static byte[] convertResponseData(byte b, int i, float f, int i2, float f2, int i3, int i4, int i5, int i6, int i7) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(b);
                byteArrayOutputStream.write(CHexConver.intToBigBytes(i));
                byteArrayOutputStream.write(CHexConver.int2byte2((int) f));
                byteArrayOutputStream.write(CHexConver.intToBigBytes(i2));
                byteArrayOutputStream.write(CHexConver.int2byte2((int) f2));
                byteArrayOutputStream.write(CHexConver.int2byte2(i3));
                byteArrayOutputStream.write(CHexConver.int2byte2(i4));
                byteArrayOutputStream.write(CHexConver.int2byte2(i5));
                byteArrayOutputStream.write(i6);
                byteArrayOutputStream.write(i7);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }

        @Override // com.jieli.jl_rcsp.model.command.watch.SportsInfoStatusSyncCmd.Response
        public int getResponseType() {
            return 6;
        }

        @Override // com.jieli.jl_rcsp.model.command.watch.SportsInfoStatusSyncCmd.Response, com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public int parse(byte[] bArr) {
            int parse = super.parse(bArr);
            if (parse <= 0) {
                return 0;
            }
            byte[] responseData = getResponseData();
            if (responseData != null && responseData.length != 0) {
                if (responseData.length < 21) {
                    return -1;
                }
                ByteBuffer wrap = ByteBuffer.wrap(responseData);
                this.version = wrap.get();
                this.step = wrap.getInt();
                this.distance = SportsInfoStatusSyncCmd.getFormatValue(wrap.getShort() * 0.01f);
                this.duration = wrap.getInt();
                float formatValue = SportsInfoStatusSyncCmd.getFormatValue(wrap.getShort() * 0.01f);
                this.speed = formatValue;
                float f = 0.0f;
                if (formatValue != 0.0f) {
                    f = SportsInfoStatusSyncCmd.getFormatValue((1.0f / formatValue) * 3600.0f);
                }
                this.pace = f;
                this.kcal = wrap.getShort();
                this.stepFreq = wrap.getShort();
                this.stride = wrap.getShort();
                this.exerciseStatus = CHexConver.byteToInt(wrap.get());
                this.heartRate = CHexConver.byteToInt(wrap.get());
            }
            return parse;
        }

        @Override // com.jieli.jl_rcsp.model.base.CommonResponse
        public String toString() {
            return "UpdateRealDataParam{version=" + ((int) this.version) + ", step=" + this.step + ", distance=" + this.distance + ", duration=" + this.duration + ", speed=" + this.speed + ", pace=" + this.pace + ", kcal=" + this.kcal + ", stepFreq=" + this.stepFreq + ", stride=" + this.stride + ", exerciseStatus=" + this.exerciseStatus + ", heartRate=" + this.heartRate + '}';
        }

        public ReadRealDataResponse(byte b, int i, float f, int i2, float f2, int i3, int i4, int i5, int i6, int i7) {
            super(6, convertResponseData(b, i, f, i2, f2, i3, i4, i5, i6, i7));
            this.version = b;
            this.step = i;
            this.distance = f;
            this.duration = i2;
            this.speed = f2;
            this.pace = f2 != 0.0f ? SportsInfoStatusSyncCmd.getFormatValue((1.0f / f2) * 3600.0f) : 0.0f;
            this.kcal = i3;
            this.stepFreq = i4;
            this.stride = i5;
            this.exerciseStatus = i6;
            this.heartRate = i7;
        }
    }

    /* loaded from: classes10.dex */
    public static class ReadSportsInfoParam extends Param {
        public ReadSportsInfoParam(byte[] bArr) throws ParseDataException {
            super(bArr);
        }

        @Override // com.jieli.jl_rcsp.model.command.watch.SportsInfoStatusSyncCmd.Param
        public int getParamType() {
            return 0;
        }

        public ReadSportsInfoParam() {
            super((byte) 0, new byte[0]);
        }
    }

    /* loaded from: classes10.dex */
    public static class ResumeSportsParam extends Param {
        public ResumeSportsParam(byte[] bArr) throws ParseDataException {
            super(bArr);
        }

        @Override // com.jieli.jl_rcsp.model.command.watch.SportsInfoStatusSyncCmd.Param
        public int getParamType() {
            return 5;
        }

        public ResumeSportsParam() {
            super((byte) 5, new byte[0]);
        }
    }

    /* loaded from: classes10.dex */
    public static class SetReadRealDataIntervalParam extends Param {
        public short interval;

        public SetReadRealDataIntervalParam(byte[] bArr) throws ParseDataException {
            super(bArr);
        }

        public short getInterval() {
            return this.interval;
        }

        @Override // com.jieli.jl_rcsp.model.command.watch.SportsInfoStatusSyncCmd.Param
        public int getParamType() {
            return 7;
        }

        @Override // com.jieli.jl_rcsp.model.command.watch.SportsInfoStatusSyncCmd.Param, com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public int parse(byte[] bArr) {
            int parse = super.parse(bArr);
            if (parse <= 0) {
                return parse;
            }
            byte[] data = getData();
            if (data != null && data.length != 0) {
                if (data.length < 2) {
                    return -1;
                }
                this.interval = CHexConver.bytesToShort(data, 0);
            }
            return parse;
        }

        public SetReadRealDataIntervalParam(short s) {
            super((byte) 7, CHexConver.shortToBigBytes(s));
            this.interval = s;
        }
    }

    /* loaded from: classes10.dex */
    public static class StartSportsParam extends Param {
        public byte type;

        public StartSportsParam(byte[] bArr) throws ParseDataException {
            super(bArr);
        }

        @Override // com.jieli.jl_rcsp.model.command.watch.SportsInfoStatusSyncCmd.Param
        public int getParamType() {
            return 1;
        }

        public byte getType() {
            return this.type;
        }

        @Override // com.jieli.jl_rcsp.model.command.watch.SportsInfoStatusSyncCmd.Param, com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public int parse(byte[] bArr) {
            int parse = super.parse(bArr);
            if (parse <= 0) {
                return parse;
            }
            byte[] data = getData();
            if (data != null && data.length != 0) {
                this.type = data[0];
            }
            return parse;
        }

        public StartSportsParam(byte b) {
            super((byte) 1, new byte[]{b});
            this.type = b;
        }
    }

    public SportsInfoStatusSyncCmd(Param param) {
        this(2, param);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float getFormatValue(float f) {
        try {
            return Float.parseFloat(RcspUtil.formatString("%.2f", Float.valueOf(f)));
        } catch (Exception e) {
            e.printStackTrace();
            return f;
        }
    }

    public SportsInfoStatusSyncCmd(int i, Param param) {
        super(166, SportsInfoStatusSyncCmd.class.getSimpleName(), i);
        setParam(param);
    }

    /* loaded from: classes10.dex */
    public static class FirmwareStopSportsParam extends Param {
        public short fileId;
        public int fileSize;
        public int restoreTime;
        public int stopTime;
        public byte[] strengthIntervalTimer;

        public FirmwareStopSportsParam(int i, int i2, short s, int i3, byte[] bArr) {
            super((byte) 3, convertData(i, i2, s, i3, bArr));
            this.stopTime = i;
            this.restoreTime = i2;
            this.fileId = s;
            this.fileSize = i3;
            this.strengthIntervalTimer = bArr;
        }

        private static byte[] convertData(int i, int i2, short s, int i3, byte[] bArr) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(CHexConver.intToBigBytes(i));
                byteArrayOutputStream.write(CHexConver.intToBigBytes(i2));
                byteArrayOutputStream.write(CHexConver.shortToBigBytes(s));
                byteArrayOutputStream.write(CHexConver.int2byte2(i3));
                if (bArr != null && bArr.length > 0) {
                    byteArrayOutputStream.write(bArr);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }

        public short getFileId() {
            return this.fileId;
        }

        public int getFileSize() {
            return this.fileSize;
        }

        @Override // com.jieli.jl_rcsp.model.command.watch.SportsInfoStatusSyncCmd.Param
        public int getParamType() {
            return 3;
        }

        public int getRestoreTime() {
            return this.restoreTime;
        }

        public int getStopTime() {
            return this.stopTime;
        }

        public byte[] getStrengthIntervalTimer() {
            return this.strengthIntervalTimer;
        }

        @Override // com.jieli.jl_rcsp.model.command.watch.SportsInfoStatusSyncCmd.Param, com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public int parse(byte[] bArr) {
            this.strengthIntervalTimer = new byte[0];
            int parse = super.parse(bArr);
            if (parse <= 0) {
                return parse;
            }
            byte[] data = getData();
            if (data != null && data.length != 0) {
                if (data.length < 12) {
                    return -1;
                }
                this.stopTime = CHexConver.bytesToInt(data, 0, 4);
                this.restoreTime = CHexConver.bytesToInt(data, 4, 4);
                this.fileId = CHexConver.bytesToShort(data, 8);
                this.fileSize = CHexConver.bytesToInt(data, 10, 2);
                if (12 < data.length) {
                    int length = data.length - 12;
                    byte[] bArr2 = new byte[length];
                    this.strengthIntervalTimer = bArr2;
                    System.arraycopy(data, 12, bArr2, 0, length);
                }
            }
            return parse;
        }

        public FirmwareStopSportsParam(byte[] bArr) throws ParseDataException {
            super(bArr);
        }
    }

    /* loaded from: classes10.dex */
    public static class Param extends BaseParameter implements IDataOp {
        private byte[] data;
        private byte op;

        public Param(byte[] bArr) throws ParseDataException {
            int paramType;
            int parse = parse(bArr);
            if (parse >= 0) {
                if (parse > 0 && (paramType = getParamType()) != -1 && getOp() != paramType) {
                    throw new ParseDataException(2, String.format(Locale.ENGLISH, "Operation[%d] does not match the target operation[%d].", Byte.valueOf(getOp()), Integer.valueOf(paramType)));
                }
                return;
            }
            throw new ParseDataException(1, "Failure to parse data. size = " + parse, this.data);
        }

        public byte[] getData() {
            return this.data;
        }

        public byte getOp() {
            return this.op;
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            return toData();
        }

        public int getParamType() {
            return -1;
        }

        public int parse(byte[] bArr) {
            this.data = new byte[0];
            if (bArr == null || bArr.length == 0) {
                return 0;
            }
            this.op = bArr[0];
            if (bArr.length > 1) {
                int length = bArr.length - 1;
                byte[] bArr2 = new byte[length];
                this.data = bArr2;
                System.arraycopy(bArr, 1, bArr2, 0, length);
            }
            return bArr.length;
        }

        @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public byte[] toData() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(this.op);
            byte[] bArr = this.data;
            if (bArr != null && bArr.length > 0) {
                try {
                    byteArrayOutputStream.write(bArr);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return byteArrayOutputStream.toByteArray();
        }

        public Param(byte b, byte[] bArr) {
            this.op = b;
            this.data = bArr == null ? new byte[0] : bArr;
        }
    }

    /* loaded from: classes10.dex */
    public static class ReadSportsInfoResponse extends Response {
        public boolean hasGps;
        public byte heartRateMode;
        public int id;
        public int readReadDataInterval;
        public byte status;
        public byte type;

        public ReadSportsInfoResponse(byte b, byte b2, int i, boolean z, byte b3, int i2) {
            super(0, convertResponseData(b, b2, i, z, b3, i2));
            this.type = b;
            this.status = b2;
            this.id = i;
            this.hasGps = z;
            this.heartRateMode = b3;
            this.readReadDataInterval = i2;
        }

        private static byte[] convertResponseData(byte b, byte b2, int i, boolean z, byte b3, int i2) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(b);
                byteArrayOutputStream.write(b2);
                byteArrayOutputStream.write(CHexConver.intToBigBytes(i));
                byteArrayOutputStream.write(z ? 1 : 0);
                byteArrayOutputStream.write(b3);
                byteArrayOutputStream.write(CHexConver.int2byte2(i2));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }

        @Override // com.jieli.jl_rcsp.model.command.watch.SportsInfoStatusSyncCmd.Response
        public int getResponseType() {
            return 0;
        }

        @Override // com.jieli.jl_rcsp.model.command.watch.SportsInfoStatusSyncCmd.Response, com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public int parse(byte[] bArr) {
            int parse = super.parse(bArr);
            if (parse <= 0) {
                return parse;
            }
            byte[] responseData = getResponseData();
            if (responseData != null && responseData.length != 0) {
                if (responseData.length < 10) {
                    return -1;
                }
                ByteBuffer wrap = ByteBuffer.wrap(responseData);
                this.type = wrap.get();
                this.status = wrap.get();
                this.id = wrap.getInt();
                boolean z = true;
                if (wrap.get() != 1) {
                    z = false;
                }
                this.hasGps = z;
                this.heartRateMode = wrap.get();
                this.readReadDataInterval = wrap.getShort();
            }
            return parse;
        }

        @Override // com.jieli.jl_rcsp.model.base.CommonResponse
        public String toString() {
            return "ReadExerciseInfoResponse{mode=" + ((int) this.type) + ", status=" + ((int) this.status) + ", id=" + this.id + ", hasGps=" + this.hasGps + ", heartRateMode=" + ((int) this.heartRateMode) + '}';
        }

        public ReadSportsInfoResponse(byte[] bArr) throws ParseDataException {
            super(bArr);
        }
    }

    /* loaded from: classes10.dex */
    public static class Response extends CommonResponse implements IDataOp {
        public int op;
        public byte[] responseData;

        public Response(byte[] bArr) throws ParseDataException {
            int responseType;
            int parse = parse(bArr);
            if (parse >= 0) {
                if (parse > 0 && (responseType = getResponseType()) != -1 && responseType != getOp()) {
                    throw new ParseDataException(2, String.format(Locale.ENGLISH, "Operation[%d] does not match the target operation[%d].", Integer.valueOf(getOp()), Integer.valueOf(responseType)));
                }
                setRawData(bArr);
                return;
            }
            throw new ParseDataException(1, "Failure to parse data. size = " + parse, bArr);
        }

        public int getOp() {
            return this.op;
        }

        public byte[] getResponseData() {
            return this.responseData;
        }

        public int getResponseType() {
            return -1;
        }

        public int parse(byte[] bArr) {
            this.responseData = new byte[0];
            if (bArr == null || bArr.length == 0) {
                return 0;
            }
            this.op = CHexConver.byteToInt(bArr[0]);
            if (bArr.length > 1) {
                int length = bArr.length - 1;
                byte[] bArr2 = new byte[length];
                this.responseData = bArr2;
                System.arraycopy(bArr, 1, bArr2, 0, length);
            }
            return bArr.length;
        }

        @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public byte[] toData() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(this.op);
            byte[] bArr = this.responseData;
            if (bArr != null && bArr.length > 0) {
                try {
                    byteArrayOutputStream.write(bArr);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return byteArrayOutputStream.toByteArray();
        }

        public Response(int i, byte[] bArr) {
            this.op = i;
            this.responseData = bArr;
        }
    }
}
