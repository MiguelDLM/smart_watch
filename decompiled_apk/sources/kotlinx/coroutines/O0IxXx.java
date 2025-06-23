package kotlinx.coroutines;

/* loaded from: classes6.dex */
public final class O0IxXx {

    @kotlin.jvm.internal.XX({"SMAP\nRunnable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Runnable.kt\nkotlinx/coroutines/RunnableKt$Runnable$1\n*L\n1#1,18:1\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Oox.oIX0oI<kotlin.oXIO0o0XI> f29731XO;

        public oIX0oI(Oox.oIX0oI<kotlin.oXIO0o0XI> oix0oi) {
            this.f29731XO = oix0oi;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f29731XO.invoke();
        }
    }

    @OXOo.OOXIXo
    public static final Runnable oIX0oI(@OXOo.OOXIXo Oox.oIX0oI<kotlin.oXIO0o0XI> oix0oi) {
        return new oIX0oI(oix0oi);
    }
}
