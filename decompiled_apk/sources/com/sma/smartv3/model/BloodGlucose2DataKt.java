package com.sma.smartv3.model;

import OXOo.OOXIXo;
import com.blankj.utilcode.util.Utils;
import com.sma.smartv3.co_fit.R;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes12.dex */
public final class BloodGlucose2DataKt {

    @OOXIXo
    private static final List<o0Xo.oIX0oI> bloodGlucoseSegments = CollectionsKt__CollectionsKt.XOxIOxOx(new o0Xo.oIX0oI(30.0f, 61.0f, Utils.getApp().getResources().getColor(R.color.bg_level_color_normal)), new o0Xo.oIX0oI(61.0f, 69.0f, Utils.getApp().getResources().getColor(R.color.bg_level_color_prediabetes)), new o0Xo.oIX0oI(69.0f, 90.0f, Utils.getApp().getResources().getColor(R.color.bg_level_color_diabetes)));

    public static final float getBloodGlucoseBarValue(float f, float f2) {
        return f - f2;
    }

    public static /* synthetic */ float getBloodGlucoseBarValue$default(float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = BloodGlucoseLevel.START.getMValue();
        }
        return getBloodGlucoseBarValue(f, f2);
    }

    @OOXIXo
    public static final List<o0Xo.oIX0oI> getBloodGlucoseSegments() {
        return bloodGlucoseSegments;
    }
}
