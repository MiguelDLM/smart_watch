package androidx.activity;

import Oox.oIX0oI;
import androidx.activity.ComponentActivity;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;

public final class ComponentActivity$fullyDrawnReporter$2 extends Lambda implements oIX0oI<FullyDrawnReporter> {
    final /* synthetic */ ComponentActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComponentActivity$fullyDrawnReporter$2(ComponentActivity componentActivity) {
        super(0);
        this.this$0 = componentActivity;
    }

    public final FullyDrawnReporter invoke() {
        ComponentActivity.ReportFullyDrawnExecutor access$getReportFullyDrawnExecutor$p = this.this$0.reportFullyDrawnExecutor;
        final ComponentActivity componentActivity = this.this$0;
        return new FullyDrawnReporter(access$getReportFullyDrawnExecutor$p, new oIX0oI<oXIO0o0XI>() {
            public final void invoke() {
                componentActivity.reportFullyDrawn();
            }
        });
    }
}
