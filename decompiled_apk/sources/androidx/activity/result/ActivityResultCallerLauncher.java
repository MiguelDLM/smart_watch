package androidx.activity.result;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultCallerLauncher$resultContract$2;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes.dex */
public final class ActivityResultCallerLauncher<I, O> extends ActivityResultLauncher<oXIO0o0XI> {

    @OOXIXo
    private final ActivityResultContract<I, O> callerContract;
    private final I callerInput;

    @OOXIXo
    private final ActivityResultContract<oXIO0o0XI, O> contract;

    @OOXIXo
    private final ActivityResultLauncher<I> launcher;

    @OOXIXo
    private final X0IIOO resultContract$delegate;

    public ActivityResultCallerLauncher(@OOXIXo ActivityResultLauncher<I> launcher, @OOXIXo ActivityResultContract<I, O> callerContract, I i) {
        IIX0o.x0xO0oo(launcher, "launcher");
        IIX0o.x0xO0oo(callerContract, "callerContract");
        this.launcher = launcher;
        this.callerContract = callerContract;
        this.callerInput = i;
        this.resultContract$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ActivityResultCallerLauncher$resultContract$2.AnonymousClass1>(this) { // from class: androidx.activity.result.ActivityResultCallerLauncher$resultContract$2
            final /* synthetic */ ActivityResultCallerLauncher<I, O> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [androidx.activity.result.ActivityResultCallerLauncher$resultContract$2$1] */
            @Override // Oox.oIX0oI
            public final AnonymousClass1 invoke() {
                final ActivityResultCallerLauncher<I, O> activityResultCallerLauncher = this.this$0;
                return new ActivityResultContract<oXIO0o0XI, O>() { // from class: androidx.activity.result.ActivityResultCallerLauncher$resultContract$2.1
                    @Override // androidx.activity.result.contract.ActivityResultContract
                    public O parseResult(int i2, Intent intent) {
                        return (O) activityResultCallerLauncher.getCallerContract().parseResult(i2, intent);
                    }

                    @Override // androidx.activity.result.contract.ActivityResultContract
                    public Intent createIntent(Context context, oXIO0o0XI input) {
                        IIX0o.x0xO0oo(context, "context");
                        IIX0o.x0xO0oo(input, "input");
                        return activityResultCallerLauncher.getCallerContract().createIntent(context, activityResultCallerLauncher.getCallerInput());
                    }
                };
            }
        });
        this.contract = getResultContract();
    }

    private final ActivityResultContract<oXIO0o0XI, O> getResultContract() {
        return (ActivityResultContract) this.resultContract$delegate.getValue();
    }

    @OOXIXo
    public final ActivityResultContract<I, O> getCallerContract() {
        return this.callerContract;
    }

    public final I getCallerInput() {
        return this.callerInput;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    @OOXIXo
    public ActivityResultContract<oXIO0o0XI, ?> getContract() {
        return this.contract;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void unregister() {
        this.launcher.unregister();
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void launch(@OOXIXo oXIO0o0XI input, @oOoXoXO ActivityOptionsCompat activityOptionsCompat) {
        IIX0o.x0xO0oo(input, "input");
        this.launcher.launch(this.callerInput, activityOptionsCompat);
    }
}
