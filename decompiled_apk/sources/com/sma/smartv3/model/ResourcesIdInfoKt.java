package com.sma.smartv3.model;

import OXOo.OOXIXo;
import android.content.Context;
import com.sma.smartv3.co_fit.R;
import com.szabh.smable3.entity.BleDeviceInfo;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class ResourcesIdInfoKt {
    @OOXIXo
    public static final List<ResourcesIdInfo> getWatchFaceElementColors(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        return CollectionsKt__CollectionsKt.Oxx0xo(new ResourcesIdInfo(R.drawable.shape_circle_0, context.getResources().getColor(R.color.dial_customize_control_0), true), new ResourcesIdInfo(R.drawable.shape_circle_1, context.getResources().getColor(R.color.dial_customize_control_1), false, 4, null), new ResourcesIdInfo(R.drawable.shape_circle_2, context.getResources().getColor(R.color.dial_customize_control_2), false, 4, null), new ResourcesIdInfo(R.drawable.shape_circle_3, context.getResources().getColor(R.color.dial_customize_control_3), false, 4, null), new ResourcesIdInfo(R.drawable.shape_circle_4, context.getResources().getColor(R.color.dial_customize_control_4), false, 4, null), new ResourcesIdInfo(R.drawable.shape_circle_5, context.getResources().getColor(R.color.dial_customize_control_5), false, 4, null), new ResourcesIdInfo(R.drawable.shape_circle_6, context.getResources().getColor(R.color.dial_customize_control_6), false, 4, null));
    }

    @OOXIXo
    public static final List<ResourcesIdInfo> getWatchFaceElementDigitalTimes() {
        return CollectionsKt__CollectionsKt.Oxx0xo(new ResourcesIdInfo(R.drawable.digital_time_0, 0, false, 6, null), new ResourcesIdInfo(R.drawable.digital_time_1, 0, false, 6, null), new ResourcesIdInfo(R.drawable.digital_time_2, 0, false, 6, null), new ResourcesIdInfo(R.drawable.digital_time_3, 0, false, 6, null), new ResourcesIdInfo(R.drawable.digital_time_4, 0, false, 6, null), new ResourcesIdInfo(R.drawable.digital_time_5, 0, false, 6, null), new ResourcesIdInfo(R.drawable.digital_time_6, 0, false, 6, null));
    }

    @OOXIXo
    public static final List<ResourcesIdInfo> getWatchFaceElementPointers(@OOXIXo BleDeviceInfo deviceInfo) {
        IIX0o.x0xO0oo(deviceInfo, "deviceInfo");
        if (IIX0o.Oxx0IOOO(deviceInfo.getMPlatform(), "B9")) {
            return CollectionsKt__CollectionsKt.Oxx0xo(new ResourcesIdInfo(R.drawable.dial_customize_point_1_0, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_point_1_1, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_point_1_2, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_point_1_3, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_point_1_4, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_point_1_5, 0, false, 6, null));
        }
        return CollectionsKt__CollectionsKt.Oxx0xo(new ResourcesIdInfo(R.drawable.dial_customize_point_2_0, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_point_2_1, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_point_2_2, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_point_2_3, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_point_2_4, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_point_2_5, 0, false, 6, null));
    }

    @OOXIXo
    public static final List<ResourcesIdInfo> getWatchFaceElementScales(@OOXIXo BleDeviceInfo deviceInfo, boolean z) {
        IIX0o.x0xO0oo(deviceInfo, "deviceInfo");
        if (z) {
            return CollectionsKt__CollectionsKt.Oxx0xo(new ResourcesIdInfo(R.drawable.dial_customize_scale_2_0, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_scale_2_1, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_scale_2_2, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_scale_2_3, 0, false, 6, null));
        }
        if (IIX0o.Oxx0IOOO(deviceInfo.getMPlatform(), "B9")) {
            return CollectionsKt__CollectionsKt.Oxx0xo(new ResourcesIdInfo(R.drawable.dial_customize_scale_172_0, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_scale_172_1, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_scale_172_2, 0, false, 6, null));
        }
        return CollectionsKt__CollectionsKt.Oxx0xo(new ResourcesIdInfo(R.drawable.dial_customize_scale_10_0, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_scale_10_1, 0, false, 6, null), new ResourcesIdInfo(R.drawable.dial_customize_scale_10_2, 0, false, 6, null));
    }
}
