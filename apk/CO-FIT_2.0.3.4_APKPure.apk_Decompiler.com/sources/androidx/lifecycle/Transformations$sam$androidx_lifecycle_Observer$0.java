package androidx.lifecycle;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import kotlin.IIXOooo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XI0IXoo;

public final class Transformations$sam$androidx_lifecycle_Observer$0 implements Observer, XI0IXoo {
    private final /* synthetic */ oOoXoXO function;

    public Transformations$sam$androidx_lifecycle_Observer$0(oOoXoXO oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "function");
        this.function = oooxoxo;
    }

    public final boolean equals(@OXOo.oOoXoXO Object obj) {
        if (!(obj instanceof Observer) || !(obj instanceof XI0IXoo)) {
            return false;
        }
        return IIX0o.Oxx0IOOO(getFunctionDelegate(), ((XI0IXoo) obj).getFunctionDelegate());
    }

    @OOXIXo
    public final IIXOooo<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    public final /* synthetic */ void onChanged(Object obj) {
        this.function.invoke(obj);
    }
}
