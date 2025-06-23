package kotlin;

/* loaded from: classes6.dex */
public class XIxXXX0x0 {

    /* loaded from: classes6.dex */
    public /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f29078oIX0oI;

        static {
            int[] iArr = new int[LazyThreadSafetyMode.values().length];
            try {
                iArr[LazyThreadSafetyMode.SYNCHRONIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LazyThreadSafetyMode.PUBLICATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LazyThreadSafetyMode.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f29078oIX0oI = iArr;
        }
    }

    @OXOo.OOXIXo
    public static <T> X0IIOO<T> I0Io(@OXOo.OOXIXo LazyThreadSafetyMode mode, @OXOo.OOXIXo Oox.oIX0oI<? extends T> initializer) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(mode, "mode");
        kotlin.jvm.internal.IIX0o.x0xO0oo(initializer, "initializer");
        int i = oIX0oI.f29078oIX0oI[mode.ordinal()];
        int i2 = 2;
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return new UnsafeLazyImpl(initializer);
                }
                throw new NoWhenBranchMatchedException();
            }
            return new SafePublicationLazyImpl(initializer);
        }
        kotlin.jvm.internal.IIXOooo iIXOooo = null;
        return new SynchronizedLazyImpl(initializer, iIXOooo, i2, iIXOooo);
    }

    @OXOo.OOXIXo
    public static final <T> X0IIOO<T> II0xO0(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo Oox.oIX0oI<? extends T> initializer) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(initializer, "initializer");
        return new SynchronizedLazyImpl(initializer, obj);
    }

    @OXOo.OOXIXo
    public static <T> X0IIOO<T> oIX0oI(@OXOo.OOXIXo Oox.oIX0oI<? extends T> initializer) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(initializer, "initializer");
        kotlin.jvm.internal.IIXOooo iIXOooo = null;
        return new SynchronizedLazyImpl(initializer, iIXOooo, 2, iIXOooo);
    }
}
