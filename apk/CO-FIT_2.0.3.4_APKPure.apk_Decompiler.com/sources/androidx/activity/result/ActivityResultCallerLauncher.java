package androidx.activity.result;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

public final class ActivityResultCallerLauncher<I, O> extends ActivityResultLauncher<oXIO0o0XI> {
    @OOXIXo
    private final ActivityResultContract<I, O> callerContract;
    private final I callerInput;
    @OOXIXo
    private final ActivityResultContract<oXIO0o0XI, O> contract = getResultContract();
    @OOXIXo
    private final ActivityResultLauncher<I> launcher;
    @OOXIXo
    private final X0IIOO resultContract$delegate = XIxXXX0x0.oIX0oI(new ActivityResultCallerLauncher$resultContract$2(this));

    public ActivityResultCallerLauncher(@OOXIXo ActivityResultLauncher<I> activityResultLauncher, @OOXIXo ActivityResultContract<I, O> activityResultContract, I i) {
        IIX0o.x0xO0oo(activityResultLauncher, "launcher");
        IIX0o.x0xO0oo(activityResultContract, "callerContract");
        this.launcher = activityResultLauncher;
        this.callerContract = activityResultContract;
        this.callerInput = i;
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

    @OOXIXo
    public ActivityResultContract<oXIO0o0XI, O> getContract() {
        return this.contract;
    }

    public void unregister() {
        this.launcher.unregister();
    }

    public void launch(@OOXIXo oXIO0o0XI oxio0o0xi, @oOoXoXO ActivityOptionsCompat activityOptionsCompat) {
        IIX0o.x0xO0oo(oxio0o0xi, "input");
        this.launcher.launch(this.callerInput, activityOptionsCompat);
    }
}
