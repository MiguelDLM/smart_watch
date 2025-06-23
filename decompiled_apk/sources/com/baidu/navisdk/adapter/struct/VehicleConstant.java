package com.baidu.navisdk.adapter.struct;

/* loaded from: classes7.dex */
public interface VehicleConstant {

    /* loaded from: classes7.dex */
    public interface EmissionStandard {
        public static final int INVALID = 0;
        public static final int S1 = 1;
        public static final int S2 = 2;
        public static final int S3 = 3;
        public static final int S4 = 4;
        public static final int S5 = 5;
        public static final int S6 = 6;
    }

    /* loaded from: classes7.dex */
    public interface MotorType {
        public static final int ELECTRIC = 1;
        public static final int INVALID = 2;
        public static final int OIL = 0;
    }

    /* loaded from: classes7.dex */
    public interface PlateBundleKey {
        public static final String AXLE_NUMBER = "axleNumber";
        public static final String AXLE_WEIGHT = "axleWeight";
        public static final String EMIS_LIMIT = "emisLimit";
        public static final String LOAD_WEIGHT = "loadWeight";
        public static final String OIL_COST = "oilCost";
        public static final String PLATE = "navigationPlate";
        public static final String PLATE_COLOR = "plateColor";
        public static final String POWER_TYPE = "powerType";
        public static final String TOTAL_WEIGHT = "totalWeight";
        public static final String TRUCK_EXT = "truckExt";
        public static final String TRUCK_HEIGHT = "truckHeight";
        public static final String TRUCK_TALL = "truckTall";
        public static final String TRUCK_TYPE = "truckType";
        public static final String TRUCK_WIDTH = "truckWidth";
    }

    /* loaded from: classes7.dex */
    public interface PlateType {
        public static final int BLACK = 4;
        public static final int BLUE = 2;
        public static final int GREEN = 3;
        public static final int INVALID = 0;
        public static final int WHITE = 5;
        public static final int YELLOW = 1;
    }

    /* loaded from: classes7.dex */
    public interface PowerType {
        public static final int DIESEL = 2;
        public static final int ELECTRIC = 3;
        public static final int INVALID = 0;
        public static final int MIX = 4;
        public static final int OIL = 1;
    }

    /* loaded from: classes7.dex */
    public interface TruckType {
        public static final int CROSS_COUNTRY_TRUCK = 7;
        public static final int HEAVY = 4;
        public static final int INVALID = 0;
        public static final int LIGHT = 2;
        public static final int MEDIUM = 3;
        public static final int MINI = 1;
        public static final int PRIVATE_TRUCK = 6;
        public static final int TRAILER = 5;
    }

    /* loaded from: classes7.dex */
    public interface TruckUsage {
        public static final int DANGER = 17;
        public static final int DEFAULT = 0;
    }
}
