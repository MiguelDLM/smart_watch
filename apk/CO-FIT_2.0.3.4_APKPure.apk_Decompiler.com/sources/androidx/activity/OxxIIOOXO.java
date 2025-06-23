package androidx.activity;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlinx.coroutines.channels.IXxxXO;

public final /* synthetic */ class OxxIIOOXO implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ View f259Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ IXxxXO f260XO;

    public /* synthetic */ OxxIIOOXO(IXxxXO iXxxXO, View view) {
        this.f260XO = iXxxXO;
        this.f259Oo = view;
    }

    public final void onScrollChanged() {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1.invokeSuspend$lambda$1(this.f260XO, this.f259Oo);
    }
}
