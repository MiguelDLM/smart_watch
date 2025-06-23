package com.kwad.components.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;
import com.kwad.sdk.n.l;
import com.kwad.sdk.utils.az;

/* loaded from: classes11.dex */
public class KsAutoCloseView extends LinearLayout implements View.OnClickListener {
    private static String Bf = "%s秒后自动关闭";
    private TextView acR;
    private ImageView acS;
    private a acT;
    private boolean acU;
    private boolean acV;
    private int countDown;

    /* loaded from: classes11.dex */
    public interface a {
        void df();

        void dg();
    }

    public KsAutoCloseView(Context context) {
        super(context);
        this.countDown = 10;
        this.acU = true;
        this.acV = false;
        P(context);
    }

    private void P(Context context) {
        l.inflate(context, R.layout.ksad_auto_close, this);
        this.acR = (TextView) findViewById(R.id.ksad_auto_close_text);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_auto_close_btn);
        this.acS = imageView;
        imageView.setOnClickListener(this);
    }

    public static /* synthetic */ int e(KsAutoCloseView ksAutoCloseView) {
        int i = ksAutoCloseView.countDown;
        ksAutoCloseView.countDown = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i) {
        this.acR.setText(String.format(Bf, Integer.valueOf(i)));
    }

    public final void U(int i) {
        if (i <= 0) {
            return;
        }
        this.countDown = i;
        post(new az() { // from class: com.kwad.components.core.widget.KsAutoCloseView.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                if (!KsAutoCloseView.this.acU) {
                    return;
                }
                if (KsAutoCloseView.this.acV) {
                    KsAutoCloseView.this.postDelayed(this, 1000L);
                    return;
                }
                if (KsAutoCloseView.this.countDown == 0) {
                    if (KsAutoCloseView.this.acT != null) {
                        KsAutoCloseView.this.acT.df();
                    }
                } else {
                    KsAutoCloseView ksAutoCloseView = KsAutoCloseView.this;
                    ksAutoCloseView.x(ksAutoCloseView.countDown);
                    KsAutoCloseView.e(KsAutoCloseView.this);
                    KsAutoCloseView.this.postDelayed(this, 1000L);
                }
            }
        });
    }

    public final void aY(boolean z) {
        int i;
        this.acU = z;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        TextView textView = this.acR;
        if (textView != null) {
            textView.setVisibility(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.acT != null && view.equals(this.acS)) {
            this.acT.dg();
        }
    }

    public void setCountDownPaused(boolean z) {
        this.acV = z;
    }

    public void setViewListener(a aVar) {
        this.acT = aVar;
    }

    public KsAutoCloseView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.countDown = 10;
        this.acU = true;
        this.acV = false;
        P(context);
    }

    public KsAutoCloseView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.countDown = 10;
        this.acU = true;
        this.acV = false;
        P(context);
    }

    @RequiresApi(api = 21)
    public KsAutoCloseView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.countDown = 10;
        this.acU = true;
        this.acV = false;
        P(context);
    }
}
