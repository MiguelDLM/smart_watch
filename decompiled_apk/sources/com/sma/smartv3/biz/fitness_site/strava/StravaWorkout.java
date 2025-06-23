package com.sma.smartv3.biz.fitness_site.strava;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.collection.oIX0oI;
import com.garmin.fit.Sport;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class StravaWorkout {

    @OOXIXo
    private static final String ALPINE_SKI = "AlpineSki";

    @OOXIXo
    private static final String BACKCOUNTRY_SKI = "BackcountrySki";

    @OOXIXo
    private static final String CANOEING = "Canoeing";

    @OOXIXo
    private static final String CROSSFIT = "Crossfit";

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private static final String ELLIPTICAL = "Elliptical";

    @OOXIXo
    private static final String E_BIKE_RIDE = "EBikeRide";

    @OOXIXo
    private static final String GOLF = "Golf";

    @OOXIXo
    private static final String HANDCYCLE = "Handcycle";

    @OOXIXo
    private static final String HIKE = "Hike";

    @OOXIXo
    private static final String ICE_SKATE = "IceSkate";

    @OOXIXo
    private static final String INLINE_SKATE = "InlineSkate";

    @OOXIXo
    private static final String KAYAKING = "Kayaking";

    @OOXIXo
    private static final String KITESURF = "Kitesurf";

    @OOXIXo
    private static final String NORDIC_SKI = "NordicSki";

    @OOXIXo
    private static final String RIDE = "Ride";

    @OOXIXo
    private static final String ROCK_CLIMBING = "RockClimbing";

    @OOXIXo
    private static final String ROLLER_SKI = "RollerSki";

    @OOXIXo
    private static final String ROWING = "Rowing";

    @OOXIXo
    private static final String RUN = "Run";

    @OOXIXo
    private static final String SAIL = "Sail";

    @OOXIXo
    private static final String SKATEBOARD = "Skateboard";

    @OOXIXo
    private static final String SNOWBOARD = "Snowboard";

    @OOXIXo
    private static final String SNOWSHOE = "Snowshoe";

    @OOXIXo
    private static final String SOCCER = "Soccer";

    @OOXIXo
    private static final String STAIR_STEPPER = "StairStepper";

    @OOXIXo
    private static final String STAND_UP_PADDLING = "StandUpPaddling";

    @OOXIXo
    private static final String SURFING = "Surfing";

    @OOXIXo
    private static final String SWIM = "Swim";

    @OOXIXo
    private static final String VELOMOBILE = "Velomobile";

    @OOXIXo
    private static final String VIRTUAL_RIDE = "VirtualRide";

    @OOXIXo
    private static final String VIRTUAL_RUN = "VirtualRun";

    @OOXIXo
    private static final String WALK = "Walk";

    @OOXIXo
    private static final String WEIGHT_TRAINING = "WeightTraining";

    @OOXIXo
    private static final String WHEELCHAIR = "Wheelchair";

    @OOXIXo
    private static final String WINDSURF = "Windsurf";

    @OOXIXo
    private static final String WORKOUT = "Workout";

    @OOXIXo
    private static final String YOGA = "Yoga";
    private int mAvgBpm;
    private int mCalorie;
    private int mCommute;

    @OOXIXo
    private String mDescription;
    private int mDistance;
    private long mElapsedTime;
    private long mEnd;
    private int mMaxBpm;
    private int mMinBpm;
    private int mMode;

    @OOXIXo
    private String mName;
    private long mStart;

    @OOXIXo
    private String mStartTime;
    private int mTrainer;

    @OOXIXo
    private String mType;

    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final String getTypeByActivityMode(int i) {
            if (i != 7) {
                if (i != 14) {
                    switch (i) {
                        case 10:
                            return StravaWorkout.RIDE;
                        case 11:
                            return StravaWorkout.SWIM;
                        case 12:
                            return StravaWorkout.WALK;
                        default:
                            return StravaWorkout.WORKOUT;
                    }
                }
                return StravaWorkout.YOGA;
            }
            return StravaWorkout.RUN;
        }

        @OOXIXo
        public final Sport getTypeByActivityModeType(int i) {
            if (i != 7) {
                switch (i) {
                    case 10:
                        return Sport.CYCLING;
                    case 11:
                        return Sport.SWIMMING;
                    case 12:
                        return Sport.WALKING;
                    default:
                        return Sport.GENERIC;
                }
            }
            return Sport.RUNNING;
        }

        private Companion() {
        }
    }

    public StravaWorkout() {
        this(null, null, null, 0L, null, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 32767, null);
    }

    @OOXIXo
    public final String component1() {
        return this.mName;
    }

    public final long component10() {
        return this.mEnd;
    }

    public final int component11() {
        return this.mMode;
    }

    public final int component12() {
        return this.mCalorie;
    }

    public final int component13() {
        return this.mAvgBpm;
    }

    public final int component14() {
        return this.mMaxBpm;
    }

    public final int component15() {
        return this.mMinBpm;
    }

    @OOXIXo
    public final String component2() {
        return this.mType;
    }

    @OOXIXo
    public final String component3() {
        return this.mStartTime;
    }

    public final long component4() {
        return this.mElapsedTime;
    }

    @OOXIXo
    public final String component5() {
        return this.mDescription;
    }

    public final int component6() {
        return this.mDistance;
    }

    public final int component7() {
        return this.mTrainer;
    }

    public final int component8() {
        return this.mCommute;
    }

    public final long component9() {
        return this.mStart;
    }

    @OOXIXo
    public final StravaWorkout copy(@OOXIXo String mName, @OOXIXo String mType, @OOXIXo String mStartTime, long j, @OOXIXo String mDescription, int i, int i2, int i3, long j2, long j3, int i4, int i5, int i6, int i7, int i8) {
        IIX0o.x0xO0oo(mName, "mName");
        IIX0o.x0xO0oo(mType, "mType");
        IIX0o.x0xO0oo(mStartTime, "mStartTime");
        IIX0o.x0xO0oo(mDescription, "mDescription");
        return new StravaWorkout(mName, mType, mStartTime, j, mDescription, i, i2, i3, j2, j3, i4, i5, i6, i7, i8);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StravaWorkout)) {
            return false;
        }
        StravaWorkout stravaWorkout = (StravaWorkout) obj;
        return IIX0o.Oxx0IOOO(this.mName, stravaWorkout.mName) && IIX0o.Oxx0IOOO(this.mType, stravaWorkout.mType) && IIX0o.Oxx0IOOO(this.mStartTime, stravaWorkout.mStartTime) && this.mElapsedTime == stravaWorkout.mElapsedTime && IIX0o.Oxx0IOOO(this.mDescription, stravaWorkout.mDescription) && this.mDistance == stravaWorkout.mDistance && this.mTrainer == stravaWorkout.mTrainer && this.mCommute == stravaWorkout.mCommute && this.mStart == stravaWorkout.mStart && this.mEnd == stravaWorkout.mEnd && this.mMode == stravaWorkout.mMode && this.mCalorie == stravaWorkout.mCalorie && this.mAvgBpm == stravaWorkout.mAvgBpm && this.mMaxBpm == stravaWorkout.mMaxBpm && this.mMinBpm == stravaWorkout.mMinBpm;
    }

    public final int getMAvgBpm() {
        return this.mAvgBpm;
    }

    public final int getMCalorie() {
        return this.mCalorie;
    }

    public final int getMCommute() {
        return this.mCommute;
    }

    @OOXIXo
    public final String getMDescription() {
        return this.mDescription;
    }

    public final int getMDistance() {
        return this.mDistance;
    }

    public final long getMElapsedTime() {
        return this.mElapsedTime;
    }

    public final long getMEnd() {
        return this.mEnd;
    }

    public final int getMMaxBpm() {
        return this.mMaxBpm;
    }

    public final int getMMinBpm() {
        return this.mMinBpm;
    }

    public final int getMMode() {
        return this.mMode;
    }

    @OOXIXo
    public final String getMName() {
        return this.mName;
    }

    public final long getMStart() {
        return this.mStart;
    }

    @OOXIXo
    public final String getMStartTime() {
        return this.mStartTime;
    }

    public final int getMTrainer() {
        return this.mTrainer;
    }

    @OOXIXo
    public final String getMType() {
        return this.mType;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((this.mName.hashCode() * 31) + this.mType.hashCode()) * 31) + this.mStartTime.hashCode()) * 31) + oIX0oI.oIX0oI(this.mElapsedTime)) * 31) + this.mDescription.hashCode()) * 31) + this.mDistance) * 31) + this.mTrainer) * 31) + this.mCommute) * 31) + oIX0oI.oIX0oI(this.mStart)) * 31) + oIX0oI.oIX0oI(this.mEnd)) * 31) + this.mMode) * 31) + this.mCalorie) * 31) + this.mAvgBpm) * 31) + this.mMaxBpm) * 31) + this.mMinBpm;
    }

    public final void setMAvgBpm(int i) {
        this.mAvgBpm = i;
    }

    public final void setMCalorie(int i) {
        this.mCalorie = i;
    }

    public final void setMCommute(int i) {
        this.mCommute = i;
    }

    public final void setMDescription(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mDescription = str;
    }

    public final void setMDistance(int i) {
        this.mDistance = i;
    }

    public final void setMElapsedTime(long j) {
        this.mElapsedTime = j;
    }

    public final void setMEnd(long j) {
        this.mEnd = j;
    }

    public final void setMMaxBpm(int i) {
        this.mMaxBpm = i;
    }

    public final void setMMinBpm(int i) {
        this.mMinBpm = i;
    }

    public final void setMMode(int i) {
        this.mMode = i;
    }

    public final void setMName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mName = str;
    }

    public final void setMStart(long j) {
        this.mStart = j;
    }

    public final void setMStartTime(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mStartTime = str;
    }

    public final void setMTrainer(int i) {
        this.mTrainer = i;
    }

    public final void setMType(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mType = str;
    }

    @OOXIXo
    public String toString() {
        return "StravaWorkout(mName=" + this.mName + ", mType=" + this.mType + ", mStartTime=" + this.mStartTime + ", mElapsedTime=" + this.mElapsedTime + ", mDescription=" + this.mDescription + ", mDistance=" + this.mDistance + ", mTrainer=" + this.mTrainer + ", mCommute=" + this.mCommute + ", mStart=" + this.mStart + ", mEnd=" + this.mEnd + ", mMode=" + this.mMode + ", mCalorie=" + this.mCalorie + ", mAvgBpm=" + this.mAvgBpm + ", mMaxBpm=" + this.mMaxBpm + ", mMinBpm=" + this.mMinBpm + HexStringBuilder.COMMENT_END_CHAR;
    }

    public StravaWorkout(@OOXIXo String mName, @OOXIXo String mType, @OOXIXo String mStartTime, long j, @OOXIXo String mDescription, int i, int i2, int i3, long j2, long j3, int i4, int i5, int i6, int i7, int i8) {
        IIX0o.x0xO0oo(mName, "mName");
        IIX0o.x0xO0oo(mType, "mType");
        IIX0o.x0xO0oo(mStartTime, "mStartTime");
        IIX0o.x0xO0oo(mDescription, "mDescription");
        this.mName = mName;
        this.mType = mType;
        this.mStartTime = mStartTime;
        this.mElapsedTime = j;
        this.mDescription = mDescription;
        this.mDistance = i;
        this.mTrainer = i2;
        this.mCommute = i3;
        this.mStart = j2;
        this.mEnd = j3;
        this.mMode = i4;
        this.mCalorie = i5;
        this.mAvgBpm = i6;
        this.mMaxBpm = i7;
        this.mMinBpm = i8;
    }

    public /* synthetic */ StravaWorkout(String str, String str2, String str3, long j, String str4, int i, int i2, int i3, long j2, long j3, int i4, int i5, int i6, int i7, int i8, int i9, IIXOooo iIXOooo) {
        this((i9 & 1) != 0 ? "" : str, (i9 & 2) != 0 ? "" : str2, (i9 & 4) != 0 ? "" : str3, (i9 & 8) != 0 ? 0L : j, (i9 & 16) == 0 ? str4 : "", (i9 & 32) != 0 ? 0 : i, (i9 & 64) != 0 ? 0 : i2, (i9 & 128) != 0 ? 0 : i3, (i9 & 256) != 0 ? 0L : j2, (i9 & 512) == 0 ? j3 : 0L, (i9 & 1024) != 0 ? 0 : i4, (i9 & 2048) != 0 ? 0 : i5, (i9 & 4096) != 0 ? 0 : i6, (i9 & 8192) != 0 ? 0 : i7, (i9 & 16384) != 0 ? 0 : i8);
    }
}
