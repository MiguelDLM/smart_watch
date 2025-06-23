package androidx.activity.result;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.MainThread;
import androidx.core.app.ActivityOptionsCompat;

public abstract class ActivityResultLauncher<I> {
    @OOXIXo
    public abstract ActivityResultContract<I, ?> getContract();

    public void launch(I i) {
        launch(i, (ActivityOptionsCompat) null);
    }

    public abstract void launch(I i, @oOoXoXO ActivityOptionsCompat activityOptionsCompat);

    @MainThread
    public abstract void unregister();
}
