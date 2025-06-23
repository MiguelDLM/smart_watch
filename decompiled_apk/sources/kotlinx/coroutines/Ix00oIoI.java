package kotlinx.coroutines;

@kotlin.jvm.internal.XX({"SMAP\nExecutors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Executors.kt\nkotlinx/coroutines/ResumeUndispatchedRunnable\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,207:1\n1#2:208\n*E\n"})
/* loaded from: classes6.dex */
public final class Ix00oIoI implements Runnable {

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final oO<kotlin.oXIO0o0XI> f29712Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final CoroutineDispatcher f29713XO;

    /* JADX WARN: Multi-variable type inference failed */
    public Ix00oIoI(@OXOo.OOXIXo CoroutineDispatcher coroutineDispatcher, @OXOo.OOXIXo oO<? super kotlin.oXIO0o0XI> oOVar) {
        this.f29713XO = coroutineDispatcher;
        this.f29712Oo = oOVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f29712Oo.X00IoxXI(this.f29713XO, kotlin.oXIO0o0XI.f29392oIX0oI);
    }
}
