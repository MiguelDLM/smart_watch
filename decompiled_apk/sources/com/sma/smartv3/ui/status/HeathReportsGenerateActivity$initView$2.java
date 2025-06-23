package com.sma.smartv3.ui.status;

import android.os.Handler;
import com.sma.smartv3.util.HeathReportsUtils;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class HeathReportsGenerateActivity$initView$2 extends Lambda implements Oox.oIX0oI<oXIO0o0XI> {
    final /* synthetic */ HeathReportsGenerateActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeathReportsGenerateActivity$initView$2(HeathReportsGenerateActivity heathReportsGenerateActivity) {
        super(0);
        this.this$0 = heathReportsGenerateActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(HeathReportsGenerateActivity this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.initRecyclerView();
    }

    @Override // Oox.oIX0oI
    public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
        invoke2();
        return oXIO0o0XI.f29392oIX0oI;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Handler handler;
        this.this$0.showCard(HeathReportsUtils.f24217oIX0oI.xoXoI());
        handler = this.this$0.mHandler;
        final HeathReportsGenerateActivity heathReportsGenerateActivity = this.this$0;
        handler.post(new Runnable() { // from class: com.sma.smartv3.ui.status.X0o0xo
            @Override // java.lang.Runnable
            public final void run() {
                HeathReportsGenerateActivity$initView$2.invoke$lambda$0(HeathReportsGenerateActivity.this);
            }
        });
    }
}
