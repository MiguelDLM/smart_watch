package androidx.lifecycle;

import kotlin.IIXOooo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XI0IXoo;

/* loaded from: classes.dex */
public final class Transformations$sam$androidx_lifecycle_Observer$0 implements Observer, XI0IXoo {
    private final /* synthetic */ Oox.oOoXoXO function;

    public Transformations$sam$androidx_lifecycle_Observer$0(Oox.oOoXoXO function) {
        IIX0o.x0xO0oo(function, "function");
        this.function = function;
    }

    public final boolean equals(@OXOo.oOoXoXO Object obj) {
        if ((obj instanceof Observer) && (obj instanceof XI0IXoo)) {
            return IIX0o.Oxx0IOOO(getFunctionDelegate(), ((XI0IXoo) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.XI0IXoo
    @OXOo.OOXIXo
    public final IIXOooo<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // androidx.lifecycle.Observer
    public final /* synthetic */ void onChanged(Object obj) {
        this.function.invoke(obj);
    }
}
