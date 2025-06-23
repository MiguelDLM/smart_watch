package OOxOOxIO;

import android.content.Context;
import android.text.TextUtils;
import androidx.media2.session.SessionCommand;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;

/* loaded from: classes6.dex */
public class Oxx0IOOO {

    /* loaded from: classes6.dex */
    public interface oIX0oI {
        void useOriginLoader();
    }

    public static boolean I0Io(MediationAdSlotValueSet mediationAdSlotValueSet, Bridge bridge) {
        if (mediationAdSlotValueSet != null && mediationAdSlotValueSet.getExtraObject() != null && TextUtils.equals((String) mediationAdSlotValueSet.getExtraObject().get("load_type"), "load_plugin_adapter") && bridge != null) {
            return true;
        }
        return false;
    }

    public static boolean II0xO0(Context context, Bridge bridge, Bridge bridge2) {
        if (context != null && bridge != null && bridge2 != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(SessionCommand.COMMAND_CODE_PLAYER_SET_SHUFFLE_MODE, bridge2);
            create.add(SessionCommand.COMMAND_CODE_PLAYER_SET_REPEAT_MODE, MediationConstant.ADN_GDT);
            create.add(10000, context);
            bridge.call(20000, create.build(), null);
            return true;
        }
        return false;
    }

    public static void oIX0oI(Context context, MediationAdSlotValueSet mediationAdSlotValueSet, Bridge bridge, Bridge bridge2, oIX0oI oix0oi) {
        boolean z;
        boolean I0Io2 = I0Io(mediationAdSlotValueSet, bridge);
        if (I0Io2) {
            z = II0xO0(context, bridge, bridge2);
        } else {
            z = false;
        }
        if ((!I0Io2 || !z) && oix0oi != null) {
            oix0oi.useOriginLoader();
        }
    }
}
