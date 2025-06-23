package com.realsil.sdk.dfu.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.realsil.sdk.core.bluetooth.utils.BluetoothHelper;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.j.a;
import com.realsil.sdk.dfu.model.ConnectionParameters;
import java.util.Locale;

/* loaded from: classes11.dex */
public class DfuConfig implements Parcelable {
    public static final int BATTERY_LEVEL_FORMAT_PERCENTAGE = 0;
    public static final int BATTERY_LEVEL_FORMAT_VALUE = 1;
    public static final int CHANNEL_TYPE_GATT = 0;
    public static final int CHANNEL_TYPE_SPP = 1;
    public static final int CHANNEL_TYPE_USB = 2;
    public static final int COMPLETE_ACTION_REMOVE_BOND = 1;
    public static final long CONNECTION_PARAMETERS_UPDATE_TIMEOUT = 10000;
    public static final Parcelable.Creator<DfuConfig> CREATOR = new Parcelable.Creator<DfuConfig>() { // from class: com.realsil.sdk.dfu.model.DfuConfig.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DfuConfig createFromParcel(Parcel parcel) {
            return new DfuConfig(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DfuConfig[] newArray(int i) {
            return new DfuConfig[i];
        }
    };
    public static final int EA_CLOSE_GATT = 4;
    public static final int ERROR_ACTION_DISCONNECT = 1;
    public static final int ERROR_ACTION_REFRESH_DEVICE = 2;
    public static final int FILE_LOCATION_ASSETS = 1;
    public static final int FILE_LOCATION_SDCARD = 0;
    public static final byte IMAGE_VERIFY_IC_TYPE = 1;
    public static final byte IMAGE_VERIFY_NA = 0;
    public static final byte IMAGE_VERIFY_SECTION_SIZE = 4;
    public static final byte IMAGE_VERIFY_VERSION = 2;
    public static final int MAX_POWER_LEVER = 110;
    public static final int MIN_POWER_LEVER = 30;
    public static final int MIN_POWER_LEVER_FOR_HUAWEI = 140;
    public static final int PHY_HIGH_SPEED = 1;
    public static final int PHY_LONG_RANGE_X2 = 2;
    public static final int PHY_LONG_RANGE_X4 = 3;
    public static final int PHY_NORMAL = 0;
    public int A;
    public int B;
    public long C;
    public boolean D;
    public boolean E;
    public int F;
    public int G;
    public String H;
    public String I;
    public String J;
    public String K;
    public ConnectionParameters L;
    public String M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public boolean S;
    public int T;
    public boolean U;
    public boolean V;
    public boolean W;
    public long X;
    public int Y;

    /* renamed from: a, reason: collision with root package name */
    public int f19579a;
    public int b;
    public int c;
    public int d;
    public String e;
    public int f;
    public String g;
    public String h;
    public int i;
    public int j;
    public int k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public Long p;
    public int q;
    public int r;
    public byte[] s;
    public int t;
    public boolean u;
    public boolean v;
    public boolean w;
    public int x;
    public boolean y;
    public int z;

    public DfuConfig() {
        this(0);
    }

    public void addCompleteAction(int i) {
        this.q = i | this.q;
    }

    public void addErrorAction(int i) {
        this.r = i | this.r;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Long getActiveImageDelayTime() {
        return this.p;
    }

    public String getAddress() {
        return this.e;
    }

    public int getBatteryLevelFormat() {
        return this.A;
    }

    public int getChannelType() {
        return this.f19579a;
    }

    public ConnectionParameters getConnectionParameters() {
        return this.L;
    }

    public long getConnectionTimeout() {
        return this.C;
    }

    public String getDfuControlPointUuid() {
        return this.K;
    }

    public String getDfuDataUuid() {
        return this.J;
    }

    public String getDfuServiceUuid() {
        return this.I;
    }

    public int getFileIndicator() {
        return this.i;
    }

    public int getFileLocation() {
        return this.f;
    }

    public String getFilePath() {
        return this.g;
    }

    public String getFileSuffix() {
        if (TextUtils.isEmpty(this.h)) {
            return a.FILE_SUFFIX;
        }
        return this.h;
    }

    public int getFlowControlInterval() {
        return this.x;
    }

    public int getHandoverTimeout() {
        return this.R;
    }

    public int getImageVerifyIndicator() {
        return this.j;
    }

    public int getLatencyTimeout() {
        return this.F;
    }

    public String getLocalName() {
        return this.M;
    }

    public int getLogLevel() {
        return this.Q;
    }

    public int getLowBatteryThreshold() {
        return this.z;
    }

    public int getManufacturerId() {
        return this.G;
    }

    public int getMaxPacketSize() {
        return this.t;
    }

    public long getNotificationTimeout() {
        return this.X;
    }

    public String getOtaServiceUuid() {
        return this.H;
    }

    public int getOtaWorkMode() {
        return this.c;
    }

    public int getPhy() {
        return this.T;
    }

    public int getPrimaryIcType() {
        return this.d;
    }

    public int getPrimaryMtuSize() {
        return this.t;
    }

    public int getProtocolType() {
        return this.b;
    }

    public int getRetransConnectTimes() {
        return this.B;
    }

    public byte[] getSecretKey() {
        return this.s;
    }

    public int getUsbEndPointInAddr() {
        return this.N;
    }

    public int getUsbEndPointOutAddr() {
        return this.O;
    }

    public int getVersionCheckMode() {
        return this.k;
    }

    public int getVpId() {
        return this.Y;
    }

    public boolean isAutomaticActiveEnabled() {
        return this.l;
    }

    public boolean isBatteryCheckEnabled() {
        return this.y;
    }

    public boolean isBondConnectionEnabled() {
        return this.D;
    }

    public boolean isBreakpointResumeEnabled() {
        return this.n;
    }

    public boolean isBufferCheckMtuUpdateEnabled() {
        return this.v;
    }

    public boolean isCheckOtaResultEnabled() {
        return this.W;
    }

    public boolean isCompleteActionEnabled(int i) {
        if ((this.q & i) == i) {
            return true;
        }
        return false;
    }

    public boolean isConParamUpdateLatencyEnabled() {
        return this.E;
    }

    public boolean isConnectBackEnabled() {
        return this.V;
    }

    public boolean isErrorActionEnabled(int i) {
        if ((this.r & i) == i) {
            return true;
        }
        return false;
    }

    public boolean isFlowControlEnabled() {
        return this.w;
    }

    public boolean isHid() {
        return this.U;
    }

    public boolean isIcCheckEnabled() {
        if ((this.j & 1) == 1) {
            return true;
        }
        return false;
    }

    public boolean isMtuUpdateEnabled() {
        return this.u;
    }

    public boolean isSectionSizeCheckEnabled() {
        if ((this.j & 4) == 4) {
            return true;
        }
        return false;
    }

    public boolean isThroughputEnabled() {
        return this.m;
    }

    public boolean isVersionCheckEnabled() {
        if ((this.j & 2) == 2) {
            return true;
        }
        return false;
    }

    public boolean isWaitActiveCmdAckEnabled() {
        return this.o;
    }

    public boolean isWaitDisconnectWhenEnterOtaMode() {
        return this.S;
    }

    public void removeCompleteAction(int i) {
        this.q = (~i) & this.q;
    }

    public void removeErrorAction(int i) {
        this.r = (~i) & this.r;
    }

    public void setActiveImageDelayTime(Long l) {
        this.p = l;
    }

    public void setAddress(String str) {
        this.e = str;
    }

    public void setAutomaticActiveEnabled(boolean z) {
        this.l = z;
    }

    public void setBatteryCheckEnabled(boolean z) {
        this.y = z;
    }

    public void setBatteryLevelFormat(int i) {
        this.A = i;
    }

    public void setBondConnectionEnabled(boolean z) {
        this.D = z;
    }

    public void setBreakpointResumeEnabled(boolean z) {
        this.n = z;
    }

    public void setBufferCheckMtuUpdateEnabled(boolean z) {
        this.v = z;
    }

    public void setChannelType(int i) {
        this.f19579a = i;
    }

    public void setCheckOtaResultEnabled(boolean z) {
        this.W = z;
    }

    public void setConParamUpdateLatencyEnabled(boolean z) {
        this.E = z;
    }

    public void setConnectBackEnabled(boolean z) {
        this.V = z;
    }

    public void setConnectionParameters(ConnectionParameters connectionParameters) {
        this.L = connectionParameters;
    }

    public void setConnectionTimeout(long j) {
        this.C = j;
    }

    @Deprecated
    public void setControlPointUuid(String str) {
        setDfuControlPointUuid(str);
    }

    @Deprecated
    public void setDataUuid(String str) {
        setDfuDataUuid(str);
    }

    public void setDfuControlPointUuid(String str) {
        this.K = str;
    }

    public void setDfuDataUuid(String str) {
        this.J = str;
    }

    public void setDfuServiceUuid(String str) {
        this.I = str;
    }

    public void setFileIndicator(int i) {
        this.i = i;
    }

    public void setFileLocation(int i) {
        this.f = i;
    }

    public void setFilePath(String str) {
        this.g = str;
    }

    public void setFileSuffix(String str) {
        this.h = str;
    }

    public void setFlowControlEnabled(boolean z) {
        this.w = z;
    }

    public void setFlowControlInterval(int i) {
        this.x = i;
    }

    public void setHandoverTimeout(int i) {
        this.R = i;
    }

    public void setHid(boolean z) {
        this.U = z;
    }

    public void setIcCheckEnabled(boolean z) {
        if (z) {
            this.j |= 1;
        } else {
            this.j &= -2;
        }
    }

    public void setImageVerifyIndicator(int i) {
        this.j = i;
    }

    public void setLatencyTimeout(int i) {
        this.F = i;
    }

    public void setLocalName(String str) {
        this.M = str;
    }

    public void setLogLevel(int i) {
        this.Q = i;
    }

    public void setLowBatteryThreshold(int i) {
        this.z = i;
    }

    public void setManufacturerId(int i) {
        this.G = i;
    }

    public void setMaxPacketSize(int i) {
        this.t = i;
    }

    public void setMtuUpdateEnabled(boolean z) {
        this.u = z;
    }

    public void setNotificationTimeout(long j) {
        if (j >= 0 && j <= 60000) {
            this.X = j;
        } else {
            ZLogger.w(String.format(Locale.US, "timeout in millis, should range from 0 ~ %d", 60000L));
        }
    }

    public void setOtaServiceUuid(String str) {
        this.H = str;
    }

    public void setOtaWorkMode(int i) {
        this.c = i;
    }

    public void setPhy(int i) {
        this.T = i;
    }

    public void setPrimaryIcType(int i) {
        this.d = i;
    }

    public void setPrimaryMtuSize(int i) {
        this.t = i;
    }

    public void setProtocolType(int i) {
        this.b = i;
    }

    public void setRetransConnectTimes(int i) {
        this.B = i;
    }

    public void setSecretKey(byte[] bArr) {
        this.s = bArr;
    }

    public void setSectionSizeCheckEnabled(boolean z) {
        if (z) {
            this.j |= 4;
        } else {
            this.j &= -5;
        }
    }

    public void setServiceUuid(String str) {
        setDfuServiceUuid(str);
    }

    public void setThroughputEnabled(boolean z) {
        this.m = z;
    }

    public void setUsbEndPointInAddr(int i) {
        this.N = i;
    }

    public void setUsbEndPointOutAddr(int i) {
        this.O = i;
    }

    public void setVersionCheckEnabled(boolean z) {
        if (z) {
            this.j |= 2;
        } else {
            this.j &= -3;
        }
    }

    public void setVersionCheckMode(int i) {
        this.k = i;
    }

    public void setVpId(int i) {
        this.Y = i;
    }

    public void setWaitActiveCmdAckEnabled(boolean z) {
        this.o = z;
    }

    public void setWaitDisconnectWhenEnterOtaMode(boolean z) {
        this.S = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DfuConfig{");
        sb.append(String.format("manufacturerId=0x%04X, primaryIcType=%s\n", Integer.valueOf(this.G), com.realsil.sdk.dfu.k.a.a(this.d)));
        sb.append(String.format("address==%s, localName=%s, isHid=%b\n", BluetoothHelper.formatAddress(this.e, true), this.M, Boolean.valueOf(this.U)));
        Locale locale = Locale.US;
        sb.append(String.format(locale, "logLevel=%d\n", Integer.valueOf(this.Q)));
        sb.append(String.format("mProtocolType=0x%04X, mChannelType=0x%02x, workMode=0x%04X\n", Integer.valueOf(this.b), Integer.valueOf(this.f19579a), Integer.valueOf(this.c)));
        int i = this.f19579a;
        if (i == 0) {
            sb.append(String.format("\tOtaService=%s\n", this.H));
            sb.append(String.format("\tDfuService=%s\n", this.I));
            sb.append(String.format("\tDfuData==%s\n", this.J));
            sb.append(String.format("\tDfuControlPoint=%s\n", this.K));
            ConnectionParameters connectionParameters = this.L;
            if (connectionParameters != null) {
                sb.append(String.format("\t%s\n", connectionParameters.toString()));
            } else {
                ZLogger.v("not set connectionParameters");
            }
        } else if (i == 2) {
            sb.append(String.format("\tEndPointInAddr=0x%02X, EndPointOutAddr=0x%02X\n", Integer.valueOf(this.N), Integer.valueOf(this.O)));
        }
        if (this.c == 24) {
            sb.append(String.format("\n\tvpId=0x%04X", Integer.valueOf(this.Y)));
        }
        sb.append(String.format(locale, "handoverTimeout=%ds, notificationTimeout=%dms\n", Integer.valueOf(this.R), Long.valueOf(this.X)));
        sb.append(String.format(locale, "file location=%d, path==%s, suffix=%s\n", Integer.valueOf(this.f), this.g, this.h));
        sb.append(String.format("\tfileIndicator=0x%08x, imageVerifyIndicator=0x%08x\n", Integer.valueOf(this.i), Integer.valueOf(this.j)));
        sb.append(String.format(locale, "\tversionCheck=%b, mode=%d, icCheck=%b, sectionSizeCheck=%b\n, batteryCheck=%b, connectBack=%b, checkOtaResult=%b\n", Boolean.valueOf(isVersionCheckEnabled()), Integer.valueOf(getVersionCheckMode()), Boolean.valueOf(isIcCheckEnabled()), Boolean.valueOf(isSectionSizeCheckEnabled()), Boolean.valueOf(this.y), Boolean.valueOf(this.V), Boolean.valueOf(this.W)));
        sb.append(String.format(locale, "conParamUpdateLatency=%b, latencyTimeout=%d", Boolean.valueOf(this.E), Integer.valueOf(this.F)));
        boolean z = this.y;
        if (z) {
            sb.append(String.format(locale, "\nlowBatteryThreshold=%d, batteryLevelFormat=%d", Integer.valueOf(this.z), Integer.valueOf(this.A)));
        } else {
            sb.append(String.format(locale, "batteryCheckEnabled=%b", Boolean.valueOf(z)));
        }
        sb.append(String.format(locale, "\nmtuUpdate=%b,bufferCheckMtuUpdateEnabled=%b,primaryMtuSize=%d", Boolean.valueOf(this.u), Boolean.valueOf(this.v), Integer.valueOf(this.t)));
        sb.append(String.format("\nthroughput=%b, breakpointResume=%b,waitActiveCmdAck=%b, activeImageDelayTime=%d", Boolean.valueOf(this.m), Boolean.valueOf(this.n), Boolean.valueOf(this.o), this.p));
        if (this.w) {
            sb.append(String.format(locale, ", flowControlInterval=%d ms", Integer.valueOf(this.x * 50)));
        }
        sb.append(String.format("\ncompleteAction=0x%04X, ", Integer.valueOf(this.q)));
        sb.append(String.format("\nerrorAction=0x%04X, ERROR_ACTION_DISCONNECT=%b, ERROR_ACTION_REFRESH_DEVICE=%b, EA_CLOSE_GATT=%b", Integer.valueOf(this.r), Boolean.valueOf(isErrorActionEnabled(1)), Boolean.valueOf(isErrorActionEnabled(2)), Boolean.valueOf(isErrorActionEnabled(4))));
        sb.append(String.format(locale, "\nretransConnectTimes=%d, connectionTimeout=%d", Integer.valueOf(this.B), Long.valueOf(this.C)));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f19579a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeString(this.e);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
        parcel.writeInt(this.k);
        parcel.writeByte(this.l ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.n ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.o ? (byte) 1 : (byte) 0);
        if (this.p == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(this.p.longValue());
        }
        parcel.writeInt(this.q);
        parcel.writeInt(this.r);
        parcel.writeByteArray(this.s);
        parcel.writeInt(this.t);
        parcel.writeByte(this.u ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.v ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.w ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.x);
        parcel.writeByte(this.y ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.z);
        parcel.writeInt(this.A);
        parcel.writeInt(this.B);
        parcel.writeLong(this.C);
        parcel.writeByte(this.D ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.E ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.F);
        parcel.writeInt(this.G);
        parcel.writeString(this.H);
        parcel.writeString(this.I);
        parcel.writeString(this.J);
        parcel.writeString(this.K);
        parcel.writeParcelable(this.L, i);
        parcel.writeString(this.M);
        parcel.writeInt(this.N);
        parcel.writeInt(this.O);
        parcel.writeInt(this.P);
        parcel.writeInt(this.Q);
        parcel.writeInt(this.R);
        parcel.writeByte(this.S ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.T);
        parcel.writeByte(this.U ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.V ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.W ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.X);
        parcel.writeInt(this.Y);
    }

    public DfuConfig(int i) {
        this.f19579a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 3;
        this.f = 0;
        this.h = a.FILE_SUFFIX;
        this.i = -1;
        this.j = 7;
        this.k = 0;
        this.l = true;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = 0L;
        this.q = 0;
        this.r = 7;
        this.t = 20;
        this.u = false;
        this.v = true;
        this.w = false;
        this.x = 0;
        this.y = false;
        this.z = 30;
        this.A = 0;
        this.B = 3;
        this.C = 32000L;
        this.D = false;
        this.E = true;
        this.F = 6;
        this.G = 93;
        this.H = "0000d0ff-3c17-d293-8e48-14fe2e4da212";
        this.I = "00006287-3c17-d293-8e48-14fe2e4da212";
        this.J = "00006387-3c17-d293-8e48-14fe2e4da212";
        this.K = "00006487-3c17-d293-8e48-14fe2e4da212";
        this.N = 130;
        this.O = 2;
        this.P = 2;
        this.Q = 0;
        this.R = 6;
        this.S = true;
        this.T = 0;
        this.X = 10000L;
        this.c = i;
        this.L = new ConnectionParameters.Builder().minInterval(6).maxInterval(17).latency(0).timeout(500).build();
        ZLogger.v("init default:" + this.L.toString());
    }

    public DfuConfig(String str, String str2) {
        this.f19579a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 3;
        this.f = 0;
        this.h = a.FILE_SUFFIX;
        this.i = -1;
        this.j = 7;
        this.k = 0;
        this.l = true;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = 0L;
        this.q = 0;
        this.r = 7;
        this.t = 20;
        this.u = false;
        this.v = true;
        this.w = false;
        this.x = 0;
        this.y = false;
        this.z = 30;
        this.A = 0;
        this.B = 3;
        this.C = 32000L;
        this.D = false;
        this.E = true;
        this.F = 6;
        this.G = 93;
        this.H = "0000d0ff-3c17-d293-8e48-14fe2e4da212";
        this.I = "00006287-3c17-d293-8e48-14fe2e4da212";
        this.J = "00006387-3c17-d293-8e48-14fe2e4da212";
        this.K = "00006487-3c17-d293-8e48-14fe2e4da212";
        this.N = 130;
        this.O = 2;
        this.P = 2;
        this.Q = 0;
        this.R = 6;
        this.S = true;
        this.T = 0;
        this.X = 10000L;
        this.e = str;
        this.f = 0;
        this.g = str2;
        this.L = new ConnectionParameters.Builder().minInterval(6).maxInterval(17).latency(0).timeout(500).build();
        ZLogger.v("init default:" + this.L.toString());
    }

    public DfuConfig(Parcel parcel) {
        this.f19579a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 3;
        this.f = 0;
        this.h = a.FILE_SUFFIX;
        this.i = -1;
        this.j = 7;
        this.k = 0;
        this.l = true;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = 0L;
        this.q = 0;
        this.r = 7;
        this.t = 20;
        this.u = false;
        this.v = true;
        this.w = false;
        this.x = 0;
        this.y = false;
        this.z = 30;
        this.A = 0;
        this.B = 3;
        this.C = 32000L;
        this.D = false;
        this.E = true;
        this.F = 6;
        this.G = 93;
        this.H = "0000d0ff-3c17-d293-8e48-14fe2e4da212";
        this.I = "00006287-3c17-d293-8e48-14fe2e4da212";
        this.J = "00006387-3c17-d293-8e48-14fe2e4da212";
        this.K = "00006487-3c17-d293-8e48-14fe2e4da212";
        this.N = 130;
        this.O = 2;
        this.P = 2;
        this.Q = 0;
        this.R = 6;
        this.S = true;
        this.T = 0;
        this.X = 10000L;
        this.f19579a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readString();
        this.f = parcel.readInt();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readInt();
        this.j = parcel.readInt();
        this.k = parcel.readInt();
        this.l = parcel.readByte() != 0;
        this.m = parcel.readByte() != 0;
        this.n = parcel.readByte() != 0;
        this.o = parcel.readByte() != 0;
        if (parcel.readByte() == 0) {
            this.p = null;
        } else {
            this.p = Long.valueOf(parcel.readLong());
        }
        this.q = parcel.readInt();
        this.r = parcel.readInt();
        this.s = parcel.createByteArray();
        this.t = parcel.readInt();
        this.u = parcel.readByte() != 0;
        this.v = parcel.readByte() != 0;
        this.w = parcel.readByte() != 0;
        this.x = parcel.readInt();
        this.y = parcel.readByte() != 0;
        this.z = parcel.readInt();
        this.A = parcel.readInt();
        this.B = parcel.readInt();
        this.C = parcel.readLong();
        this.D = parcel.readByte() != 0;
        this.E = parcel.readByte() != 0;
        this.F = parcel.readInt();
        this.G = parcel.readInt();
        this.H = parcel.readString();
        this.I = parcel.readString();
        this.J = parcel.readString();
        this.K = parcel.readString();
        this.L = (ConnectionParameters) parcel.readParcelable(ConnectionParameters.class.getClassLoader());
        this.M = parcel.readString();
        this.N = parcel.readInt();
        this.O = parcel.readInt();
        this.P = parcel.readInt();
        this.Q = parcel.readInt();
        this.R = parcel.readInt();
        this.S = parcel.readByte() != 0;
        this.T = parcel.readInt();
        this.U = parcel.readByte() != 0;
        this.V = parcel.readByte() != 0;
        this.W = parcel.readByte() != 0;
        this.X = parcel.readLong();
        this.Y = parcel.readInt();
    }
}
