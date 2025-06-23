package com.google.android.gms.fitness.data;

import androidx.annotation.NonNull;

/* loaded from: classes9.dex */
public final class HealthFields {
    public static final int BLOOD_GLUCOSE_SPECIMEN_SOURCE_CAPILLARY_BLOOD = 2;
    public static final int BLOOD_GLUCOSE_SPECIMEN_SOURCE_INTERSTITIAL_FLUID = 1;
    public static final int BLOOD_GLUCOSE_SPECIMEN_SOURCE_PLASMA = 3;
    public static final int BLOOD_GLUCOSE_SPECIMEN_SOURCE_SERUM = 4;
    public static final int BLOOD_GLUCOSE_SPECIMEN_SOURCE_TEARS = 5;
    public static final int BLOOD_GLUCOSE_SPECIMEN_SOURCE_WHOLE_BLOOD = 6;
    public static final int BLOOD_PRESSURE_MEASUREMENT_LOCATION_LEFT_UPPER_ARM = 3;
    public static final int BLOOD_PRESSURE_MEASUREMENT_LOCATION_LEFT_WRIST = 1;
    public static final int BLOOD_PRESSURE_MEASUREMENT_LOCATION_RIGHT_UPPER_ARM = 4;
    public static final int BLOOD_PRESSURE_MEASUREMENT_LOCATION_RIGHT_WRIST = 2;
    public static final int BODY_POSITION_LYING_DOWN = 3;
    public static final int BODY_POSITION_SEMI_RECUMBENT = 4;
    public static final int BODY_POSITION_SITTING = 2;
    public static final int BODY_POSITION_STANDING = 1;
    public static final int BODY_TEMPERATURE_MEASUREMENT_LOCATION_AXILLARY = 1;
    public static final int BODY_TEMPERATURE_MEASUREMENT_LOCATION_FINGER = 2;
    public static final int BODY_TEMPERATURE_MEASUREMENT_LOCATION_FOREHEAD = 3;
    public static final int BODY_TEMPERATURE_MEASUREMENT_LOCATION_ORAL = 4;
    public static final int BODY_TEMPERATURE_MEASUREMENT_LOCATION_RECTAL = 5;
    public static final int BODY_TEMPERATURE_MEASUREMENT_LOCATION_TEMPORAL_ARTERY = 6;
    public static final int BODY_TEMPERATURE_MEASUREMENT_LOCATION_TOE = 7;
    public static final int BODY_TEMPERATURE_MEASUREMENT_LOCATION_TYMPANIC = 8;
    public static final int BODY_TEMPERATURE_MEASUREMENT_LOCATION_VAGINAL = 10;
    public static final int BODY_TEMPERATURE_MEASUREMENT_LOCATION_WRIST = 9;
    public static final int CERVICAL_DILATION_CLOSED = 1;
    public static final int CERVICAL_DILATION_MEDIUM = 2;
    public static final int CERVICAL_DILATION_OPEN = 3;
    public static final int CERVICAL_FIRMNESS_FIRM = 3;
    public static final int CERVICAL_FIRMNESS_MEDIUM = 2;
    public static final int CERVICAL_FIRMNESS_SOFT = 1;
    public static final int CERVICAL_MUCUS_AMOUNT_HEAVY = 3;
    public static final int CERVICAL_MUCUS_AMOUNT_LIGHT = 1;
    public static final int CERVICAL_MUCUS_AMOUNT_MEDIUM = 2;
    public static final int CERVICAL_MUCUS_TEXTURE_CREAMY = 3;
    public static final int CERVICAL_MUCUS_TEXTURE_DRY = 1;
    public static final int CERVICAL_MUCUS_TEXTURE_EGG_WHITE = 5;
    public static final int CERVICAL_MUCUS_TEXTURE_STICKY = 2;
    public static final int CERVICAL_MUCUS_TEXTURE_WATERY = 4;
    public static final int CERVICAL_POSITION_HIGH = 3;
    public static final int CERVICAL_POSITION_LOW = 1;
    public static final int CERVICAL_POSITION_MEDIUM = 2;
    public static final int FIELD_TEMPORAL_RELATION_TO_MEAL_AFTER_MEAL = 4;
    public static final int FIELD_TEMPORAL_RELATION_TO_MEAL_BEFORE_MEAL = 3;
    public static final int FIELD_TEMPORAL_RELATION_TO_MEAL_FASTING = 2;
    public static final int FIELD_TEMPORAL_RELATION_TO_MEAL_GENERAL = 1;
    public static final int MENSTRUAL_FLOW_HEAVY = 4;
    public static final int MENSTRUAL_FLOW_LIGHT = 2;
    public static final int MENSTRUAL_FLOW_MEDIUM = 3;
    public static final int MENSTRUAL_FLOW_SPOTTING = 1;
    public static final int OVULATION_TEST_RESULT_NEGATIVE = 1;
    public static final int OVULATION_TEST_RESULT_POSITIVE = 2;
    public static final int OXYGEN_SATURATION_MEASUREMENT_METHOD_PULSE_OXIMETRY = 1;
    public static final int OXYGEN_SATURATION_SYSTEM_PERIPHERAL_CAPILLARY = 1;
    public static final int OXYGEN_THERAPY_ADMINISTRATION_MODE_NASAL_CANULA = 1;
    public static final int TEMPORAL_RELATION_TO_SLEEP_BEFORE_SLEEP = 2;
    public static final int TEMPORAL_RELATION_TO_SLEEP_DURING_SLEEP = 4;
    public static final int TEMPORAL_RELATION_TO_SLEEP_FULLY_AWAKE = 1;
    public static final int TEMPORAL_RELATION_TO_SLEEP_ON_WAKING = 3;

    @NonNull
    public static final Field FIELD_BLOOD_PRESSURE_SYSTOLIC = Field.zzb("blood_pressure_systolic");

    @NonNull
    public static final Field FIELD_BLOOD_PRESSURE_SYSTOLIC_AVERAGE = Field.zzb("blood_pressure_systolic_average");

    @NonNull
    public static final Field FIELD_BLOOD_PRESSURE_SYSTOLIC_MIN = Field.zzb("blood_pressure_systolic_min");

    @NonNull
    public static final Field FIELD_BLOOD_PRESSURE_SYSTOLIC_MAX = Field.zzb("blood_pressure_systolic_max");

    @NonNull
    public static final Field FIELD_BLOOD_PRESSURE_DIASTOLIC = Field.zzb("blood_pressure_diastolic");

    @NonNull
    public static final Field FIELD_BLOOD_PRESSURE_DIASTOLIC_AVERAGE = Field.zzb("blood_pressure_diastolic_average");

    @NonNull
    public static final Field FIELD_BLOOD_PRESSURE_DIASTOLIC_MIN = Field.zzb("blood_pressure_diastolic_min");

    @NonNull
    public static final Field FIELD_BLOOD_PRESSURE_DIASTOLIC_MAX = Field.zzb("blood_pressure_diastolic_max");

    @NonNull
    public static final Field FIELD_BODY_POSITION = Field.zzf("body_position");

    @NonNull
    public static final Field FIELD_BLOOD_PRESSURE_MEASUREMENT_LOCATION = Field.zzf("blood_pressure_measurement_location");

    @NonNull
    public static final Field FIELD_BLOOD_GLUCOSE_LEVEL = Field.zzb("blood_glucose_level");

    @NonNull
    public static final Field FIELD_TEMPORAL_RELATION_TO_MEAL = Field.zzf("temporal_relation_to_meal");

    @NonNull
    public static final Field FIELD_TEMPORAL_RELATION_TO_SLEEP = Field.zzf("temporal_relation_to_sleep");

    @NonNull
    public static final Field FIELD_BLOOD_GLUCOSE_SPECIMEN_SOURCE = Field.zzf("blood_glucose_specimen_source");

    @NonNull
    public static final Field FIELD_OXYGEN_SATURATION = Field.zzb("oxygen_saturation");

    @NonNull
    public static final Field FIELD_OXYGEN_SATURATION_AVERAGE = Field.zzb("oxygen_saturation_average");

    @NonNull
    public static final Field FIELD_OXYGEN_SATURATION_MIN = Field.zzb("oxygen_saturation_min");

    @NonNull
    public static final Field FIELD_OXYGEN_SATURATION_MAX = Field.zzb("oxygen_saturation_max");

    @NonNull
    public static final Field FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE = Field.zzb("supplemental_oxygen_flow_rate");

    @NonNull
    public static final Field FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE_AVERAGE = Field.zzb("supplemental_oxygen_flow_rate_average");

    @NonNull
    public static final Field FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE_MIN = Field.zzb("supplemental_oxygen_flow_rate_min");

    @NonNull
    public static final Field FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE_MAX = Field.zzb("supplemental_oxygen_flow_rate_max");

    @NonNull
    public static final Field FIELD_OXYGEN_THERAPY_ADMINISTRATION_MODE = Field.zzf("oxygen_therapy_administration_mode");

    @NonNull
    public static final Field FIELD_OXYGEN_SATURATION_SYSTEM = Field.zzf("oxygen_saturation_system");

    @NonNull
    public static final Field FIELD_OXYGEN_SATURATION_MEASUREMENT_METHOD = Field.zzf("oxygen_saturation_measurement_method");

    @NonNull
    public static final Field FIELD_BODY_TEMPERATURE = Field.zzb("body_temperature");

    @NonNull
    public static final Field FIELD_BODY_TEMPERATURE_MEASUREMENT_LOCATION = Field.zzf("body_temperature_measurement_location");

    @NonNull
    public static final Field FIELD_CERVICAL_MUCUS_TEXTURE = Field.zzf("cervical_mucus_texture");

    @NonNull
    public static final Field FIELD_CERVICAL_MUCUS_AMOUNT = Field.zzf("cervical_mucus_amount");

    @NonNull
    public static final Field FIELD_CERVICAL_POSITION = Field.zzf("cervical_position");

    @NonNull
    public static final Field FIELD_CERVICAL_DILATION = Field.zzf("cervical_dilation");

    @NonNull
    public static final Field FIELD_CERVICAL_FIRMNESS = Field.zzf("cervical_firmness");

    @NonNull
    public static final Field FIELD_MENSTRUAL_FLOW = Field.zzf("menstrual_flow");

    @NonNull
    public static final Field FIELD_OVULATION_TEST_RESULT = Field.zzf("ovulation_test_result");

    private HealthFields() {
    }
}
