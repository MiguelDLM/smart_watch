package com.jieli.jl_rcsp.model;

import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.RcspUtil;

/* loaded from: classes10.dex */
public class SportHealthConfigure {
    public static final int CONFIGURE_TYPE_ALTITUDE = 3;
    public static final int CONFIGURE_TYPE_BLOOD_OXYGEN = 2;
    public static final int CONFIGURE_TYPE_COMBINE_FUNC = 255;
    public static final int CONFIGURE_TYPE_GPS = 4;
    public static final int CONFIGURE_TYPE_GSENSOR = 0;
    public static final int CONFIGURE_TYPE_RATE = 1;
    public static final int CONFIGURE_TYPE_SPORT_MODE = 254;
    private AltitudeFunc altitudeFunc;
    private BloodOxygenFunc bloodOxygenFunc;
    private CombineFunc combineFunc;
    private GSensorFunc gSensorFunc;
    private GPSFunc gpsFunc;
    private RateFunc rateFunc;
    private SportModeFunc sportModeFunc;

    /* loaded from: classes10.dex */
    public static class AltitudeFunc extends BaseFunc {
        private boolean isOpen;

        public AltitudeFunc(int i, byte[] bArr) throws RuntimeException {
            super(3, i, bArr);
        }

        public boolean isOpen() {
            return this.isOpen;
        }

        @Override // com.jieli.jl_rcsp.model.SportHealthConfigure.BaseFunc
        public void parseData(int i, byte[] bArr) throws RuntimeException {
            if (i == 0) {
                if (bArr != null) {
                    boolean z = true;
                    if (bArr.length >= 1) {
                        if ((bArr[0] & 1) != 1) {
                            z = false;
                        }
                        this.isOpen = z;
                        return;
                    }
                }
                throw new RuntimeException(getClass().getSimpleName() + " : Data exception : " + CHexConver.byte2HexStr(bArr));
            }
            throw new RuntimeException("Unsupported version :  " + i);
        }

        public String toString() {
            return "AltitudeFunc{isOpen=" + this.isOpen + "} ";
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class BaseFunc {
        private final int type;

        public BaseFunc(int i, int i2, byte[] bArr) throws RuntimeException {
            this.type = i;
            parseData(i2, bArr);
        }

        public int getType() {
            return this.type;
        }

        public abstract void parseData(int i, byte[] bArr) throws RuntimeException;
    }

    /* loaded from: classes10.dex */
    public static class BloodOxygenFunc extends BaseFunc {
        private boolean isOpen;

        public BloodOxygenFunc(int i, byte[] bArr) throws RuntimeException {
            super(2, i, bArr);
        }

        public boolean isOpen() {
            return this.isOpen;
        }

        @Override // com.jieli.jl_rcsp.model.SportHealthConfigure.BaseFunc
        public void parseData(int i, byte[] bArr) throws RuntimeException {
            if (i == 0) {
                if (bArr != null) {
                    boolean z = true;
                    if (bArr.length >= 1) {
                        if ((bArr[0] & 1) != 1) {
                            z = false;
                        }
                        this.isOpen = z;
                        return;
                    }
                }
                throw new RuntimeException(getClass().getSimpleName() + " : Data exception : " + CHexConver.byte2HexStr(bArr));
            }
            throw new RuntimeException("Unsupported version :  " + i);
        }

        public String toString() {
            return "BloodOxygenFunc{isOpen=" + this.isOpen + "} ";
        }
    }

    /* loaded from: classes10.dex */
    public static class CombineFunc extends BaseFunc {
        private boolean isSupportAutoPressureDetection;
        private boolean isSupportFallDetection;
        private boolean isSupportHealthMonitoring;
        private boolean isSupportPersonalInfo;
        private boolean isSupportSedentaryReminder;
        private boolean isSupportSensorSettings;
        private boolean isSupportSleepDetection;
        private boolean isSupportSportRateReminder;

        public CombineFunc(int i, byte[] bArr) throws RuntimeException {
            super(255, i, bArr);
        }

        public boolean isSupportAutoPressureDetection() {
            return this.isSupportAutoPressureDetection;
        }

        public boolean isSupportFallDetection() {
            return this.isSupportFallDetection;
        }

        public boolean isSupportHealthMonitoring() {
            return this.isSupportHealthMonitoring;
        }

        public boolean isSupportPersonalInfo() {
            return this.isSupportPersonalInfo;
        }

        public boolean isSupportSedentaryReminder() {
            return this.isSupportSedentaryReminder;
        }

        public boolean isSupportSensorSettings() {
            return this.isSupportSensorSettings;
        }

        public boolean isSupportSleepDetection() {
            return this.isSupportSleepDetection;
        }

        public boolean isSupportSportRateReminder() {
            return this.isSupportSportRateReminder;
        }

        @Override // com.jieli.jl_rcsp.model.SportHealthConfigure.BaseFunc
        public void parseData(int i, byte[] bArr) throws RuntimeException {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            if (i == 0) {
                if (bArr != null) {
                    boolean z8 = true;
                    if (bArr.length >= 1) {
                        byte b = bArr[0];
                        if ((b & 1) == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.isSupportHealthMonitoring = z;
                        if (((b >> 1) & 1) == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        this.isSupportPersonalInfo = z2;
                        if (((b >> 2) & 1) == 1) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        this.isSupportSleepDetection = z3;
                        if (((b >> 3) & 1) == 1) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        this.isSupportSedentaryReminder = z4;
                        if (((b >> 4) & 1) == 1) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        this.isSupportSportRateReminder = z5;
                        if (((b >> 5) & 1) == 1) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        this.isSupportAutoPressureDetection = z6;
                        if (((b >> 6) & 1) == 1) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        this.isSupportFallDetection = z7;
                        if (((b >> 7) & 1) != 1) {
                            z8 = false;
                        }
                        this.isSupportSensorSettings = z8;
                        return;
                    }
                }
                throw new RuntimeException(getClass().getSimpleName() + " : Data exception : " + CHexConver.byte2HexStr(bArr));
            }
            throw new RuntimeException("Unsupported version :  " + i);
        }

        public String toString() {
            return "CombineFunc{isSupportHealthMonitoring=" + this.isSupportHealthMonitoring + ", isSupportPersonalInfo=" + this.isSupportPersonalInfo + ", isSupportSleepDetection=" + this.isSupportSleepDetection + ", isSupportSedentaryReminder=" + this.isSupportSedentaryReminder + ", isSupportSportRateReminder=" + this.isSupportSportRateReminder + ", isSupportAutoPressureDetection=" + this.isSupportAutoPressureDetection + ", isSupportFallDetection=" + this.isSupportFallDetection + ", isSupportSensorSettings=" + this.isSupportSensorSettings + "} ";
        }
    }

    /* loaded from: classes10.dex */
    public static class GPSFunc extends BaseFunc {
        private boolean isOpen;

        public GPSFunc(int i, byte[] bArr) throws RuntimeException {
            super(4, i, bArr);
        }

        public boolean isOpen() {
            return this.isOpen;
        }

        @Override // com.jieli.jl_rcsp.model.SportHealthConfigure.BaseFunc
        public void parseData(int i, byte[] bArr) throws RuntimeException {
            if (i == 0) {
                if (bArr != null) {
                    boolean z = true;
                    if (bArr.length >= 1) {
                        if ((bArr[0] & 1) != 1) {
                            z = false;
                        }
                        this.isOpen = z;
                        return;
                    }
                }
                throw new RuntimeException(getClass().getSimpleName() + " : Data exception : " + CHexConver.byte2HexStr(bArr));
            }
            throw new RuntimeException("Unsupported version :  " + i);
        }

        public String toString() {
            return "GPSFunc{isOpen=" + this.isOpen + "} ";
        }
    }

    /* loaded from: classes10.dex */
    public static class GSensorFunc extends BaseFunc {
        private boolean isEnableSportStep;
        private boolean isOpen;

        public GSensorFunc(int i, byte[] bArr) throws RuntimeException {
            super(0, i, bArr);
        }

        public boolean isEnableSportStep() {
            return this.isEnableSportStep;
        }

        public boolean isOpen() {
            return this.isOpen;
        }

        @Override // com.jieli.jl_rcsp.model.SportHealthConfigure.BaseFunc
        public void parseData(int i, byte[] bArr) throws RuntimeException {
            boolean z;
            if (i == 0) {
                if (bArr != null) {
                    boolean z2 = true;
                    if (bArr.length >= 1) {
                        byte b = bArr[0];
                        if ((b & 1) == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.isOpen = z;
                        if (((b >> 1) & 1) != 1) {
                            z2 = false;
                        }
                        this.isEnableSportStep = z2;
                        return;
                    }
                }
                throw new RuntimeException(getClass().getSimpleName() + " : Data exception : " + CHexConver.byte2HexStr(bArr));
            }
            throw new RuntimeException("Unsupported version :  " + i);
        }

        public String toString() {
            return "GSensorFunc{, isOpen=" + this.isOpen + ", isEnableSportStep=" + this.isEnableSportStep + "} ";
        }
    }

    /* loaded from: classes10.dex */
    public static class RateFunc extends BaseFunc {
        private boolean isEnableContinuousTest;
        private boolean isOpen;

        public RateFunc(int i, byte[] bArr) throws RuntimeException {
            super(1, i, bArr);
        }

        public boolean isEnableContinuousTest() {
            return this.isEnableContinuousTest;
        }

        public boolean isOpen() {
            return this.isOpen;
        }

        @Override // com.jieli.jl_rcsp.model.SportHealthConfigure.BaseFunc
        public void parseData(int i, byte[] bArr) throws RuntimeException {
            boolean z;
            if (i == 0) {
                if (bArr != null) {
                    boolean z2 = true;
                    if (bArr.length >= 1) {
                        byte b = bArr[0];
                        if ((b & 1) == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.isOpen = z;
                        if (((b >> 1) & 1) != 1) {
                            z2 = false;
                        }
                        this.isEnableContinuousTest = z2;
                        return;
                    }
                }
                throw new RuntimeException(getClass().getSimpleName() + " : Data exception : " + CHexConver.byte2HexStr(bArr));
            }
            throw new RuntimeException("Unsupported version :  " + i);
        }

        public String toString() {
            return "RateFunc{isOpen=" + this.isOpen + ", isEnableContinuousTest=" + this.isEnableContinuousTest + "} ";
        }
    }

    /* loaded from: classes10.dex */
    public static class SportModeFunc extends BaseFunc {
        private boolean isSupportCount;
        private boolean isSupportInDoor;
        private boolean isSupportOutDoor;
        private boolean isSupportRecord;

        public SportModeFunc(int i, byte[] bArr) throws RuntimeException {
            super(254, i, bArr);
        }

        public boolean isSupportCount() {
            return this.isSupportCount;
        }

        public boolean isSupportInDoor() {
            return this.isSupportInDoor;
        }

        public boolean isSupportOutDoor() {
            return this.isSupportOutDoor;
        }

        public boolean isSupportRecord() {
            return this.isSupportRecord;
        }

        @Override // com.jieli.jl_rcsp.model.SportHealthConfigure.BaseFunc
        public void parseData(int i, byte[] bArr) throws RuntimeException {
            boolean z;
            boolean z2;
            boolean z3;
            if (i == 0) {
                if (bArr != null) {
                    boolean z4 = true;
                    if (bArr.length >= 1) {
                        byte b = bArr[0];
                        if ((b & 1) == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.isSupportRecord = z;
                        if (((b >> 1) & 1) == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        this.isSupportCount = z2;
                        if (((b >> 2) & 1) == 1) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        this.isSupportOutDoor = z3;
                        if (((b >> 3) & 1) != 1) {
                            z4 = false;
                        }
                        this.isSupportInDoor = z4;
                        return;
                    }
                }
                throw new RuntimeException(getClass().getSimpleName() + " : Data exception : " + CHexConver.byte2HexStr(bArr));
            }
            throw new RuntimeException("Unsupported version :  " + i);
        }

        public String toString() {
            return "SportModeFunc{isSupportRecord=" + this.isSupportRecord + ", isSupportCount=" + this.isSupportCount + ", isSupportOutDoor=" + this.isSupportOutDoor + ", isSupportInDoor=" + this.isSupportInDoor + "} ";
        }
    }

    public SportHealthConfigure(int i, byte[] bArr) throws RuntimeException {
        parseData(i, bArr);
    }

    private void parseData(int i, byte[] bArr) throws RuntimeException {
        if (i == 0) {
            if (bArr != null && bArr.length >= 2) {
                for (LtvBean ltvBean : RcspUtil.parseLTVData(bArr)) {
                    byte[] data = ltvBean.getData();
                    int type = ltvBean.getType();
                    if (type != 254) {
                        if (type != 255) {
                            if (type != 0) {
                                if (type != 1) {
                                    if (type != 2) {
                                        if (type != 3) {
                                            if (type == 4) {
                                                this.gpsFunc = new GPSFunc(i, data);
                                            }
                                        } else {
                                            this.altitudeFunc = new AltitudeFunc(i, data);
                                        }
                                    } else {
                                        this.bloodOxygenFunc = new BloodOxygenFunc(i, data);
                                    }
                                } else {
                                    this.rateFunc = new RateFunc(i, data);
                                }
                            } else {
                                this.gSensorFunc = new GSensorFunc(i, data);
                            }
                        } else {
                            this.combineFunc = new CombineFunc(i, data);
                        }
                    } else {
                        this.sportModeFunc = new SportModeFunc(i, data);
                    }
                }
                return;
            }
            throw new RuntimeException("Data exception : " + CHexConver.byte2HexStr(bArr));
        }
        throw new RuntimeException("Unsupported version :  " + i);
    }

    public AltitudeFunc getAltitudeFunc() {
        return this.altitudeFunc;
    }

    public BloodOxygenFunc getBloodOxygenFunc() {
        return this.bloodOxygenFunc;
    }

    public CombineFunc getCombineFunc() {
        return this.combineFunc;
    }

    public GSensorFunc getGSensorFunc() {
        return this.gSensorFunc;
    }

    public GPSFunc getGpsFunc() {
        return this.gpsFunc;
    }

    public RateFunc getRateFunc() {
        return this.rateFunc;
    }

    public SportModeFunc getSportModeFunc() {
        return this.sportModeFunc;
    }

    public boolean isExistAltitude() {
        if (this.altitudeFunc != null) {
            return true;
        }
        return false;
    }

    public boolean isExistBloodOxygen() {
        if (this.bloodOxygenFunc != null) {
            return true;
        }
        return false;
    }

    public boolean isExistGSensor() {
        if (this.gSensorFunc != null) {
            return true;
        }
        return false;
    }

    public boolean isExistGps() {
        if (this.gpsFunc != null) {
            return true;
        }
        return false;
    }

    public boolean isExistRate() {
        if (this.rateFunc != null) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "SportHealthConfigure{gSensorFunc=" + this.gSensorFunc + ", rateFunc=" + this.rateFunc + ",bloodOxygenFunc=" + this.bloodOxygenFunc + ",altitudeFunc=" + this.altitudeFunc + ",gpsFunc=" + this.gpsFunc + ",sportModeFunc=" + this.sportModeFunc + ",combineFunc=" + this.combineFunc + '}';
    }
}
