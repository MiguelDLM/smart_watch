package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleAICoachDayPlanCourse extends BleWritable {
    private float mCourseGoal;
    private int mCourseIndex;
    private int mCourseNumber;

    @OOXIXo
    private List<BleAICoachCourse> mCoursesItem;

    public BleAICoachDayPlanCourse() {
        this(0, null, 0, 0.0f, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BleAICoachDayPlanCourse copy$default(BleAICoachDayPlanCourse bleAICoachDayPlanCourse, int i, List list, int i2, float f, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = bleAICoachDayPlanCourse.mCourseNumber;
        }
        if ((i3 & 2) != 0) {
            list = bleAICoachDayPlanCourse.mCoursesItem;
        }
        if ((i3 & 4) != 0) {
            i2 = bleAICoachDayPlanCourse.mCourseIndex;
        }
        if ((i3 & 8) != 0) {
            f = bleAICoachDayPlanCourse.mCourseGoal;
        }
        return bleAICoachDayPlanCourse.copy(i, list, i2, f);
    }

    public final int component1() {
        return this.mCourseNumber;
    }

    @OOXIXo
    public final List<BleAICoachCourse> component2() {
        return this.mCoursesItem;
    }

    public final int component3() {
        return this.mCourseIndex;
    }

    public final float component4() {
        return this.mCourseGoal;
    }

    @OOXIXo
    public final BleAICoachDayPlanCourse copy(int i, @OOXIXo List<BleAICoachCourse> mCoursesItem, int i2, float f) {
        IIX0o.x0xO0oo(mCoursesItem, "mCoursesItem");
        return new BleAICoachDayPlanCourse(i, mCoursesItem, i2, f);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleAICoachDayPlanCourse)) {
            return false;
        }
        BleAICoachDayPlanCourse bleAICoachDayPlanCourse = (BleAICoachDayPlanCourse) obj;
        return this.mCourseNumber == bleAICoachDayPlanCourse.mCourseNumber && IIX0o.Oxx0IOOO(this.mCoursesItem, bleAICoachDayPlanCourse.mCoursesItem) && this.mCourseIndex == bleAICoachDayPlanCourse.mCourseIndex && Float.compare(this.mCourseGoal, bleAICoachDayPlanCourse.mCourseGoal) == 0;
    }

    public final float getMCourseGoal() {
        return this.mCourseGoal;
    }

    public final int getMCourseIndex() {
        return this.mCourseIndex;
    }

    public final int getMCourseNumber() {
        return this.mCourseNumber;
    }

    @OOXIXo
    public final List<BleAICoachCourse> getMCoursesItem() {
        return this.mCoursesItem;
    }

    public int hashCode() {
        return (((((this.mCourseNumber * 31) + this.mCoursesItem.hashCode()) * 31) + this.mCourseIndex) * 31) + Float.floatToIntBits(this.mCourseGoal);
    }

    public final void setMCourseGoal(float f) {
        this.mCourseGoal = f;
    }

    public final void setMCourseIndex(int i) {
        this.mCourseIndex = i;
    }

    public final void setMCourseNumber(int i) {
        this.mCourseNumber = i;
    }

    public final void setMCoursesItem(@OOXIXo List<BleAICoachCourse> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mCoursesItem = list;
    }

    @OOXIXo
    public String toString() {
        return "BleAICoachDayPlanCourse(mCourseNumber=" + this.mCourseNumber + ", mCoursesItem=" + this.mCoursesItem + ", mCourseIndex=" + this.mCourseIndex + ", mCourseGoal=" + this.mCourseGoal + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleAICoachDayPlanCourse(int i, List list, int i2, float f, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? new ArrayList() : list, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? 0.0f : f);
    }

    public BleAICoachDayPlanCourse(int i, @OOXIXo List<BleAICoachCourse> mCoursesItem, int i2, float f) {
        IIX0o.x0xO0oo(mCoursesItem, "mCoursesItem");
        this.mCourseNumber = i;
        this.mCoursesItem = mCoursesItem;
        this.mCourseIndex = i2;
        this.mCourseGoal = f;
    }
}
