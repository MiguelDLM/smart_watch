package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleActivity extends BleReadable {
    public static final int AEROBICS = 51;
    public static final int AEROBIC_EXERCISE = 22;
    public static final int ARCHERY = 62;
    public static final int AUTO_NONE = 1;
    public static final int AUTO_RUN = 3;
    public static final int AUTO_WALK = 2;
    public static final int BACK_TRAINING = 107;
    public static final int BADMINTON = 18;
    public static final int BALLET = 76;
    public static final int BALLROOM_DANCE = 162;
    public static final int BARBELL = 117;
    public static final int BASEBALL = 34;
    public static final int BASKETBALL = 16;
    public static final int BATTLE_ROPES = 124;
    public static final int BEACH_SOCCER = 152;
    public static final int BEACH_VOLLEYBALL = 153;
    public static final int BEGIN = 0;
    public static final int BILLIARDS = 83;
    public static final int BOARD_GAMES = 145;
    public static final int BOATING = 147;
    public static final int BOBSLEIGH = 133;
    public static final int BOCCE_BALL = 155;
    public static final int BODY_BALANCE = 113;
    public static final int BODY_COMBAT = 112;
    public static final int BODY_EXERCISE = 56;
    public static final int BOWLING = 64;
    public static final int BOXING = 25;
    public static final int BREAK_DANCE = 161;
    public static final int BRIDGE = 144;
    public static final int CHESS = 141;
    public static final int CLIMBING = 13;
    public static final int CLIMB_STAIRS = 27;
    public static final int CORE_TRAINING = 127;
    public static final int CRICHKET = 49;
    public static final int CROQUET = 102;
    public static final int CROSSFIT = 99;
    public static final int CROSS_TRAINING = 130;
    public static final int CYCLING = 10;

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int DANCE = 35;
    public static final int DANCE_STREET = 41;
    public static final int DARTS = 44;
    public static final int DISCO = 77;
    public static final int DISCUS = 85;
    public static final int DODGEBALL = 157;
    public static final int DOUBLE_ROD = 123;
    public static final int DRAUGHTS = 142;
    public static final int DUM_BLE = 55;
    public static final int ELLIPIICAL = 47;
    public static final int END = 4;
    public static final int FENCING = 58;
    public static final int FIGHTING = 119;
    public static final int FISHING = 72;
    public static final int FLOOR_BALL = 103;
    public static final int FLYING_KITES = 139;
    public static final int FOLK_DANCE = 158;
    public static final int FOOTBALL = 17;
    public static final int FREE_EXERCISE = 21;
    public static final int FRISBEE = 61;
    public static final int GAME = 116;
    public static final int GATEBALL = 156;
    public static final int GO = 143;
    public static final int GOLF = 33;
    public static final int GYMNASTICS = 45;
    public static final int HAMMER = 93;
    public static final int HANDBALL = 40;
    public static final int HANDWHEEL = 125;
    public static final int HIGH_JUMP = 88;
    public static final int HIIT = 111;
    public static final int HIPHOP_DANCE = 160;
    public static final int HOCKEY = 37;
    public static final int HORSE_RIDING = 63;
    public static final int HULA_HOOP = 32;
    public static final int HUNT = 137;
    public static final int ICE_HOCKEY = 132;
    public static final int INDOOR = 8;
    public static final int INDOOR_WALKING = 20;
    public static final int ITEM_LENGTH = 16;
    public static final int JAI_BALL = 105;
    public static final int JAVELIN = 92;
    public static final int JAZZ_DANCE = 75;
    public static final int JUMP_ROPE = 26;
    public static final int KARATE = 57;
    public static final int KAYAK = 101;
    public static final int KAYAK_RAFTING = 136;
    public static final int KETTLEBELL = 118;
    public static final int KITE_KICKING = 140;
    public static final int LATIN_DANCE = 159;
    public static final int LEG_PRESS = 95;
    public static final int LONG_JUMP = 91;
    public static final int LOWER_LIMBS = 121;
    public static final int MARATHON = 19;
    public static final int MARTIAL_ARTS = 59;
    public static final int MIXED_AEROBICS = 129;
    public static final int MODERN_DANCE = 79;
    public static final int MOTOCROSS = 97;
    public static final int MOTORBOAT = 148;
    public static final int MOUNTAIN_CLIMBER = 110;
    public static final int OFF_ROAD_BIKE = 96;
    public static final int ONGOING = 1;
    public static final int OUTDOOR = 9;
    public static final int PADDLE_BOARD = 135;
    public static final int PARACHUTE = 89;
    public static final int PAUSE = 2;
    public static final int PILATES = 38;
    public static final int PING_PONG = 36;
    public static final int PLANK = 82;
    public static final int PLAYING = 146;
    public static final int POLE_DANCING = 73;
    public static final int POLO = 149;
    public static final int PULL_UP = 69;
    public static final int PUSH_UPS = 80;
    public static final int RACE_RIDING = 86;
    public static final int RESUME = 3;
    public static final int ROCK_CLIMBING = 84;
    public static final int ROLLER_SKATING = 30;
    public static final int ROWING = 98;
    public static final int ROWING_MACHINE = 52;
    public static final int RUGBY = 53;
    public static final int RUNNING = 7;
    public static final int SAILBOAT = 68;
    public static final int SANDBAG_BALL = 154;
    public static final int SCOOTER = 81;
    public static final int SHOT_PUT = 90;
    public static final int SHUTTLECOCK = 151;
    public static final int SINGLE_POLE = 122;
    public static final int SIT_UP = 54;
    public static final int SKATE = 29;
    public static final int SKATEBOARD = 70;
    public static final int SKI = 28;
    public static final int SLED = 134;
    public static final int SOFTBALL = 66;
    public static final int SPINNING = 15;
    public static final int SQUARE_DANCE = 74;
    public static final int SQUASH = 67;
    public static final int SQUAT = 94;
    public static final int STEPPING = 46;
    public static final int STEP_TRAINING = 131;
    public static final int STRETCH = 128;
    public static final int SURF = 65;
    public static final int SWIMMING = 11;
    public static final int TAEKWONDO = 39;
    public static final int TAE_BO = 115;
    public static final int TAI_CHI = 60;
    public static final int TAP_DANCE = 78;
    public static final int TENNIS = 43;
    public static final int TENNIS_DOUBLES = 106;
    public static final int THAI = 104;
    public static final int TRACK_AND_FIELD = 126;
    public static final int TRAMPOLINE = 71;
    public static final int TREKKING = 50;
    public static final int TRX = 114;
    public static final int TUG_OF_WAR = 138;
    public static final int UPPER_LIMBS = 120;
    public static final int VOLLEYBALL = 42;
    public static final int WALKING = 12;
    public static final int WATER_BIKE = 100;
    public static final int WATER_POLO = 150;
    public static final int WATER_SKIING = 109;
    public static final int WATER_VOLLEYBALL = 108;
    public static final int WEIGHTLIFTING = 24;
    public static final int WEIGHTTRANNING = 23;
    public static final int WRESTLING = 87;
    public static final int YOGA = 14;
    public static final int ZUMBA = 48;
    private int mCalorie;
    private int mDistance;
    private int mMode;
    private int mState;
    private int mStep;
    private int mTime;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleActivity() {
        this(0, 0, 0, 0, 0, 0, 63, null);
    }

    public static /* synthetic */ BleActivity copy$default(BleActivity bleActivity, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = bleActivity.mTime;
        }
        if ((i7 & 2) != 0) {
            i2 = bleActivity.mMode;
        }
        int i8 = i2;
        if ((i7 & 4) != 0) {
            i3 = bleActivity.mState;
        }
        int i9 = i3;
        if ((i7 & 8) != 0) {
            i4 = bleActivity.mStep;
        }
        int i10 = i4;
        if ((i7 & 16) != 0) {
            i5 = bleActivity.mCalorie;
        }
        int i11 = i5;
        if ((i7 & 32) != 0) {
            i6 = bleActivity.mDistance;
        }
        return bleActivity.copy(i, i8, i9, i10, i11, i6);
    }

    public final int component1() {
        return this.mTime;
    }

    public final int component2() {
        return this.mMode;
    }

    public final int component3() {
        return this.mState;
    }

    public final int component4() {
        return this.mStep;
    }

    public final int component5() {
        return this.mCalorie;
    }

    public final int component6() {
        return this.mDistance;
    }

    @OOXIXo
    public final BleActivity copy(int i, int i2, int i3, int i4, int i5, int i6) {
        return new BleActivity(i, i2, i3, i4, i5, i6);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mTime = BleReadable.readInt32$default(this, null, 1, null);
        this.mMode = readIntN(5);
        this.mState = readIntN(3);
        this.mStep = BleReadable.readInt24$default(this, null, 1, null);
        this.mCalorie = BleReadable.readInt32$default(this, null, 1, null);
        this.mDistance = BleReadable.readInt32$default(this, null, 1, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleActivity)) {
            return false;
        }
        BleActivity bleActivity = (BleActivity) obj;
        return this.mTime == bleActivity.mTime && this.mMode == bleActivity.mMode && this.mState == bleActivity.mState && this.mStep == bleActivity.mStep && this.mCalorie == bleActivity.mCalorie && this.mDistance == bleActivity.mDistance;
    }

    public final int getMCalorie() {
        return this.mCalorie;
    }

    public final int getMDistance() {
        return this.mDistance;
    }

    public final int getMMode() {
        return this.mMode;
    }

    public final int getMState() {
        return this.mState;
    }

    public final int getMStep() {
        return this.mStep;
    }

    public final int getMTime() {
        return this.mTime;
    }

    public int hashCode() {
        return (((((((((this.mTime * 31) + this.mMode) * 31) + this.mState) * 31) + this.mStep) * 31) + this.mCalorie) * 31) + this.mDistance;
    }

    public final void setMCalorie(int i) {
        this.mCalorie = i;
    }

    public final void setMDistance(int i) {
        this.mDistance = i;
    }

    public final void setMMode(int i) {
        this.mMode = i;
    }

    public final void setMState(int i) {
        this.mState = i;
    }

    public final void setMStep(int i) {
        this.mStep = i;
    }

    public final void setMTime(int i) {
        this.mTime = i;
    }

    @OOXIXo
    public String toString() {
        return "BleActivity(mTime=" + this.mTime + ", mMode=" + this.mMode + ", mState=" + this.mState + ", mStep=" + this.mStep + ", mCalorie=" + this.mCalorie + ", mDistance=" + this.mDistance + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleActivity(int i, int i2, int i3, int i4, int i5, int i6, int i7, IIXOooo iIXOooo) {
        this((i7 & 1) != 0 ? 0 : i, (i7 & 2) != 0 ? 0 : i2, (i7 & 4) != 0 ? 0 : i3, (i7 & 8) != 0 ? 0 : i4, (i7 & 16) != 0 ? 0 : i5, (i7 & 32) != 0 ? 0 : i6);
    }

    public BleActivity(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mTime = i;
        this.mMode = i2;
        this.mState = i3;
        this.mStep = i4;
        this.mCalorie = i5;
        this.mDistance = i6;
    }
}
