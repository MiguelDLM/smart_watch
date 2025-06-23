package com.bomdic.gomoreedgekit.data;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class GMFitnessSummary {
    private final float aerobicEfficiency;
    private final float anaerobicEfficiency;
    private final float cycleAerobic;
    private final float cycleAerobicPower;
    private final float cycleAerobicStaminaLevel;
    private final float cycleAnaerobic;
    private final float cycleAnaerobicStaminaLevel;
    private final float cycleEndurance;
    private final float cyclePower;
    private final float cycleStaminaLevel;
    private final float cycleUltraEndurance;
    private final float cycleVO2Max;
    private final float cyclingFTP;
    private final float cyclingVO2PeakPower;

    @OOXIXo
    private final int[] fitnessAge;

    @OOXIXo
    private final String fitnessChecksum;
    private final float hrMaxEstimation;
    private final float meanCadenceRunPoseFromHand;
    private final float meanFlightRunPoseFromHand;
    private final float meanPowerRunPoseFromHand;
    private final float meanStanceRunPoseFromHand;
    private final float meanStrideLenRunPoseFromHand;
    private final int recoveryTime;

    @OOXIXo
    private final int[] runTimePrediction;
    private final float runningAerobic;
    private final float runningAerobicPower;
    private final float runningAerobicStaminaLevel;
    private final float runningAnaerobic;
    private final float runningAnaerobicStaminaLevel;
    private final float runningEndurance;
    private final float runningLactateHR;
    private final float runningLactatePace;
    private final float runningPower;
    private final float runningStaminaLevel;
    private final float runningUltraEndurance;
    private final float runningVO2Max;
    private final int totalStepCountRunPoseFromHand;

    @OOXIXo
    private final String trainingChecksum;
    private final int trainingLoad;
    private final float trainingLoadTrend;
    private final int trainingStatus;
    private final int valid;

    public GMFitnessSummary() {
        this(0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, null, 0, 0.0f, 0, null, 0.0f, null, null, -1, 1023, null);
    }

    public final int component1() {
        return this.valid;
    }

    public final float component10() {
        return this.runningUltraEndurance;
    }

    public final float component11() {
        return this.runningVO2Max;
    }

    public final float component12() {
        return this.runningLactatePace;
    }

    public final float component13() {
        return this.runningLactateHR;
    }

    public final float component14() {
        return this.cycleStaminaLevel;
    }

    public final float component15() {
        return this.cycleAerobicStaminaLevel;
    }

    public final float component16() {
        return this.cycleAnaerobicStaminaLevel;
    }

    public final float component17() {
        return this.cyclePower;
    }

    public final float component18() {
        return this.cycleAnaerobic;
    }

    public final float component19() {
        return this.cycleAerobicPower;
    }

    public final float component2() {
        return this.runningStaminaLevel;
    }

    public final float component20() {
        return this.cycleAerobic;
    }

    public final float component21() {
        return this.cycleEndurance;
    }

    public final float component22() {
        return this.cycleUltraEndurance;
    }

    public final float component23() {
        return this.cycleVO2Max;
    }

    public final float component24() {
        return this.cyclingFTP;
    }

    public final float component25() {
        return this.cyclingVO2PeakPower;
    }

    public final float component26() {
        return this.meanCadenceRunPoseFromHand;
    }

    public final float component27() {
        return this.meanStrideLenRunPoseFromHand;
    }

    public final float component28() {
        return this.meanStanceRunPoseFromHand;
    }

    public final float component29() {
        return this.meanFlightRunPoseFromHand;
    }

    public final float component3() {
        return this.runningAerobicStaminaLevel;
    }

    public final float component30() {
        return this.meanPowerRunPoseFromHand;
    }

    public final int component31() {
        return this.totalStepCountRunPoseFromHand;
    }

    public final float component32() {
        return this.aerobicEfficiency;
    }

    public final float component33() {
        return this.anaerobicEfficiency;
    }

    public final int component34() {
        return this.recoveryTime;
    }

    @OOXIXo
    public final int[] component35() {
        return this.runTimePrediction;
    }

    public final int component36() {
        return this.trainingLoad;
    }

    public final float component37() {
        return this.trainingLoadTrend;
    }

    public final int component38() {
        return this.trainingStatus;
    }

    @OOXIXo
    public final int[] component39() {
        return this.fitnessAge;
    }

    public final float component4() {
        return this.runningAnaerobicStaminaLevel;
    }

    public final float component40() {
        return this.hrMaxEstimation;
    }

    @OOXIXo
    public final String component41() {
        return this.fitnessChecksum;
    }

    @OOXIXo
    public final String component42() {
        return this.trainingChecksum;
    }

    public final float component5() {
        return this.runningPower;
    }

    public final float component6() {
        return this.runningAnaerobic;
    }

    public final float component7() {
        return this.runningAerobicPower;
    }

    public final float component8() {
        return this.runningAerobic;
    }

    public final float component9() {
        return this.runningEndurance;
    }

    @OOXIXo
    public final GMFitnessSummary copy(int i, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23, float f24, float f25, float f26, float f27, float f28, float f29, int i2, float f30, float f31, int i3, @OOXIXo int[] runTimePrediction, int i4, float f32, int i5, @OOXIXo int[] fitnessAge, float f33, @OOXIXo String fitnessChecksum, @OOXIXo String trainingChecksum) {
        IIX0o.x0xO0oo(runTimePrediction, "runTimePrediction");
        IIX0o.x0xO0oo(fitnessAge, "fitnessAge");
        IIX0o.x0xO0oo(fitnessChecksum, "fitnessChecksum");
        IIX0o.x0xO0oo(trainingChecksum, "trainingChecksum");
        return new GMFitnessSummary(i, f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f22, f23, f24, f25, f26, f27, f28, f29, i2, f30, f31, i3, runTimePrediction, i4, f32, i5, fitnessAge, f33, fitnessChecksum, trainingChecksum);
    }

    public boolean equals(@oOoXoXO Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!IIX0o.Oxx0IOOO(GMFitnessSummary.class, cls)) {
            return false;
        }
        IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type com.bomdic.gomoreedgekit.data.GMFitnessSummary");
        GMFitnessSummary gMFitnessSummary = (GMFitnessSummary) obj;
        if (this.valid == gMFitnessSummary.valid && this.runningStaminaLevel == gMFitnessSummary.runningStaminaLevel && this.runningAerobicStaminaLevel == gMFitnessSummary.runningAerobicStaminaLevel && this.runningAnaerobicStaminaLevel == gMFitnessSummary.runningAnaerobicStaminaLevel && this.runningPower == gMFitnessSummary.runningPower && this.runningAnaerobic == gMFitnessSummary.runningAnaerobic && this.runningAerobicPower == gMFitnessSummary.runningAerobicPower && this.runningAerobic == gMFitnessSummary.runningAerobic && this.runningEndurance == gMFitnessSummary.runningEndurance && this.runningUltraEndurance == gMFitnessSummary.runningUltraEndurance && this.runningVO2Max == gMFitnessSummary.runningVO2Max && this.runningLactatePace == gMFitnessSummary.runningLactatePace && this.runningLactateHR == gMFitnessSummary.runningLactateHR && this.cycleStaminaLevel == gMFitnessSummary.cycleStaminaLevel && this.cycleAerobicStaminaLevel == gMFitnessSummary.cycleAerobicStaminaLevel && this.cycleAnaerobicStaminaLevel == gMFitnessSummary.cycleAnaerobicStaminaLevel && this.cyclePower == gMFitnessSummary.cyclePower && this.cycleAnaerobic == gMFitnessSummary.cycleAnaerobic && this.cycleAerobicPower == gMFitnessSummary.cycleAerobicPower && this.cycleAerobic == gMFitnessSummary.cycleAerobic && this.cycleEndurance == gMFitnessSummary.cycleEndurance && this.cycleUltraEndurance == gMFitnessSummary.cycleUltraEndurance && this.cycleVO2Max == gMFitnessSummary.cycleVO2Max && this.cyclingFTP == gMFitnessSummary.cyclingFTP && this.cyclingVO2PeakPower == gMFitnessSummary.cyclingVO2PeakPower && this.aerobicEfficiency == gMFitnessSummary.aerobicEfficiency && this.anaerobicEfficiency == gMFitnessSummary.anaerobicEfficiency && this.recoveryTime == gMFitnessSummary.recoveryTime && Arrays.equals(this.runTimePrediction, gMFitnessSummary.runTimePrediction) && this.trainingLoad == gMFitnessSummary.trainingLoad && this.trainingLoadTrend == gMFitnessSummary.trainingLoadTrend && this.trainingStatus == gMFitnessSummary.trainingStatus && Arrays.equals(this.fitnessAge, gMFitnessSummary.fitnessAge) && this.hrMaxEstimation == gMFitnessSummary.hrMaxEstimation && IIX0o.Oxx0IOOO(this.fitnessChecksum, gMFitnessSummary.fitnessChecksum) && IIX0o.Oxx0IOOO(this.trainingChecksum, gMFitnessSummary.trainingChecksum)) {
            return true;
        }
        return false;
    }

    public final float getAerobicEfficiency() {
        return this.aerobicEfficiency;
    }

    public final float getAnaerobicEfficiency() {
        return this.anaerobicEfficiency;
    }

    public final float getCycleAerobic() {
        return this.cycleAerobic;
    }

    public final float getCycleAerobicPower() {
        return this.cycleAerobicPower;
    }

    public final float getCycleAerobicStaminaLevel() {
        return this.cycleAerobicStaminaLevel;
    }

    public final float getCycleAnaerobic() {
        return this.cycleAnaerobic;
    }

    public final float getCycleAnaerobicStaminaLevel() {
        return this.cycleAnaerobicStaminaLevel;
    }

    public final float getCycleEndurance() {
        return this.cycleEndurance;
    }

    public final float getCyclePower() {
        return this.cyclePower;
    }

    public final float getCycleStaminaLevel() {
        return this.cycleStaminaLevel;
    }

    public final float getCycleUltraEndurance() {
        return this.cycleUltraEndurance;
    }

    public final float getCycleVO2Max() {
        return this.cycleVO2Max;
    }

    public final float getCyclingFTP() {
        return this.cyclingFTP;
    }

    public final float getCyclingVO2PeakPower() {
        return this.cyclingVO2PeakPower;
    }

    @OOXIXo
    public final int[] getFitnessAge() {
        return this.fitnessAge;
    }

    @OOXIXo
    public final String getFitnessChecksum() {
        return this.fitnessChecksum;
    }

    public final float getHrMaxEstimation() {
        return this.hrMaxEstimation;
    }

    public final float getMeanCadenceRunPoseFromHand() {
        return this.meanCadenceRunPoseFromHand;
    }

    public final float getMeanFlightRunPoseFromHand() {
        return this.meanFlightRunPoseFromHand;
    }

    public final float getMeanPowerRunPoseFromHand() {
        return this.meanPowerRunPoseFromHand;
    }

    public final float getMeanStanceRunPoseFromHand() {
        return this.meanStanceRunPoseFromHand;
    }

    public final float getMeanStrideLenRunPoseFromHand() {
        return this.meanStrideLenRunPoseFromHand;
    }

    public final int getRecoveryTime() {
        return this.recoveryTime;
    }

    @OOXIXo
    public final int[] getRunTimePrediction() {
        return this.runTimePrediction;
    }

    public final float getRunningAerobic() {
        return this.runningAerobic;
    }

    public final float getRunningAerobicPower() {
        return this.runningAerobicPower;
    }

    public final float getRunningAerobicStaminaLevel() {
        return this.runningAerobicStaminaLevel;
    }

    public final float getRunningAnaerobic() {
        return this.runningAnaerobic;
    }

    public final float getRunningAnaerobicStaminaLevel() {
        return this.runningAnaerobicStaminaLevel;
    }

    public final float getRunningEndurance() {
        return this.runningEndurance;
    }

    public final float getRunningLactateHR() {
        return this.runningLactateHR;
    }

    public final float getRunningLactatePace() {
        return this.runningLactatePace;
    }

    public final float getRunningPower() {
        return this.runningPower;
    }

    public final float getRunningStaminaLevel() {
        return this.runningStaminaLevel;
    }

    public final float getRunningUltraEndurance() {
        return this.runningUltraEndurance;
    }

    public final float getRunningVO2Max() {
        return this.runningVO2Max;
    }

    public final int getTotalStepCountRunPoseFromHand() {
        return this.totalStepCountRunPoseFromHand;
    }

    @OOXIXo
    public final String getTrainingChecksum() {
        return this.trainingChecksum;
    }

    public final int getTrainingLoad() {
        return this.trainingLoad;
    }

    public final float getTrainingLoadTrend() {
        return this.trainingLoadTrend;
    }

    public final int getTrainingStatus() {
        return this.trainingStatus;
    }

    public final int getValid() {
        return this.valid;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.valid * 31) + Float.floatToIntBits(this.runningStaminaLevel)) * 31) + Float.floatToIntBits(this.runningAerobicStaminaLevel)) * 31) + Float.floatToIntBits(this.runningAnaerobicStaminaLevel)) * 31) + Float.floatToIntBits(this.runningPower)) * 31) + Float.floatToIntBits(this.runningAnaerobic)) * 31) + Float.floatToIntBits(this.runningAerobicPower)) * 31) + Float.floatToIntBits(this.runningAerobic)) * 31) + Float.floatToIntBits(this.runningEndurance)) * 31) + Float.floatToIntBits(this.runningUltraEndurance)) * 31) + Float.floatToIntBits(this.runningVO2Max)) * 31) + Float.floatToIntBits(this.runningLactatePace)) * 31) + Float.floatToIntBits(this.runningLactateHR)) * 31) + Float.floatToIntBits(this.cycleStaminaLevel)) * 31) + Float.floatToIntBits(this.cycleAerobicStaminaLevel)) * 31) + Float.floatToIntBits(this.cycleAnaerobicStaminaLevel)) * 31) + Float.floatToIntBits(this.cyclePower)) * 31) + Float.floatToIntBits(this.cycleAnaerobic)) * 31) + Float.floatToIntBits(this.cycleAerobicPower)) * 31) + Float.floatToIntBits(this.cycleAerobic)) * 31) + Float.floatToIntBits(this.cycleEndurance)) * 31) + Float.floatToIntBits(this.cycleUltraEndurance)) * 31) + Float.floatToIntBits(this.cycleVO2Max)) * 31) + Float.floatToIntBits(this.cyclingFTP)) * 31) + Float.floatToIntBits(this.cyclingVO2PeakPower)) * 31) + Float.floatToIntBits(this.aerobicEfficiency)) * 31) + Float.floatToIntBits(this.anaerobicEfficiency)) * 31) + this.recoveryTime) * 31) + Arrays.hashCode(this.runTimePrediction)) * 31) + this.trainingLoad) * 31) + Float.floatToIntBits(this.trainingLoadTrend)) * 31) + this.trainingStatus) * 31) + Arrays.hashCode(this.fitnessAge)) * 31) + Float.floatToIntBits(this.hrMaxEstimation)) * 31) + this.fitnessChecksum.hashCode()) * 31) + this.trainingChecksum.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "GMFitnessSummary(valid=" + this.valid + ", runningStaminaLevel=" + this.runningStaminaLevel + ", runningAerobicStaminaLevel=" + this.runningAerobicStaminaLevel + ", runningAnaerobicStaminaLevel=" + this.runningAnaerobicStaminaLevel + ", runningPower=" + this.runningPower + ", runningAnaerobic=" + this.runningAnaerobic + ", runningAerobicPower=" + this.runningAerobicPower + ", runningAerobic=" + this.runningAerobic + ", runningEndurance=" + this.runningEndurance + ", runningUltraEndurance=" + this.runningUltraEndurance + ", runningVO2Max=" + this.runningVO2Max + ", runningLactatePace=" + this.runningLactatePace + ", runningLactateHR=" + this.runningLactateHR + ", cycleStaminaLevel=" + this.cycleStaminaLevel + ", cycleAerobicStaminaLevel=" + this.cycleAerobicStaminaLevel + ", cycleAnaerobicStaminaLevel=" + this.cycleAnaerobicStaminaLevel + ", cyclePower=" + this.cyclePower + ", cycleAnaerobic=" + this.cycleAnaerobic + ", cycleAerobicPower=" + this.cycleAerobicPower + ", cycleAerobic=" + this.cycleAerobic + ", cycleEndurance=" + this.cycleEndurance + ", cycleUltraEndurance=" + this.cycleUltraEndurance + ", cycleVO2Max=" + this.cycleVO2Max + ", cyclingFTP=" + this.cyclingFTP + ", cyclingVO2PeakPower=" + this.cyclingVO2PeakPower + ", meanCadenceRunPoseFromHand=" + this.meanCadenceRunPoseFromHand + ", meanStrideLenRunPoseFromHand=" + this.meanStrideLenRunPoseFromHand + ", meanStanceRunPoseFromHand=" + this.meanStanceRunPoseFromHand + ", meanFlightRunPoseFromHand=" + this.meanFlightRunPoseFromHand + ", meanPowerRunPoseFromHand=" + this.meanPowerRunPoseFromHand + ", totalStepCountRunPoseFromHand=" + this.totalStepCountRunPoseFromHand + ", aerobicEfficiency=" + this.aerobicEfficiency + ", anaerobicEfficiency=" + this.anaerobicEfficiency + ", recoveryTime=" + this.recoveryTime + ", runTimePrediction=" + Arrays.toString(this.runTimePrediction) + ", trainingLoad=" + this.trainingLoad + ", trainingLoadTrend=" + this.trainingLoadTrend + ", trainingStatus=" + this.trainingStatus + ", fitnessAge=" + Arrays.toString(this.fitnessAge) + ", hrMaxEstimation=" + this.hrMaxEstimation + ", fitnessChecksum=" + this.fitnessChecksum + ", trainingChecksum=" + this.trainingChecksum + oIX0oI.I0Io.f4095I0Io;
    }

    public GMFitnessSummary(int i, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23, float f24, float f25, float f26, float f27, float f28, float f29, int i2, float f30, float f31, int i3, @OOXIXo int[] runTimePrediction, int i4, float f32, int i5, @OOXIXo int[] fitnessAge, float f33, @OOXIXo String fitnessChecksum, @OOXIXo String trainingChecksum) {
        IIX0o.x0xO0oo(runTimePrediction, "runTimePrediction");
        IIX0o.x0xO0oo(fitnessAge, "fitnessAge");
        IIX0o.x0xO0oo(fitnessChecksum, "fitnessChecksum");
        IIX0o.x0xO0oo(trainingChecksum, "trainingChecksum");
        this.valid = i;
        this.runningStaminaLevel = f;
        this.runningAerobicStaminaLevel = f2;
        this.runningAnaerobicStaminaLevel = f3;
        this.runningPower = f4;
        this.runningAnaerobic = f5;
        this.runningAerobicPower = f6;
        this.runningAerobic = f7;
        this.runningEndurance = f8;
        this.runningUltraEndurance = f9;
        this.runningVO2Max = f10;
        this.runningLactatePace = f11;
        this.runningLactateHR = f12;
        this.cycleStaminaLevel = f13;
        this.cycleAerobicStaminaLevel = f14;
        this.cycleAnaerobicStaminaLevel = f15;
        this.cyclePower = f16;
        this.cycleAnaerobic = f17;
        this.cycleAerobicPower = f18;
        this.cycleAerobic = f19;
        this.cycleEndurance = f20;
        this.cycleUltraEndurance = f21;
        this.cycleVO2Max = f22;
        this.cyclingFTP = f23;
        this.cyclingVO2PeakPower = f24;
        this.meanCadenceRunPoseFromHand = f25;
        this.meanStrideLenRunPoseFromHand = f26;
        this.meanStanceRunPoseFromHand = f27;
        this.meanFlightRunPoseFromHand = f28;
        this.meanPowerRunPoseFromHand = f29;
        this.totalStepCountRunPoseFromHand = i2;
        this.aerobicEfficiency = f30;
        this.anaerobicEfficiency = f31;
        this.recoveryTime = i3;
        this.runTimePrediction = runTimePrediction;
        this.trainingLoad = i4;
        this.trainingLoadTrend = f32;
        this.trainingStatus = i5;
        this.fitnessAge = fitnessAge;
        this.hrMaxEstimation = f33;
        this.fitnessChecksum = fitnessChecksum;
        this.trainingChecksum = trainingChecksum;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ GMFitnessSummary(int r42, float r43, float r44, float r45, float r46, float r47, float r48, float r49, float r50, float r51, float r52, float r53, float r54, float r55, float r56, float r57, float r58, float r59, float r60, float r61, float r62, float r63, float r64, float r65, float r66, float r67, float r68, float r69, float r70, float r71, int r72, float r73, float r74, int r75, int[] r76, int r77, float r78, int r79, int[] r80, float r81, java.lang.String r82, java.lang.String r83, int r84, int r85, kotlin.jvm.internal.IIXOooo r86) {
        /*
            Method dump skipped, instructions count: 553
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bomdic.gomoreedgekit.data.GMFitnessSummary.<init>(int, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, int, float, float, int, int[], int, float, int, int[], float, java.lang.String, java.lang.String, int, int, kotlin.jvm.internal.IIXOooo):void");
    }
}
