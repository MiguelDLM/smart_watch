package com.google.android.gms.internal.fitness;

import com.google.android.gms.fitness.FitnessActivities;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;

/* loaded from: classes9.dex */
public enum zzgp {
    AEROBICS(9, FitnessActivities.AEROBICS),
    ARCHERY(119, FitnessActivities.ARCHERY),
    BADMINTON(10, FitnessActivities.BADMINTON),
    BASEBALL(11, FitnessActivities.BASEBALL),
    BASKETBALL(12, FitnessActivities.BASKETBALL),
    BIATHLON(13, FitnessActivities.BIATHLON),
    BIKING(1, FitnessActivities.BIKING),
    BIKING_HAND(14, FitnessActivities.BIKING_HAND),
    BIKING_MOUNTAIN(15, FitnessActivities.BIKING_MOUNTAIN),
    BIKING_ROAD(16, FitnessActivities.BIKING_ROAD),
    BIKING_SPINNING(17, FitnessActivities.BIKING_SPINNING),
    BIKING_STATIONARY(18, FitnessActivities.BIKING_STATIONARY),
    BIKING_UTILITY(19, FitnessActivities.BIKING_UTILITY),
    BOXING(20, FitnessActivities.BOXING),
    CALISTHENICS(21, FitnessActivities.CALISTHENICS),
    CIRCUIT_TRAINING(22, FitnessActivities.CIRCUIT_TRAINING),
    CRICKET(23, FitnessActivities.CRICKET),
    CROSSFIT(113, FitnessActivities.CROSSFIT),
    CURLING(106, FitnessActivities.CURLING),
    DANCING(24, FitnessActivities.DANCING),
    DIVING(102, FitnessActivities.DIVING),
    ELEVATOR(117, FitnessActivities.ELEVATOR),
    ELLIPTICAL(25, FitnessActivities.ELLIPTICAL),
    ERGOMETER(103, FitnessActivities.ERGOMETER),
    ESCALATOR(118, FitnessActivities.ESCALATOR),
    EXITING_VEHICLE(6, "exiting_vehicle"),
    FENCING(26, FitnessActivities.FENCING),
    FLOSSING(121, "flossing"),
    FOOTBALL_AMERICAN(27, FitnessActivities.FOOTBALL_AMERICAN),
    FOOTBALL_AUSTRALIAN(28, FitnessActivities.FOOTBALL_AUSTRALIAN),
    FOOTBALL_SOCCER(29, FitnessActivities.FOOTBALL_SOCCER),
    FRISBEE_DISC(30, FitnessActivities.FRISBEE_DISC),
    GARDENING(31, FitnessActivities.GARDENING),
    GOLF(32, FitnessActivities.GOLF),
    GUIDED_BREATHING(122, FitnessActivities.GUIDED_BREATHING),
    GYMNASTICS(33, FitnessActivities.GYMNASTICS),
    HANDBALL(34, FitnessActivities.HANDBALL),
    HIGH_INTENSITY_INTERVAL_TRAINING(114, FitnessActivities.HIGH_INTENSITY_INTERVAL_TRAINING),
    HIKING(35, FitnessActivities.HIKING),
    HOCKEY(36, FitnessActivities.HOCKEY),
    HORSEBACK_RIDING(37, FitnessActivities.HORSEBACK_RIDING),
    HOUSEWORK(38, FitnessActivities.HOUSEWORK),
    ICE_SKATING(104, FitnessActivities.ICE_SKATING),
    INTERVAL_TRAINING(115, FitnessActivities.INTERVAL_TRAINING),
    IN_VEHICLE(0, FitnessActivities.IN_VEHICLE),
    JUMP_ROPE(39, FitnessActivities.JUMP_ROPE),
    KAYAKING(40, FitnessActivities.KAYAKING),
    KETTLEBELL_TRAINING(41, FitnessActivities.KETTLEBELL_TRAINING),
    KICKBOXING(42, FitnessActivities.KICKBOXING),
    KICK_SCOOTER(107, FitnessActivities.KICK_SCOOTER),
    KITESURFING(43, FitnessActivities.KITESURFING),
    MARTIAL_ARTS(44, FitnessActivities.MARTIAL_ARTS),
    MEDITATION(45, FitnessActivities.MEDITATION),
    MIXED_MARTIAL_ARTS(46, FitnessActivities.MIXED_MARTIAL_ARTS),
    ON_FOOT(2, FitnessActivities.ON_FOOT),
    OTHER(108, "other"),
    P90X(47, FitnessActivities.P90X),
    PARAGLIDING(48, FitnessActivities.PARAGLIDING),
    PILATES(49, FitnessActivities.PILATES),
    POLO(50, FitnessActivities.POLO),
    RACQUETBALL(51, FitnessActivities.RACQUETBALL),
    ROCK_CLIMBING(52, FitnessActivities.ROCK_CLIMBING),
    ROWING(53, FitnessActivities.ROWING),
    ROWING_MACHINE(54, FitnessActivities.ROWING_MACHINE),
    RUGBY(55, FitnessActivities.RUGBY),
    RUNNING(8, FitnessActivities.RUNNING),
    RUNNING_JOGGING(56, FitnessActivities.RUNNING_JOGGING),
    RUNNING_SAND(57, FitnessActivities.RUNNING_SAND),
    RUNNING_TREADMILL(58, FitnessActivities.RUNNING_TREADMILL),
    SAILING(59, FitnessActivities.SAILING),
    SCUBA_DIVING(60, FitnessActivities.SCUBA_DIVING),
    SKATEBOARDING(61, FitnessActivities.SKATEBOARDING),
    SKATING(62, FitnessActivities.SKATING),
    SKATING_CROSS(63, FitnessActivities.SKATING_CROSS),
    SKATING_INDOOR(105, FitnessActivities.SKATING_INDOOR),
    SKATING_INLINE(64, FitnessActivities.SKATING_INLINE),
    SKIING(65, FitnessActivities.SKIING),
    SKIING_BACK_COUNTRY(66, FitnessActivities.SKIING_BACK_COUNTRY),
    SKIING_CROSS_COUNTRY(67, FitnessActivities.SKIING_CROSS_COUNTRY),
    SKIING_DOWNHILL(68, FitnessActivities.SKIING_DOWNHILL),
    SKIING_KITE(69, FitnessActivities.SKIING_KITE),
    SKIING_ROLLER(70, FitnessActivities.SKIING_ROLLER),
    SLEDDING(71, FitnessActivities.SLEDDING),
    SLEEP(72, "sleep"),
    SLEEP_AWAKE(112, FitnessActivities.SLEEP_AWAKE),
    SLEEP_DEEP(110, FitnessActivities.SLEEP_DEEP),
    SLEEP_LIGHT(109, FitnessActivities.SLEEP_LIGHT),
    SLEEP_REM(111, FitnessActivities.SLEEP_REM),
    SNOWBOARDING(73, FitnessActivities.SNOWBOARDING),
    SNOWMOBILE(74, FitnessActivities.SNOWMOBILE),
    SNOWSHOEING(75, FitnessActivities.SNOWSHOEING),
    SOFTBALL(120, FitnessActivities.SOFTBALL),
    SQUASH(76, FitnessActivities.SQUASH),
    STAIR_CLIMBING(77, FitnessActivities.STAIR_CLIMBING),
    STAIR_CLIMBING_MACHINE(78, FitnessActivities.STAIR_CLIMBING_MACHINE),
    STANDUP_PADDLEBOARDING(79, FitnessActivities.STANDUP_PADDLEBOARDING),
    STILL(3, FitnessActivities.STILL),
    STRENGTH_TRAINING(80, FitnessActivities.STRENGTH_TRAINING),
    SURFING(81, FitnessActivities.SURFING),
    SWIMMING(82, FitnessActivities.SWIMMING),
    SWIMMING_OPEN_WATER(84, FitnessActivities.SWIMMING_OPEN_WATER),
    SWIMMING_POOL(83, FitnessActivities.SWIMMING_POOL),
    TABLE_TENNIS(85, FitnessActivities.TABLE_TENNIS),
    TEAM_SPORTS(86, FitnessActivities.TEAM_SPORTS),
    TENNIS(87, FitnessActivities.TENNIS),
    TILTING(5, FitnessActivities.TILTING),
    TREADMILL(88, FitnessActivities.TREADMILL),
    UNKNOWN(4, "unknown"),
    VOLLEYBALL(89, FitnessActivities.VOLLEYBALL),
    VOLLEYBALL_BEACH(90, FitnessActivities.VOLLEYBALL_BEACH),
    VOLLEYBALL_INDOOR(91, FitnessActivities.VOLLEYBALL_INDOOR),
    WAKEBOARDING(92, FitnessActivities.WAKEBOARDING),
    WALKING(7, "walking"),
    WALKING_FITNESS(93, FitnessActivities.WALKING_FITNESS),
    WALKING_NORDIC(94, FitnessActivities.WALKING_NORDIC),
    WALKING_PACED(123, FitnessActivities.WALKING_PACED),
    WALKING_STROLLER(116, FitnessActivities.WALKING_STROLLER),
    WALKING_TREADMILL(95, FitnessActivities.WALKING_TREADMILL),
    WATER_POLO(96, FitnessActivities.WATER_POLO),
    WEIGHTLIFTING(97, FitnessActivities.WEIGHTLIFTING),
    WHEELCHAIR(98, FitnessActivities.WHEELCHAIR),
    WINDSURFING(99, FitnessActivities.WINDSURFING),
    YOGA(100, FitnessActivities.YOGA),
    ZUMBA(101, FitnessActivities.ZUMBA);

    private static final zzfw zzbu;
    private static final zzga zzbv;
    private final int zzbx;
    private final String zzby;

    static {
        EnumSet allOf = EnumSet.allOf(zzgp.class);
        ArrayList arrayList = new ArrayList(Collections.nCopies(allOf.size(), null));
        Iterator it = allOf.iterator();
        while (it.hasNext()) {
            zzgp zzgpVar = (zzgp) it.next();
            arrayList.set(zzgpVar.zzbx, zzgpVar);
        }
        zzbu = zzfw.zzh(arrayList);
        zzbv = zzga.zzi(Integer.valueOf(SLEEP.zzbx), Integer.valueOf(SLEEP_AWAKE.zzbx), Integer.valueOf(SLEEP_DEEP.zzbx), Integer.valueOf(SLEEP_LIGHT.zzbx), Integer.valueOf(SLEEP_REM.zzbx));
    }

    zzgp(int i, String str) {
        this.zzbx = i;
        this.zzby = str;
    }

    public static zzgp zza(int i, zzgp zzgpVar) {
        if (i >= 0) {
            zzfw zzfwVar = zzbu;
            if (i < zzfwVar.size()) {
                return (zzgp) zzfwVar.get(i);
            }
        }
        return zzgpVar;
    }

    public final boolean zzb() {
        return zzbv.contains(Integer.valueOf(this.zzbx));
    }
}
