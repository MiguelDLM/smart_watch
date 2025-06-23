package androidx.activity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.RequiresApi;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.flow.Oxx0IOOO;

public final class PipHintTrackerKt {
    @RequiresApi(26)
    @oOoXoXO
    public static final Object trackPipAnimationHintView(@OOXIXo Activity activity, @OOXIXo View view, @OOXIXo I0Io<? super oXIO0o0XI> i0Io) {
        Object collect = Oxx0IOOO.Oxx0xo(new PipHintTrackerKt$trackPipAnimationHintView$flow$1(view, (I0Io<? super PipHintTrackerKt$trackPipAnimationHintView$flow$1>) null)).collect(new PipHintTrackerKt$trackPipAnimationHintView$2(activity), i0Io);
        if (collect == II0xO0.oOoXoXO()) {
            return collect;
        }
        return oXIO0o0XI.f19155oIX0oI;
    }

    /* access modifiers changed from: private */
    public static final Rect trackPipAnimationHintView$positionInWindow(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect;
    }
}
