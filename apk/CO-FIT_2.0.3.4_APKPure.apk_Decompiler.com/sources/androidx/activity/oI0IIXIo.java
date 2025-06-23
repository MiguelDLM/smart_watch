package androidx.activity;

import android.view.View;
import kotlinx.coroutines.channels.IXxxXO;

public final /* synthetic */ class oI0IIXIo implements View.OnLayoutChangeListener {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ IXxxXO f264XO;

    public /* synthetic */ oI0IIXIo(IXxxXO iXxxXO) {
        this.f264XO = iXxxXO;
    }

    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1.invokeSuspend$lambda$0(this.f264XO, view, i, i2, i3, i4, i5, i6, i7, i8);
    }
}
