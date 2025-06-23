package androidx.work;

import androidx.annotation.NonNull;
import androidx.work.OneTimeWorkRequest;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class OneTimeWorkRequestKt {
    public static final /* synthetic */ <W extends ListenableWorker> OneTimeWorkRequest.Builder OneTimeWorkRequestBuilder() {
        IIX0o.OxI(4, "W");
        return new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) ListenableWorker.class);
    }

    @OXOo.OOXIXo
    public static final OneTimeWorkRequest.Builder setInputMerger(@OXOo.OOXIXo OneTimeWorkRequest.Builder builder, @NonNull @OXOo.OOXIXo kotlin.reflect.oxoX<? extends InputMerger> inputMerger) {
        IIX0o.x0xO0oo(builder, "<this>");
        IIX0o.x0xO0oo(inputMerger, "inputMerger");
        return builder.setInputMerger(XO0OX.II0xO0.X0o0xo(inputMerger));
    }
}
