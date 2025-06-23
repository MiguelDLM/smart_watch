package com.baidu.navisdk.adapter.struct;

import android.text.TextUtils;
import com.baidu.navisdk.adapter.struct.VehicleConstant;
import com.baidu.navisdk.module.routepreference.b;
import com.baidu.navisdk.util.common.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class BNTruckInfo extends b {
    private static final String TAG = "BNTruckInfo";
    private int axlesNumber;
    private float axlesWeight;
    private int emissionLimit;
    private float height;
    private float length;
    private float loadWeight;
    private String oilCost;
    private int plateType;
    private int powerType;
    private int truckType;
    private int truckUsage;
    private float weight;
    private float width;

    /* loaded from: classes7.dex */
    public static class Builder {
        private String plate = "";
        private int truckType = 0;
        private int truckUsage = 0;
        private int emissionLimit = 0;
        private int powerType = 0;
        private int plateType = 0;
        private float weight = 0.0f;
        private float length = 0.0f;
        private float width = 0.0f;
        private float height = 0.0f;
        private int axlesNumber = 0;
        private float axlesWeight = 0.0f;
        private String oilCost = "0";
        private float loadWeight = 0.0f;

        public Builder axlesNumber(int i) {
            this.axlesNumber = i;
            return this;
        }

        public Builder axlesWeight(float f) {
            this.axlesWeight = f;
            return this;
        }

        public BNTruckInfo build() {
            return new BNTruckInfo(this.plate, this.plateType, this.truckType, this.truckUsage, this.axlesNumber, this.height, this.width, this.weight, this.length, this.loadWeight, this.emissionLimit, this.axlesWeight, this.oilCost, this.powerType);
        }

        public Builder emissionLimit(int i) {
            this.emissionLimit = i;
            return this;
        }

        public Builder height(float f) {
            this.height = f;
            return this;
        }

        public Builder length(float f) {
            this.length = f;
            return this;
        }

        public Builder loadWeight(float f) {
            this.loadWeight = f;
            return this;
        }

        public Builder oilCost(String str) {
            this.oilCost = str;
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

        public Builder powerType(int i) {
            this.powerType = i;
            return this;
        }

        public Builder truckType(int i) {
            this.truckType = i;
            return this;
        }

        public Builder truckUsage(int i) {
            this.truckUsage = i;
            return this;
        }

        public Builder weight(float f) {
            this.weight = f;
            return this;
        }

        public Builder width(float f) {
            this.width = f;
            return this;
        }
    }

    public void copy(BNTruckInfo bNTruckInfo) {
        if (bNTruckInfo == null) {
            return;
        }
        setPlateInfo(bNTruckInfo.getPlate());
        this.emissionLimit = bNTruckInfo.emissionLimit;
        this.plateType = bNTruckInfo.plateType;
        this.truckType = bNTruckInfo.truckType;
        this.truckUsage = bNTruckInfo.truckUsage;
        this.axlesNumber = bNTruckInfo.axlesNumber;
        this.height = bNTruckInfo.height;
        this.width = bNTruckInfo.width;
        this.weight = bNTruckInfo.weight;
        this.length = bNTruckInfo.length;
        this.loadWeight = bNTruckInfo.loadWeight;
        this.axlesWeight = bNTruckInfo.axlesWeight;
        this.oilCost = bNTruckInfo.oilCost;
        this.powerType = bNTruckInfo.powerType;
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "copy: " + toString());
        }
    }

    @Override // com.baidu.navisdk.module.routepreference.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || BNTruckInfo.class != obj.getClass()) {
            return false;
        }
        BNTruckInfo bNTruckInfo = (BNTruckInfo) obj;
        if (getPlate() == null ? bNTruckInfo.getPlate() != null : !getPlate().equals(bNTruckInfo.getPlate())) {
            return false;
        }
        if (this.plateType == bNTruckInfo.plateType && this.truckType == bNTruckInfo.truckType && this.height == bNTruckInfo.height && this.width == bNTruckInfo.width && this.length == bNTruckInfo.length && this.weight == bNTruckInfo.weight && this.loadWeight == bNTruckInfo.loadWeight && this.oilCost.equals(bNTruckInfo.oilCost) && this.axlesWeight == bNTruckInfo.axlesWeight && this.axlesNumber == bNTruckInfo.axlesNumber && this.powerType == bNTruckInfo.powerType && this.emissionLimit == bNTruckInfo.emissionLimit && this.truckUsage == bNTruckInfo.truckUsage) {
            return true;
        }
        return false;
    }

    public int getAxlesNumber() {
        return this.axlesNumber;
    }

    public float getAxlesWeight() {
        return this.axlesWeight;
    }

    public int getEmissionLimit() {
        return this.emissionLimit;
    }

    public float getHeight() {
        return this.height;
    }

    public float getLength() {
        return this.length;
    }

    public float getLoadWeight() {
        return this.loadWeight;
    }

    public String getOilCost() {
        return this.oilCost;
    }

    public int getPlateType() {
        return this.plateType;
    }

    public int getPowerType() {
        return this.powerType;
    }

    public int getTruckType() {
        return this.truckType;
    }

    public int getTruckUsage() {
        return this.truckUsage;
    }

    public String getVehicleInfoJsonStr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(VehicleConstant.PlateBundleKey.PLATE, getPlate());
            jSONObject.put(VehicleConstant.PlateBundleKey.PLATE_COLOR, this.plateType);
            jSONObject.put(VehicleConstant.PlateBundleKey.TRUCK_TYPE, this.truckType);
            jSONObject.put(VehicleConstant.PlateBundleKey.AXLE_NUMBER, this.axlesNumber);
            jSONObject.put(VehicleConstant.PlateBundleKey.AXLE_WEIGHT, this.axlesWeight);
            jSONObject.put(VehicleConstant.PlateBundleKey.TRUCK_TALL, this.height);
            jSONObject.put(VehicleConstant.PlateBundleKey.TRUCK_WIDTH, this.width);
            jSONObject.put(VehicleConstant.PlateBundleKey.TRUCK_HEIGHT, this.length);
            jSONObject.put(VehicleConstant.PlateBundleKey.TOTAL_WEIGHT, this.weight);
            jSONObject.put(VehicleConstant.PlateBundleKey.LOAD_WEIGHT, this.loadWeight);
            jSONObject.put(VehicleConstant.PlateBundleKey.OIL_COST, this.oilCost);
            jSONObject.put(VehicleConstant.PlateBundleKey.POWER_TYPE, this.powerType);
            jSONObject.put(VehicleConstant.PlateBundleKey.EMIS_LIMIT, this.emissionLimit);
            jSONObject.put(VehicleConstant.PlateBundleKey.TRUCK_EXT, this.truckUsage);
        } catch (JSONException e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException(TAG, e);
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public float getWeight() {
        return this.weight;
    }

    public float getWidth() {
        return this.width;
    }

    @Override // com.baidu.navisdk.module.routepreference.b
    public int hashCode() {
        int i;
        if (getPlate() != null) {
            i = getPlate().hashCode();
        } else {
            i = 0;
        }
        return (((i * 31) + this.plateType) * 31) + this.truckType;
    }

    public boolean isValid() {
        if (!TextUtils.isEmpty(getPlate()) && this.height != 0.0f && this.width != 0.0f && this.weight != 0.0f && this.length != 0.0f && this.axlesNumber != 0 && this.loadWeight != 0.0f) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.module.routepreference.b
    public String toString() {
        return "BNTruckInfo{plate='" + getPlate() + ", plateType=" + this.plateType + ", truckType=" + this.truckType + ", axlesNumber=" + this.axlesNumber + ", loadWeight=" + this.loadWeight + ", weight=" + this.weight + ", length=" + this.length + ", width=" + this.width + ", length=" + this.height + ", axlesWeight=" + this.axlesWeight + ", oilCost=" + this.oilCost + ", emissionLimit=" + this.emissionLimit + ", powerType=" + this.powerType + '}';
    }

    private BNTruckInfo(String str, int i, int i2, int i3, int i4, float f, float f2, float f3, float f4, float f5, int i5, float f6, String str2, int i6) {
        this.truckType = 0;
        this.truckUsage = 0;
        this.emissionLimit = 0;
        this.powerType = 0;
        this.plateType = 0;
        this.weight = 0.0f;
        this.length = 0.0f;
        this.width = 0.0f;
        this.height = 0.0f;
        this.axlesNumber = 0;
        this.axlesWeight = 0.0f;
        this.oilCost = "0";
        this.loadWeight = 0.0f;
        setPlateInfo(str);
        this.plateType = i;
        this.truckType = i2;
        this.truckUsage = i3;
        this.axlesNumber = i4;
        this.height = f;
        this.width = f2;
        this.weight = f3;
        this.length = f4;
        this.loadWeight = f5;
        this.emissionLimit = i5;
        this.axlesWeight = f6;
        this.oilCost = str2;
        this.powerType = i6;
    }
}
