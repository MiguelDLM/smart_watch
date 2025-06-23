package kotlinx.coroutines.internal;

/* loaded from: classes6.dex */
public final class o00 {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f30292I0Io = 2;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f30293II0xO0 = 1;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f30294oIX0oI = 0;

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final Object f30295oxoX = new x0o("CONDITION_FALSE");

    @kotlin.o0
    public static /* synthetic */ void I0Io() {
    }

    @kotlin.o0
    public static /* synthetic */ void II0xO0() {
    }

    @kotlin.o0
    public static /* synthetic */ void X0o0xo() {
    }

    @OXOo.OOXIXo
    @kotlin.o0
    public static final LockFreeLinkedListNode XO(@OXOo.OOXIXo Object obj) {
        IoOoX ioOoX;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        if (obj instanceof IoOoX) {
            ioOoX = (IoOoX) obj;
        } else {
            ioOoX = null;
        }
        if (ioOoX == null || (lockFreeLinkedListNode = ioOoX.f30229oIX0oI) == null) {
            kotlin.jvm.internal.IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            return (LockFreeLinkedListNode) obj;
        }
        return lockFreeLinkedListNode;
    }

    @OXOo.OOXIXo
    public static final Object oIX0oI() {
        return f30295oxoX;
    }

    @kotlin.o0
    public static /* synthetic */ void oxoX() {
    }
}
