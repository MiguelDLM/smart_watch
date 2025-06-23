package com.google.android.gms.fitness.data;

import androidx.annotation.VisibleForTesting;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public final class zza {

    @VisibleForTesting
    public static final Map zza;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(DataType.TYPE_ACTIVITY_SEGMENT, DataType.AGGREGATE_ACTIVITY_SUMMARY);
        hashMap.put(DataType.TYPE_BASAL_METABOLIC_RATE, DataType.AGGREGATE_BASAL_METABOLIC_RATE_SUMMARY);
        hashMap.put(HealthDataTypes.TYPE_BLOOD_GLUCOSE, HealthDataTypes.AGGREGATE_BLOOD_GLUCOSE_SUMMARY);
        hashMap.put(HealthDataTypes.TYPE_BLOOD_PRESSURE, HealthDataTypes.AGGREGATE_BLOOD_PRESSURE_SUMMARY);
        hashMap.put(DataType.TYPE_BODY_FAT_PERCENTAGE, DataType.AGGREGATE_BODY_FAT_PERCENTAGE_SUMMARY);
        hashMap.put(HealthDataTypes.TYPE_BODY_TEMPERATURE, HealthDataTypes.AGGREGATE_BODY_TEMPERATURE_SUMMARY);
        hashMap.put(DataType.TYPE_CALORIES_EXPENDED, DataType.AGGREGATE_CALORIES_EXPENDED);
        DataType dataType = HealthDataTypes.TYPE_CERVICAL_MUCUS;
        hashMap.put(dataType, dataType);
        DataType dataType2 = HealthDataTypes.TYPE_CERVICAL_POSITION;
        hashMap.put(dataType2, dataType2);
        hashMap.put(DataType.TYPE_DISTANCE_DELTA, DataType.AGGREGATE_DISTANCE_DELTA);
        hashMap.put(DataType.TYPE_HEART_POINTS, DataType.AGGREGATE_HEART_POINTS);
        hashMap.put(DataType.TYPE_HEART_RATE_BPM, DataType.AGGREGATE_HEART_RATE_SUMMARY);
        hashMap.put(DataType.TYPE_HEIGHT, DataType.AGGREGATE_HEIGHT_SUMMARY);
        hashMap.put(DataType.TYPE_HYDRATION, DataType.AGGREGATE_HYDRATION);
        hashMap.put(DataType.TYPE_LOCATION_SAMPLE, DataType.AGGREGATE_LOCATION_BOUNDING_BOX);
        DataType dataType3 = HealthDataTypes.TYPE_MENSTRUATION;
        hashMap.put(dataType3, dataType3);
        hashMap.put(DataType.TYPE_MOVE_MINUTES, DataType.AGGREGATE_MOVE_MINUTES);
        hashMap.put(DataType.TYPE_NUTRITION, DataType.AGGREGATE_NUTRITION_SUMMARY);
        DataType dataType4 = HealthDataTypes.TYPE_OVULATION_TEST;
        hashMap.put(dataType4, dataType4);
        hashMap.put(HealthDataTypes.TYPE_OXYGEN_SATURATION, HealthDataTypes.AGGREGATE_OXYGEN_SATURATION_SUMMARY);
        hashMap.put(DataType.TYPE_POWER_SAMPLE, DataType.AGGREGATE_POWER_SUMMARY);
        hashMap.put(DataType.TYPE_SPEED, DataType.AGGREGATE_SPEED_SUMMARY);
        hashMap.put(DataType.TYPE_STEP_COUNT_DELTA, DataType.AGGREGATE_STEP_COUNT_DELTA);
        DataType dataType5 = HealthDataTypes.TYPE_VAGINAL_SPOTTING;
        hashMap.put(dataType5, dataType5);
        hashMap.put(DataType.TYPE_WEIGHT, DataType.AGGREGATE_WEIGHT_SUMMARY);
        zza = Collections.unmodifiableMap(hashMap);
    }
}
