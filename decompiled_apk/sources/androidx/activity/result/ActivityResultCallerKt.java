package androidx.activity.result;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import androidx.activity.result.contract.ActivityResultContract;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes.dex */
public final class ActivityResultCallerKt {
    @OOXIXo
    public static final <I, O> ActivityResultLauncher<oXIO0o0XI> registerForActivityResult(@OOXIXo ActivityResultCaller activityResultCaller, @OOXIXo ActivityResultContract<I, O> contract, I i, @OOXIXo ActivityResultRegistry registry, @OOXIXo final oOoXoXO<O, oXIO0o0XI> callback) {
        IIX0o.x0xO0oo(activityResultCaller, "<this>");
        IIX0o.x0xO0oo(contract, "contract");
        IIX0o.x0xO0oo(registry, "registry");
        IIX0o.x0xO0oo(callback, "callback");
        return new ActivityResultCallerLauncher(activityResultCaller.registerForActivityResult(contract, registry, new ActivityResultCallback() { // from class: androidx.activity.result.oIX0oI
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                oOoXoXO.this.invoke(obj);
            }
        }), contract, i);
    }

    @OOXIXo
    public static final <I, O> ActivityResultLauncher<oXIO0o0XI> registerForActivityResult(@OOXIXo ActivityResultCaller activityResultCaller, @OOXIXo ActivityResultContract<I, O> contract, I i, @OOXIXo final oOoXoXO<O, oXIO0o0XI> callback) {
        IIX0o.x0xO0oo(activityResultCaller, "<this>");
        IIX0o.x0xO0oo(contract, "contract");
        IIX0o.x0xO0oo(callback, "callback");
        return new ActivityResultCallerLauncher(activityResultCaller.registerForActivityResult(contract, new ActivityResultCallback() { // from class: androidx.activity.result.II0xO0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                oOoXoXO.this.invoke(obj);
            }
        }), contract, i);
    }
}
