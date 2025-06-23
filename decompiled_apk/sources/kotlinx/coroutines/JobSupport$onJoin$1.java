package kotlinx.coroutines;

import kotlin.jvm.internal.FunctionReferenceImpl;

/* loaded from: classes6.dex */
public /* synthetic */ class JobSupport$onJoin$1 extends FunctionReferenceImpl implements Oox.IXxxXO<JobSupport, kotlinx.coroutines.selects.xoIox<?>, Object, kotlin.oXIO0o0XI> {
    public static final JobSupport$onJoin$1 INSTANCE = new JobSupport$onJoin$1();

    public JobSupport$onJoin$1() {
        super(3, JobSupport.class, "registerSelectForOnJoin", "registerSelectForOnJoin(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // Oox.IXxxXO
    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(JobSupport jobSupport, kotlinx.coroutines.selects.xoIox<?> xoiox, Object obj) {
        invoke2(jobSupport, xoiox, obj);
        return kotlin.oXIO0o0XI.f29392oIX0oI;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@OXOo.OOXIXo JobSupport jobSupport, @OXOo.OOXIXo kotlinx.coroutines.selects.xoIox<?> xoiox, @OXOo.oOoXoXO Object obj) {
        jobSupport.x0(xoiox, obj);
    }
}
