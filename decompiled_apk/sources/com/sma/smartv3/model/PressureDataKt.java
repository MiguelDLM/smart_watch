package com.sma.smartv3.model;

import OXOo.OOXIXo;
import android.content.Context;
import androidx.core.content.ContextCompat;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.segmentedbar.SegmentedBarView;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.text.XIxXXX0x0;
import oIxOXo.oxoX;

/* loaded from: classes12.dex */
public final class PressureDataKt {
    public static final int PRESSURE_LEVEL_RANGE_0 = 0;
    public static final int PRESSURE_LEVEL_RANGE_1 = 25;
    public static final int PRESSURE_LEVEL_RANGE_2 = 50;
    public static final int PRESSURE_LEVEL_RANGE_3 = 75;
    public static final int PRESSURE_LEVEL_RANGE_4 = 100;

    @OOXIXo
    public static final int[] getBarColors(@OOXIXo Context context, int i) {
        IIX0o.x0xO0oo(context, "context");
        if (i < 25) {
            return new int[]{ContextCompat.getColor(context, R.color.level_color_low), ContextCompat.getColor(context, R.color.level_color_low)};
        }
        if (i < 50) {
            return new int[]{ContextCompat.getColor(context, R.color.level_color_standard), ContextCompat.getColor(context, R.color.level_color_standard)};
        }
        if (i < 75) {
            return new int[]{ContextCompat.getColor(context, R.color.level_color_high), ContextCompat.getColor(context, R.color.level_color_high)};
        }
        return new int[]{ContextCompat.getColor(context, R.color.level_color_severely_high), ContextCompat.getColor(context, R.color.level_color_severely_high)};
    }

    public static final void setPressureSbv(@OOXIXo Context context, @OOXIXo SegmentedBarView sbv) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(sbv, "sbv");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        List X00IoxXI2 = CollectionsKt__CollectionsKt.X00IoxXI(0, 25, 50, 75, 100);
        String[] stringArray = context.getResources().getStringArray(R.array.level_range_4_2_pressure);
        IIX0o.oO(stringArray, "getStringArray(...)");
        int[] intArray = context.getResources().getIntArray(R.array.level_color_4_2);
        IIX0o.oO(intArray, "getIntArray(...)");
        int length = stringArray.length;
        while (i < length) {
            int intValue = ((Number) X00IoxXI2.get(i)).intValue();
            int i2 = i + 1;
            int intValue2 = ((Number) X00IoxXI2.get(i2)).intValue();
            o0Xo.oIX0oI x0XOIxOo2 = new o0Xo.oIX0oI(intValue, intValue2, stringArray[i], intArray[i]).x0XOIxOo("");
            if (i == 0) {
                x0XOIxOo2.x0XOIxOo(String.valueOf(intValue));
            } else if (i == stringArray.length - 1) {
                x0XOIxOo2.x0XOIxOo(String.valueOf(intValue2));
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(intValue);
                sb.append(XIxXXX0x0.f29558oxoX);
                sb.append(intValue2);
                x0XOIxOo2.x0XOIxOo(sb.toString());
            }
            IIX0o.ooOOo0oXI(x0XOIxOo2);
            arrayList.add(x0XOIxOo2);
            i = i2;
        }
        sbv.setShowDescriptionText(true);
        sbv.setSegments(arrayList);
        sbv.setDescriptionTextColor(oxoX.I0Io(sbv.getContext(), R.color.text_color));
        sbv.setDescriptionTopTextColor(oxoX.I0Io(sbv.getContext(), R.color.text_color));
    }

    public static final void setPressureSbvValue(@OOXIXo SegmentedBarView sbv, float f) {
        IIX0o.x0xO0oo(sbv, "sbv");
        if (f > 100.0f) {
            f = 100.0f;
        }
        sbv.setValue(Float.valueOf(f));
    }
}
