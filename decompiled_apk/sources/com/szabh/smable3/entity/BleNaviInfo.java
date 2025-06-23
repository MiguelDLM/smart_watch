package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.collection.oIX0oI;
import com.bestmafen.baseble.data.BleWritable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.text.oxoX;

/* loaded from: classes13.dex */
public final class BleNaviInfo extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int NAME_MAX_LENGTH = 232;
    public static final int NAVI_END = 4;
    public static final int NAVI_GOING = 1;
    public static final int NAVI_PAUSE = 2;
    public static final int NAVI_RESUME = 3;
    public static final int NAVI_START = 0;
    public static final int TURN_ALONG = 0;
    public static final int TURN_BACK = 1;
    public static final int TURN_BACK_2BRANCH_LEFT = 2;
    public static final int TURN_BACK_2BRANCH_RIGHT = 3;
    public static final int TURN_BACK_3BRANCH_CENTER = 4;
    public static final int TURN_BACK_3BRANCH_LEFT = 5;
    public static final int TURN_BACK_3BRANCH_RIGHT = 6;
    public static final int TURN_BRANCH_CENTER = 7;
    public static final int TURN_BRANCH_LEFT = 8;
    public static final int TURN_BRANCH_LEFT_STRAIGHT = 9;
    public static final int TURN_BRANCH_RIGHT = 10;
    public static final int TURN_BRANCH_RIGHT_STRAIGHT = 11;
    public static final int TURN_DEST = 12;
    public static final int TURN_FRONT = 13;
    public static final int TURN_INFERRY = 14;
    public static final int TURN_LB_2BRANCH_LEFT = 15;
    public static final int TURN_LB_2BRANCH_RIGHT = 16;
    public static final int TURN_LB_3BRANCH_CENTER = 17;
    public static final int TURN_LB_3BRANCH_LEFT = 18;
    public static final int TURN_LB_3BRANCH_RIGHT = 19;
    public static final int TURN_LEFT = 20;
    public static final int TURN_LEFT_BACK = 21;
    public static final int TURN_LEFT_FRONT = 22;
    public static final int TURN_LEFT_SIDE = 23;
    public static final int TURN_LEFT_SIDE_IC = 24;
    public static final int TURN_LEFT_SIDE_MAIN = 25;
    public static final int TURN_LF_2BRANCH_LEFT = 26;
    public static final int TURN_LF_2BRANCH_RIGHT = 27;
    public static final int TURN_RB_2BRANCH_LEFT = 28;
    public static final int TURN_RB_2BRANCH_RIGHT = 29;
    public static final int TURN_RB_3BRANCH_CENTER = 30;
    public static final int TURN_RB_3BRANCH_LEFT = 31;
    public static final int TURN_RB_3BRANCH_RIGHT = 32;
    public static final int TURN_RF_2BRANCH_LEFT = 33;
    public static final int TURN_RF_2BRANCH_RIGHT = 34;
    public static final int TURN_RIGHT = 35;
    public static final int TURN_RIGHT_BACK = 36;
    public static final int TURN_RIGHT_FRONT = 37;
    public static final int TURN_RIGHT_SIDE = 38;
    public static final int TURN_RIGHT_SIDE_IC = 39;
    public static final int TURN_RIGHT_SIDE_MAIN = 40;
    public static final int TURN_RING = 41;
    public static final int TURN_RING_FRONT = 42;
    public static final int TURN_RING_LEFT = 43;
    public static final int TURN_RING_LEFTBACK = 44;
    public static final int TURN_RING_LEFTFRONT = 45;
    public static final int TURN_RING_RIGHT = 46;
    public static final int TURN_RING_RIGHTBACK = 47;
    public static final int TURN_RING_RIGHTFRONT = 48;
    public static final int TURN_RING_TURNBACK = 49;
    private int mDistance;
    private int mMode;
    private int mRemainDistance;
    private int mRemainTime;

    @OOXIXo
    private String mRoadName;
    private int mSpeed;
    private int mState;
    private long mTime;
    private int mTurnType;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        public final int bdTurnIconNameToType(@OOXIXo String turnIconName) {
            IIX0o.x0xO0oo(turnIconName, "turnIconName");
            switch (turnIconName.hashCode()) {
                case -2118620201:
                    if (!turnIconName.equals("turn_back_3branch_right.png")) {
                        return 0;
                    }
                    return 6;
                case -2042173033:
                    if (!turnIconName.equals("turn_ring_front.png")) {
                        return 0;
                    }
                    return 42;
                case -1890594296:
                    if (!turnIconName.equals("turn_left_side.png")) {
                        return 0;
                    }
                    return 23;
                case -1856743837:
                    if (!turnIconName.equals("turn_rf_2branch_right.png")) {
                        return 0;
                    }
                    return 34;
                case -1799532762:
                    if (!turnIconName.equals("turn_left_side_main.png")) {
                        return 0;
                    }
                    return 25;
                case -1736025363:
                    if (!turnIconName.equals("turn_ring.png")) {
                        return 0;
                    }
                    return 41;
                case -1655525354:
                    if (!turnIconName.equals("turn_ring_leftback.png")) {
                        return 0;
                    }
                    return 44;
                case -1549633778:
                    if (!turnIconName.equals("turn_inferry.png")) {
                        return 0;
                    }
                    return 14;
                case -1420513952:
                    if (!turnIconName.equals("turn_rb_3branch_right.png")) {
                        return 0;
                    }
                    return 32;
                case -1123731332:
                    if (!turnIconName.equals("turn_branch_right.png")) {
                        return 0;
                    }
                    return 10;
                case -1069071681:
                    if (!turnIconName.equals("turn_right_front.png")) {
                        return 0;
                    }
                    return 37;
                case -1039245827:
                    if (!turnIconName.equals("turn_branch_left.png")) {
                        return 0;
                    }
                    return 8;
                case -944844816:
                    if (!turnIconName.equals("turn_ring_leftfront.png")) {
                        return 0;
                    }
                    return 45;
                case -878361000:
                    if (!turnIconName.equals("turn_right_side_ic.png")) {
                        return 0;
                    }
                    return 39;
                case -753402194:
                    if (!turnIconName.equals("turn_left_front.png")) {
                        return 0;
                    }
                    return 22;
                case -569421649:
                    if (!turnIconName.equals("turn_ring_left.png")) {
                        return 0;
                    }
                    return 43;
                case -320878299:
                    if (!turnIconName.equals("turn_lb_2branch_right.png")) {
                        return 0;
                    }
                    return 16;
                case -99661865:
                    if (!turnIconName.equals("turn_right_side.png")) {
                        return 0;
                    }
                    return 38;
                case -78988135:
                    if (!turnIconName.equals("turn_rb_3branch_left.png")) {
                        return 0;
                    }
                    return 31;
                case 13218200:
                    if (!turnIconName.equals("turn_left_back.png")) {
                        return 0;
                    }
                    return 21;
                case 24534771:
                    if (!turnIconName.equals("turn_branch_right_straight.png")) {
                        return 0;
                    }
                    return 11;
                case 191541781:
                    if (!turnIconName.equals("turn_right.png")) {
                        return 0;
                    }
                    return 35;
                case 239499041:
                    if (!turnIconName.equals("turn_lb_3branch_center.png")) {
                        return 0;
                    }
                    return 17;
                case 255550837:
                    if (!turnIconName.equals("turn_ring_rightfront.png")) {
                        return 0;
                    }
                    return 48;
                case 295314103:
                    if (!turnIconName.equals("turn_right_side_main.png")) {
                        return 0;
                    }
                    return 40;
                case 431546042:
                    if (!turnIconName.equals("turn_rb_2branch_left.png")) {
                        return 0;
                    }
                    return 28;
                case 456824278:
                    turnIconName.equals("turn_along.png");
                    return 0;
                case 534537823:
                    if (!turnIconName.equals("turn_dest.png")) {
                        return 0;
                    }
                    return 12;
                case 555916298:
                    if (!turnIconName.equals("turn_ring_right.png")) {
                        return 0;
                    }
                    return 46;
                case 587315852:
                    if (!turnIconName.equals("turn_ring_turnback.png")) {
                        return 0;
                    }
                    return 49;
                case 596201513:
                    if (!turnIconName.equals("turn_lf_2branch_right.png")) {
                        return 0;
                    }
                    return 27;
                case 692875795:
                    if (!turnIconName.equals("turn_lb_3branch_left.png")) {
                        return 0;
                    }
                    return 18;
                case 738223926:
                    if (!turnIconName.equals("turn_rf_2branch_left.png")) {
                        return 0;
                    }
                    return 33;
                case 823037398:
                    if (!turnIconName.equals("turn_back_2branch_right.png")) {
                        return 0;
                    }
                    return 3;
                case 1032431398:
                    if (!turnIconName.equals("turn_lb_3branch_right.png")) {
                        return 0;
                    }
                    return 19;
                case 1154143729:
                    if (!turnIconName.equals("turn_ring_rightback.png")) {
                        return 0;
                    }
                    return 47;
                case 1203409972:
                    if (!turnIconName.equals("turn_lb_2branch_left.png")) {
                        return 0;
                    }
                    return 15;
                case 1219939652:
                    if (!turnIconName.equals("turn_left.png")) {
                        return 0;
                    }
                    return 20;
                case 1290328722:
                    if (!turnIconName.equals("turn_branch_left_straight.png")) {
                        return 0;
                    }
                    return 9;
                case 1341147280:
                    if (!turnIconName.equals("turn_back_3branch_center.png")) {
                        return 0;
                    }
                    return 4;
                case 1422512962:
                    if (!turnIconName.equals("turn_back_3branch_left.png")) {
                        return 0;
                    }
                    return 5;
                case 1507604519:
                    if (!turnIconName.equals("turn_rb_3branch_center.png")) {
                        return 0;
                    }
                    return 30;
                case 1510087856:
                    if (!turnIconName.equals("turn_lf_2branch_left.png")) {
                        return 0;
                    }
                    return 26;
                case 1521143647:
                    if (!turnIconName.equals("turn_rb_2branch_right.png")) {
                        return 0;
                    }
                    return 29;
                case 1622458916:
                    if (!turnIconName.equals("turn_back.png")) {
                        return 0;
                    }
                    return 1;
                case 1804150631:
                    if (!turnIconName.equals("turn_right_back.png")) {
                        return 0;
                    }
                    return 36;
                case 1832305287:
                    if (!turnIconName.equals("turn_left_side_ic.png")) {
                        return 0;
                    }
                    return 24;
                case 1888419746:
                    if (!turnIconName.equals("turn_front.png")) {
                        return 0;
                    }
                    return 13;
                case 1933047139:
                    if (!turnIconName.equals("turn_back_2branch_left.png")) {
                        return 0;
                    }
                    return 2;
                case 2117931147:
                    if (!turnIconName.equals("turn_branch_center.png")) {
                        return 0;
                    }
                    return 7;
                default:
                    return 0;
            }
        }

        private Companion() {
        }
    }

    public BleNaviInfo() {
        this(0, 0L, 0, 0, 0, 0, 0, 0, null, 511, null);
    }

    public final int component1() {
        return this.mState;
    }

    public final long component2() {
        return this.mTime;
    }

    public final int component3() {
        return this.mTurnType;
    }

    public final int component4() {
        return this.mRemainDistance;
    }

    public final int component5() {
        return this.mRemainTime;
    }

    public final int component6() {
        return this.mDistance;
    }

    public final int component7() {
        return this.mSpeed;
    }

    public final int component8() {
        return this.mMode;
    }

    @OOXIXo
    public final String component9() {
        return this.mRoadName;
    }

    @OOXIXo
    public final BleNaviInfo copy(int i, long j, int i2, int i3, int i4, int i5, int i6, int i7, @OOXIXo String mRoadName) {
        IIX0o.x0xO0oo(mRoadName, "mRoadName");
        return new BleNaviInfo(i, j, i2, i3, i4, i5, i6, i7, mRoadName);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mState = readInt8();
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mState);
        writeObject(BleTime.Companion.ofLocal(this.mTime));
        writeInt8(this.mTurnType);
        BleWritable.writeInt32$default(this, this.mRemainDistance, null, 2, null);
        BleWritable.writeInt32$default(this, this.mRemainTime, null, 2, null);
        BleWritable.writeInt32$default(this, this.mDistance, null, 2, null);
        writeInt8(this.mSpeed);
        writeInt8(this.mMode);
        byte[] bytes = this.mRoadName.getBytes(oxoX.f29581II0xO0);
        IIX0o.oO(bytes, "getBytes(...)");
        BleWritable.writeInt16$default(this, Math.min(bytes.length, 232), null, 2, null);
        BleWritable.writeStringWithLimit$default(this, this.mRoadName, 232, null, true, 4, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleNaviInfo)) {
            return false;
        }
        BleNaviInfo bleNaviInfo = (BleNaviInfo) obj;
        return this.mState == bleNaviInfo.mState && this.mTime == bleNaviInfo.mTime && this.mTurnType == bleNaviInfo.mTurnType && this.mRemainDistance == bleNaviInfo.mRemainDistance && this.mRemainTime == bleNaviInfo.mRemainTime && this.mDistance == bleNaviInfo.mDistance && this.mSpeed == bleNaviInfo.mSpeed && this.mMode == bleNaviInfo.mMode && IIX0o.Oxx0IOOO(this.mRoadName, bleNaviInfo.mRoadName);
    }

    public final int getMDistance() {
        return this.mDistance;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        byte[] bytes = this.mRoadName.getBytes(oxoX.f29581II0xO0);
        IIX0o.oO(bytes, "getBytes(...)");
        return Math.min(bytes.length, 232) + 24;
    }

    public final int getMMode() {
        return this.mMode;
    }

    public final int getMRemainDistance() {
        return this.mRemainDistance;
    }

    public final int getMRemainTime() {
        return this.mRemainTime;
    }

    @OOXIXo
    public final String getMRoadName() {
        return this.mRoadName;
    }

    public final int getMSpeed() {
        return this.mSpeed;
    }

    public final int getMState() {
        return this.mState;
    }

    public final long getMTime() {
        return this.mTime;
    }

    public final int getMTurnType() {
        return this.mTurnType;
    }

    public int hashCode() {
        return (((((((((((((((this.mState * 31) + oIX0oI.oIX0oI(this.mTime)) * 31) + this.mTurnType) * 31) + this.mRemainDistance) * 31) + this.mRemainTime) * 31) + this.mDistance) * 31) + this.mSpeed) * 31) + this.mMode) * 31) + this.mRoadName.hashCode();
    }

    public final void setMDistance(int i) {
        this.mDistance = i;
    }

    public final void setMMode(int i) {
        this.mMode = i;
    }

    public final void setMRemainDistance(int i) {
        this.mRemainDistance = i;
    }

    public final void setMRemainTime(int i) {
        this.mRemainTime = i;
    }

    public final void setMRoadName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mRoadName = str;
    }

    public final void setMSpeed(int i) {
        this.mSpeed = i;
    }

    public final void setMState(int i) {
        this.mState = i;
    }

    public final void setMTime(long j) {
        this.mTime = j;
    }

    public final void setMTurnType(int i) {
        this.mTurnType = i;
    }

    @OOXIXo
    public String toString() {
        return "BleNaviInfo(mState=" + this.mState + ", mTime=" + this.mTime + ", mTurnType=" + this.mTurnType + ", mRemainDistance=" + this.mRemainDistance + ", mRemainTime=" + this.mRemainTime + ", mDistance=" + this.mDistance + ", mSpeed=" + this.mSpeed + ", mMode=" + this.mMode + ", mRoadName='" + this.mRoadName + "')";
    }

    public /* synthetic */ BleNaviInfo(int i, long j, int i2, int i3, int i4, int i5, int i6, int i7, String str, int i8, IIXOooo iIXOooo) {
        this((i8 & 1) != 0 ? 0 : i, (i8 & 2) != 0 ? 0L : j, (i8 & 4) != 0 ? 0 : i2, (i8 & 8) != 0 ? 0 : i3, (i8 & 16) != 0 ? 0 : i4, (i8 & 32) != 0 ? 0 : i5, (i8 & 64) != 0 ? 0 : i6, (i8 & 128) == 0 ? i7 : 0, (i8 & 256) != 0 ? "" : str);
    }

    public BleNaviInfo(int i, long j, int i2, int i3, int i4, int i5, int i6, int i7, @OOXIXo String mRoadName) {
        IIX0o.x0xO0oo(mRoadName, "mRoadName");
        this.mState = i;
        this.mTime = j;
        this.mTurnType = i2;
        this.mRemainDistance = i3;
        this.mRemainTime = i4;
        this.mDistance = i5;
        this.mSpeed = i6;
        this.mMode = i7;
        this.mRoadName = mRoadName;
    }
}
