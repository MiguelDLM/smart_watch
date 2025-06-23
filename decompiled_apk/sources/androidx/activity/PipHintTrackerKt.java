package androidx.activity;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.RequiresApi;
import kotlin.oXIO0o0XI;

/* loaded from: classes.dex */
public final class PipHintTrackerKt {
    @RequiresApi(26)
    @OXOo.oOoXoXO
    public static final Object trackPipAnimationHintView(@OXOo.OOXIXo final Activity activity, @OXOo.OOXIXo View view, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        Object collect = kotlinx.coroutines.flow.Oxx0IOOO.Oxx0xo(new PipHintTrackerKt$trackPipAnimationHintView$flow$1(view, null)).collect(new kotlinx.coroutines.flow.XO() { // from class: androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$2
            public final Object emit(Rect rect, kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io2) {
                Api26Impl.INSTANCE.setPipParamsSourceRectHint(activity, rect);
                return oXIO0o0XI.f29392oIX0oI;
            }

            @Override // kotlinx.coroutines.flow.XO
            public /* bridge */ /* synthetic */ Object emit(Object obj, kotlin.coroutines.I0Io i0Io2) {
                return emit((Rect) obj, (kotlin.coroutines.I0Io<? super oXIO0o0XI>) i0Io2);
            }
        }, i0Io);
        if (collect == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return collect;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect trackPipAnimationHintView$positionInWindow(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect;
    }
}
