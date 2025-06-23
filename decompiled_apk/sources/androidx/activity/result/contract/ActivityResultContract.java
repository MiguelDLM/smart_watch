package androidx.activity.result.contract;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public abstract class ActivityResultContract<I, O> {

    /* loaded from: classes.dex */
    public static final class SynchronousResult<T> {
        private final T value;

        public SynchronousResult(T t) {
            this.value = t;
        }

        public final T getValue() {
            return this.value;
        }
    }

    @OOXIXo
    public abstract Intent createIntent(@OOXIXo Context context, I i);

    @oOoXoXO
    public SynchronousResult<O> getSynchronousResult(@OOXIXo Context context, I i) {
        IIX0o.x0xO0oo(context, "context");
        return null;
    }

    public abstract O parseResult(int i, @oOoXoXO Intent intent);
}
