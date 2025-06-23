package com.sma.smartv3.ui.sport.coach;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.blankj.utilcode.util.ToastUtils;
import com.bomdic.gomoreedgekit.GMVitalityCoach;
import com.bomdic.gomoreedgekit.GoMoreEdge;
import com.bomdic.gomoreedgekit.data.GMCoachUserInfo;
import com.bomdic.gomoreedgekit.data.GMVitalityDailyMET;
import com.bomdic.gomoreedgekit.data.GMVitalityLesson;
import com.bomdic.gomoreedgekit.data.GMVitalityPlan;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.JsonFieldContainer;
import com.sma.smartv3.ui.sport.coach.AICoachManage;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.util.xoIox;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleAICoachBeforePlan;
import com.szabh.smable3.entity.BleAICoachCourse;
import com.szabh.smable3.entity.BleAICoachDayPlanCourse;
import com.szabh.smable3.entity.BleAICoachGeneratePlan;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nAICoachManage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AICoachManage.kt\ncom/sma/smartv3/ui/sport/coach/AICoachManage\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 5 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,729:1\n1864#2,2:730\n1855#2,2:732\n1866#2:734\n1#3:735\n13330#4,2:736\n86#5,2:738\n*S KotlinDebug\n*F\n+ 1 AICoachManage.kt\ncom/sma/smartv3/ui/sport/coach/AICoachManage\n*L\n176#1:730,2\n181#1:732,2\n176#1:734\n309#1:736,2\n667#1:738,2\n*E\n"})
/* loaded from: classes12.dex */
public final class AICoachManage {

    /* renamed from: II0XooXoX */
    public static final int f23902II0XooXoX = 0;

    /* renamed from: OOXIXo */
    public static final int f23903OOXIXo = 3;

    /* renamed from: Oxx0IOOO */
    @OOXIXo
    public static volatile AICoachManage f23904Oxx0IOOO = null;

    /* renamed from: XO */
    @OOXIXo
    public static final oIX0oI f23905XO;

    /* renamed from: oOoXoXO */
    public static final int f23906oOoXoXO = 4;

    /* renamed from: ooOOo0oXI */
    public static final int f23907ooOOo0oXI = 5;

    /* renamed from: xoIox */
    public static final int f23908xoIox = 2;

    /* renamed from: xxIXOIIO */
    public static final int f23909xxIXOIIO = 1;

    /* renamed from: I0Io */
    @oOoXoXO
    public List<PlanGroupTitle> f23910I0Io;

    /* renamed from: X0o0xo */
    public boolean f23912X0o0xo;

    /* renamed from: oxoX */
    @oOoXoXO
    public BleAICoachGeneratePlan f23914oxoX;

    /* renamed from: oIX0oI */
    @OOXIXo
    public final String f23913oIX0oI = "AICoachManage";

    /* renamed from: II0xO0 */
    @OOXIXo
    public VitalityData f23911II0xO0 = new VitalityData(0.0f, 0, null, null, null, 0, 0, null, null, null, 0, 0, 0.0f, 0, null, 0, 65535, null);

    /* loaded from: classes12.dex */
    public static final class PlanGroupTitle extends JsonFieldContainer implements Serializable {
        private boolean isCompleted;
        private boolean isHaveLesson;
        private int mLessonIndex;

        @OOXIXo
        private String ofWeek;

        @OOXIXo
        private String remarks;

        @OOXIXo
        private String timeDay;

        public PlanGroupTitle() {
            this(null, null, false, false, 0, null, 63, null);
        }

        public static /* synthetic */ PlanGroupTitle copy$default(PlanGroupTitle planGroupTitle, String str, String str2, boolean z, boolean z2, int i, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = planGroupTitle.ofWeek;
            }
            if ((i2 & 2) != 0) {
                str2 = planGroupTitle.timeDay;
            }
            String str4 = str2;
            if ((i2 & 4) != 0) {
                z = planGroupTitle.isHaveLesson;
            }
            boolean z3 = z;
            if ((i2 & 8) != 0) {
                z2 = planGroupTitle.isCompleted;
            }
            boolean z4 = z2;
            if ((i2 & 16) != 0) {
                i = planGroupTitle.mLessonIndex;
            }
            int i3 = i;
            if ((i2 & 32) != 0) {
                str3 = planGroupTitle.remarks;
            }
            return planGroupTitle.copy(str, str4, z3, z4, i3, str3);
        }

        @OOXIXo
        public final String component1() {
            return this.ofWeek;
        }

        @OOXIXo
        public final String component2() {
            return this.timeDay;
        }

        public final boolean component3() {
            return this.isHaveLesson;
        }

        public final boolean component4() {
            return this.isCompleted;
        }

        public final int component5() {
            return this.mLessonIndex;
        }

        @OOXIXo
        public final String component6() {
            return this.remarks;
        }

        @OOXIXo
        public final PlanGroupTitle copy(@OOXIXo String ofWeek, @OOXIXo String timeDay, boolean z, boolean z2, int i, @OOXIXo String remarks) {
            IIX0o.x0xO0oo(ofWeek, "ofWeek");
            IIX0o.x0xO0oo(timeDay, "timeDay");
            IIX0o.x0xO0oo(remarks, "remarks");
            return new PlanGroupTitle(ofWeek, timeDay, z, z2, i, remarks);
        }

        public boolean equals(@oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PlanGroupTitle)) {
                return false;
            }
            PlanGroupTitle planGroupTitle = (PlanGroupTitle) obj;
            return IIX0o.Oxx0IOOO(this.ofWeek, planGroupTitle.ofWeek) && IIX0o.Oxx0IOOO(this.timeDay, planGroupTitle.timeDay) && this.isHaveLesson == planGroupTitle.isHaveLesson && this.isCompleted == planGroupTitle.isCompleted && this.mLessonIndex == planGroupTitle.mLessonIndex && IIX0o.Oxx0IOOO(this.remarks, planGroupTitle.remarks);
        }

        public final int getMLessonIndex() {
            return this.mLessonIndex;
        }

        @OOXIXo
        public final String getOfWeek() {
            return this.ofWeek;
        }

        @OOXIXo
        public final String getRemarks() {
            return this.remarks;
        }

        @OOXIXo
        public final String getTimeDay() {
            return this.timeDay;
        }

        public int hashCode() {
            return (((((((((this.ofWeek.hashCode() * 31) + this.timeDay.hashCode()) * 31) + androidx.work.oIX0oI.oIX0oI(this.isHaveLesson)) * 31) + androidx.work.oIX0oI.oIX0oI(this.isCompleted)) * 31) + this.mLessonIndex) * 31) + this.remarks.hashCode();
        }

        public final boolean isCompleted() {
            return this.isCompleted;
        }

        public final boolean isHaveLesson() {
            return this.isHaveLesson;
        }

        public final void setCompleted(boolean z) {
            this.isCompleted = z;
        }

        public final void setHaveLesson(boolean z) {
            this.isHaveLesson = z;
        }

        public final void setMLessonIndex(int i) {
            this.mLessonIndex = i;
        }

        public final void setOfWeek(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<set-?>");
            this.ofWeek = str;
        }

        public final void setRemarks(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<set-?>");
            this.remarks = str;
        }

        public final void setTimeDay(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<set-?>");
            this.timeDay = str;
        }

        @OOXIXo
        public String toString() {
            return "PlanGroupTitle(ofWeek=" + this.ofWeek + ", timeDay=" + this.timeDay + ", isHaveLesson=" + this.isHaveLesson + ", isCompleted=" + this.isCompleted + ", mLessonIndex=" + this.mLessonIndex + ", remarks=" + this.remarks + HexStringBuilder.COMMENT_END_CHAR;
        }

        public /* synthetic */ PlanGroupTitle(String str, String str2, boolean z, boolean z2, int i, String str3, int i2, IIXOooo iIXOooo) {
            this((i2 & 1) != 0 ? "周日" : str, (i2 & 2) != 0 ? "01" : str2, (i2 & 4) != 0 ? false : z, (i2 & 8) == 0 ? z2 : false, (i2 & 16) != 0 ? -1 : i, (i2 & 32) != 0 ? "" : str3);
        }

        public PlanGroupTitle(@OOXIXo String ofWeek, @OOXIXo String timeDay, boolean z, boolean z2, int i, @OOXIXo String remarks) {
            IIX0o.x0xO0oo(ofWeek, "ofWeek");
            IIX0o.x0xO0oo(timeDay, "timeDay");
            IIX0o.x0xO0oo(remarks, "remarks");
            this.ofWeek = ofWeek;
            this.timeDay = timeDay;
            this.isHaveLesson = z;
            this.isCompleted = z2;
            this.mLessonIndex = i;
            this.remarks = remarks;
        }
    }

    @XX({"SMAP\nAICoachManage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AICoachManage.kt\ncom/sma/smartv3/ui/sport/coach/AICoachManage$VitalityData\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,729:1\n1#2:730\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class VitalityData extends JsonFieldContainer implements Serializable {

        @OOXIXo
        private String dailyParameter;

        @OOXIXo
        private List<Integer> dailySchedule;

        @OOXIXo
        private int[] dailyTargets;

        @OOXIXo
        private String generateParameter;
        private int level;
        private int mAllCalorie;
        private int mAllExerciseTime;
        private float mAll_METS;

        @oOoXoXO
        private BleAICoachBeforePlan mBeforePlanInfo;

        @OOXIXo
        private List<Integer> mCompletionMark;
        private int mProgress;

        @oOoXoXO
        private List<VitalityLesson> mVitalityDayLesson;
        private float planTarget;
        private long startTime;
        private int userAge;
        private int weeklyTargetNumber;

        public VitalityData() {
            this(0.0f, 0, null, null, null, 0, 0L, null, null, null, 0, 0, 0.0f, 0, null, 0, 65535, null);
        }

        public final float component1() {
            return this.planTarget;
        }

        @OOXIXo
        public final List<Integer> component10() {
            return this.mCompletionMark;
        }

        public final int component11() {
            return this.mProgress;
        }

        public final int component12() {
            return this.mAllExerciseTime;
        }

        public final float component13() {
            return this.mAll_METS;
        }

        public final int component14() {
            return this.mAllCalorie;
        }

        @oOoXoXO
        public final BleAICoachBeforePlan component15() {
            return this.mBeforePlanInfo;
        }

        public final int component16() {
            return this.userAge;
        }

        public final int component2() {
            return this.level;
        }

        @OOXIXo
        public final String component3() {
            return this.generateParameter;
        }

        @OOXIXo
        public final String component4() {
            return this.dailyParameter;
        }

        @oOoXoXO
        public final List<VitalityLesson> component5() {
            return this.mVitalityDayLesson;
        }

        public final int component6() {
            return this.weeklyTargetNumber;
        }

        public final long component7() {
            return this.startTime;
        }

        @OOXIXo
        public final int[] component8() {
            return this.dailyTargets;
        }

        @OOXIXo
        public final List<Integer> component9() {
            return this.dailySchedule;
        }

        @OOXIXo
        public final VitalityData copy(float f, int i, @OOXIXo String generateParameter, @OOXIXo String dailyParameter, @oOoXoXO List<VitalityLesson> list, int i2, long j, @OOXIXo int[] dailyTargets, @OOXIXo List<Integer> dailySchedule, @OOXIXo List<Integer> mCompletionMark, int i3, int i4, float f2, int i5, @oOoXoXO BleAICoachBeforePlan bleAICoachBeforePlan, int i6) {
            IIX0o.x0xO0oo(generateParameter, "generateParameter");
            IIX0o.x0xO0oo(dailyParameter, "dailyParameter");
            IIX0o.x0xO0oo(dailyTargets, "dailyTargets");
            IIX0o.x0xO0oo(dailySchedule, "dailySchedule");
            IIX0o.x0xO0oo(mCompletionMark, "mCompletionMark");
            return new VitalityData(f, i, generateParameter, dailyParameter, list, i2, j, dailyTargets, dailySchedule, mCompletionMark, i3, i4, f2, i5, bleAICoachBeforePlan, i6);
        }

        public boolean equals(@oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VitalityData)) {
                return false;
            }
            VitalityData vitalityData = (VitalityData) obj;
            return Float.compare(this.planTarget, vitalityData.planTarget) == 0 && this.level == vitalityData.level && IIX0o.Oxx0IOOO(this.generateParameter, vitalityData.generateParameter) && IIX0o.Oxx0IOOO(this.dailyParameter, vitalityData.dailyParameter) && IIX0o.Oxx0IOOO(this.mVitalityDayLesson, vitalityData.mVitalityDayLesson) && this.weeklyTargetNumber == vitalityData.weeklyTargetNumber && this.startTime == vitalityData.startTime && IIX0o.Oxx0IOOO(this.dailyTargets, vitalityData.dailyTargets) && IIX0o.Oxx0IOOO(this.dailySchedule, vitalityData.dailySchedule) && IIX0o.Oxx0IOOO(this.mCompletionMark, vitalityData.mCompletionMark) && this.mProgress == vitalityData.mProgress && this.mAllExerciseTime == vitalityData.mAllExerciseTime && Float.compare(this.mAll_METS, vitalityData.mAll_METS) == 0 && this.mAllCalorie == vitalityData.mAllCalorie && IIX0o.Oxx0IOOO(this.mBeforePlanInfo, vitalityData.mBeforePlanInfo) && this.userAge == vitalityData.userAge;
        }

        @OOXIXo
        public final String getDailyParameter() {
            return this.dailyParameter;
        }

        @OOXIXo
        public final List<Integer> getDailySchedule() {
            return this.dailySchedule;
        }

        @OOXIXo
        public final int[] getDailyTargets() {
            return this.dailyTargets;
        }

        @OOXIXo
        public final String getGenerateParameter() {
            return this.generateParameter;
        }

        public final int getLevel() {
            return this.level;
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

        @oOoXoXO
        public final BleAICoachBeforePlan getMBeforePlanInfo() {
            return this.mBeforePlanInfo;
        }

        @OOXIXo
        public final List<Integer> getMCompletionMark() {
            return this.mCompletionMark;
        }

        public final int getMProgress() {
            return this.mProgress;
        }

        @oOoXoXO
        public final List<VitalityLesson> getMVitalityDayLesson() {
            return this.mVitalityDayLesson;
        }

        public final float getPlanTarget() {
            return this.planTarget;
        }

        public final long getStartTime() {
            return this.startTime;
        }

        public final int getUserAge() {
            return this.userAge;
        }

        public final int getWeeklyTargetNumber() {
            return this.weeklyTargetNumber;
        }

        public int hashCode() {
            int hashCode;
            int floatToIntBits = ((((((Float.floatToIntBits(this.planTarget) * 31) + this.level) * 31) + this.generateParameter.hashCode()) * 31) + this.dailyParameter.hashCode()) * 31;
            List<VitalityLesson> list = this.mVitalityDayLesson;
            int i = 0;
            if (list == null) {
                hashCode = 0;
            } else {
                hashCode = list.hashCode();
            }
            int oIX0oI2 = (((((((((((((((((((floatToIntBits + hashCode) * 31) + this.weeklyTargetNumber) * 31) + androidx.collection.oIX0oI.oIX0oI(this.startTime)) * 31) + Arrays.hashCode(this.dailyTargets)) * 31) + this.dailySchedule.hashCode()) * 31) + this.mCompletionMark.hashCode()) * 31) + this.mProgress) * 31) + this.mAllExerciseTime) * 31) + Float.floatToIntBits(this.mAll_METS)) * 31) + this.mAllCalorie) * 31;
            BleAICoachBeforePlan bleAICoachBeforePlan = this.mBeforePlanInfo;
            if (bleAICoachBeforePlan != null) {
                i = bleAICoachBeforePlan.hashCode();
            }
            return ((oIX0oI2 + i) * 31) + this.userAge;
        }

        public final void setDailyParameter(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<set-?>");
            this.dailyParameter = str;
        }

        public final void setDailySchedule(@OOXIXo List<Integer> list) {
            IIX0o.x0xO0oo(list, "<set-?>");
            this.dailySchedule = list;
        }

        public final void setDailyTargets(@OOXIXo int[] iArr) {
            IIX0o.x0xO0oo(iArr, "<set-?>");
            this.dailyTargets = iArr;
        }

        public final void setGenerateParameter(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<set-?>");
            this.generateParameter = str;
        }

        public final void setLevel(int i) {
            this.level = i;
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

        public final void setMBeforePlanInfo(@oOoXoXO BleAICoachBeforePlan bleAICoachBeforePlan) {
            this.mBeforePlanInfo = bleAICoachBeforePlan;
        }

        public final void setMCompletionMark(@OOXIXo List<Integer> list) {
            IIX0o.x0xO0oo(list, "<set-?>");
            this.mCompletionMark = list;
        }

        public final void setMProgress(int i) {
            this.mProgress = i;
        }

        public final void setMVitalityDayLesson(@oOoXoXO List<VitalityLesson> list) {
            this.mVitalityDayLesson = list;
        }

        public final void setPlanTarget(float f) {
            this.planTarget = f;
        }

        public final void setStartTime(long j) {
            this.startTime = j;
        }

        public final void setUserAge(int i) {
            this.userAge = i;
        }

        public final void setWeeklyTargetNumber(int i) {
            this.weeklyTargetNumber = i;
        }

        @OOXIXo
        public String toString() {
            return "VitalityData(planTarget=" + this.planTarget + ", level=" + this.level + ", generateParameter=" + this.generateParameter + ", dailyParameter=" + this.dailyParameter + ", mVitalityDayLesson=" + this.mVitalityDayLesson + ", weeklyTargetNumber=" + this.weeklyTargetNumber + ", startTime=" + this.startTime + ", dailyTargets=" + Arrays.toString(this.dailyTargets) + ", dailySchedule=" + this.dailySchedule + ", mCompletionMark=" + this.mCompletionMark + ", mProgress=" + this.mProgress + ", mAllExerciseTime=" + this.mAllExerciseTime + ", mAll_METS=" + this.mAll_METS + ", mAllCalorie=" + this.mAllCalorie + ", mBeforePlanInfo=" + this.mBeforePlanInfo + ", userAge=" + this.userAge + HexStringBuilder.COMMENT_END_CHAR;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4, types: [java.util.ArrayList] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ VitalityData(float r30, int r31, java.lang.String r32, java.lang.String r33, java.util.List r34, int r35, long r36, int[] r38, java.util.List r39, java.util.List r40, int r41, int r42, float r43, int r44, com.szabh.smable3.entity.BleAICoachBeforePlan r45, int r46, int r47, kotlin.jvm.internal.IIXOooo r48) {
            /*
                Method dump skipped, instructions count: 276
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.sport.coach.AICoachManage.VitalityData.<init>(float, int, java.lang.String, java.lang.String, java.util.List, int, long, int[], java.util.List, java.util.List, int, int, float, int, com.szabh.smable3.entity.BleAICoachBeforePlan, int, int, kotlin.jvm.internal.IIXOooo):void");
        }

        public VitalityData(float f, int i, @OOXIXo String generateParameter, @OOXIXo String dailyParameter, @oOoXoXO List<VitalityLesson> list, int i2, long j, @OOXIXo int[] dailyTargets, @OOXIXo List<Integer> dailySchedule, @OOXIXo List<Integer> mCompletionMark, int i3, int i4, float f2, int i5, @oOoXoXO BleAICoachBeforePlan bleAICoachBeforePlan, int i6) {
            IIX0o.x0xO0oo(generateParameter, "generateParameter");
            IIX0o.x0xO0oo(dailyParameter, "dailyParameter");
            IIX0o.x0xO0oo(dailyTargets, "dailyTargets");
            IIX0o.x0xO0oo(dailySchedule, "dailySchedule");
            IIX0o.x0xO0oo(mCompletionMark, "mCompletionMark");
            this.planTarget = f;
            this.level = i;
            this.generateParameter = generateParameter;
            this.dailyParameter = dailyParameter;
            this.mVitalityDayLesson = list;
            this.weeklyTargetNumber = i2;
            this.startTime = j;
            this.dailyTargets = dailyTargets;
            this.dailySchedule = dailySchedule;
            this.mCompletionMark = mCompletionMark;
            this.mProgress = i3;
            this.mAllExerciseTime = i4;
            this.mAll_METS = f2;
            this.mAllCalorie = i5;
            this.mBeforePlanInfo = bleAICoachBeforePlan;
            this.userAge = i6;
        }
    }

    /* loaded from: classes12.dex */
    public static final class VitalityDayLesson extends JsonFieldContainer implements Serializable {
        private final int lessonCode;
        private final int lessonIcon;

        @OOXIXo
        private final String lessonName;
        private float lessonTarget;
        private final int lessonTime;

        @OOXIXo
        private final String lessonTitle;

        @oOoXoXO
        private final List<VitalityLessonIntervalLessons> mIntervalLessons;

        public VitalityDayLesson() {
            this(0, null, null, 0, 0, 0.0f, null, 127, null);
        }

        public static /* synthetic */ VitalityDayLesson copy$default(VitalityDayLesson vitalityDayLesson, int i, String str, String str2, int i2, int i3, float f, List list, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = vitalityDayLesson.lessonCode;
            }
            if ((i4 & 2) != 0) {
                str = vitalityDayLesson.lessonTitle;
            }
            String str3 = str;
            if ((i4 & 4) != 0) {
                str2 = vitalityDayLesson.lessonName;
            }
            String str4 = str2;
            if ((i4 & 8) != 0) {
                i2 = vitalityDayLesson.lessonIcon;
            }
            int i5 = i2;
            if ((i4 & 16) != 0) {
                i3 = vitalityDayLesson.lessonTime;
            }
            int i6 = i3;
            if ((i4 & 32) != 0) {
                f = vitalityDayLesson.lessonTarget;
            }
            float f2 = f;
            if ((i4 & 64) != 0) {
                list = vitalityDayLesson.mIntervalLessons;
            }
            return vitalityDayLesson.copy(i, str3, str4, i5, i6, f2, list);
        }

        public final int component1() {
            return this.lessonCode;
        }

        @OOXIXo
        public final String component2() {
            return this.lessonTitle;
        }

        @OOXIXo
        public final String component3() {
            return this.lessonName;
        }

        public final int component4() {
            return this.lessonIcon;
        }

        public final int component5() {
            return this.lessonTime;
        }

        public final float component6() {
            return this.lessonTarget;
        }

        @oOoXoXO
        public final List<VitalityLessonIntervalLessons> component7() {
            return this.mIntervalLessons;
        }

        @OOXIXo
        public final VitalityDayLesson copy(int i, @OOXIXo String lessonTitle, @OOXIXo String lessonName, int i2, int i3, float f, @oOoXoXO List<VitalityLessonIntervalLessons> list) {
            IIX0o.x0xO0oo(lessonTitle, "lessonTitle");
            IIX0o.x0xO0oo(lessonName, "lessonName");
            return new VitalityDayLesson(i, lessonTitle, lessonName, i2, i3, f, list);
        }

        public boolean equals(@oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VitalityDayLesson)) {
                return false;
            }
            VitalityDayLesson vitalityDayLesson = (VitalityDayLesson) obj;
            return this.lessonCode == vitalityDayLesson.lessonCode && IIX0o.Oxx0IOOO(this.lessonTitle, vitalityDayLesson.lessonTitle) && IIX0o.Oxx0IOOO(this.lessonName, vitalityDayLesson.lessonName) && this.lessonIcon == vitalityDayLesson.lessonIcon && this.lessonTime == vitalityDayLesson.lessonTime && Float.compare(this.lessonTarget, vitalityDayLesson.lessonTarget) == 0 && IIX0o.Oxx0IOOO(this.mIntervalLessons, vitalityDayLesson.mIntervalLessons);
        }

        public final int getLessonCode() {
            return this.lessonCode;
        }

        public final int getLessonIcon() {
            return this.lessonIcon;
        }

        @OOXIXo
        public final String getLessonName() {
            return this.lessonName;
        }

        public final float getLessonTarget() {
            return this.lessonTarget;
        }

        public final int getLessonTime() {
            return this.lessonTime;
        }

        @OOXIXo
        public final String getLessonTitle() {
            return this.lessonTitle;
        }

        @oOoXoXO
        public final List<VitalityLessonIntervalLessons> getMIntervalLessons() {
            return this.mIntervalLessons;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((((((((((this.lessonCode * 31) + this.lessonTitle.hashCode()) * 31) + this.lessonName.hashCode()) * 31) + this.lessonIcon) * 31) + this.lessonTime) * 31) + Float.floatToIntBits(this.lessonTarget)) * 31;
            List<VitalityLessonIntervalLessons> list = this.mIntervalLessons;
            if (list == null) {
                hashCode = 0;
            } else {
                hashCode = list.hashCode();
            }
            return hashCode2 + hashCode;
        }

        public final void setLessonTarget(float f) {
            this.lessonTarget = f;
        }

        @OOXIXo
        public String toString() {
            return "VitalityDayLesson(lessonCode=" + this.lessonCode + ", lessonTitle=" + this.lessonTitle + ", lessonName=" + this.lessonName + ", lessonIcon=" + this.lessonIcon + ", lessonTime=" + this.lessonTime + ", lessonTarget=" + this.lessonTarget + ", mIntervalLessons=" + this.mIntervalLessons + HexStringBuilder.COMMENT_END_CHAR;
        }

        public /* synthetic */ VitalityDayLesson(int i, String str, String str2, int i2, int i3, float f, List list, int i4, IIXOooo iIXOooo) {
            this((i4 & 1) != 0 ? 1 : i, (i4 & 2) != 0 ? "" : str, (i4 & 4) == 0 ? str2 : "", (i4 & 8) != 0 ? 0 : i2, (i4 & 16) != 0 ? 0 : i3, (i4 & 32) != 0 ? 95.0f : f, (i4 & 64) != 0 ? null : list);
        }

        public VitalityDayLesson(int i, @OOXIXo String lessonTitle, @OOXIXo String lessonName, int i2, int i3, float f, @oOoXoXO List<VitalityLessonIntervalLessons> list) {
            IIX0o.x0xO0oo(lessonTitle, "lessonTitle");
            IIX0o.x0xO0oo(lessonName, "lessonName");
            this.lessonCode = i;
            this.lessonTitle = lessonTitle;
            this.lessonName = lessonName;
            this.lessonIcon = i2;
            this.lessonTime = i3;
            this.lessonTarget = f;
            this.mIntervalLessons = list;
        }
    }

    /* loaded from: classes12.dex */
    public static final class VitalityLessonIntervalLessons extends JsonFieldContainer implements Serializable {
        private final int intenseMinutes;
        private final int lowerBoundHR;
        private final int repeatTimes;
        private final int restHR;
        private final int restMinutes;
        private final float target;
        private final int upperBoundHR;

        public VitalityLessonIntervalLessons() {
            this(0, 0, 0, 0, 0, 0, 0.0f, 127, null);
        }

        public static /* synthetic */ VitalityLessonIntervalLessons copy$default(VitalityLessonIntervalLessons vitalityLessonIntervalLessons, int i, int i2, int i3, int i4, int i5, int i6, float f, int i7, Object obj) {
            if ((i7 & 1) != 0) {
                i = vitalityLessonIntervalLessons.intenseMinutes;
            }
            if ((i7 & 2) != 0) {
                i2 = vitalityLessonIntervalLessons.restMinutes;
            }
            int i8 = i2;
            if ((i7 & 4) != 0) {
                i3 = vitalityLessonIntervalLessons.upperBoundHR;
            }
            int i9 = i3;
            if ((i7 & 8) != 0) {
                i4 = vitalityLessonIntervalLessons.lowerBoundHR;
            }
            int i10 = i4;
            if ((i7 & 16) != 0) {
                i5 = vitalityLessonIntervalLessons.restHR;
            }
            int i11 = i5;
            if ((i7 & 32) != 0) {
                i6 = vitalityLessonIntervalLessons.repeatTimes;
            }
            int i12 = i6;
            if ((i7 & 64) != 0) {
                f = vitalityLessonIntervalLessons.target;
            }
            return vitalityLessonIntervalLessons.copy(i, i8, i9, i10, i11, i12, f);
        }

        public final int component1() {
            return this.intenseMinutes;
        }

        public final int component2() {
            return this.restMinutes;
        }

        public final int component3() {
            return this.upperBoundHR;
        }

        public final int component4() {
            return this.lowerBoundHR;
        }

        public final int component5() {
            return this.restHR;
        }

        public final int component6() {
            return this.repeatTimes;
        }

        public final float component7() {
            return this.target;
        }

        @OOXIXo
        public final VitalityLessonIntervalLessons copy(int i, int i2, int i3, int i4, int i5, int i6, float f) {
            return new VitalityLessonIntervalLessons(i, i2, i3, i4, i5, i6, f);
        }

        public boolean equals(@oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VitalityLessonIntervalLessons)) {
                return false;
            }
            VitalityLessonIntervalLessons vitalityLessonIntervalLessons = (VitalityLessonIntervalLessons) obj;
            return this.intenseMinutes == vitalityLessonIntervalLessons.intenseMinutes && this.restMinutes == vitalityLessonIntervalLessons.restMinutes && this.upperBoundHR == vitalityLessonIntervalLessons.upperBoundHR && this.lowerBoundHR == vitalityLessonIntervalLessons.lowerBoundHR && this.restHR == vitalityLessonIntervalLessons.restHR && this.repeatTimes == vitalityLessonIntervalLessons.repeatTimes && Float.compare(this.target, vitalityLessonIntervalLessons.target) == 0;
        }

        public final int getIntenseMinutes() {
            return this.intenseMinutes;
        }

        public final int getLowerBoundHR() {
            return this.lowerBoundHR;
        }

        public final int getRepeatTimes() {
            return this.repeatTimes;
        }

        public final int getRestHR() {
            return this.restHR;
        }

        public final int getRestMinutes() {
            return this.restMinutes;
        }

        public final float getTarget() {
            return this.target;
        }

        public final int getUpperBoundHR() {
            return this.upperBoundHR;
        }

        public int hashCode() {
            return (((((((((((this.intenseMinutes * 31) + this.restMinutes) * 31) + this.upperBoundHR) * 31) + this.lowerBoundHR) * 31) + this.restHR) * 31) + this.repeatTimes) * 31) + Float.floatToIntBits(this.target);
        }

        @OOXIXo
        public String toString() {
            return "VitalityLessonIntervalLessons(intenseMinutes=" + this.intenseMinutes + ", restMinutes=" + this.restMinutes + ", upperBoundHR=" + this.upperBoundHR + ", lowerBoundHR=" + this.lowerBoundHR + ", restHR=" + this.restHR + ", repeatTimes=" + this.repeatTimes + ", target=" + this.target + HexStringBuilder.COMMENT_END_CHAR;
        }

        public /* synthetic */ VitalityLessonIntervalLessons(int i, int i2, int i3, int i4, int i5, int i6, float f, int i7, IIXOooo iIXOooo) {
            this((i7 & 1) != 0 ? 0 : i, (i7 & 2) != 0 ? 0 : i2, (i7 & 4) != 0 ? 136 : i3, (i7 & 8) != 0 ? 113 : i4, (i7 & 16) != 0 ? 104 : i5, (i7 & 32) == 0 ? i6 : 0, (i7 & 64) != 0 ? 75.0f : f);
        }

        public VitalityLessonIntervalLessons(int i, int i2, int i3, int i4, int i5, int i6, float f) {
            this.intenseMinutes = i;
            this.restMinutes = i2;
            this.upperBoundHR = i3;
            this.lowerBoundHR = i4;
            this.restHR = i5;
            this.repeatTimes = i6;
            this.target = f;
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public final void II0xO0(@OOXIXo AICoachManage aICoachManage) {
            IIX0o.x0xO0oo(aICoachManage, "<set-?>");
            AICoachManage.f23904Oxx0IOOO = aICoachManage;
        }

        @OOXIXo
        public final AICoachManage oIX0oI() {
            return AICoachManage.f23904Oxx0IOOO;
        }

        public oIX0oI() {
        }
    }

    static {
        AICoachManage aICoachManage;
        oIX0oI oix0oi = new oIX0oI(null);
        f23905XO = oix0oi;
        synchronized (oix0oi) {
            aICoachManage = new AICoachManage();
            GoMoreEdge.INSTANCE.initialize();
            f23904Oxx0IOOO = aICoachManage;
        }
        f23904Oxx0IOOO = aICoachManage;
    }

    public static /* synthetic */ void O0xOxO(AICoachManage aICoachManage, int i, int i2, float f, float f2, int i3, int i4, float f3, float f4, String str, String str2, int i5, Object obj) {
        String str3;
        String str4;
        String mLastChecksum;
        String str5;
        int i6 = (i5 & 16) != 0 ? -1 : i3;
        int i7 = (i5 & 32) != 0 ? -1 : i4;
        float f5 = (i5 & 64) != 0 ? -1.0f : f3;
        float f6 = (i5 & 128) != 0 ? -1.0f : f4;
        String str6 = "-999";
        if ((i5 & 256) != 0) {
            BleAICoachBeforePlan mBeforePlanInfo = aICoachManage.f23911II0xO0.getMBeforePlanInfo();
            if (mBeforePlanInfo == null || (str5 = mBeforePlanInfo.getMCurrentChecksum()) == null) {
                str5 = "-999";
            }
            str3 = str5;
        } else {
            str3 = str;
        }
        if ((i5 & 512) != 0) {
            BleAICoachBeforePlan mBeforePlanInfo2 = aICoachManage.f23911II0xO0.getMBeforePlanInfo();
            if (mBeforePlanInfo2 != null && (mLastChecksum = mBeforePlanInfo2.getMLastChecksum()) != null) {
                str6 = mLastChecksum;
            }
            str4 = str6;
        } else {
            str4 = str2;
        }
        aICoachManage.OxI(i, i2, f, f2, i6, i7, f5, f6, str3, str4);
    }

    public static /* synthetic */ void X0o0xo(AICoachManage aICoachManage, GMVitalityLesson gMVitalityLesson, int i, Object obj) {
        if ((i & 1) != 0) {
            gMVitalityLesson = null;
        }
        aICoachManage.oxoX(gMVitalityLesson);
    }

    public static /* synthetic */ int oO(AICoachManage aICoachManage, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return aICoachManage.x0XOIxOo(i);
    }

    public static /* synthetic */ boolean xoIox(AICoachManage aICoachManage, long j, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 28;
        }
        return aICoachManage.xxIXOIIO(j, i);
    }

    public final void II0XooXoX() {
        com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.coach.AICoachManage$deleteAICoachPlan$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(BleConnector bleConnector) {
                invoke2(bleConnector);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OOXIXo BleConnector it) {
                AICoachManage.VitalityData vitalityData;
                IIX0o.x0xO0oo(it, "it");
                BleConnector.sendInt8$default(BleConnector.INSTANCE, BleKey.AI_COACH_PLAN, BleKeyFlag.DELETE, 255, false, false, 24, null);
                Xo0.f24349oIX0oI.XO().remove(XoI0Ixx0.f24387OIx00oxx + '_' + AICoachManage.VitalityData.class.getName());
                vitalityData = AICoachManage.this.f23911II0xO0;
                vitalityData.setPlanTarget(0.0f);
                x0xO0oo.II0xO0(x0xO0oo.f24647x0OIX00oO, null, 2, null);
            }
        }, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void IIXOooo() {
        int i;
        int i2;
        float f;
        int i3;
        BleAICoachGeneratePlan bleAICoachGeneratePlan;
        int i4;
        int i5;
        float f2;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.f23911II0xO0.getStartTime());
        int i6 = calendar.get(7);
        int i7 = i6 - 1;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i8 = 0;
        if (this.f23911II0xO0.getMVitalityDayLesson() != null) {
            List<VitalityLesson> mVitalityDayLesson = this.f23911II0xO0.getMVitalityDayLesson();
            IIX0o.ooOOo0oXI(mVitalityDayLesson);
            List<VitalityLesson> mVitalityDayLesson2 = this.f23911II0xO0.getMVitalityDayLesson();
            IIX0o.ooOOo0oXI(mVitalityDayLesson2);
            arrayList2.addAll(mVitalityDayLesson.subList(i7, mVitalityDayLesson2.size()));
            List<VitalityLesson> mVitalityDayLesson3 = this.f23911II0xO0.getMVitalityDayLesson();
            IIX0o.ooOOo0oXI(mVitalityDayLesson3);
            arrayList2.addAll(mVitalityDayLesson3.subList(0, i7));
        }
        int i9 = 0;
        for (Object obj : arrayList2) {
            int i10 = i9 + 1;
            if (i9 < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            VitalityLesson vitalityLesson = (VitalityLesson) obj;
            BleAICoachDayPlanCourse bleAICoachDayPlanCourse = new BleAICoachDayPlanCourse(0, null, 0, 0.0f, 15, null);
            if (vitalityLesson.getDayLesson().size() >= 5) {
                ArrayList arrayList3 = new ArrayList();
                bleAICoachDayPlanCourse.setMCourseNumber(vitalityLesson.getDayLesson().size());
                for (VitalityDayLesson vitalityDayLesson : vitalityLesson.getDayLesson()) {
                    BleAICoachCourse bleAICoachCourse = new BleAICoachCourse(0, 0.0f, 0, 0, 0, 0, 0, 0, 255, null);
                    bleAICoachCourse.setMCourseType(vitalityDayLesson.getLessonCode());
                    bleAICoachCourse.setMCourseGoal(vitalityDayLesson.getLessonTarget());
                    bleAICoachCourse.setMCourseTime(vitalityDayLesson.getLessonTime());
                    if (vitalityDayLesson.getMIntervalLessons() != null && !vitalityDayLesson.getMIntervalLessons().isEmpty()) {
                        bleAICoachCourse.setMCourseUpperBoundHR(vitalityDayLesson.getMIntervalLessons().get(0).getUpperBoundHR());
                        bleAICoachCourse.setMCourseLowerBoundHR(vitalityDayLesson.getMIntervalLessons().get(0).getLowerBoundHR());
                        if (vitalityDayLesson.getLessonCode() == 1) {
                            bleAICoachCourse.setMCourseTime(vitalityDayLesson.getMIntervalLessons().get(0).getIntenseMinutes());
                            bleAICoachCourse.setMRestMinutes(vitalityDayLesson.getMIntervalLessons().get(0).getRestMinutes());
                            bleAICoachCourse.setMCourseRestHR(vitalityDayLesson.getMIntervalLessons().get(0).getRestHR());
                            bleAICoachCourse.setMRepeatTimes(vitalityDayLesson.getMIntervalLessons().get(0).getRepeatTimes());
                        }
                    }
                    arrayList3.add(bleAICoachCourse);
                }
                if (vitalityLesson.getDayLesson().size() == 5) {
                    arrayList3.add(new BleAICoachCourse(0, 0.0f, 0, 0, 0, 0, 0, 0, 255, null));
                }
                bleAICoachDayPlanCourse.setMCoursesItem(arrayList3);
                bleAICoachDayPlanCourse.setMCourseIndex(0);
                bleAICoachDayPlanCourse.setMCourseGoal(vitalityLesson.getDayLesson().get(0).getLessonTarget());
                arrayList.add(bleAICoachDayPlanCourse);
            } else {
                arrayList.add(bleAICoachDayPlanCourse);
            }
            i9 = i10;
        }
        ArrayList arrayList4 = new ArrayList(32);
        for (int i11 = 0; i11 < 32; i11++) {
            arrayList4.add(0);
        }
        List<Integer> subList = this.f23911II0xO0.getDailySchedule().subList(0, 7);
        int i12 = i6 + 27;
        for (int i13 = i7; i13 < i12; i13++) {
            arrayList4.set(i13 - i7, subList.get(i13 % 7));
        }
        ArrayList arrayList5 = new ArrayList(32);
        for (int i14 = 0; i14 < 32; i14++) {
            arrayList5.add(0);
        }
        BleAICoachGeneratePlan bleAICoachGeneratePlan2 = this.f23914oxoX;
        List list = arrayList5;
        if (bleAICoachGeneratePlan2 != null) {
            IIX0o.ooOOo0oXI(bleAICoachGeneratePlan2);
            list = bleAICoachGeneratePlan2.getMCompletionMark();
        }
        int mProgress = this.f23911II0xO0.getMProgress();
        int mAllExerciseTime = this.f23911II0xO0.getMAllExerciseTime();
        float mAll_METS = this.f23911II0xO0.getMAll_METS();
        int mAllCalorie = this.f23911II0xO0.getMAllCalorie();
        if (this.f23912X0o0xo && (bleAICoachGeneratePlan = this.f23914oxoX) != null) {
            if (bleAICoachGeneratePlan != null) {
                i4 = bleAICoachGeneratePlan.getMProgress();
            } else {
                i4 = 0;
            }
            BleAICoachGeneratePlan bleAICoachGeneratePlan3 = this.f23914oxoX;
            if (bleAICoachGeneratePlan3 != null) {
                i5 = bleAICoachGeneratePlan3.getMAllExerciseTime();
            } else {
                i5 = 0;
            }
            BleAICoachGeneratePlan bleAICoachGeneratePlan4 = this.f23914oxoX;
            if (bleAICoachGeneratePlan4 != null) {
                f2 = bleAICoachGeneratePlan4.getMAll_METS();
            } else {
                f2 = 0.0f;
            }
            BleAICoachGeneratePlan bleAICoachGeneratePlan5 = this.f23914oxoX;
            if (bleAICoachGeneratePlan5 != null) {
                i8 = bleAICoachGeneratePlan5.getMAllCalorie();
            }
            i = i4;
            i2 = i5;
            f = f2;
            i3 = i8;
        } else {
            i = mProgress;
            i2 = mAllExerciseTime;
            f = mAll_METS;
            i3 = mAllCalorie;
        }
        BleAICoachGeneratePlan bleAICoachGeneratePlan6 = new BleAICoachGeneratePlan(arrayList4, list, this.f23911II0xO0.getStartTime(), this.f23911II0xO0.getPlanTarget(), this.f23911II0xO0.getLevel(), arrayList, i, i2, f, i3);
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f23913oIX0oI + " sendObject item item = " + bleAICoachGeneratePlan6);
        BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.AI_COACH_PLAN, BleKeyFlag.UPDATE, bleAICoachGeneratePlan6, false, false, 24, null);
    }

    public final void IXxxXO() {
        this.f23910I0Io = new ArrayList();
        if (this.f23911II0xO0.getMCompletionMark().isEmpty() || this.f23911II0xO0.getMCompletionMark().size() < 32) {
            BleAICoachGeneratePlan bleAICoachGeneratePlan = this.f23914oxoX;
            if (bleAICoachGeneratePlan != null) {
                VitalityData vitalityData = this.f23911II0xO0;
                IIX0o.ooOOo0oXI(bleAICoachGeneratePlan);
                vitalityData.setMCompletionMark(bleAICoachGeneratePlan.getMCompletionMark());
            } else {
                VitalityData vitalityData2 = this.f23911II0xO0;
                ArrayList arrayList = new ArrayList(32);
                for (int i = 0; i < 32; i++) {
                    arrayList.add(0);
                }
                vitalityData2.setMCompletionMark(arrayList);
            }
        }
        int i2 = 6;
        if (this.f23911II0xO0.getDailySchedule().size() < 6) {
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.f23911II0xO0.getStartTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateFormatUtils.DD, Locale.getDefault());
        boolean z = false;
        for (int i3 = calendar.get(7) - 1; i3 > 0; i3--) {
            if (i3 > 0 && this.f23911II0xO0.getDailySchedule().get(i3 - 1).intValue() == 1) {
                z = true;
            }
            calendar.add(6, -1);
            IIX0o.ooOOo0oXI(calendar);
            String oOoXoXO2 = oOoXoXO(calendar);
            List<PlanGroupTitle> list = this.f23910I0Io;
            IIX0o.ooOOo0oXI(list);
            String format = simpleDateFormat.format(calendar.getTime());
            IIX0o.oO(format, "format(...)");
            list.add(0, new PlanGroupTitle(oOoXoXO2, format, false, false, 0, null, 56, null));
        }
        int intValue = ((Number) CollectionsKt___CollectionsKt.O0O0Io00X(this.f23911II0xO0.getDailySchedule())).intValue();
        calendar.setTimeInMillis(this.f23911II0xO0.getStartTime());
        if (z) {
            List<PlanGroupTitle> list2 = this.f23910I0Io;
            IIX0o.ooOOo0oXI(list2);
            int size = list2.size();
            int i4 = size + 28;
            int i5 = size;
            while (i5 < i4) {
                if (i5 != size) {
                    calendar.add(i2, 1);
                }
                List<PlanGroupTitle> list3 = this.f23910I0Io;
                IIX0o.ooOOo0oXI(list3);
                IIX0o.ooOOo0oXI(calendar);
                String oOoXoXO3 = oOoXoXO(calendar);
                String format2 = simpleDateFormat.format(calendar.getTime());
                IIX0o.oO(format2, "format(...)");
                list3.add(new PlanGroupTitle(oOoXoXO3, format2, true, oOXoIIIo.I0Io.II0xO0(this.f23911II0xO0.getMCompletionMark().get(i5 - size).intValue()), i5, null, 32, null));
                i5++;
                i2 = 6;
            }
            int i6 = 7 - size;
            for (int i7 = 0; i7 < i6; i7++) {
                calendar.add(6, 1);
                List<PlanGroupTitle> list4 = this.f23910I0Io;
                IIX0o.ooOOo0oXI(list4);
                IIX0o.ooOOo0oXI(calendar);
                String oOoXoXO4 = oOoXoXO(calendar);
                String format3 = simpleDateFormat.format(calendar.getTime());
                IIX0o.oO(format3, "format(...)");
                list4.add(new PlanGroupTitle(oOoXoXO4, format3, false, false, 0, null, 56, null));
            }
            return;
        }
        List<PlanGroupTitle> list5 = this.f23910I0Io;
        IIX0o.ooOOo0oXI(list5);
        int size2 = list5.size();
        for (int i8 = size2; i8 < 28; i8++) {
            if (i8 != size2) {
                calendar.add(6, 1);
            }
            List<PlanGroupTitle> list6 = this.f23910I0Io;
            IIX0o.ooOOo0oXI(list6);
            IIX0o.ooOOo0oXI(calendar);
            String oOoXoXO5 = oOoXoXO(calendar);
            String format4 = simpleDateFormat.format(calendar.getTime());
            IIX0o.oO(format4, "format(...)");
            list6.add(new PlanGroupTitle(oOoXoXO5, format4, true, oOXoIIIo.I0Io.II0xO0(this.f23911II0xO0.getMCompletionMark().get(i8 - size2).intValue()), (i8 + intValue) - 1, null, 32, null));
        }
    }

    public final void OOXIXo() {
        float[] fArr;
        float[] fArr2;
        float[] fArr3;
        float[] fArr4;
        float[] mWeekExerciseMET;
        if (this.f23911II0xO0.getWeeklyTargetNumber() == 0) {
            ToastUtils.showLong(UtilsKt.oI0IIXIo(R.string.request_error), new Object[0]);
        }
        if (this.f23911II0xO0.getGenerateParameter().length() == 0) {
            Oxx0IOOO();
        }
        GMVitalityCoach gMVitalityCoach = GMVitalityCoach.INSTANCE;
        BleAICoachBeforePlan mBeforePlanInfo = this.f23911II0xO0.getMBeforePlanInfo();
        if (mBeforePlanInfo == null || (fArr = mBeforePlanInfo.getMWeekRoutineMET()) == null) {
            fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        }
        BleAICoachBeforePlan mBeforePlanInfo2 = this.f23911II0xO0.getMBeforePlanInfo();
        if (mBeforePlanInfo2 != null && (mWeekExerciseMET = mBeforePlanInfo2.getMWeekExerciseMET()) != null) {
            fArr2 = mWeekExerciseMET;
        } else {
            fArr2 = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        }
        GMVitalityDailyMET dailyMET = gMVitalityCoach.dailyMET(fArr, fArr2, this.f23911II0xO0.getGenerateParameter(), 0, this.f23911II0xO0.getDailySchedule());
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f23913oIX0oI);
        sb.append(", getCoachDaily totalDailyMETs=");
        BleAICoachBeforePlan mBeforePlanInfo3 = this.f23911II0xO0.getMBeforePlanInfo();
        if (mBeforePlanInfo3 != null) {
            fArr3 = mBeforePlanInfo3.getMRoutineMET();
        } else {
            fArr3 = null;
        }
        sb.append(fArr3);
        sb.append(" , totalExerciseMETs=");
        BleAICoachBeforePlan mBeforePlanInfo4 = this.f23911II0xO0.getMBeforePlanInfo();
        if (mBeforePlanInfo4 != null) {
            fArr4 = mBeforePlanInfo4.getMExerciseMET();
        } else {
            fArr4 = null;
        }
        sb.append(fArr4);
        sb.append(" , parameter = ");
        sb.append(this.f23911II0xO0.getGenerateParameter());
        sb.append(", dailySchedule=");
        sb.append(this.f23911II0xO0.getDailySchedule());
        sb.append(TokenParser.SP);
        oix0oi.oIX0oI(sb.toString());
        this.f23911II0xO0.setDailyTargets(dailyMET.getDailyTargets());
        this.f23911II0xO0.setDailyParameter(dailyMET.getParameter());
        oix0oi.oIX0oI(this.f23913oIX0oI + ", getCoachDaily dayReturn=" + dailyMET);
        this.f23911II0xO0.setMVitalityDayLesson(new ArrayList());
        int length = dailyMET.getDailyTargets().length;
        for (int i = 0; i < length; i++) {
            if (dailyMET.getDailyTargets()[i] != 0) {
                GMVitalityLesson vitalityLesson = GMVitalityCoach.INSTANCE.vitalityLesson(dailyMET.getParameter(), i);
                oxoX(vitalityLesson);
                OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f23913oIX0oI + ", getCoachDaily lsd=" + vitalityLesson.getLsdLesson());
                int size = vitalityLesson.getIntervalLessons().size();
                for (int i2 = 0; i2 < size; i2++) {
                    OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f23913oIX0oI + ", getCoachDaily [" + i2 + ']' + vitalityLesson.getIntervalLessons().get(i2));
                }
            } else {
                X0o0xo(this, null, 1, null);
            }
        }
    }

    @oOoXoXO
    public final List<PlanGroupTitle> Oo() {
        return this.f23910I0Io;
    }

    public final void OxI(int i, int i2, float f, float f2, int i3, int i4, float f3, float f4, @OOXIXo String currentChecksum, @OOXIXo String lastChecksum) {
        int i5;
        IIX0o.x0xO0oo(currentChecksum, "currentChecksum");
        IIX0o.x0xO0oo(lastChecksum, "lastChecksum");
        GMVitalityCoach gMVitalityCoach = GMVitalityCoach.INSTANCE;
        if (i3 == -1) {
            i5 = 220 - i;
        } else {
            i5 = i3;
        }
        int i6 = gMVitalityCoach.set(new GMCoachUserInfo(i, i2, f, f2, i5, i4, f3, f4), currentChecksum, lastChecksum);
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f23913oIX0oI + ", setCoachUserInfo setResult=" + i6 + " , age=" + i + " , gender=" + i2 + " , height=" + f + " , weight=" + f2 + " , maxHR=" + i3 + " , restingHr=" + i4 + " , vo2Max=" + f3 + " , staminaLevel=" + f4 + " , currentChecksum=" + currentChecksum + " , lastChecksum=" + lastChecksum + TokenParser.SP);
    }

    public final void Oxx0IOOO() {
        float[] fArr;
        float[] fArr2;
        boolean z;
        float[] mExerciseMET;
        GMVitalityCoach gMVitalityCoach = GMVitalityCoach.INSTANCE;
        BleAICoachBeforePlan mBeforePlanInfo = this.f23911II0xO0.getMBeforePlanInfo();
        int i = 3;
        if (mBeforePlanInfo == null || (fArr = mBeforePlanInfo.getMRoutineMET()) == null) {
            fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        }
        BleAICoachBeforePlan mBeforePlanInfo2 = this.f23911II0xO0.getMBeforePlanInfo();
        if (mBeforePlanInfo2 != null && (mExerciseMET = mBeforePlanInfo2.getMExerciseMET()) != null) {
            fArr2 = mExerciseMET;
        } else {
            fArr2 = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        }
        BleAICoachBeforePlan mBeforePlanInfo3 = this.f23911II0xO0.getMBeforePlanInfo();
        if (mBeforePlanInfo3 != null) {
            i = mBeforePlanInfo3.getMDayMET();
        }
        BleAICoachBeforePlan mBeforePlanInfo4 = this.f23911II0xO0.getMBeforePlanInfo();
        if (mBeforePlanInfo4 != null) {
            z = oOXoIIIo.I0Io.II0xO0(mBeforePlanInfo4.getMIsFirst());
        } else {
            z = true;
        }
        GMVitalityPlan generate = gMVitalityCoach.generate(fArr, fArr2, "-999", false, i, z);
        this.f23911II0xO0.setWeeklyTargetNumber(0);
        for (int i2 : generate.getWeeklyTargets()) {
            if (i2 > 0) {
                VitalityData vitalityData = this.f23911II0xO0;
                vitalityData.setWeeklyTargetNumber(vitalityData.getWeeklyTargetNumber() + 1);
            }
        }
        if (this.f23911II0xO0.getWeeklyTargetNumber() == 0) {
            ToastUtils.showLong(UtilsKt.oI0IIXIo(R.string.request_error), new Object[0]);
        }
        this.f23911II0xO0.setPlanTarget(generate.getPlanTarget());
        this.f23911II0xO0.setLevel(generate.getLevel());
        this.f23911II0xO0.setGenerateParameter(generate.getParameter());
    }

    @OOXIXo
    public final Pair<List<String>, List<String>> Oxx0xo() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.f23911II0xO0.getStartTime());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(xoIox.f24702o00, Locale.getDefault());
        AICoachManage aICoachManage = f23904Oxx0IOOO;
        IIX0o.ooOOo0oXI(calendar);
        int xxX2 = aICoachManage.xxX(calendar);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(ArraysKt___ArraysKt.oXooI(this.f23911II0xO0.getDailyTargets()).subList(xxX2, this.f23911II0xO0.getDailyTargets().length));
        arrayList3.addAll(ArraysKt___ArraysKt.oXooI(this.f23911II0xO0.getDailyTargets()).subList(0, xxX2));
        for (int i = 0; i < 7; i++) {
            if (i != 0) {
                calendar.add(6, 1);
            }
            arrayList.add(simpleDateFormat.format(calendar.getTime()) + " (" + oOoXoXO(calendar) + HexStringBuilder.COMMENT_END_CHAR);
            if (((Number) arrayList3.get(i)).intValue() > 0) {
                arrayList2.add(((Number) arrayList3.get(i)).intValue() + TokenParser.SP + UtilsKt.oI0IIXIo(R.string.abh_mets_unit));
            } else {
                arrayList2.add(String.valueOf(UtilsKt.oI0IIXIo(R.string.abh_rest_day)));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public final boolean OxxIIOOXO() {
        return this.f23912X0o0xo;
    }

    public final void X0IIOO(boolean z) {
        this.f23912X0o0xo = z;
    }

    public final void XI0IXoo(@oOoXoXO BleAICoachGeneratePlan bleAICoachGeneratePlan) {
        this.f23914oxoX = bleAICoachGeneratePlan;
    }

    public final void XIxXXX0x0(@oOoXoXO List<PlanGroupTitle> list) {
        this.f23910I0Io = list;
    }

    public final int XO(@OOXIXo String birthday) {
        IIX0o.x0xO0oo(birthday, "birthday");
        Date parse = new SimpleDateFormat(xoIox.f24693OxxIIOOXO, Locale.getDefault()).parse(birthday);
        Date time = Calendar.getInstance().getTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parse);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(time);
        int i = calendar2.get(1) - calendar.get(1);
        if (calendar2.get(6) < calendar.get(6)) {
            i--;
        }
        this.f23911II0xO0.setUserAge(i);
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("calculateAge age = " + i);
        return i;
    }

    public final void XxX0x0xxx(@OOXIXo VitalityData data) {
        IIX0o.x0xO0oo(data, "data");
        this.f23911II0xO0 = data;
    }

    public final void o00(@OOXIXo BleAICoachBeforePlan info) {
        IIX0o.x0xO0oo(info, "info");
        this.f23911II0xO0.setMBeforePlanInfo(info);
    }

    @OOXIXo
    public final VitalityData oI0IIXIo() {
        return this.f23911II0xO0;
    }

    public final String oOoXoXO(Calendar calendar) {
        switch (calendar.get(7)) {
            case 2:
                return UtilsKt.oI0IIXIo(R.string.abh_plan_label_weekday1_s);
            case 3:
                return UtilsKt.oI0IIXIo(R.string.abh_plan_label_weekday2_s);
            case 4:
                return UtilsKt.oI0IIXIo(R.string.abh_plan_label_weekday3_s);
            case 5:
                return UtilsKt.oI0IIXIo(R.string.abh_plan_label_weekday4_s);
            case 6:
                return UtilsKt.oI0IIXIo(R.string.abh_plan_label_weekday5_s);
            case 7:
                return UtilsKt.oI0IIXIo(R.string.abh_plan_label_weekday6_s);
            default:
                return UtilsKt.oI0IIXIo(R.string.abh_plan_label_weekday7_s);
        }
    }

    public final void ooOOo0oXI(int i) {
        BleConnector.sendInt8$default(BleConnector.INSTANCE, BleKey.AI_COACH_PLAN, BleKeyFlag.READ, i, false, false, 24, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0292 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0271  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void oxoX(com.bomdic.gomoreedgekit.data.GMVitalityLesson r22) {
        /*
            Method dump skipped, instructions count: 710
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.sport.coach.AICoachManage.oxoX(com.bomdic.gomoreedgekit.data.GMVitalityLesson):void");
    }

    public final int x0XOIxOo(int i) {
        if (i != 0) {
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? R.drawable.plan_detail_lsd_run_icon : R.drawable.plan_detail_rowing_icon : R.drawable.plan_detail_elliptical_icon : R.drawable.plan_detail_bicycle_icon : R.drawable.plan_detail_walking_icon : R.drawable.plan_detail_interval_run_icon;
        }
        return R.drawable.plan_detail_lsd_run_icon;
    }

    @oOoXoXO
    public final BleAICoachGeneratePlan x0xO0oo() {
        return this.f23914oxoX;
    }

    public final void xXxxox0I() {
    }

    public final void xoXoI(@OOXIXo BleAICoachGeneratePlan plan) {
        IIX0o.x0xO0oo(plan, "plan");
        this.f23914oxoX = plan;
        this.f23911II0xO0.setMProgress(plan.getMProgress());
        this.f23911II0xO0.setMAllExerciseTime(plan.getMAllExerciseTime());
        this.f23911II0xO0.setMAll_METS(plan.getMAll_METS());
        this.f23911II0xO0.setMAllCalorie(plan.getMAllCalorie());
        this.f23911II0xO0.setMCompletionMark(plan.getMCompletionMark());
        Xo0 xo0 = Xo0.f24349oIX0oI;
        xo0.XO().put(XoI0Ixx0.f24387OIx00oxx + '_' + VitalityData.class.getName(), new Gson().toJson(this.f23911II0xO0));
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f23913oIX0oI + " setAICoachGeneratePlan = " + this.f23914oxoX);
        long j = (long) 1000;
        if (plan.getMPlanStartTime() / j == this.f23911II0xO0.getStartTime() / j && this.f23911II0xO0.getStartTime() != 0) {
            long j2 = xo0.XO().getLong(XoI0Ixx0.f24479xIXX, 0L);
            if (j2 > 0 && xxIXOIIO(j2, 1)) {
                xXxxox0I();
                this.f23912X0o0xo = true;
                IIXOooo();
                return;
            }
            return;
        }
        if (this.f23911II0xO0.getStartTime() != 0 && this.f23911II0xO0.getPlanTarget() > 0.0f) {
            this.f23912X0o0xo = false;
            IIXOooo();
        }
    }

    public final boolean xxIXOIIO(long j, int i) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        if (currentTimeMillis < i * 86400000 && currentTimeMillis > 0) {
            return true;
        }
        return false;
    }

    public final int xxX(@OOXIXo Calendar calendar) {
        IIX0o.x0xO0oo(calendar, "calendar");
        switch (calendar.get(7)) {
            case 1:
            default:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            case 7:
                return 6;
        }
    }

    /* loaded from: classes12.dex */
    public static final class VitalityLesson extends JsonFieldContainer implements Serializable {

        @OOXIXo
        private final String day;

        @OOXIXo
        private List<VitalityDayLesson> dayLesson;
        private final int isCompletion;

        public /* synthetic */ VitalityLesson(String str, int i, List list, int i2, IIXOooo iIXOooo) {
            this((i2 & 1) != 0 ? "0" : str, (i2 & 2) != 0 ? 0 : i, list);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ VitalityLesson copy$default(VitalityLesson vitalityLesson, String str, int i, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = vitalityLesson.day;
            }
            if ((i2 & 2) != 0) {
                i = vitalityLesson.isCompletion;
            }
            if ((i2 & 4) != 0) {
                list = vitalityLesson.dayLesson;
            }
            return vitalityLesson.copy(str, i, list);
        }

        @OOXIXo
        public final String component1() {
            return this.day;
        }

        public final int component2() {
            return this.isCompletion;
        }

        @OOXIXo
        public final List<VitalityDayLesson> component3() {
            return this.dayLesson;
        }

        @OOXIXo
        public final VitalityLesson copy(@OOXIXo String day, int i, @OOXIXo List<VitalityDayLesson> dayLesson) {
            IIX0o.x0xO0oo(day, "day");
            IIX0o.x0xO0oo(dayLesson, "dayLesson");
            return new VitalityLesson(day, i, dayLesson);
        }

        public boolean equals(@oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VitalityLesson)) {
                return false;
            }
            VitalityLesson vitalityLesson = (VitalityLesson) obj;
            return IIX0o.Oxx0IOOO(this.day, vitalityLesson.day) && this.isCompletion == vitalityLesson.isCompletion && IIX0o.Oxx0IOOO(this.dayLesson, vitalityLesson.dayLesson);
        }

        @OOXIXo
        public final String getDay() {
            return this.day;
        }

        @OOXIXo
        public final List<VitalityDayLesson> getDayLesson() {
            return this.dayLesson;
        }

        public int hashCode() {
            return (((this.day.hashCode() * 31) + this.isCompletion) * 31) + this.dayLesson.hashCode();
        }

        public final int isCompletion() {
            return this.isCompletion;
        }

        public final void setDayLesson(@OOXIXo List<VitalityDayLesson> list) {
            IIX0o.x0xO0oo(list, "<set-?>");
            this.dayLesson = list;
        }

        @OOXIXo
        public String toString() {
            return "VitalityLesson(day=" + this.day + ", isCompletion=" + this.isCompletion + ", dayLesson=" + this.dayLesson + HexStringBuilder.COMMENT_END_CHAR;
        }

        public VitalityLesson(@OOXIXo String day, int i, @OOXIXo List<VitalityDayLesson> dayLesson) {
            IIX0o.x0xO0oo(day, "day");
            IIX0o.x0xO0oo(dayLesson, "dayLesson");
            this.day = day;
            this.isCompletion = i;
            this.dayLesson = dayLesson;
        }
    }
}
