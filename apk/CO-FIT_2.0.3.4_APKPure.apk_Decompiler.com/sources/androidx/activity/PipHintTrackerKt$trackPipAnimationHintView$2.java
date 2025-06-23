package androidx.activity;

import android.app.Activity;
import android.graphics.Rect;
import kotlin.coroutines.I0Io;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.flow.XO;

public final class PipHintTrackerKt$trackPipAnimationHintView$2<T> implements XO {
    final /* synthetic */ Activity $this_trackPipAnimationHintView;

    public PipHintTrackerKt$trackPipAnimationHintView$2(Activity activity) {
        this.$this_trackPipAnimationHintView = activity;
    }

    public final Object emit(Rect rect, I0Io<? super oXIO0o0XI> i0Io) {
        Api26Impl.INSTANCE.setPipParamsSourceRectHint(this.$this_trackPipAnimationHintView, rect);
        return oXIO0o0XI.f19155oIX0oI;
    }
}
