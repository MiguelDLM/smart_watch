package com.sma.smartv3.util;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.sma.smartv3.util.HeathReportsUtils$itemLayoutClickListener$1$2;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class HeathReportsUtils$itemLayoutClickListener$1$2 extends Lambda implements Oox.oOoXoXO<Boolean, oXIO0o0XI> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ View $btn;
    final /* synthetic */ String $itemType;
    final /* synthetic */ String $mAiQuestion;
    final /* synthetic */ long $queryTime;
    final /* synthetic */ TextView $tv;

    /* renamed from: com.sma.smartv3.util.HeathReportsUtils$itemLayoutClickListener$1$2$2, reason: invalid class name */
    /* loaded from: classes12.dex */
    public static final class AnonymousClass2 extends Lambda implements Oox.oOoXoXO<String, oXIO0o0XI> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ String $itemType;
        final /* synthetic */ long $queryTime;
        final /* synthetic */ TextView $tv;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Activity activity, TextView textView, String str, long j) {
            super(1);
            this.$activity = activity;
            this.$tv = textView;
            this.$itemType = str;
            this.$queryTime = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(TextView tv, String itemType, long j, String answer) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(tv, "$tv");
            kotlin.jvm.internal.IIX0o.x0xO0oo(itemType, "$itemType");
            kotlin.jvm.internal.IIX0o.x0xO0oo(answer, "$answer");
            tv.setVisibility(0);
            HeathReportsUtils.f24217oIX0oI.XX(itemType, j, answer);
            tv.setText(answer);
        }

        @Override // Oox.oOoXoXO
        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(String str) {
            invoke2(str);
            return oXIO0o0XI.f29392oIX0oI;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@OXOo.OOXIXo final String answer) {
            String str;
            kotlin.jvm.internal.IIX0o.x0xO0oo(answer, "answer");
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            StringBuilder sb = new StringBuilder();
            str = HeathReportsUtils.f24219oOoXoXO;
            sb.append(str);
            sb.append(" startAIAnalyze");
            oix0oi.oIX0oI(sb.toString());
            Activity activity = this.$activity;
            final TextView textView = this.$tv;
            final String str2 = this.$itemType;
            final long j = this.$queryTime;
            activity.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.util.xXxxox0I
                @Override // java.lang.Runnable
                public final void run() {
                    HeathReportsUtils$itemLayoutClickListener$1$2.AnonymousClass2.invoke$lambda$0(textView, str2, j, answer);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeathReportsUtils$itemLayoutClickListener$1$2(Activity activity, String str, View view, TextView textView, String str2, long j) {
        super(1);
        this.$activity = activity;
        this.$mAiQuestion = str;
        this.$btn = view;
        this.$tv = textView;
        this.$itemType = str2;
        this.$queryTime = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(TextView tv) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tv, "$tv");
        tv.setText("");
    }

    @Override // Oox.oOoXoXO
    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return oXIO0o0XI.f29392oIX0oI;
    }

    public final void invoke(boolean z) {
        String str;
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        StringBuilder sb = new StringBuilder();
        str = HeathReportsUtils.f24219oOoXoXO;
        sb.append(str);
        sb.append(" startHeathAnalyze b = ");
        sb.append(z);
        oix0oi.oIX0oI(sb.toString());
        if (z) {
            Xo0.f24349oIX0oI.oIX0oI().put(XoI0Ixx0.f24430XoIxOXIXo, true);
            Activity activity = this.$activity;
            final TextView textView = this.$tv;
            activity.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.util.XxX0x0xxx
                @Override // java.lang.Runnable
                public final void run() {
                    HeathReportsUtils$itemLayoutClickListener$1$2.invoke$lambda$0(textView);
                }
            });
            HeathReportsUtils.xo0x(HeathReportsUtils.f24217oIX0oI, this.$mAiQuestion, 0, new AnonymousClass2(this.$activity, this.$tv, this.$itemType, this.$queryTime), 2, null);
            return;
        }
        this.$btn.setEnabled(true);
    }
}
