package androidx.activity.result;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import androidx.activity.result.contract.ActivityResultContract;
import com.huawei.openalliance.ad.constant.bn;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

public final class ActivityResultCallerKt {
    @OOXIXo
    public static final <I, O> ActivityResultLauncher<oXIO0o0XI> registerForActivityResult(@OOXIXo ActivityResultCaller activityResultCaller, @OOXIXo ActivityResultContract<I, O> activityResultContract, I i, @OOXIXo ActivityResultRegistry activityResultRegistry, @OOXIXo oOoXoXO<O, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(activityResultCaller, "<this>");
        IIX0o.x0xO0oo(activityResultContract, "contract");
        IIX0o.x0xO0oo(activityResultRegistry, "registry");
        IIX0o.x0xO0oo(oooxoxo, bn.f.L);
        return new ActivityResultCallerLauncher(activityResultCaller.registerForActivityResult(activityResultContract, activityResultRegistry, new oIX0oI(oooxoxo)), activityResultContract, i);
    }

    /* access modifiers changed from: private */
    public static final void registerForActivityResult$lambda$0(oOoXoXO oooxoxo, Object obj) {
        oooxoxo.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void registerForActivityResult$lambda$1(oOoXoXO oooxoxo, Object obj) {
        oooxoxo.invoke(obj);
    }

    @OOXIXo
    public static final <I, O> ActivityResultLauncher<oXIO0o0XI> registerForActivityResult(@OOXIXo ActivityResultCaller activityResultCaller, @OOXIXo ActivityResultContract<I, O> activityResultContract, I i, @OOXIXo oOoXoXO<O, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(activityResultCaller, "<this>");
        IIX0o.x0xO0oo(activityResultContract, "contract");
        IIX0o.x0xO0oo(oooxoxo, bn.f.L);
        return new ActivityResultCallerLauncher(activityResultCaller.registerForActivityResult(activityResultContract, new II0xO0(oooxoxo)), activityResultContract, i);
    }
}
