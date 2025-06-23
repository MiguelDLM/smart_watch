package com.jieli.jl_rcsp.model;

import com.jieli.jl_rcsp.model.device.DeviceConfiguration;
import com.jieli.jl_rcsp.model.device.settings.v0.DialExpandInfo;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class WatchConfigure extends DeviceConfiguration {
    private DialExpandInfo dialExpandInfo;
    private FunctionOption functionOption;
    private NecessaryFunc necessaryFunc;
    private SportHealthConfigure sportHealthConfigure;
    private SystemSetup systemSetup;

    /* loaded from: classes10.dex */
    public static class DataBlock {
        public byte[] data;
        public int offset;

        private DataBlock() {
        }
    }

    /* loaded from: classes10.dex */
    public static class FunctionOption {
        private final byte[] data;
        private boolean isSupportAICloud;
        private boolean isSupportAIDial;
        private boolean isSupportAlarmSetting;
        private boolean isSupportContacts;
        private boolean isSupportDialExpandInfo;
        private boolean isSupportFileBrowse;
        private boolean isSupportMessageSync;
        private boolean isSupportMusicTransfer;
        private boolean isSupportNetworkModule;
        private boolean isSupportPlatformInfo;
        private boolean isSupportSearchDevice;
        private boolean isSupportWeatherSync;
        private final int version;

        public FunctionOption(int i, byte[] bArr) throws RuntimeException {
            this.version = i;
            this.data = bArr;
            parseData(i, bArr);
        }

        private void parseData(int i, byte[] bArr) throws RuntimeException {
            if (i == 0) {
                if (bArr != null && bArr.length >= 1) {
                    byte b = bArr[0];
                    this.isSupportContacts = CHexConver.checkBitValue(b, 0);
                    this.isSupportFileBrowse = CHexConver.checkBitValue(b, 1);
                    this.isSupportMusicTransfer = CHexConver.checkBitValue(b, 2);
                    this.isSupportAlarmSetting = CHexConver.checkBitValue(b, 3);
                    this.isSupportMessageSync = CHexConver.checkBitValue(b, 4);
                    this.isSupportWeatherSync = CHexConver.checkBitValue(b, 5);
                    this.isSupportSearchDevice = CHexConver.checkBitValue(b, 6);
                    this.isSupportAICloud = CHexConver.checkBitValue(b, 7);
                    if (bArr.length <= 1) {
                        return;
                    }
                    byte b2 = bArr[1];
                    this.isSupportAIDial = CHexConver.checkBitValue(b2, 0);
                    this.isSupportPlatformInfo = CHexConver.checkBitValue(b2, 1);
                    this.isSupportNetworkModule = CHexConver.checkBitValue(b2, 2);
                    this.isSupportDialExpandInfo = CHexConver.checkBitValue(b2, 3);
                    return;
                }
                throw new RuntimeException(getClass().getSimpleName() + " : Data exception : " + CHexConver.byte2HexStr(bArr));
            }
            throw new RuntimeException("Unsupported version :  " + i);
        }

        public byte[] getData() {
            return this.data;
        }

        public int getVersion() {
            return this.version;
        }

        public boolean isSupportAICloud() {
            return this.isSupportAICloud;
        }

        public boolean isSupportAIDial() {
            return this.isSupportAIDial;
        }

        public boolean isSupportAlarmSetting() {
            return this.isSupportAlarmSetting;
        }

        public boolean isSupportContacts() {
            return this.isSupportContacts;
        }

        public boolean isSupportDialExpandInfo() {
            return this.isSupportDialExpandInfo;
        }

        public boolean isSupportFileBrowse() {
            return this.isSupportFileBrowse;
        }

        public boolean isSupportMessageSync() {
            return this.isSupportMessageSync;
        }

        public boolean isSupportMusicTransfer() {
            return this.isSupportMusicTransfer;
        }

        public boolean isSupportNetworkModule() {
            return this.isSupportNetworkModule;
        }

        public boolean isSupportPlatformInfo() {
            return this.isSupportPlatformInfo;
        }

        public boolean isSupportSearchDevice() {
            return this.isSupportSearchDevice;
        }

        public boolean isSupportWeatherSync() {
            return this.isSupportWeatherSync;
        }

        public String toString() {
            return "FunctionOption{isSupportContacts=" + this.isSupportContacts + ", isSupportFileBrowse=" + this.isSupportFileBrowse + ", isSupportMusicTransfer=" + this.isSupportMusicTransfer + ", isSupportAlarmSetting=" + this.isSupportAlarmSetting + ", isSupportMessageSync=" + this.isSupportMessageSync + ", isSupportWeatherSync=" + this.isSupportWeatherSync + ", isSupportSearchDevice=" + this.isSupportSearchDevice + ", isSupportAICloud=" + this.isSupportAICloud + ", isSupportAIDial=" + this.isSupportAIDial + ", isSupportPlatformInfo=" + this.isSupportPlatformInfo + ", isSupportNetworkModule=" + this.isSupportNetworkModule + ", isSupportDialExpandInfo=" + this.isSupportDialExpandInfo + '}';
        }
    }

    /* loaded from: classes10.dex */
    public static class NecessaryFunc {
        private final byte[] data;
        private boolean isSupportDialBrowse;
        private boolean isSupportDialOp;
        private boolean isSupportDialSwitch;
        private boolean isSupportOTA;
        private boolean isSupportResourceUpdate;
        private final int version;

        public NecessaryFunc(int i, byte[] bArr) throws RuntimeException {
            this.version = i;
            this.data = bArr;
            parseData(i, bArr);
        }

        private void parseData(int i, byte[] bArr) throws RuntimeException {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            if (i == 0) {
                if (bArr != null) {
                    boolean z5 = true;
                    if (bArr.length >= 1) {
                        byte b = bArr[0];
                        if ((b & 1) == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.isSupportOTA = z;
                        if (((b >> 1) & 1) == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        this.isSupportResourceUpdate = z2;
                        if (((b >> 2) & 1) == 1) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        this.isSupportDialOp = z3;
                        if (((b >> 3) & 1) == 1) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        this.isSupportDialSwitch = z4;
                        if (((b >> 4) & 1) != 1) {
                            z5 = false;
                        }
                        this.isSupportDialBrowse = z5;
                        return;
                    }
                }
                throw new RuntimeException(getClass().getSimpleName() + " : Data exception : " + CHexConver.byte2HexStr(bArr));
            }
            throw new RuntimeException("Unsupported version :  " + i);
        }

        public byte[] getData() {
            return this.data;
        }

        public int getVersion() {
            return this.version;
        }

        public boolean isSupportDialBrowse() {
            return this.isSupportDialBrowse;
        }

        public boolean isSupportDialOp() {
            return this.isSupportDialOp;
        }

        public boolean isSupportDialSwitch() {
            return this.isSupportDialSwitch;
        }

        public boolean isSupportOTA() {
            return this.isSupportOTA;
        }

        public boolean isSupportResourceUpdate() {
            return this.isSupportResourceUpdate;
        }

        public String toString() {
            return "NecessaryFunc{isSupportOTA=" + this.isSupportOTA + ", isSupportResourceUpdate=" + this.isSupportResourceUpdate + ", isSupportDialOp=" + this.isSupportDialOp + ", isSupportDialSwitch=" + this.isSupportDialSwitch + ", isSupportDialBrowse=" + this.isSupportDialBrowse + '}';
        }
    }

    /* loaded from: classes10.dex */
    public static class SystemSetup {
        private final byte[] data;
        private boolean isSupportBtDisconnectSetting;
        private boolean isSupportDNDMode;
        private boolean isSupportExerciseSetting;
        private boolean isSupportScreenSetting;
        private boolean isSupportVibrationSetting;
        private final int version;

        public SystemSetup(int i, byte[] bArr) throws RuntimeException {
            this.version = i;
            this.data = bArr;
            parseData(i, bArr);
        }

        private void parseData(int i, byte[] bArr) throws RuntimeException {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            if (i == 0) {
                if (bArr != null) {
                    boolean z5 = true;
                    if (bArr.length >= 1) {
                        byte b = bArr[0];
                        if ((b & 1) == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.isSupportScreenSetting = z;
                        if (((b >> 1) & 1) == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        this.isSupportVibrationSetting = z2;
                        if (((b >> 2) & 1) == 1) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        this.isSupportDNDMode = z3;
                        if (((b >> 3) & 1) == 1) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        this.isSupportExerciseSetting = z4;
                        if (((b >> 4) & 1) != 1) {
                            z5 = false;
                        }
                        this.isSupportBtDisconnectSetting = z5;
                        return;
                    }
                }
                throw new RuntimeException(getClass().getSimpleName() + " : Data exception : " + CHexConver.byte2HexStr(bArr));
            }
            throw new RuntimeException("Unsupported version :  " + i);
        }

        public byte[] getData() {
            return this.data;
        }

        public int getVersion() {
            return this.version;
        }

        public boolean isSupportBtDisconnectSetting() {
            return this.isSupportBtDisconnectSetting;
        }

        public boolean isSupportDNDMode() {
            return this.isSupportDNDMode;
        }

        public boolean isSupportExerciseSetting() {
            return this.isSupportExerciseSetting;
        }

        public boolean isSupportScreenSetting() {
            return this.isSupportScreenSetting;
        }

        public boolean isSupportVibrationSetting() {
            return this.isSupportVibrationSetting;
        }

        public String toString() {
            return "SystemSetup{isSupportScreenSetting=" + this.isSupportScreenSetting + ", isSupportVibrationSetting=" + this.isSupportVibrationSetting + ", isSupportDNDMode=" + this.isSupportDNDMode + ", isSupportExerciseSetting=" + this.isSupportExerciseSetting + ", isSupportBtDisconnectSetting=" + this.isSupportBtDisconnectSetting + '}';
        }
    }

    public WatchConfigure(int i, byte[] bArr) throws RuntimeException {
        super(0, i, bArr);
        parsePayload(bArr);
    }

    private void getDataBlock(byte[] bArr, DataBlock dataBlock) {
        if (bArr != null && dataBlock != null) {
            int i = dataBlock.offset;
            byte[] bArr2 = new byte[2];
            int i2 = 0;
            while (true) {
                int i3 = i + 2;
                if (i3 <= bArr.length) {
                    System.arraycopy(bArr, i, bArr2, 0, 2);
                    byte[] booleanArrayBig = CHexConver.getBooleanArrayBig(bArr2[1]);
                    i2 += 2;
                    if (CHexConver.byteToInt(booleanArrayBig[booleanArrayBig.length - 1]) == 0) {
                        break;
                    } else {
                        i = i3;
                    }
                } else {
                    i2 = 0;
                    break;
                }
            }
            if (i2 > 0) {
                byte[] bArr3 = new byte[i2];
                System.arraycopy(bArr, dataBlock.offset, bArr3, 0, i2);
                dataBlock.data = bArr3;
                return;
            }
            dataBlock.data = new byte[0];
        }
    }

    private int parseData(int i, byte[] bArr) throws RuntimeException {
        if (i == 0) {
            if (bArr != null && bArr.length >= 8) {
                DataBlock dataBlock = new DataBlock();
                int i2 = 0;
                for (int i3 = 0; i3 < 3; i3++) {
                    dataBlock.offset = i2;
                    getDataBlock(bArr, dataBlock);
                    byte[] bArr2 = dataBlock.data;
                    if (bArr2.length != 0) {
                        if (i3 != 0) {
                            if (i3 != 1) {
                                if (i3 == 2) {
                                    this.functionOption = new FunctionOption(i, bArr2);
                                }
                            } else {
                                this.systemSetup = new SystemSetup(i, bArr2);
                            }
                        } else {
                            this.necessaryFunc = new NecessaryFunc(i, bArr2);
                        }
                        i2 = dataBlock.offset + dataBlock.data.length;
                        dataBlock.offset = i2;
                    } else {
                        throw new RuntimeException("Data exception : not found block");
                    }
                }
                if (i2 + 2 < bArr.length) {
                    int length = bArr.length - i2;
                    byte[] bArr3 = new byte[length];
                    System.arraycopy(bArr, i2, bArr3, 0, length);
                    int i4 = i2 + length;
                    this.sportHealthConfigure = new SportHealthConfigure(i, bArr3);
                    return i4;
                }
                return i2;
            }
            throw new RuntimeException("Data exception : " + CHexConver.byte2HexStr(bArr));
        }
        throw new RuntimeException("Unsupported version :  " + i);
    }

    public DialExpandInfo getDialExpandInfo() {
        return this.dialExpandInfo;
    }

    public FunctionOption getFunctionOption() {
        return this.functionOption;
    }

    public NecessaryFunc getNecessaryFunc() {
        return this.necessaryFunc;
    }

    public SportHealthConfigure getSportHealthConfigure() {
        return this.sportHealthConfigure;
    }

    public SystemSetup getSystemSetup() {
        return this.systemSetup;
    }

    @Override // com.jieli.jl_rcsp.model.device.DeviceConfiguration
    public int parsePayload(byte[] bArr) throws RuntimeException {
        return parseData(getVersion(), bArr);
    }

    public WatchConfigure setDialExpandInfo(DialExpandInfo dialExpandInfo) {
        this.dialExpandInfo = dialExpandInfo;
        return this;
    }

    public String toString() {
        return "WatchConfigure{version=" + getVersion() + ", data=" + CHexConver.byte2HexStr(getData()) + ", necessaryFunc=" + this.necessaryFunc + ", systemSetup=" + this.systemSetup + ", functionOption=" + this.functionOption + ", sportHealthConfigure=" + this.sportHealthConfigure + ", dialExpandInfo=" + this.dialExpandInfo + '}';
    }
}
