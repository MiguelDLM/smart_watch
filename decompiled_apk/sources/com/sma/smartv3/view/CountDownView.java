package com.sma.smartv3.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.oxxXoxO;
import skin.support.widget.SkinCompatTextView;

/* loaded from: classes12.dex */
public final class CountDownView extends SkinCompatTextView {

    @OXOo.oOoXoXO
    private CountDownTimer countDownTimer;
    private long interval;
    private long totalTime;

    /* loaded from: classes12.dex */
    public static final class oIX0oI extends CountDownTimer {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ CountDownView f24876oIX0oI;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public oIX0oI(long j, long j2, CountDownView countDownView) {
            super(j, j2);
            this.f24876oIX0oI = countDownView;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.f24876oIX0oI.setText("00:00:00");
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            long hours = timeUnit.toHours(j);
            long j2 = 60;
            long minutes = timeUnit.toMinutes(j) % j2;
            long seconds = timeUnit.toSeconds(j) % j2;
            CountDownView countDownView = this.f24876oIX0oI;
            oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
            String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(hours), Long.valueOf(minutes), Long.valueOf(seconds)}, 3));
            IIX0o.oO(format, "format(...)");
            countDownView.setText(format);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public CountDownView(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public static /* synthetic */ void startCountDown$default(CountDownView countDownView, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = 1000;
        }
        countDownView.startCountDown(j, j2);
    }

    public final void cancelCountDown() {
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.countDownTimer = null;
    }

    public final void startCountDown(long j, long j2) {
        cancelCountDown();
        this.totalTime = j;
        this.interval = j2;
        this.countDownTimer = new oIX0oI(j, j2, this).start();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public CountDownView(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ CountDownView(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public CountDownView(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.interval = 1000L;
    }
}
