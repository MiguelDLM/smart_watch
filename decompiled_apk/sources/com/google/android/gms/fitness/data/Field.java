package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mapsdkplatform.comapi.f;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.garmin.fit.xOxOoo;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "FieldCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes9.dex */
public final class Field extends AbstractSafeParcelable {
    public static final int FORMAT_FLOAT = 2;
    public static final int FORMAT_INT32 = 1;
    public static final int FORMAT_MAP = 4;
    public static final int FORMAT_STRING = 3;
    public static final int MEAL_TYPE_BREAKFAST = 1;
    public static final int MEAL_TYPE_DINNER = 3;
    public static final int MEAL_TYPE_LUNCH = 2;
    public static final int MEAL_TYPE_SNACK = 4;
    public static final int MEAL_TYPE_UNKNOWN = 0;

    @NonNull
    public static final String NUTRIENT_CALCIUM = "calcium";

    @NonNull
    public static final String NUTRIENT_CALORIES = "calories";

    @NonNull
    public static final String NUTRIENT_CHOLESTEROL = "cholesterol";

    @NonNull
    public static final String NUTRIENT_DIETARY_FIBER = "dietary_fiber";

    @NonNull
    public static final String NUTRIENT_IRON = "iron";

    @NonNull
    public static final String NUTRIENT_MONOUNSATURATED_FAT = "fat.monounsaturated";

    @NonNull
    public static final String NUTRIENT_POLYUNSATURATED_FAT = "fat.polyunsaturated";

    @NonNull
    public static final String NUTRIENT_POTASSIUM = "potassium";

    @NonNull
    public static final String NUTRIENT_PROTEIN = "protein";

    @NonNull
    public static final String NUTRIENT_SATURATED_FAT = "fat.saturated";

    @NonNull
    public static final String NUTRIENT_SODIUM = "sodium";

    @NonNull
    public static final String NUTRIENT_SUGAR = "sugar";

    @NonNull
    public static final String NUTRIENT_TOTAL_CARBS = "carbs.total";

    @NonNull
    public static final String NUTRIENT_TOTAL_FAT = "fat.total";

    @NonNull
    public static final String NUTRIENT_TRANS_FAT = "fat.trans";

    @NonNull
    public static final String NUTRIENT_UNSATURATED_FAT = "fat.unsaturated";

    @NonNull
    public static final String NUTRIENT_VITAMIN_A = "vitamin_a";

    @NonNull
    public static final String NUTRIENT_VITAMIN_C = "vitamin_c";
    public static final int RESISTANCE_TYPE_BARBELL = 1;
    public static final int RESISTANCE_TYPE_BODY = 6;
    public static final int RESISTANCE_TYPE_CABLE = 2;
    public static final int RESISTANCE_TYPE_DUMBBELL = 3;
    public static final int RESISTANCE_TYPE_KETTLEBELL = 4;
    public static final int RESISTANCE_TYPE_MACHINE = 5;
    public static final int RESISTANCE_TYPE_UNKNOWN = 0;

    @SafeParcelable.Field(getter = "getName", id = 1)
    private final String zzad;

    @SafeParcelable.Field(getter = "getFormat", id = 2)
    private final int zzae;

    @Nullable
    @SafeParcelable.Field(getter = "isOptional", id = 3)
    private final Boolean zzaf;

    @NonNull
    public static final Parcelable.Creator<Field> CREATOR = new zzq();

    @NonNull
    public static final Field FIELD_ACTIVITY = zzd(TTDownloadField.TT_ACTIVITY);

    @NonNull
    public static final Field FIELD_SLEEP_SEGMENT_TYPE = zzd("sleep_segment_type");

    @NonNull
    public static final Field FIELD_CONFIDENCE = zzb("confidence");

    @NonNull
    public static final Field FIELD_STEPS = zzd("steps");

    @NonNull
    @Deprecated
    public static final Field FIELD_STEP_LENGTH = zzb("step_length");

    @NonNull
    public static final Field FIELD_DURATION = zzd("duration");

    @NonNull
    @ShowFirstParty
    public static final Field zza = zzf("duration");

    @NonNull
    @ShowFirstParty
    public static final Field zzb = zzc("activity_duration.ascending");

    @NonNull
    @ShowFirstParty
    public static final Field zzc = zzc("activity_duration.descending");

    @NonNull
    public static final Field FIELD_BPM = zzb("bpm");

    @NonNull
    @ShowFirstParty
    public static final Field zzd = zzb("respiratory_rate");

    @NonNull
    public static final Field FIELD_LATITUDE = zzb("latitude");

    @NonNull
    public static final Field FIELD_LONGITUDE = zzb("longitude");

    @NonNull
    public static final Field FIELD_ACCURACY = zzb("accuracy");

    @NonNull
    public static final Field FIELD_ALTITUDE = zze("altitude");

    @NonNull
    public static final Field FIELD_DISTANCE = zzb(xOxOoo.f15470o00);

    @NonNull
    public static final Field FIELD_HEIGHT = zzb("height");

    @NonNull
    public static final Field FIELD_WEIGHT = zzb("weight");

    @NonNull
    public static final Field FIELD_PERCENTAGE = zzb("percentage");

    @NonNull
    public static final Field FIELD_SPEED = zzb(RouteGuideParams.RGKey.AssistInfo.Speed);

    @NonNull
    public static final Field FIELD_RPM = zzb("rpm");

    @NonNull
    @ShowFirstParty
    public static final Field zze = zza("google.android.fitness.GoalV2");

    @NonNull
    @ShowFirstParty
    public static final Field zzf = zza("google.android.fitness.Device");

    @NonNull
    public static final Field FIELD_REVOLUTIONS = zzd("revolutions");

    @NonNull
    public static final Field FIELD_CALORIES = zzb("calories");

    @NonNull
    public static final Field FIELD_WATTS = zzb("watts");

    @NonNull
    public static final Field FIELD_VOLUME = zzb("volume");

    @NonNull
    public static final Field FIELD_MEAL_TYPE = zzf("meal_type");

    @NonNull
    public static final Field FIELD_FOOD_ITEM = new Field("food_item", 3, Boolean.TRUE);

    @NonNull
    public static final Field FIELD_NUTRIENTS = zzc("nutrients");

    @NonNull
    public static final Field FIELD_EXERCISE = zzg("exercise");

    @NonNull
    public static final Field FIELD_REPETITIONS = zzf("repetitions");

    @NonNull
    public static final Field FIELD_RESISTANCE = zze("resistance");

    @NonNull
    public static final Field FIELD_RESISTANCE_TYPE = zzf("resistance_type");

    @NonNull
    public static final Field FIELD_NUM_SEGMENTS = zzd("num_segments");

    @NonNull
    public static final Field FIELD_AVERAGE = zzb("average");

    @NonNull
    public static final Field FIELD_MAX = zzb("max");

    @NonNull
    public static final Field FIELD_MIN = zzb("min");

    @NonNull
    public static final Field FIELD_LOW_LATITUDE = zzb("low_latitude");

    @NonNull
    public static final Field FIELD_LOW_LONGITUDE = zzb("low_longitude");

    @NonNull
    public static final Field FIELD_HIGH_LATITUDE = zzb("high_latitude");

    @NonNull
    public static final Field FIELD_HIGH_LONGITUDE = zzb("high_longitude");

    @NonNull
    public static final Field FIELD_OCCURRENCES = zzd("occurrences");

    @NonNull
    @ShowFirstParty
    public static final Field zzg = zzd("sensor_type");

    @NonNull
    @ShowFirstParty
    public static final Field zzh = new Field("timestamps", 5, null);

    @NonNull
    @ShowFirstParty
    public static final Field zzi = new Field("sensor_values", 6, null);

    @NonNull
    public static final Field FIELD_INTENSITY = zzb(xOxOoo.f15467XI0IXoo);

    @NonNull
    @ShowFirstParty
    public static final Field zzj = zzc("activity_confidence");

    @NonNull
    @ShowFirstParty
    public static final Field zzk = zzb("probability");

    @NonNull
    @ShowFirstParty
    public static final Field zzl = zza("google.android.fitness.SleepAttributes");

    @NonNull
    @ShowFirstParty
    public static final Field zzm = zza("google.android.fitness.SleepDisorderedBreathingFeatures");

    @NonNull
    @ShowFirstParty
    public static final Field zzn = zza("google.android.fitness.SleepSchedule");

    @NonNull
    @ShowFirstParty
    public static final Field zzo = zza("google.android.fitness.SleepSoundscape");

    @NonNull
    @Deprecated
    public static final Field FIELD_CIRCUMFERENCE = zzb("circumference");

    @NonNull
    @ShowFirstParty
    public static final Field zzp = zza("google.android.fitness.PacedWalkingAttributes");

    @NonNull
    @ShowFirstParty
    public static final Field zzq = zzg("zone_id");

    @NonNull
    @ShowFirstParty
    public static final Field zzr = zzb("met");

    @NonNull
    @ShowFirstParty
    public static final Field zzs = zzb("internal_device_temperature");

    @NonNull
    @ShowFirstParty
    public static final Field zzt = zzb("skin_temperature");

    @NonNull
    @ShowFirstParty
    public static final Field zzu = zzd("custom_heart_rate_zone_status");

    @NonNull
    public static final Field FIELD_MIN_INT = zzd("min_int");

    @NonNull
    public static final Field FIELD_MAX_INT = zzd("max_int");

    @NonNull
    @ShowFirstParty
    public static final Field zzv = zzf("lightly_active_duration");

    @NonNull
    @ShowFirstParty
    public static final Field zzw = zzf("moderately_active_duration");

    @NonNull
    @ShowFirstParty
    public static final Field zzx = zzf("very_active_duration");

    @NonNull
    @ShowFirstParty
    public static final Field zzy = zza("google.android.fitness.SedentaryTime");

    @NonNull
    @ShowFirstParty
    public static final Field zzz = zza("google.android.fitness.LivePace");

    @NonNull
    @ShowFirstParty
    public static final Field zzA = zza("google.android.fitness.MomentaryStressAlgorithm");

    @NonNull
    @ShowFirstParty
    public static final Field zzB = zzd("magnet_presence");

    @NonNull
    @ShowFirstParty
    public static final Field zzC = zza("google.android.fitness.MomentaryStressWindows");

    @NonNull
    @ShowFirstParty
    public static final Field zzD = zza("google.android.fitness.ExerciseDetectionThresholds");

    @NonNull
    @ShowFirstParty
    public static final Field zzE = zza("google.android.fitness.RecoveryHeartRate");

    @NonNull
    @ShowFirstParty
    public static final Field zzF = zza("google.android.fitness.HeartRateVariability");

    @NonNull
    @ShowFirstParty
    public static final Field zzG = zza("google.android.fitness.HeartRateVariabilitySummary");

    @NonNull
    @ShowFirstParty
    public static final Field zzH = zza("google.android.fitness.ContinuousEDA");

    @NonNull
    @ShowFirstParty
    public static final Field zzI = zza("google.android.fitness.TimeInSleepStages");

    @NonNull
    @ShowFirstParty
    public static final Field zzJ = zza("google.android.fitness.Grok");

    @NonNull
    @ShowFirstParty
    public static final Field zzK = zza("google.android.fitness.WakeMagnitude");

    @NonNull
    @ShowFirstParty
    public static final Field zzL = zzd("google.android.fitness.FatBurnMinutes");

    @NonNull
    @ShowFirstParty
    public static final Field zzM = zzd("google.android.fitness.CardioMinutes");

    @NonNull
    @ShowFirstParty
    public static final Field zzN = zzd("google.android.fitness.PeakHeartRateMinutes");

    @NonNull
    @ShowFirstParty
    public static final Field zzO = zzd("google.android.fitness.ActiveZoneMinutes");

    @NonNull
    @ShowFirstParty
    public static final Field zzP = zza("google.android.fitness.SleepCoefficient");

    @NonNull
    @ShowFirstParty
    public static final Field zzQ = zza("google.android.fitness.RunVO2Max");

    @NonNull
    @ShowFirstParty
    public static final Field zzR = zzd("device_location_type");

    @NonNull
    @ShowFirstParty
    public static final Field zzS = zzg("device_id");

    @NonNull
    @ShowFirstParty
    public static final Field zzT = zza("google.android.fitness.DemographicVO2Max");

    @NonNull
    @ShowFirstParty
    public static final Field zzU = zza("google.android.fitness.SleepSetting");

    @NonNull
    @ShowFirstParty
    public static final Field zzV = zza("google.android.fitness.ValuesInHeartRateZones");

    @NonNull
    @ShowFirstParty
    public static final Field zzW = zza("google.android.fitness.HeartHistogram");

    @NonNull
    @ShowFirstParty
    public static final Field zzX = zza("google.android.fitness.StressScore");

    @NonNull
    @ShowFirstParty
    public static final Field zzY = zza("google.android.fitness.RespiratoryRateSummary");

    @NonNull
    @ShowFirstParty
    public static final Field zzZ = zza("google.android.fitness.DailySkinSleepTemperatureDerivations");

    @NonNull
    @ShowFirstParty
    public static final Field zzaa = zza("google.android.fitness.SwimLengthsData");

    @NonNull
    @ShowFirstParty
    public static final Field zzab = zza("google.android.fitness.DailySleep");

    @NonNull
    @ShowFirstParty
    public static final Field zzac = zza("google.android.fitness.DailyInternalDeviceTemperatureSleepTemperatureDerivations");

    @ShowFirstParty
    @SafeParcelable.Constructor
    public Field(@NonNull @SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) int i, @Nullable @SafeParcelable.Param(id = 3) Boolean bool) {
        this.zzad = (String) Preconditions.checkNotNull(str);
        this.zzae = i;
        this.zzaf = bool;
    }

    @NonNull
    @ShowFirstParty
    public static Field zza(@NonNull String str) {
        return new Field(str, 7, null);
    }

    @NonNull
    @ShowFirstParty
    public static Field zzb(@NonNull String str) {
        return new Field(str, 2, null);
    }

    @NonNull
    @ShowFirstParty
    public static Field zzc(@NonNull String str) {
        return new Field(str, 4, null);
    }

    @NonNull
    @ShowFirstParty
    public static Field zzd(@NonNull String str) {
        return new Field(str, 1, null);
    }

    @NonNull
    @ShowFirstParty
    public static Field zze(@NonNull String str) {
        return new Field(str, 2, Boolean.TRUE);
    }

    @NonNull
    @ShowFirstParty
    public static Field zzf(@NonNull String str) {
        return new Field(str, 1, Boolean.TRUE);
    }

    @NonNull
    @ShowFirstParty
    public static Field zzg(@NonNull String str) {
        return new Field(str, 3, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Field)) {
            return false;
        }
        Field field = (Field) obj;
        if (this.zzad.equals(field.zzad) && this.zzae == field.zzae) {
            return true;
        }
        return false;
    }

    public int getFormat() {
        return this.zzae;
    }

    @NonNull
    public String getName() {
        return this.zzad;
    }

    public int hashCode() {
        return this.zzad.hashCode();
    }

    @Nullable
    public Boolean isOptional() {
        return this.zzaf;
    }

    @NonNull
    public String toString() {
        String str;
        String str2 = this.zzad;
        if (this.zzae == 1) {
            str = "i";
        } else {
            str = f.f6163a;
        }
        return String.format("%s(%s)", str2, str);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getName(), false);
        SafeParcelWriter.writeInt(parcel, 2, getFormat());
        SafeParcelWriter.writeBooleanObject(parcel, 3, isOptional(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
