package kotlin.jvm.internal;

import java.io.Serializable;

/* loaded from: classes6.dex */
public abstract class Lambda<R> implements XIxXXX0x0<R>, Serializable {
    private final int arity;

    public Lambda(int i) {
        this.arity = i;
    }

    @Override // kotlin.jvm.internal.XIxXXX0x0
    public int getArity() {
        return this.arity;
    }

    @OXOo.OOXIXo
    public String toString() {
        String o002 = IO.o00(this);
        IIX0o.oO(o002, "renderLambdaToString(...)");
        return o002;
    }
}
