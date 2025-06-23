package com.sma.smartv3.ui.me;

import android.webkit.WebView;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.DelayKt;

@IXIxx0.oxoX(c = "com.sma.smartv3.ui.me.WebViewV2Activity$initView$2$onPageFinished$2", f = "WebViewV2Activity.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class WebViewV2Activity$initView$2$onPageFinished$2 extends SuspendLambda implements Oox.x0xO0oo<kotlinx.coroutines.xII, kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI>, Object> {
    final /* synthetic */ WebView $view;
    int label;
    final /* synthetic */ WebViewV2Activity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewV2Activity$initView$2$onPageFinished$2(WebViewV2Activity webViewV2Activity, WebView webView, kotlin.coroutines.I0Io<? super WebViewV2Activity$initView$2$onPageFinished$2> i0Io) {
        super(2, i0Io);
        this.this$0 = webViewV2Activity;
        this.$view = webView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<kotlin.oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        return new WebViewV2Activity$initView$2$onPageFinished$2(this.this$0, this.$view, i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                kotlin.I0oOoX.x0XOIxOo(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            kotlin.I0oOoX.x0XOIxOo(obj);
            this.label = 1;
            if (DelayKt.II0xO0(300L, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        this.this$0.getTitleCenter().setText(this.$view.getTitle());
        return kotlin.oXIO0o0XI.f29392oIX0oI;
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo kotlinx.coroutines.xII xii, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> i0Io) {
        return ((WebViewV2Activity$initView$2$onPageFinished$2) create(xii, i0Io)).invokeSuspend(kotlin.oXIO0o0XI.f29392oIX0oI);
    }
}
