package com.baidu.navisdk.adapter.struct;

import com.baidu.navisdk.module.routepreference.b;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public final class BNMotorInfo extends b {
    private static final String TAG = "BNMotorInfo";
    private String displacement;
    private int motorType;
    private int plateType;

    /* loaded from: classes7.dex */
    public static class Builder {
        private String displacement;
        private int motorType;
        private String plate;
        private int plateType;

        public BNMotorInfo build() {
            return new BNMotorInfo(this.plate, this.motorType, this.plateType, this.displacement);
        }

        public Builder displacement(String str) {
            this.displacement = str;
            return this;
        }

        public Builder motorType(int i) {
            this.motorType = i;
            return this;
        }

        public Builder plate(String str) {
            this.plate = str;
            return this;
        }

        public Builder plateType(int i) {
            this.plateType = i;
            return this;
        }
    }

    public void clone(BNMotorInfo bNMotorInfo) {
        setPlateInfo(bNMotorInfo.getPlate());
        this.plateType = bNMotorInfo.plateType;
        this.displacement = bNMotorInfo.displacement;
        this.motorType = bNMotorInfo.motorType;
    }

    public void copy(BNMotorInfo bNMotorInfo) {
        if (bNMotorInfo == null) {
            return;
        }
        setPlateInfo(bNMotorInfo.getPlate());
        this.plateType = bNMotorInfo.plateType;
        this.motorType = bNMotorInfo.motorType;
        this.displacement = bNMotorInfo.displacement;
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "copy: " + toString());
        }
    }

    @Override // com.baidu.navisdk.module.routepreference.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || BNMotorInfo.class != obj.getClass()) {
            return false;
        }
        BNMotorInfo bNMotorInfo = (BNMotorInfo) obj;
        if (this.plateType != bNMotorInfo.plateType || this.motorType != bNMotorInfo.motorType) {
            return false;
        }
        if (getPlate() == null ? bNMotorInfo.getPlate() != null : !getPlate().equals(bNMotorInfo.getPlate())) {
            return false;
        }
        String str = this.displacement;
        if (str != null) {
            return str.equals(bNMotorInfo.displacement);
        }
        if (bNMotorInfo.displacement == null) {
            return true;
        }
        return false;
    }

    public String getDisplacement() {
        return this.displacement;
    }

    public int getMotorType() {
        return this.motorType;
    }

    public int getPlateType() {
        return this.plateType;
    }

    @Override // com.baidu.navisdk.module.routepreference.b
    public int hashCode() {
        int i;
        int i2 = 0;
        if (getPlate() != null) {
            i = getPlate().hashCode();
        } else {
            i = 0;
        }
        int i3 = ((i * 31) + this.plateType) * 31;
        String str = this.displacement;
        if (str != null) {
            i2 = str.hashCode();
        }
        return ((i3 + i2) * 31) + this.motorType;
    }

    @Override // com.baidu.navisdk.module.routepreference.b
    public String toString() {
        return "BNMotorInfo{plate='" + getPlate() + "', plateType=" + this.plateType + ", carCC=" + this.displacement + ", truckType=" + this.motorType + '}';
    }

    private BNMotorInfo(String str, int i, int i2, String str2) {
        setPlateInfo(str);
        this.plateType = i;
        this.motorType = i2;
        this.displacement = str2;
    }
}
