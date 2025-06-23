package com.bomdic.gomoreedgekit;

import OXOo.OOXIXo;
import XO0OX.x0XOIxOo;
import com.bomdic.gomoreedgekit.data.GMCoachUserInfo;
import com.bomdic.gomoreedgekit.data.GMVitalityDailyMET;
import com.bomdic.gomoreedgekit.data.GMVitalityLesson;
import com.bomdic.gomoreedgekit.data.GMVitalityPlan;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class GMVitalityCoach {

    @OOXIXo
    public static final GMVitalityCoach INSTANCE = new GMVitalityCoach();

    private GMVitalityCoach() {
    }

    @x0XOIxOo
    private static final native int jniVitalityLazyIndex(float[] fArr, float[] fArr2, String str);

    @x0XOIxOo
    private static final native GMVitalityLesson jniVitalityLesson(String str, int i);

    @x0XOIxOo
    private static final native GMVitalityPlan jniVitalityPlan(float[] fArr, float[] fArr2, String str, boolean z, int i, boolean z2);

    @x0XOIxOo
    private static final native GMVitalityDailyMET jniVitalitySetDayPlan(float[] fArr, float[] fArr2, String str, int i, List<Integer> list);

    @OOXIXo
    public final GMVitalityDailyMET dailyMET(@OOXIXo float[] totalDailyMETs, @OOXIXo float[] totalExerciseMETs, @OOXIXo String parameter, int i, @OOXIXo List<Integer> dailySchedule) {
        IIX0o.x0xO0oo(totalDailyMETs, "totalDailyMETs");
        IIX0o.x0xO0oo(totalExerciseMETs, "totalExerciseMETs");
        IIX0o.x0xO0oo(parameter, "parameter");
        IIX0o.x0xO0oo(dailySchedule, "dailySchedule");
        return jniVitalitySetDayPlan(totalDailyMETs, totalExerciseMETs, parameter, i, dailySchedule);
    }

    @OOXIXo
    public final GMVitalityPlan generate(@OOXIXo float[] dailyMETs, @OOXIXo float[] exerciseMETs, @OOXIXo String parameter, boolean z, int i, boolean z2) {
        IIX0o.x0xO0oo(dailyMETs, "dailyMETs");
        IIX0o.x0xO0oo(exerciseMETs, "exerciseMETs");
        IIX0o.x0xO0oo(parameter, "parameter");
        return jniVitalityPlan(dailyMETs, exerciseMETs, parameter, z, i, z2);
    }

    public final int lazyIndex(@OOXIXo float[] dailyMETs, @OOXIXo float[] exerciseMETs, @OOXIXo String parameter) {
        IIX0o.x0xO0oo(dailyMETs, "dailyMETs");
        IIX0o.x0xO0oo(exerciseMETs, "exerciseMETs");
        IIX0o.x0xO0oo(parameter, "parameter");
        return jniVitalityLazyIndex(dailyMETs, exerciseMETs, parameter);
    }

    public final int set(@OOXIXo GMCoachUserInfo gmCoachUserInfo, @OOXIXo String currentTrainingChecksum, @OOXIXo String lastTrainingChecksum) {
        IIX0o.x0xO0oo(gmCoachUserInfo, "gmCoachUserInfo");
        IIX0o.x0xO0oo(currentTrainingChecksum, "currentTrainingChecksum");
        IIX0o.x0xO0oo(lastTrainingChecksum, "lastTrainingChecksum");
        return GMBase.INSTANCE.setupPlan$kit_release(gmCoachUserInfo, 7, currentTrainingChecksum, lastTrainingChecksum);
    }

    @OOXIXo
    public final GMVitalityLesson vitalityLesson(@OOXIXo String parameter, int i) {
        IIX0o.x0xO0oo(parameter, "parameter");
        return jniVitalityLesson(parameter, i);
    }
}
