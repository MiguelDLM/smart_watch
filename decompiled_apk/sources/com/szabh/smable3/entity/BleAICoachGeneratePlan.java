package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.collection.oIX0oI;
import com.bestmafen.baseble.data.BleReadable;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.szabh.smable3.entity.BleWeekPlanTime;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nBleAICoachPlan.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleAICoachPlan.kt\ncom/szabh/smable3/entity/BleAICoachGeneratePlan\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 BleReadable.kt\ncom/bestmafen/baseble/data/BleReadable\n*L\n1#1,337:1\n1549#2:338\n1620#2,3:339\n222#3,4:342\n222#3,4:346\n222#3,4:350\n232#3,3:354\n222#3,15:357\n*S KotlinDebug\n*F\n+ 1 BleAICoachPlan.kt\ncom/szabh/smable3/entity/BleAICoachGeneratePlan\n*L\n157#1:338\n157#1:339,3\n177#1:342,4\n180#1:346,4\n183#1:350,4\n201#1:354,3\n201#1:357,15\n*E\n"})
/* loaded from: classes13.dex */
public final class BleAICoachGeneratePlan extends BleWritable {
    private int mAllCalorie;
    private int mAllExerciseTime;
    private float mAll_METS;

    @OOXIXo
    private List<Integer> mCompletionMark;

    @OOXIXo
    private List<BleAICoachDayPlanCourse> mCourses;
    private int mPlanLevel;
    private long mPlanStartTime;
    private float mPlanTarget;

    @OOXIXo
    private List<Integer> mPlanTime;
    private int mProgress;

    public BleAICoachGeneratePlan() {
        this(null, null, 0L, 0.0f, 0, null, 0, 0, 0.0f, 0, 1023, null);
    }

    @OOXIXo
    public final List<Integer> component1() {
        return this.mPlanTime;
    }

    public final int component10() {
        return this.mAllCalorie;
    }

    @OOXIXo
    public final List<Integer> component2() {
        return this.mCompletionMark;
    }

    public final long component3() {
        return this.mPlanStartTime;
    }

    public final float component4() {
        return this.mPlanTarget;
    }

    public final int component5() {
        return this.mPlanLevel;
    }

    @OOXIXo
    public final List<BleAICoachDayPlanCourse> component6() {
        return this.mCourses;
    }

    public final int component7() {
        return this.mProgress;
    }

    public final int component8() {
        return this.mAllExerciseTime;
    }

    public final float component9() {
        return this.mAll_METS;
    }

    @OOXIXo
    public final BleAICoachGeneratePlan copy(@OOXIXo List<Integer> mPlanTime, @OOXIXo List<Integer> mCompletionMark, long j, float f, int i, @OOXIXo List<BleAICoachDayPlanCourse> mCourses, int i2, int i3, float f2, int i4) {
        IIX0o.x0xO0oo(mPlanTime, "mPlanTime");
        IIX0o.x0xO0oo(mCompletionMark, "mCompletionMark");
        IIX0o.x0xO0oo(mCourses, "mCourses");
        return new BleAICoachGeneratePlan(mPlanTime, mCompletionMark, j, f, i, mCourses, i2, i3, f2, i4);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        BleReadable bleReadable = (BleReadable) BleWeekPlanTime.class.newInstance();
        bleReadable.setMBytes(readBytes(4));
        bleReadable.decode();
        IIX0o.ooOOo0oXI(bleReadable);
        this.mPlanTime = ArraysKt___ArraysKt.X0XOOO(((BleWeekPlanTime) bleReadable).getMList());
        BleReadable bleReadable2 = (BleReadable) BleWeekPlanTime.class.newInstance();
        bleReadable2.setMBytes(readBytes(4));
        bleReadable2.decode();
        IIX0o.ooOOo0oXI(bleReadable2);
        this.mCompletionMark = ArraysKt___ArraysKt.X0XOOO(((BleWeekPlanTime) bleReadable2).getMList());
        BleReadable bleReadable3 = (BleReadable) BleAICoachTime.class.newInstance();
        bleReadable3.setMBytes(readBytes(8));
        bleReadable3.decode();
        IIX0o.ooOOo0oXI(bleReadable3);
        BleAICoachTime bleAICoachTime = (BleAICoachTime) bleReadable3;
        Calendar calendar = Calendar.getInstance();
        IIX0o.oO(calendar, "getInstance(...)");
        calendar.set(1, bleAICoachTime.getMYear());
        calendar.set(2, bleAICoachTime.getMMonth() - 1);
        calendar.set(5, bleAICoachTime.getMDay());
        calendar.set(11, bleAICoachTime.getMHour());
        calendar.set(12, bleAICoachTime.getMMinute());
        calendar.set(13, bleAICoachTime.getMSecond());
        calendar.set(14, 0);
        this.mPlanStartTime = calendar.getTimeInMillis();
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mPlanTarget = readFloat(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mPlanLevel = readInt32(LITTLE_ENDIAN);
        this.mCourses = new ArrayList();
        for (int i = 0; i < 7; i++) {
            BleAICoachDayPlanCourse bleAICoachDayPlanCourse = new BleAICoachDayPlanCourse(0, null, 0, 0.0f, 15, null);
            ByteOrder LITTLE_ENDIAN2 = ByteOrder.LITTLE_ENDIAN;
            IIX0o.oO(LITTLE_ENDIAN2, "LITTLE_ENDIAN");
            bleAICoachDayPlanCourse.setMCourseNumber(readInt32(LITTLE_ENDIAN2));
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < 6; i2++) {
                BleReadable bleReadable4 = (BleReadable) BleAICoachCourse.class.newInstance();
                bleReadable4.setMBytes(readBytes(16));
                bleReadable4.decode();
                IIX0o.ooOOo0oXI(bleReadable4);
                arrayList.add(bleReadable4);
            }
            bleAICoachDayPlanCourse.setMCoursesItem(arrayList);
            ByteOrder LITTLE_ENDIAN3 = ByteOrder.LITTLE_ENDIAN;
            IIX0o.oO(LITTLE_ENDIAN3, "LITTLE_ENDIAN");
            bleAICoachDayPlanCourse.setMCourseIndex(readInt32(LITTLE_ENDIAN3));
            IIX0o.oO(LITTLE_ENDIAN3, "LITTLE_ENDIAN");
            bleAICoachDayPlanCourse.setMCourseGoal(readFloat(LITTLE_ENDIAN3));
            this.mCourses.add(bleAICoachDayPlanCourse);
        }
        ByteOrder LITTLE_ENDIAN4 = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN4, "LITTLE_ENDIAN");
        this.mProgress = readInt32(LITTLE_ENDIAN4);
        IIX0o.oO(LITTLE_ENDIAN4, "LITTLE_ENDIAN");
        this.mAllExerciseTime = readInt32(LITTLE_ENDIAN4);
        IIX0o.oO(LITTLE_ENDIAN4, "LITTLE_ENDIAN");
        this.mAll_METS = readFloat(LITTLE_ENDIAN4);
        IIX0o.oO(LITTLE_ENDIAN4, "LITTLE_ENDIAN");
        this.mAllCalorie = readInt32(LITTLE_ENDIAN4);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        Object readBytes;
        super.encode();
        BleWeekPlanTime.Companion companion = BleWeekPlanTime.Companion;
        writeObject(companion.ofPlanTime(this.mPlanTime));
        writeObject(companion.ofPlanTime(this.mCompletionMark));
        writeObject(BleAICoachTime.Companion.ofLocal(this.mPlanStartTime));
        float f = this.mPlanTarget;
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeFloat(f, LITTLE_ENDIAN);
        int i = this.mPlanLevel;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt32(i, LITTLE_ENDIAN);
        List<BleAICoachDayPlanCourse> list = this.mCourses;
        ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(list, 10));
        for (BleAICoachDayPlanCourse bleAICoachDayPlanCourse : list) {
            if (bleAICoachDayPlanCourse.getMCourseNumber() == 6) {
                int mCourseNumber = bleAICoachDayPlanCourse.getMCourseNumber();
                ByteOrder LITTLE_ENDIAN2 = ByteOrder.LITTLE_ENDIAN;
                IIX0o.oO(LITTLE_ENDIAN2, "LITTLE_ENDIAN");
                writeInt32(mCourseNumber, LITTLE_ENDIAN2);
                writeList(bleAICoachDayPlanCourse.getMCoursesItem());
                int mCourseIndex = bleAICoachDayPlanCourse.getMCourseIndex();
                IIX0o.oO(LITTLE_ENDIAN2, "LITTLE_ENDIAN");
                writeInt32(mCourseIndex, LITTLE_ENDIAN2);
                float mCourseGoal = bleAICoachDayPlanCourse.getMCourseGoal();
                IIX0o.oO(LITTLE_ENDIAN2, "LITTLE_ENDIAN");
                writeFloat(mCourseGoal, LITTLE_ENDIAN2);
                readBytes = oXIO0o0XI.f29392oIX0oI;
            } else {
                readBytes = readBytes(108);
            }
            arrayList.add(readBytes);
        }
        int i2 = this.mProgress;
        ByteOrder LITTLE_ENDIAN3 = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN3, "LITTLE_ENDIAN");
        writeInt32(i2, LITTLE_ENDIAN3);
        int i3 = this.mAllExerciseTime;
        IIX0o.oO(LITTLE_ENDIAN3, "LITTLE_ENDIAN");
        writeInt32(i3, LITTLE_ENDIAN3);
        float f2 = this.mAll_METS;
        IIX0o.oO(LITTLE_ENDIAN3, "LITTLE_ENDIAN");
        writeFloat(f2, LITTLE_ENDIAN3);
        int i4 = this.mAllCalorie;
        IIX0o.oO(LITTLE_ENDIAN3, "LITTLE_ENDIAN");
        writeInt32(i4, LITTLE_ENDIAN3);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleAICoachGeneratePlan)) {
            return false;
        }
        BleAICoachGeneratePlan bleAICoachGeneratePlan = (BleAICoachGeneratePlan) obj;
        return IIX0o.Oxx0IOOO(this.mPlanTime, bleAICoachGeneratePlan.mPlanTime) && IIX0o.Oxx0IOOO(this.mCompletionMark, bleAICoachGeneratePlan.mCompletionMark) && this.mPlanStartTime == bleAICoachGeneratePlan.mPlanStartTime && Float.compare(this.mPlanTarget, bleAICoachGeneratePlan.mPlanTarget) == 0 && this.mPlanLevel == bleAICoachGeneratePlan.mPlanLevel && IIX0o.Oxx0IOOO(this.mCourses, bleAICoachGeneratePlan.mCourses) && this.mProgress == bleAICoachGeneratePlan.mProgress && this.mAllExerciseTime == bleAICoachGeneratePlan.mAllExerciseTime && Float.compare(this.mAll_METS, bleAICoachGeneratePlan.mAll_METS) == 0 && this.mAllCalorie == bleAICoachGeneratePlan.mAllCalorie;
    }

    public final int getMAllCalorie() {
        return this.mAllCalorie;
    }

    public final int getMAllExerciseTime() {
        return this.mAllExerciseTime;
    }

    public final float getMAll_METS() {
        return this.mAll_METS;
    }

    @OOXIXo
    public final List<Integer> getMCompletionMark() {
        return this.mCompletionMark;
    }

    @OOXIXo
    public final List<BleAICoachDayPlanCourse> getMCourses() {
        return this.mCourses;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 796;
    }

    public final int getMPlanLevel() {
        return this.mPlanLevel;
    }

    public final long getMPlanStartTime() {
        return this.mPlanStartTime;
    }

    public final float getMPlanTarget() {
        return this.mPlanTarget;
    }

    @OOXIXo
    public final List<Integer> getMPlanTime() {
        return this.mPlanTime;
    }

    public final int getMProgress() {
        return this.mProgress;
    }

    public int hashCode() {
        return (((((((((((((((((this.mPlanTime.hashCode() * 31) + this.mCompletionMark.hashCode()) * 31) + oIX0oI.oIX0oI(this.mPlanStartTime)) * 31) + Float.floatToIntBits(this.mPlanTarget)) * 31) + this.mPlanLevel) * 31) + this.mCourses.hashCode()) * 31) + this.mProgress) * 31) + this.mAllExerciseTime) * 31) + Float.floatToIntBits(this.mAll_METS)) * 31) + this.mAllCalorie;
    }

    public final void setMAllCalorie(int i) {
        this.mAllCalorie = i;
    }

    public final void setMAllExerciseTime(int i) {
        this.mAllExerciseTime = i;
    }

    public final void setMAll_METS(float f) {
        this.mAll_METS = f;
    }

    public final void setMCompletionMark(@OOXIXo List<Integer> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mCompletionMark = list;
    }

    public final void setMCourses(@OOXIXo List<BleAICoachDayPlanCourse> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mCourses = list;
    }

    public final void setMPlanLevel(int i) {
        this.mPlanLevel = i;
    }

    public final void setMPlanStartTime(long j) {
        this.mPlanStartTime = j;
    }

    public final void setMPlanTarget(float f) {
        this.mPlanTarget = f;
    }

    public final void setMPlanTime(@OOXIXo List<Integer> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mPlanTime = list;
    }

    public final void setMProgress(int i) {
        this.mProgress = i;
    }

    @OOXIXo
    public String toString() {
        return "BleAICoachGeneratePlan(mPlanTime=" + this.mPlanTime + ", mCompletionMark=" + this.mCompletionMark + ", mPlanStartTime=" + this.mPlanStartTime + ",mPlanTarget=" + this.mPlanTarget + ",mPlanLevel=" + this.mPlanLevel + ",mProgress=" + this.mProgress + ",mAllExerciseTime=" + this.mAllExerciseTime + ",mAll_METS=" + this.mAll_METS + ",mAllCalorie=" + this.mAllCalorie + ",mCourses=" + this.mCourses + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleAICoachGeneratePlan(List list, List list2, long j, float f, int i, List list3, int i2, int i3, float f2, int i4, int i5, IIXOooo iIXOooo) {
        this((i5 & 1) != 0 ? new ArrayList() : list, (i5 & 2) != 0 ? new ArrayList() : list2, (i5 & 4) != 0 ? 0L : j, (i5 & 8) != 0 ? 0.0f : f, (i5 & 16) != 0 ? 0 : i, (i5 & 32) != 0 ? new ArrayList() : list3, (i5 & 64) != 0 ? 0 : i2, (i5 & 128) != 0 ? 0 : i3, (i5 & 256) == 0 ? f2 : 0.0f, (i5 & 512) == 0 ? i4 : 0);
    }

    public BleAICoachGeneratePlan(@OOXIXo List<Integer> mPlanTime, @OOXIXo List<Integer> mCompletionMark, long j, float f, int i, @OOXIXo List<BleAICoachDayPlanCourse> mCourses, int i2, int i3, float f2, int i4) {
        IIX0o.x0xO0oo(mPlanTime, "mPlanTime");
        IIX0o.x0xO0oo(mCompletionMark, "mCompletionMark");
        IIX0o.x0xO0oo(mCourses, "mCourses");
        this.mPlanTime = mPlanTime;
        this.mCompletionMark = mCompletionMark;
        this.mPlanStartTime = j;
        this.mPlanTarget = f;
        this.mPlanLevel = i;
        this.mCourses = mCourses;
        this.mProgress = i2;
        this.mAllExerciseTime = i3;
        this.mAll_METS = f2;
        this.mAllCalorie = i4;
    }
}
