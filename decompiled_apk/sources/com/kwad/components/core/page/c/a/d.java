package com.kwad.components.core.page.c.a;

import android.view.View;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bo;

/* loaded from: classes11.dex */
public final class d extends a {
    private View PB;
    private TextView PC;
    private int PD;
    private Runnable PE = new Runnable() { // from class: com.kwad.components.core.page.c.a.d.1
        @Override // java.lang.Runnable
        public final void run() {
            if (com.kwad.components.core.q.a.rj().rm()) {
                bo.runOnUiThreadDelay(this, 500L);
                return;
            }
            if (d.this.PD > 0) {
                d.this.PC.setText(String.format("倒计时%d秒", Integer.valueOf(d.this.PD)));
                d.c(d.this);
                com.kwad.components.core.q.a.rj().aJ(d.this.PD);
                bo.runOnUiThreadDelay(this, 1000L);
                return;
            }
            d.this.PC.setText("已获得权益");
            bo.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.page.c.a.d.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.PB.setVisibility(8);
                }
            }, 500L);
            com.kwad.components.core.q.a.rj().aK(true);
        }
    };

    public static /* synthetic */ int c(d dVar) {
        int i = dVar.PD;
        dVar.PD = i - 1;
        return i;
    }

    private void pY() {
        TextView textView;
        if (this.PB != null && (textView = this.PC) != null) {
            textView.setText(String.format("倒计时%d秒", Integer.valueOf(this.PD)));
            this.PB.setVisibility(0);
            bo.runOnUiThreadDelay(this.PE, 1000L);
        }
    }

    @Override // com.kwad.components.core.page.c.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.PD = com.kwad.sdk.core.response.b.a.aL(com.kwad.sdk.core.response.b.e.dS(this.Pk.mAdTemplate));
        com.kwad.components.core.q.a.rj().aJ(this.PD);
        pY();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.PB = findViewById(R.id.ksad_web_reward_task_layout);
        this.PC = (TextView) findViewById(R.id.ksad_web_reward_task_text);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        bo.c(this.PE);
    }
}
