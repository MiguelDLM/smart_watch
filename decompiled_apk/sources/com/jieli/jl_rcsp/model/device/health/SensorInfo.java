package com.jieli.jl_rcsp.model.device.health;

import com.jieli.jl_rcsp.model.device.AttrBean;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class SensorInfo implements IHealthSettingToAttr {
    private int flag;
    private final Sensor step = new Sensor(0, 1);
    private final Sensor heartRate = new Sensor(2, 3);
    private final Sensor bloodOxygen = new Sensor(4, 5);
    private final Sensor altitudePressure = new Sensor(6, 7);

    /* loaded from: classes10.dex */
    public class Sensor {
        private final int enablePos;
        private final int recordEnablePos;

        public Sensor(SensorInfo sensorInfo, int i) {
            this(i, i + 1);
        }

        public boolean isEnable() {
            if (((SensorInfo.this.flag >> this.enablePos) & 1) == 1) {
                return true;
            }
            return false;
        }

        public boolean isRecordEnable() {
            int i = SensorInfo.this.flag >> this.recordEnablePos;
            if (isEnable() && (i & 1) == 1) {
                return true;
            }
            return false;
        }

        public void setEnable(boolean z) {
            if (z) {
                SensorInfo.access$076(SensorInfo.this, 1 << this.enablePos);
            } else {
                SensorInfo.access$072(SensorInfo.this, ~(1 << this.enablePos));
            }
        }

        public void setRecordEnable(boolean z) {
            if (z) {
                SensorInfo.access$076(SensorInfo.this, 1 << this.recordEnablePos);
            } else {
                SensorInfo.access$072(SensorInfo.this, ~(1 << this.recordEnablePos));
            }
        }

        public String toString() {
            return "Sensor{enablePos=" + this.enablePos + ", recordEnablePos=" + this.recordEnablePos + '}';
        }

        public Sensor(int i, int i2) {
            this.enablePos = i;
            this.recordEnablePos = i2;
        }
    }

    public SensorInfo(int i) {
        this.flag = i;
    }

    public static /* synthetic */ int access$072(SensorInfo sensorInfo, int i) {
        int i2 = i & sensorInfo.flag;
        sensorInfo.flag = i2;
        return i2;
    }

    public static /* synthetic */ int access$076(SensorInfo sensorInfo, int i) {
        int i2 = i | sensorInfo.flag;
        sensorInfo.flag = i2;
        return i2;
    }

    public SensorInfo copy() {
        return new SensorInfo(this.flag);
    }

    public Sensor getAltitudePressureSensor() {
        return this.altitudePressure;
    }

    public Sensor getBloodOxygenSensor() {
        return this.bloodOxygen;
    }

    public Sensor getHeartRateSensor() {
        return this.heartRate;
    }

    public Sensor getStepSensor() {
        return this.step;
    }

    @Override // com.jieli.jl_rcsp.model.device.health.IHealthSettingToAttr
    public int getType() {
        return 1;
    }

    @Override // com.jieli.jl_rcsp.model.device.health.IHealthSettingToAttr
    public AttrBean toAttr() {
        AttrBean attrBean = new AttrBean();
        attrBean.setType((byte) getType());
        attrBean.setAttrData(CHexConver.shortToBigBytes((short) this.flag));
        return attrBean;
    }

    public String toString() {
        return "SensorInfo{flag=" + this.flag + ", step=" + this.step + ", heartRate=" + this.heartRate + ", bloodOxygen=" + this.bloodOxygen + ", altitudePressure=" + this.altitudePressure + '}';
    }
}
