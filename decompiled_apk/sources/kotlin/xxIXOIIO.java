package kotlin;

@IIX0(markerClass = {IXxxXO.class})
@kotlin.coroutines.Oxx0IOOO
@oxxXoxO(version = "1.7")
/* loaded from: classes6.dex */
public abstract class xxIXOIIO<T, R> {
    public /* synthetic */ xxIXOIIO(kotlin.jvm.internal.IIXOooo iIXOooo) {
        this();
    }

    @OXOo.oOoXoXO
    public abstract <U, S> Object I0Io(@OXOo.OOXIXo Oxx0IOOO<U, S> oxx0IOOO, U u, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super S> i0Io);

    @OXOo.oOoXoXO
    public abstract Object II0xO0(T t, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super R> i0Io);

    @OOXIXo(level = DeprecationLevel.ERROR, message = "'invoke' should not be called from DeepRecursiveScope. Use 'callRecursive' to do recursion in the heap instead of the call stack.", replaceWith = @XX(expression = "this.callRecursive(value)", imports = {}))
    @OXOo.OOXIXo
    public final Void oxoX(@OXOo.OOXIXo Oxx0IOOO<?, ?> oxx0IOOO, @OXOo.oOoXoXO Object obj) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        throw new UnsupportedOperationException("Should not be called from DeepRecursiveScope");
    }

    public xxIXOIIO() {
    }
}
