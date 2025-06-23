package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "DataTypeCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes9.dex */
public final class DataType extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final DataType AGGREGATE_ACTIVITY_SUMMARY;

    @NonNull
    public static final DataType AGGREGATE_BASAL_METABOLIC_RATE_SUMMARY;

    @NonNull
    public static final DataType AGGREGATE_BODY_FAT_PERCENTAGE_SUMMARY;

    @NonNull
    public static final DataType AGGREGATE_CALORIES_EXPENDED;

    @NonNull
    public static final DataType AGGREGATE_DISTANCE_DELTA;

    @NonNull
    public static final DataType AGGREGATE_HEART_POINTS;

    @NonNull
    public static final DataType AGGREGATE_HEART_RATE_SUMMARY;

    @NonNull
    public static final DataType AGGREGATE_HEIGHT_SUMMARY;

    @NonNull
    public static final DataType AGGREGATE_HYDRATION;

    @NonNull
    public static final DataType AGGREGATE_LOCATION_BOUNDING_BOX;

    @NonNull
    public static final DataType AGGREGATE_MOVE_MINUTES;

    @NonNull
    public static final DataType AGGREGATE_NUTRITION_SUMMARY;

    @NonNull
    public static final DataType AGGREGATE_POWER_SUMMARY;

    @NonNull
    public static final DataType AGGREGATE_SPEED_SUMMARY;

    @NonNull
    public static final DataType AGGREGATE_STEP_COUNT_DELTA;

    @NonNull
    public static final DataType AGGREGATE_WEIGHT_SUMMARY;

    @NonNull
    public static final Parcelable.Creator<DataType> CREATOR = new zzk();

    @NonNull
    public static final String MIME_TYPE_PREFIX = "vnd.google.fitness.data_type/";

    @NonNull
    public static final DataType TYPE_ACTIVITY_SEGMENT;

    @NonNull
    public static final DataType TYPE_BASAL_METABOLIC_RATE;

    @NonNull
    public static final DataType TYPE_BODY_FAT_PERCENTAGE;

    @NonNull
    public static final DataType TYPE_CALORIES_EXPENDED;

    @NonNull
    public static final DataType TYPE_CYCLING_PEDALING_CADENCE;

    @NonNull
    public static final DataType TYPE_CYCLING_PEDALING_CUMULATIVE;

    @NonNull
    public static final DataType TYPE_CYCLING_WHEEL_REVOLUTION;

    @NonNull
    public static final DataType TYPE_CYCLING_WHEEL_RPM;

    @NonNull
    public static final DataType TYPE_DISTANCE_DELTA;

    @NonNull
    public static final DataType TYPE_HEART_POINTS;

    @NonNull
    public static final DataType TYPE_HEART_RATE_BPM;

    @NonNull
    public static final DataType TYPE_HEIGHT;

    @NonNull
    public static final DataType TYPE_HYDRATION;

    @NonNull
    public static final DataType TYPE_LOCATION_SAMPLE;

    @NonNull
    @Deprecated
    public static final DataType TYPE_LOCATION_TRACK;

    @NonNull
    public static final DataType TYPE_MOVE_MINUTES;

    @NonNull
    public static final DataType TYPE_NUTRITION;

    @NonNull
    public static final DataType TYPE_POWER_SAMPLE;

    @NonNull
    public static final DataType TYPE_SLEEP_SEGMENT;

    @NonNull
    public static final DataType TYPE_SPEED;

    @NonNull
    public static final DataType TYPE_STEP_COUNT_CADENCE;

    @NonNull
    @ShowFirstParty
    @KeepForSdk
    public static final DataType TYPE_STEP_COUNT_CUMULATIVE;

    @NonNull
    public static final DataType TYPE_STEP_COUNT_DELTA;

    @NonNull
    public static final DataType TYPE_WEIGHT;

    @NonNull
    public static final DataType TYPE_WORKOUT_EXERCISE;

    @NonNull
    @ShowFirstParty
    public static final DataType zzA;

    @NonNull
    @ShowFirstParty
    public static final DataType zzB;

    @NonNull
    @ShowFirstParty
    public static final DataType zzC;

    @NonNull
    @ShowFirstParty
    public static final DataType zzD;

    @NonNull
    @ShowFirstParty
    public static final DataType zzE;

    @NonNull
    @ShowFirstParty
    public static final DataType zzF;

    @NonNull
    @ShowFirstParty
    public static final DataType zzG;

    @NonNull
    @ShowFirstParty
    public static final DataType zzH;

    @NonNull
    @ShowFirstParty
    public static final DataType zzI;

    @NonNull
    @ShowFirstParty
    public static final DataType zzJ;

    @NonNull
    @ShowFirstParty
    public static final DataType zzK;

    @NonNull
    @ShowFirstParty
    public static final DataType zzL;

    @NonNull
    @ShowFirstParty
    public static final DataType zzM;

    @NonNull
    @ShowFirstParty
    public static final DataType zzN;

    @NonNull
    @ShowFirstParty
    public static final DataType zzO;

    @NonNull
    @ShowFirstParty
    public static final DataType zzP;

    @NonNull
    @ShowFirstParty
    public static final DataType zzQ;

    @NonNull
    @ShowFirstParty
    public static final DataType zzR;

    @NonNull
    @ShowFirstParty
    public static final DataType zzS;

    @NonNull
    @ShowFirstParty
    public static final DataType zza;

    @NonNull
    @ShowFirstParty
    public static final DataType zzb;

    @NonNull
    @ShowFirstParty
    public static final DataType zzc;

    @NonNull
    @ShowFirstParty
    public static final DataType zzd;

    @NonNull
    @ShowFirstParty
    public static final DataType zze;

    @NonNull
    @ShowFirstParty
    public static final DataType zzf;

    @NonNull
    public static final DataType zzg;

    @NonNull
    @ShowFirstParty
    public static final DataType zzh;

    @NonNull
    @ShowFirstParty
    public static final DataType zzi;

    @NonNull
    @ShowFirstParty
    public static final DataType zzj;

    @NonNull
    @ShowFirstParty
    public static final DataType zzk;

    @NonNull
    @ShowFirstParty
    public static final DataType zzl;

    @NonNull
    @ShowFirstParty
    public static final DataType zzm;

    @NonNull
    @ShowFirstParty
    public static final DataType zzn;

    @NonNull
    @ShowFirstParty
    public static final DataType zzo;

    @NonNull
    @ShowFirstParty
    public static final DataType zzp;

    @NonNull
    @ShowFirstParty
    public static final DataType zzq;

    @NonNull
    @ShowFirstParty
    public static final DataType zzr;

    @NonNull
    @ShowFirstParty
    public static final DataType zzs;

    @NonNull
    @ShowFirstParty
    public static final DataType zzt;

    @NonNull
    @ShowFirstParty
    public static final DataType zzu;

    @NonNull
    @ShowFirstParty
    public static final DataType zzv;

    @NonNull
    @ShowFirstParty
    public static final DataType zzw;

    @NonNull
    @ShowFirstParty
    public static final DataType zzx;

    @NonNull
    @ShowFirstParty
    public static final DataType zzy;

    @NonNull
    @ShowFirstParty
    public static final DataType zzz;

    @SafeParcelable.Field(getter = "getName", id = 1)
    private final String zzT;

    @SafeParcelable.Field(getter = "getFields", id = 2)
    private final List zzU;

    @Nullable
    @SafeParcelable.Field(getter = "getReadScope", id = 3)
    private final String zzV;

    @Nullable
    @SafeParcelable.Field(getter = "getWriteScope", id = 4)
    private final String zzW;

    static {
        Field field = Field.FIELD_STEPS;
        DataType dataType = new DataType("com.google.step_count.delta", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field);
        TYPE_STEP_COUNT_DELTA = dataType;
        TYPE_STEP_COUNT_CUMULATIVE = new DataType("com.google.step_count.cumulative", 1, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field);
        Field field2 = Field.FIELD_RPM;
        TYPE_STEP_COUNT_CADENCE = new DataType("com.google.step_count.cadence", 1, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field2);
        zza = new DataType("com.google.internal.goal", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.zze);
        Field field3 = Field.FIELD_ACTIVITY;
        TYPE_ACTIVITY_SEGMENT = new DataType("com.google.activity.segment", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field3);
        zzb = new DataType("com.google.internal.sleep_disordered_breathing_features", 2, "https://www.googleapis.com/auth/fitness.sleep.read", "https://www.googleapis.com/auth/fitness.sleep.write", Field.zzm);
        TYPE_SLEEP_SEGMENT = new DataType("com.google.sleep.segment", 2, "https://www.googleapis.com/auth/fitness.sleep.read", "https://www.googleapis.com/auth/fitness.sleep.write", Field.FIELD_SLEEP_SEGMENT_TYPE);
        zzc = new DataType("com.google.internal.sleep_soundscape", 2, "https://www.googleapis.com/auth/fitness.sleep.read", "https://www.googleapis.com/auth/fitness.sleep.write", Field.zzo);
        Field field4 = Field.FIELD_CALORIES;
        DataType dataType2 = new DataType("com.google.calories.expended", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field4);
        TYPE_CALORIES_EXPENDED = dataType2;
        TYPE_BASAL_METABOLIC_RATE = new DataType("com.google.calories.bmr", 1, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field4);
        TYPE_POWER_SAMPLE = new DataType("com.google.power.sample", 1, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.FIELD_WATTS);
        zzd = new DataType("com.google.sensor.events", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.zzg, Field.zzh, Field.zzi);
        TYPE_HEART_RATE_BPM = new DataType("com.google.heart_rate.bpm", 1, "https://www.googleapis.com/auth/fitness.heart_rate.read", "https://www.googleapis.com/auth/fitness.heart_rate.write", Field.FIELD_BPM);
        zze = new DataType("com.google.respiratory_rate", 1, "https://www.googleapis.com/auth/fitness.respiratory_rate.read", "https://www.googleapis.com/auth/fitness.respiratory_rate.write", Field.zzd);
        Field field5 = Field.FIELD_LATITUDE;
        Field field6 = Field.FIELD_LONGITUDE;
        Field field7 = Field.FIELD_ACCURACY;
        Field field8 = Field.FIELD_ALTITUDE;
        TYPE_LOCATION_SAMPLE = new DataType("com.google.location.sample", 1, "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", field5, field6, field7, field8);
        TYPE_LOCATION_TRACK = new DataType("com.google.location.track", 2, "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", field5, field6, field7, field8);
        DataType dataType3 = new DataType("com.google.distance.delta", 2, "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", Field.FIELD_DISTANCE);
        TYPE_DISTANCE_DELTA = dataType3;
        TYPE_SPEED = new DataType("com.google.speed", 1, "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", Field.FIELD_SPEED);
        Field field9 = Field.FIELD_REVOLUTIONS;
        TYPE_CYCLING_WHEEL_REVOLUTION = new DataType("com.google.cycling.wheel_revolution.cumulative", 1, "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", field9);
        TYPE_CYCLING_WHEEL_RPM = new DataType("com.google.cycling.wheel_revolution.rpm", 1, "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", field2);
        TYPE_CYCLING_PEDALING_CUMULATIVE = new DataType("com.google.cycling.pedaling.cumulative", 1, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field9);
        TYPE_CYCLING_PEDALING_CADENCE = new DataType("com.google.cycling.pedaling.cadence", 1, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field2);
        TYPE_HEIGHT = new DataType("com.google.height", 1, "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", Field.FIELD_HEIGHT);
        TYPE_WEIGHT = new DataType("com.google.weight", 1, "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", Field.FIELD_WEIGHT);
        TYPE_BODY_FAT_PERCENTAGE = new DataType("com.google.body.fat.percentage", 1, "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", Field.FIELD_PERCENTAGE);
        Field field10 = Field.FIELD_NUTRIENTS;
        Field field11 = Field.FIELD_MEAL_TYPE;
        TYPE_NUTRITION = new DataType("com.google.nutrition", 1, "https://www.googleapis.com/auth/fitness.nutrition.read", "https://www.googleapis.com/auth/fitness.nutrition.write", field10, field11, Field.FIELD_FOOD_ITEM);
        DataType dataType4 = new DataType("com.google.hydration", 1, "https://www.googleapis.com/auth/fitness.nutrition.read", "https://www.googleapis.com/auth/fitness.nutrition.write", Field.FIELD_VOLUME);
        TYPE_HYDRATION = dataType4;
        TYPE_WORKOUT_EXERCISE = new DataType("com.google.activity.exercise", 1, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.FIELD_EXERCISE, Field.FIELD_REPETITIONS, Field.zza, Field.FIELD_RESISTANCE_TYPE, Field.FIELD_RESISTANCE);
        Field field12 = Field.FIELD_DURATION;
        DataType dataType5 = new DataType("com.google.active_minutes", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field12);
        TYPE_MOVE_MINUTES = dataType5;
        AGGREGATE_MOVE_MINUTES = dataType5;
        zzf = new DataType("com.google.device_on_body", 1, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.zzk);
        AGGREGATE_ACTIVITY_SUMMARY = new DataType("com.google.activity.summary", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field3, field12, Field.FIELD_NUM_SEGMENTS);
        Field field13 = Field.FIELD_AVERAGE;
        Field field14 = Field.FIELD_MAX;
        Field field15 = Field.FIELD_MIN;
        AGGREGATE_BASAL_METABOLIC_RATE_SUMMARY = new DataType("com.google.calories.bmr.summary", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field13, field14, field15);
        AGGREGATE_STEP_COUNT_DELTA = dataType;
        AGGREGATE_DISTANCE_DELTA = dataType3;
        AGGREGATE_CALORIES_EXPENDED = dataType2;
        Field field16 = Field.FIELD_INTENSITY;
        TYPE_HEART_POINTS = new DataType("com.google.heart_minutes", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field16);
        AGGREGATE_HEART_POINTS = new DataType("com.google.heart_minutes.summary", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field16, field12);
        AGGREGATE_HEART_RATE_SUMMARY = new DataType("com.google.heart_rate.summary", 2, "https://www.googleapis.com/auth/fitness.heart_rate.read", "https://www.googleapis.com/auth/fitness.heart_rate.write", field13, field14, field15);
        AGGREGATE_LOCATION_BOUNDING_BOX = new DataType("com.google.location.bounding_box", 2, "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", Field.FIELD_LOW_LATITUDE, Field.FIELD_LOW_LONGITUDE, Field.FIELD_HIGH_LATITUDE, Field.FIELD_HIGH_LONGITUDE);
        AGGREGATE_POWER_SUMMARY = new DataType("com.google.power.summary", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field13, field14, field15);
        AGGREGATE_SPEED_SUMMARY = new DataType("com.google.speed.summary", 2, "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", field13, field14, field15);
        AGGREGATE_BODY_FAT_PERCENTAGE_SUMMARY = new DataType("com.google.body.fat.percentage.summary", 2, "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", field13, field14, field15);
        AGGREGATE_WEIGHT_SUMMARY = new DataType("com.google.weight.summary", 2, "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", field13, field14, field15);
        AGGREGATE_HEIGHT_SUMMARY = new DataType("com.google.height.summary", 2, "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", field13, field14, field15);
        AGGREGATE_NUTRITION_SUMMARY = new DataType("com.google.nutrition.summary", 2, "https://www.googleapis.com/auth/fitness.nutrition.read", "https://www.googleapis.com/auth/fitness.nutrition.write", field10, field11);
        AGGREGATE_HYDRATION = dataType4;
        zzg = new DataType("com.google.activity.samples", 1, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.zzj);
        zzh = new DataType("com.google.internal.sleep_attributes", 2, "https://www.googleapis.com/auth/fitness.sleep.read", "https://www.googleapis.com/auth/fitness.sleep.write", Field.zzl);
        zzi = new DataType("com.google.internal.sleep_schedule", 1, "https://www.googleapis.com/auth/fitness.sleep.read", "https://www.googleapis.com/auth/fitness.sleep.write", Field.zzn);
        zzj = new DataType("com.google.internal.paced_walking_attributes", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.zzp);
        zzk = new DataType("com.google.time_zone_change", 1, "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", Field.zzq);
        zzl = new DataType("com.google.internal.met", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.zzr);
        zzm = new DataType("com.google.internal.internal_device_temperature", 2, "https://www.googleapis.com/auth/fitness.body_temperature.read", "https://www.googleapis.com/auth/fitness.body_temperature.write", Field.zzs);
        zzn = new DataType("com.google.internal.skin_temperature", 2, "https://www.googleapis.com/auth/fitness.body_temperature.read", "https://www.googleapis.com/auth/fitness.body_temperature.write", Field.zzt);
        Field field17 = Field.FIELD_MAX_INT;
        zzo = new DataType("com.google.internal.custom_heart_rate_zone", 1, "https://www.googleapis.com/auth/fitness.heart_rate.read", "https://www.googleapis.com/auth/fitness.heart_rate.write", Field.zzu, Field.FIELD_MIN_INT, field17);
        zzp = new DataType("com.google.internal.active_minutes_combined", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.zzv, Field.zzw, Field.zzx);
        zzq = new DataType("com.google.internal.sedentary_time", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.zzy);
        zzr = new DataType("com.google.internal.live_pace", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.zzz);
        zzs = new DataType("com.google.internal.custom_max_heart_rate", 1, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field17);
        zzt = new DataType("com.google.internal.momentary_stress_algorithm", 1, "https://www.googleapis.com/auth/fitness.heart_rate.read", "https://www.googleapis.com/auth/fitness.heart_rate.write", Field.zzA);
        zzu = new DataType("com.google.internal.magnetic_field_presence", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.zzB);
        zzv = new DataType("com.google.internal.momentary_stress_windows", 2, "https://www.googleapis.com/auth/fitness.heart_rate.read", "https://www.googleapis.com/auth/fitness.heart_rate.write", Field.zzC);
        zzw = new DataType("com.google.internal.exercise_detection_thresholds", 1, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.zzD);
        zzx = new DataType("com.google.internal.recovery_heart_rate", 2, "https://www.googleapis.com/auth/fitness.heart_rate.read", "https://www.googleapis.com/auth/fitness.heart_rate.write", Field.zzE);
        zzy = new DataType("com.google.internal.heart_rate_variability", 2, "https://www.googleapis.com/auth/fitness.heart_rate.read", "https://www.googleapis.com/auth/fitness.heart_rate.write", Field.zzF);
        zzz = new DataType("com.google.internal.heart_rate_variability_summary", 2, "https://www.googleapis.com/auth/fitness.heart_rate.read", "https://www.googleapis.com/auth/fitness.heart_rate.write", Field.zzG);
        zzA = new DataType("com.google.internal.continuous_eda", 1, "https://www.googleapis.com/auth/fitness.heart_rate.read", "https://www.googleapis.com/auth/fitness.heart_rate.write", Field.zzH);
        zzB = new DataType("com.google.internal.altitude_sample", 1, "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", field8);
        zzC = new DataType("com.google.internal.time_in_sleep_stages", 2, "https://www.googleapis.com/auth/fitness.sleep.read", "https://www.googleapis.com/auth/fitness.sleep.write", Field.zzI);
        zzD = new DataType("com.google.internal.grok_data", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.zzJ);
        zzE = new DataType("com.google.internal.wake_magnitude", 2, "https://www.googleapis.com/auth/fitness.sleep.read", "https://www.googleapis.com/auth/fitness.sleep.write", Field.zzK);
        zzF = new DataType("com.google.internal.active_zone_minutes_summary", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.zzL, Field.zzM, Field.zzN, Field.zzO);
        zzG = new DataType("com.google.internal.sleep_coefficient", 1, "https://www.googleapis.com/auth/fitness.sleep.read", "https://www.googleapis.com/auth/fitness.sleep.write", Field.zzP);
        zzH = new DataType("com.google.internal.run_vo2_max", 1, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.zzQ);
        zzI = new DataType("com.google.internal.demographic_vo2_max", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.zzT);
        zzJ = new DataType("com.google.internal.sleep_setting", 1, "https://www.googleapis.com/auth/fitness.sleep.read", "https://www.googleapis.com/auth/fitness.sleep.write", Field.zzU);
        zzK = new DataType("com.google.internal.values_in_heart_rate_zones", 2, "https://www.googleapis.com/auth/fitness.heart_rate.read", "https://www.googleapis.com/auth/fitness.heart_rate.write", Field.zzV);
        zzL = new DataType("com.google.internal.heart_histogram", 1, "https://www.googleapis.com/auth/fitness.sleep.read", "https://www.googleapis.com/auth/fitness.sleep.write", Field.zzW);
        zzM = new DataType("com.google.internal.respiratory_rate_summary", 1, "https://www.googleapis.com/auth/fitness.sleep.read", "https://www.googleapis.com/auth/fitness.sleep.write", Field.zzY);
        zzN = new DataType("com.google.internal.stress_score", 2, "https://www.googleapis.com/auth/fitness.heart_rate.read", "https://www.googleapis.com/auth/fitness.heart_rate.write", Field.zzX);
        zzO = new DataType("com.google.internal.device_location", 1, "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", field5, field6, field7, Field.zzR, Field.zzS);
        zzP = new DataType("com.google.internal.daily_skin_sleep_temperature_derivations", 2, "https://www.googleapis.com/auth/fitness.body_temperature.read", "https://www.googleapis.com/auth/fitness.body_temperature.write", Field.zzZ);
        zzQ = new DataType("com.google.internal.swim_lengths_data", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.zzaa);
        zzR = new DataType("com.google.internal.daily_sleep", 2, "https://www.googleapis.com/auth/fitness.sleep.read", "https://www.googleapis.com/auth/fitness.sleep.write", Field.zzab);
        zzS = new DataType("com.google.internal.daily_internal_device_temperature_sleep_temperature_derivations", 2, "https://www.googleapis.com/auth/fitness.body_temperature.read", "https://www.googleapis.com/auth/fitness.body_temperature.write", Field.zzac);
    }

    @ShowFirstParty
    public DataType(@NonNull String str, int i, @Nullable String str2, @Nullable String str3, @NonNull Field... fieldArr) {
        this.zzT = str;
        this.zzU = Collections.unmodifiableList(Arrays.asList(fieldArr));
        this.zzV = str2;
        this.zzW = str3;
    }

    @NonNull
    @Deprecated
    public static List<DataType> getAggregatesForInput(@NonNull DataType dataType) {
        DataType aggregateType = dataType.getAggregateType();
        if (aggregateType == null) {
            return Collections.emptyList();
        }
        return Collections.singletonList(aggregateType);
    }

    @NonNull
    public static String getMimeType(@NonNull DataType dataType) {
        return MIME_TYPE_PREFIX.concat(String.valueOf(dataType.getName()));
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DataType)) {
            return false;
        }
        DataType dataType = (DataType) obj;
        if (this.zzT.equals(dataType.zzT) && this.zzU.equals(dataType.zzU)) {
            return true;
        }
        return false;
    }

    @Nullable
    public DataType getAggregateType() {
        return (DataType) zza.zza.get(this);
    }

    @NonNull
    public List<Field> getFields() {
        return this.zzU;
    }

    @NonNull
    public String getName() {
        return this.zzT;
    }

    public int hashCode() {
        return this.zzT.hashCode();
    }

    public int indexOf(@NonNull Field field) {
        int indexOf = this.zzU.indexOf(field);
        boolean z = false;
        Object[] objArr = {field, this};
        if (indexOf >= 0) {
            z = true;
        }
        Preconditions.checkArgument(z, "%s not a field of %s", objArr);
        return indexOf;
    }

    @NonNull
    public String toString() {
        return String.format("DataType{%s%s}", this.zzT, this.zzU);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getName(), false);
        SafeParcelWriter.writeTypedList(parcel, 2, getFields(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzV, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzW, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Nullable
    @ShowFirstParty
    public final String zza() {
        return this.zzV;
    }

    @Nullable
    @ShowFirstParty
    public final String zzb() {
        return this.zzW;
    }

    @NonNull
    @ShowFirstParty
    public final String zzc() {
        if (this.zzT.startsWith("com.google.")) {
            return this.zzT.substring(11);
        }
        return this.zzT;
    }

    @SafeParcelable.Constructor
    public DataType(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) List list, @Nullable @SafeParcelable.Param(id = 3) String str2, @Nullable @SafeParcelable.Param(id = 4) String str3) {
        this.zzT = str;
        this.zzU = Collections.unmodifiableList(list);
        this.zzV = str2;
        this.zzW = str3;
    }
}
